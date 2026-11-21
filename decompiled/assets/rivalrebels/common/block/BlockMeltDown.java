package assets.rivalrebels.common.block;

import assets.rivalrebels.common.tileentity.TileEntityMeltDown;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockMeltDown extends BlockContainer {
   @SideOnly(Side.CLIENT)
   IIcon icon;

   public BlockMeltDown() {
      super(Material.field_151567_E);
   }

   public int func_149645_b() {
      return -1;
   }

   public AxisAlignedBB func_149668_a(World par1World, int par2, int par3, int par4) {
      return null;
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_149662_c() {
      return false;
   }

   public int func_149745_a(Random random) {
      return 0;
   }

   public TileEntity func_149915_a(World var1, int var) {
      return new TileEntityMeltDown();
   }

   public void func_149726_b(World world, int x, int y, int z) {
      world.func_147464_a(x, y, z, this, 1);
   }

   public void func_149674_a(World world, int x, int y, int z, Random par5Random) {
      int meta = world.func_72805_g(x, y, z);
      if (meta < 14) {
         world.func_147465_d(x, y + 2, z, this, meta + 1, 2);
      }
   }

   public final IIcon func_149691_a(int side, int meta) {
      return this.icon;
   }

   public void func_149651_a(IIconRegister iconregister) {
      this.icon = iconregister.func_94245_a("RivalRebels:ak");
   }
}
