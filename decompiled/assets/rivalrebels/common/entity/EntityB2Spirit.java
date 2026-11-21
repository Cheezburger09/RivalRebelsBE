package assets.rivalrebels.common.entity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import assets.rivalrebels.common.item.weapon.ItemRoda;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityB2Spirit extends Entity {
   private int ticksSinceStart = 0;
   private int timeLeft = -1;
   private double tx = 0.0;
   private double ty = 0.0;
   private double tz = 0.0;
   public int health;
   public boolean carpet = false;
   public EntityRhodes rhodeswing = null;
   public static int staticEntityIndex = 10;
   public int entityIndex = 10;
   public boolean dropAnything = true;
   public static boolean randchance = true;
   public boolean dropOnlyOne = false;
   public static boolean trash = true;
   public static boolean leave = true;
   public int mode = 0;
   Entity rhodes = null;

   public EntityB2Spirit(World par1World) {
      super(par1World);
      this.func_70105_a(30.0F, 4.0F);
      this.field_70158_ak = true;
      this.field_70121_D.func_72324_b(-10.0, -3.0, -10.0, 10.0, 4.0, 10.0);
      this.health = RivalRebels.b2spirithealth;
      this.field_70129_M = 0.0F;
   }

   public EntityB2Spirit(World par1World, double x, double y, double z, double x1, double y1, double z1, boolean c, boolean da) {
      this(par1World);
      this.carpet = c;
      this.tx = x;
      this.ty = y;
      this.tz = z;
      this.dropOnlyOne = !da;
      if (this.carpet) {
         this.entityIndex = 10;
         if (staticEntityIndex <= 23) {
            this.entityIndex = staticEntityIndex;
         }
      } else {
         this.entityIndex = 24;
         if (staticEntityIndex > 23) {
            this.entityIndex = staticEntityIndex;
         }
      }

      if (!this.field_70170_p.field_72995_K) {
         this.startBombRun(this.tz - z1, x1 - this.tx);
      }
   }

   public EntityB2Spirit(EntityRhodes r) {
      this(r.field_70170_p);
      this.rhodeswing = r;
      this.field_70165_t = r.field_70165_t - r.field_70159_w * 500.0;
      this.field_70163_u = 120.0;
      this.field_70161_v = r.field_70161_v - r.field_70179_y * 500.0;
   }

   public AxisAlignedBB func_70114_g(Entity par1Entity) {
      return par1Entity.field_70121_D;
   }

   public AxisAlignedBB func_70046_E() {
      return this.field_70121_D;
   }

   public boolean func_70067_L() {
      return true;
   }

   public boolean func_70104_M() {
      return false;
   }

   public void func_70071_h_() {
      super.func_70071_h_();
      this.field_70142_S = this.field_70165_t;
      this.field_70137_T = this.field_70163_u;
      this.field_70136_U = this.field_70161_v;
      if (Math.random() > 0.8F) {
         RivalRebelsSoundPlayer.playSound(this, 8, 0, 4.5F, 1.3F);
      }

      if (this.rhodeswing != null) {
         this.field_70159_w = this.rhodeswing.field_70165_t - this.field_70165_t;
         this.field_70181_x = this.rhodeswing.field_70163_u - this.field_70163_u;
         this.field_70179_y = this.rhodeswing.field_70161_v - this.field_70161_v;
         double t = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
         this.field_70159_w /= t;
         this.field_70181_x /= t;
         this.field_70179_y /= t;
         this.field_70177_z = this.rhodeswing.field_70177_z;
         this.field_70125_A = (float)Math.min(t, 90.0);
         if (t < 25.0 || this.field_70173_aa > 100) {
            this.rhodeswing.b2energy = 8000;
            this.rhodeswing.freeze = false;
            this.func_70106_y();
         }
      }

      if (!this.field_70170_p.field_72995_K) {
         double distfromtarget = Math.sqrt(
            (this.tx - this.field_70165_t) * (this.tx - this.field_70165_t) + (this.tz - this.field_70161_v) * (this.tz - this.field_70161_v)
         );
         this.ticksSinceStart++;
         if (this.ticksSinceStart >= 60 && this.mode == 0) {
            if (this.carpet || (this.dropOnlyOne ? this.ticksSinceStart == 80 : this.ticksSinceStart % 40 == 0)) {
               this.dropNuke();
            }

            if (distfromtarget > 80.0) {
               this.mode = this.field_70170_p.field_73012_v.nextBoolean() ? 1 : 2;
               if (trash) {
                  this.carpet = true;
                  this.entityIndex = this.field_70170_p.field_73012_v.nextInt(ItemRoda.rodaindex);
               }

               if (leave) {
                  if (this.ticksSinceStart > 1000 && this.field_70170_p.field_73012_v.nextInt(4) == 1) {
                     this.field_70181_x = 2.0;
                  }

                  if (!trash && this.dropOnlyOne) {
                     this.field_70181_x = 2.0;
                  }
               }
            }
         }

         if (this.mode > 0) {
            if (this.mode == 1) {
               this.field_70177_z += 10.0F;
            } else if (this.mode == 2) {
               this.field_70177_z -= 10.0F;
            }

            this.field_70159_w = MathHelper.func_76126_a(this.field_70177_z / 180.0F * (float) Math.PI);
            this.field_70179_y = MathHelper.func_76134_b(this.field_70177_z / 180.0F * (float) Math.PI);
            if (distfromtarget < 80.0) {
               this.mode = 0;
            }
         }

         for (Entity var9 : this.field_70170_p
            .func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(1.0, 1.0, 1.0))) {
            if (var9 instanceof EntityRocket) {
               ((EntityRocket)var9).explode(null);
            }

            if (var9 instanceof EntityPlasmoid) {
               ((EntityPlasmoid)var9).explode();
            }

            if (var9 instanceof EntityLaserBurst) {
               ((EntityLaserBurst)var9).func_70106_y();
               this.func_70097_a(DamageSource.field_76377_j, 6.0F);
            }
         }

         this.timeLeft--;
         if (this.timeLeft == 0) {
            this.field_70181_x = 2.0;
         }

         if (this.field_70163_u > 256.0) {
            this.func_70106_y();
         }
      }

      this.field_70165_t = this.field_70165_t + this.field_70159_w;
      this.field_70163_u = this.field_70163_u + this.field_70181_x;
      this.field_70161_v = this.field_70161_v + this.field_70179_y;
      if (this.rhodeswing == null) {
         float var16 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
         this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0 / Math.PI);
         this.field_70125_A = (float)(Math.atan2(-this.field_70181_x, var16) * 180.0 / Math.PI);

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
      }

      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
   }

   public void dropNuke() {
      if (this.dropAnything) {
         ItemRoda.spawn(
            this.entityIndex,
            this.field_70170_p,
            this.field_70165_t + Math.random() * 4.0 - 2.0,
            this.field_70163_u - 3.5,
            this.field_70161_v + Math.random() * 4.0 - 2.0,
            this.field_70159_w * 0.1F,
            -1.0,
            this.field_70179_y * 0.1F,
            1.0,
            0.0
         );
      }
   }

   public void startBombRun(double x, double z) {
      if (this.rhodes != null) {
         this.tx = this.rhodes.field_70165_t;
         this.ty = this.rhodes.field_70163_u;
         this.tz = this.rhodes.field_70161_v;
         x = -this.rhodes.field_70159_w;
         z = -this.rhodes.field_70179_y;
      }

      double dist = 1.0 / Math.sqrt(x * x + z * z);
      x *= dist;
      z *= dist;
      this.field_70159_w = -x;
      this.field_70179_y = -z;
      this.func_70107_b(this.tx + x * 80.0, this.ty + 60.0, this.tz + z * 80.0);
      this.field_70126_B = this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0 / Math.PI);
   }

   public void func_70014_b(NBTTagCompound nbt) {
      nbt.func_74768_a("drop", this.entityIndex);
      nbt.func_74776_a("tx", (float)this.tx);
      nbt.func_74776_a("ty", (float)this.ty);
      nbt.func_74776_a("tz", (float)this.tz);
      nbt.func_74768_a("age", this.ticksSinceStart);
      nbt.func_74768_a("health", this.health);
      nbt.func_74768_a("duration", this.timeLeft);
   }

   public void func_70037_a(NBTTagCompound nbt) {
      this.entityIndex = nbt.func_74762_e("drop");
      this.carpet = this.entityIndex < ItemRoda.rodaindex;
      this.tx = nbt.func_74760_g("tx");
      this.ty = nbt.func_74760_g("ty");
      this.tz = nbt.func_74760_g("tz");
      this.ticksSinceStart = nbt.func_74762_e("age");
      this.health = nbt.func_74762_e("health");
      this.timeLeft = nbt.func_74762_e("duration");
      if (this.ticksSinceStart == 0) {
         double dx = this.tx - this.field_70165_t;
         double dy = this.ty - this.field_70163_u;
         this.startBombRun(dx, dy);
      }
   }

   public boolean func_70112_a(double par1) {
      return true;
   }

   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
      super.func_70097_a(par1DamageSource, par2);
      if (!this.field_70128_L && !this.field_70170_p.field_72995_K) {
         this.health = (int)(this.health - par2);
         if (this.health <= 0) {
            this.func_70106_y();
            this.field_70170_p.func_72876_a((Entity)null, this.field_70165_t, this.field_70163_u, this.field_70161_v, 6.0F, true);
            this.field_70170_p.func_72838_d(new EntityB2Frag(this.field_70170_p, this, 0));
            this.field_70170_p.func_72838_d(new EntityB2Frag(this.field_70170_p, this, 1));
            EntityZombie pz = new EntityZombie(this.field_70170_p);
            pz.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            this.field_70170_p.func_72838_d(pz);
            RivalRebelsSoundPlayer.playSound(this, 0, 0, 30.0F, 1.0F);
         }
      }

      return true;
   }

   protected void func_70088_a() {
   }
}
