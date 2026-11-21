package assets.rivalrebels.common.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityNukeCrate extends TileEntity {
   public void func_145839_a(NBTTagCompound par1NBTTagCompound) {
      super.func_145839_a(par1NBTTagCompound);
      this.field_145847_g = par1NBTTagCompound.func_74762_e("NuclearBombMetadata");
   }

   public void func_145841_b(NBTTagCompound par1NBTTagCompound) {
      super.func_145841_b(par1NBTTagCompound);
      par1NBTTagCompound.func_74768_a("NuclearBombMetadata", this.field_145847_g);
   }

   public void func_145845_h() {
      super.func_145845_h();
   }
}
