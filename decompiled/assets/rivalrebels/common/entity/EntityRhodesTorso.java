package assets.rivalrebels.common.entity;

import net.minecraft.world.World;

public class EntityRhodesTorso extends EntityRhodesPiece {
   public EntityRhodesTorso(World w) {
      super(w);
   }

   public EntityRhodesTorso(World w, double x, double y, double z, float scale, int color) {
      super(w, x, y, z, scale, color);
      this.health = 2000;
   }

   @Override
   public int getMaxAge() {
      return 1500;
   }
}
