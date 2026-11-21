package assets.rivalrebels.common.entity;

import net.minecraft.world.World;

public class EntityRhodesLeftUpperArm extends EntityRhodesPiece {
   public EntityRhodesLeftUpperArm(World w) {
      super(w);
   }

   public EntityRhodesLeftUpperArm(World w, double x, double y, double z, float scale, int color) {
      super(w, x, y, z, scale, color);
      this.health = 400;
   }

   @Override
   public int getMaxAge() {
      return 700;
   }
}
