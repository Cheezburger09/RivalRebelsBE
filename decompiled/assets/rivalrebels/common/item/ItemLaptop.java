package assets.rivalrebels.common.item;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.entity.EntityLaptop;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.Facing;
import net.minecraft.world.World;

public class ItemLaptop extends Item {
   public ItemLaptop() {
      this.field_77777_bU = 4;
      this.func_77637_a(RivalRebels.rralltab);
   }

   public boolean func_77648_a(
      ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10
   ) {
      if (!par3World.field_72995_K) {
         par2EntityPlayer.func_145747_a(new ChatComponentText("Out of service"));
         Block var11 = par3World.func_147439_a(par4, par5, par6);
         par4 += Facing.field_71586_b[par7];
         par5 += Facing.field_71587_c[par7];
         par6 += Facing.field_71585_d[par7];
         double var12 = 0.0;
         if (par7 == 1 && var11 != null && var11.func_149645_b() == 11) {
            var12 = 0.5;
         }

         EntityLaptop laptop = new EntityLaptop(par3World);
         laptop.func_70012_b(par4 + 0.5F, (float)(par5 + var12), par6 + 0.5F, par2EntityPlayer.field_70177_z, 0.0F);
         par3World.func_72838_d(laptop);
         par1ItemStack.field_77994_a--;
         return true;
      } else {
         return true;
      }
   }

   public void func_94581_a(IIconRegister iconregister) {
      this.field_77791_bV = iconregister.func_94245_a("RivalRebels:aj");
   }
}
