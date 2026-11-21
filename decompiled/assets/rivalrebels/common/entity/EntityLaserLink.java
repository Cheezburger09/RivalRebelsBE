package assets.rivalrebels.common.entity;

import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityLaserLink extends EntityInanimate {
   public Random field_70146_Z = new Random();
   public Long randLong = this.field_70146_Z.nextLong();
   public int field_70173_aa;
   public EntityPlayer shooter;

   public EntityLaserLink(World par1World) {
      super(par1World);
      this.field_70158_ak = true;
   }

   public EntityLaserLink(World par1World, EntityPlayer player, double distance) {
      this(par1World);
      this.shooter = player;
      this.field_70173_aa = 0;
      this.field_70159_w = distance / 100.0;
      this.func_70012_b(
         this.shooter.field_70165_t,
         this.shooter.field_70163_u + this.shooter.func_70047_e(),
         this.shooter.field_70161_v,
         this.shooter.field_70177_z,
         this.shooter.field_70125_A
      );
      this.field_70165_t = this.field_70165_t - MathHelper.func_76134_b(this.field_70177_z / 180.0F * (float) Math.PI) * 0.2F;
      this.field_70163_u -= 0.08;
      this.field_70161_v = this.field_70161_v - MathHelper.func_76126_a(this.field_70177_z / 180.0F * (float) Math.PI) * 0.2F;
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      this.field_70129_M = 0.0F;
      this.func_70105_a(0.5F, 0.5F);
   }

   public EntityLaserLink(World par1World, double x, double y, double z, float yaw, float pitch, double distance) {
      this(par1World);
      this.func_70012_b(x, y, z, yaw, pitch);
      this.field_70159_w = distance / 100.0;
      this.field_70173_aa = 0;
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      this.field_70129_M = 0.0F;
      this.func_70105_a(0.5F, 0.5F);
   }

   public boolean func_70112_a(double par1) {
      return true;
   }

   public int func_70070_b(float par1) {
      return 1000;
   }

   public float func_70013_c(float par1) {
      return 1000.0F;
   }

   @Override
   protected void func_70088_a() {
   }

   public void func_70071_h_() {
      super.func_70071_h_();
      if (this.field_70173_aa == 1) {
         this.func_70106_y();
      }

      this.field_70173_aa++;
   }

   @Override
   protected void func_70037_a(NBTTagCompound var1) {
   }

   @Override
   protected void func_70014_b(NBTTagCompound var1) {
   }
}
