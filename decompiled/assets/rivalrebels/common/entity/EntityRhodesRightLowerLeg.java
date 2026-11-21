package assets.rivalrebels.common.entity;

import net.minecraft.world.World;

public class EntityRhodesRightLowerLeg extends EntityRhodesPiece {
   public EntityRhodesRightLowerLeg(World w) {
      super(w);
   }

   public EntityRhodesRightLowerLeg(World w, double x, double y, double z, float scale, int color) {
      super(w, x, y, z, scale, color);
      this.health = 800;
   }

   @Override
   public int getMaxAge() {
      return 700;
   }
}
