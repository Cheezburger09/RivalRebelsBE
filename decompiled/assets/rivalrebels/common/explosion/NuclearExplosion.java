package assets.rivalrebels.common.explosion;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsDamageSource;
import assets.rivalrebels.common.entity.EntityB83;
import assets.rivalrebels.common.entity.EntityHackB83;
import assets.rivalrebels.common.entity.EntityNuclearBlast;
import assets.rivalrebels.common.entity.EntityRhodes;
import assets.rivalrebels.common.entity.EntityTsarBlast;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class NuclearExplosion {
   public static Block[] prblocks = new Block[]{
      Blocks.field_150365_q,
      Blocks.field_150366_p,
      Blocks.field_150450_ax,
      Blocks.field_150352_o,
      Blocks.field_150369_x,
      Blocks.field_150482_ag,
      Blocks.field_150412_bA
   };
   public static Block[] pgblocks = new Block[]{Blocks.field_150348_b, Blocks.field_150347_e, Blocks.field_150346_d};

   public NuclearExplosion(World world, int x, int y, int z, int strength) {
      Side side = FMLCommonHandler.instance().getEffectiveSide();
      if (side == Side.SERVER) {
         this.createHole(world, x, y, z, strength, true);
         this.fixLag(world, x, y, z, strength);
      }
   }

   public NuclearExplosion(World world, int x, int y, int z, int strength, boolean breakobj) {
      Side side = FMLCommonHandler.instance().getEffectiveSide();
      if (side == Side.SERVER) {
         this.createHole(world, x, y, z, strength, breakobj);
         this.fixLag(world, x, y, z, strength);
      }
   }

   private void createHole(World world, int x, int y, int z, int radius, boolean breakobj) {
      Random rand = new Random();
      int halfradius = radius / 2;
      int onepointfiveradius = halfradius * 3;
      int AOC = radius / RivalRebels.nuclearBombStrength;
      int onepointfiveradiussqrd = onepointfiveradius * onepointfiveradius;
      int twoAOC = AOC * 2;

      for (int X = -onepointfiveradius; X <= onepointfiveradius; X++) {
         int xx = x + X;
         int XX = X * X;

         for (int Z = -onepointfiveradius; Z <= onepointfiveradius; Z++) {
            int ZZ = Z * Z + XX;
            int zz = z + Z;

            for (int Y = -onepointfiveradius; Y <= onepointfiveradius; Y++) {
               int YY = Y * Y + ZZ;
               int yy = y + Y;
               if (YY < onepointfiveradiussqrd) {
                  Block block = world.func_147439_a(xx, yy, zz);
                  if (block != Blocks.field_150350_a) {
                     int dist = (int)Math.sqrt(YY);
                     if (dist < radius && block != Blocks.field_150357_h) {
                        int varrand = 1 + dist - halfradius;
                        if (dist < halfradius) {
                           if (breakobj && block == RivalRebels.omegaobj) {
                              RivalRebels.round.winSigma();
                              block = RivalRebels.plasmaexplosion;
                           } else if (breakobj && block == RivalRebels.sigmaobj) {
                              RivalRebels.round.winOmega();
                              block = RivalRebels.plasmaexplosion;
                           } else if (block == RivalRebels.reactive) {
                              for (int i = 0; i < (1 - dist / onepointfiveradius) * 4 + Math.random() * 2.0; i++) {
                                 world.func_147449_b(xx, yy, zz, Blocks.field_150350_a);
                              }
                           } else {
                              world.func_147449_b(xx, yy, zz, Blocks.field_150350_a);
                              block = Blocks.field_150350_a;
                           }
                        } else if (varrand > 0) {
                           int randomness = halfradius - varrand / 2;
                           if (breakobj && block == RivalRebels.omegaobj) {
                              RivalRebels.round.winSigma();
                              block = RivalRebels.plasmaexplosion;
                           } else if (breakobj && block == RivalRebels.sigmaobj) {
                              RivalRebels.round.winOmega();
                              block = RivalRebels.plasmaexplosion;
                           } else if (block == RivalRebels.reactive) {
                              for (int i = 0; i < (1 - dist / onepointfiveradius) * 4 + Math.random() * 2.0; i++) {
                                 world.func_147449_b(xx, yy, zz, Blocks.field_150350_a);
                              }
                           } else if (block != Blocks.field_150355_j
                              && block != Blocks.field_150353_l
                              && block != Blocks.field_150358_i
                              && block != Blocks.field_150356_k) {
                              if (block == Blocks.field_150348_b && rand.nextInt(randomness) < randomness / 2) {
                                 world.func_147449_b(xx, yy, zz, Blocks.field_150347_e);
                                 block = Blocks.field_150347_e;
                              } else if (block == Blocks.field_150349_c || block == Blocks.field_150346_d) {
                                 world.func_147449_b(xx, yy, zz, RivalRebels.radioactivedirt);
                              } else if (block != Blocks.field_150354_m && block != Blocks.field_150322_A) {
                                 if (rand.nextInt(varrand) == 0 || rand.nextInt(varrand / 2 + 1) == 0) {
                                    world.func_147449_b(xx, yy, zz, Blocks.field_150350_a);
                                    block = Blocks.field_150350_a;
                                 }
                              } else {
                                 world.func_147449_b(xx, yy, zz, RivalRebels.radioactivesand);
                              }
                           } else {
                              world.func_147449_b(xx, yy, zz, Blocks.field_150350_a);
                              block = Blocks.field_150350_a;
                           }
                        }
                     }

                     if (dist < onepointfiveradius && block != Blocks.field_150350_a && block != Blocks.field_150357_h) {
                        if (Y < twoAOC && (dist >= onepointfiveradius || Y < AOC)) {
                           if (world.func_147439_a(xx, yy - 1, zz) == Blocks.field_150364_r) {
                              world.func_147449_b(xx, yy, zz, Blocks.field_150480_ab);
                           } else if (block == Blocks.field_150349_c || block == Blocks.field_150346_d) {
                              world.func_147449_b(xx, yy, zz, RivalRebels.radioactivedirt);
                           } else if (block == Blocks.field_150354_m || block == Blocks.field_150322_A) {
                              world.func_147449_b(xx, yy, zz, RivalRebels.radioactivesand);
                           }
                        } else {
                           world.func_147449_b(xx, yy, zz, Blocks.field_150350_a);
                        }
                     }
                  }
               }
            }
         }
      }

      world.func_72908_a(x, y, z, "random.explode", 4.0F, (1.0F + (rand.nextFloat() - rand.nextFloat()) * 0.2F) * 0.7F);
   }

   private void pushAndHurtEntities(World world, int x, int y, int z, int radius) {
      radius *= 4;
      int var3x = MathHelper.func_76128_c((double)x - radius - 1.0);
      int var4x = MathHelper.func_76128_c((double)x + radius + 1.0);
      int var5x = MathHelper.func_76128_c((double)y - radius - 1.0);
      int var28 = MathHelper.func_76128_c((double)y + radius + 1.0);
      int var7 = MathHelper.func_76128_c((double)z - radius - 1.0);
      int var29 = MathHelper.func_76128_c((double)z + radius + 1.0);
      List var9 = world.func_72839_b(null, AxisAlignedBB.func_72330_a(var3x, var5x, var7, var4x, var28, var29));
      Vec3 var30 = Vec3.func_72443_a(x, y, z);

      for (int var11 = 0; var11 < var9.size(); var11++) {
         Entity var31 = (Entity)var9.get(var11);
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
               double var34 = (1.0 - var13) * var32 * (!(var31 instanceof EntityB83) && !(var31 instanceof EntityHackB83) ? 1 : -1);
               if (!(var31 instanceof EntityNuclearBlast) && !(var31 instanceof EntityTsarBlast) && !(var31 instanceof EntityRhodes)) {
                  if (var31 instanceof EntityFallingBlock) {
                     var31.func_70106_y();
                  }

                  var31.func_70097_a(RivalRebelsDamageSource.nuclearblast, (int)((var34 * var34 + var34) / 2.0 * 8.0 * radius + 1.0) * 4);
                  var31.field_70159_w -= var15 * var34 * 8.0;
                  var31.field_70181_x -= var17 * var34 * 8.0;
                  var31.field_70179_y -= var19 * var34 * 8.0;
               }

               if (var31 instanceof EntityRhodes) {
                  var31.func_70097_a(RivalRebelsDamageSource.nuclearblast, (int)(radius * var34 * 0.2F));
               }
            }
         }
      }
   }

   private void fixLag(World world, int x, int y, int z, int strength) {
      for (int X = -strength; X <= strength; X++) {
         int xx = x + X;

         for (int Y = -strength; Y <= strength; Y++) {
            int yy = y + Y;

            for (int Z = -strength; Z <= strength; Z++) {
               int zz = z + Z;
               Block blockID = world.func_147439_a(xx, yy, zz);
               if (blockID == Blocks.field_150350_a
                  && world.func_72957_l(xx, yy, zz) == 0
                  && world.func_147439_a(xx, yy + 1, zz) != Blocks.field_150350_a
                  && world.func_147439_a(xx, yy - 1, zz) != Blocks.field_150350_a
                  && world.func_147439_a(xx + 1, yy, zz) != Blocks.field_150350_a
                  && world.func_147439_a(xx - 1, yy, zz) != Blocks.field_150350_a
                  && world.func_147439_a(xx, yy, zz + 1) != Blocks.field_150350_a
                  && world.func_147439_a(xx, yy, zz - 1) != Blocks.field_150350_a) {
                  int r = world.field_73012_v.nextInt(50);
                  Block id = null;
                  if (r == 0) {
                     id = prblocks[world.field_73012_v.nextInt(prblocks.length)];
                  } else {
                     id = pgblocks[world.field_73012_v.nextInt(pgblocks.length)];
                  }

                  world.func_147449_b(xx, yy, zz, id);
               }
            }
         }
      }
   }
}
