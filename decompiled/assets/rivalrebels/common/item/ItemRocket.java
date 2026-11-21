package assets.rivalrebels.common.item;

import assets.rivalrebels.RivalRebels;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ItemRocket extends Item {
   public ItemRocket() {
      this.field_77777_bU = 32;
      this.func_77637_a(RivalRebels.rralltab);
   }

   public void func_94581_a(IIconRegister iconregister) {
      this.field_77791_bV = iconregister.func_94245_a("RivalRebels:ar");
   }
}
