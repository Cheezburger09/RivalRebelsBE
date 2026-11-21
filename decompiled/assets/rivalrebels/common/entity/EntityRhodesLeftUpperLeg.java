package assets.rivalrebels.common.entity;

import net.minecraft.world.World;

public class EntityRhodesLeftUpperLeg extends EntityRhodesPiece {
   public EntityRhodesLeftUpperLeg(World w) {
      super(w);
   }

   public EntityRhodesLeftUpperLeg(World w, double x, double y, double z, float scale, int color) {
      super(w, x, y, z, scale, color);
      this.health = 600;
   }

   @Override
   public int getMaxAge() {
      return 700;
   }
}
