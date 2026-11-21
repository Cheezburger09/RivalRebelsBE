package assets.rivalrebels.common.entity;

import assets.rivalrebels.RivalRebels;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL14;

public class EntityDocileFlameFX extends EntityFX {
   public int sequence;

   public EntityDocileFlameFX(World par1World, EntityPlayer entity) {
      super(par1World, entity.field_70165_t, entity.field_70163_u + entity.func_70047_e(), entity.field_70161_v);
      this.func_70105_a(0.1F, 0.1F);
      this.func_70012_b(entity.field_70165_t, entity.field_70163_u + entity.func_70047_e(), entity.field_70161_v, entity.field_70177_z, entity.field_70125_A);
      this.field_70177_z = (this.field_70177_z + 25.0F) % 360.0F;
      this.field_70165_t = this.field_70165_t - MathHelper.func_76134_b(this.field_70177_z / 180.0F * (float) Math.PI) * 0.16F;
      this.field_70163_u -= 0.2;
      this.field_70161_v = this.field_70161_v - MathHelper.func_76126_a(this.field_70177_z / 180.0F * (float) Math.PI) * 0.16F;
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      this.field_70129_M = 0.0F;
      this.field_70159_w = -MathHelper.func_76126_a(this.field_70177_z / 180.0F * (float) Math.PI)
         * MathHelper.func_76134_b(this.field_70125_A / 180.0F * (float) Math.PI);
      this.field_70179_y = MathHelper.func_76134_b(this.field_70177_z / 180.0F * (float) Math.PI)
         * MathHelper.func_76134_b(this.field_70125_A / 180.0F * (float) Math.PI);
      this.field_70181_x = -MathHelper.func_76126_a(this.field_70125_A / 180.0F * (float) Math.PI);
      this.func_70016_h(this.field_70159_w, this.field_70181_x, this.field_70179_y);
   }

   public void func_70071_h_() {
      this.field_70169_q = this.field_70142_S = this.field_70165_t;
      this.field_70167_r = this.field_70137_T = this.field_70163_u;
      this.field_70166_s = this.field_70136_U = this.field_70161_v;
      if (this.field_70173_aa >= 8 && this.field_70170_p.field_73012_v.nextInt(2) == 1 || this.field_70171_ac) {
         this.func_70106_y();
      }

      this.field_70173_aa++;
      this.sequence++;
      float airFriction = 0.99F;
      this.field_70159_w *= airFriction;
      this.field_70181_x *= airFriction;
      this.field_70179_y *= airFriction;
      this.field_70181_x += 0.05;
      this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
   }

   public int func_70070_b(float par1) {
      return 1000;
   }

   public float func_70013_c(float par1) {
      return 1000.0F;
   }

   public void func_70539_a(Tessellator t, float par2, float par3, float par4, float par5, float par6, float par7) {
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etflameball);
      GL14.glBlendFuncSeparate(770, 771, 1, 0);
      GL11.glBlendFunc(770, 1);
      GL14.glBlendEquation(32774);
      float f10 = 0.03F * this.field_70544_f;
      float f11 = (float)(this.field_70169_q + (this.field_70165_t - this.field_70169_q) * par2 - field_70556_an);
      float f12 = (float)(this.field_70167_r + (this.field_70163_u - this.field_70167_r) * par2 - field_70554_ao);
      float f13 = (float)(this.field_70166_s + (this.field_70161_v - this.field_70166_s) * par2 - field_70555_ap);
      t.func_78369_a(1.0F, 1.0F, 1.0F, 1.0F);
      float X = this.sequence % 4 / 4.0F;
      float Y = (this.sequence - this.sequence % 4) / 16.0F;
      t.func_78374_a(f11 - par3 * f10 - par6 * f10, f12 - par4 * f10, f13 - par5 * f10 - par7 * f10, X + 0.25F, Y + 0.25F);
      t.func_78374_a(f11 - par3 * f10 + par6 * f10, f12 + par4 * f10, f13 - par5 * f10 + par7 * f10, X + 0.25F, Y);
      t.func_78374_a(f11 + par3 * f10 + par6 * f10, f12 + par4 * f10, f13 + par5 * f10 + par7 * f10, X, Y);
      t.func_78374_a(f11 + par3 * f10 - par6 * f10, f12 - par4 * f10, f13 + par5 * f10 - par7 * f10, X, Y + 0.25F);
   }
}
