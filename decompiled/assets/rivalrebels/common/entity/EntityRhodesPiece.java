package assets.rivalrebels.common.entity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsDamageSource;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import assets.rivalrebels.common.explosion.Explosion;
import assets.rivalrebels.common.packet.PacketDispatcher;
import assets.rivalrebels.common.packet.RhodesPiecePacket;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityRhodesPiece extends Entity {
   protected int health;
   private float myaw;
   private float mpitch;
   public float scale = 1.0F;
   public int color = 0;

   public EntityRhodesPiece(World w) {
      super(w);
      this.func_70105_a(4.0F, 2.0F);
      this.field_70121_D.func_72324_b(-1.5, -1.5, -1.5, 1.5, 1.5, 1.5);
   }

   public EntityRhodesPiece(World w, double x, double y, double z, float s, int c) {
      this(w);
      this.func_70107_b(x, y, z);
      this.scale = s;
      this.color = c;
      this.myaw = (float)(this.field_70146_Z.nextGaussian() * 20.0);
      this.mpitch = (float)(this.field_70146_Z.nextGaussian() * 20.0);
      this.field_70159_w = (float)(this.field_70146_Z.nextGaussian() * 0.75);
      this.field_70181_x = (float)Math.abs(this.field_70146_Z.nextGaussian() * 0.75);
      this.field_70179_y = (float)(this.field_70146_Z.nextGaussian() * 0.75);
   }

   public AxisAlignedBB func_70114_g(Entity par1Entity) {
      return par1Entity.field_70121_D;
   }

   public AxisAlignedBB func_70046_E() {
      return this.field_70121_D;
   }

   public boolean func_70067_L() {
      return true;
   }

   public boolean func_70104_M() {
      return true;
   }

   public void func_70071_h_() {
      super.func_70071_h_();
      if (this.field_70173_aa == 1) {
         PacketDispatcher.packetsys.sendToAll(new RhodesPiecePacket(this));
      }

      this.field_70173_aa++;
      if (this.field_70170_p
            .field_73012_v
            .nextInt(Math.max(this.getMaxAge() * (RivalRebels.rhodesPromode ? 1 : 30) - this.field_70173_aa, RivalRebels.rhodesPromode ? 100 : 1))
         == 0) {
         this.func_70106_y();
      }

      this.field_70142_S = this.field_70165_t;
      this.field_70137_T = this.field_70163_u;
      this.field_70136_U = this.field_70161_v;
      this.field_70159_w *= 0.999F;
      this.field_70181_x *= 0.999F;
      this.field_70179_y *= 0.999F;
      this.myaw *= 0.98F;
      this.mpitch *= 0.98F;
      this.field_70177_z = this.field_70177_z + this.myaw;
      this.field_70125_A = this.field_70125_A + this.mpitch;
      if (this.field_70124_G) {
         this.field_70125_A = Math.round(this.field_70125_A / 90.0F) * 90;
         this.field_70159_w *= 0.7F;
         this.field_70179_y *= 0.7F;
      } else {
         this.field_70181_x -= 0.1;
      }

      this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
   }

   public int getMaxAge() {
      return 100;
   }

   public boolean func_70112_a(double par1) {
      return true;
   }

   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
      super.func_70097_a(par1DamageSource, par2);
      if (!this.field_70128_L && !this.field_70170_p.field_72995_K) {
         this.health = (int)(this.health - par2);
         if (this.health <= 0) {
            this.func_70106_y();
            new Explosion(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, 6, true, true, RivalRebelsDamageSource.rocket);
            RivalRebelsSoundPlayer.playSound(this, 0, 0, 30.0F, 1.0F);
         }
      }

      return true;
   }

   protected void func_70088_a() {
   }

   protected void func_70037_a(NBTTagCompound nbt) {
      this.health = nbt.func_74762_e("health");
   }

   protected void func_70014_b(NBTTagCompound nbt) {
      nbt.func_74768_a("health", this.health);
   }
}
