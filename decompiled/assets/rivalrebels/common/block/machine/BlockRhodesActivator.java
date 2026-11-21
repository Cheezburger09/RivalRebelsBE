package assets.rivalrebels.common.block.machine;

import assets.rivalrebels.common.tileentity.TileEntityRhodesActivator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockRhodesActivator extends BlockContainer {
   @SideOnly(Side.CLIENT)
   IIcon icon;
   @SideOnly(Side.CLIENT)
   IIcon icontop;

   public BlockRhodesActivator() {
      super(Material.field_151573_f);
   }

   public boolean func_149686_d() {
      return true;
   }

   public boolean func_149662_c() {
      return true;
   }

   public boolean hasTileEntity(int metadata) {
      return true;
   }

   public TileEntity func_149915_a(World var1, int var) {
      return new TileEntityRhodesActivator();
   }

   public final IIcon func_149691_a(int side, int meta) {
      return side != 0 && side != 1 ? this.icon : this.icontop;
   }

   public void func_149651_a(IIconRegister iconregister) {
      this.icon = iconregister.func_94245_a("RivalRebels:ci");
      this.icontop = iconregister.func_94245_a("RivalRebels:ch");
   }
}
