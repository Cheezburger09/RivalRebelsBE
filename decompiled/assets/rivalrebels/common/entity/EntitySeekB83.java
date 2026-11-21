package assets.rivalrebels.common.entity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsDamageSource;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import assets.rivalrebels.common.explosion.Explosion;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntitySeekB83 extends EntityInanimate implements IProjectile {
   private EntityLivingBase thrower;
   public boolean fins = false;
   public int rotation = 45;
   public float slide = 0.0F;
   private boolean inwaterprevtick = false;
   private int soundfile = 0;

   public EntitySeekB83(World par1World) {
      super(par1World);
      this.func_70105_a(0.5F, 0.5F);
   }

   public EntitySeekB83(World par1World, double par2, double par4, double par6) {
      super(par1World);
      this.func_70105_a(0.5F, 0.5F);
      this.func_70107_b(par2, par4, par6);
      this.field_70129_M = 0.0F;
   }

   public EntitySeekB83(World par1World, EntityPlayer entity2, float par3) {
      super(par1World);
      this.thrower = entity2;
      this.fins = false;
      this.func_70105_a(0.5F, 0.5F);
      this.func_70012_b(
         entity2.field_70165_t, entity2.field_70163_u + entity2.func_70047_e(), entity2.field_70161_v, entity2.field_70177_z, entity2.field_70125_A
      );
      this.field_70165_t = this.field_70165_t - MathHelper.func_76134_b(this.field_70177_z / 180.0F * (float) Math.PI) * 0.16F;
      this.field_70163_u -= 0.0;
      this.field_70161_v = this.field_70161_v - MathHelper.func_76126_a(this.field_70177_z / 180.0F * (float) Math.PI) * 0.16F;
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      this.field_70129_M = 0.0F;
      this.field_70159_w = -MathHelper.func_76126_a(this.field_70177_z / 180.0F * (float) Math.PI)
         * MathHelper.func_76134_b(this.field_70125_A / 180.0F * (float) Math.PI);
      this.field_70179_y = MathHelper.func_76134_b(this.field_70177_z / 180.0F * (float) Math.PI)
         * MathHelper.func_76134_b(this.field_70125_A / 180.0F * (float) Math.PI);
      this.field_70181_x = -MathHelper.func_76126_a(this.field_70125_A / 180.0F * (float) Math.PI);
      this.func_70186_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, 0.5F, 1.0F);
   }

   public EntitySeekB83(World par1World, EntityPlayer entity2, float par3, float yawdelta) {
      super(par1World);
      this.thrower = entity2;
      this.fins = false;
      this.func_70105_a(0.5F, 0.5F);
      this.func_70012_b(
         entity2.field_70165_t, entity2.field_70163_u + entity2.func_70047_e(), entity2.field_70161_v, entity2.field_70177_z + yawdelta, entity2.field_70125_A
      );
      this.field_70165_t = this.field_70165_t - MathHelper.func_76134_b(this.field_70177_z / 180.0F * (float) Math.PI) * 0.16F;
      this.field_70163_u -= 0.0;
      this.field_70161_v = this.field_70161_v - MathHelper.func_76126_a(this.field_70177_z / 180.0F * (float) Math.PI) * 0.16F;
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      this.field_70129_M = 0.0F;
      this.field_70159_w = -MathHelper.func_76126_a(this.field_70177_z / 180.0F * (float) Math.PI)
         * MathHelper.func_76134_b(this.field_70125_A / 180.0F * (float) Math.PI);
      this.field_70179_y = MathHelper.func_76134_b(this.field_70177_z / 180.0F * (float) Math.PI)
         * MathHelper.func_76134_b(this.field_70125_A / 180.0F * (float) Math.PI);
      this.field_70181_x = -MathHelper.func_76126_a(this.field_70125_A / 180.0F * (float) Math.PI);
      this.func_70186_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, 0.5F, 1.0F);
   }

   public EntitySeekB83(World w, double x, double y, double z, double mx, double my, double mz) {
      super(w);
      this.func_70105_a(0.5F, 0.5F);
      this.func_70107_b(x + mx * 16.0, y + my * 16.0, z + mz * 16.0);
      this.field_70129_M = 0.0F;
      this.fins = false;
      this.func_70186_c(mx, my, mz, 0.5F, 0.1F);
   }

   public void func_70186_c(double mx, double my, double mz, float speed, float randomness) {
      float f2 = MathHelper.func_76133_a(mx * mx + my * my + mz * mz);
      mx /= f2;
      my /= f2;
      mz /= f2;
      mx += this.field_70146_Z.nextGaussian() * 0.0075 * randomness;
      my += this.field_70146_Z.nextGaussian() * 0.0075 * randomness;
      mz += this.field_70146_Z.nextGaussian() * 0.0075 * randomness;
      mx *= speed;
      my *= speed;
      mz *= speed;
      this.field_70159_w = mx;
      this.field_70181_x = my;
      this.field_70179_y = mz;
      this.field_70126_B = this.field_70177_z = (float)(Math.atan2(mx, mz) * 180.0 / Math.PI);
      this.field_70127_C = this.field_70125_A = (float)(Math.atan2(my, MathHelper.func_76133_a(mx * mx + mz * mz)) * 180.0 / Math.PI);
   }

   public void func_70071_h_() {
      super.func_70071_h_();
      if (this.field_70173_aa == 0) {
         this.rotation = this.field_70170_p.field_73012_v.nextInt(360);
         this.slide = this.field_70170_p.field_73012_v.nextInt(21) - 10;

         for (int i = 0; i < 10; i++) {
            this.field_70170_p
               .func_72869_a(
                  "explode",
                  this.field_70165_t - this.field_70159_w * 2.0,
                  this.field_70163_u - this.field_70181_x * 2.0,
                  this.field_70161_v - this.field_70179_y * 2.0,
                  -this.field_70159_w + (this.field_70170_p.field_73012_v.nextFloat() - 0.5F) * 0.1F,
                  -this.field_70181_x + (this.field_70170_p.field_73012_v.nextFloat() - 0.5) * 0.1F,
                  -this.field_70179_y + (this.field_70170_p.field_73012_v.nextFloat() - 0.5F) * 0.1F
               );
         }
      }

      this.rotation = this.rotation + (int)this.slide;
      this.slide = (float)(this.slide * 0.9);
      if (this.field_70173_aa >= 800) {
         this.explode(null);
      }

      if (this.field_70170_p.field_72995_K && this.field_70173_aa >= 5 && !this.field_70171_ac && this.field_70173_aa <= 100) {
         this.field_70170_p
            .func_72838_d(
               new EntityPropulsionFX(
                  this.field_70170_p,
                  this.field_70165_t,
                  this.field_70163_u,
                  this.field_70161_v,
                  -this.field_70159_w * 0.5,
                  -this.field_70181_x * 0.5 - 0.1,
                  -this.field_70179_y * 0.5
               )
            );
      }

      Vec3 vec31 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      Vec3 vec3 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
      MovingObjectPosition mop = this.field_70170_p.func_147447_a(vec31, vec3, false, true, false);
      if (!this.field_70170_p.field_72995_K) {
         vec31 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
         if (mop != null) {
            vec3 = Vec3.func_72443_a(mop.field_72307_f.field_72450_a, mop.field_72307_f.field_72448_b, mop.field_72307_f.field_72449_c);
         } else {
            vec3 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
         }

         List list = this.field_70170_p
            .func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(1.0, 1.0, 1.0));
         double d0 = Double.MAX_VALUE;

         for (int i = 0; i < list.size(); i++) {
            Entity entity = (Entity)list.get(i);
            if (entity.func_70067_L() && this.field_70173_aa >= 7 && entity != this.thrower || entity instanceof EntityHackB83 || entity instanceof EntityB83) {
               MovingObjectPosition mop1 = entity.field_70121_D.func_72314_b(0.5, 0.5, 0.5).func_72327_a(vec31, vec3);
               if (mop1 != null) {
                  double d1 = vec31.func_72436_e(mop1.field_72307_f);
                  if (d1 < d0) {
                     mop = new MovingObjectPosition(entity, mop1.field_72307_f);
                     d0 = d1;
                  }
               }
            }
         }
      }

      if (mop != null) {
         this.explode(mop);
      }

      Iterator iter = this.field_70170_p.field_72996_f.iterator();
      double ddx = this.field_70159_w;
      double ddy = this.field_70181_x;
      double ddz = this.field_70179_y;
      double dist = 1000000.0;

      while (iter.hasNext()) {
         Entity e = (Entity)iter.next();
         if (e instanceof EntityB83 || e instanceof EntityHackB83) {
            double dx = e.field_70165_t - this.field_70165_t;
            double dy = e.field_70163_u - this.field_70163_u;
            double dz = e.field_70161_v - this.field_70161_v;
            double temp = dx * dx + dy * dy + dz * dz;
            if (temp < dist && dx * this.field_70159_w + dy * this.field_70181_x + dz * this.field_70179_y > 0.0) {
               dist = temp;
               temp = Math.sqrt(temp) * 0.9F;
               ddx = dx / temp;
               ddy = dy / temp;
               ddz = dz / temp;
            }
         }
      }

      this.field_70159_w = ddx;
      this.field_70181_x = ddy;
      this.field_70179_y = ddz;
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
      float var17 = 1.1F;
      if (this.field_70173_aa > 25) {
         var17 = 0.9999F;
      }

      if (this.func_70090_H()) {
         for (int var7 = 0; var7 < 4; var7++) {
            this.field_70170_p
               .func_72869_a(
                  "bubble",
                  this.field_70165_t - this.field_70159_w * 0.25,
                  this.field_70163_u - this.field_70181_x * 0.25,
                  this.field_70161_v - this.field_70179_y * 0.25,
                  this.field_70159_w,
                  this.field_70181_x,
                  this.field_70179_y
               );
         }

         if (!this.inwaterprevtick) {
            RivalRebelsSoundPlayer.playSound(this, 23, 4, 0.5F, 0.5F);
         }

         this.soundfile = 3;
         var17 = 0.8F;
         this.inwaterprevtick = true;
      } else {
         this.soundfile = 0;
      }

      this.field_70159_w *= var17;
      this.field_70181_x *= var17;
      this.field_70179_y *= var17;
      if (this.field_70173_aa == 3) {
         this.fins = true;
         this.field_70125_A = (float)(this.field_70125_A + 22.5);
      }

      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      this.field_70173_aa++;
   }

   @Override
   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
   }

   @Override
   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
   }

   public void explode(MovingObjectPosition mop) {
      if (mop != null) {
         if (mop.field_72308_g != null) {
            if (mop.field_72308_g instanceof EntityHackB83) {
               mop.field_72308_g.func_70106_y();
               this.field_70170_p.func_147449_b((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, RivalRebels.plasmaexplosion);
               this.func_70106_y();
            } else if (mop.field_72308_g instanceof EntityPlayer) {
               EntityPlayer player = (EntityPlayer)mop.field_72308_g;
               ItemStack[] armorSlots = player.field_71071_by.field_70460_b;
               if (armorSlots[0] != null) {
                  armorSlots[0].func_77972_a(48, player);
               }

               if (armorSlots[1] != null) {
                  armorSlots[1].func_77972_a(48, player);
               }

               if (armorSlots[2] != null) {
                  armorSlots[2].func_77972_a(48, player);
               }

               if (armorSlots[3] != null) {
                  armorSlots[3].func_77972_a(48, player);
               }

               RivalRebelsSoundPlayer.playSound(this, 23, this.soundfile, 5.0F, 0.3F);
               new Explosion(
                  this.field_70170_p,
                  this.field_70165_t,
                  this.field_70163_u,
                  this.field_70161_v,
                  RivalRebels.rpgExplodeSize,
                  false,
                  false,
                  RivalRebelsDamageSource.rocket
               );
               this.func_70106_y();
            } else {
               new Explosion(
                  this.field_70170_p,
                  this.field_70165_t,
                  this.field_70163_u,
                  this.field_70161_v,
                  RivalRebels.rpgExplodeSize,
                  false,
                  false,
                  RivalRebelsDamageSource.rocket
               );
               this.func_70106_y();
            }
         } else {
            Block block = this.field_70170_p.func_147439_a(mop.field_72311_b, mop.field_72312_c, mop.field_72309_d);
            if (block != Blocks.field_150359_w && block != Blocks.field_150410_aZ && block != Blocks.field_150399_cn && block != Blocks.field_150397_co) {
               RivalRebelsSoundPlayer.playSound(this, 23, this.soundfile, 5.0F, 0.3F);
               new Explosion(
                  this.field_70170_p,
                  this.field_70165_t,
                  this.field_70163_u,
                  this.field_70161_v,
                  RivalRebels.rpgExplodeSize,
                  false,
                  false,
                  RivalRebelsDamageSource.rocket
               );
               this.func_70106_y();
            } else {
               this.field_70170_p.func_147449_b(mop.field_72311_b, mop.field_72312_c, mop.field_72309_d, Blocks.field_150350_a);
               RivalRebelsSoundPlayer.playSound(this, 4, 0, 5.0F, 0.3F);
            }
         }
      } else {
         RivalRebelsSoundPlayer.playSound(this, 23, this.soundfile, 5.0F, 0.3F);
         new Explosion(
            this.field_70170_p,
            this.field_70165_t,
            this.field_70163_u,
            this.field_70161_v,
            RivalRebels.rpgExplodeSize,
            false,
            false,
            RivalRebelsDamageSource.rocket
         );
         this.func_70106_y();
      }
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
}
