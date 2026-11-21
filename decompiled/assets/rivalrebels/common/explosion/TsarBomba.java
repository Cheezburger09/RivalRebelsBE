package assets.rivalrebels.common.explosion;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.entity.EntityTsarBlast;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class TsarBomba {
   public int posX;
   public int posY;
   public int posZ;
   public int lastposX = 0;
   public int lastposZ = 0;
   public int radius;
   public World worldObj;
   private int n = 1;
   private int nlimit;
   private int shell;
   private int leg;
   private int element;
   private int repeatCount = 0;
   private boolean isTree;
   private int treeHeight;
   public int processedchunks = 0;

   public TsarBomba(int x, int y, int z, World world, int rad) {
      this.posX = x;
      this.posY = y;
      this.posZ = z;
      this.worldObj = world;
      this.radius = rad;
      this.nlimit = (this.radius + 25) * (this.radius + 25) * 4;
      rad *= rad;
      if (!world.field_72995_K) {
         System.out.println("radius:" + this.radius);
         System.out.println("Nlimit:" + this.nlimit);
         int clamprad = this.radius;

         for (int X = -clamprad; X < clamprad; X++) {
            int x2 = X * X;

            for (int Z = -clamprad; Z < clamprad; Z++) {
               if (x2 + Z * Z < rad) {
                  for (int Y = 70; Y > 0; Y--) {
                     Block block = this.worldObj.func_147439_a(X + this.posX, Y, Z + this.posZ);
                     if (block == Blocks.field_150355_j || block == Blocks.field_150353_l || block == Blocks.field_150358_i || block == Blocks.field_150356_k) {
                        this.worldObj.func_147468_f(X + this.posX, Y, Z + this.posZ);
                     }
                  }
               }
            }
         }
      }
   }

   public void update(EntityTsarBlast tsarblast) {
      if (this.n > 0 && this.n < this.nlimit) {
         boolean repeat = this.processChunk(this.lastposX, this.lastposZ);
         this.shell = (int)Math.floor((Math.sqrt(this.n) + 1.0) / 2.0);
         int shell2 = 2 * this.shell;
         this.leg = (int)Math.floor((this.n - (shell2 - 1) * (shell2 - 1)) / shell2);
         this.element = this.n - (shell2 - 1) * (shell2 - 1) - shell2 * this.leg - this.shell + 1;
         this.lastposX = this.leg == 0 ? this.shell : (this.leg == 1 ? -this.element : (this.leg == 2 ? -this.shell : this.element));
         this.lastposZ = this.leg == 0 ? this.element : (this.leg == 1 ? this.shell : (this.leg == 2 ? -this.element : -this.shell));
         this.n++;
         if (!repeat) {
            this.repeatCount++;
            if (this.repeatCount >= RivalRebels.tsarBombaSpeed * 2) {
               this.repeatCount = 0;
               return;
            }

            this.update(tsarblast);
         }
      } else {
         tsarblast.tsar = null;
         tsarblast.func_70106_y();
      }
   }

   private boolean processChunk(int x, int z) {
      this.processedchunks++;
      double dist = x * x + z * z;
      if (dist < this.radius * this.radius) {
         dist = Math.sqrt(dist);
         int y = this.getTopBlock(x + this.posX, z + this.posZ, dist);
         float yele = this.posY + (y - this.posY) * 0.5F;
         if (RivalRebels.elevation) {
            yele = y;
         }

         int ylimit = (int)Math.floor(yele - (this.radius - dist) / 2.0 + Math.sin(dist * 0.5) * 1.15);

         for (int Y = y; Y > ylimit && Y != 0; Y--) {
            Block block = this.worldObj.func_147439_a(x + this.posX, Y, z + this.posZ);
            if (block == RivalRebels.omegaobj) {
               RivalRebels.round.winSigma();
            } else if (block == RivalRebels.sigmaobj) {
               RivalRebels.round.winOmega();
            }

            this.worldObj.func_147449_b(x + this.posX, Y, z + this.posZ, Blocks.field_150350_a);
         }

         double limit = this.radius / 2 + this.worldObj.field_73012_v.nextInt(this.radius / 4) + 7.5;
         if (dist < limit) {
            int blockType = this.worldObj.field_73012_v.nextInt(4) + 1;
            if (x >= 0 && z < 0) {
               blockType = 1;
            }

            if (x > 0 && z >= 0) {
               blockType = 2;
            }

            if (x <= 0 && z > 0) {
               blockType = 3;
            }

            if (x < 0 && z <= 0) {
               blockType = 4;
            }

            int metadata = (int)Math.ceil(16.0 / limit * dist);
            metadata -= this.radius / 10 - 1;
            if (metadata < 0) {
               metadata = -metadata;
            }

            if (++metadata > 15) {
               metadata = 15;
            }

            for (int Y = ylimit; Y > ylimit - (this.worldObj.field_73012_v.nextInt(5) + 2) && Y != 0; Y--) {
               Block block = this.worldObj.func_147439_a(x + this.posX, Y, z + this.posZ);
               if (block == RivalRebels.omegaobj) {
                  RivalRebels.round.winSigma();
               } else if (block == RivalRebels.sigmaobj) {
                  RivalRebels.round.winOmega();
               }

               if (blockType == 1) {
                  this.worldObj.func_147449_b(x + this.posX, Y, z + this.posZ, RivalRebels.petrifiedstone1);
               } else if (blockType == 2) {
                  this.worldObj.func_147449_b(x + this.posX, Y, z + this.posZ, RivalRebels.petrifiedstone2);
               } else if (blockType == 3) {
                  this.worldObj.func_147449_b(x + this.posX, Y, z + this.posZ, RivalRebels.petrifiedstone3);
               } else {
                  this.worldObj.func_147449_b(x + this.posX, Y, z + this.posZ, RivalRebels.petrifiedstone4);
               }

               this.worldObj.func_72921_c(x + this.posX, Y, z + this.posZ, metadata, 3);
            }
         }

         if (this.isTree) {
            this.isTree = false;
            int metadata = (int)Math.floor(16.0 / this.radius * dist);
            if (metadata < 0) {
               metadata = 0;
            }

            if (++metadata > 15) {
               metadata = 15;
            }

            for (int Y = ylimit; Y > ylimit - this.treeHeight && Y != 0; Y--) {
               this.worldObj.func_147449_b(x + this.posX, Y, z + this.posZ, RivalRebels.petrifiedwood);
               this.worldObj.func_72921_c(x + this.posX, Y, z + this.posZ, metadata, 3);
            }
         }

         return true;
      } else {
         if (!(dist <= this.radius * this.radius * 1.3125 * 1.3125)) {
            return false;
         }

         dist = Math.sqrt(dist);
         int y = this.getTopBlock(x + this.posX, z + this.posZ, dist);
         int ylimit = (int)Math.ceil(Math.sin((dist - this.radius - this.radius / 16) * this.radius * 0.001875) * (this.radius / 16));
         if (dist >= this.radius + 5) {
            int metadata = (int)Math.floor(16.0 / this.radius * dist);
            if (metadata < 0) {
               metadata = 0;
            }

            if (++metadata > 15) {
               metadata = 15;
            }

            for (int Y = ylimit; Y >= 0 && Y != 0; Y--) {
               int yy = Y + y;
               Block blockID = this.worldObj.func_147439_a(x + this.posX, yy, z + this.posZ);
               if (blockID == RivalRebels.omegaobj) {
                  RivalRebels.round.winSigma();
               } else if (blockID == RivalRebels.sigmaobj) {
                  RivalRebels.round.winOmega();
               } else {
                  if (this.isTree) {
                     this.isTree = false;

                     for (int Yy = 0; Yy >= -this.treeHeight; Yy--) {
                        this.worldObj.func_147449_b(x + this.posX, yy + Yy, z + this.posZ, RivalRebels.petrifiedwood);
                        this.worldObj.func_72921_c(x + this.posX, yy + Yy, z + this.posZ, metadata, 3);
                     }
                     break;
                  }

                  Block blockID1 = this.worldObj.func_147439_a(x + this.posX, yy - ylimit, z + this.posZ);
                  int datavalue = this.worldObj.func_72805_g(x + this.posX, yy - ylimit, z + this.posZ);
                  this.worldObj.func_147465_d(x + this.posX, yy, z + this.posZ, blockID1, datavalue, 3);
               }
            }
         } else {
            Block blockID = this.worldObj.func_147439_a(x + this.posX, y, z + this.posZ);
            if (blockID != Blocks.field_150357_h && blockID != null && !blockID.func_149662_c()) {
               this.worldObj.func_147449_b(x + this.posX, y, z + this.posZ, Blocks.field_150350_a);
            }

            if (this.isTree) {
               this.isTree = false;
               int metadata = (int)Math.floor(16.0 / this.radius * dist);
               if (metadata < 0) {
                  metadata = 0;
               }

               if (++metadata > 15) {
                  metadata = 15;
               }

               for (int Y = ylimit; Y > ylimit - this.treeHeight; Y--) {
                  this.worldObj.func_147449_b(x + this.posX, Y, z + this.posZ, RivalRebels.petrifiedwood);
                  this.worldObj.func_72921_c(x + this.posX, Y, z + this.posZ, metadata, 3);
               }
            }
         }

         return true;
      }
   }

   private int getTopBlock(int x, int z, double dist) {
      int foundY = 0;
      boolean found = false;

      for (int y = 256; y > 0; y--) {
         Block blockID = this.worldObj.func_147439_a(x, y, z);
         if (blockID != Blocks.field_150350_a) {
            if (blockID == RivalRebels.omegaobj) {
               RivalRebels.round.winSigma();
            } else if (blockID == RivalRebels.sigmaobj) {
               RivalRebels.round.winOmega();
            }

            if (blockID == RivalRebels.reactive) {
               for (int i = 0; i < (1.0 - dist / this.radius) * 16.0 + Math.random() * 2.0; i++) {
                  this.worldObj.func_147449_b(x, y, z, Blocks.field_150350_a);
               }
            }

            if (blockID.func_149662_c() && blockID != Blocks.field_150364_r) {
               if (!found) {
                  return y;
               }

               this.treeHeight = foundY - y;
               return foundY;
            }

            this.worldObj.func_147468_f(x, y, z);
            if (dist > this.radius / 2 && blockID == Blocks.field_150364_r && this.worldObj.func_147439_a(x, y - 1, z) == Blocks.field_150364_r) {
               this.isTree = true;
            }

            if (!found && this.isTree) {
               foundY = y;
               found = true;
            }
         }
      }

      return foundY;
   }
}
