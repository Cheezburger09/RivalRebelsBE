package assets.rivalrebels.common.entity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.explosion.NuclearExplosion;
import net.minecraft.world.World;

public class EntityB83NoShroom extends EntityB83 {
   public int field_70195_i = 0;

   public EntityB83NoShroom(World par1World) {
      super(par1World);
      this.func_70105_a(0.5F, 0.5F);
   }

   public EntityB83NoShroom(World par1World, double x, double y, double z, double mx, double my, double mz) {
      super(par1World);
      this.func_70105_a(0.5F, 0.5F);
      this.func_70107_b(x, y, z);
      this.field_70129_M = 0.0F;
      this.func_70186_c(mx, my, mz, 5.0F, 1.0F);
   }

   @Override
   public void func_70071_h_() {
      this.field_70159_w *= 1.1F;
      this.field_70181_x *= 1.1F;
      this.field_70179_y *= 1.1F;
      super.func_70071_h_();
   }

   @Override
   public void explode() {
      new NuclearExplosion(this.field_70170_p, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, RivalRebels.b83Strength / 2);
      EntitySphereBlast etb = new EntitySphereBlast(
         this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, RivalRebels.b83Strength * 1.3333334F
      );
      etb.time = -920;
      this.field_70170_p.func_72838_d(etb);
      this.func_70106_y();
   }
}
