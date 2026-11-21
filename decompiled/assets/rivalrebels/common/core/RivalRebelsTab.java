package assets.rivalrebels.common.core;

import assets.rivalrebels.RivalRebels;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class RivalRebelsTab extends CreativeTabs {
   private String name;
   private int icon;

   public RivalRebelsTab(String name, int icon) {
      super(name);
      this.name = name;
      this.icon = icon;
   }

   public Item func_78016_d() {
      return this.icon == 0 ? RivalRebels.nuclearelement : RivalRebels.hydrod;
   }

   public String func_78024_c() {
      return this.name;
   }

   public String func_78013_b() {
      return this.name;
   }
}
