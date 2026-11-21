package assets.rivalrebels.common.entity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.packet.EntityGorePacket;
import assets.rivalrebels.common.packet.PacketDispatcher;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityGore extends EntityInanimate {
   protected boolean inGround;
   public Entity origin;
   public String username = "Steve";
   private int ticksExisted;
   private boolean isSliding = false;
   public int type = 0;
   public int mob = -1;
   private int slideCount = 0;
   float x = 0.0F;
   float y = 0.0F;
   float z = 0.0F;
   float rotYaw = 0.0F;
   float rotPitch = 0.0F;
   float motionyaw = 0.0F;
   float motionpitch = 0.0F;
   int pitchLock = 0;
   float offset = 0.0F;
   public double size = 0.0;
   public boolean greenblood = false;
   public ResourceLocation playerSkin = null;
   private int bounces = -1;

   public EntityGore(World par1World) {
      super(par1World);
      this.func_70105_a(0.25F, 0.25F);
   }

   public EntityGore(World par1World, double x, double y, double z, double mx, double my, double mz, int Type, int Mob) {
      super(par1World);
      this.func_70105_a(0.5F, 0.5F);
      this.func_70107_b(x, y, z);
      this.field_70129_M = 0.0F;
      this.setAnglesMotion(mx, my, mz);
      this.type = Type;
      this.mob = Mob;
   }

   public void setAnglesMotion(double mx, double my, double mz) {
      this.field_70159_w = mx;
      this.field_70181_x = my;
      this.field_70179_y = mz;
      this.field_70126_B = this.field_70177_z = (float)(Math.atan2(mx, mz) * 180.0 / Math.PI);
      this.field_70127_C = this.field_70125_A = (float)(Math.atan2(my, MathHelper.func_76133_a(mx * mx + mz * mz)) * 180.0 / Math.PI);
   }

   public EntityGore(World par1World, Entity toBeGibbed, int Type, int Mob) {
      super(par1World);
      this.func_70105_a(0.25F, 0.25F);
      this.origin = toBeGibbed;
      this.isSliding = false;
      this.slideCount = 0;
      this.bounces = -1;
      this.pitchLock = 0;
      this.type = Type;
      this.greenblood = false;
      this.mob = Mob;
      if (Mob == 0) {
         this.username = ((EntityPlayer)this.origin).func_70005_c_();
         this.setBiped(0);
      } else if (Mob == 1) {
         this.setBiped(0);
      } else if (Mob == 2) {
         this.setBiped(0);
      } else if (Mob == 3) {
         this.setBiped(1);
         this.greenblood = true;
      } else if (Mob == 4) {
         this.setBiped(2);
      } else if (Mob == 5) {
         this.setQuadruped();
         this.greenblood = true;
      } else if (Mob == 6) {
         this.setNoped();
         this.greenblood = true;
      } else if (Mob == 7) {
         this.setNoped();
      } else if (Mob == 8) {
         this.setOctoped(0);
      } else if (Mob == 9) {
         this.setOctoped(1);
         this.greenblood = true;
      } else if (Mob == 10) {
         this.setOctoped(2);
      } else if (Mob == 11) {
         this.size = this.origin.field_70121_D.func_72320_b();
         if (this.size > 2.0 || this.size < 1.0) {
            this.greenblood = true;
         }

         this.setDefault();
      }

      this.motionyaw = (float)((Math.random() - 0.5) * 135.0);
      this.motionpitch = (float)((Math.random() - 0.5) * 135.0);
      this.func_70012_b(toBeGibbed.field_70165_t + this.x, toBeGibbed.field_70163_u + this.y, toBeGibbed.field_70161_v + this.z, this.rotYaw, this.rotPitch);
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      this.setThrowableHeading(0.3F);
   }

   private void setNoped() {
      if (this.type == 0) {
         this.y = this.origin.func_70047_e();
         this.offset = 0.5F;
      }

      if (this.type == 1) {
         this.y = this.origin.func_70047_e();
         this.offset = 0.25F;
      }

      this.rotYaw = this.origin.field_70177_z;
   }

   private void setBiped(int thin) {
      if (this.type == 0) {
         this.y = this.origin.func_70047_e() + 0.2F;
         this.offset = 0.25F;
         this.rotYaw = this.origin.field_70177_z;
         this.rotPitch = this.origin.field_70125_A;
      }

      if (this.type == 1) {
         if (thin == 2) {
            this.y = 2.0F;
         } else {
            this.y = 1.1F;
         }

         this.offset = 0.125F;
         this.rotYaw = this.origin.field_70177_z;
      }

      if (this.type == 2) {
         this.x = (float)Math.random() - 0.5F;
         if (thin == 2) {
            this.y = 1.6F;
         } else {
            this.y = 1.1F;
         }

         this.z = (float)Math.random() - 0.5F;
         if (thin == 0) {
            this.offset = 0.125F;
         } else {
            this.offset = 0.0625F;
         }

         this.rotYaw = this.origin.field_70177_z;
      }

      if (this.type == 3) {
         this.x = (float)Math.random() - 0.5F;
         if (thin == 2) {
            this.y = 0.95F;
         } else {
            this.y = 0.35F;
         }

         this.z = (float)Math.random() - 0.5F;
         if (thin == 0) {
            this.offset = 0.125F;
         } else {
            this.offset = 0.0625F;
         }

         this.rotYaw = this.origin.field_70177_z;
      }
   }

   private void setQuadruped() {
      if (this.type == 0) {
         this.y = this.origin.func_70047_e();
         this.offset = 0.25F;
         this.rotYaw = this.origin.field_70177_z;
         this.rotPitch = this.origin.field_70125_A;
      }

      if (this.type == 1) {
         this.y = 0.875F;
         this.offset = 0.125F;
         this.rotYaw = this.origin.field_70177_z;
      }

      if (this.type == 3) {
         this.x = (float)(Math.random() - 0.5);
         this.y = 0.25F;
         this.z = (float)(Math.random() - 0.5);
         this.offset = 0.125F;
         this.rotYaw = this.origin.field_70177_z;
      }
   }

   private void setOctoped(int mode) {
      if (mode != 2) {
         float scale = 1.0F;
         if (mode == 1) {
            scale = 0.666F;
         }

         if (this.type == 0) {
            this.y = this.origin.func_70047_e();
            this.offset = 0.25F * scale;
            this.rotYaw = this.origin.field_70177_z;
            this.rotPitch = this.origin.field_70125_A;
         }

         if (this.type == 1) {
            this.x = (float)(Math.random() - 0.5) * scale;
            this.y = 0.25F * scale;
            this.z = (float)(Math.random() - 0.5) * scale;
            this.offset = 0.1F * scale;
            this.rotYaw = this.origin.field_70177_z;
         }

         if (this.type == 3) {
            this.x = (float)(Math.random() - 0.5) * scale;
            this.y = 0.25F * scale;
            this.z = (float)(Math.random() - 0.5) * scale;
            this.offset = 0.0625F * scale;
            this.rotYaw = (float)(Math.random() * 360.0);
            this.rotPitch = 25.0F;
         }
      } else {
         if (this.type == 0) {
            this.y = this.origin.func_70047_e();
            this.offset = 1.5F;
            this.rotYaw = this.origin.field_70177_z;
            this.rotPitch = this.origin.field_70125_A;
         }

         if (this.type == 3) {
            this.x = (float)(Math.random() - 0.5) * 4.0F;
            this.z = (float)(Math.random() - 0.5) * 4.0F;
            this.offset = 0.125F;
         }
      }
   }

   private void setDefault() {
      if (this.type == 0) {
         this.y = this.origin.func_70047_e() + 0.2F;
         this.offset = 0.25F;
         this.rotYaw = this.origin.field_70177_z;
         this.rotPitch = this.origin.field_70125_A;
      }

      if (this.type == 1) {
         this.y = this.origin.func_70047_e() / 2.0F;
         this.offset = 0.125F;
         this.rotYaw = this.origin.field_70177_z;
      }

      if (this.type == 2) {
         this.x = (float)((Math.random() - 0.5) * this.size);
         this.y = this.origin.func_70047_e() / 2.0F;
         this.z = (float)((Math.random() - 0.5) * this.size);
         this.offset = 0.0625F;
         this.rotYaw = this.origin.field_70177_z;
      }

      if (this.type == 3) {
         this.x = (float)((Math.random() - 0.5) * this.size);
         this.y = this.origin.func_70047_e() / 4.0F;
         this.z = (float)((Math.random() - 0.5) * this.size);
         this.offset = 0.0625F;
         this.rotYaw = this.origin.field_70177_z;
      }
   }

   public void setThrowableHeading(float par7) {
      this.field_70159_w = this.field_70146_Z.nextGaussian() * par7;
      this.field_70181_x = Math.abs(this.field_70146_Z.nextGaussian() * par7);
      this.field_70179_y = this.field_70146_Z.nextGaussian() * par7;
   }

   public void func_70071_h_() {
      if (this.ticksExisted == 0) {
         Side side = FMLCommonHandler.instance().getEffectiveSide();
         if (side == Side.SERVER) {
            PacketDispatcher.packetsys.sendToAll(new EntityGorePacket(this));
         }
      }

      if (this.playerSkin == null && FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT && !this.username.equals("Steve")) {
         for (EntityPlayer player : this.field_70170_p.field_73010_i) {
            if (player.func_70005_c_().equals(this.username)) {
               AbstractClientPlayer acp = (AbstractClientPlayer)player;
               this.playerSkin = acp.func_110306_p();
            }
         }
      }

      this.ticksExisted++;
      super.func_70071_h_();
      if (this.inGround) {
         this.inGround = false;
         this.field_70159_w = this.field_70159_w * (this.field_70146_Z.nextFloat() * 0.2F);
         this.field_70181_x = this.field_70181_x * (this.field_70146_Z.nextFloat() * 0.2F);
         this.field_70179_y = this.field_70179_y * (this.field_70146_Z.nextFloat() * 0.2F);
      }

      if (this.isSliding) {
         this.slideCount++;
         if (this.slideCount == 140) {
            this.func_70106_y();
         }
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

      this.field_70125_A = this.field_70125_A + this.motionpitch;
      this.field_70177_z = this.field_70177_z + this.motionyaw;
      this.field_70165_t = this.field_70165_t + this.field_70159_w;
      this.field_70163_u = this.field_70163_u + this.field_70181_x;
      this.field_70161_v = this.field_70161_v + this.field_70179_y;
      this.field_70125_A = this.field_70127_C + (this.field_70125_A - this.field_70127_C) * 0.5F;
      this.field_70177_z = this.field_70126_B + (this.field_70177_z - this.field_70126_B) * 0.5F;
      float f2 = 0.99F;
      float f3 = 0.05F;
      if (this.func_70090_H()) {
         f2 = 0.9F;
      } else if (!this.isSliding) {
         if (this.field_70170_p.field_72995_K && RivalRebels.goreEnabled && FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
            this.spawnBlood();
         }
      } else {
         f2 = 0.8F;
      }

      this.motionpitch = (float)((double)this.motionpitch * f2);
      this.motionyaw = (float)((double)this.motionyaw * f2);
      this.field_70159_w *= f2;
      this.field_70181_x *= f2;
      this.field_70179_y *= f2;
      this.field_70181_x -= f3;
      if (this.isSliding) {
         if (this.bounces == -1) {
            this.bounces = this.field_70170_p.field_73012_v.nextInt(2) + 2;
         }

         if (this.bounces > 0) {
            this.bounces--;
            this.field_70181_x = this.field_70181_x * -(Math.random() * 0.5 + 0.35);
            this.isSliding = false;
            this.slideCount = 0;
            this.pitchLock = (int)(Math.ceil(this.field_70125_A / 90.0F) * 90.0);
         } else {
            this.field_70181_x = 0.0;
         }

         this.motionpitch = 0.0F;
         this.field_70125_A = this.pitchLock;
      }

      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
   }

   @SideOnly(Side.CLIENT)
   private void spawnBlood() {
      for (int i = 0; i < 3; i++) {
         RivalRebels.proxy.spawnGore(this.field_70170_p, this, !this.greenblood);
      }
   }

   public static byte[] getBytesString(String str) {
      char[] buffer = str.toCharArray();
      byte[] bytes = new byte[buffer.length];

      for (int i = 0; i < bytes.length; i++) {
         bytes[i] = (byte)buffer[i];
      }

      return bytes;
   }

   @SideOnly(Side.CLIENT)
   public boolean func_70112_a(double par1) {
      return true;
   }

   @Override
   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
      par1NBTTagCompound.func_74774_a("Mob", (byte)this.mob);
      par1NBTTagCompound.func_74774_a("Type", (byte)this.type);
      par1NBTTagCompound.func_74774_a("Green", (byte)(this.greenblood ? 1 : 0));
   }

   @Override
   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
      this.mob = par1NBTTagCompound.func_74771_c("Mob") & 255;
      this.type = par1NBTTagCompound.func_74771_c("Type") & 255;
      this.greenblood = par1NBTTagCompound.func_74771_c("Green") == 1;
   }

   @SideOnly(Side.CLIENT)
   public float func_70053_R() {
      return 0.0F;
   }

   @Override
   public void func_70088_a() {
   }
}
