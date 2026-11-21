package assets.rivalrebels.common.entity;

import assets.rivalrebels.common.core.RivalRebelsDamageSource;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityBomb extends EntityThrowable {
   public int field_70195_i = 0;
   public int timeleft = 20;
   public boolean exploded = false;
   public boolean hit = false;

   public EntityBomb(World par1World) {
      super(par1World);
      this.func_70105_a(0.5F, 0.5F);
   }

   public EntityBomb(World par1World, double x, double y, double z, float yaw, float pitch) {
      this(par1World);
      this.func_70012_b(x, y, z, yaw, pitch);
      this.field_70129_M = 0.0F;
      this.field_70159_w = -(
         -MathHelper.func_76126_a(this.field_70177_z / 180.0F * (float) Math.PI) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * (float) Math.PI)
      );
      this.field_70179_y = MathHelper.func_76134_b(this.field_70177_z / 180.0F * (float) Math.PI)
         * MathHelper.func_76134_b(this.field_70125_A / 180.0F * (float) Math.PI);
      this.field_70181_x = -MathHelper.func_76126_a(this.field_70125_A / 180.0F * (float) Math.PI);
   }

   public EntityBomb(World par1World, double x, double y, double z, double mx, double my, double mz) {
      super(par1World);
      this.func_70105_a(0.5F, 0.5F);
      this.func_70107_b(x + mx * 1.4F, y + my * 1.4F, z + mz * 1.4F);
      this.field_70129_M = 0.0F;
      this.setAnglesMotion(mx, my, mz);
   }

   public EntityBomb(World par1World, EntityPlayer entity2, float par3) {
      super(par1World);
      this.func_70105_a(0.5F, 0.5F);
      this.func_70012_b(
         entity2.field_70165_t, entity2.field_70163_u + entity2.func_70047_e(), entity2.field_70161_v, entity2.field_70177_z, entity2.field_70125_A
      );
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      this.field_70129_M = 0.0F;
      this.field_70159_w = -MathHelper.func_76126_a(this.field_70177_z / 180.0F * (float) Math.PI)
         * MathHelper.func_76134_b(this.field_70125_A / 180.0F * (float) Math.PI);
      this.field_70179_y = MathHelper.func_76134_b(this.field_70177_z / 180.0F * (float) Math.PI)
         * MathHelper.func_76134_b(this.field_70125_A / 180.0F * (float) Math.PI);
      this.field_70181_x = -MathHelper.func_76126_a(this.field_70125_A / 180.0F * (float) Math.PI);
      this.field_70165_t = this.field_70165_t + this.field_70159_w;
      this.field_70163_u = this.field_70163_u + this.field_70181_x;
      this.field_70161_v = this.field_70161_v + this.field_70179_y;
      this.func_70186_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, 2.5F, 0.1F);
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
      if (this.field_70195_i == -100) {
         this.explode(false);
      }

      this.field_70195_i++;
      if (this.exploded) {
         this.field_70181_x = 0.0;
         if (this.hit) {
            this.field_70181_x = 1.0;
         }

         this.field_70159_w = 0.0;
         this.field_70179_y = 0.0;
         this.timeleft--;
         if (this.timeleft < 0) {
            this.func_70106_y();
         }

         this.field_70173_aa++;
      } else {
         Vec3 var15 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
         Vec3 var2 = Vec3.func_72443_a(
            this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y
         );
         MovingObjectPosition var3 = this.field_70170_p.func_72933_a(var15, var2);
         var15 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
         var2 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
         if (var3 != null) {
            var2 = Vec3.func_72443_a(var3.field_72307_f.field_72450_a, var3.field_72307_f.field_72448_b, var3.field_72307_f.field_72449_c);
         }

         if (!this.field_70170_p.field_72995_K) {
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
         float var17 = 0.95F;
         float var18 = this.func_70185_h();
         this.field_70159_w *= var17;
         this.field_70181_x *= var17;
         this.field_70179_y *= var17;
         this.field_70181_x -= var18;
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
      if (var1.field_72308_g != null) {
         var1.field_72308_g.func_70097_a(RivalRebelsDamageSource.rocket, var1.field_72308_g instanceof EntityPlayer ? 20 : 300);
         this.explode(true);
      } else {
         this.explode(false);
      }
   }

   protected float func_70185_h() {
      return 0.1F;
   }

   public void explode(boolean b) {
      this.exploded = true;
      this.hit = b;
      this.field_70173_aa = 0;
      if (Math.random() > 0.8F) {
         RivalRebelsSoundPlayer.playSound(this, 23, 0, 20.0F, 0.4F + (float)Math.random() * 0.3F);
      }

      if (!this.field_70170_p.field_72995_K && !b) {
         int r = 2;

         for (int x = -r; x <= r; x++) {
            for (int y = -r; y <= r; y++) {
               for (int z = -r; z <= r; z++) {
                  this.field_70170_p
                     .func_147468_f((int)(this.field_70165_t + x), (int)(Math.max(this.field_70163_u, r + 1) + y), (int)(this.field_70161_v + z));
               }
            }
         }
      }
   }
}
