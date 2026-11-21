package assets.rivalrebels.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityWeatherEffect;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityLightningBolt2 extends EntityWeatherEffect {
   private int lightningState;
   public long boltVertex = 0L;
   private int boltLivingTime;

   public EntityLightningBolt2(World par1World, double par2, double par4, double par6) {
      super(par1World);
      this.func_70012_b(par2, par4, par6, 0.0F, 0.0F);
      this.lightningState = 2;
      this.boltVertex = this.field_70146_Z.nextLong();
      this.boltLivingTime = this.field_70146_Z.nextInt(3) + 1;
   }

   public void func_70071_h_() {
      super.func_70071_h_();
      if (this.lightningState == 2) {
         this.field_70170_p
            .func_72908_a(
               this.field_70165_t, this.field_70163_u, this.field_70161_v, "ambient.weather.thunder", 10000.0F, 0.8F + this.field_70146_Z.nextFloat() * 0.2F
            );
         this.field_70170_p
            .func_72908_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, "random.explode", 2.0F, 0.5F + this.field_70146_Z.nextFloat() * 0.2F);
      }

      this.lightningState--;
      if (this.lightningState < 0) {
         if (this.boltLivingTime == 0) {
            this.func_70106_y();
         } else if (this.lightningState < -this.field_70146_Z.nextInt(10)) {
            this.boltLivingTime--;
            this.lightningState = 1;
            this.boltVertex = this.field_70146_Z.nextLong();
         }
      }

      if (this.lightningState >= 0) {
         double var6 = 3.0;

         for (Entity var5 : this.field_70170_p
            .func_72839_b(
               this,
               AxisAlignedBB.func_72330_a(
                  this.field_70165_t - var6,
                  this.field_70163_u - var6,
                  this.field_70161_v - var6,
                  this.field_70165_t + var6,
                  this.field_70163_u + 6.0 + var6,
                  this.field_70161_v + var6
               )
            )) {
            ;
         }

         this.field_70170_p.field_73016_r = 2;
      }
   }

   protected void func_70088_a() {
   }

   protected void func_70037_a(NBTTagCompound par1NBTTagCompound) {
   }

   protected void func_70014_b(NBTTagCompound par1NBTTagCompound) {
   }
}
