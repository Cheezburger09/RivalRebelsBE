package assets.rivalrebels.common.item;

import assets.rivalrebels.RivalRebels;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class ItemClassArmor extends ItemArmor {
   private static final int[] maxDamageArray = new int[]{0, 0, 0, 0};
   public final int field_77881_a;
   public final int field_77879_b;
   public final int field_77880_c;
   public int team;
   public int stateclass;
   private final ArmorMaterial material;

   public ItemClassArmor(ArmorMaterial par2EnumArmorMaterial, int par3, int par4, int team, int stateclass) {
      super(par2EnumArmorMaterial, par3, par4);
      this.material = par2EnumArmorMaterial;
      this.field_77881_a = par4;
      this.field_77880_c = par3;
      this.field_77879_b = this.material.func_78044_b(par4);
      this.func_77637_a(RivalRebels.rrarmortab);
      this.func_77656_e(par2EnumArmorMaterial.func_78046_a(par4));
      this.field_77777_bU = 1;
      this.team = team;
      this.stateclass = stateclass;

      for (int i = 0; i < maxDamageArray.length; i++) {
         maxDamageArray[i] = this.material.func_78044_b(i);
      }
   }

   static int[] getMaxDamageArray() {
      return maxDamageArray;
   }

   public String getArmorTexture(ItemStack item, Entity entity, int slot, String type) {
      Item itemstack = item.func_77973_b();
      if (itemstack == RivalRebels.orebelhelmet) {
         return "rivalrebels:textures/armors/l.png";
      } else if (itemstack == RivalRebels.orebelchest) {
         return "rivalrebels:textures/armors/l.png";
      } else if (itemstack == RivalRebels.orebelpants) {
         return "rivalrebels:textures/armors/k.png";
      } else if (itemstack == RivalRebels.orebelboots) {
         return "rivalrebels:textures/armors/l.png";
      } else if (itemstack == RivalRebels.onukerhelmet) {
         return "rivalrebels:textures/armors/i.png";
      } else if (itemstack == RivalRebels.onukerchest) {
         return "rivalrebels:textures/armors/i.png";
      } else if (itemstack == RivalRebels.onukerpants) {
         return "rivalrebels:textures/armors/k.png";
      } else if (itemstack == RivalRebels.onukerboots) {
         return "rivalrebels:textures/armors/i.png";
      } else if (itemstack == RivalRebels.ointelhelmet) {
         return "rivalrebels:textures/armors/g.png";
      } else if (itemstack == RivalRebels.ointelchest) {
         return "rivalrebels:textures/armors/g.png";
      } else if (itemstack == RivalRebels.ointelpants) {
         return "rivalrebels:textures/armors/k.png";
      } else if (itemstack == RivalRebels.ointelboots) {
         return "rivalrebels:textures/armors/g.png";
      } else if (itemstack == RivalRebels.ohackerhelmet) {
         return "rivalrebels:textures/armors/e.png";
      } else if (itemstack == RivalRebels.ohackerchest) {
         return "rivalrebels:textures/armors/e.png";
      } else if (itemstack == RivalRebels.ohackerpants) {
         return "rivalrebels:textures/armors/k.png";
      } else if (itemstack == RivalRebels.ohackerboots) {
         return "rivalrebels:textures/armors/e.png";
      } else if (itemstack == RivalRebels.srebelhelmet) {
         return "rivalrebels:textures/armors/m.png";
      } else if (itemstack == RivalRebels.srebelchest) {
         return "rivalrebels:textures/armors/m.png";
      } else if (itemstack == RivalRebels.srebelpants) {
         return "rivalrebels:textures/armors/n.png";
      } else if (itemstack == RivalRebels.srebelboots) {
         return "rivalrebels:textures/armors/m.png";
      } else if (itemstack == RivalRebels.snukerhelmet) {
         return "rivalrebels:textures/armors/j.png";
      } else if (itemstack == RivalRebels.snukerchest) {
         return "rivalrebels:textures/armors/j.png";
      } else if (itemstack == RivalRebels.snukerpants) {
         return "rivalrebels:textures/armors/n.png";
      } else if (itemstack == RivalRebels.snukerboots) {
         return "rivalrebels:textures/armors/j.png";
      } else if (itemstack == RivalRebels.sintelhelmet) {
         return "rivalrebels:textures/armors/h.png";
      } else if (itemstack == RivalRebels.sintelchest) {
         return "rivalrebels:textures/armors/h.png";
      } else if (itemstack == RivalRebels.sintelpants) {
         return "rivalrebels:textures/armors/n.png";
      } else if (itemstack == RivalRebels.sintelboots) {
         return "rivalrebels:textures/armors/h.png";
      } else if (itemstack == RivalRebels.shackerhelmet) {
         return "rivalrebels:textures/armors/f.png";
      } else if (itemstack == RivalRebels.shackerchest) {
         return "rivalrebels:textures/armors/f.png";
      } else if (itemstack == RivalRebels.shackerpants) {
         return "rivalrebels:textures/armors/n.png";
      } else {
         return itemstack == RivalRebels.shackerboots ? "rivalrebels:textures/armors/f.png" : "";
      }
   }

   public void func_94581_a(IIconRegister iconregister) {
      String str = "";
      if (this.team == 0) {
         str = "o";
      }

      if (this.team == 1) {
         str = "s";
      }

      if (this.stateclass == 0) {
         str = "r" + str;
      }

      if (this.stateclass == 1) {
         str = "n" + str;
      }

      if (this.stateclass == 2) {
         str = "i" + str;
      }

      if (this.stateclass == 3) {
         str = "h" + str;
      }

      if (this.field_77881_a == 0) {
         this.field_77791_bV = iconregister.func_94245_a("rivalrebels:" + str + "h");
      }

      if (this.field_77881_a == 1) {
         this.field_77791_bV = iconregister.func_94245_a("rivalrebels:" + str + "c");
      }

      if (this.field_77881_a == 2) {
         this.field_77791_bV = iconregister.func_94245_a("rivalrebels:" + str + "p");
      }

      if (this.field_77881_a == 3) {
         this.field_77791_bV = iconregister.func_94245_a("rivalrebels:" + str + "b");
      }
   }
}
