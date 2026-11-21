package assets.rivalrebels.common.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public abstract class TileEntityMachineBase extends TileEntity {
   public float pInM = 0.0F;
   public float pInR = 0.0F;
   public float edist = 0.0F;
   public float decay = 0.0F;
   public float powerGiven = 0.0F;
   public int x = 0;
   public int y = 0;
   public int z = 0;

   public void func_145845_h() {
      super.func_145845_h();
      if (this.pInR > 0.0F) {
         this.pInR = this.powered(this.pInR, this.edist);
      }

      this.pInR = this.pInR - this.decay;
   }

   public void func_145839_a(NBTTagCompound nbt) {
      super.func_145839_a(nbt);
      this.x = nbt.func_74762_e("rx");
      this.y = nbt.func_74762_e("ry");
      this.z = nbt.func_74762_e("rz");
      this.edist = nbt.func_74760_g("edist");
   }

   public void func_145841_b(NBTTagCompound nbt) {
      super.func_145841_b(nbt);
      nbt.func_74768_a("rx", this.x);
      nbt.func_74768_a("ry", this.y);
      nbt.func_74768_a("rz", this.z);
      nbt.func_74776_a("edist", this.edist);
   }

   public void func_145843_s() {
      super.func_145843_s();
      TileEntity connectedTo = this.field_145850_b.func_147438_o(this.x, this.y, this.z);
      if (connectedTo != null && connectedTo instanceof TileEntityReactor) {
         ((TileEntityReactor)connectedTo).machines.remove(this);
      }
   }

   public abstract float powered(float var1, float var2);
}
