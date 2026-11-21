package assets.rivalrebels.common.entity;

import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityPropulsionFX extends EntityThrowable {
   private int ticksInAir;

   public EntityPropulsionFX(World par1World) {
      super(par1World);
      this.ticksInAir = 0;
      this.func_70105_a(0.1F, 0.1F);
   }

   public EntityPropulsionFX(World par1World, double par2, double par4, double par6) {
      super(par1World);
      par4 += -0.2;
      this.ticksInAir = 0;
      this.func_70105_a(0.5F, 0.5F);
      this.func_70107_b(par2, par4, par6);
      this.field_70129_M = 0.0F;
   }

   public EntityPropulsionFX(World world2, double x, double y, double z, double mX, double mY, double mZ) {
      super(world2);
      this.ticksInAir = 0;
      this.func_70105_a(0.5F, 0.5F);
      this.func_70107_b(x, y, z);
      this.func_70016_h(mX, mY, mZ);
      this.field_70129_M = 0.0F;
   }

   public void func_70016_h(double mX, double mY, double mZ) {
      this.field_70159_w = mX;
      this.field_70181_x = mY;
      this.field_70179_y = mZ;
   }

   public int func_70070_b(float par1) {
      return 1000;
   }

   public float func_70013_c(float par1) {
      return 1000.0F;
   }

   public boolean func_70112_a(double par1) {
      return true;
   }

   public void func_70071_h_() {
      super.func_70071_h_();
      this.ticksInAir++;
      if (this.ticksInAir >= 5 && this.field_70170_p.field_73012_v.nextInt(2) == 1 || this.field_70171_ac) {
         this.func_70106_y();
      }

      this.field_70163_u += 0.005;
      this.field_70165_t = this.field_70165_t + (this.field_70170_p.field_73012_v.nextDouble() - 0.5) * 0.07;
      this.field_70163_u = this.field_70163_u + (this.field_70170_p.field_73012_v.nextDouble() - 0.5) * 0.07;
      this.field_70161_v = this.field_70161_v + (this.field_70170_p.field_73012_v.nextDouble() - 0.5) * 0.07;
      this.field_70165_t = this.field_70165_t + this.field_70159_w;
      this.field_70163_u = this.field_70163_u + this.field_70181_x;
      this.field_70161_v = this.field_70161_v + this.field_70179_y;
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
   }

   public void func_70037_a(NBTTagCompound var1) {
   }

   public void func_70014_b(NBTTagCompound var1) {
   }

   protected float func_70185_h() {
      return 0.0F;
   }

   protected void func_70184_a(MovingObjectPosition var1) {
   }
}
