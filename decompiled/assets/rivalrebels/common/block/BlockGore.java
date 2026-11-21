package assets.rivalrebels.common.block;

import assets.rivalrebels.common.entity.EntityBlood;
import assets.rivalrebels.common.entity.EntityGoo;
import assets.rivalrebels.common.tileentity.TileEntityGore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockGore extends BlockContainer {
   @SideOnly(Side.CLIENT)
   IIcon icon;
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

   public BlockGore() {
      super(Material.field_151568_F);
   }

   public int func_149745_a(Random random) {
      return 0;
   }

   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
      if (player.field_71075_bZ.field_75098_d) {
         int meta = world.func_72805_g(x, y, z) + 1;
         if (meta >= 6) {
            meta = 0;
         }

         world.func_72921_c(x, y, z, meta, 3);
         return true;
      } else {
         return false;
      }
   }

   public void func_149734_b(World world, int x, int y, int z, Random random) {
      if (world.func_147439_a(x, y - 1, z) == Blocks.field_150350_a && world.func_72805_g(x, y, z) < 2) {
         world.func_72838_d(new EntityBlood(world, x + Math.random(), y + 0.9F, z + Math.random()));
      } else if (world.func_147439_a(x, y - 1, z) == Blocks.field_150350_a && world.func_72805_g(x, y, z) < 4) {
         world.func_72838_d(new EntityGoo(world, x + Math.random(), y + 0.9F, z + Math.random()));
      }
   }

   public boolean func_149686_d() {
      return false;
   }

   public int func_149645_b() {
      return -1;
   }

   public boolean func_149662_c() {
      return false;
   }

   public AxisAlignedBB func_149668_a(World par1World, int par2, int par3, int par4) {
      return null;
   }

   public AxisAlignedBB func_149633_g(World par1World, int par2, int par3, int par4) {
      return null;
   }

   public void func_149674_a(World world, int xx, int yy, int zz, Random par5Random) {
      if (world.func_147445_c(xx, yy - 1, zz, false)
         || world.func_147445_c(xx + 1, yy, zz, false)
         || world.func_147445_c(xx - 1, yy, zz, false)
         || world.func_147445_c(xx, yy, zz + 1, false)
         || world.func_147445_c(xx, yy, zz - 1, false)
         || world.func_147445_c(xx, yy + 1, zz, false)) {
         world.func_147449_b(xx, yy, zz, Blocks.field_150350_a);
      }
   }

   public void func_149670_a(World par1World, int par2, int par3, int par4, Entity entity) {
   }

   public boolean hasTileEntity(int metadata) {
      return true;
   }

   public TileEntity func_149915_a(World var1, int var) {
      return new TileEntityGore();
   }

   public final IIcon func_149691_a(int side, int meta) {
      if (meta == 0) {
         return this.icon;
      } else if (meta == 1) {
         return this.icon2;
      } else if (meta == 2) {
         return this.icon3;
      } else if (meta == 3) {
         return this.icon4;
      } else if (meta == 4) {
         return this.icon5;
      } else {
         return meta == 5 ? this.icon6 : this.icon;
      }
   }

   public void func_149651_a(IIconRegister iconregister) {
      this.icon = iconregister.func_94245_a("RivalRebels:br");
      this.icon2 = iconregister.func_94245_a("RivalRebels:bs");
      this.icon3 = iconregister.func_94245_a("RivalRebels:bt");
      this.icon4 = iconregister.func_94245_a("RivalRebels:bu");
      this.icon5 = iconregister.func_94245_a("RivalRebels:bv");
      this.icon6 = iconregister.func_94245_a("RivalRebels:bw");
   }
}
