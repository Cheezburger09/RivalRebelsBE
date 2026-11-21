package assets.rivalrebels.common.tileentity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import assets.rivalrebels.common.round.RivalRebelsPlayer;
import assets.rivalrebels.common.round.RivalRebelsTeam;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class TileEntityForceFieldNode extends TileEntityMachineBase {
   public String username = null;
   public RivalRebelsTeam rrteam = null;
   public int level = 0;

   public TileEntityForceFieldNode() {
      this.pInM = 345.0F;
      this.pInR = 345.0F;
   }

   @Override
   public void func_145845_h() {
      if (this.pInR > 0.0F) {
         this.pInR = this.powered(this.pInR, this.edist);
      } else {
         this.turnOff();
      }

      this.pInR = this.pInR - this.decay;
   }

   public void turnOff() {
      if (this.level > 0) {
         int meta = this.field_145850_b.func_72805_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
         this.level--;

         for (int y = 0; y < 7; y++) {
            switch (meta) {
               case 2:
                  if (this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d + (y - 3), this.field_145849_e - this.level - 1)
                     == RivalRebels.forcefield) {
                     this.field_145850_b
                        .func_147465_d(this.field_145851_c, this.field_145848_d + (y - 3), this.field_145849_e - this.level - 1, Blocks.field_150350_a, 0, 3);
                  }
                  break;
               case 3:
                  if (this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d + (y - 3), this.field_145849_e + this.level + 1)
                     == RivalRebels.forcefield) {
                     this.field_145850_b
                        .func_147465_d(this.field_145851_c, this.field_145848_d + (y - 3), this.field_145849_e + this.level + 1, Blocks.field_150350_a, 0, 3);
                  }
                  break;
               case 4:
                  if (this.field_145850_b.func_147439_a(this.field_145851_c - this.level - 1, this.field_145848_d + (y - 3), this.field_145849_e)
                     == RivalRebels.forcefield) {
                     this.field_145850_b
                        .func_147465_d(this.field_145851_c - this.level - 1, this.field_145848_d + (y - 3), this.field_145849_e, Blocks.field_150350_a, 0, 3);
                  }
                  break;
               case 5:
                  if (this.field_145850_b.func_147439_a(this.field_145851_c + this.level + 1, this.field_145848_d + (y - 3), this.field_145849_e)
                     == RivalRebels.forcefield) {
                     this.field_145850_b
                        .func_147465_d(this.field_145851_c + this.level + 1, this.field_145848_d + (y - 3), this.field_145849_e, Blocks.field_150350_a, 0, 3);
                  }
            }
         }
      }
   }

   public AxisAlignedBB getRenderBoundingBox() {
      int meta = this.field_145850_b.func_72805_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
      float t = 0.0625F;
      float l = 35.0F;
      float h = 3.5F;
      switch (meta) {
         case 2:
            return AxisAlignedBB.func_72330_a(
               this.field_145851_c + 0.5F - t,
               this.field_145848_d + 0.5F - h,
               this.field_145849_e - l,
               this.field_145851_c + 0.5F + t,
               this.field_145848_d + 0.5F + h,
               this.field_145849_e
            );
         case 3:
            return AxisAlignedBB.func_72330_a(
               this.field_145851_c + 0.5F - t,
               this.field_145848_d + 0.5F - h,
               this.field_145849_e + 1.0F,
               this.field_145851_c + 0.5F + t,
               this.field_145848_d + 0.5F + h,
               this.field_145849_e + 1.0F + l
            );
         case 4:
            return AxisAlignedBB.func_72330_a(
               this.field_145851_c - l,
               this.field_145848_d + 0.5F - h,
               this.field_145849_e + 0.5F - t,
               this.field_145851_c,
               this.field_145848_d + 0.5F + h,
               this.field_145849_e + 0.5F + t
            );
         case 5:
            return AxisAlignedBB.func_72330_a(
               this.field_145851_c + 1.0F,
               this.field_145848_d + 0.5F - h,
               this.field_145849_e + 0.5F - t,
               this.field_145851_c + 1.0F + l,
               this.field_145848_d + 0.5F + h,
               this.field_145849_e + 0.5F + t
            );
         default:
            return AxisAlignedBB.func_72330_a(
               this.field_145851_c, this.field_145848_d, this.field_145849_e, this.field_145851_c, this.field_145848_d, this.field_145849_e
            );
      }
   }

   @SideOnly(Side.CLIENT)
   public double func_145833_n() {
      return 16384.0;
   }

   @Override
   public void func_145839_a(NBTTagCompound par1NBTTagCompound) {
      super.func_145839_a(par1NBTTagCompound);
      this.rrteam = RivalRebelsTeam.getForID(par1NBTTagCompound.func_74762_e("rrteam"));
      if (this.rrteam == RivalRebelsTeam.NONE) {
         this.rrteam = null;
      }

      if (this.rrteam == null) {
         this.username = par1NBTTagCompound.func_74779_i("username");
      }
   }

   @Override
   public void func_145841_b(NBTTagCompound par1NBTTagCompound) {
      super.func_145841_b(par1NBTTagCompound);
      if (this.rrteam != null) {
         par1NBTTagCompound.func_74768_a("rrteam", this.rrteam.ordinal());
      }

      if (this.username != null) {
         par1NBTTagCompound.func_74778_a("username", this.username);
      }
   }

   @Override
   public float powered(float power, float distance) {
      float hits = (float)Math.random();
      int meta = this.field_145850_b.func_72805_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
      double randomness = 0.1;
      float thickness = 0.5F;
      float length = 35.0F;
      float height = 3.52F;
      double speed = 2.0;
      if (meta == 2) {
         AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(
            this.field_145851_c + 0.5F - thickness,
            this.field_145848_d + 0.5F - height,
            this.field_145849_e - length,
            this.field_145851_c + 0.5F + thickness,
            this.field_145848_d + 0.5F + height,
            this.field_145849_e
         );

         for (Entity e : this.field_145850_b.func_72839_b(null, aabb)) {
            boolean shouldContinue = true;
            if (e instanceof EntityPlayer && e != null) {
               EntityPlayer p = (EntityPlayer)e;
               RivalRebelsPlayer player = RivalRebels.round.rrplayerlist.getForName(p.func_70005_c_());
               if (p.func_70005_c_().equals(this.username) || player != null && player.rrteam == this.rrteam) {
                  shouldContinue = false;
                  hits++;
                  p.func_70634_a(p.field_70165_t + (p.field_70165_t > this.field_145851_c + 0.5 ? -2 : 2), p.field_70163_u, p.field_70161_v);
               }
            }

            if (shouldContinue && e != null) {
               double cpx = this.field_145851_c + 0.5F - e.field_70165_t;
               double cpy = e.field_70163_u + e.func_70047_e() - e.field_70163_u;
               double cpz = e.field_70161_v - e.field_70161_v;
               double dist = Math.sqrt(cpx * cpx + cpy * cpy + cpz * cpz) / speed;
               cpx /= dist;
               cpy /= dist;
               cpz /= dist;
               cpx += this.field_145850_b.field_73012_v.nextGaussian() * randomness;
               cpy += this.field_145850_b.field_73012_v.nextGaussian() * randomness;
               cpz += this.field_145850_b.field_73012_v.nextGaussian() * randomness;
               e.field_70159_w = -cpx - e.field_70159_w;
               e.field_70181_x = -cpy - e.field_70181_x;
               e.field_70179_y = -cpz - e.field_70179_y;
               RivalRebelsSoundPlayer.playSound(e, 10, 7, 1.0F, 2.0F);
               if (e.field_70121_D != null) {
                  hits = (float)(hits + e.field_70121_D.func_72320_b());
               }
            }
         }

         if (this.level < length) {
            this.placeBlockCarefully(
               this.field_145850_b, this.field_145851_c, this.field_145848_d, (int)(this.field_145849_e - length - 1.0F), RivalRebels.reactive
            );

            for (int y = 0; y < 7; y++) {
               if (this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d + (y - 3), this.field_145849_e - this.level - 1)
                  != RivalRebels.forcefield) {
                  this.field_145850_b
                     .func_147465_d(this.field_145851_c, this.field_145848_d + (y - 3), this.field_145849_e - this.level - 1, RivalRebels.forcefield, meta, 3);
                  hits++;
               }
            }

            this.level++;
         }
      }

      if (meta == 3) {
         AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(
            this.field_145851_c + 0.5F - thickness,
            this.field_145848_d + 0.5F - height,
            this.field_145849_e + 1.0F,
            this.field_145851_c + 0.5F + thickness,
            this.field_145848_d + 0.5F + height,
            this.field_145849_e + 1.0F + length
         );

         for (Entity e : this.field_145850_b.func_72839_b(null, aabb)) {
            boolean shouldContinue = true;
            if (e instanceof EntityPlayer && e != null) {
               EntityPlayer p = (EntityPlayer)e;
               RivalRebelsPlayer player = RivalRebels.round.rrplayerlist.getForName(p.func_70005_c_());
               if (p.func_70005_c_().equals(this.username) || player != null && player.rrteam == this.rrteam) {
                  shouldContinue = false;
                  hits++;
                  p.func_70634_a(p.field_70165_t + (p.field_70165_t > this.field_145851_c + 0.5 ? -2 : 2), p.field_70163_u, p.field_70161_v);
               }
            }

            if (shouldContinue && e != null) {
               double cpx = this.field_145851_c + 0.5F - e.field_70165_t;
               double cpy = e.field_70163_u + e.func_70047_e() - e.field_70163_u;
               double cpz = e.field_70161_v - e.field_70161_v;
               double dist = Math.sqrt(cpx * cpx + cpy * cpy + cpz * cpz) / speed;
               cpx /= dist;
               cpy /= dist;
               cpz /= dist;
               cpx += this.field_145850_b.field_73012_v.nextGaussian() * randomness;
               cpy += this.field_145850_b.field_73012_v.nextGaussian() * randomness;
               cpz += this.field_145850_b.field_73012_v.nextGaussian() * randomness;
               e.field_70159_w = -cpx - e.field_70159_w;
               e.field_70181_x = -cpy - e.field_70181_x;
               e.field_70179_y = -cpz - e.field_70179_y;
               RivalRebelsSoundPlayer.playSound(e, 10, 7, 1.0F, 2.0F);
               if (e.field_70121_D != null) {
                  hits = (float)(hits + e.field_70121_D.func_72320_b());
               }
            }
         }

         if (this.level < length) {
            this.placeBlockCarefully(
               this.field_145850_b, this.field_145851_c, this.field_145848_d, (int)(this.field_145849_e + length + 1.0F), RivalRebels.reactive
            );

            for (int y = 0; y < 7; y++) {
               if (this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d + (y - 3), this.field_145849_e + this.level + 1)
                  != RivalRebels.forcefield) {
                  this.field_145850_b
                     .func_147465_d(this.field_145851_c, this.field_145848_d + (y - 3), this.field_145849_e + this.level + 1, RivalRebels.forcefield, meta, 3);
                  hits++;
               }
            }

            this.level++;
         }
      }

      if (meta == 4) {
         AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(
            this.field_145851_c - length,
            this.field_145848_d + 0.5F - height,
            this.field_145849_e + 0.5F - thickness,
            this.field_145851_c,
            this.field_145848_d + 0.5F + height,
            this.field_145849_e + 0.5F + thickness
         );

         for (Entity e : this.field_145850_b.func_72839_b(null, aabb)) {
            boolean shouldContinue = true;
            if (e instanceof EntityPlayer && e != null) {
               EntityPlayer p = (EntityPlayer)e;
               RivalRebelsPlayer player = RivalRebels.round.rrplayerlist.getForName(p.func_70005_c_());
               if (p.func_70005_c_().equals(this.username) || player != null && player.rrteam == this.rrteam) {
                  shouldContinue = false;
                  hits++;
                  p.func_70634_a(p.field_70165_t, p.field_70163_u, p.field_70161_v + (p.field_70161_v > this.field_145849_e + 0.5 ? -2 : 2));
               }
            }

            if (shouldContinue && e != null) {
               double cpx = e.field_70165_t - e.field_70165_t;
               double cpy = e.field_70163_u + e.func_70047_e() - e.field_70163_u;
               double cpz = this.field_145849_e + 0.5F - e.field_70161_v;
               double dist = Math.sqrt(cpx * cpx + cpy * cpy + cpz * cpz) / speed;
               cpx /= dist;
               cpy /= dist;
               cpz /= dist;
               cpx += this.field_145850_b.field_73012_v.nextGaussian() * randomness;
               cpy += this.field_145850_b.field_73012_v.nextGaussian() * randomness;
               cpz += this.field_145850_b.field_73012_v.nextGaussian() * randomness;
               e.field_70159_w = -cpx - e.field_70159_w;
               e.field_70181_x = -cpy - e.field_70181_x;
               e.field_70179_y = -cpz - e.field_70179_y;
               RivalRebelsSoundPlayer.playSound(e, 10, 7, 1.0F, 2.0F);
               if (e.field_70121_D != null) {
                  hits = (float)(hits + e.field_70121_D.func_72320_b());
               }
            }
         }

         if (this.level < length) {
            this.placeBlockCarefully(
               this.field_145850_b, (int)(this.field_145851_c - length - 1.0F), this.field_145848_d, this.field_145849_e, RivalRebels.reactive
            );

            for (int y = 0; y < 7; y++) {
               if (this.field_145850_b.func_147439_a(this.field_145851_c - this.level - 1, this.field_145848_d + (y - 3), this.field_145849_e)
                  != RivalRebels.forcefield) {
                  this.field_145850_b
                     .func_147465_d(this.field_145851_c - this.level - 1, this.field_145848_d + (y - 3), this.field_145849_e, RivalRebels.forcefield, meta, 3);
                  hits++;
               }
            }

            this.level++;
         }
      }

      if (meta == 5) {
         AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(
            this.field_145851_c + 1.0F,
            this.field_145848_d + 0.5F - height,
            this.field_145849_e + 0.5F - thickness,
            this.field_145851_c + 1.0F + length,
            this.field_145848_d + 0.5F + height,
            this.field_145849_e + 0.5F + thickness
         );

         for (Entity e : this.field_145850_b.func_72839_b(null, aabb)) {
            boolean shouldContinue = true;
            if (e instanceof EntityPlayer && e != null) {
               EntityPlayer p = (EntityPlayer)e;
               RivalRebelsPlayer player = RivalRebels.round.rrplayerlist.getForName(p.func_70005_c_());
               if (p.func_70005_c_().equals(this.username) || player != null && player.rrteam == this.rrteam) {
                  shouldContinue = false;
                  hits++;
                  p.func_70634_a(p.field_70165_t, p.field_70163_u, p.field_70161_v + (p.field_70161_v > this.field_145849_e + 0.5 ? -2 : 2));
               }
            }

            if (shouldContinue && e != null) {
               double cpx = e.field_70165_t - e.field_70165_t;
               double cpy = e.field_70163_u + e.func_70047_e() - e.field_70163_u;
               double cpz = this.field_145849_e + 0.5F - e.field_70161_v;
               double dist = Math.sqrt(cpx * cpx + cpy * cpy + cpz * cpz) / speed;
               cpx /= dist;
               cpy /= dist;
               cpz /= dist;
               cpx += this.field_145850_b.field_73012_v.nextGaussian() * randomness;
               cpy += this.field_145850_b.field_73012_v.nextGaussian() * randomness;
               cpz += this.field_145850_b.field_73012_v.nextGaussian() * randomness;
               e.field_70159_w = -cpx - e.field_70159_w;
               e.field_70181_x = -cpy - e.field_70181_x;
               e.field_70179_y = -cpz - e.field_70179_y;
               RivalRebelsSoundPlayer.playSound(e, 10, 7, 1.0F, 2.0F);
               if (e.field_70121_D != null) {
                  hits = (float)(hits + e.field_70121_D.func_72320_b());
               }
            }
         }

         if (this.level < length) {
            this.placeBlockCarefully(
               this.field_145850_b, (int)(this.field_145851_c + length + 1.0F), this.field_145848_d, this.field_145849_e, RivalRebels.reactive
            );

            for (int y = 0; y < 7; y++) {
               if (this.field_145850_b.func_147439_a(this.field_145851_c + this.level + 1, this.field_145848_d + (y - 3), this.field_145849_e)
                  != RivalRebels.forcefield) {
                  this.field_145850_b
                     .func_147465_d(this.field_145851_c + this.level + 1, this.field_145848_d + (y - 3), this.field_145849_e, RivalRebels.forcefield, meta, 3);
                  hits++;
               }
            }

            this.level++;
         }
      }

      return power - hits * 16.0F;
   }

   public void placeBlockCarefully(World world, int i, int j, int z, Block blockID) {
      if (world.func_147439_a(i, j, z) != RivalRebels.reactive
         && world.func_147439_a(i, j, z) != RivalRebels.fshield
         && world.func_147439_a(i, j, z) != RivalRebels.omegaobj
         && world.func_147439_a(i, j, z) != RivalRebels.sigmaobj) {
         world.func_147449_b(i, j, z, blockID);
      }
   }
}
