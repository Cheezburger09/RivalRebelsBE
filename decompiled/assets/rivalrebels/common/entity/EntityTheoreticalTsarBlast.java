package assets.rivalrebels.common.entity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.explosion.TsarBomba;
import net.minecraft.world.World;

public class EntityTheoreticalTsarBlast extends EntityTsarBlast {
   public EntityTheoreticalTsarBlast(World par1World) {
      super(par1World);
      this.field_70158_ak = true;
   }

   public EntityTheoreticalTsarBlast(World par1World, float x, float y, float z, TsarBomba tsarBomba, int rad) {
      super(par1World);
      this.field_70158_ak = true;
      this.tsar = tsarBomba;
      this.radius = rad;
      this.field_70159_w = Math.sqrt(this.radius - RivalRebels.tsarBombaStrength) / 10.0;
      this.func_70107_b(x, y, z);
   }
}
