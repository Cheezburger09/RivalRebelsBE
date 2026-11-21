package assets.rivalrebels.common.item;

import assets.rivalrebels.RivalRebels;
import net.minecraft.item.Item;

public class ItemCore extends Item {
   public float timemult = 0.0F;

   public ItemCore() {
      this.field_77777_bU = 1;
      this.func_77637_a(RivalRebels.rralltab);
   }
}
