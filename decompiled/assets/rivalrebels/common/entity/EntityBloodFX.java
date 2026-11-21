package assets.rivalrebels.common.entity;

import assets.rivalrebels.RivalRebels;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class EntityBloodFX extends EntityFX {
   boolean isBlood;

   public EntityBloodFX(World w, double x, double y, double z, boolean b) {
      this(w, x, y, z, w.field_73012_v.nextGaussian() * 0.1, w.field_73012_v.nextGaussian() * 0.1, w.field_73012_v.nextGaussian() * 0.1, b);
   }

   public EntityBloodFX(World w, double x, double y, double z, double r, double g, double b, boolean bl) {
      super(w, x, y, z, r, g, b);
      this.field_70165_t = x;
      this.field_70163_u = y;
      this.field_70161_v = z;
      this.field_70159_w = r;
      this.field_70181_x = g;
      this.field_70179_y = b;
      this.field_70545_g = 0.75F;
      this.field_70547_e = 20;
      this.isBlood = bl;
   }

   public EntityBloodFX(World w, EntityGore g, boolean b) {
      this(w, g.field_70165_t, g.field_70163_u, g.field_70161_v, b);
   }

   public void func_70539_a(Tessellator t, float par2, float par3, float par4, float par5, float par6, float par7) {
      Minecraft.func_71410_x().field_71446_o.func_110577_a(this.isBlood ? RivalRebels.etblood : RivalRebels.etgoo);
      float f10 = 0.1F * this.field_70544_f;
      float f11 = (float)(this.field_70169_q + (this.field_70165_t - this.field_70169_q) * par2 - field_70556_an);
      float f12 = (float)(this.field_70167_r + (this.field_70163_u - this.field_70167_r) * par2 - field_70554_ao);
      float f13 = (float)(this.field_70166_s + (this.field_70161_v - this.field_70166_s) * par2 - field_70555_ap);
      t.func_78369_a(1.0F, 1.0F, 1.0F, 1.0F);
      t.func_78374_a(f11 - par3 * f10 - par6 * f10, f12 - par4 * f10, f13 - par5 * f10 - par7 * f10, 1.0, 1.0);
      t.func_78374_a(f11 - par3 * f10 + par6 * f10, f12 + par4 * f10, f13 - par5 * f10 + par7 * f10, 1.0, 0.0);
      t.func_78374_a(f11 + par3 * f10 + par6 * f10, f12 + par4 * f10, f13 + par5 * f10 + par7 * f10, 0.0, 0.0);
      t.func_78374_a(f11 + par3 * f10 - par6 * f10, f12 - par4 * f10, f13 + par5 * f10 - par7 * f10, 0.0, 1.0);
   }
}
