package assets.rivalrebels.common.block.autobuilds;

import assets.rivalrebels.RivalRebels;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockAutoBarricade extends BlockAutoTemplate {
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
      this.placeBlockCarefully(par1World, x, y, z, Blocks.field_150350_a);
      this.placeBlockCarefully(par1World, x + 1, y, z + 1, RivalRebels.reactive);
      this.placeBlockCarefully(par1World, x + 1, y, z - 1, RivalRebels.reactive);
      this.placeBlockCarefully(par1World, x - 1, y, z - 1, RivalRebels.reactive);
      this.placeBlockCarefully(par1World, x - 1, y, z + 1, RivalRebels.reactive);
      this.placeBlockCarefully(par1World, x + 1, y + 1, z + 1, RivalRebels.reactive);
      this.placeBlockCarefully(par1World, x + 1, y + 1, z - 1, RivalRebels.reactive);
      this.placeBlockCarefully(par1World, x - 1, y + 1, z - 1, RivalRebels.reactive);
      this.placeBlockCarefully(par1World, x - 1, y + 1, z + 1, RivalRebels.reactive);
      this.placeBlockCarefully(par1World, x + 1, y + 2, z + 1, RivalRebels.reactive);
      this.placeBlockCarefully(par1World, x + 1, y + 2, z - 1, RivalRebels.reactive);
      this.placeBlockCarefully(par1World, x - 1, y + 2, z - 1, RivalRebels.reactive);
      this.placeBlockCarefully(par1World, x - 1, y + 2, z + 1, RivalRebels.reactive);
      this.placeBlockCarefully(par1World, x, y + 2, z + 1, RivalRebels.steel);
      this.placeBlockCarefully(par1World, x + 1, y + 2, z, RivalRebels.steel);
      this.placeBlockCarefully(par1World, x, y + 2, z - 1, RivalRebels.steel);
      this.placeBlockCarefully(par1World, x - 1, y + 2, z, RivalRebels.steel);
      this.placeBlockCarefully(par1World, x, y + 2, z + 2, RivalRebels.reactive);
      this.placeBlockCarefully(par1World, x + 2, y + 2, z, RivalRebels.reactive);
      this.placeBlockCarefully(par1World, x, y + 2, z - 2, RivalRebels.reactive);
      this.placeBlockCarefully(par1World, x - 2, y + 2, z, RivalRebels.reactive);
      this.placeBlockCarefully(par1World, x + 1, y + 3, z + 1, RivalRebels.reactive);
      this.placeBlockCarefully(par1World, x + 1, y + 3, z - 1, RivalRebels.reactive);
      this.placeBlockCarefully(par1World, x - 1, y + 3, z - 1, RivalRebels.reactive);
      this.placeBlockCarefully(par1World, x - 1, y + 3, z + 1, RivalRebels.reactive);
      this.placeBlockCarefully(par1World, x, y + 3, z + 1, RivalRebels.steel);
      this.placeBlockCarefully(par1World, x + 1, y + 3, z, RivalRebels.steel);
      this.placeBlockCarefully(par1World, x, y + 3, z - 1, RivalRebels.steel);
      this.placeBlockCarefully(par1World, x - 1, y + 3, z, RivalRebels.steel);
      this.placeBlockCarefully(par1World, x, y + 3, z - 2, RivalRebels.ffreciever, 2, 3);
      this.placeBlockCarefully(par1World, x, y + 3, z + 2, RivalRebels.ffreciever, 3, 3);
      this.placeBlockCarefully(par1World, x - 2, y + 3, z, RivalRebels.ffreciever, 4, 3);
      this.placeBlockCarefully(par1World, x + 2, y + 3, z, RivalRebels.ffreciever, 5, 3);
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
      this.icon3 = iconregister.func_94245_a("RivalRebels:cx");
      this.icon4 = iconregister.func_94245_a("RivalRebels:cx");
      this.icon5 = iconregister.func_94245_a("RivalRebels:cx");
      this.icon6 = iconregister.func_94245_a("RivalRebels:cx");
   }
}
