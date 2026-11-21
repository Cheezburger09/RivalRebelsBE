package assets.rivalrebels.common.block.trap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockJump extends Block {
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

   public BlockJump() {
      super(Material.field_151583_m);
   }

   public void func_149670_a(World par1World, int par2, int par3, int par4, Entity par5Entity) {
      if (par5Entity instanceof EntityLivingBase) {
         par5Entity.field_70181_x += 2.0;
         par1World.func_72908_a(par2, par3, par4, "random.bowhit", 3.0F, 2.0F);
      }
   }

   public AxisAlignedBB func_149668_a(World par1World, int par2, int par3, int par4) {
      float f = 0.0625F;
      return AxisAlignedBB.func_72330_a(par2, par3, par4, par2 + 1, par3 + 1 - f, par4 + 1);
   }

   public AxisAlignedBB func_149633_g(World par1World, int par2, int par3, int par4) {
      return AxisAlignedBB.func_72330_a(par2, par3, par4, par2 + 1, par3 + 1, par4 + 1);
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
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
      this.icon1 = iconregister.func_94245_a("RivalRebels:ah");
      this.icon2 = iconregister.func_94245_a("RivalRebels:au");
      this.icon3 = iconregister.func_94245_a("RivalRebels:at");
      this.icon4 = iconregister.func_94245_a("RivalRebels:at");
      this.icon5 = iconregister.func_94245_a("RivalRebels:at");
      this.icon6 = iconregister.func_94245_a("RivalRebels:at");
   }
}
