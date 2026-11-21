package assets.rivalrebels.common.block;

import assets.rivalrebels.common.tileentity.TileEntityReactive;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockReactive extends BlockContainer {
   @SideOnly(Side.CLIENT)
   IIcon icon;
   @SideOnly(Side.CLIENT)
   IIcon icontop;

   public BlockReactive() {
      super(Material.field_151573_f);
   }

   public void func_149749_a(World world, int i, int j, int k, Block l, int s) {
      super.func_149749_a(world, i, j, k, l, s);
      if (s < 15 && s >= 0) {
         world.func_147465_d(i, j, k, this, s + 1, 2);
      }
   }

   public boolean func_149716_u() {
      return true;
   }

   @SideOnly(Side.CLIENT)
   public int func_149720_d(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
      return (15 - par1IBlockAccess.func_72805_g(par2, par3, par4)) * 1118481;
   }

   public int func_149745_a(Random par1Random) {
      return 0;
   }

   public final IIcon func_149691_a(int side, int meta) {
      return side != 0 && side != 1 ? this.icon : this.icontop;
   }

   public void func_149651_a(IIconRegister iconregister) {
      this.icon = iconregister.func_94245_a("RivalRebels:cf");
      this.icontop = iconregister.func_94245_a("RivalRebels:cn");
   }

   public TileEntity func_149915_a(World world, int var) {
      return new TileEntityReactive();
   }
}
