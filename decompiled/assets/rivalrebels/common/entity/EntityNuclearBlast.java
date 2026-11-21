package assets.rivalrebels.common.entity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsDamageSource;
import assets.rivalrebels.common.explosion.NuclearExplosion;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityNuclearBlast extends EntityInanimate {
   public int field_70173_aa;
   int time;
   int Strength;

   public EntityNuclearBlast(World par1World) {
      super(par1World);
      this.field_70158_ak = true;
      this.field_70173_aa = 0;
      this.time = 0;
      this.func_70105_a(0.5F, 0.5F);
   }

   public EntityNuclearBlast(World par1World, double par2, double par4, double par6, int s, boolean hasTroll) {
      super(par1World);
      this.field_70158_ak = true;
      this.field_70173_aa = 0;
      this.time = 0;
      this.field_70181_x = this.Strength = s;
      if (hasTroll) {
         this.field_70159_w = 1.0;
      } else {
         this.field_70159_w = 0.0;
      }

      this.func_70105_a(0.5F, 0.5F);
      this.func_70107_b(par2, par4, par6);
      this.field_70129_M = 0.0F;
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
      if (!this.field_70170_p.field_72995_K) {
         if (this.field_70173_aa == 0) {
            this.field_70170_p.func_72876_a(null, this.field_70165_t, this.field_70163_u - 5.0, this.field_70161_v, 4.0F, true);
         }

         if (this.field_70173_aa % 20 == 0 && this.field_70173_aa > 60) {
            this.time++;
            if (this.time <= this.Strength) {
               new NuclearExplosion(
                  this.field_70170_p,
                  (int)this.field_70165_t,
                  (int)this.field_70163_u - 5,
                  (int)this.field_70161_v,
                  this.time * this.time / 2 + RivalRebels.nuclearBombStrength
               );
            }
         }

         if (this.field_70173_aa % 2 == 0 && this.field_70173_aa < 400) {
            this.pushAndHurtEntities();
         }
      }

      if (this.field_70173_aa < 30) {
         this.field_70170_p
            .func_72908_a(
               this.field_70165_t,
               this.field_70163_u + this.field_70173_aa - 5.0,
               this.field_70161_v,
               "random.explode",
               4.0F,
               this.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F
            );
      }

      if (this.field_70173_aa % 3 == 0 && this.field_70173_aa < 40 && this.field_70173_aa > 30) {
         for (int i = 0; i < 21; i++) {
            this.field_70170_p
               .func_72908_a(
                  this.field_70165_t + Math.sin(i) * (i / 0.5),
                  this.field_70163_u + 17.0,
                  this.field_70161_v + Math.cos(i) * (i / 0.5),
                  "explode",
                  4.0F,
                  this.field_70170_p.field_73012_v.nextFloat() + 1.0F
               );
         }
      }

      if (this.field_70173_aa < 600) {
         if (this.field_70173_aa % 5 == this.field_70170_p.field_73012_v.nextInt(5)) {
            for (EntityPlayer p : this.field_70170_p.field_73010_i) {
               this.field_70170_p.func_72956_a(p, "ambient.weather.thunder", 10.0F, 0.5F);
               this.field_70170_p.func_72956_a(p, "random.explode", 5.0F, 0.1F);
            }
         }
      } else {
         this.func_70106_y();
      }

      this.field_70173_aa++;
   }

   private void pushAndHurtEntities() {
      int radius = this.Strength * RivalRebels.nuclearBombStrength * 1;
      if (radius > 80) {
         radius = 80;
      }

      int var3 = MathHelper.func_76128_c(this.field_70165_t - radius - 1.0);
      int var4 = MathHelper.func_76128_c(this.field_70165_t + radius + 1.0);
      int var5 = MathHelper.func_76128_c(this.field_70163_u - radius - 1.0);
      int var28 = MathHelper.func_76128_c(this.field_70163_u + radius + 1.0);
      int var7 = MathHelper.func_76128_c(this.field_70161_v - radius - 1.0);
      int var29 = MathHelper.func_76128_c(this.field_70161_v + radius + 1.0);
      List var9 = this.field_70170_p.func_72839_b(this, AxisAlignedBB.func_72330_a(var3, var5, var7, var4, var28, var29));
      Vec3 var30 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);

      for (int var11 = 0; var11 < var9.size(); var11++) {
         Entity var31 = (Entity)var9.get(var11);
         double var13 = var31.func_70011_f(this.field_70165_t, this.field_70163_u, this.field_70161_v) / radius;
         if (var13 <= 1.0) {
            double var15 = var31.field_70165_t - this.field_70165_t;
            double var17 = var31.field_70163_u + var31.func_70047_e() - this.field_70163_u;
            double var19 = var31.field_70161_v - this.field_70161_v;
            double var33 = MathHelper.func_76133_a(var15 * var15 + var17 * var17 + var19 * var19);
            if (var33 != 0.0) {
               var15 /= var33;
               var17 /= var33;
               var19 /= var33;
               if (!(var31 instanceof EntityNuclearBlast) && !(var31 instanceof EntityTsarBlast)) {
                  if (var31 instanceof EntityFallingBlock) {
                     var31.func_70106_y();
                  } else if (!(var31 instanceof EntityPlayer) || !((EntityPlayer)var31).field_71075_bZ.field_75098_d) {
                     var31.func_70097_a(RivalRebelsDamageSource.nuclearblast, 16 * radius);
                     var31.field_70159_w -= var15 * 8.0;
                     var31.field_70181_x -= var17 * 8.0;
                     var31.field_70179_y -= var19 * 8.0;
                  }
               }
            }
         }
      }
   }

   @Override
   public void func_70037_a(NBTTagCompound var1) {
      this.field_70173_aa = var1.func_74762_e("ticksExisted");
      this.time = var1.func_74762_e("time");
      this.field_70181_x = this.Strength = var1.func_74762_e("charges");
      this.field_70159_w = var1.func_74767_n("troll") ? 1.0 : 0.0;
   }

   @Override
   public void func_70014_b(NBTTagCompound var1) {
      var1.func_74768_a("ticksExisted", this.field_70173_aa);
      var1.func_74768_a("time", this.time);
      var1.func_74768_a("charges", this.Strength);
   }

   @Override
   protected void func_70088_a() {
   }
}
