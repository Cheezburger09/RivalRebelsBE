package assets.rivalrebels.common.item.weapon;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsDamageSource;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import assets.rivalrebels.common.entity.EntityRaytrace;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import java.util.HashSet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

public class ItemTesla extends ItemTool {
   boolean message = true;

   public ItemTesla() {
      super(1.0F, ToolMaterial.EMERALD, new HashSet());
      this.field_77777_bU = 1;
      this.func_77637_a(RivalRebels.rralltab);
   }

   public int func_77619_b() {
      return 100;
   }

   public boolean func_77662_d() {
      return true;
   }

   public EnumAction func_77661_b(ItemStack par1ItemStack) {
      return EnumAction.bow;
   }

   public int func_77626_a(ItemStack par1ItemStack) {
      return 20;
   }

   public ItemStack func_77659_a(ItemStack item, World world, EntityPlayer player) {
      int degree = this.getDegree(item);
      float chance = Math.abs(degree - 90) / 90.0F;
      if (!player.field_71075_bZ.field_75098_d && !player.field_71071_by.func_146028_b(RivalRebels.battery) && !RivalRebels.infiniteAmmo) {
         if (!world.field_72995_K) {
            player.func_145747_a(new ChatComponentText("§cOut of batteries"));
         }
      } else {
         if (!player.field_71075_bZ.field_75098_d && !RivalRebels.infiniteAmmo) {
            player.field_71071_by.func_146026_a(RivalRebels.battery);
            if (chance > 0.33333) {
               player.field_71071_by.func_146026_a(RivalRebels.battery);
            }

            if (chance > 0.66666) {
               player.field_71071_by.func_146026_a(RivalRebels.battery);
            }
         }

         player.func_71008_a(item, this.func_77626_a(item));
      }

      if (this.message && world.field_72995_K) {
         player.func_145747_a(
            new ChatComponentText(StatCollector.func_74838_a("RivalRebels.Orders") + " " + StatCollector.func_74838_a("RivalRebels.message.use") + " [R].")
         );
         this.message = false;
      }

      return item;
   }

   public void func_77663_a(ItemStack item, World world, Entity entity, int par4, boolean par5) {
      if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT
         && (RivalRebels.altRkey ? Keyboard.isKeyDown(33) : Keyboard.isKeyDown(19))
         && item == ((EntityPlayer)entity).field_71071_by.func_70448_g()
         && Minecraft.func_71410_x().field_71462_r == null) {
         RivalRebels.proxy.teslaGui(this.getDegree(item));
      }
   }

   public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
      if (player.func_70026_G() && !player.field_71075_bZ.field_75098_d) {
         player.func_70097_a(RivalRebelsDamageSource.electricity, 2.0F);
      }

      World world = player.field_70170_p;
      if (player.field_70170_p.field_73012_v.nextInt(10) == 0) {
         RivalRebelsSoundPlayer.playSound(player, 25, 1);
      }

      int degree = this.getDegree(stack);
      float chance = Math.abs(degree - 90) / 90.0F;
      if (degree - 90 > 0) {
         chance /= 10.0F;
      }

      float dist = 7.0F + (1.0F - degree / 180.0F) * 73.0F;
      float randomness = degree / 720.0F;
      int num = degree / 25 + 1;
      if (!world.field_72995_K) {
         for (int i = 0; i < num; i++) {
            world.func_72838_d(new EntityRaytrace(world, player, dist, randomness, chance, !stack.func_77948_v()));
         }
      }
   }

   public int getDegree(ItemStack item) {
      return item.field_77990_d == null ? 0 : item.field_77990_d.func_74762_e("dial") + 90;
   }

   public void func_94581_a(IIconRegister iconregister) {
      this.field_77791_bV = iconregister.func_94245_a("RivalRebels:ax");
   }
}
