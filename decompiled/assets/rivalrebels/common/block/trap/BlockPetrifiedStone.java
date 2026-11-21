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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPetrifiedStone extends Block {
   public String type = "b";
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

   public BlockPetrifiedStone(String type) {
      super(Material.field_151576_e);
      this.type = type;
   }

   public int func_149745_a(Random random) {
      return 1;
   }

   @SideOnly(Side.CLIENT)
   public int func_149635_D() {
      return 4473924;
   }

   public void func_149724_b(World world, int par2, int par3, int par4, Entity entity) {
      if (world.field_73012_v.nextInt(2) == 0) {
         entity.func_70097_a(RivalRebelsDamageSource.radioactivepoisoning, (16 - world.func_72805_g(par2, par3, par4)) / 2 + world.field_73012_v.nextInt(3) - 1);
      }
   }

   @SideOnly(Side.CLIENT)
   public int func_149741_i(int par1) {
      return 4473924;
   }

   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
      if (player.field_71075_bZ.field_75098_d) {
         world.func_72921_c(x, y, z, world.func_72805_g(x, y, z) + 1, 3);
         return true;
      } else {
         return false;
      }
   }

   public void func_149689_a(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack) {
      if (entity instanceof EntityPlayer) {
         world.func_72921_c(x, y, z, 7, 3);
      }
   }

   @SideOnly(Side.CLIENT)
   public int func_149720_d(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
      return par1IBlockAccess.func_72805_g(par2, par3, par4) * 1118481;
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
      this.icon1 = iconregister.func_94245_a("RivalRebels:b" + this.type);
      this.icon2 = iconregister.func_94245_a("RivalRebels:b" + this.type);
      this.icon3 = iconregister.func_94245_a("RivalRebels:bb");
      this.icon4 = iconregister.func_94245_a("RivalRebels:bb");
      this.icon5 = iconregister.func_94245_a("RivalRebels:bb");
      this.icon6 = iconregister.func_94245_a("RivalRebels:bb");
   }
}
