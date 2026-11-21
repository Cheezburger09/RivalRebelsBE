package assets.rivalrebels.common.block.trap;

import assets.rivalrebels.common.core.RivalRebelsDamageSource;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockToxicGas extends Block {
   @SideOnly(Side.CLIENT)
   IIcon icon;

   public BlockToxicGas() {
      super(Material.field_151570_A);
      this.func_149675_a(true);
   }

   public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
      return 300;
   }

   public int func_149745_a(Random random) {
      return 0;
   }

   public AxisAlignedBB func_149668_a(World par1World, int par2, int par3, int par4) {
      return null;
   }

   public AxisAlignedBB func_149633_g(World par1World, int par2, int par3, int par4) {
      return AxisAlignedBB.func_72330_a(par2, par3, par4, par2, par3, par4);
   }

   public void func_149670_a(World par1World, int par2, int par3, int par4, Entity entity) {
      if (entity instanceof EntityPlayer) {
         ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_76436_u.field_76415_H, 200, 0));
         ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_76431_k.field_76415_H, 200, 0));
         ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_76440_q.field_76415_H, 80, 0));
         ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, 80, 0));
      }

      if (entity instanceof EntityMob || entity instanceof EntityAnimal || entity instanceof EntityPlayer) {
         entity.func_70097_a(RivalRebelsDamageSource.gasgrenade, 1.0F);
      }
   }

   public int func_149645_b() {
      return -1;
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_149662_c() {
      return false;
   }

   public void func_149726_b(World world, int x, int y, int z) {
      world.func_147464_a(x, y, z, this, 8);
   }

   public void func_149674_a(World par1World, int x, int y, int z, Random par5Random) {
      par1World.func_147464_a(x, y, z, this, 8);
      if (par1World.field_73012_v.nextInt(25) == 1) {
         par1World.func_147449_b(x, y, z, Blocks.field_150350_a);
      }
   }

   public void func_149734_b(World w, int x, int y, int z, Random r) {
      w.func_72869_a("smoke", x + 0.5, y + 0.5, z + 0.5, (r.nextFloat() - 0.5) * 0.1, (r.nextFloat() - 0.5) * 0.1, (r.nextFloat() - 0.5) * 0.1);
      w.func_72869_a("spell", x + 0.5, y + 0.5, z + 0.5, (r.nextFloat() - 0.5) * 0.1, (r.nextFloat() - 0.5) * 0.1, (r.nextFloat() - 0.5) * 0.1);
   }

   public final IIcon func_149691_a(int side, int meta) {
      return this.icon;
   }

   public void func_149651_a(IIconRegister iconregister) {
      this.icon = iconregister.func_94245_a("RivalRebels:ak");
   }
}
