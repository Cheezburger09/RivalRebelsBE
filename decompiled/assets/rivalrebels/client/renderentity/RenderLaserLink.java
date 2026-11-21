package assets.rivalrebels.client.renderentity;

import assets.rivalrebels.common.entity.EntityLaserLink;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderLaserLink extends Render {
   static float red = 0.5F;
   static float green = 0.1F;
   static float blue = 0.1F;

   public void renderLaserLink(EntityLaserLink ell, double x, double y, double z, float yaw, float pitch) {
      double distance = ell.field_70159_w * 100.0;
      if (distance > 0.0) {
         float radius = 0.7F;
         Tessellator tessellator = Tessellator.field_78398_a;
         GL11.glPushMatrix();
         GL11.glEnable(32826);
         GL11.glDisable(3553);
         GL11.glEnable(3042);
         GL11.glBlendFunc(1, 1);
         GL11.glTranslatef((float)x, (float)y, (float)z);
         GL11.glRotatef(-ell.field_70177_z, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(ell.field_70125_A, 1.0F, 0.0F, 0.0F);

         for (float o = 0.0F; o <= radius; o += radius / 16.0F) {
            tessellator.func_78382_b();
            tessellator.func_78369_a(red, green, blue, 1.0F);
            tessellator.func_78377_a(0.0F + o, 0.0F - o, 0.0);
            tessellator.func_78377_a(0.0F + o, 0.0F + o, 0.0);
            tessellator.func_78377_a(0.0F + o, 0.0F + o, 0.0 + distance);
            tessellator.func_78377_a(0.0F + o, 0.0F - o, 0.0 + distance);
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78369_a(red, green, blue, 1.0F);
            tessellator.func_78377_a(0.0F - o, 0.0F - o, 0.0);
            tessellator.func_78377_a(0.0F + o, 0.0F - o, 0.0);
            tessellator.func_78377_a(0.0F + o, 0.0F - o, 0.0 + distance);
            tessellator.func_78377_a(0.0F - o, 0.0F - o, 0.0 + distance);
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78369_a(red, green, blue, 1.0F);
            tessellator.func_78377_a(0.0F - o, 0.0F + o, 0.0);
            tessellator.func_78377_a(0.0F - o, 0.0F - o, 0.0);
            tessellator.func_78377_a(0.0F - o, 0.0F - o, 0.0 + distance);
            tessellator.func_78377_a(0.0F - o, 0.0F + o, 0.0 + distance);
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78369_a(red, green, blue, 1.0F);
            tessellator.func_78377_a(0.0F + o, 0.0F + o, 0.0);
            tessellator.func_78377_a(0.0F - o, 0.0F + o, 0.0);
            tessellator.func_78377_a(0.0F - o, 0.0F + o, 0.0 + distance);
            tessellator.func_78377_a(0.0F + o, 0.0F + o, 0.0 + distance);
            tessellator.func_78381_a();
         }

         GL11.glDisable(3042);
         GL11.glEnable(3553);
         GL11.glDisable(32826);
         GL11.glPopMatrix();
      }
   }

   public void func_76986_a(Entity entityLaserLink, double x, double y, double z, float yaw, float pitch) {
      this.renderLaserLink((EntityLaserLink)entityLaserLink, x, y, z, yaw, pitch);
   }

   protected ResourceLocation func_110775_a(Entity entity) {
      return null;
   }
}
