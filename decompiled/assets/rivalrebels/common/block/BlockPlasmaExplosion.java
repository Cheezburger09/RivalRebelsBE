package assets.rivalrebels.common.block;

import assets.rivalrebels.common.tileentity.TileEntityPlasmaExplosion;
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

public class BlockPlasmaExplosion extends BlockContainer {
   @SideOnly(Side.CLIENT)
   IIcon icon;

   public BlockPlasmaExplosion() {
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
      return new TileEntityPlasmaExplosion();
   }

   public final IIcon func_149691_a(int side, int meta) {
      return this.icon;
   }

   public void func_149651_a(IIconRegister iconregister) {
      this.icon = iconregister.func_94245_a("RivalRebels:ak");
   }
}
