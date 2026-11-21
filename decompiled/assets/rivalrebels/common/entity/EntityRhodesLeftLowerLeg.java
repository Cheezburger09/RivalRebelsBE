package assets.rivalrebels.common.entity;

import net.minecraft.world.World;

public class EntityRhodesLeftLowerLeg extends EntityRhodesPiece {
   public EntityRhodesLeftLowerLeg(World w) {
      super(w);
   }

   public EntityRhodesLeftLowerLeg(World w, double x, double y, double z, float scale, int color) {
      super(w, x, y, z, scale, color);
      this.health = 800;
   }

   @Override
   public int getMaxAge() {
      return 700;
   }
}
