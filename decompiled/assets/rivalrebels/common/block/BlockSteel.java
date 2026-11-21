package assets.rivalrebels.common.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockSteel extends Block {
   @SideOnly(Side.CLIENT)
   IIcon icon;

   public BlockSteel() {
      super(Material.field_151573_f);
   }

   public boolean func_149686_d() {
      return false;
   }

   public int func_149645_b() {
      return 485;
   }

   public boolean func_149662_c() {
      return false;
   }

   public AxisAlignedBB func_149668_a(World par1World, int par2, int par3, int par4) {
      float f = 0.0625F;
      return AxisAlignedBB.func_72330_a(par2 + f, par3 + f, par4 + f, par2 + 1 - f, par3 + 1.0F, par4 + 1 - f);
   }

   public void func_149670_a(World par1World, int par2, int par3, int par4, Entity entity) {
      if (entity.func_70093_af() && !entity.field_70123_F) {
         entity.field_70181_x = 0.08;
         entity.field_70143_R = 0.0F;
      } else if (entity.field_70123_F) {
         entity.field_70181_x = 0.25;
         entity.field_70143_R = 0.0F;
      } else if (!entity.field_70122_E) {
         if (entity.field_70124_G) {
            entity.field_70181_x = 0.08;
            entity.field_70143_R = 0.0F;
         } else {
            entity.field_70181_x = -0.1;
            entity.field_70143_R = 0.0F;
         }
      }
   }

   public boolean hasTileEntity(int metadata) {
      return true;
   }

   public final IIcon func_149691_a(int side, int meta) {
      return this.icon;
   }

   public void func_149651_a(IIconRegister iconregister) {
      this.icon = iconregister.func_94245_a("RivalRebels:bx");
   }
}
