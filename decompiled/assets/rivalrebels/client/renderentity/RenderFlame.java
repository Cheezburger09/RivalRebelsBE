package assets.rivalrebels.client.renderentity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.entity.EntityFlameBall;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL14;

public class RenderFlame extends Render {
   public void renderFlame(EntityFlameBall ell, double x, double y, double z, float yaw, float pitch) {
      if (ell.field_70173_aa >= 3) {
         GL11.glPushMatrix();
         GL11.glDepthMask(false);
         GL11.glEnable(3553);
         GL11.glDisable(2884);
         GL11.glDisable(2896);
         GL11.glEnable(3042);
         GL14.glBlendFuncSeparate(770, 771, 1, 0);
         GL11.glBlendFunc(770, 1);
         GL14.glBlendEquation(32774);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etflameball);
         GL11.glPushMatrix();
         float X = ell.sequence % 4 / 4.0F;
         float Y = (ell.sequence - ell.sequence % 4) / 16.0F;
         float size = 0.05F * ell.field_70173_aa;
         size *= size;
         Tessellator t = Tessellator.field_78398_a;
         GL11.glTranslated(x, y, z);
         GL11.glRotatef(180.0F - Minecraft.func_71410_x().field_71439_g.field_70177_z, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(90.0F - Minecraft.func_71410_x().field_71439_g.field_70125_A, 1.0F, 0.0F, 0.0F);
         GL11.glPushMatrix();
         GL11.glRotatef(ell.rotation, 0.0F, 1.0F, 0.0F);
         t.func_78382_b();
         t.func_78375_b(0.0F, 1.0F, 0.0F);
         t.func_78374_a(-size, 0.0, -size, X, Y);
         t.func_78374_a(size, 0.0, -size, X + 0.25F, Y);
         t.func_78374_a(size, 0.0, size, X + 0.25F, Y + 0.25F);
         t.func_78374_a(-size, 0.0, size, X, Y + 0.25F);
         t.func_78381_a();
         GL11.glPopMatrix();
         GL11.glPopMatrix();
         GL11.glEnable(2896);
         GL11.glEnable(2884);
         GL11.glDisable(3042);
         GL11.glDepthMask(true);
         GL11.glPopMatrix();
      }
   }

   public void func_76986_a(Entity entityLaserLink, double x, double y, double z, float yaw, float pitch) {
      this.renderFlame((EntityFlameBall)entityLaserLink, x, y, z, yaw, pitch);
   }

   protected ResourceLocation func_110775_a(Entity entity) {
      return null;
   }
}
