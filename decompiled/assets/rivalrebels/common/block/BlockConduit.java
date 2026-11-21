package assets.rivalrebels.common.block;

import assets.rivalrebels.common.tileentity.TileEntityConduit;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockConduit extends BlockContainer {
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
   @SideOnly(Side.CLIENT)
   IIcon icon7;
   @SideOnly(Side.CLIENT)
   IIcon icon8;
   @SideOnly(Side.CLIENT)
   IIcon icon9;

   public BlockConduit() {
      super(Material.field_151573_f);
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_149662_c() {
      return false;
   }

   public void func_149689_a(World world, int x, int y, int z, EntityLivingBase par5EntityLiving, ItemStack par6ItemStack) {
      world.func_147465_d(x, y, z, this, new Random().nextInt(9) + 1, 3);
   }

   public boolean hasTileEntity(int metadata) {
      return true;
   }

   public TileEntity func_149915_a(World var1, int var2) {
      return new TileEntityConduit();
   }

   public final IIcon func_149691_a(int side, int meta) {
      if (meta == 1) {
         return this.icon1;
      } else if (meta == 2) {
         return this.icon2;
      } else if (meta == 3) {
         return this.icon3;
      } else if (meta == 4) {
         return this.icon4;
      } else if (meta == 5) {
         return this.icon5;
      } else if (meta == 6) {
         return this.icon6;
      } else if (meta == 7) {
         return this.icon7;
      } else if (meta == 8) {
         return this.icon8;
      } else {
         return meta == 9 ? this.icon9 : this.icon1;
      }
   }

   public void func_149651_a(IIconRegister iconregister) {
      this.icon1 = iconregister.func_94245_a("RivalRebels:co");
      this.icon2 = iconregister.func_94245_a("RivalRebels:cp");
      this.icon3 = iconregister.func_94245_a("RivalRebels:cq");
      this.icon4 = iconregister.func_94245_a("RivalRebels:cr");
      this.icon5 = iconregister.func_94245_a("RivalRebels:cs");
      this.icon6 = iconregister.func_94245_a("RivalRebels:ct");
      this.icon7 = iconregister.func_94245_a("RivalRebels:cu");
      this.icon8 = iconregister.func_94245_a("RivalRebels:cv");
      this.icon9 = iconregister.func_94245_a("RivalRebels:cw");
   }
}
