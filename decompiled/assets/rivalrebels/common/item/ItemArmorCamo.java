package assets.rivalrebels.common.item;

import assets.rivalrebels.RivalRebels;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class ItemArmorCamo extends ItemArmor {
   private static final int[] maxDamageArray = new int[]{11, 16, 15, 13};
   public final int field_77881_a;
   public final int field_77879_b;
   public final int field_77880_c;
   public int team;

   public ItemArmorCamo(ArmorMaterial par2EnumArmorMaterial, int par3, int par4, int team) {
      super(par2EnumArmorMaterial, par3, par4);
      this.field_77881_a = par4;
      this.field_77880_c = par3;
      this.field_77879_b = maxDamageArray[par4];
      this.func_77637_a(RivalRebels.rrarmortab);
      this.func_77656_e(par2EnumArmorMaterial.func_78046_a(par4) * 2);
      this.field_77777_bU = 1;
      this.team = team;
   }

   static int[] getMaxDamageArray() {
      return maxDamageArray;
   }

   public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String layer) {
      if (itemstack.func_77973_b() == RivalRebels.camohat
         || itemstack.func_77973_b() == RivalRebels.camoshirt
         || itemstack.func_77973_b() == RivalRebels.camoshoes) {
         return "rivalrebels:textures/armors/c.png";
      } else if (itemstack.func_77973_b() == RivalRebels.camopants) {
         return "rivalrebels:textures/armors/d.png";
      } else if (itemstack.func_77973_b() == RivalRebels.camohat2
         || itemstack.func_77973_b() == RivalRebels.camoshirt2
         || itemstack.func_77973_b() == RivalRebels.camoshoes2) {
         return "rivalrebels:textures/armors/a.png";
      } else {
         return itemstack.func_77973_b() == RivalRebels.camopants2 ? "rivalrebels:textures/armors/b.png" : null;
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

      if (this.field_77881_a == 0) {
         this.field_77791_bV = iconregister.func_94245_a("RivalRebels:" + str + "h");
      }

      if (this.field_77881_a == 1) {
         this.field_77791_bV = iconregister.func_94245_a("RivalRebels:" + str + "v");
      }

      if (this.field_77881_a == 2) {
         this.field_77791_bV = iconregister.func_94245_a("RivalRebels:" + str + "p");
      }

      if (this.field_77881_a == 3) {
         this.field_77791_bV = iconregister.func_94245_a("RivalRebels:" + str + "b");
      }
   }
}
