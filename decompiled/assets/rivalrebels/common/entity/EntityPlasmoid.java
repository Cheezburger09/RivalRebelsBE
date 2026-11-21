package assets.rivalrebels.common.entity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.BlackList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityPlasmoid extends EntityInanimate {
   private EntityPlayer thrower;
   public int rotation = 45;
   public int size = 3;
   public float slide = 0.0F;
   boolean gravity = false;

   public EntityPlasmoid(World par1World) {
      super(par1World);
      this.func_70105_a(0.5F, 0.5F);
      this.size = 3;
   }

   public EntityPlasmoid(World par1World, double par2, double par4, double par6) {
      super(par1World);
      this.func_70105_a(0.5F, 0.5F);
      this.func_70107_b(par2, par4, par6);
      this.field_70129_M = 0.0F;
      this.size = 3;
   }

   public EntityPlasmoid(World par1World, EntityPlayer par2EntityLiving, EntityLiving par3EntityLiving, float par4, float par5) {
      super(par1World);
      this.thrower = par2EntityLiving;
      this.field_70163_u = par2EntityLiving.field_70163_u + par2EntityLiving.func_70047_e() - 0.1F;
      double var6 = par3EntityLiving.field_70165_t - par2EntityLiving.field_70165_t;
      double var8 = par3EntityLiving.field_70163_u + par3EntityLiving.func_70047_e() - 0.7F - this.field_70163_u;
      double var10 = par3EntityLiving.field_70161_v - par2EntityLiving.field_70161_v;
      double var12 = MathHelper.func_76133_a(var6 * var6 + var10 * var10);
      if (var12 >= 1.0E-7) {
         float var14 = (float)(Math.atan2(var10, var6) * 180.0 / Math.PI) - 90.0F;
         float var15 = (float)(-(Math.atan2(var8, var12) * 180.0 / Math.PI));
         double var16 = var6 / var12;
         double var18 = var10 / var12;
         this.func_70012_b(par2EntityLiving.field_70165_t + var16, this.field_70163_u, par2EntityLiving.field_70161_v + var18, var14, var15);
         this.field_70129_M = 0.0F;
         float var20 = (float)var12 * 0.2F;
         this.setAccurateHeading(var6, var8 + var20, var10, par4, par5);
      }

      this.size = 3;
   }

   public EntityPlasmoid(World par1World, EntityPlayer par2EntityLiving, float par3, boolean drop) {
      super(par1World);
      par3 *= this.gravity ? 3 : 1;
      this.gravity = drop;
      this.thrower = par2EntityLiving;
      this.func_70105_a(0.5F, 0.5F);
      this.func_70012_b(
         par2EntityLiving.field_70165_t,
         par2EntityLiving.field_70163_u + par2EntityLiving.func_70047_e(),
         par2EntityLiving.field_70161_v,
         par2EntityLiving.field_70177_z,
         par2EntityLiving.field_70125_A
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
      this.setAccurateHeading(this.field_70159_w, this.field_70181_x, this.field_70179_y, par3 * 1.5F, 1.0F);
   }

   public EntityPlasmoid(World worldObj, double px, double py, double pz, double x, double y, double z, float d) {
      super(worldObj);
      this.func_70105_a(0.5F, 0.5F);
      double f = d / MathHelper.func_76133_a(x * x + y * y + z * z);
      this.func_70107_b(px + x * f, py + y * f, pz + z * f);
      this.field_70129_M = 0.0F;
      this.size = 3;
      this.field_70159_w = x;
      this.field_70181_x = y;
      this.field_70179_y = z;
      float var10x = MathHelper.func_76133_a(x * x + z * z);
      this.field_70126_B = this.field_70177_z = (float)(Math.atan2(x, z) * 180.0 / Math.PI);
      this.field_70127_C = this.field_70125_A = (float)(Math.atan2(y, var10x) * 180.0 / Math.PI);
   }

   public void setAccurateHeading(double par1, double par3, double par5, float par7, float par8) {
      float var9 = MathHelper.func_76133_a(par1 * par1 + par3 * par3 + par5 * par5);
      par1 /= var9;
      par3 /= var9;
      par5 /= var9;
      par1 *= par7;
      par3 *= par7;
      par5 *= par7;
      this.field_70159_w = par1;
      this.field_70181_x = par3;
      this.field_70179_y = par5;
      float var10 = MathHelper.func_76133_a(par1 * par1 + par5 * par5);
      this.field_70126_B = this.field_70177_z = (float)(Math.atan2(par1, par5) * 180.0 / Math.PI);
      this.field_70127_C = this.field_70125_A = (float)(Math.atan2(par3, var10) * 180.0 / Math.PI);
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
      if (this.field_70173_aa == 0) {
         this.rotation = this.field_70170_p.field_73012_v.nextInt(360);
         this.slide = this.field_70170_p.field_73012_v.nextInt(21) - 10;
      }

      if (this.gravity) {
         this.field_70181_x -= 0.05F;
      }

      this.field_70173_aa++;
      this.rotation = this.rotation + (int)this.slide;
      this.slide = (float)(this.slide * 0.9);
      if (this.field_70173_aa >= RivalRebels.plasmoidDecay * (this.gravity ? 3 : 1)) {
         this.explode();
      }

      Vec3 vec31 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      Vec3 vec3 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
      MovingObjectPosition mop = this.field_70170_p.func_147447_a(vec31, vec3, false, true, false);
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
         if (entity.func_70067_L() && (entity != this.thrower || this.field_70173_aa >= 5)) {
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

      if (mop != null) {
         this.explode();
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
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
   }

   @Override
   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
   }

   @Override
   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
   }

   protected void explode() {
      if (!this.field_70170_p.field_72995_K) {
         this.func_70106_y();
         Block block = Blocks.field_150348_b;

         int i;
         for (i = -1;
            (block.func_149662_c() || BlackList.plasmaExplosion(block)) && i < 4;
            block = this.field_70170_p
               .func_147439_a(
                  (int)(this.field_70165_t - this.field_70159_w * i),
                  (int)(this.field_70163_u - this.field_70181_x * i),
                  (int)(this.field_70161_v - this.field_70179_y * i)
               )
         ) {
            i++;
         }

         this.field_70170_p
            .func_147449_b(
               (int)(this.field_70165_t - this.field_70159_w * i),
               (int)(this.field_70163_u - this.field_70181_x * i),
               (int)(this.field_70161_v - this.field_70179_y * i),
               RivalRebels.plasmaexplosion
            );
      }
   }

   @Override
   protected void func_70088_a() {
   }
}
