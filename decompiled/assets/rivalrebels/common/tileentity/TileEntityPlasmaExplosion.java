package assets.rivalrebels.common.tileentity;

import assets.rivalrebels.common.core.RivalRebelsDamageSource;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import assets.rivalrebels.common.entity.EntityNuclearBlast;
import assets.rivalrebels.common.entity.EntityPlasmoid;
import assets.rivalrebels.common.entity.EntityRhodes;
import assets.rivalrebels.common.entity.EntityTsarBlast;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;

public class TileEntityPlasmaExplosion extends TileEntity {
   public float size = 0.0F;
   float increment = 0.3F;
   float prevsize = 0.0F;

   public void func_145845_h() {
      this.prevsize = this.size;
      this.size = this.size + this.increment;
      if (this.prevsize == 0.0F) {
         RivalRebelsSoundPlayer.playSound(this.field_145850_b, 16, 0, this.field_145851_c, this.field_145848_d, this.field_145849_e, 4.0F);
      }

      if (this.size > 3.1F) {
         this.size = 0.0F;
         this.field_145850_b.func_147449_b(this.field_145851_c, this.field_145848_d, this.field_145849_e, Blocks.field_150350_a);
         this.func_145843_s();
      }

      double fsize = Math.sin(this.size) * 5.9 * 2.0;
      double fsqr = fsize * fsize;
      List l = this.field_145850_b
         .func_72839_b(
            null,
            AxisAlignedBB.func_72330_a(
               this.field_145851_c - fsize + 0.5,
               this.field_145848_d - fsize + 0.5,
               this.field_145849_e - fsize + 0.5,
               this.field_145851_c + fsize + 0.5,
               this.field_145848_d + fsize + 0.5,
               this.field_145849_e + fsize + 0.5
            )
         );

      for (int i = 0; i < l.size(); i++) {
         Entity e = (Entity)l.get(i);
         double var15 = e.field_70165_t - this.field_145851_c;
         double var17 = e.field_70163_u + e.func_70047_e() - this.field_145848_d + 1.5;
         double var19 = e.field_70161_v - this.field_145849_e;
         double dist = 0.5F / (MathHelper.func_76133_a(var15 * var15 + var17 * var17 + var19 * var19) + 0.01F);
         if (dist <= 0.5
            && !(e instanceof EntityNuclearBlast)
            && !(e instanceof EntityPlasmoid)
            && !(e instanceof EntityTsarBlast)
            && !(e instanceof EntityRhodes)) {
            e.func_70097_a(RivalRebelsDamageSource.plasmaexplosion, 2.0F);
            e.field_70159_w += var15 * dist;
            e.field_70181_x += var17 * dist;
            e.field_70179_y += var19 * dist;
         }
      }

      super.func_145845_h();
   }

   public AxisAlignedBB getRenderBoundingBox() {
      return AxisAlignedBB.func_72330_a(
         this.field_145851_c - 2, this.field_145848_d - 2, this.field_145849_e - 2, this.field_145851_c + 3, this.field_145848_d + 3, this.field_145849_e + 3
      );
   }

   @SideOnly(Side.CLIENT)
   public double func_145833_n() {
      return 16384.0;
   }
}
