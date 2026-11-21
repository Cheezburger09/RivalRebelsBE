package assets.rivalrebels.common.entity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsDamageSource;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import assets.rivalrebels.common.explosion.AntimatterBomb;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityAntimatterBombBlast extends EntityInanimate {
   public AntimatterBomb tsar = null;
   public double radius;
   public int time = 0;
   List<Entity> entitylist = new ArrayList<>();

   public EntityAntimatterBombBlast(World par1World) {
      super(par1World);
      this.field_70158_ak = true;
   }

   public EntityAntimatterBombBlast(World par1World, float x, float y, float z, AntimatterBomb tsarBomba, int rad) {
      super(par1World);
      this.field_70158_ak = true;
      this.tsar = tsarBomba;
      this.radius = rad;
      this.field_70159_w = Math.sqrt(this.radius - RivalRebels.tsarBombaStrength) / 10.0;
      this.func_70107_b(x, y, z);
   }

   public EntityAntimatterBombBlast(World par1World, double x, double y, double z, float rad) {
      super(par1World);
      this.field_70158_ak = true;
      this.radius = rad;
      this.field_70159_w = Math.sqrt(rad - RivalRebels.tsarBombaStrength) / 10.0;
      this.func_70107_b(x, y, z);
   }

   public void func_70071_h_() {
      super.func_70071_h_();
      if (this.field_70170_p.field_73012_v.nextInt(30) == 0) {
         this.field_70170_p.func_72956_a(this, "ambient.weather.thunder", 10.0F, 0.5F);
      } else if (this.field_70170_p.field_73012_v.nextInt(30) == 0) {
         RivalRebelsSoundPlayer.playSound(this, 13, 0, 100.0F, 0.8F);
      }

      this.field_70173_aa++;
      if (!this.field_70170_p.field_72995_K) {
         if (this.tsar == null && this.field_70173_aa > 1200) {
            this.func_70106_y();
         }

         if (this.field_70173_aa % 20 == 0) {
            this.updateEntityList();
         }

         if (this.field_70173_aa < 1200 && this.field_70173_aa % 5 == 0) {
            this.pushAndHurtEntities();
         }

         for (int i = 0; i < RivalRebels.tsarBombaSpeed * 2; i++) {
            if (this.tsar == null) {
               return;
            }

            this.tsar.update(this);
         }
      }
   }

   public void updateEntityList() {
      this.entitylist.clear();
      double ldist = this.radius * this.radius;

      for (int i = 0; i < this.field_70170_p.field_72996_f.size(); i++) {
         Entity e = (Entity)this.field_70170_p.field_72996_f.get(i);
         double dist = e.func_70092_e(this.field_70165_t, this.field_70163_u, this.field_70161_v);
         if (dist < ldist
            && (!(e instanceof EntityPlayer) || !((EntityPlayer)e).field_71075_bZ.field_75098_d)
            && !(e instanceof EntityNuclearBlast)
            && !(e instanceof EntityAntimatterBombBlast)
            && e != this) {
            this.entitylist.add(e);
         }
      }
   }

   public void pushAndHurtEntities() {
      List<Entity> remove = new ArrayList<>();
      float invrad = 1.0F / (float)this.radius;

      for (Entity e : this.entitylist) {
         if (!e.field_70128_L && !e.func_85032_ar()) {
            float dx = (float)(e.field_70165_t - this.field_70165_t);
            float dy = (float)(e.field_70163_u - this.field_70163_u);
            float dz = (float)(e.field_70161_v - this.field_70161_v);
            float dist = MathHelper.func_76129_c(dx * dx + dy * dy + dz * dz);
            float rsqrt = 1.0F / (dist + 1.0E-4F);
            dx *= rsqrt;
            dy *= rsqrt;
            dz *= rsqrt;
            double f = 40.0F * (1.0F - dist * invrad) * (!(e instanceof EntityB83) && !(e instanceof EntityHackB83) ? 1.0F : -1.0F);
            if (e instanceof EntityRhodes) {
               e.func_70097_a(RivalRebelsDamageSource.nuclearblast, (int)(this.radius * f * 0.025F));
            } else {
               e.func_70097_a(RivalRebelsDamageSource.nuclearblast, (int)(f * f * 2.0 * this.radius + 20.0));
               e.field_70159_w -= dx * f;
               e.field_70181_x -= dy * f;
               e.field_70179_y -= dz * f;
            }
         } else {
            remove.add(e);
         }
      }

      for (Entity e : remove) {
         this.entitylist.remove(e);
      }
   }

   @Override
   public void func_70037_a(NBTTagCompound nbt) {
      this.field_70159_w = nbt.func_74760_g("size");
      this.radius = nbt.func_74760_g("radius");
   }

   @Override
   public void func_70014_b(NBTTagCompound nbt) {
      nbt.func_74776_a("size", (float)this.field_70159_w);
      nbt.func_74776_a("radius", (float)this.radius);
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

   @Override
   protected void func_70088_a() {
   }

   public EntityAntimatterBombBlast setTime() {
      this.field_70173_aa = 920;
      return this;
   }
}
