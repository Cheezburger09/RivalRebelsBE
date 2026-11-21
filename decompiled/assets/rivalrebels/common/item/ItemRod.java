package assets.rivalrebels.common.item;

import assets.rivalrebels.RivalRebels;
import java.util.HashSet;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.Item.ToolMaterial;

public class ItemRod extends ItemTool {
   public int power;

   public ItemRod() {
      super(1.0F, ToolMaterial.EMERALD, new HashSet());
      this.field_77777_bU = 1;
      this.func_77656_e(32);
      this.func_77637_a(RivalRebels.rralltab);
   }

   public boolean func_77616_k(ItemStack is) {
      return true;
   }

   public boolean func_77645_m() {
      return true;
   }
}
