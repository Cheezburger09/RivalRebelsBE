package assets.rivalrebels.common.block;

import assets.rivalrebels.RivalRebels;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockLight extends Block {
   public int rendertype;
   @SideOnly(Side.CLIENT)
   IIcon icon;

   public BlockLight(int Render) {
      super(Material.field_151567_E);
      this.rendertype = Render;
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public int func_149745_a(Random random) {
      return 0;
   }

   public int func_149645_b() {
      return this.rendertype;
   }

   public AxisAlignedBB func_149668_a(World par1World, int par2, int par3, int par4) {
      return null;
   }

   public AxisAlignedBB func_149633_g(World par1World, int par2, int par3, int par4) {
      return AxisAlignedBB.func_72330_a(par2, par3, par4, par2, par3, par4);
   }

   public void func_149726_b(World world, int x, int y, int z) {
      if (this == RivalRebels.light) {
         world.func_147464_a(x, y, z, this, 10);
      }
   }

   public void func_149674_a(World par1World, int x, int y, int z, Random par5Random) {
      par1World.func_147449_b(x, y, z, Blocks.field_150350_a);
   }

   public final IIcon func_149691_a(int side, int meta) {
      return this.icon;
   }

   public void func_149651_a(IIconRegister iconregister) {
      this.icon = iconregister.func_94245_a("RivalRebels:ad");
   }
}
