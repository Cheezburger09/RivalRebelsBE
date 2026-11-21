package assets.rivalrebels.common.entity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsDamageSource;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityLaserBurst extends EntityInanimate {
   private EntityPlayer shooter;

   public EntityLaserBurst(World par1World) {
      super(par1World);
      this.func_70105_a(0.5F, 0.5F);
   }

   public EntityLaserBurst(World par1World, EntityPlayer player) {
      super(par1World);
      this.shooter = player;
      this.func_70105_a(0.5F, 0.5F);
      this.func_70012_b(player.field_70165_t, player.field_70163_u + player.func_70047_e(), player.field_70161_v, player.field_70177_z, player.field_70125_A);
      this.field_70165_t = this.field_70165_t - MathHelper.func_76134_b(this.field_70177_z / 180.0F * (float) Math.PI) * 0.2F;
      this.field_70163_u -= 0.12;
      this.field_70161_v = this.field_70161_v - MathHelper.func_76126_a(this.field_70177_z / 180.0F * (float) Math.PI) * 0.2F;
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      this.field_70129_M = 0.0F;
      this.field_70159_w = -MathHelper.func_76126_a(this.field_70177_z / 180.0F * (float) Math.PI)
         * MathHelper.func_76134_b(this.field_70125_A / 180.0F * (float) Math.PI);
      this.field_70179_y = MathHelper.func_76134_b(this.field_70177_z / 180.0F * (float) Math.PI)
         * MathHelper.func_76134_b(this.field_70125_A / 180.0F * (float) Math.PI);
      this.field_70181_x = -MathHelper.func_76126_a(this.field_70125_A / 180.0F * (float) Math.PI);
      this.setAccurateHeading(this.field_70159_w, this.field_70181_x, this.field_70179_y, 4.0F, 0.075F);
   }

   public EntityLaserBurst(World par1World, EntityPlayer player, boolean accurate) {
      super(par1World);
      this.shooter = player;
      this.func_70105_a(0.5F, 0.5F);
      this.func_70012_b(player.field_70165_t, player.field_70163_u + player.func_70047_e(), player.field_70161_v, player.field_70177_z, player.field_70125_A);
      this.field_70165_t = this.field_70165_t - MathHelper.func_76134_b(this.field_70177_z / 180.0F * (float) Math.PI) * 0.2F;
      this.field_70163_u -= 0.12;
      this.field_70161_v = this.field_70161_v - MathHelper.func_76126_a(this.field_70177_z / 180.0F * (float) Math.PI) * 0.2F;
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      this.field_70129_M = 0.0F;
      this.field_70159_w = -MathHelper.func_76126_a(this.field_70177_z / 180.0F * (float) Math.PI)
         * MathHelper.func_76134_b(this.field_70125_A / 180.0F * (float) Math.PI);
      this.field_70179_y = MathHelper.func_76134_b(this.field_70177_z / 180.0F * (float) Math.PI)
         * MathHelper.func_76134_b(this.field_70125_A / 180.0F * (float) Math.PI);
      this.field_70181_x = -MathHelper.func_76126_a(this.field_70125_A / 180.0F * (float) Math.PI);
      this.setAccurateHeading(this.field_70159_w, this.field_70181_x, this.field_70179_y, 4.0F * (float)Math.random() + 1.0F, accurate ? 0.001F : 0.075F);
   }

   public EntityLaserBurst(World par1World, double x, double y, double z, double mx, double my, double mz) {
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

   public EntityLaserBurst(World par1World, double x, double y, double z, double mx, double my, double mz, EntityPlayer player) {
      super(par1World);
      this.shooter = player;
      this.func_70105_a(0.5F, 0.5F);
      this.func_70107_b(x, y, z);
      this.field_70129_M = 0.0F;
      this.field_70159_w = mx;
      this.field_70179_y = mz;
      this.field_70181_x = my;
   }

   public void setAccurateHeading(double par1, double par3, double par5, float par7, float par8) {
      float var9 = MathHelper.func_76133_a(par1 * par1 + par3 * par3 + par5 * par5);
      par1 /= var9;
      par3 /= var9;
      par5 /= var9;
      par1 += this.field_70146_Z.nextGaussian() * par8;
      par3 += this.field_70146_Z.nextGaussian() * par8;
      par5 += this.field_70146_Z.nextGaussian() * par8;
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
      this.field_70173_aa++;
      if (this.field_70173_aa > 60) {
         this.func_70106_y();
      }

      Vec3 var15 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      Vec3 var2 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
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
            if (var9.func_70067_L() && var9 != this.shooter) {
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
         if (var3.field_72308_g == null) {
            Block blockID = this.field_70170_p.func_147439_a(var3.field_72311_b, var3.field_72312_c, var3.field_72309_d);
            if (blockID == Blocks.field_150335_W && !this.field_70170_p.field_72995_K) {
               EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(
                  this.field_70170_p, var3.field_72311_b + 0.5F, var3.field_72312_c + 0.5F, var3.field_72309_d + 0.5F, this.shooter
               );
               entitytntprimed.field_70516_a = this.field_70170_p.field_73012_v.nextInt(entitytntprimed.field_70516_a / 4) + entitytntprimed.field_70516_a / 8;
               this.field_70170_p.func_72838_d(entitytntprimed);
               this.field_70170_p.func_147468_f(var3.field_72311_b, var3.field_72312_c, var3.field_72309_d);
            }

            if (blockID == RivalRebels.remotecharge) {
               RivalRebels.remotecharge.func_149723_a(this.field_70170_p, var3.field_72311_b, var3.field_72312_c, var3.field_72309_d, null);
            }

            if (blockID == RivalRebels.timedbomb) {
               RivalRebels.timedbomb.func_149723_a(this.field_70170_p, var3.field_72311_b, var3.field_72312_c, var3.field_72309_d, null);
            }

            this.func_70106_y();
         } else if (var3.field_72308_g instanceof EntityPlayer && this.shooter != var3.field_72308_g) {
            EntityPlayer player = (EntityPlayer)var3.field_72308_g;
            ItemStack[] armorSlots = player.field_71071_by.field_70460_b;
            int i = this.field_70170_p.field_73012_v.nextInt(4);
            if (armorSlots[i] != null && !this.field_70170_p.field_72995_K) {
               armorSlots[i].func_77972_a(24, player);
            }

            player.func_70097_a(RivalRebelsDamageSource.laserburst, 16.0F);
            if (player.func_110143_aJ() < 3.0F && player.func_70089_S()) {
               player.func_70097_a(RivalRebelsDamageSource.laserburst, 2000000.0F);
               player.field_70725_aQ = 0;
               this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, var3.field_72308_g, 0, 0));
               this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, var3.field_72308_g, 1, 0));
               this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, var3.field_72308_g, 2, 0));
               this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, var3.field_72308_g, 2, 0));
               this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, var3.field_72308_g, 3, 0));
               this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, var3.field_72308_g, 3, 0));
            }

            this.func_70106_y();
         } else if (var3.field_72308_g instanceof EntityLivingBase
            && !(var3.field_72308_g instanceof EntityAnimal)
            && !(var3.field_72308_g instanceof EntityBat)
            && !(var3.field_72308_g instanceof EntityVillager)
            && !(var3.field_72308_g instanceof EntitySquid)) {
            EntityLivingBase entity = (EntityLivingBase)var3.field_72308_g;
            entity.func_70097_a(RivalRebelsDamageSource.laserburst, 6.0F);
            if (entity.func_110143_aJ() < 3.0F) {
               int legs = -1;
               int arms = -1;
               int mobs = -1;
               entity.func_70106_y();
               RivalRebelsSoundPlayer.playSound(this, 2, 1, 4.0F);
               byte var28;
               if (entity instanceof EntityZombie && !(entity instanceof EntityPigZombie)) {
                  legs = 2;
                  arms = 2;
                  var28 = 1;
               } else if (entity instanceof EntityPigZombie) {
                  legs = 2;
                  arms = 2;
                  var28 = 2;
               } else if (entity instanceof EntitySkeleton) {
                  legs = 2;
                  arms = 2;
                  var28 = 3;
               } else if (entity instanceof EntityEnderman) {
                  legs = 2;
                  arms = 2;
                  var28 = 4;
               } else if (entity instanceof EntityCreeper) {
                  legs = 4;
                  arms = 0;
                  var28 = 5;
               } else if (entity instanceof EntitySlime && !(entity instanceof EntityMagmaCube)) {
                  legs = 0;
                  arms = 0;
                  var28 = 6;
               } else if (entity instanceof EntityMagmaCube) {
                  legs = 0;
                  arms = 0;
                  var28 = 7;
               } else if (entity instanceof EntitySpider && !(entity instanceof EntityCaveSpider)) {
                  legs = 8;
                  arms = 0;
                  var28 = 8;
               } else if (entity instanceof EntityCaveSpider) {
                  legs = 8;
                  arms = 0;
                  var28 = 9;
               } else if (entity instanceof EntityGhast) {
                  legs = 9;
                  arms = 0;
                  var28 = 10;
               } else {
                  legs = (int)(entity.field_70121_D.func_72320_b() * 2.0);
                  arms = (int)(entity.field_70121_D.func_72320_b() * 2.0);
                  var28 = 11;
               }

               this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, var3.field_72308_g, 0, var28));
               this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, var3.field_72308_g, 1, var28));

               for (int i = 0; i < arms; i++) {
                  this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, var3.field_72308_g, 2, var28));
               }

               for (int i = 0; i < legs; i++) {
                  this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, var3.field_72308_g, 3, var28));
               }
            }

            this.func_70106_y();
         } else if (var3.field_72308_g instanceof EntityRhodesHead
            || var3.field_72308_g instanceof EntityRhodesLeftLowerArm
            || var3.field_72308_g instanceof EntityRhodesLeftLowerLeg
            || var3.field_72308_g instanceof EntityRhodesLeftUpperArm
            || var3.field_72308_g instanceof EntityRhodesLeftUpperLeg
            || var3.field_72308_g instanceof EntityRhodesRightLowerArm
            || var3.field_72308_g instanceof EntityRhodesRightLowerLeg
            || var3.field_72308_g instanceof EntityRhodesRightUpperArm
            || var3.field_72308_g instanceof EntityRhodesRightUpperLeg
            || var3.field_72308_g instanceof EntityRhodesTorso) {
            var3.field_72308_g.func_70097_a(RivalRebelsDamageSource.laserburst, 6.0F);
         }
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

   @Override
   protected void func_70088_a() {
   }
}
