package assets.rivalrebels.common.entity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityGasGrenade extends EntityInanimate {
   private boolean inGround = false;
   public Entity shootingEntity;
   private int ticksInAir = 0;

   public EntityGasGrenade(World par1World) {
      super(par1World);
      this.func_70105_a(0.5F, 0.5F);
   }

   public EntityGasGrenade(World par1World, double par2, double par4, double par6) {
      super(par1World);
      this.func_70105_a(0.5F, 0.5F);
      this.func_70107_b(par2, par4, par6);
      this.field_70129_M = 0.0F;
   }

   public EntityGasGrenade(World par1World, double x, double y, double z, double mx, double my, double mz) {
      super(par1World);
      this.func_70105_a(0.5F, 0.5F);
      this.func_70107_b(x, y, z);
      this.field_70129_M = 0.0F;
      this.setAnglesMotion(mx, my, mz);
   }

   public void setAnglesMotion(double mx, double my, double mz) {
      this.field_70159_w = mx;
      this.field_70181_x = my;
      this.field_70179_y = mz;
      this.field_70126_B = this.field_70177_z = (float)(Math.atan2(mx, mz) * 180.0 / Math.PI);
      this.field_70127_C = this.field_70125_A = (float)(Math.atan2(my, MathHelper.func_76133_a(mx * mx + mz * mz)) * 180.0 / Math.PI);
   }

   public EntityGasGrenade(World par1World, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving, float par4, float par5) {
      super(par1World);
      this.shootingEntity = par2EntityLiving;
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
         this.setArrowHeading(var6, var8 + var20, var10, par4, par5);
      }
   }

   public EntityGasGrenade(World par1World, EntityPlayer player, float par3) {
      super(par1World);
      this.shootingEntity = player;
      this.func_70105_a(0.5F, 0.5F);
      this.func_70012_b(player.field_70165_t, player.field_70163_u + player.func_70047_e(), player.field_70161_v, player.field_70177_z, player.field_70125_A);
      this.field_70165_t = this.field_70165_t - MathHelper.func_76134_b(this.field_70177_z / 180.0F * (float) Math.PI) * 0.16F;
      this.field_70163_u -= 0.1F;
      this.field_70161_v = this.field_70161_v - MathHelper.func_76126_a(this.field_70177_z / 180.0F * (float) Math.PI) * 0.16F;
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      this.field_70129_M = 0.0F;
      this.field_70159_w = -MathHelper.func_76126_a(this.field_70177_z / 180.0F * (float) Math.PI)
         * MathHelper.func_76134_b(this.field_70125_A / 180.0F * (float) Math.PI);
      this.field_70179_y = MathHelper.func_76134_b(this.field_70177_z / 180.0F * (float) Math.PI)
         * MathHelper.func_76134_b(this.field_70125_A / 180.0F * (float) Math.PI);
      this.field_70181_x = -MathHelper.func_76126_a(this.field_70125_A / 180.0F * (float) Math.PI);
      this.setArrowHeading(this.field_70159_w, this.field_70181_x, this.field_70179_y, par3 * 1.5F, 1.0F);
   }

   @Override
   protected void func_70088_a() {
      this.field_70180_af.func_75682_a(16, (byte)0);
   }

   public void setArrowHeading(double par1, double par3, double par5, float par7, float par8) {
      float var9 = MathHelper.func_76133_a(par1 * par1 + par3 * par3 + par5 * par5);
      par1 /= var9;
      par3 /= var9;
      par5 /= var9;
      par1 += this.field_70146_Z.nextGaussian() * 0.0075F * par8;
      par3 += this.field_70146_Z.nextGaussian() * 0.0075F * par8;
      par5 += this.field_70146_Z.nextGaussian() * 0.0075F * par8;
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

   @SideOnly(Side.CLIENT)
   public void func_70056_a(double par1, double par3, double par5, float par7, float par8, int par9) {
      this.func_70107_b(par1, par3, par5);
      this.func_70101_b(par7, par8);
   }

   @SideOnly(Side.CLIENT)
   public void func_70016_h(double par1, double par3, double par5) {
      this.field_70159_w = par1;
      this.field_70181_x = par3;
      this.field_70179_y = par5;
      if (this.field_70127_C == 0.0F && this.field_70126_B == 0.0F) {
         float var7 = MathHelper.func_76133_a(par1 * par1 + par5 * par5);
         this.field_70126_B = this.field_70177_z = (float)(Math.atan2(par1, par5) * 180.0 / Math.PI);
         this.field_70127_C = this.field_70125_A = (float)(Math.atan2(par3, var7) * 180.0 / Math.PI);
         this.field_70127_C = this.field_70125_A;
         this.field_70126_B = this.field_70177_z;
         this.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
      }
   }

   public void func_70071_h_() {
      super.func_70071_h_();
      if (this.field_70127_C == 0.0F && this.field_70126_B == 0.0F) {
         float var1 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
         this.field_70126_B = this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0 / Math.PI);
         this.field_70127_C = this.field_70125_A = (float)(Math.atan2(this.field_70181_x, var1) * 180.0 / Math.PI);
      }

      this.ticksInAir++;
      Vec3 var17 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      Vec3 var3 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
      MovingObjectPosition var4 = this.field_70170_p.func_147447_a(var17, var3, false, true, false);
      var17 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      var3 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
      if (var4 != null) {
         var3 = Vec3.func_72443_a(var4.field_72307_f.field_72450_a, var4.field_72307_f.field_72448_b, var4.field_72307_f.field_72449_c);
      }

      Entity var5 = null;
      List var6 = this.field_70170_p
         .func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(1.0, 1.0, 1.0));
      double var7 = 0.0;
      Iterator var9 = var6.iterator();
      if (!this.field_70170_p.field_72995_K) {
         while (var9.hasNext()) {
            Entity var10 = (Entity)var9.next();
            if (var10.func_70067_L() && (var10 != this.shootingEntity || this.ticksInAir >= 5)) {
               AxisAlignedBB var12 = var10.field_70121_D.func_72314_b(0.3F, 0.3F, 0.3F);
               MovingObjectPosition var13 = var12.func_72327_a(var17, var3);
               if (var13 != null) {
                  double var14 = var17.func_72438_d(var13.field_72307_f);
                  if (var14 < var7 || var7 == 0.0) {
                     var5 = var10;
                     var7 = var14;
                  }
               }
            }
         }
      }

      if (var5 != null) {
         var4 = new MovingObjectPosition(var5);
      }

      if (var4 != null) {
         this.pop();
         this.func_70106_y();
      }

      this.field_70165_t = this.field_70165_t + this.field_70159_w;
      this.field_70163_u = this.field_70163_u + this.field_70181_x;
      this.field_70161_v = this.field_70161_v + this.field_70179_y;
      float var20 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
      this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0 / Math.PI);
      this.field_70125_A = (float)(Math.atan2(this.field_70181_x, var20) * 180.0 / Math.PI);

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
      this.field_70125_A += 90.0F;
      if (this.field_70125_A <= -270.0F) {
         this.field_70125_A = 90.0F;
      }

      float var23 = 0.9999F;
      if (this.func_70090_H()) {
         for (int var26 = 0; var26 < 4; var26++) {
            float var27 = 0.25F;
            this.field_70170_p
               .func_72869_a(
                  "bubble",
                  this.field_70165_t - this.field_70159_w * var27,
                  this.field_70163_u - this.field_70181_x * var27,
                  this.field_70161_v - this.field_70179_y * var27,
                  this.field_70159_w,
                  this.field_70181_x,
                  this.field_70179_y
               );
         }

         var23 = 0.8F;
      }

      this.field_70159_w *= var23;
      this.field_70181_x *= var23;
      this.field_70179_y *= var23;
      this.field_70181_x -= 0.03F;
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      this.func_145775_I();
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

   public boolean func_70075_an() {
      return false;
   }

   public void func_70243_d(boolean par1) {
      byte var2 = this.field_70180_af.func_75683_a(16);
      if (par1) {
         this.field_70180_af.func_75692_b(16, (byte)(var2 | 1));
      } else {
         this.field_70180_af.func_75692_b(16, (byte)(var2 & -2));
      }
   }

   public boolean func_70241_g() {
      byte var1 = this.field_70180_af.func_75683_a(16);
      return (var1 & 1) != 0;
   }

   private void pop() {
      RivalRebelsSoundPlayer.playSound(this, 9, 1);

      for (int x = -4; x <= 4; x++) {
         for (int y = -4; y <= 4; y++) {
            for (int z = -4; z <= 4; z++) {
               if (this.field_70170_p.func_147439_a((int)this.field_70165_t + x, (int)this.field_70163_u + y, (int)this.field_70161_v + z)
                  == Blocks.field_150350_a) {
                  this.field_70170_p.func_147449_b((int)this.field_70165_t + x, (int)this.field_70163_u + y, (int)this.field_70161_v + z, RivalRebels.toxicgas);
               }
            }
         }
      }
   }
}
