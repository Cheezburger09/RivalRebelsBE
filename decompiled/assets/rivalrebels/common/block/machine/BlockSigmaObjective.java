package assets.rivalrebels.common.block.machine;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import assets.rivalrebels.common.tileentity.TileEntitySigmaObjective;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockSigmaObjective extends BlockContainer {
   @SideOnly(Side.CLIENT)
   IIcon icon;

   public BlockSigmaObjective() {
      super(Material.field_151573_f);
      this.func_149647_a(CreativeTabs.field_78031_c);
   }

   public int func_149745_a(Random random) {
      return 0;
   }

   public void func_149726_b(World world, int x, int y, int z) {
      if (x != RivalRebels.round.sObjx || y != RivalRebels.round.sObjy || z != RivalRebels.round.sObjz) {
         world.func_147449_b(RivalRebels.round.sObjx, RivalRebels.round.sObjy, RivalRebels.round.sObjz, RivalRebels.plasmaexplosion);
         RivalRebels.round.sObjx = x;
         RivalRebels.round.sObjy = y;
         RivalRebels.round.sObjz = z;
         if (world.func_147439_a(RivalRebels.round.oObjx, RivalRebels.round.oObjy, RivalRebels.round.oObjz) == RivalRebels.omegaobj) {
            RivalRebels.round.roundManualStart();
         }
      }
   }

   public void func_149749_a(World world, int x, int y, int z, Block blockID, int par6) {
      super.func_149749_a(world, x, y, z, blockID, par6);
      if (world.func_147439_a(x, y, z) != RivalRebels.plasmaexplosion) {
         world.func_147449_b(x, y, z, blockID);
      }
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public int func_149645_b() {
      return -1;
   }

   public boolean func_149727_a(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
      RivalRebelsSoundPlayer.playSound(par1World, 10, 3, par2, par3, par4);
      return true;
   }

   public TileEntity func_149915_a(World par1World, int var) {
      return new TileEntitySigmaObjective();
   }

   public final IIcon func_149691_a(int side, int meta) {
      return this.icon;
   }

   public void func_149651_a(IIconRegister iconregister) {
      this.icon = iconregister.func_94245_a("RivalRebels:bp");
   }
}
