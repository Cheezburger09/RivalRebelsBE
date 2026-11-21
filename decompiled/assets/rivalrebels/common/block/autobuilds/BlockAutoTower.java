package assets.rivalrebels.common.block.autobuilds;

import assets.rivalrebels.RivalRebels;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockAutoTower extends BlockAutoTemplate {
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

      for (int y1 = 0; y1 <= 16; y1++) {
         this.placeBlockCarefully(world, x + 1, y + y1, z, RivalRebels.steel);
         this.placeBlockCarefully(world, x - 1, y + y1, z, RivalRebels.steel);
         this.placeBlockCarefully(world, x, y + y1, z + 1, RivalRebels.steel);
         this.placeBlockCarefully(world, x, y + y1, z - 1, RivalRebels.steel);
         this.placeBlockCarefully(world, x - 1, y + y1, z + 1, RivalRebels.steel);
         this.placeBlockCarefully(world, x + 1, y + y1, z - 1, RivalRebels.steel);
         this.placeBlockCarefully(world, x + 1, y + y1, z + 1, RivalRebels.steel);
         this.placeBlockCarefully(world, x - 1, y + y1, z - 1, RivalRebels.steel);
         this.placeBlockCarefully(world, x, y + y1, z, Blocks.field_150350_a);
         if (y1 <= 1) {
            this.placeBlockCarefully(world, x + 1, y + y1, z, Blocks.field_150350_a);
            this.placeBlockCarefully(world, x - 1, y + y1, z, Blocks.field_150350_a);
            this.placeBlockCarefully(world, x, y + y1, z + 1, Blocks.field_150350_a);
            this.placeBlockCarefully(world, x, y + y1, z - 1, Blocks.field_150350_a);
         } else if (y1 == 8) {
            this.placeBlockCarefully(world, x - 1, y + y1, z + 1, Blocks.field_150424_aL);
            this.placeBlockCarefully(world, x + 1, y + y1, z - 1, Blocks.field_150424_aL);
            this.placeBlockCarefully(world, x + 1, y + y1, z + 1, Blocks.field_150424_aL);
            this.placeBlockCarefully(world, x - 1, y + y1, z - 1, Blocks.field_150424_aL);
         } else if (y1 == 11) {
            this.placeBlockCarefully(world, x - 1, y + y1, z + 1, Blocks.field_150424_aL);
            this.placeBlockCarefully(world, x + 1, y + y1, z - 1, Blocks.field_150424_aL);
            this.placeBlockCarefully(world, x + 1, y + y1, z + 1, Blocks.field_150424_aL);
            this.placeBlockCarefully(world, x - 1, y + y1, z - 1, Blocks.field_150424_aL);
         } else if (y1 == 9) {
            this.placeBlockCarefully(world, x - 1, y + y1, z + 1, Blocks.field_150350_a);
            this.placeBlockCarefully(world, x + 1, y + y1, z - 1, Blocks.field_150350_a);
            this.placeBlockCarefully(world, x + 1, y + y1, z + 1, Blocks.field_150350_a);
            this.placeBlockCarefully(world, x - 1, y + y1, z - 1, Blocks.field_150350_a);
         } else if (y1 == 10) {
            this.placeBlockCarefully(world, x - 1, y + y1, z, Blocks.field_150350_a);
            this.placeBlockCarefully(world, x + 1, y + y1, z, Blocks.field_150350_a);
            this.placeBlockCarefully(world, x, y + y1, z + 1, Blocks.field_150350_a);
            this.placeBlockCarefully(world, x, y + y1, z - 1, Blocks.field_150350_a);
         } else if (y1 == 12) {
            this.placeBlockCarefully(world, x - 1, y + y1, z + 1, Blocks.field_150350_a);
            this.placeBlockCarefully(world, x + 1, y + y1, z - 1, Blocks.field_150350_a);
            this.placeBlockCarefully(world, x + 1, y + y1, z + 1, Blocks.field_150350_a);
            this.placeBlockCarefully(world, x - 1, y + y1, z - 1, Blocks.field_150350_a);
         } else if (y1 == 16) {
            this.placeBlockCarefully(world, x - 1, y + y1, z + 1, Blocks.field_150364_r);
            this.placeBlockCarefully(world, x - 1, y + y1 + 1, z + 1, Blocks.field_150429_aA);
            this.placeBlockCarefully(world, x + 1, y + y1 + 1, z - 1, Blocks.field_150429_aA);
            this.placeBlockCarefully(world, x + 1, y + y1 + 1, z + 1, Blocks.field_150429_aA);
            this.placeBlockCarefully(world, x - 1, y + y1 + 1, z - 1, Blocks.field_150429_aA);
         }
      }

      this.placeBlockCarefully(world, x, y - 1, z, RivalRebels.jump);
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
      this.icon2 = iconregister.func_94245_a("RivalRebels:ai");
      this.icon3 = iconregister.func_94245_a("RivalRebels:cy");
      this.icon4 = iconregister.func_94245_a("RivalRebels:cy");
      this.icon5 = iconregister.func_94245_a("RivalRebels:cy");
      this.icon6 = iconregister.func_94245_a("RivalRebels:cy");
   }
}
