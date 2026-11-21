package assets.rivalrebels.common.entity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityRhodesHead extends EntityRhodesPiece {
   public EntityRhodesHead(World w) {
      super(w);
   }

   public EntityRhodesHead(World w, double x, double y, double z, float scale, int color) {
      super(w, x, y, z, scale, color);
      this.health = 700;
   }

   @Override
   public int getMaxAge() {
      return 3000;
   }

   @Override
   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
      this.func_70018_K();
      if (!this.field_70128_L && !this.field_70170_p.field_72995_K) {
         this.health = (int)(this.health - par2);
         if (this.health <= 0) {
            this.func_70106_y();
            this.field_70170_p
               .func_72838_d(
                  new EntityItem(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, new ItemStack(RivalRebels.nuclearelement, 4))
               );
            this.field_70170_p
               .func_72838_d(
                  new EntityItem(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, new ItemStack(RivalRebels.core3, 1))
               );
            this.field_70170_p
               .func_72838_d(
                  new EntityItem(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, new ItemStack(RivalRebels.einsten, 1))
               );
            if (this.field_70146_Z.nextBoolean()) {
               this.field_70170_p
                  .func_72838_d(
                     new EntityItem(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, new ItemStack(RivalRebels.buildrhodes, 1))
                  );
            }

            RivalRebelsSoundPlayer.playSound(this, 0, 0, 30.0F, 1.0F);
         }
      }

      return true;
   }
}
