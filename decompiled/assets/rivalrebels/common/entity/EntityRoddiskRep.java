package assets.rivalrebels.common.entity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsDamageSource;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
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
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityRoddiskRep extends EntityInanimate {
   public EntityPlayer shooter;

   public EntityRoddiskRep(World par1World) {
      super(par1World);
   }

   public EntityRoddiskRep(World par1World, EntityPlayer par2EntityLiving, float par3) {
      super(par1World);
      this.shooter = par2EntityLiving;
      this.func_70105_a(0.5F, 0.5F);
      this.field_70121_D.func_72324_b(-0.4, -0.0625, -0.4, 0.4, 0.0625, 0.4);
      this.func_70012_b(
         par2EntityLiving.field_70165_t,
         par2EntityLiving.field_70163_u + par2EntityLiving.func_70047_e(),
         par2EntityLiving.field_70161_v,
         par2EntityLiving.field_70177_z,
         par2EntityLiving.field_70125_A
      );
      this.field_70165_t = this.field_70165_t - MathHelper.func_76134_b(this.field_70177_z / 180.0F * (float) Math.PI) * 0.16F;
      this.field_70163_u -= 0.1;
      this.field_70161_v = this.field_70161_v - MathHelper.func_76126_a(this.field_70177_z / 180.0F * (float) Math.PI) * 0.16F;
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      this.field_70129_M = 0.0F;
      this.field_70159_w = -MathHelper.func_76126_a(this.field_70177_z / 180.0F * (float) Math.PI)
         * MathHelper.func_76134_b(this.field_70125_A / 180.0F * (float) Math.PI);
      this.field_70179_y = MathHelper.func_76134_b(this.field_70177_z / 180.0F * (float) Math.PI)
         * MathHelper.func_76134_b(this.field_70125_A / 180.0F * (float) Math.PI);
      this.field_70181_x = -MathHelper.func_76126_a(this.field_70125_A / 180.0F * (float) Math.PI);
      this.setHeading(this.field_70159_w, this.field_70181_x, this.field_70179_y, par3 * 1.5F, 1.0F);
   }

   public void setHeading(double par1, double par3, double par5, float par7, float par8) {
      float var9 = MathHelper.func_76133_a(par1 * par1 + par3 * par3 + par5 * par5);
      par1 /= var9;
      par3 /= var9;
      par5 /= var9;
      par1 += this.field_70146_Z.nextGaussian() * 0.005 * par8;
      par3 += this.field_70146_Z.nextGaussian() * 0.005 * par8;
      par5 += this.field_70146_Z.nextGaussian() * 0.005 * par8;
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

   @Override
   protected void func_70088_a() {
   }

   public void func_70071_h_() {
      this.field_70142_S = this.field_70165_t;
      this.field_70137_T = this.field_70163_u;
      this.field_70136_U = this.field_70161_v;
      if (this.field_70173_aa > 100 && this.shooter == null && !this.field_70170_p.field_72995_K) {
         this.func_70106_y();
         RivalRebelsSoundPlayer.playSound(this, 5, 0);
      }

      if (this.field_70173_aa >= 120 && !this.field_70170_p.field_72995_K && this.shooter != null) {
         EntityItem ei = new EntityItem(
            this.field_70170_p, this.shooter.field_70165_t, this.shooter.field_70163_u, this.shooter.field_70161_v, new ItemStack(RivalRebels.roddisk)
         );
         this.field_70170_p.func_72838_d(ei);
         this.func_70106_y();
         RivalRebelsSoundPlayer.playSound(this, 6, 1);
      }

      if (this.field_70173_aa == 10) {
         RivalRebelsSoundPlayer.playSound(this, 6, 0);
      }

      if (!this.field_70170_p.field_72995_K) {
         double randx = this.field_70170_p.field_73012_v.nextGaussian();
         double randy = this.field_70170_p.field_73012_v.nextGaussian();
         double d = 1.0 / Math.sqrt(randx * randx + randy * randy);
         this.field_70170_p
            .func_72838_d(
               new EntityLaserBurst(
                  this.field_70170_p,
                  this.field_70165_t,
                  this.field_70163_u,
                  this.field_70161_v,
                  randx * d,
                  -Math.abs(this.field_70181_x),
                  randy * d,
                  this.shooter
               )
            );
      }

      int radius = 2;
      int nx = MathHelper.func_76128_c(this.field_70165_t - radius - 1.0);
      int px = MathHelper.func_76128_c(this.field_70165_t + radius + 1.0);
      int ny = MathHelper.func_76128_c(this.field_70163_u - radius - 1.0);
      int py = MathHelper.func_76128_c(this.field_70163_u + radius + 1.0);
      int nz = MathHelper.func_76128_c(this.field_70161_v - radius - 1.0);
      int pz = MathHelper.func_76128_c(this.field_70161_v + radius + 1.0);
      List par9 = this.field_70170_p.func_72839_b(null, AxisAlignedBB.func_72330_a(nx, ny, nz, px, py, pz));

      for (int var11 = 0; var11 < par9.size(); var11++) {
         Entity var31 = (Entity)par9.get(var11);
         if (var31 instanceof EntityArrow) {
            var31.func_70106_y();
         }
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
            if (var9 instanceof EntityRoddiskRegular
               || var9 instanceof EntityRoddiskRebel
               || var9 instanceof EntityRoddiskLeader
               || var9 instanceof EntityRoddiskOfficer) {
               var9.func_70106_y();
               EntityItem ei = new EntityItem(
                  this.field_70170_p, var9.field_70165_t, var9.field_70163_u, var9.field_70161_v, new ItemStack(RivalRebels.roddisk)
               );
               this.field_70170_p.func_72838_d(ei);
            } else if (var9.func_70067_L() && var9 != this.shooter) {
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
         this.field_70170_p
            .func_72869_a(
               "explode",
               var3.field_72307_f.field_72450_a,
               var3.field_72307_f.field_72448_b,
               var3.field_72307_f.field_72449_c,
               this.field_70159_w * 0.1,
               this.field_70181_x * 0.1,
               this.field_70179_y * 0.1
            );
         this.field_70170_p
            .func_72869_a(
               "explode",
               var3.field_72307_f.field_72450_a,
               var3.field_72307_f.field_72448_b,
               var3.field_72307_f.field_72449_c,
               this.field_70159_w * 0.1,
               this.field_70181_x * 0.1,
               this.field_70179_y * 0.1
            );
         this.field_70170_p
            .func_72869_a(
               "explode",
               var3.field_72307_f.field_72450_a,
               var3.field_72307_f.field_72448_b,
               var3.field_72307_f.field_72449_c,
               this.field_70159_w * 0.1,
               this.field_70181_x * 0.1,
               this.field_70179_y * 0.1
            );
         this.field_70170_p
            .func_72869_a(
               "explode",
               var3.field_72307_f.field_72450_a,
               var3.field_72307_f.field_72448_b,
               var3.field_72307_f.field_72449_c,
               this.field_70159_w * 0.1,
               this.field_70181_x * 0.1,
               this.field_70179_y * 0.1
            );
         if (var3.field_72308_g != null) {
            RivalRebelsSoundPlayer.playSound(this, 5, 1);
            if (var3.field_72308_g instanceof EntityPlayer && var3.field_72308_g != this.shooter) {
               EntityPlayer entityPlayerHit = (EntityPlayer)var3.field_72308_g;
               ItemStack[] armorSlots = entityPlayerHit.field_71071_by.field_70460_b;

               for (int i = 0; i < 4; i++) {
                  if (armorSlots[i] != null) {
                     armorSlots[i].func_77972_a(30, entityPlayerHit);
                     entityPlayerHit.func_70097_a(RivalRebelsDamageSource.tron, 1.0F);
                  } else {
                     entityPlayerHit.func_70097_a(RivalRebelsDamageSource.tron, 15.0F);
                  }
               }

               if (entityPlayerHit.func_110143_aJ() < 3.0F && entityPlayerHit.func_70089_S()) {
                  entityPlayerHit.func_70097_a(RivalRebelsDamageSource.tron, 2000000.0F);
                  entityPlayerHit.field_70725_aQ = 0;
                  this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, var3.field_72308_g, 0, 0));
                  this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, var3.field_72308_g, 1, 0));
                  this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, var3.field_72308_g, 2, 0));
                  this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, var3.field_72308_g, 2, 0));
                  this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, var3.field_72308_g, 3, 0));
                  this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, var3.field_72308_g, 3, 0));
               }
            } else if (var3.field_72308_g instanceof EntityLivingBase
               && !(var3.field_72308_g instanceof EntityAnimal)
               && !(var3.field_72308_g instanceof EntityBat)
               && !(var3.field_72308_g instanceof EntityVillager)
               && !(var3.field_72308_g instanceof EntitySquid)) {
               EntityLivingBase entity = (EntityLivingBase)var3.field_72308_g;
               entity.func_70097_a(RivalRebelsDamageSource.tron, 40.0F);
               if (entity.func_110143_aJ() < 3.0F) {
                  int legs = -1;
                  int arms = -1;
                  int mobs = -1;
                  entity.func_70106_y();
                  RivalRebelsSoundPlayer.playSound(this, 2, 1, 4.0F);
                  byte var41;
                  if (entity instanceof EntityZombie && !(entity instanceof EntityPigZombie)) {
                     legs = 2;
                     arms = 2;
                     var41 = 1;
                  } else if (entity instanceof EntityPigZombie) {
                     legs = 2;
                     arms = 2;
                     var41 = 2;
                  } else if (entity instanceof EntitySkeleton) {
                     legs = 2;
                     arms = 2;
                     var41 = 3;
                  } else if (entity instanceof EntityEnderman) {
                     legs = 2;
                     arms = 2;
                     var41 = 4;
                  } else if (entity instanceof EntityCreeper) {
                     legs = 4;
                     arms = 0;
                     var41 = 5;
                  } else if (entity instanceof EntitySlime && !(entity instanceof EntityMagmaCube)) {
                     legs = 0;
                     arms = 0;
                     var41 = 6;
                  } else if (entity instanceof EntityMagmaCube) {
                     legs = 0;
                     arms = 0;
                     var41 = 7;
                  } else if (entity instanceof EntitySpider && !(entity instanceof EntityCaveSpider)) {
                     legs = 8;
                     arms = 0;
                     var41 = 8;
                  } else if (entity instanceof EntityCaveSpider) {
                     legs = 8;
                     arms = 0;
                     var41 = 9;
                  } else if (entity instanceof EntityGhast) {
                     legs = 9;
                     arms = 0;
                     var41 = 10;
                  } else {
                     legs = (int)(entity.field_70121_D.func_72320_b() * 2.0);
                     arms = (int)(entity.field_70121_D.func_72320_b() * 2.0);
                     var41 = 11;
                  }

                  this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, var3.field_72308_g, 0, var41));
                  this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, var3.field_72308_g, 1, var41));

                  for (int i = 0; i < arms; i++) {
                     this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, var3.field_72308_g, 2, var41));
                  }

                  for (int i = 0; i < legs; i++) {
                     this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, var3.field_72308_g, 3, var41));
                  }
               }
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
               var3.field_72308_g.func_70097_a(RivalRebelsDamageSource.tron, 20.0F);
            }
         } else if (this.field_70170_p.func_147439_a(var3.field_72311_b, var3.field_72312_c, var3.field_72309_d) == RivalRebels.flare) {
            RivalRebels.flare.func_149664_b(this.field_70170_p, var3.field_72311_b, var3.field_72312_c, var3.field_72309_d, 0);
         } else if (this.field_70170_p.func_147439_a(var3.field_72311_b, var3.field_72312_c, var3.field_72309_d) != RivalRebels.landmine
            && this.field_70170_p.func_147439_a(var3.field_72311_b, var3.field_72312_c, var3.field_72309_d) != RivalRebels.alandmine) {
            Block block = this.field_70170_p.func_147439_a(var3.field_72311_b, var3.field_72312_c, var3.field_72309_d);
            if (block == Blocks.field_150359_w || block == Blocks.field_150410_aZ) {
               this.field_70170_p.func_147449_b(var3.field_72311_b, var3.field_72312_c, var3.field_72309_d, Blocks.field_150350_a);
            }

            RivalRebelsSoundPlayer.playSound(this, 5, 2);
            if (var3.field_72310_e == 4 || var3.field_72310_e == 5) {
               this.field_70159_w *= -1.0;
            }

            if (var3.field_72310_e == 0 || var3.field_72310_e == 1) {
               this.field_70181_x *= -1.0;
            }

            if (var3.field_72310_e == 2 || var3.field_72310_e == 3) {
               this.field_70179_y *= -1.0;
            }
         } else {
            RivalRebels.landmine.func_149670_a(this.field_70170_p, var3.field_72311_b, var3.field_72312_c, var3.field_72309_d, this);
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
      if (this.shooter != null) {
         this.field_70159_w = this.field_70159_w + (this.shooter.field_70165_t - this.field_70165_t) * 0.01F;
         this.field_70181_x = this.field_70181_x + (this.shooter.field_70163_u + 1.62 - this.field_70163_u) * 0.01F;
         this.field_70179_y = this.field_70179_y + (this.shooter.field_70161_v - this.field_70161_v) * 0.01F;
      }

      this.field_70159_w *= 0.995F;
      this.field_70181_x *= 0.995F;
      this.field_70179_y *= 0.995F;
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
   }

   public boolean func_130002_c(EntityPlayer player) {
      if (this.field_70173_aa >= 10 && player == this.shooter) {
         if (player.field_71071_by.func_70441_a(new ItemStack(RivalRebels.roddisk))) {
            this.func_70106_y();
            RivalRebelsSoundPlayer.playSound(this, 6, 1);
         }

         return true;
      } else {
         return false;
      }
   }

   public int func_70070_b(float par1) {
      return 1000000;
   }

   public float func_70013_c(float par1) {
      return 1000000.0F;
   }

   public boolean func_70112_a(double par1) {
      return true;
   }

   @Override
   public void func_70037_a(NBTTagCompound var1) {
   }

   @Override
   public void func_70014_b(NBTTagCompound var1) {
   }

   public AxisAlignedBB func_70114_g(Entity par1Entity) {
      return par1Entity.field_70121_D;
   }

   public AxisAlignedBB func_70046_E() {
      return this.field_70121_D;
   }

   public boolean func_70067_L() {
      return !this.field_70128_L;
   }

   public boolean func_70104_M() {
      return true;
   }
}
