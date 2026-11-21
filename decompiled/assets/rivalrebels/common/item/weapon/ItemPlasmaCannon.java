package assets.rivalrebels.common.item.weapon;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import assets.rivalrebels.common.entity.EntityPlasmoid;
import java.util.HashSet;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemPlasmaCannon extends ItemTool {
   public ItemPlasmaCannon() {
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
      return 64;
   }

   public ItemStack func_77659_a(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
      if (par3EntityPlayer.field_71075_bZ.field_75098_d || par3EntityPlayer.field_71071_by.func_146028_b(RivalRebels.hydrod) || RivalRebels.infiniteAmmo) {
         par3EntityPlayer.func_71008_a(par1ItemStack, this.func_77626_a(par1ItemStack));
         if (!par3EntityPlayer.field_71075_bZ.field_75098_d && !RivalRebels.infiniteAmmo) {
            int item = -1;

            for (int i = 0; i < 36; i++) {
               if (par3EntityPlayer.field_71071_by.field_70462_a[i] != null
                  && par3EntityPlayer.field_71071_by.field_70462_a[i].func_77973_b() == RivalRebels.hydrod) {
                  item = i;
               }
            }

            if (item == -1) {
               return par1ItemStack;
            }

            par3EntityPlayer.field_71071_by.field_70462_a[item].func_77972_a(1, par3EntityPlayer);
            if (par3EntityPlayer.field_71071_by.field_70462_a[item].func_77960_j() == par3EntityPlayer.field_71071_by.field_70462_a[item].func_77958_k()) {
               par3EntityPlayer.field_71071_by.func_70298_a(item, 1);
               par3EntityPlayer.field_71071_by.func_70441_a(new ItemStack(RivalRebels.emptyrod, 1));
            }

            par3EntityPlayer.func_71008_a(par1ItemStack, this.func_77626_a(par1ItemStack));
         }

         RivalRebelsSoundPlayer.playSound(par3EntityPlayer, 16, 1, 0.25F);
      } else if (!par2World.field_72995_K) {
         par3EntityPlayer.func_145747_a(new ChatComponentText("§cOut of Hydrogen"));
      }

      return par1ItemStack;
   }

   public void func_77615_a(ItemStack item, World world, EntityPlayer player, int i) {
      if (!player.field_70170_p.field_72995_K) {
         float f = (this.func_77626_a(item) - i) / 20.0F;
         f = (f * f + f * 2.0F) * 0.3333F;
         if (f > 1.0F) {
            f = 1.0F;
         }

         f += 0.2F;
         RivalRebelsSoundPlayer.playSound(player, 16, 2);
         Entity entity = new EntityPlasmoid(player.field_70170_p, player, f + 0.5F, item.func_77986_q() != null);
         player.field_70170_p.func_72838_d(entity);
      }
   }

   public void func_94581_a(IIconRegister iconregister) {
      this.field_77791_bV = iconregister.func_94245_a("RivalRebels:ao");
   }
}
