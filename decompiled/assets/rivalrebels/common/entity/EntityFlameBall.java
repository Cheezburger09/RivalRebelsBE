package assets.rivalrebels.common.entity;

import assets.rivalrebels.common.core.RivalRebelsDamageSource;
import assets.rivalrebels.common.tileentity.TileEntityReciever;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityFlameBall extends EntityInanimate {
   public int sequence;
   public float rotation;
   public float motionr;

   public EntityFlameBall(World par1World) {
      super(par1World);
      this.func_70105_a(0.5F, 0.5F);
      this.rotation = (float)(Math.random() * 360.0);
      this.motionr = (float)(Math.random() - 0.5) * 5.0F;
   }

   public EntityFlameBall(World par1World, double par2, double par4, double par6) {
      super(par1World);
      this.func_70105_a(0.5F, 0.5F);
      this.func_70107_b(par2, par4, par6);
      this.rotation = (float)(Math.random() * 360.0);
      this.motionr = (float)(Math.random() - 0.5) * 5.0F;
   }

   public EntityFlameBall(World par1World, EntityPlayer player, float par3) {
      super(par1World);
      this.func_70105_a(0.5F, 0.5F);
      this.func_70107_b(player.field_70165_t, player.field_70163_u + player.func_70047_e(), player.field_70161_v);
      this.field_70159_w = -MathHelper.func_76126_a(player.field_70177_z / 180.0F * (float) Math.PI)
         * MathHelper.func_76134_b(player.field_70125_A / 180.0F * (float) Math.PI);
      this.field_70179_y = MathHelper.func_76134_b(player.field_70177_z / 180.0F * (float) Math.PI)
         * MathHelper.func_76134_b(player.field_70125_A / 180.0F * (float) Math.PI);
      this.field_70181_x = -MathHelper.func_76126_a(player.field_70125_A / 180.0F * (float) Math.PI);
      this.field_70165_t = this.field_70165_t - MathHelper.func_76134_b(player.field_70177_z / 180.0F * (float) Math.PI) * 0.2F;
      this.field_70163_u -= 0.13;
      this.field_70161_v = this.field_70161_v - MathHelper.func_76126_a(player.field_70177_z / 180.0F * (float) Math.PI) * 0.2F;
      this.field_70159_w *= par3;
      this.field_70181_x *= par3;
      this.field_70179_y *= par3;
      this.rotation = (float)(Math.random() * 360.0);
      this.motionr = (float)(Math.random() - 0.5) * 5.0F;
   }

   public EntityFlameBall(World par1World, TileEntityReciever ter, float f) {
      super(par1World);
      this.field_70177_z = (float)(180.0 - ter.yaw);
      this.field_70125_A = (float)(-ter.pitch);
      this.func_70105_a(0.5F, 0.5F);
      this.func_70107_b(ter.field_145851_c + ter.xO + 0.5, ter.field_145848_d + 0.5, ter.field_145849_e + ter.zO + 0.5);
      this.field_70159_w = -MathHelper.func_76126_a(this.field_70177_z / 180.0F * (float) Math.PI)
         * MathHelper.func_76134_b(this.field_70125_A / 180.0F * (float) Math.PI);
      this.field_70179_y = MathHelper.func_76134_b(this.field_70177_z / 180.0F * (float) Math.PI)
         * MathHelper.func_76134_b(this.field_70125_A / 180.0F * (float) Math.PI);
      this.field_70181_x = -MathHelper.func_76126_a(this.field_70125_A / 180.0F * (float) Math.PI);
      this.field_70159_w *= f;
      this.field_70181_x *= f;
      this.field_70179_y *= f;
      this.rotation = (float)(Math.random() * 360.0);
      this.motionr = (float)(Math.random() - 0.5) * 5.0F;
   }

   public EntityFlameBall(World world, double x, double y, double z, double mx, double my, double mz) {
      super(world);
      this.func_70105_a(0.5F, 0.5F);
      this.func_70107_b(x, y, z);
      this.field_70159_w = mx;
      this.field_70181_x = my;
      this.field_70179_y = mz;
      this.rotation = (float)(Math.random() * 360.0);
      this.motionr = (float)(Math.random() - 0.5) * 5.0F;
   }

   public EntityFlameBall(World world, double x, double y, double z, double mx, double my, double mz, double d, double r) {
      super(world);
      this.func_70105_a(0.5F, 0.5F);
      this.func_70107_b(
         x + mx * d + this.field_70146_Z.nextGaussian() * r,
         y + my * d + this.field_70146_Z.nextGaussian() * r,
         z + mz * d + this.field_70146_Z.nextGaussian() * r
      );
      this.field_70159_w = mx;
      this.field_70181_x = my;
      this.field_70179_y = mz;
      this.rotation = (float)(Math.random() * 360.0);
      this.motionr = (float)(Math.random() - 0.5) * 5.0F;
   }

   public void func_70071_h_() {
      this.field_70142_S = this.field_70165_t;
      this.field_70137_T = this.field_70163_u;
      this.field_70136_U = this.field_70161_v;
      super.func_70071_h_();
      this.field_70173_aa++;
      if (this.field_70173_aa % 3 == 0) {
         this.sequence++;
      }

      if (this.sequence > 15) {
         this.func_70106_y();
      }

      Vec3 start = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      Vec3 end = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
      MovingObjectPosition mop = this.field_70170_p.func_72933_a(start, end);
      start = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      end = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
      if (mop != null) {
         end = Vec3.func_72443_a(mop.field_72307_f.field_72450_a, mop.field_72307_f.field_72448_b, mop.field_72307_f.field_72449_c);
      }

      Entity e = null;
      List var5 = this.field_70170_p
         .func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(1.0, 1.0, 1.0));
      double var6 = 0.0;
      Iterator var8 = var5.iterator();
      if (!this.field_70170_p.field_72995_K) {
         while (var8.hasNext()) {
            Entity var9 = (Entity)var8.next();
            if (var9.func_70067_L()) {
               float var10 = 0.3F;
               AxisAlignedBB var11 = var9.field_70121_D.func_72314_b(var10, var10, var10);
               MovingObjectPosition var12 = var11.func_72327_a(start, end);
               if (var12 != null) {
                  double var13 = start.func_72438_d(var12.field_72307_f);
                  if (var13 < var6 || var6 == 0.0) {
                     e = var9;
                     var6 = var13;
                  }
               }
            }
         }
      }

      if (e != null) {
         mop = new MovingObjectPosition(e);
      }

      if (mop != null && this.field_70173_aa >= 5) {
         this.fire();
         this.func_70106_y();
         if (mop.field_72308_g != null) {
            mop.field_72308_g.func_70015_d(3);
            mop.field_72308_g.func_70097_a(RivalRebelsDamageSource.cooked, 12.0F);
            if (mop.field_72308_g != null && mop.field_72308_g instanceof EntityPlayer) {
               EntityPlayer player = (EntityPlayer)mop.field_72308_g;
               ItemStack[] armorSlots = player.field_71071_by.field_70460_b;
               int i = this.field_70170_p.field_73012_v.nextInt(4);
               if (armorSlots[i] != null && !this.field_70170_p.field_72995_K) {
                  armorSlots[i].func_77972_a(8, player);
               }
            }
         }
      }

      this.field_70165_t = this.field_70165_t + this.field_70159_w;
      this.field_70163_u = this.field_70163_u + this.field_70181_x;
      this.field_70161_v = this.field_70161_v + this.field_70179_y;
      this.rotation = this.rotation + this.motionr;
      this.motionr *= 1.06F;
      if (this.func_70090_H()) {
         this.func_70106_y();
      }

      float airFriction = 0.96F;
      float gravity = 0.01F;
      this.field_70159_w *= airFriction;
      this.field_70181_x *= airFriction;
      this.field_70179_y *= airFriction;
      this.field_70181_x -= gravity;
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
   }

   @Override
   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
   }

   @Override
   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
   }

   @Override
   protected void func_70088_a() {
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

   public float func_70053_R() {
      return 0.0F;
   }

   public boolean func_70075_an() {
      return false;
   }

   public boolean shouldRenderInPass(int pass) {
      return true;
   }

   private void fire() {
      if (!this.field_70170_p.field_72995_K) {
         for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
               for (int z = -1; z < 2; z++) {
                  Block id = this.field_70170_p.func_147439_a((int)this.field_70165_t + x, (int)this.field_70163_u + y, (int)this.field_70161_v + z);
                  if (id == Blocks.field_150350_a
                     || id == Blocks.field_150433_aE
                     || id == Blocks.field_150432_aD
                     || id == Blocks.field_150362_t
                     || id == Blocks.field_150361_u) {
                     this.field_70170_p
                        .func_147449_b((int)this.field_70165_t + x, (int)this.field_70163_u + y, (int)this.field_70161_v + z, Blocks.field_150480_ab);
                  }
               }
            }
         }
      }
   }
}
