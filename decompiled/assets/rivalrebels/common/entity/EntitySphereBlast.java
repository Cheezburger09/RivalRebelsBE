package assets.rivalrebels.common.entity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsDamageSource;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntitySphereBlast extends EntityTsarBlast {
   public EntitySphereBlast(World par1World) {
      super(par1World);
      this.field_70158_ak = true;
   }

   public EntitySphereBlast(World par1World, double x, double y, double z, float rad) {
      super(par1World);
      this.field_70158_ak = true;
      this.radius = rad;
      this.field_70159_w = Math.sqrt(rad - RivalRebels.tsarBombaStrength) / 10.0;
      this.func_70107_b(x, y, z);
   }

   @Override
   public void func_70071_h_() {
      if (this.field_70170_p.field_73012_v.nextInt(10) == 0) {
         this.field_70170_p.func_72956_a(this, "ambient.weather.thunder", 10.0F, 0.5F);
      } else if (this.field_70170_p.field_73012_v.nextInt(5) == 0) {
         RivalRebelsSoundPlayer.playSound(this, 26, 0, 100.0F, 0.7F);
      }

      if (this.field_70146_Z.nextBoolean() && this.field_70146_Z.nextBoolean()) {
         this.pushAndHurtEntities();
      }

      this.field_70173_aa++;
      if (this.field_70173_aa > 400) {
         this.func_70106_y();
      }
   }

   @Override
   public void pushAndHurtEntities() {
      int var3 = MathHelper.func_76128_c(this.field_70165_t - this.radius - 1.0);
      int var4 = MathHelper.func_76128_c(this.field_70165_t + this.radius + 1.0);
      int var5 = MathHelper.func_76128_c(this.field_70163_u - this.radius - 1.0);
      int var28 = MathHelper.func_76128_c(this.field_70163_u + this.radius + 1.0);
      int var7 = MathHelper.func_76128_c(this.field_70161_v - this.radius - 1.0);
      int var29 = MathHelper.func_76128_c(this.field_70161_v + this.radius + 1.0);
      List var9 = this.field_70170_p.func_72839_b(this, AxisAlignedBB.func_72330_a(var3, var5, var7, var4, var28, var29));
      Vec3 var30 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);

      for (int var11 = 0; var11 < var9.size(); var11++) {
         Entity var31 = (Entity)var9.get(var11);
         if (var31 instanceof EntityLivingBase) {
            if (var31 instanceof EntityPlayer && ((EntityPlayer)var31).field_71075_bZ.field_75098_d) {
               continue;
            }

            double var13 = var31.func_70011_f(this.field_70165_t, this.field_70163_u, this.field_70161_v) / this.radius;
            if (var13 <= 1.0) {
               double var15 = var31.field_70165_t - this.field_70165_t;
               double var17 = var31.field_70163_u + var31.func_70047_e() - this.field_70163_u;
               double var19 = var31.field_70161_v - this.field_70161_v;
               double var33 = MathHelper.func_76133_a(var15 * var15 + var17 * var17 + var19 * var19);
               if (var33 != 0.0) {
                  var15 /= var33;
                  var17 /= var33;
                  var19 /= var33;
                  double var34 = 1.0 - var13;
                  var31.func_70097_a(RivalRebelsDamageSource.nuclearblast, (int)((var34 * var34 + var34) * 20.0 * this.radius + 20.0) * 200);
                  var31.field_70159_w -= var15 * var34 * 8.0;
                  var31.field_70181_x -= var17 * var34 * 8.0;
                  var31.field_70179_y -= var19 * var34 * 8.0;
               }
            }
         }

         if (var31 instanceof EntityRhodes) {
            var31.func_70097_a(RivalRebelsDamageSource.nuclearblast, 30.0F);
         }
      }
   }

   @Override
   public void func_70037_a(NBTTagCompound nbttagcompound) {
   }

   @Override
   public void func_70014_b(NBTTagCompound nbttagcompound) {
   }

   @Override
   public int func_70070_b(float par1) {
      return 1000;
   }

   @Override
   public float func_70013_c(float par1) {
      return 1000.0F;
   }

   @Override
   public boolean func_70112_a(double par1) {
      return true;
   }

   @Override
   protected void func_70088_a() {
   }
}
