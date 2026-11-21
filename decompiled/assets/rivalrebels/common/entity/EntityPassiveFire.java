package assets.rivalrebels.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityPassiveFire extends EntityInanimate {
   private int xTile;
   private int yTile;
   private int zTile;
   private World world;
   private int timer = 0;
   private int inTile;
   private int inData;
   private boolean inGround;
   public Entity shootingEntity;
   private int ticksInAir;
   private double damage;

   public EntityPassiveFire(World par1World) {
      super(par1World);
      this.xTile = -1;
      this.yTile = -1;
      this.zTile = -1;
      this.world = par1World;
      this.inTile = 0;
      this.inData = 0;
      this.inGround = false;
      this.ticksInAir = 0;
      this.damage = 2.0;
      this.func_70105_a(0.1F, 0.1F);
   }

   public EntityPassiveFire(World par1World, double par2, double par4, double par6) {
      super(par1World);
      this.world = par1World;
      this.xTile = -1;
      this.yTile = -1;
      this.zTile = -1;
      this.inTile = 0;
      this.inData = 0;
      this.inGround = false;
      this.ticksInAir = 0;
      this.damage = 2.0;
      this.func_70105_a(0.1F, 0.1F);
      this.func_70107_b(par2, par4, par6);
      this.field_70129_M = 0.0F;
   }

   public EntityPassiveFire(World par1World, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving, float par4, float par5) {
      super(par1World);
      this.world = par1World;
      this.xTile = -1;
      this.yTile = -1;
      this.zTile = -1;
      this.inTile = 0;
      this.inData = 0;
      this.inGround = false;
      this.ticksInAir = 0;
      this.damage = 2.0;
      this.shootingEntity = par2EntityLiving;
      this.field_70163_u = par2EntityLiving.field_70163_u + par2EntityLiving.func_70047_e() - 0.1;
      double d = par3EntityLiving.field_70165_t - par2EntityLiving.field_70165_t;
      double d1 = par3EntityLiving.field_70163_u + par3EntityLiving.func_70047_e() - 0.7 - this.field_70163_u;
      double d2 = par3EntityLiving.field_70161_v - par2EntityLiving.field_70161_v;
      double d3 = MathHelper.func_76133_a(d * d + d2 * d2);
      if (!(d3 < 1.0E-7)) {
         float f = (float)(Math.atan2(d2, d) * 180.0 / Math.PI) - 90.0F;
         float f1 = (float)(-(Math.atan2(d1, d3) * 180.0 / Math.PI));
         double d4 = d / d3;
         double d5 = d2 / d3;
         this.func_70012_b(par2EntityLiving.field_70165_t + d4, this.field_70163_u, par2EntityLiving.field_70161_v + d5, f, f1);
         this.field_70129_M = 0.0F;
         float f2 = (float)d3 * 0.2F;
         this.func_70016_h(d, d1 + f2, d2);
      }
   }

   public EntityPassiveFire(World par1World, Entity entity, float par3) {
      super(par1World);
      this.world = par1World;
      this.xTile = -1;
      this.yTile = -1;
      this.zTile = -1;
      this.inTile = 0;
      this.inData = 0;
      this.inGround = false;
      this.ticksInAir = 0;
      this.damage = 2.0;
      this.shootingEntity = entity;
      this.func_70105_a(0.1F, 0.1F);
      this.func_70012_b(entity.field_70165_t, entity.field_70163_u + entity.func_70047_e(), entity.field_70161_v, entity.field_70177_z, entity.field_70125_A);
      this.field_70177_z = (this.field_70177_z + 25.0F) % 360.0F;
      this.field_70165_t = this.field_70165_t - MathHelper.func_76134_b(this.field_70177_z / 180.0F * (float) Math.PI) * 0.16F;
      this.field_70163_u -= 0.2;
      this.field_70161_v = this.field_70161_v - MathHelper.func_76126_a(this.field_70177_z / 180.0F * (float) Math.PI) * 0.16F;
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      this.field_70129_M = 0.0F;
      this.field_70159_w = -MathHelper.func_76126_a(this.field_70177_z / 180.0F * (float) Math.PI)
         * MathHelper.func_76134_b(this.field_70125_A / 180.0F * (float) Math.PI);
      this.field_70179_y = MathHelper.func_76134_b(this.field_70177_z / 180.0F * (float) Math.PI)
         * MathHelper.func_76134_b(this.field_70125_A / 180.0F * (float) Math.PI);
      this.field_70181_x = -MathHelper.func_76126_a(this.field_70125_A / 180.0F * (float) Math.PI);
      this.func_70016_h(this.field_70159_w, this.field_70181_x, this.field_70179_y);
   }

   public int func_70070_b(float par1) {
      return 1000;
   }

   public float func_70013_c(float par1) {
      return 1000.0F;
   }

   public boolean func_70112_a(double par1) {
      return par1 <= 16.0;
   }

   public EntityPassiveFire(World world, int x, int y, int z, int mx, int my, int mz) {
      super(world);
      this.world = world;
      this.xTile = -1;
      this.yTile = -1;
      this.zTile = -1;
      this.inTile = 0;
      this.inData = 0;
      this.inGround = false;
      this.ticksInAir = 0;
      this.damage = 2.0;
      this.func_70105_a(0.3F, 0.3F);
      this.func_70107_b(x, y, z);
      this.field_70159_w = mx;
      this.field_70181_x = my;
      this.field_70179_y = mz;
      this.field_70129_M = 0.0F;
   }

   @Override
   protected void func_70088_a() {
   }

   public void func_70016_h(double par1, double par3, double par5) {
      this.field_70159_w = par1 + (this.field_70170_p.field_73012_v.nextFloat() - 0.5) / 50.0;
      this.field_70181_x = par3 + (this.field_70170_p.field_73012_v.nextFloat() - 0.5) / 50.0;
      this.field_70179_y = par5 + (this.field_70170_p.field_73012_v.nextFloat() - 0.5) / 50.0;
   }

   public void func_70071_h_() {
      this.field_70142_S = this.field_70165_t;
      this.field_70137_T = this.field_70163_u;
      this.field_70136_U = this.field_70161_v;
      super.func_70071_h_();
      if (this.ticksInAir > 7) {
         this.func_70106_y();
      }

      this.field_70165_t = this.field_70165_t + this.field_70159_w;
      this.field_70163_u = this.field_70163_u + this.field_70181_x;
      this.field_70161_v = this.field_70161_v + this.field_70179_y;
      float var17 = 0.4F;
      float var18 = -0.02F;
      if (this.func_70090_H()) {
         this.func_70106_y();
      }

      this.field_70159_w *= var17;
      this.field_70181_x *= var17;
      this.field_70179_y *= var17;
      this.field_70181_x -= var18;
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      this.ticksInAir++;
   }

   @Override
   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
      par1NBTTagCompound.func_74777_a("xTile", (short)this.xTile);
      par1NBTTagCompound.func_74777_a("yTile", (short)this.yTile);
      par1NBTTagCompound.func_74777_a("zTile", (short)this.zTile);
      par1NBTTagCompound.func_74774_a("inTile", (byte)this.inTile);
      par1NBTTagCompound.func_74774_a("inData", (byte)this.inData);
      par1NBTTagCompound.func_74774_a("inGround", (byte)(this.inGround ? 1 : 0));
      par1NBTTagCompound.func_74780_a("damage", this.damage);
   }

   @Override
   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
      this.xTile = par1NBTTagCompound.func_74765_d("xTile");
      this.yTile = par1NBTTagCompound.func_74765_d("yTile");
      this.zTile = par1NBTTagCompound.func_74765_d("zTile");
      this.inTile = par1NBTTagCompound.func_74771_c("inTile") & 255;
      this.inData = par1NBTTagCompound.func_74771_c("inData") & 255;
      this.inGround = par1NBTTagCompound.func_74771_c("inGround") == 1;
      if (par1NBTTagCompound.func_74764_b("damage")) {
         this.damage = par1NBTTagCompound.func_74769_h("damage");
      }
   }

   public float func_70053_R() {
      return 0.0F;
   }

   public boolean func_70075_an() {
      return false;
   }
}
