package assets.rivalrebels.common.block.machine;

import assets.rivalrebels.RivalRebels;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockForceField extends Block {
   @SideOnly(Side.CLIENT)
   IIcon icon;

   public BlockForceField() {
      super(Material.field_151592_s);
      this.func_149676_a(0.0F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
   }

   public int func_149745_a(Random random) {
      return 0;
   }

   public int idDropped(int i, Random random) {
      return 0;
   }

   public void func_149719_a(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
      int var5 = par1IBlockAccess.func_72805_g(par2, par3, par4);
      float var6 = 0.4375F;
      if (var5 == 4) {
         this.func_149676_a(0.0F, 0.0F, var6, 1.0F, 1.0F, 1.0F - var6);
      }

      if (var5 == 5) {
         this.func_149676_a(0.0F, 0.0F, var6, 1.0F, 1.0F, 1.0F - var6);
      }

      if (var5 == 2) {
         this.func_149676_a(var6, 0.0F, 0.0F, 1.0F - var6, 1.0F, 1.0F);
      }

      if (var5 == 3) {
         this.func_149676_a(var6, 0.0F, 0.0F, 1.0F - var6, 1.0F, 1.0F);
      }
   }

   public void func_149683_g() {
      this.func_149676_a(0.0F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
   }

   public AxisAlignedBB func_149668_a(World par1World, int par2, int par3, int par4) {
      int var5 = par1World.func_72805_g(par2, par3, par4);
      float var6 = 0.4375F;
      if (var5 == 4) {
         this.func_149676_a(0.0F, 0.0F, var6, 1.0F, 1.0F, 1.0F - var6);
      }

      if (var5 == 5) {
         this.func_149676_a(0.0F, 0.0F, var6, 1.0F, 1.0F, 1.0F - var6);
      }

      if (var5 == 2) {
         this.func_149676_a(var6, 0.0F, 0.0F, 1.0F - var6, 1.0F, 1.0F);
      }

      if (var5 == 3) {
         this.func_149676_a(var6, 0.0F, 0.0F, 1.0F - var6, 1.0F, 1.0F);
      }

      return super.func_149668_a(par1World, par2, par3, par4);
   }

   @SideOnly(Side.CLIENT)
   public AxisAlignedBB func_149633_g(World par1World, int par2, int par3, int par4) {
      int var5 = par1World.func_72805_g(par2, par3, par4);
      float var6 = 0.4375F;
      if (var5 == 4) {
         this.func_149676_a(0.0F, 0.0F, var6, 1.0F, 1.0F, 1.0F - var6);
      }

      if (var5 == 5) {
         this.func_149676_a(0.0F, 0.0F, var6, 1.0F, 1.0F, 1.0F - var6);
      }

      if (var5 == 2) {
         this.func_149676_a(var6, 0.0F, 0.0F, 1.0F - var6, 1.0F, 1.0F);
      }

      if (var5 == 3) {
         this.func_149676_a(var6, 0.0F, 0.0F, 1.0F - var6, 1.0F, 1.0F);
      }

      return super.func_149633_g(par1World, par2, par3, par4);
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public int func_149645_b() {
      return RivalRebels.goodRender ? -1 : 0;
   }

   public final IIcon func_149691_a(int side, int meta) {
      return this.icon;
   }

   public void func_149651_a(IIconRegister iconregister) {
      this.icon = iconregister.func_94245_a("RivalRebels:di");
   }
}
