package assets.rivalrebels.common.entity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsDamageSource;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityCuchillo extends EntityInanimate {
   public Entity shootingEntity;
   private boolean inGround;
   private int ticksInGround;

   public EntityCuchillo(World par1World) {
      super(par1World);
      this.func_70105_a(0.5F, 0.5F);
   }

   public EntityCuchillo(World par1World, EntityPlayer player, float par3) {
      super(par1World);
      this.shootingEntity = player;
      this.func_70105_a(0.5F, 0.5F);
      this.func_70012_b(player.field_70165_t, player.field_70163_u + player.func_70047_e(), player.field_70161_v, player.field_70177_z, player.field_70125_A);
      this.field_70165_t = this.field_70165_t - MathHelper.func_76134_b(this.field_70177_z / 180.0F * (float) Math.PI) * 0.16F;
      this.field_70163_u -= 0.1F;
      this.field_70161_v = this.field_70161_v - MathHelper.func_76126_a(this.field_70177_z / 180.0F * (float) Math.PI) * 0.16F;
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      this.field_70129_M = 0.0F;
      this.field_70159_w = -MathHelper.func_76126_a(this.field_70177_z / 180.0F * (float) Math.PI)
         * MathHelper.func_76134_b(this.field_70125_A / 180.0F * (float) Math.PI)
         * par3;
      this.field_70179_y = MathHelper.func_76134_b(this.field_70177_z / 180.0F * (float) Math.PI)
         * MathHelper.func_76134_b(this.field_70125_A / 180.0F * (float) Math.PI)
         * par3;
      this.field_70181_x = -MathHelper.func_76126_a(this.field_70125_A / 180.0F * (float) Math.PI) * par3;
   }

   public EntityCuchillo(World par1World, double x, double y, double z, double mx, double my, double mz) {
      super(par1World);
      this.func_70105_a(0.5F, 0.5F);
      this.func_70107_b(x, y, z);
      this.field_70129_M = 0.0F;
      this.setAnglesMotion(mx, my, mz);
   }

   public void setAnglesMotion(double mx, double my, double mz) {
      this.field_70159_w = mx;
      this.field_70181_x = my;
      this.field_70179_y = mz;
      this.field_70126_B = this.field_70177_z = (float)(Math.atan2(mx, mz) * 180.0 / Math.PI);
      this.field_70127_C = this.field_70125_A = (float)(Math.atan2(my, MathHelper.func_76133_a(mx * mx + mz * mz)) * 180.0 / Math.PI);
   }

   @Override
   protected void func_70088_a() {
   }

   public void func_70071_h_() {
      super.func_70071_h_();
      this.field_70173_aa++;
      if (this.inGround) {
         this.field_70159_w *= 0.2F;
         this.field_70181_x *= 0.2F;
         this.field_70179_y *= 0.2F;
         this.ticksInGround++;
         if (this.ticksInGround == 60) {
            this.field_70170_p
               .func_72838_d(
                  new EntityItem(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, new ItemStack(RivalRebels.knife, 1))
               );
            this.func_70106_y();
         }
      } else {
         Vec3 vec31 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
         Vec3 vec3 = Vec3.func_72443_a(
            this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y
         );
         MovingObjectPosition mop = this.field_70170_p.func_147447_a(vec31, vec3, false, true, false);
         vec31 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
         if (mop != null) {
            vec3 = Vec3.func_72443_a(mop.field_72307_f.field_72450_a, mop.field_72307_f.field_72448_b, mop.field_72307_f.field_72449_c);
         } else {
            vec3 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
         }

         List list = this.field_70170_p
            .func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(1.0, 1.0, 1.0));
         double d0 = Double.MAX_VALUE;

         for (int i = 0; i < list.size(); i++) {
            Entity entity = (Entity)list.get(i);
            if (entity.func_70067_L() && (this.field_70173_aa >= 10 || entity != this.shootingEntity)) {
               MovingObjectPosition mop1 = entity.field_70121_D.func_72314_b(0.5, 0.5, 0.5).func_72327_a(vec31, vec3);
               if (mop1 != null) {
                  double d1 = vec31.func_72436_e(mop1.field_72307_f);
                  if (d1 < d0) {
                     mop = new MovingObjectPosition(entity, mop1.field_72307_f);
                     d0 = d1;
                  }
               }
            }
         }

         if (mop != null) {
            if (!this.field_70170_p.field_72995_K) {
               if (mop.field_72308_g != null) {
                  mop.field_72308_g.func_70097_a(RivalRebelsDamageSource.cuchillo, 7.0F);
                  this.func_70106_y();
               } else {
                  Block block = this.field_70170_p.func_147439_a(mop.field_72311_b, mop.field_72312_c, mop.field_72309_d);
                  Material hit = block.func_149688_o();
                  if (block == Blocks.field_150359_w || block == Blocks.field_150410_aZ || block == Blocks.field_150399_cn || block == Blocks.field_150397_co) {
                     this.field_70170_p.func_147449_b(mop.field_72311_b, mop.field_72312_c, mop.field_72309_d, Blocks.field_150350_a);
                     RivalRebelsSoundPlayer.playSound(this, 4, 0, 5.0F, 0.3F);
                     return;
                  }

                  if (hit == Material.field_151576_e) {
                     this.field_70170_p
                        .func_72838_d(
                           new EntityItem(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, new ItemStack(RivalRebels.knife, 1))
                        );
                     this.func_70106_y();
                  } else {
                     this.inGround = true;
                  }
               }
            }
         } else {
            this.field_70165_t = this.field_70165_t + this.field_70159_w;
            this.field_70163_u = this.field_70163_u + this.field_70181_x;
            this.field_70161_v = this.field_70161_v + this.field_70179_y;
            this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0 / Math.PI);

            while (this.field_70177_z - this.field_70126_B < -180.0F) {
               this.field_70126_B -= 360.0F;
            }

            while (this.field_70177_z - this.field_70126_B >= 180.0F) {
               this.field_70126_B += 360.0F;
            }

            this.field_70125_A -= 30.0F;
            this.field_70177_z = this.field_70126_B + (this.field_70177_z - this.field_70126_B) * 0.2F;
            float friction = 0.98F;
            if (this.func_70090_H()) {
               for (int var26 = 0; var26 < 4; var26++) {
                  this.field_70170_p
                     .func_72869_a(
                        "bubble",
                        this.field_70165_t - this.field_70159_w * 0.25,
                        this.field_70163_u - this.field_70181_x * 0.25,
                        this.field_70161_v - this.field_70179_y * 0.25,
                        this.field_70159_w,
                        this.field_70181_x,
                        this.field_70179_y
                     );
               }

               friction = 0.8F;
            }

            this.field_70159_w *= friction;
            this.field_70181_x *= friction;
            this.field_70179_y *= friction;
            this.field_70181_x -= 0.026F;
            this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
         }
      }
   }

   @Override
   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
   }

   @Override
   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
   }

   public void func_70100_b_(EntityPlayer par1EntityPlayer) {
      if (!this.field_70170_p.field_72995_K && this.inGround) {
         if (!par1EntityPlayer.field_71075_bZ.field_75098_d) {
            par1EntityPlayer.field_71071_by.func_70441_a(new ItemStack(RivalRebels.knife, 1));
         }

         this.field_70170_p.func_72956_a(this, "random.pop", 0.2F, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7F + 1.0F) * 2.0F);
         this.func_70106_y();
      }
   }

   @SideOnly(Side.CLIENT)
   public float func_70053_R() {
      return 0.0F;
   }

   public boolean func_70075_an() {
      return false;
   }
}
