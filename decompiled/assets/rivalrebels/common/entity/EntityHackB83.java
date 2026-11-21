package assets.rivalrebels.common.entity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.explosion.NuclearExplosion;
import java.util.List;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityHackB83 extends EntityThrowable {
   public int field_70195_i = 0;
   double mmx = 0.0;
   double mmy = 0.0;
   double mmz = 0.0;
   boolean straight;

   public EntityHackB83(World par1World) {
      super(par1World);
      this.func_70105_a(0.5F, 0.5F);
   }

   public EntityHackB83(World par1World, double x, double y, double z, float yaw, float pitch, boolean flystraight) {
      super(par1World);
      this.func_70105_a(0.5F, 0.5F);
      this.straight = flystraight;
      this.func_70012_b(x, y, z, yaw, pitch);
      this.field_70129_M = 0.0F;
      this.field_70159_w = -(
         -MathHelper.func_76126_a(this.field_70177_z / 180.0F * (float) Math.PI) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * (float) Math.PI)
      );
      this.field_70179_y = MathHelper.func_76134_b(this.field_70177_z / 180.0F * (float) Math.PI)
         * MathHelper.func_76134_b(this.field_70125_A / 180.0F * (float) Math.PI);
      this.field_70181_x = -MathHelper.func_76126_a(this.field_70125_A / 180.0F * (float) Math.PI);
   }

   public EntityHackB83(World par1World, double x, double y, double z, double mx, double my, double mz, boolean flystraight) {
      super(par1World);
      this.func_70105_a(0.5F, 0.5F);
      this.func_70107_b(x, y, z);
      this.field_70129_M = 0.0F;
      this.setAnglesMotion(mx, my, mz);
      this.straight = flystraight;
   }

   public void setAnglesMotion(double mx, double my, double mz) {
      this.field_70159_w = mx;
      this.field_70181_x = my;
      this.field_70179_y = mz;
      this.field_70126_B = this.field_70177_z = (float)(Math.atan2(mx, mz) * 180.0 / Math.PI);
      this.field_70127_C = this.field_70125_A = (float)(Math.atan2(my, MathHelper.func_76133_a(mx * mx + mz * mz)) * 180.0 / Math.PI);
   }

   public void func_70071_h_() {
      this.field_70142_S = this.field_70165_t;
      this.field_70137_T = this.field_70163_u;
      this.field_70136_U = this.field_70161_v;
      if (this.field_70195_i == -100 || this.field_70163_u < 0.0 || this.field_70163_u > 256.0) {
         this.explode();
      }

      this.field_70195_i++;
      if (!this.straight && !this.field_70170_p.field_72995_K) {
         this.mmx = this.mmx + this.field_70170_p.field_73012_v.nextGaussian() * 0.4;
         this.mmy = this.mmy + this.field_70170_p.field_73012_v.nextGaussian() * 0.4;
         this.mmz = this.mmz + this.field_70170_p.field_73012_v.nextGaussian() * 0.4;
         double dist = 1.0 / Math.sqrt(this.mmx * this.mmx + this.mmy * this.mmy + this.mmz * this.mmz);
         this.mmx *= dist;
         this.mmy *= dist;
         this.mmz *= dist;
         if (this.field_70195_i > 35) {
            this.field_70159_w = this.field_70159_w + this.mmx * 0.2F;
            this.field_70181_x = this.field_70181_x + this.mmy * 0.2F;
            this.field_70179_y = this.field_70179_y + this.mmz * 0.2F;
         } else {
            this.field_70159_w = this.field_70159_w + this.mmx * 0.2F;
            this.field_70181_x = this.field_70181_x + Math.abs(this.mmy) * 0.2F;
            this.field_70179_y = this.field_70179_y + this.mmz * 0.2F;
         }
      }

      if (this.field_70170_p.field_72995_K && !this.field_70171_ac) {
         this.field_70170_p
            .func_72838_d(
               new EntityPropulsionFX(
                  this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, -this.field_70159_w, -this.field_70181_x, -this.field_70179_y
               )
            );
         this.field_70170_p
            .func_72838_d(
               new EntityPropulsionFX(
                  this.field_70170_p,
                  this.field_70165_t,
                  this.field_70163_u,
                  this.field_70161_v,
                  -this.field_70159_w * 0.8F,
                  -this.field_70181_x * 0.8F,
                  -this.field_70179_y * 0.8F
               )
            );
         this.field_70170_p
            .func_72838_d(
               new EntityPropulsionFX(
                  this.field_70170_p,
                  this.field_70165_t,
                  this.field_70163_u,
                  this.field_70161_v,
                  -this.field_70159_w * 0.6F,
                  -this.field_70181_x * 0.6F,
                  -this.field_70179_y * 0.6F
               )
            );
         this.field_70170_p
            .func_72838_d(
               new EntityPropulsionFX(
                  this.field_70170_p,
                  this.field_70165_t,
                  this.field_70163_u,
                  this.field_70161_v,
                  -this.field_70159_w * 0.4F,
                  -this.field_70181_x * 0.4F,
                  -this.field_70179_y * 0.4F
               )
            );
         this.field_70170_p
            .func_72838_d(
               new EntityPropulsionFX(
                  this.field_70170_p,
                  this.field_70165_t,
                  this.field_70163_u,
                  this.field_70161_v,
                  -this.field_70159_w * 0.2F,
                  -this.field_70181_x * 0.2F,
                  -this.field_70179_y * 0.2F
               )
            );
      }

      Vec3 var15 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      Vec3 var2 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
      MovingObjectPosition var3 = this.field_70170_p.func_72933_a(var15, var2);
      var15 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      var2 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
      if (var3 != null) {
         var2 = Vec3.func_72443_a(var3.field_72307_f.field_72450_a, var3.field_72307_f.field_72448_b, var3.field_72307_f.field_72449_c);
      }

      if (!this.field_70170_p.field_72995_K && this.field_70195_i > 3) {
         Entity var4 = null;
         List var5 = this.field_70170_p
            .func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(1.0, 1.0, 1.0));
         double var6 = 0.0;

         for (Entity var9 : var5) {
            if (var9.func_70067_L()) {
               float var10 = 0.3F;
               AxisAlignedBB var11 = var9.field_70121_D.func_72314_b(var10, var10, var10);
               MovingObjectPosition var12 = var11.func_72327_a(var15, var2);
               if (var12 != null) {
                  double var13 = var15.func_72438_d(var12.field_72307_f);
                  if (var13 < var6 || var6 == 0.0) {
                     var4 = var9;
                     var6 = var13;
                  }
               }
            }
         }

         if (var4 != null) {
            var3 = new MovingObjectPosition(var4);
         }
      }

      if (var3 != null) {
         this.func_70184_a(var3);
      }

      this.field_70165_t = this.field_70165_t + this.field_70159_w;
      this.field_70163_u = this.field_70163_u + this.field_70181_x;
      this.field_70161_v = this.field_70161_v + this.field_70179_y;
      float var16 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
      this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0 / Math.PI);
      this.field_70125_A = (float)(Math.atan2(this.field_70181_x, var16) * 180.0 / Math.PI);

      while (this.field_70125_A - this.field_70127_C < -180.0F) {
         this.field_70127_C -= 360.0F;
      }

      while (this.field_70125_A - this.field_70127_C >= 180.0F) {
         this.field_70127_C += 360.0F;
      }

      while (this.field_70177_z - this.field_70126_B < -180.0F) {
         this.field_70126_B -= 360.0F;
      }

      while (this.field_70177_z - this.field_70126_B >= 180.0F) {
         this.field_70126_B += 360.0F;
      }

      this.field_70125_A = this.field_70127_C + (this.field_70125_A - this.field_70127_C) * 0.2F;
      this.field_70177_z = this.field_70126_B + (this.field_70177_z - this.field_70126_B) * 0.2F;
      float var17 = 0.9F;
      if (!this.straight && !this.field_70170_p.field_72995_K) {
         this.field_70159_w *= var17;
         this.field_70181_x *= var17;
         this.field_70179_y *= var17;
      }

      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
   }

   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
   }

   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
   }

   public boolean func_70112_a(double par1) {
      return true;
   }

   protected void func_70184_a(MovingObjectPosition var1) {
      if (var1.field_72308_g == null) {
         Material m = this.field_70170_p.func_147439_a(var1.field_72311_b, var1.field_72312_c, var1.field_72309_d).func_149688_o();
         if (m == Material.field_151584_j
            || m == Material.field_151571_B
            || m == Material.field_151578_c
            || m == Material.field_151585_k
            || m == Material.field_151568_F
            || m == Material.field_151594_q
            || m == Material.field_151570_A
            || m == Material.field_151580_n
            || m == Material.field_151596_z
            || m == Material.field_151592_s
            || m == Material.field_151577_b
            || m == Material.field_151595_p
            || m == Material.field_151597_y
            || m == Material.field_151575_d
            || m == Material.field_151582_l
            || m == Material.field_151586_h
            || m == Material.field_151583_m
            || m == Material.field_151588_w) {
            this.field_70170_p.func_147468_f(var1.field_72311_b, var1.field_72312_c, var1.field_72309_d);
            return;
         }
      }

      this.explode();
   }

   public void explode() {
      new NuclearExplosion(this.field_70170_p, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, RivalRebels.b83Strength, false);
      this.field_70170_p
         .func_72838_d(
            new EntityTsarBlast(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, RivalRebels.b83Strength * 1.3333334F).setTime()
         );
      this.func_70106_y();
   }
}
