package assets.rivalrebels.common.item.weapon;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import assets.rivalrebels.common.entity.EntityFlameBall;
import assets.rivalrebels.common.entity.EntityFlameBall1;
import assets.rivalrebels.common.entity.EntityFlameBall2;
import assets.rivalrebels.common.entity.EntityFlameBallGreen;
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
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

public class ItemFlameThrower extends ItemTool {
   boolean message = true;

   public ItemFlameThrower() {
      super(1.0F, ToolMaterial.EMERALD, new HashSet());
      this.field_77777_bU = 1;
      this.func_77637_a(RivalRebels.rralltab);
   }

   public boolean func_77662_d() {
      return true;
   }

   public EnumAction func_77661_b(ItemStack par1ItemStack) {
      return EnumAction.bow;
   }

   public int func_77626_a(ItemStack par1ItemStack) {
      return 64;
   }

   public ItemStack func_77659_a(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
      if (par3EntityPlayer.field_71075_bZ.field_75098_d || par3EntityPlayer.field_71071_by.func_146028_b(RivalRebels.fuel) || RivalRebels.infiniteAmmo) {
         par3EntityPlayer.func_71008_a(par1ItemStack, this.func_77626_a(par1ItemStack));
         if (!par3EntityPlayer.field_71075_bZ.field_75098_d && !RivalRebels.infiniteAmmo) {
            par3EntityPlayer.field_71071_by.func_146026_a(RivalRebels.fuel);
            if (this.getMode(par1ItemStack) != 2) {
               par3EntityPlayer.field_71071_by.func_146026_a(RivalRebels.fuel);
            }

            if (this.getMode(par1ItemStack) != 2) {
               par3EntityPlayer.field_71071_by.func_146026_a(RivalRebels.fuel);
            }

            if (this.getMode(par1ItemStack) == 0) {
               par3EntityPlayer.field_71071_by.func_146026_a(RivalRebels.fuel);
            }

            if (this.getMode(par1ItemStack) == 0) {
               par3EntityPlayer.field_71071_by.func_146026_a(RivalRebels.fuel);
            }
         }

         if (par1ItemStack.func_77948_v() && !par2World.field_72995_K) {
            par2World.func_72838_d(new EntityFlameBallGreen(par2World, par3EntityPlayer, (float)(Math.random() + 1.0)));
         }
      } else if (!par2World.field_72995_K) {
         par3EntityPlayer.func_145747_a(new ChatComponentText("§cOut of fuel"));
      }

      if (this.message && par2World.field_72995_K) {
         par3EntityPlayer.func_145747_a(
            new ChatComponentText(StatCollector.func_74838_a("RivalRebels.Orders") + " " + StatCollector.func_74838_a("RivalRebels.message.use") + " [R].")
         );
         this.message = false;
      }

      return par1ItemStack;
   }

   public void onUsingTick(ItemStack item, EntityPlayer entity, int par4) {
      World world = entity.field_70170_p;
      if (!world.field_72995_K && entity.field_71071_by.func_70448_g() != null && entity.field_71071_by.func_70448_g().func_77973_b() == this) {
         if (world.field_73012_v.nextInt(10) == 0 && !entity.func_70090_H()) {
            RivalRebelsSoundPlayer.playSound(entity, 8, 0, 0.03F);
            if (world.field_73012_v.nextInt(3) == 0 && !entity.func_70090_H()) {
               RivalRebelsSoundPlayer.playSound(entity, 8, 1, 0.1F);
            }
         }

         if (!item.func_77948_v()) {
            switch (this.getMode(item)) {
               case 0:
                  for (int i = 0; i < 4; i++) {
                     world.func_72838_d(new EntityFlameBall2(world, entity, (float)(Math.random() + 0.5)));
                  }
                  break;
               case 1:
                  world.func_72838_d(new EntityFlameBall1(entity.field_70170_p, entity, 1.0F));
                  break;
               case 2:
                  world.func_72838_d(new EntityFlameBall(world, entity, 1.0F));
            }
         }
      }
   }

   public void func_77663_a(ItemStack item, World world, Entity entity, int par4, boolean par5) {
      if (item.func_77978_p() == null) {
         item.field_77990_d = new NBTTagCompound();
      }

      if (!item.func_77978_p().func_74767_n("isReady")) {
         item.func_77978_p().func_74757_a("isReady", true);
         item.func_77978_p().func_74768_a("mode", 2);
      }

      if (entity instanceof EntityPlayer) {
         EntityPlayer player = (EntityPlayer)entity;
         if (player.field_71071_by.func_70448_g() != null
            && player.field_71071_by.func_70448_g().func_77973_b() == this
            && world.field_73012_v.nextInt(10) == 0
            && !player.func_70090_H()) {
            RivalRebelsSoundPlayer.playSound(player, 8, 0, 0.03F);
         }
      }

      Side side = FMLCommonHandler.instance().getEffectiveSide();
      if (side == Side.CLIENT) {
         this.openGui(item, entity);
      }
   }

   public void openGui(ItemStack item, Entity entity) {
      if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT
         && (RivalRebels.altRkey ? Keyboard.isKeyDown(33) : Keyboard.isKeyDown(19))
         && item == ((EntityPlayer)entity).field_71071_by.func_70448_g()
         && Minecraft.func_71410_x().field_71462_r == null) {
         RivalRebels.proxy.flamethrowerGui(this.getMode(item));
      }
   }

   public int getMode(ItemStack item) {
      return item.field_77990_d == null ? 0 : item.field_77990_d.func_74762_e("mode");
   }

   public void func_94581_a(IIconRegister iconregister) {
      this.field_77791_bV = iconregister.func_94245_a("RivalRebels:ae");
   }
}
