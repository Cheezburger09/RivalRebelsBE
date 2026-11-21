package assets.rivalrebels.common.block.trap;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.tileentity.TileEntityNuclearBomb;
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
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockNuclearBomb extends BlockContainer {
   public int orientation;
   @SideOnly(Side.CLIENT)
   IIcon icon;

   public BlockNuclearBomb() {
      super(Material.field_151573_f);
   }

   public int func_149745_a(Random par1Random) {
      return 0;
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

   public static int determineOrientation(World world, int x, int y, int z, EntityPlayer entity) {
      if (MathHelper.func_76135_e((float)entity.field_70165_t - x) < 2.0F && MathHelper.func_76135_e((float)entity.field_70161_v - z) < 2.0F) {
         double var5 = entity.field_70163_u + 1.82 - entity.field_70129_M;
         if (var5 - y > 2.0) {
            return 1;
         }

         if (y - var5 > 0.0) {
            return 0;
         }
      }

      int var7 = MathHelper.func_76128_c(entity.field_70177_z * 4.0F / 360.0F + 0.5) & 3;
      return var7 == 0 ? 2 : (var7 == 1 ? 5 : (var7 == 2 ? 3 : (var7 == 3 ? 4 : 0)));
   }

   public void func_149689_a(World world, int x, int y, int z, EntityLivingBase entity, ItemStack i) {
      if (MathHelper.func_76135_e((float)entity.field_70165_t - x) < 2.0F && MathHelper.func_76135_e((float)entity.field_70161_v - z) < 2.0F) {
         double var5x = entity.field_70163_u + 1.82 - entity.field_70129_M;
         if (var5x - y > 2.0) {
            world.func_72921_c(x, y, z, 1, 0);
            return;
         }

         if (y - var5x > 0.0) {
            world.func_72921_c(x, y, z, 0, 0);
            return;
         }
      }

      int var7 = MathHelper.func_76128_c(entity.field_70177_z * 4.0F / 360.0F + 0.5) & 3;
      world.func_72921_c(x, y, z, var7 == 0 ? 2 : (var7 == 1 ? 5 : (var7 == 2 ? 3 : (var7 == 3 ? 4 : 0))), 0);
   }

   public boolean func_149727_a(World par1World, int x, int y, int z, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
      if (!par5EntityPlayer.func_70093_af()) {
         if (par5EntityPlayer.field_71071_by.func_70448_g() != null && par5EntityPlayer.field_71071_by.func_70448_g().func_77973_b() == RivalRebels.pliers) {
            FMLNetworkHandler.openGui(par5EntityPlayer, RivalRebels.instance, 0, par1World, x, y, z);
         } else if (!par1World.field_72995_K) {
            par5EntityPlayer.func_145747_a(new ChatComponentText("§7[§4Orders§7] §cUse pliers to open."));
         }
      }

      return false;
   }

   public boolean hasTileEntity(int metadata) {
      return true;
   }

   public TileEntity func_149915_a(World par1World, int var) {
      return new TileEntityNuclearBomb();
   }

   public final IIcon func_149691_a(int side, int meta) {
      return this.icon;
   }

   public void func_149651_a(IIconRegister iconregister) {
      this.icon = iconregister.func_94245_a("RivalRebels:ak");
   }
}
