package assets.rivalrebels.common.item;

import assets.rivalrebels.RivalRebels;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;

public class ItemRodRedstone extends ItemRod {
   public ItemRodRedstone() {
      this.field_77777_bU = 1;
      this.power = 300000;
      this.func_77656_e(256);
      this.func_77637_a(RivalRebels.rralltab);
   }

   @Override
   public boolean func_77616_k(ItemStack is) {
      return true;
   }

   @Override
   public boolean func_77645_m() {
      return true;
   }

   public void func_94581_a(IIconRegister iconregister) {
      this.field_77791_bV = iconregister.func_94245_a("RivalRebels:al");
   }
}
