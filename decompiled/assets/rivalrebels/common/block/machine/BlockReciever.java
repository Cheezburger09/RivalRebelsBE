package assets.rivalrebels.common.block.machine;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import assets.rivalrebels.common.tileentity.TileEntityReciever;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockReciever extends BlockContainer {
   @SideOnly(Side.CLIENT)
   IIcon icon;

   public BlockReciever() {
      super(Material.field_151573_f);
   }

   public int func_149745_a(Random par1Random) {
      return 0;
   }

   public void func_149689_a(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLiving, ItemStack par6ItemStack) {
      int l = MathHelper.func_76128_c(par5EntityLiving.field_70177_z * 4.0F / 360.0F + 0.5) & 3;
      if (l == 0) {
         par1World.func_72921_c(par2, par3, par4, 2, 2);
      }

      if (l == 1) {
         par1World.func_72921_c(par2, par3, par4, 5, 2);
      }

      if (l == 2) {
         par1World.func_72921_c(par2, par3, par4, 3, 2);
      }

      if (l == 3) {
         par1World.func_72921_c(par2, par3, par4, 4, 2);
      }
   }

   public boolean hasTileEntity(int metadata) {
      return true;
   }

   public TileEntity func_149915_a(World var1, int var) {
      return new TileEntityReciever();
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

   public boolean func_149727_a(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
      if (!par1World.field_72995_K) {
         FMLNetworkHandler.openGui(par5EntityPlayer, RivalRebels.instance, 0, par1World, par2, par3, par4);
      }

      RivalRebelsSoundPlayer.playSound(par1World, 10, 3, par2, par3, par4);
      return true;
   }

   public final IIcon func_149691_a(int side, int meta) {
      return this.icon;
   }

   public void func_149651_a(IIconRegister iconregister) {
      this.icon = iconregister.func_94245_a("RivalRebels:dj");
   }
}
