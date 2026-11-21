package assets.rivalrebels.common.entity;

import assets.rivalrebels.common.core.RivalRebelsDamageSource;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import assets.rivalrebels.common.explosion.Explosion;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityB2Frag extends EntityInanimate {
   private int xTile = -1;
   private int yTile = -1;
   private int zTile = -1;
   private int inTile;
   protected boolean inGround;
   private int ticksInGround;
   private int ticksInAir;
   private boolean isSliding = false;
   public int type = 0;
   float motionyaw = 0.0F;
   float motionpitch = 0.0F;
   float offset = 0.0F;
   double size = 0.0;
   public int health = 300;

   public EntityB2Frag(World par1World) {
      super(par1World);
      this.field_70121_D.func_72324_b(-2.5, -2.5, -2.5, 2.5, 2.5, 2.5);
      this.func_70105_a(7.5F, 7.5F);
      this.field_70158_ak = true;
   }

   public EntityB2Frag(World par1World, Entity toBeGibbed, int Type) {
      super(par1World);
      this.field_70121_D.func_72324_b(-2.5, -2.5, -2.5, 2.5, 2.5, 2.5);
      this.func_70105_a(7.5F, 7.5F);
      this.field_70158_ak = true;
      this.isSliding = false;
      this.type = Type;
      this.motionyaw = (float)((Math.random() - 0.5) * 35.0);
      this.motionpitch = (float)((Math.random() - 0.5) * 25.0);
      this.func_70012_b(toBeGibbed.field_70165_t, toBeGibbed.field_70163_u, toBeGibbed.field_70161_v, toBeGibbed.field_70177_z, toBeGibbed.field_70125_A);
      double ox = this.field_70165_t;
      double oz = this.field_70161_v;
      if (Type == 1) {
         this.field_70165_t = this.field_70165_t - MathHelper.func_76134_b(-this.field_70177_z / 180.0F * (float) Math.PI) * 7.5F;
         this.field_70161_v = this.field_70161_v - MathHelper.func_76126_a(-this.field_70177_z / 180.0F * (float) Math.PI) * 7.5F;
      } else if (Type == 0) {
         this.field_70165_t = this.field_70165_t - MathHelper.func_76134_b((-this.field_70177_z + 180.0F) / 180.0F * (float) Math.PI) * 7.5F;
         this.field_70161_v = this.field_70161_v - MathHelper.func_76126_a((-this.field_70177_z + 180.0F) / 180.0F * (float) Math.PI) * 7.5F;
      }

      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      this.field_70159_w = toBeGibbed.field_70159_w;
      this.field_70181_x = toBeGibbed.field_70181_x;
      this.field_70179_y = toBeGibbed.field_70179_y;
      this.field_70159_w = this.field_70159_w + (-ox + this.field_70165_t) * 0.1;
      this.field_70179_y = this.field_70179_y + (-oz + this.field_70161_v) * 0.1;
      this.func_70015_d(10);
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

   public void func_70071_h_() {
      if (this.ticksInAir == 0) {
         Side side = FMLCommonHandler.instance().getEffectiveSide();
         if (side == Side.SERVER) {
            for (EntityPlayer player : this.field_70170_p.field_73010_i) {
               ByteArrayOutputStream bos = new ByteArrayOutputStream(9);
               DataOutputStream outputStream = new DataOutputStream(bos);

               try {
                  outputStream.writeInt(17);
                  outputStream.writeInt(this.func_145782_y());
                  outputStream.writeByte(this.type);
               } catch (Exception ex) {
                  ex.printStackTrace();
               } finally {
                  try {
                     if (outputStream != null) {
                        outputStream.close();
                     }
                  } catch (IOException var14) {
                  }
               }
            }
         }
      }

      this.ticksInAir++;
      this.field_70142_S = this.field_70165_t;
      this.field_70137_T = this.field_70163_u;
      this.field_70136_U = this.field_70161_v;
      super.func_70071_h_();
      if (this.inGround) {
         this.ticksInGround++;
         if (this.ticksInGround == 1200) {
            this.func_70106_y();
         }

         this.inGround = false;
         this.field_70159_w = this.field_70159_w * (this.field_70146_Z.nextFloat() * 0.2F);
         this.field_70181_x = this.field_70181_x * (this.field_70146_Z.nextFloat() * 0.2F);
         this.field_70179_y = this.field_70179_y * (this.field_70146_Z.nextFloat() * 0.2F);
         this.ticksInGround = 0;
         this.ticksInAir = 0;
      }

      Vec3 vec3 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      Vec3 vec31 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
      MovingObjectPosition movingobjectposition = this.field_70170_p.func_72933_a(vec3, vec31);
      vec3 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      vec31 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
      if (movingobjectposition != null) {
         this.isSliding = true;
         this.field_70163_u = movingobjectposition.field_72307_f.field_72448_b + this.offset;
      }

      if (!this.field_70170_p.field_72995_K) {
         for (Entity var9 : this.field_70170_p
            .func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(1.0, 1.0, 1.0))) {
            if (var9 instanceof EntityRocket) {
               ((EntityRocket)var9).explode(null);
            }

            if (var9 instanceof EntityPlasmoid) {
               ((EntityPlasmoid)var9).explode();
            }

            if (var9 instanceof EntityLaserBurst) {
               ((EntityLaserBurst)var9).func_70106_y();
               this.func_70097_a(DamageSource.field_76377_j, 6.0F);
            }
         }
      }

      this.field_70125_A = this.field_70125_A + this.motionpitch;
      this.field_70177_z = this.field_70177_z + this.motionyaw;
      this.field_70165_t = this.field_70165_t + this.field_70159_w;
      this.field_70163_u = this.field_70163_u + this.field_70181_x;
      this.field_70161_v = this.field_70161_v + this.field_70179_y;
      this.field_70125_A = this.field_70127_C + (this.field_70125_A - this.field_70127_C) * 0.5F;
      this.field_70177_z = this.field_70126_B + (this.field_70177_z - this.field_70126_B) * 0.5F;
      float f2 = 0.99F;
      float f3 = 0.05F;
      if (this.isSliding) {
         this.motionpitch = 0.0F;
         this.motionyaw = 0.0F;
         this.field_70181_x = 0.0;
         f2 = 0.7F;
         f3 = 0.0F;
      }

      this.motionpitch = (float)((double)this.motionpitch * f2);
      this.motionyaw = (float)((double)this.motionyaw * f2);
      this.field_70159_w *= f2;
      this.field_70181_x *= f2;
      this.field_70179_y *= f2;
      this.field_70181_x -= f3;
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
   }

   public static byte[] getBytesString(String str) {
      char[] buffer = str.toCharArray();
      byte[] bytes = new byte[buffer.length];

      for (int i = 0; i < bytes.length; i++) {
         bytes[i] = (byte)buffer[i];
      }

      return bytes;
   }

   @Override
   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
      par1NBTTagCompound.func_74777_a("xTile", (short)this.xTile);
      par1NBTTagCompound.func_74777_a("yTile", (short)this.yTile);
      par1NBTTagCompound.func_74777_a("zTile", (short)this.zTile);
      par1NBTTagCompound.func_74774_a("inTile", (byte)this.inTile);
      par1NBTTagCompound.func_74774_a("Type", (byte)this.type);
      par1NBTTagCompound.func_74774_a("inGround", (byte)(this.inGround ? 1 : 0));
   }

   @Override
   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
      this.xTile = par1NBTTagCompound.func_74765_d("xTile");
      this.yTile = par1NBTTagCompound.func_74765_d("yTile");
      this.zTile = par1NBTTagCompound.func_74765_d("zTile");
      this.inTile = par1NBTTagCompound.func_74771_c("inTile") & 255;
      this.type = par1NBTTagCompound.func_74771_c("Type") & 255;
      this.inGround = par1NBTTagCompound.func_74771_c("inGround") == 1;
   }

   public boolean func_70112_a(double par1) {
      return true;
   }

   @SideOnly(Side.CLIENT)
   public float func_70053_R() {
      return 0.0F;
   }

   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
      if (!this.field_70128_L) {
         this.health = (int)(this.health - par2);
         if (this.health <= 0) {
            this.func_70106_y();
            new Explosion(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, 6, true, true, RivalRebelsDamageSource.rocket);
            RivalRebelsSoundPlayer.playSound(this, 0, 0, 30.0F, 1.0F);
         }
      }

      return true;
   }

   @Override
   protected void func_70088_a() {
   }
}
