package assets.rivalrebels.common.block.machine;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import assets.rivalrebels.common.tileentity.TileEntityMachineBase;
import assets.rivalrebels.common.tileentity.TileEntityReactor;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
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

public class BlockReactor extends BlockContainer {
   @SideOnly(Side.CLIENT)
   IIcon icon;

   public BlockReactor() {
      super(Material.field_151573_f);
   }

   public int func_149645_b() {
      return -1;
   }

   public int func_149745_a(Random random) {
      return 1;
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

      if (par6ItemStack.func_82837_s()) {
      }
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_149662_c() {
      return false;
   }

   public TileEntity func_149915_a(World var1, int var) {
      return new TileEntityReactor();
   }

   public boolean func_149727_a(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
      if (!par1World.field_72995_K) {
         FMLNetworkHandler.openGui(par5EntityPlayer, RivalRebels.instance, 0, par1World, par2, par3, par4);
      }

      RivalRebelsSoundPlayer.playSound(par1World, 10, 3, par2, par3, par4);
      return true;
   }

   public void func_149749_a(World world, int x, int y, int z, Block id, int meta) {
      TileEntity te = world.func_147438_o(x, y, z);
      if (te != null && te instanceof TileEntityReactor) {
         TileEntityReactor ter = (TileEntityReactor)te;
         ter.on = false;

         for (TileEntity var12 : world.field_147482_g) {
            if (var12 != null && var12 instanceof TileEntityMachineBase) {
               TileEntityMachineBase temb = (TileEntityMachineBase)var12;
               if (temb.x == x && temb.y == y && temb.z == z) {
                  temb.x = temb.y = temb.z = 0;
                  temb.edist = 0.0F;
               }
            }
         }
      }

      super.func_149749_a(world, x, y, z, id, meta);
   }

   public final IIcon func_149691_a(int side, int meta) {
      return this.icon;
   }

   public void func_149651_a(IIconRegister iconregister) {
      this.icon = iconregister.func_94245_a("RivalRebels:bj");
   }
}
