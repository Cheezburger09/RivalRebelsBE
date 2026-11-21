package assets.rivalrebels.common.entity;

import net.minecraft.world.World;

public class EntityRhodesRightUpperArm extends EntityRhodesPiece {
   public EntityRhodesRightUpperArm(World w) {
      super(w);
   }

   public EntityRhodesRightUpperArm(World w, double x, double y, double z, float scale, int color) {
      super(w, x, y, z, scale, color);
      this.health = 400;
   }

   @Override
   public int getMaxAge() {
      return 700;
   }
}
