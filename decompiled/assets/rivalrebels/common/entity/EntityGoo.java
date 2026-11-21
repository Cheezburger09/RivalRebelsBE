package assets.rivalrebels.common.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityGoo extends EntityInanimate {
   private boolean isGore = true;

   public EntityGoo(World par1World) {
      super(par1World);
      this.func_70105_a(0.25F, 0.25F);
   }

   public EntityGoo(World par1World, EntityGore bloodEmitter) {
      super(par1World);
      this.func_70105_a(0.25F, 0.25F);
      this.func_70012_b(bloodEmitter.field_70165_t, bloodEmitter.field_70163_u, bloodEmitter.field_70161_v, 0.0F, 0.0F);
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      this.setThrowableHeading(0.1F);
      this.isGore = true;
   }

   public EntityGoo(World par1World, double x, double y, double z) {
      super(par1World);
      this.func_70105_a(0.25F, 0.25F);
      this.func_70012_b(x, y, z, 0.0F, 0.0F);
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      this.setThrowableHeading(0.0F);
      this.isGore = false;
   }

   public void setThrowableHeading(float force) {
      this.field_70159_w = this.field_70146_Z.nextGaussian() * force;
      this.field_70181_x = this.field_70146_Z.nextGaussian() * force;
      this.field_70179_y = this.field_70146_Z.nextGaussian() * force;
   }

   public void func_70071_h_() {
      super.func_70071_h_();
      this.field_70173_aa++;
      Vec3 vec3 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      Vec3 vec31 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
      MovingObjectPosition movingobjectposition = this.field_70170_p.func_72933_a(vec3, vec31);
      vec3 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      vec31 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
      if (movingobjectposition != null || this.func_70090_H() || this.field_70173_aa == 20 && this.isGore) {
         this.func_70106_y();
      }

      this.field_70165_t = this.field_70165_t + this.field_70159_w;
      this.field_70163_u = this.field_70163_u + this.field_70181_x;
      this.field_70161_v = this.field_70161_v + this.field_70179_y;
      this.field_70159_w *= 0.99F;
      this.field_70181_x *= 0.99F;
      this.field_70179_y *= 0.99F;
      this.field_70181_x -= 0.03F;
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
   }

   @SideOnly(Side.CLIENT)
   public boolean func_70112_a(double par1) {
      return par1 < 256.0;
   }

   @Override
   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
   }

   @Override
   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
   }

   @SideOnly(Side.CLIENT)
   public float func_70053_R() {
      return 0.0F;
   }

   @Override
   public void func_70088_a() {
   }
}
