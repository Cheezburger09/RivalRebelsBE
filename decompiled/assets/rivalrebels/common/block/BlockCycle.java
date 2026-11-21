package assets.rivalrebels.common.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCycle extends Block {
   float phase = 0.0F;
   float phaseadd = (float) (Math.PI / 18);
   float pShiftR = 0.0F;
   float pShiftG = (float) (Math.PI * 2.0 / 3.0);
   float pShiftB = (float) (Math.PI * 4.0 / 3.0);
   @SideOnly(Side.CLIENT)
   IIcon icon;

   public BlockCycle() {
      super(Material.field_151573_f);
   }

   public void func_149726_b(World world, int x, int y, int z) {
      world.func_147464_a(x, y, z, this, 1);
   }

   public int func_149720_d(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
      this.phase = this.phase + this.phaseadd;
      int r = (int)((Math.sin(this.phase + this.pShiftR) + 1.0) * 128.0);
      int g = (int)((Math.sin(this.phase + this.pShiftG) + 1.0) * 128.0);
      int b = (int)((Math.sin(this.phase + this.pShiftB) + 1.0) * 128.0);
      return (r & 0xFF) << 16 | (g & 0xFF) << 8 | b & 0xFF;
   }

   public void func_149674_a(World world, int par2, int par3, int par4, Random par5Random) {
      world.func_147464_a(par2, par3, par4, this, 1);
      world.func_147449_b(par2, par3, par4, Blocks.field_150350_a);
      world.func_147449_b(par2, par3, par4, this);
   }

   public final IIcon func_149691_a(int side, int meta) {
      return this.icon;
   }

   public void func_149651_a(IIconRegister iconregister) {
      this.icon = iconregister.func_94245_a("RivalRebels:ak");
   }
}
