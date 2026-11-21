package assets.rivalrebels.common.explosion;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.BlackList;
import assets.rivalrebels.common.core.RivalRebelsDamageSource;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import assets.rivalrebels.common.entity.EntityDebris;
import assets.rivalrebels.common.entity.EntityFlameBall;
import assets.rivalrebels.common.entity.EntityRhodes;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class Explosion {
   public Explosion(World world, double x, double y, double z, int strength, boolean fire, boolean crater, DamageSource dmgsrc) {
      world.func_72869_a("hugeexplosion", x, y, z, 0.0, 0.0, 0.0);
      if (!world.field_72995_K) {
         if (fire) {
            this.fireSpread(world, x, y, z, strength);
         } else {
            this.createHole(world, x, y, z, strength * strength, crater, 4);
         }

         this.pushAndHurtEntities(world, x, y, z, strength, dmgsrc);
      }
   }

   private void fireSpread(World world, double x, double y, double z, int radius) {
      Random rand = new Random();
      int halfradius = radius / 2;
      int tworadius = radius * 2;

      for (int X = -tworadius; X <= tworadius; X++) {
         for (int Y = -tworadius; Y <= tworadius; Y++) {
            for (int Z = -tworadius; Z <= tworadius; Z++) {
               int xx = (int)x + X;
               int yy = (int)y + Y;
               int zz = (int)z + Z;
               Block block = world.func_147439_a(xx, yy, zz);
               if (block == Blocks.field_150350_a) {
                  int dist = (int)Math.sqrt(X * X + Y * Y + Z * Z);
                  if (dist < radius) {
                     int varrand = 1 + dist - halfradius;
                     if (dist < halfradius) {
                        world.func_147449_b(xx, yy, zz, Blocks.field_150480_ab);
                     } else if (varrand > 0 && (rand.nextInt(varrand) == 0 || rand.nextInt(varrand / 2 + 1) == 0)) {
                        world.func_147449_b(xx, yy, zz, Blocks.field_150480_ab);
                     }
                  }
               }
            }
         }
      }
   }

   private void createHole(World world, double x, double y, double z, int radius, boolean crater, int delete) {
      Random rand = new Random();
      int halfradius = radius >> 2;
      int tworadius = radius << 2;

      for (int X = -tworadius; X <= tworadius; X++) {
         int xx = (int)x + X;

         for (int Y = -tworadius; Y <= tworadius; Y++) {
            int yy = (int)y + Y;

            for (int Z = -tworadius; Z <= tworadius; Z++) {
               int zz = (int)z + Z;
               Block block = world.func_147439_a(xx, yy, zz);
               if (block != null && block != Blocks.field_150350_a && block != Blocks.field_150357_h) {
                  int dist = X * X + Y * Y + Z * Z;
                  if (dist <= delete && block == RivalRebels.camo1 && block == RivalRebels.camo2 && block == RivalRebels.camo3) {
                     world.func_147449_b(xx, yy, zz, Blocks.field_150350_a);
                  } else if (dist < radius) {
                     int varrand = 1 + dist - halfradius;
                     if (dist < halfradius) {
                        this.breakBlock(world, xx, yy, zz, radius, x, y, z);
                     } else if (varrand > 0 && (rand.nextInt(varrand) == 0 || rand.nextInt(varrand / 2 + 1) == 0)) {
                        this.breakBlock(world, xx, yy, zz, radius, x, y, z);
                     }
                  } else if (dist < tworadius && (Y >= 2 || dist < radius * 1.5 && Y >= 1) && crater) {
                     this.breakBlock(world, xx, yy, zz, radius, x, y, z);
                  }
               }
            }
         }
      }
   }

   private void breakBlock(World world, int xx, int yy, int zz, int strength, double x, double y, double z) {
      Block block = world.func_147439_a(xx, yy, zz);
      if (block == RivalRebels.remotecharge) {
         world.func_147449_b(xx, yy, zz, Blocks.field_150350_a);
         RivalRebelsSoundPlayer.playSound(world, 22, 0, xx, yy, zz, 0.5F, 0.3F);
         new Explosion(world, x + 0.5, y + 0.5, z + 0.5, RivalRebels.chargeExplodeSize, false, false, RivalRebelsDamageSource.charge);
      } else if (block != RivalRebels.toxicgas
         && block != Blocks.field_150486_ae
         && block != Blocks.field_150395_bd
         && block != Blocks.field_150329_H
         && block != RivalRebels.flare
         && block != RivalRebels.light
         && block != RivalRebels.light2
         && block != RivalRebels.reactive
         && block != RivalRebels.timedbomb) {
         if (block == Blocks.field_150476_ad || block == Blocks.field_150400_ck || block == Blocks.field_150401_cl || block == Blocks.field_150487_bG) {
            world.func_147449_b(xx, yy, zz, Blocks.field_150344_f);
         }

         if (block != RivalRebels.camo1 && block != RivalRebels.camo2 && block != RivalRebels.camo3 && block != RivalRebels.conduit
            || world.field_73012_v.nextInt(20) == 0) {
            if (!BlackList.explosion(block)) {
               EntityDebris e = new EntityDebris(world, xx, yy, zz);
               double xmo = x - xx;
               double ymo = y - yy;
               double zmo = z - zz;
               e.func_70024_g(xmo * 0.2F, ymo * 0.2F, zmo * 0.2F);
               world.func_72838_d(e);
            }
         }
      } else {
         world.func_147449_b(xx, yy, zz, Blocks.field_150350_a);
      }
   }

   private void pushAndHurtEntities(World world, double x, double y, double z, int radius, DamageSource dmgsrc) {
      int var3 = MathHelper.func_76128_c(x - radius - 1.0);
      int var4x = MathHelper.func_76128_c(x + radius + 1.0);
      int var5 = MathHelper.func_76128_c(y - radius - 1.0);
      int var28 = MathHelper.func_76128_c(y + radius + 1.0);
      int var7 = MathHelper.func_76128_c(z - radius - 1.0);
      int var29 = MathHelper.func_76128_c(z + radius + 1.0);
      List var9x = world.func_72839_b(null, AxisAlignedBB.func_72330_a(var3, var5, var7, var4x, var28, var29));
      Vec3 var30 = Vec3.func_72443_a(x, y, z);
      radius *= 4;

      for (int var11 = 0; var11 < var9x.size(); var11++) {
         Entity var31 = (Entity)var9x.get(var11);
         if (!(var31 instanceof EntityDebris) && !(var31 instanceof EntityFlameBall) && !(var31 instanceof EntityRhodes)) {
            double var13 = var31.func_70011_f(x, y, z) / radius;
            if (var13 <= 1.0) {
               double var15 = var31.field_70165_t - x;
               double var17 = var31.field_70163_u + var31.func_70047_e() - y;
               double var19 = var31.field_70161_v - z;
               double var33 = MathHelper.func_76133_a(var15 * var15 + var17 * var17 + var19 * var19);
               if (var33 != 0.0) {
                  var15 /= var33;
                  var17 /= var33;
                  var19 /= var33;
                  double var32 = world.func_72842_a(var30, var31.field_70121_D);
                  double var34 = (1.0 - var13) * var32;
                  var31.func_70097_a(dmgsrc, (int)((var34 * var34 + var34) / 2.0 * radius + 1.0));
                  var31.field_70159_w += var15 * var34;
                  var31.field_70181_x += var17 * var34;
                  var31.field_70179_y += var19 * var34;
               }
            }
         }
      }
   }
}
