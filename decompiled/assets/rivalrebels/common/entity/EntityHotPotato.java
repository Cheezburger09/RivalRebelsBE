package assets.rivalrebels.common.entity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.command.CommandHotPotato;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import assets.rivalrebels.common.explosion.TsarBomba;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityHotPotato extends EntityThrowable {
   public int field_70173_aa = 0;
   public int round = 0;
   public int nextx = 0;
   public int nexty = 0;
   public int nextz = 0;
   public boolean dorounds = false;
   public int charges = RivalRebels.tsarBombaStrength + 9;

   public EntityHotPotato(World par1World) {
      super(par1World);
      this.func_70105_a(0.5F, 0.5F);
   }

   public EntityHotPotato(World par1World, int x, int y, int z, int count) {
      super(par1World);
      this.func_70105_a(0.5F, 0.5F);
      this.func_70107_b(x + 0.5F, y + 0.5F, z + 0.5F);
      this.field_70129_M = 0.0F;
      this.round = count;
      this.nextx = x;
      this.nexty = y;
      this.nextz = z;
      this.dorounds = true;
   }

   public EntityHotPotato(World worldObj, double px, double py, double pz, double f, double g, double h) {
      super(worldObj);
      this.func_70105_a(0.5F, 0.5F);
      this.func_70107_b(px, py, pz);
      this.field_70159_w = f;
      this.field_70181_x = g;
      this.field_70179_y = h;
      this.field_70129_M = 0.0F;
      this.round = 1;
      this.nextx = (int)px;
      this.nexty = (int)py;
      this.nextz = (int)pz;
      this.field_70173_aa = 1;
      this.dorounds = true;
   }

   public void func_70071_h_() {
      this.field_70142_S = this.field_70165_t;
      this.field_70137_T = this.field_70163_u;
      this.field_70136_U = this.field_70161_v;
      if (this.field_70173_aa == -100) {
         this.explode();
      }

      this.field_70173_aa++;
      if (this.field_70173_aa < 2 && this.dorounds) {
         RivalRebelsSoundPlayer.playSound(this.field_70170_p, 14, 0, this.field_70165_t, this.field_70163_u, this.field_70161_v, 100.0F);
         this.field_70159_w = 0.0;
         this.field_70181_x = 0.0;
         this.field_70179_y = 0.0;
         this.func_70105_a(0.5F, 0.5F);
         this.func_70107_b(this.nextx + 0.5F, this.nexty + 0.5F, this.nextz + 0.5F);
         this.field_70129_M = 0.0F;
         this.field_70170_p.func_147449_b(this.nextx, this.nexty - 400, this.nextz, RivalRebels.jump);
         this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      } else {
         if (!this.field_70170_p.field_72995_K) {
            Vec3 var15 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            Vec3 var2 = Vec3.func_72443_a(
               this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y
            );
            MovingObjectPosition var3 = this.field_70170_p.func_72933_a(var15, var2);
            var15 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            var2 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
            if (var3 != null) {
               var2 = Vec3.func_72443_a(var3.field_72307_f.field_72450_a, var3.field_72307_f.field_72448_b, var3.field_72307_f.field_72449_c);
            }

            Entity var4 = null;
            List var5 = this.field_70170_p
               .func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(1.0, 1.0, 1.0));
            double var6 = 0.0;

            for (Entity var9 : var5) {
               if (var9.func_70067_L()) {
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

            if (var3 != null) {
               this.func_70184_a(var3);
            }

            if (this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v) == Blocks.field_150355_j) {
               this.field_70181_x += 0.06F;
            }
         }

         this.field_70165_t = this.field_70165_t + this.field_70159_w;
         this.field_70163_u = this.field_70163_u + this.field_70181_x;
         this.field_70161_v = this.field_70161_v + this.field_70179_y;
         if (this.field_70163_u < 0.0) {
            this.func_70106_y();
         }

         if (this.field_70154_o == null) {
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

            this.field_70125_A = this.field_70127_C + (this.field_70125_A - this.field_70127_C) * 0.05F;
            this.field_70177_z = this.field_70126_B + (this.field_70177_z - this.field_70126_B) * 0.05F;
         }

         float var17 = 0.98F;
         float var18 = this.func_70185_h();
         this.field_70159_w *= var17;
         this.field_70181_x *= var17;
         this.field_70179_y *= var17;
         this.field_70181_x -= var18;
         this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      }
   }

   public void func_70014_b(NBTTagCompound nbt) {
      nbt.func_74768_a("charge", this.charges);
   }

   public void func_70037_a(NBTTagCompound nbt) {
      this.charges = nbt.func_74762_e("charge");
      if (this.charges == 0) {
         this.charges = RivalRebels.tsarBombaStrength + 9;
      }

      this.field_70126_B = this.field_70177_z = nbt.func_74760_g("rot");
   }

   public boolean func_70112_a(double par1) {
      return true;
   }

   protected void func_70184_a(MovingObjectPosition var1) {
      if (var1.field_72308_g == null) {
         Block b = this.field_70170_p.func_147439_a(var1.field_72311_b, var1.field_72312_c, var1.field_72309_d);
         if (b == RivalRebels.jump || b == Blocks.field_150432_aD) {
            this.field_70181_x = Math.max(-this.field_70181_x, 0.2F);
            return;
         }

         if (this.field_70170_p.field_73012_v.nextInt(10) != 0) {
            this.field_70181_x = Math.max(-this.field_70181_x, 0.2F);
            return;
         }
      }

      this.explode();
   }

   protected float func_70185_h() {
      return 0.03F;
   }

   public void explode() {
      if (!this.field_70170_p.field_72995_K) {
         TsarBomba tsar = new TsarBomba((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, this.field_70170_p, this.charges);
         EntityTsarBlast tsarblast = new EntityTsarBlast(
            this.field_70170_p, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, tsar, this.charges
         );
         this.field_70170_p.func_72838_d(tsarblast);
         this.field_70173_aa = 0;
         this.round--;
         CommandHotPotato.roundinprogress = false;
         if (this.round <= 0) {
            this.func_70106_y();
         }
      }
   }
}
