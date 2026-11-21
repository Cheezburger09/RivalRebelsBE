package assets.rivalrebels.common.block.trap;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsDamageSource;
import assets.rivalrebels.common.explosion.Explosion;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockFlare extends Block {
   @SideOnly(Side.CLIENT)
   IIcon icon;

   public BlockFlare() {
      super(Material.field_151575_d);
   }

   public AxisAlignedBB func_149668_a(World par1World, int par2, int par3, int i) {
      return null;
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public int func_149645_b() {
      return 2;
   }

   private boolean canPlaceTorchOn(World par1World, int par2, int par3, int par4) {
      if (par1World.func_147445_c(par2, par3, par4, true)) {
         return true;
      }

      Block i = par1World.func_147439_a(par2, par3, par4);
      if (i != Blocks.field_150422_aJ && i != Blocks.field_150386_bk && i != Blocks.field_150359_w) {
         if (i != null && i instanceof BlockStairs) {
            int j = par1World.func_72805_g(par2, par3, par4);
            if ((4 & j) != 0) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }

   public boolean func_149742_c(World par1World, int par2, int par3, int par4) {
      return this.canPlaceTorchOn(par1World, par2, par3 - 1, par4);
   }

   public void onBlockPlaced(World par1World, int par2, int par3, int par4, int par5) {
      int i = par1World.func_72805_g(par2, par3, par4);
      if (par5 == 1 && this.canPlaceTorchOn(par1World, par2, par3 - 1, par4)) {
         i = 5;
      }

      if (par5 == 2 && par1World.func_147445_c(par2, par3, par4 + 1, true)) {
         i = 4;
      }

      if (par5 == 3 && par1World.func_147445_c(par2, par3, par4 - 1, true)) {
         i = 3;
      }

      if (par5 == 4 && par1World.func_147445_c(par2 + 1, par3, par4, true)) {
         i = 2;
      }

      if (par5 == 5 && par1World.func_147445_c(par2 - 1, par3, par4, true)) {
         i = 1;
      }

      par1World.func_72921_c(par2, par3, par4, i, 0);
      par1World.func_147464_a(par2, par3, par4, this, 1);
   }

   public void func_149734_b(World world, int x, int y, int z, Random par5Random) {
      world.func_72869_a("lava", x + 0.5, y + 0.6, z + 0.5, 0.0, 0.5, 0.0);
      world.func_72869_a("lava", x + 0.5, y + 0.8, z + 0.5, 0.0, 0.5, 0.0);
      world.func_72869_a("lava", x + 0.5, y + 1, z + 0.5, 0.0, 0.5, 0.0);
      world.func_72869_a(
         "flame",
         x + 0.5,
         y + 1.2,
         z + 0.5,
         (-0.5 + world.field_73012_v.nextFloat()) * 0.1,
         0.5 + world.field_73012_v.nextFloat() * 0.5,
         (-0.5 + world.field_73012_v.nextFloat()) * 0.1
      );
      world.func_72869_a(
         "flame",
         x + 0.5,
         y + 1.4,
         z + 0.5,
         (-0.5 + world.field_73012_v.nextFloat()) * 0.1,
         0.5 + world.field_73012_v.nextFloat() * 0.5,
         (-0.5 + world.field_73012_v.nextFloat()) * 0.1
      );
      world.func_72869_a(
         "smoke",
         x + 0.5,
         y + 1.6,
         z + 0.5,
         (-0.5 + world.field_73012_v.nextFloat()) * 0.1,
         0.5 + world.field_73012_v.nextFloat() * 0.5,
         (-0.5 + world.field_73012_v.nextFloat()) * 0.1
      );
      world.func_72908_a(x, y, z, "random.fizz", 3.0F, 2.0F);
   }

   public void func_149674_a(World world, int x, int y, int z, Random random) {
      world.func_147464_a(x, y, z, this, 1);
      if (world.func_147439_a(x + 1, y, z) == Blocks.field_150355_j
         || world.func_147439_a(x - 1, y, z) == Blocks.field_150355_j
         || world.func_147439_a(x, y, z + 1) == Blocks.field_150355_j
         || world.func_147439_a(x, y, z - 1) == Blocks.field_150355_j) {
         world.func_147449_b(x, y, z, Blocks.field_150350_a);
         world.func_72838_d(new EntityItem(world, x, y, z, new ItemStack(RivalRebels.flare)));
      }
   }

   public void func_149664_b(World world, int x, int y, int z, int m) {
      if (RivalRebels.flareExplode) {
         world.func_147449_b(x, y, z, Blocks.field_150350_a);
         new Explosion(world, x, y, z, 3, true, false, RivalRebelsDamageSource.flare);
         world.func_72908_a(x, y, z, "random.explode", 0.5F, 0.3F);
      }
   }

   public void func_149670_a(World par1World, int par2, int par3, int par4, Entity par5Entity) {
      par5Entity.func_70097_a(RivalRebelsDamageSource.flare, 1.0F);
      par5Entity.func_70015_d(5);
   }

   public int func_149745_a(Random random) {
      return 0;
   }

   public final IIcon func_149691_a(int side, int meta) {
      return this.icon;
   }

   public void func_149651_a(IIconRegister iconregister) {
      this.icon = iconregister.func_94245_a("RivalRebels:an");
   }
}
