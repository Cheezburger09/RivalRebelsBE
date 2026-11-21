package assets.rivalrebels.common.block.autobuilds;

import assets.rivalrebels.RivalRebels;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockAutoEaster extends BlockAutoTemplate {
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
   public void build(World par1World, int x, int y, int z) {
      super.build(par1World, x, y, z);
      int h = 0;
      this.placeBlockCarefully(par1World, x, y, z, Blocks.field_150350_a);
      this.placeBlockCarefully(par1World, x + 1, y + h, z, RivalRebels.jump);
      this.placeBlockCarefully(par1World, x + 2, y + h, z, RivalRebels.jump);
      this.placeBlockCarefully(par1World, x + 3, y + h, z, RivalRebels.jump);
      this.placeBlockCarefully(par1World, x + 4, y + h, z, RivalRebels.jump);
      this.placeBlockCarefully(par1World, x + 1, y + h, z + 1, RivalRebels.jump);
      this.placeBlockCarefully(par1World, x + 2, y + h, z + 1, RivalRebels.jump);
      this.placeBlockCarefully(par1World, x + 3, y + h, z + 1, RivalRebels.jump);
      this.placeBlockCarefully(par1World, x + 4, y + h, z + 1, RivalRebels.jump);
      this.placeBlockCarefully(par1World, x + 1, y + h, z + 2, RivalRebels.jump);
      this.placeBlockCarefully(par1World, x + 2, y + h, z + 2, RivalRebels.jump);
      this.placeBlockCarefully(par1World, x + 3, y + h, z + 2, RivalRebels.jump);
      this.placeBlockCarefully(par1World, x + 4, y + h, z + 2, RivalRebels.jump);
      this.placeBlockCarefully(par1World, x + 1, y + h, z + 3, RivalRebels.jump);
      this.placeBlockCarefully(par1World, x + 2, y + h, z + 3, RivalRebels.jump);
      this.placeBlockCarefully(par1World, x + 3, y + h, z + 3, RivalRebels.jump);
      this.placeBlockCarefully(par1World, x + 4, y + h, z + 3, RivalRebels.jump);
      this.placeBlockCarefully(par1World, x + 1, y + ++h, z, Blocks.field_150433_aE);
      this.placeBlockCarefully(par1World, x + 2, y + h, z, Blocks.field_150433_aE);
      this.placeBlockCarefully(par1World, x + 3, y + h, z, Blocks.field_150433_aE);
      this.placeBlockCarefully(par1World, x + 4, y + h, z, Blocks.field_150433_aE);
      this.placeBlockCarefully(par1World, x + 1, y + h, z + 1, Blocks.field_150433_aE);
      this.placeBlockCarefully(par1World, x + 2, y + h, z + 1, Blocks.field_150433_aE);
      this.placeBlockCarefully(par1World, x + 3, y + h, z + 1, Blocks.field_150433_aE);
      this.placeBlockCarefully(par1World, x + 4, y + h, z + 1, Blocks.field_150433_aE);
      this.placeBlockCarefully(par1World, x + 1, y + h, z + 2, Blocks.field_150433_aE);
      this.placeBlockCarefully(par1World, x + 2, y + h, z + 2, Blocks.field_150433_aE);
      this.placeBlockCarefully(par1World, x + 3, y + h, z + 2, Blocks.field_150433_aE);
      this.placeBlockCarefully(par1World, x + 4, y + h, z + 2, Blocks.field_150433_aE);
      this.placeBlockCarefully(par1World, x + 1, y + h, z + 3, Blocks.field_150433_aE);
      this.placeBlockCarefully(par1World, x + 2, y + h, z + 3, Blocks.field_150433_aE);
      this.placeBlockCarefully(par1World, x + 3, y + h, z + 3, Blocks.field_150433_aE);
      this.placeBlockCarefully(par1World, x + 4, y + h, z + 3, Blocks.field_150433_aE);
      this.placeBlockCarefully(par1World, x + 1, y + ++h, z, Blocks.field_150433_aE);
      this.placeBlockCarefully(par1World, x + 2, y + h, z, Blocks.field_150433_aE);
      this.placeBlockCarefully(par1World, x + 3, y + h, z, Blocks.field_150433_aE);
      this.placeBlockCarefully(par1World, x + 4, y + h, z, Blocks.field_150433_aE);
      this.placeBlockCarefully(par1World, x + 1, y + h, z + 1, Blocks.field_150433_aE);
      this.placeBlockCarefully(par1World, x + 2, y + h, z + 1, Blocks.field_150433_aE);
      this.placeBlockCarefully(par1World, x + 3, y + h, z + 1, Blocks.field_150433_aE);
      this.placeBlockCarefully(par1World, x + 4, y + h, z + 1, Blocks.field_150433_aE);
      this.placeBlockCarefully(par1World, x + 1, y + h, z + 2, Blocks.field_150433_aE);
      this.placeBlockCarefully(par1World, x + 2, y + h, z + 2, Blocks.field_150433_aE);
      this.placeBlockCarefully(par1World, x + 3, y + h, z + 2, Blocks.field_150433_aE);
      this.placeBlockCarefully(par1World, x + 4, y + h, z + 2, Blocks.field_150433_aE);
      this.placeBlockCarefully(par1World, x + 1, y + h, z + 3, Blocks.field_150433_aE);
      this.placeBlockCarefully(par1World, x + 2, y + h, z + 3, Blocks.field_150433_aE);
      this.placeBlockCarefully(par1World, x + 3, y + h, z + 3, Blocks.field_150433_aE);
      this.placeBlockCarefully(par1World, x + 4, y + h, z + 3, Blocks.field_150433_aE);
      this.placeBlockCarefully(par1World, x + 1, y + ++h, z, Blocks.field_150423_aK);
      this.placeBlockCarefully(par1World, x + 2, y + h, z, Blocks.field_150423_aK);
      this.placeBlockCarefully(par1World, x + 3, y + h, z, Blocks.field_150423_aK);
      this.placeBlockCarefully(par1World, x + 4, y + h, z, Blocks.field_150423_aK);
      this.placeBlockCarefully(par1World, x + 1, y + h, z + 1, Blocks.field_150423_aK);
      this.placeBlockCarefully(par1World, x + 2, y + h, z + 1, Blocks.field_150423_aK);
      this.placeBlockCarefully(par1World, x + 3, y + h, z + 1, Blocks.field_150423_aK);
      this.placeBlockCarefully(par1World, x + 4, y + h, z + 1, Blocks.field_150423_aK);
      this.placeBlockCarefully(par1World, x + 1, y + h, z + 2, Blocks.field_150423_aK);
      this.placeBlockCarefully(par1World, x + 2, y + h, z + 2, Blocks.field_150423_aK);
      this.placeBlockCarefully(par1World, x + 3, y + h, z + 2, Blocks.field_150423_aK);
      this.placeBlockCarefully(par1World, x + 4, y + h, z + 2, Blocks.field_150423_aK);
      this.placeBlockCarefully(par1World, x + 1, y + h, z + 3, Blocks.field_150423_aK);
      this.placeBlockCarefully(par1World, x + 2, y + h, z + 3, Blocks.field_150423_aK);
      this.placeBlockCarefully(par1World, x + 3, y + h, z + 3, Blocks.field_150423_aK);
      this.placeBlockCarefully(par1World, x + 4, y + h, z + 3, Blocks.field_150423_aK);
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
      this.icon3 = iconregister.func_94245_a("RivalRebels:ah");
      this.icon4 = iconregister.func_94245_a("RivalRebels:ah");
      this.icon5 = iconregister.func_94245_a("RivalRebels:ah");
      this.icon6 = iconregister.func_94245_a("RivalRebels:ah");
   }
}
