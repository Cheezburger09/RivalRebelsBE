package assets.rivalrebels.common.item;

import assets.rivalrebels.RivalRebels;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class ItemTrollHelmet extends ItemArmor {
   public ItemTrollHelmet() {
      super(EnumHelper.addArmorMaterial("Troll", 5000, new int[]{0, 0, 0, 0}, 1000), 0, 0);
      this.func_77637_a(RivalRebels.rrarmortab);
      this.func_77656_e(5000);
      this.field_77777_bU = 64;
   }

   public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String layer) {
      return "rivalrebels:textures/armors/o.png";
   }

   public void func_94581_a(IIconRegister iconregister) {
      this.field_77791_bV = iconregister.func_94245_a("RivalRebels:bf");
   }

   public boolean func_77648_a(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int s, float px, float py, float pz) {
      Block block = world.func_147439_a(x, y, z);
      if (block == Blocks.field_150431_aC && (world.func_72805_g(x, y, z) & 7) < 1) {
         s = 1;
      } else if (block != Blocks.field_150395_bd && block != Blocks.field_150329_H && block != Blocks.field_150330_I && !block.isReplaceable(world, x, y, z)) {
         if (s == 0) {
            y--;
         }

         if (s == 1) {
            y++;
         }

         if (s == 2) {
            z--;
         }

         if (s == 3) {
            z++;
         }

         if (s == 4) {
            x--;
         }

         if (s == 5) {
            x++;
         }
      }

      if (item.field_77994_a == 0) {
         return false;
      } else if (!player.func_82247_a(x, y, z, s, item)) {
         return false;
      } else if (world.func_147472_a(RivalRebels.flag2, x, y, z, false, s, player, item)) {
         int i1 = this.func_77647_b(item.func_77960_j());
         int j1 = RivalRebels.flag2.func_149660_a(world, x, y, z, s, px, py, pz, i1);
         world.func_147465_d(x, y, z, RivalRebels.flag2, j1, 3);
         world.func_72908_a(
            x + 0.5F,
            y + 0.5F,
            z + 0.5F,
            RivalRebels.flag2.field_149762_H.func_150496_b(),
            (RivalRebels.flag2.field_149762_H.func_150497_c() + 1.0F) / 2.0F,
            RivalRebels.flag2.field_149762_H.func_150494_d() * 0.8F
         );
         item.field_77994_a--;
         return true;
      } else {
         return false;
      }
   }
}
