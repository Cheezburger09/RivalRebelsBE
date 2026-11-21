package assets.rivalrebels.common.tileentity;

public class TileEntityReactive extends TileEntityMachineBase {
   int cooldown = 0;

   public TileEntityReactive() {
      this.pInM = 1.0F;
   }

   @Override
   public float powered(float power, float distance) {
      int metadata = this.field_145850_b.func_72805_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
      if (metadata > 0) {
         if (this.cooldown <= 0) {
            this.field_145850_b.func_72921_c(this.field_145851_c, this.field_145848_d, this.field_145849_e, metadata - 1, 2);
            this.cooldown = 10;
            return power - 1.0F;
         }

         this.cooldown--;
      }

      return power;
   }
}
