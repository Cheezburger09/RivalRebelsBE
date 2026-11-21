package assets.rivalrebels.common.entity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.BlackList;
import assets.rivalrebels.common.core.RivalRebelsDamageSource;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityRaytrace extends EntityInanimate {
   public Entity shootingEntity;
   private int ticksInAir = 0;
   private float range = 0.0F;
   private float c;

   public EntityRaytrace(World par1World) {
      super(par1World);
      this.func_70105_a(0.5F, 0.5F);
   }

   public EntityRaytrace(World par1World, double x, double y, double z, double mx, double my, double mz) {
      super(par1World);
      this.func_70105_a(0.5F, 0.5F);
      this.func_70107_b(x, y, z);
      this.field_70129_M = 0.0F;
      this.setAnglesMotion(mx, my, mz);
      this.c = 1.0F;
      this.range = MathHelper.func_76133_a(mx * mx + my * my + mz * mz);
   }

   public void setAnglesMotion(double mx, double my, double mz) {
      this.field_70159_w = mx;
      this.field_70181_x = my;
      this.field_70179_y = mz;
      this.field_70126_B = this.field_70177_z = (float)(Math.atan2(mx, mz) * 180.0 / Math.PI);
      this.field_70127_C = this.field_70125_A = (float)(Math.atan2(my, MathHelper.func_76133_a(mx * mx + mz * mz)) * 180.0 / Math.PI);
   }

   public EntityRaytrace(World par1World, EntityPlayer player, float distance, float randomness, float chance, boolean shift) {
      super(par1World);
      this.c = chance;
      this.range = distance;
      this.shootingEntity = player;
      this.func_70105_a(0.5F, 0.5F);
      this.func_70012_b(player.field_70165_t, player.field_70163_u + player.func_70047_e(), player.field_70161_v, player.field_70177_z, player.field_70125_A);
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      this.field_70129_M = 0.0F;
      this.field_70159_w = -MathHelper.func_76126_a(this.field_70177_z / 180.0F * (float) Math.PI)
         * MathHelper.func_76134_b(this.field_70125_A / 180.0F * (float) Math.PI);
      this.field_70179_y = MathHelper.func_76134_b(this.field_70177_z / 180.0F * (float) Math.PI)
         * MathHelper.func_76134_b(this.field_70125_A / 180.0F * (float) Math.PI);
      this.field_70181_x = -MathHelper.func_76126_a(this.field_70125_A / 180.0F * (float) Math.PI);
      if (shift) {
         this.field_70165_t = this.field_70165_t - MathHelper.func_76134_b(this.field_70177_z / 180.0F * (float) Math.PI) * 0.16F;
         this.field_70161_v = this.field_70161_v - MathHelper.func_76126_a(this.field_70177_z / 180.0F * (float) Math.PI) * 0.16F;
         this.field_70165_t = this.field_70165_t + this.field_70159_w;
         this.field_70163_u = this.field_70163_u + this.field_70181_x;
         this.field_70161_v = this.field_70161_v + this.field_70179_y;
      } else {
         this.field_70163_u -= 0.05F;
         this.field_70165_t = this.field_70165_t - MathHelper.func_76134_b(this.field_70177_z / 180.0F * (float) Math.PI) * 0.3F;
         this.field_70161_v = this.field_70161_v - MathHelper.func_76126_a(this.field_70177_z / 180.0F * (float) Math.PI) * 0.3F;
      }

      this.setArrowHeading(this.field_70159_w, this.field_70181_x, this.field_70179_y, this.range, randomness);
   }

   @Override
   protected void func_70088_a() {
   }

   public void setArrowHeading(double par1, double par3, double par5, float par7, float par8) {
      float var9 = MathHelper.func_76133_a(par1 * par1 + par3 * par3 + par5 * par5);
      par1 /= var9;
      par3 /= var9;
      par5 /= var9;
      par1 += this.field_70170_p.field_73012_v.nextGaussian() * par8;
      par3 += this.field_70170_p.field_73012_v.nextGaussian() * par8;
      par5 += this.field_70170_p.field_73012_v.nextGaussian() * par8;
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

   public void func_70071_h_() {
      super.func_70071_h_();
      Vec3 vec31 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      Vec3 vec3 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
      MovingObjectPosition MOP = this.field_70170_p.func_147447_a(vec31, vec3, false, true, false);
      vec31 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      if (MOP != null) {
         vec3 = Vec3.func_72443_a(MOP.field_72307_f.field_72450_a, MOP.field_72307_f.field_72448_b, MOP.field_72307_f.field_72449_c);
      } else {
         vec3 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
      }

      List list = this.field_70170_p
         .func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(1.0, 30.0, 1.0));
      double d0 = Double.MAX_VALUE;

      for (int i = 0; i < list.size(); i++) {
         Entity entity = (Entity)list.get(i);
         if ((entity.func_70067_L() || entity instanceof EntityRhodes) && entity != this.shootingEntity) {
            MovingObjectPosition mop1 = entity.field_70121_D.func_72314_b(0.5, 0.5, 0.5).func_72327_a(vec31, vec3);
            if (mop1 != null) {
               double d1 = vec31.func_72436_e(mop1.field_72307_f);
               if (d1 < d0) {
                  MOP = new MovingObjectPosition(entity, mop1.field_72307_f);
                  d0 = d1;
               }
            }
         }
      }

      if (MOP != null) {
         if (MOP.field_72308_g == null) {
            if (!this.field_70170_p.field_72995_K) {
               this.field_70170_p
                  .func_72838_d(
                     new EntityLightningLink(
                        this.field_70170_p,
                        this,
                        this.func_70011_f(MOP.field_72307_f.field_72450_a, MOP.field_72307_f.field_72448_b, MOP.field_72307_f.field_72449_c)
                     )
                  );
            }

            Block BlockHit = this.field_70170_p.func_147439_a(MOP.field_72311_b, MOP.field_72312_c, MOP.field_72309_d);
            float r = this.field_70170_p.field_73012_v.nextFloat();
            if (BlockHit == RivalRebels.camo1 || BlockHit == RivalRebels.camo2 || BlockHit == RivalRebels.camo3) {
               if (r * 10.0F <= this.c) {
                  if (!this.field_70170_p.field_72995_K) {
                     this.field_70170_p.func_147449_b(MOP.field_72311_b, MOP.field_72312_c, MOP.field_72309_d, Blocks.field_150350_a);
                  }

                  for (int i = 0; i < 4; i++) {
                     this.field_70170_p
                        .func_72869_a(
                           "explode",
                           MOP.field_72311_b,
                           MOP.field_72312_c - 1 + i * 0.5,
                           MOP.field_72309_d,
                           (this.field_70170_p.field_73012_v.nextFloat() - 0.5F) * 0.1,
                           this.field_70170_p.field_73012_v.nextFloat() * 0.05,
                           (this.field_70170_p.field_73012_v.nextFloat() - 0.5F) * 0.1
                        );
                  }
               }
            } else if (BlockHit == RivalRebels.reactive) {
               if (r * 15.0F <= this.c) {
                  if (!this.field_70170_p.field_72995_K) {
                     this.field_70170_p.func_147449_b(MOP.field_72311_b, MOP.field_72312_c, MOP.field_72309_d, Blocks.field_150350_a);
                  }

                  for (int i = 0; i < 4; i++) {
                     this.field_70170_p
                        .func_72869_a(
                           "explode",
                           MOP.field_72311_b,
                           MOP.field_72312_c - 1 + i * 0.5,
                           MOP.field_72309_d,
                           (this.field_70170_p.field_73012_v.nextFloat() - 0.5F) * 0.1,
                           this.field_70170_p.field_73012_v.nextFloat() * 0.05,
                           (this.field_70170_p.field_73012_v.nextFloat() - 0.5F) * 0.1
                        );
                  }
               }
            } else if (!BlackList.tesla(BlockHit) && r <= this.c) {
               if (!this.field_70170_p.field_72995_K) {
                  this.field_70170_p.func_147449_b(MOP.field_72311_b, MOP.field_72312_c, MOP.field_72309_d, Blocks.field_150350_a);
               }

               for (int i = 0; i < 4; i++) {
                  this.field_70170_p
                     .func_72869_a(
                        "explode",
                        MOP.field_72311_b,
                        MOP.field_72312_c - 1 + i * 0.5,
                        MOP.field_72309_d,
                        (this.field_70170_p.field_73012_v.nextFloat() - 0.5F) * 0.1,
                        this.field_70170_p.field_73012_v.nextFloat() * 0.05,
                        (this.field_70170_p.field_73012_v.nextFloat() - 0.5F) * 0.1
                     );
               }
            }
         } else {
            if (!this.field_70170_p.field_72995_K) {
               this.field_70170_p.func_72838_d(new EntityLightningLink(this.field_70170_p, this, this.func_70032_d(MOP.field_72308_g)));
            }

            if (MOP.field_72308_g instanceof EntityPlayer) {
               EntityPlayer entityPlayerHit = (EntityPlayer)MOP.field_72308_g;
               ItemStack[] armorSlots = entityPlayerHit.field_71071_by.field_70460_b;
               int i = this.field_70170_p.field_73012_v.nextInt(4);
               if (armorSlots[i] != null) {
                  armorSlots[i].func_77972_a(14, entityPlayerHit);
                  entityPlayerHit.func_70097_a(RivalRebelsDamageSource.electricity, 1.0F);
               } else {
                  entityPlayerHit.func_70097_a(
                     RivalRebelsDamageSource.electricity, RivalRebels.teslaDecay / ((int)MOP.field_72308_g.func_70032_d(this) + 1) / (i + 1)
                  );
               }
            } else if (MOP.field_72308_g instanceof EntityB2Spirit) {
               MOP.field_72308_g
                  .func_70097_a(RivalRebelsDamageSource.electricity, RivalRebels.teslaDecay / 1.5F / ((int)MOP.field_72308_g.func_70032_d(this) + 1));
            } else {
               MOP.field_72308_g.func_70097_a(RivalRebelsDamageSource.electricity, RivalRebels.teslaDecay / ((int)MOP.field_72308_g.func_70032_d(this) + 1));
            }
         }
      } else if (!this.field_70170_p.field_72995_K) {
         this.field_70170_p.func_72838_d(new EntityLightningLink(this.field_70170_p, this, this.range));
      }

      this.func_70106_y();
   }

   @Override
   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
   }

   @Override
   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
   }
}
