package assets.rivalrebels.common.block.autobuilds;

import assets.rivalrebels.RivalRebels;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockAutoBunker extends BlockAutoTemplate {
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
         int r = RivalRebels.bunkerradius;

         for (int x1 = -r; x1 <= r; x1++) {
            for (int y1 = 0; y1 <= 5; y1++) {
               for (int z1 = -r; z1 <= r; z1++) {
                  this.placeBlockCarefully(world, x + x1, y + y1, z + z1, Blocks.field_150350_a);
               }
            }
         }

         for (int a = -r; a <= r; a++) {
            for (int c = -r; c <= r; c++) {
               this.placeBlockCarefully(world, x + a, y - 1, z + c, RivalRebels.smartcamo);
               if (a < -(r - 1) || c < -(r - 1) || a > r - 1 || c > r - 1) {
                  this.placeBlockCarefully(world, x + a, y, z + c, RivalRebels.smartcamo);
               }
            }
         }

         y += 3;
         r -= 2;

         for (int a = -(r - 1); a <= r - 1; a++) {
            for (int c = -(r - 1); c <= r - 1; c++) {
               if (a == -(r - 1) && c == -(r - 1) || a == -(r - 1) && c == r - 1 || a == r - 1 && c == -(r - 1) || a == r - 1 && c == r - 1) {
                  this.placeBlockCarefully(world, x + a, y - 3, z + c, RivalRebels.smartcamo);
                  this.placeBlockCarefully(world, x + a, y - 2, z + c, RivalRebels.smartcamo);
                  this.placeBlockCarefully(world, x + a, y - 1, z + c, RivalRebels.smartcamo);
               }

               if (a < -(r - 2) || c < -(r - 2) || a > r - 2 || c > r - 2) {
                  this.placeBlockCarefully(world, x + a, y - 3, z + c, RivalRebels.smartcamo);
                  this.placeBlockCarefully(world, x + a, y, z + c, RivalRebels.smartcamo);
                  this.placeBlockCarefully(world, x + a, y + 1, z + c, RivalRebels.smartcamo);
               }
            }
         }

         for (int a = -r; a <= r; a++) {
            for (int c = -r; c <= r; c++) {
               if (a < -(r - 1) || c < -(r - 1) || a > r - 1 || c > r - 1) {
                  this.placeBlockCarefully(world, x + a, y, z + c, RivalRebels.smartcamo);
                  this.placeBlockCarefully(world, x + a, y - 3, z + c, RivalRebels.smartcamo);
               }
            }
         }

         r -= 2;

         for (int a = -r; a <= r; a++) {
            for (int c = -r; c <= r; c++) {
               this.placeBlockCarefully(world, x + a, y + 1, z + c, RivalRebels.smartcamo);
               this.placeBlockCarefully(world, x + a, y + 2, z + c, RivalRebels.smartcamo);
            }
         }

         y -= 3;
         r += 4;

         for (int a = -(r - 1); a <= r - 1; a++) {
            for (int c = -(r - 1); c <= r - 1; c++) {
               if (a < -(r - 2) || c < -(r - 2) || a > r - 2 || c > r - 2) {
                  this.placeBlockCarefully(world, x + a, y, z + c, RivalRebels.smartcamo);
                  this.placeBlockCarefully(world, x + a, y + 1, z + c, RivalRebels.smartcamo);
               }
            }
         }

         this.placeBlockCarefully(world, x - r + 5, y + 3, z, RivalRebels.light2);
         this.placeBlockCarefully(world, x + r - 5, y + 3, z, RivalRebels.light2);
         this.placeBlockCarefully(world, x, y + 3, z + r - 5, RivalRebels.light2);
         this.placeBlockCarefully(world, x, y + 3, z - r + 5, RivalRebels.light2);
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
      this.icon1 = iconregister.func_94245_a("RivalRebels:ah");
      this.icon2 = iconregister.func_94245_a("RivalRebels:ah");
      this.icon3 = iconregister.func_94245_a("RivalRebels:bl");
      this.icon4 = iconregister.func_94245_a("RivalRebels:bl");
      this.icon5 = iconregister.func_94245_a("RivalRebels:bl");
      this.icon6 = iconregister.func_94245_a("RivalRebels:bl");
   }
}
