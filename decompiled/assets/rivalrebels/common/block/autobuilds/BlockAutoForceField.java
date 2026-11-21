package assets.rivalrebels.common.block.autobuilds;

import assets.rivalrebels.RivalRebels;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockAutoForceField extends BlockAutoTemplate {
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
         int r = 2;
         int h = 6;

         for (int y1 = 0; y1 <= h; y1++) {
            for (int x1 = -r; x1 <= r; x1++) {
               for (int z1 = -r; z1 <= r; z1++) {
                  if ((Math.abs(x1) != r && Math.abs(z1) != r || y1 == 3 && (Math.abs(x1) == 0 || Math.abs(z1) == 0)) && y1 != 0 && y1 != h) {
                     this.placeBlockCarefully(world, x + x1, y + y1, z + z1, Blocks.field_150350_a, 0, 2);
                  } else {
                     this.placeBlockCarefully(world, x + x1, y + y1, z + z1, RivalRebels.reactive);
                  }
               }
            }

            if (y1 != 3) {
               this.placeBlockCarefully(world, x + r + 1, y + y1, z, RivalRebels.reactive);
               this.placeBlockCarefully(world, x - r - 1, y + y1, z, RivalRebels.reactive);
               this.placeBlockCarefully(world, x, y + y1, z + r + 1, RivalRebels.reactive);
               this.placeBlockCarefully(world, x, y + y1, z - r - 1, RivalRebels.reactive);
            } else {
               for (int z1 = -r; z1 <= r; z1++) {
                  this.placeBlockCarefully(world, x, y + y1, z + z1, RivalRebels.conduit);
               }

               for (int x1 = -r; x1 <= r; x1++) {
                  this.placeBlockCarefully(world, x + x1, y + y1, z, RivalRebels.conduit);
               }
            }
         }
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
      this.icon3 = iconregister.func_94245_a("RivalRebels:db");
      this.icon4 = iconregister.func_94245_a("RivalRebels:db");
      this.icon5 = iconregister.func_94245_a("RivalRebels:db");
      this.icon6 = iconregister.func_94245_a("RivalRebels:db");
   }
}
