package assets.rivalrebels.common.block.autobuilds;

import assets.rivalrebels.RivalRebels;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockRhodesScaffold extends BlockAutoTemplate {
   public static final byte[] binimg = new byte[]{
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      7,
      7,
      0,
      1,
      1,
      1,
      1,
      0,
      0,
      0,
      0,
      0,
      1,
      1,
      1,
      0,
      0,
      0,
      2,
      1,
      0,
      1,
      1,
      1,
      1,
      1,
      0,
      1,
      1,
      0,
      1,
      1,
      1,
      1,
      1,
      0,
      0,
      0,
      0,
      1,
      1,
      1,
      0,
      1,
      1,
      1,
      0,
      0,
      0,
      1,
      1,
      0,
      1,
      1,
      1,
      1,
      0,
      0,
      1,
      1,
      0,
      1,
      1,
      1,
      1,
      0,
      0,
      1,
      1,
      0,
      0,
      0,
      1,
      1,
      0,
      0,
      1,
      1,
      0,
      0,
      0,
      1,
      1,
      0,
      0,
      1,
      1,
      4,
      5,
      4,
      1,
      1,
      0,
      1,
      1,
      0,
      0,
      0,
      2,
      1,
      1,
      0,
      1,
      1,
      2,
      0,
      0,
      1,
      1,
      1,
      0,
      1,
      1,
      1,
      0,
      0,
      0,
      0,
      1,
      0,
      0,
      1,
      0,
      0,
      0,
      1,
      0,
      1,
      0,
      1,
      1,
      0,
      0,
      1,
      1,
      1,
      1,
      0,
      1,
      1,
      0,
      1,
      1,
      1,
      0,
      1,
      0,
      1,
      1,
      0,
      1,
      1,
      1,
      0,
      0,
      0,
      0,
      0,
      0,
      1,
      1,
      1,
      0,
      0,
      0,
      0,
      0,
      0,
      1,
      1,
      1,
      1,
      0,
      0,
      0,
      0,
      1,
      1,
      1,
      1,
      1,
      0,
      0,
      0,
      0,
      1,
      1,
      1,
      1,
      0,
      0,
      0,
      0,
      0,
      0,
      1,
      1,
      1,
      0,
      0,
      4,
      5,
      4,
      0,
      1,
      1,
      1,
      2,
      0,
      0,
      3,
      0,
      1,
      1,
      1,
      1,
      1,
      0,
      0,
      3,
      0,
      1,
      1,
      1,
      1,
      1,
      0,
      0,
      3,
      0,
      1,
      1,
      1,
      1,
      0,
      0,
      0,
      3,
      0,
      0,
      1,
      1,
      1,
      0,
      0,
      0,
      3,
      0,
      0,
      1,
      1,
      1,
      0,
      0,
      0,
      3,
      0,
      0,
      1,
      1,
      1,
      0,
      0,
      0,
      3,
      0,
      0,
      0,
      1,
      0,
      0,
      0,
      6,
      6,
      6,
      6,
      6,
      6,
      6,
      6,
      6
   };
   @SideOnly(Side.CLIENT)
   IIcon icon1;
   @SideOnly(Side.CLIENT)
   IIcon icon2;
   @SideOnly(Side.CLIENT)
   IIcon icon3;
   @SideOnly(Side.CLIENT)
   IIcon icon4;
   @SideOnly(Side.CLIENT)
   IIcon icon5;
   @SideOnly(Side.CLIENT)
   IIcon icon6;

   @Override
   public void build(World world, int x, int y, int z) {
      super.build(world, x, y, z);
      if (!world.field_72995_K) {
         int scale = 1;
         if (world.func_147439_a(x, y - 1, z) == RivalRebels.buildrhodes && world.func_147439_a(x, y - 2, z) == RivalRebels.buildrhodes) {
            if (world.func_147439_a(x, y - 3, z) == RivalRebels.buildrhodes && world.func_147439_a(x, y - 4, z) == RivalRebels.buildrhodes) {
               scale = 3;
            } else {
               scale = 2;
            }
         }

         for (int i = 0; i < 288; i++) {
            int fy = 30 - i / 9;
            int fx1 = -8 + i % 9;
            int fx2 = 9 - i % 9;
            fy *= scale;
            fx1 *= scale;
            fx2 *= scale;
            byte b = binimg[i];
            if (scale == 1) {
               this.place(world, x, y, z, fy, fx1, b);
               this.place(world, x, y, z, fy, fx2, b);
            } else if (scale == 2) {
               this.place(world, x, y, z, fy, fx1, b);
               this.place(world, x, y, z, fy, fx2, b);
               this.place(world, x, y, z, fy, fx1 + 1, b);
               this.place(world, x, y, z, fy, fx2 + 1, b);
               this.place(world, x, y, z, fy + 1, fx1, b);
               this.place(world, x, y, z, fy + 1, fx2, b);
               this.place(world, x, y, z, fy + 1, fx1 + 1, b);
               this.place(world, x, y, z, fy + 1, fx2 + 1, b);
            } else if (scale == 3) {
               this.place(world, x, y, z, fy, fx1, b);
               this.place(world, x, y, z, fy, fx2, b);
               this.place(world, x, y, z, fy, fx1 + 1, b);
               this.place(world, x, y, z, fy, fx2 + 1, b);
               this.place(world, x, y, z, fy, fx1 + 2, b);
               this.place(world, x, y, z, fy, fx2 + 2, b);
               this.place(world, x, y, z, fy + 1, fx1, b);
               this.place(world, x, y, z, fy + 1, fx2, b);
               this.place(world, x, y, z, fy + 1, fx1 + 1, b);
               this.place(world, x, y, z, fy + 1, fx2 + 1, b);
               this.place(world, x, y, z, fy + 1, fx1 + 2, b);
               this.place(world, x, y, z, fy + 1, fx2 + 2, b);
               this.place(world, x, y, z, fy + 2, fx1, b);
               this.place(world, x, y, z, fy + 2, fx2, b);
               this.place(world, x, y, z, fy + 2, fx1 + 1, b);
               this.place(world, x, y, z, fy + 2, fx2 + 1, b);
               this.place(world, x, y, z, fy + 2, fx1 + 2, b);
               this.place(world, x, y, z, fy + 2, fx2 + 2, b);
            }
         }
      }
   }

   private void place(World world, int x, int y, int z, int fy, int fx1, byte b) {
      if (b == 0) {
         world.func_147449_b(x + fx1, y + fy, z - 4, Blocks.field_150350_a);
         world.func_147449_b(x + fx1, y + fy, z - 3, Blocks.field_150350_a);
         world.func_147449_b(x + fx1, y + fy, z - 2, Blocks.field_150350_a);
         world.func_147449_b(x + fx1, y + fy, z - 1, Blocks.field_150350_a);
         world.func_147449_b(x + fx1, y + fy, z, RivalRebels.steel);
         world.func_147449_b(x + fx1, y + fy, z + 1, Blocks.field_150350_a);
         world.func_147449_b(x + fx1, y + fy, z + 2, Blocks.field_150350_a);
         world.func_147449_b(x + fx1, y + fy, z + 3, Blocks.field_150350_a);
         world.func_147449_b(x + fx1, y + fy, z + 4, Blocks.field_150350_a);
      }

      if (b == 1) {
         world.func_147449_b(x + fx1, y + fy, z - 4, Blocks.field_150350_a);
         world.func_147449_b(x + fx1, y + fy, z - 3, Blocks.field_150350_a);
         world.func_147449_b(x + fx1, y + fy, z - 2, Blocks.field_150350_a);
         world.func_147449_b(x + fx1, y + fy, z - 1, Blocks.field_150350_a);
         if (RivalRebels.prefillrhodes) {
            world.func_147449_b(x + fx1, y + fy, z, RivalRebels.conduit);
         } else {
            world.func_147449_b(x + fx1, y + fy, z, Blocks.field_150350_a);
         }

         world.func_147449_b(x + fx1, y + fy, z + 1, Blocks.field_150350_a);
         world.func_147449_b(x + fx1, y + fy, z + 2, Blocks.field_150350_a);
         world.func_147449_b(x + fx1, y + fy, z + 3, Blocks.field_150350_a);
         world.func_147449_b(x + fx1, y + fy, z + 4, Blocks.field_150350_a);
      }

      if (b == 2) {
         world.func_147449_b(x + fx1, y + fy, z - 4, Blocks.field_150350_a);
         world.func_147449_b(x + fx1, y + fy, z - 3, Blocks.field_150350_a);
         world.func_147449_b(x + fx1, y + fy, z - 2, Blocks.field_150350_a);
         world.func_147449_b(x + fx1, y + fy, z - 1, Blocks.field_150350_a);
         world.func_147449_b(x + fx1, y + fy, z, RivalRebels.rhodesactivator);
         world.func_147449_b(x + fx1, y + fy, z + 1, Blocks.field_150350_a);
         world.func_147449_b(x + fx1, y + fy, z + 2, Blocks.field_150350_a);
         world.func_147449_b(x + fx1, y + fy, z + 3, Blocks.field_150350_a);
         world.func_147449_b(x + fx1, y + fy, z + 4, Blocks.field_150350_a);
      }

      if (b == 3) {
         world.func_147449_b(x + fx1, y + fy, z - 4, Blocks.field_150350_a);
         world.func_147449_b(x + fx1, y + fy, z - 3, RivalRebels.steel);
         world.func_147449_b(x + fx1, y + fy, z - 2, Blocks.field_150350_a);
         world.func_147449_b(x + fx1, y + fy, z - 1, Blocks.field_150350_a);
         world.func_147449_b(x + fx1, y + fy, z, RivalRebels.steel);
         world.func_147449_b(x + fx1, y + fy, z + 1, Blocks.field_150350_a);
         world.func_147449_b(x + fx1, y + fy, z + 2, Blocks.field_150350_a);
         world.func_147449_b(x + fx1, y + fy, z + 3, RivalRebels.steel);
         world.func_147449_b(x + fx1, y + fy, z + 4, Blocks.field_150350_a);
      }

      if (b == 4) {
         world.func_147449_b(x + fx1, y + fy, z - 4, Blocks.field_150350_a);
         world.func_147449_b(x + fx1, y + fy, z - 3, RivalRebels.steel);
         world.func_147449_b(x + fx1, y + fy, z - 2, RivalRebels.steel);
         world.func_147449_b(x + fx1, y + fy, z - 1, RivalRebels.steel);
         world.func_147449_b(x + fx1, y + fy, z, RivalRebels.steel);
         world.func_147449_b(x + fx1, y + fy, z + 1, RivalRebels.steel);
         world.func_147449_b(x + fx1, y + fy, z + 2, RivalRebels.steel);
         world.func_147449_b(x + fx1, y + fy, z + 3, RivalRebels.steel);
         world.func_147449_b(x + fx1, y + fy, z + 4, Blocks.field_150350_a);
      }

      if (b == 5) {
         world.func_147449_b(x + fx1, y + fy, z - 4, Blocks.field_150350_a);
         world.func_147449_b(x + fx1, y + fy, z - 3, RivalRebels.steel);
         world.func_147449_b(x + fx1, y + fy, z - 2, RivalRebels.conduit);
         world.func_147449_b(x + fx1, y + fy, z - 1, RivalRebels.steel);
         world.func_147449_b(x + fx1, y + fy, z, RivalRebels.steel);
         world.func_147449_b(x + fx1, y + fy, z + 1, RivalRebels.steel);
         world.func_147449_b(x + fx1, y + fy, z + 2, RivalRebels.conduit);
         world.func_147449_b(x + fx1, y + fy, z + 3, RivalRebels.steel);
         world.func_147449_b(x + fx1, y + fy, z + 4, Blocks.field_150350_a);
      }

      if (b == 6) {
         world.func_147449_b(x + fx1, y + fy, z - 4, RivalRebels.reactive);
         world.func_147449_b(x + fx1, y + fy, z - 3, RivalRebels.reactive);
         world.func_147449_b(x + fx1, y + fy, z - 2, RivalRebels.reactive);
         world.func_147449_b(x + fx1, y + fy, z - 1, RivalRebels.reactive);
         world.func_147449_b(x + fx1, y + fy, z, RivalRebels.reactive);
         world.func_147449_b(x + fx1, y + fy, z + 1, RivalRebels.reactive);
         world.func_147449_b(x + fx1, y + fy, z + 2, RivalRebels.reactive);
         world.func_147449_b(x + fx1, y + fy, z + 3, RivalRebels.reactive);
         world.func_147449_b(x + fx1, y + fy, z + 4, RivalRebels.reactive);
      }

      if (b == 7) {
         world.func_147449_b(x + fx1, y + fy, z - 4, Blocks.field_150350_a);
         world.func_147449_b(x + fx1, y + fy, z - 3, Blocks.field_150350_a);
         world.func_147449_b(x + fx1, y + fy, z - 2, Blocks.field_150350_a);
         world.func_147449_b(x + fx1, y + fy, z - 1, Blocks.field_150350_a);
         world.func_147449_b(x + fx1, y + fy, z, Blocks.field_150350_a);
         world.func_147449_b(x + fx1, y + fy, z + 1, Blocks.field_150350_a);
         world.func_147449_b(x + fx1, y + fy, z + 2, Blocks.field_150350_a);
         world.func_147449_b(x + fx1, y + fy, z + 3, Blocks.field_150350_a);
         world.func_147449_b(x + fx1, y + fy, z + 4, Blocks.field_150350_a);
      }
   }

   @SideOnly(Side.CLIENT)
   public final IIcon func_149691_a(int side, int meta) {
      if (side == 0) {
         return this.icon1;
      } else if (side == 1) {
         return this.icon2;
      } else if (side == 2) {
         return this.icon3;
      } else if (side == 3) {
         return this.icon4;
      } else if (side == 4) {
         return this.icon5;
      } else {
         return side == 5 ? this.icon6 : this.icon1;
      }
   }

   @SideOnly(Side.CLIENT)
   public void func_149651_a(IIconRegister iconregister) {
      this.icon1 = iconregister.func_94245_a("RivalRebels:cz");
      this.icon2 = iconregister.func_94245_a("RivalRebels:da");
      this.icon3 = iconregister.func_94245_a("RivalRebels:dk");
      this.icon4 = iconregister.func_94245_a("RivalRebels:dk");
      this.icon5 = iconregister.func_94245_a("RivalRebels:dk");
      this.icon6 = iconregister.func_94245_a("RivalRebels:dk");
   }
}
