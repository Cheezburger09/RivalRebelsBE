package assets.rivalrebels.common.block.trap;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsDamageSource;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import assets.rivalrebels.common.entity.EntityRoddiskLeader;
import assets.rivalrebels.common.entity.EntityRoddiskOfficer;
import assets.rivalrebels.common.entity.EntityRoddiskRebel;
import assets.rivalrebels.common.entity.EntityRoddiskRegular;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRemoteCharge extends Block {
   public boolean boom = false;
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

   public BlockRemoteCharge() {
      super(Material.field_151580_n);
      this.func_149675_a(true);
      float f = 0.0625F;
      float f1 = 0.0625F;
      float f2 = 0.5F;
      this.func_149676_a(f1, 0.0F, f, 1.0F - f, f2, 1.0F - f);
   }

   public int func_149745_a(Random par1Random) {
      return 0;
   }

   public void func_149719_a(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
      int i = par1IBlockAccess.func_72805_g(par2, par3, par4);
      float f = 0.0625F;
      float f1 = (1 + i * 2) / 16.0F;
      float f2 = 0.5F;
      this.func_149676_a(f1, 0.0F, f, 1.0F - f, f2, 1.0F - f);
   }

   public AxisAlignedBB func_149668_a(World par1World, int par2, int par3, int par4) {
      int i = par1World.func_72805_g(par2, par3, par4);
      float f = 0.0625F;
      float f1 = (1 + i * 2) / 16.0F;
      float f2 = 0.5F;
      return AxisAlignedBB.func_72330_a(par2 + f1, par3, par4 + f, par2 + 1 - f, par3 + f2 - f, par4 + 1 - f);
   }

   public int func_149738_a(World par1World) {
      return 1;
   }

   public AxisAlignedBB func_149633_g(World par1World, int par2, int par3, int par4) {
      int i = par1World.func_72805_g(par2, par3, par4);
      float f = 0.0625F;
      float f1 = (1 + i * 2) / 16.0F;
      float f2 = 0.5F;
      return AxisAlignedBB.func_72330_a(par2 + f1, par3, par4 + f, par2 + 1 - f, par3 + f2, par4 + 1 - f);
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_149662_c() {
      return false;
   }

   public void func_149664_b(World world, int x, int y, int z, int l) {
      explode(world, x, y, z);
   }

   public void func_149723_a(World world, int x, int y, int z, Explosion explosion) {
      explode(world, x, y, z);
   }

   public void func_149726_b(World world, int x, int y, int z) {
      world.func_147464_a(x, y, z, this, this.func_149738_a(world));
   }

   public void func_149674_a(World world, int x, int y, int z, Random rand) {
      if (world.func_147439_a(x + 1, y, z) == Blocks.field_150480_ab
         || world.func_147439_a(x - 1, y, z) == Blocks.field_150480_ab
         || world.func_147439_a(x, y + 1, z) == Blocks.field_150480_ab
         || world.func_147439_a(x, y - 1, z) == Blocks.field_150480_ab
         || world.func_147439_a(x, y, z + 1) == Blocks.field_150480_ab
         || world.func_147439_a(x, y, z - 1) == Blocks.field_150480_ab) {
         explode(world, x, y, z);
      }

      if (this.boom) {
         explode(world, x, y, z);
         this.boom = false;
      }

      world.func_147464_a(x, y, z, this, this.func_149738_a(world));
   }

   public void func_149670_a(World world, int x, int y, int z, Entity entity) {
      if (entity instanceof EntityRoddiskRegular
         || entity instanceof EntityRoddiskRebel
         || entity instanceof EntityRoddiskOfficer
         || entity instanceof EntityRoddiskLeader) {
         explode(world, x, y, z);
      }
   }

   public static void explode(World world, int x, int y, int z) {
      world.func_147449_b(x, y, z, Blocks.field_150350_a);
      new assets.rivalrebels.common.explosion.Explosion(
         world, x + 0.5F, y + 0.5F, z + 0.5F, RivalRebels.chargeExplodeSize, false, false, RivalRebelsDamageSource.charge
      );
      RivalRebelsSoundPlayer.playSound(world, 22, 0, x, y, z, 1.0F, 0.3F);
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
      this.icon1 = iconregister.func_94245_a("RivalRebels:ag");
      this.icon2 = iconregister.func_94245_a("RivalRebels:ag");
      this.icon3 = iconregister.func_94245_a("RivalRebels:af");
      this.icon4 = iconregister.func_94245_a("RivalRebels:af");
      this.icon5 = iconregister.func_94245_a("RivalRebels:af");
      this.icon6 = iconregister.func_94245_a("RivalRebels:af");
   }

   public void onFinishFalling(World par1World, int par2, int par3, int par4, int par5) {
      explode(par1World, par2, par3, par4);
   }
}
