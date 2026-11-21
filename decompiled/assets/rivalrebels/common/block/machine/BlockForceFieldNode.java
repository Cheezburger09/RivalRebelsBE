package assets.rivalrebels.common.block.machine;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import assets.rivalrebels.common.item.ItemChip;
import assets.rivalrebels.common.round.RivalRebelsTeam;
import assets.rivalrebels.common.tileentity.TileEntityForceFieldNode;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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

public class BlockForceFieldNode extends BlockContainer {
   @SideOnly(Side.CLIENT)
   IIcon icon;
   @SideOnly(Side.CLIENT)
   IIcon icon2;
   @SideOnly(Side.CLIENT)
   IIcon icontop1;
   @SideOnly(Side.CLIENT)
   IIcon icontop2;
   @SideOnly(Side.CLIENT)
   IIcon icontop3;
   @SideOnly(Side.CLIENT)
   IIcon icontop4;

   public BlockForceFieldNode() {
      super(Material.field_151573_f);
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
      TileEntity te = world.func_147438_o(x, y, z);
      if (te instanceof TileEntityForceFieldNode && !world.field_72995_K) {
         TileEntityForceFieldNode teffn = (TileEntityForceFieldNode)te;
         ItemStack is = player.field_71071_by.func_70448_g();
         if (is != null
            && is.func_77973_b() instanceof ItemChip
            && (teffn.username == null || teffn.username.equals(""))
            && (teffn.rrteam == null || teffn.rrteam == RivalRebelsTeam.NONE)) {
            teffn.rrteam = RivalRebels.round.rrplayerlist.getForName(player.func_70005_c_()).rrteam;
            if (teffn.rrteam == RivalRebelsTeam.NONE || teffn.rrteam == null) {
               teffn.username = player.func_70005_c_();
               teffn.rrteam = null;
            }

            RivalRebelsSoundPlayer.playSound(world, 10, 5, x, y, z);
         }
      }

      return false;
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
      return new TileEntityForceFieldNode();
   }

   public final IIcon func_149691_a(int side, int meta) {
      if (meta == 0) {
         if (side == 0 || side == 1) {
            return this.icontop2;
         } else {
            return side == 4 ? this.icon2 : this.icon;
         }
      } else if (side != 0 && side != 1) {
         return side == meta ? this.icon2 : this.icon;
      } else {
         return meta == 3 ? this.icontop1 : (meta == 4 ? this.icontop2 : (meta == 2 ? this.icontop3 : this.icontop4));
      }
   }

   public void func_149651_a(IIconRegister iconregister) {
      this.icon = iconregister.func_94245_a("RivalRebels:cf");
      this.icon2 = iconregister.func_94245_a("RivalRebels:cg");
      this.icontop1 = iconregister.func_94245_a("RivalRebels:cj");
      this.icontop2 = iconregister.func_94245_a("RivalRebels:ck");
      this.icontop3 = iconregister.func_94245_a("RivalRebels:cl");
      this.icontop4 = iconregister.func_94245_a("RivalRebels:cm");
   }
}
