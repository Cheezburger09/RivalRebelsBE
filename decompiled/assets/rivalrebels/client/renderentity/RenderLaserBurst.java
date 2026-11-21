package assets.rivalrebels.client.renderentity;

import assets.rivalrebels.common.entity.EntityLaserBurst;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderLaserBurst extends Render {
   static float red = 1.0F;
   static float green = 0.0F;
   static float blue = 0.0F;

   public void renderLaserBurst(EntityLaserBurst ell, double x, double y, double z, float yaw, float pitch) {
      float radius = 0.12F;
      int distance = 4;
      Tessellator tessellator = Tessellator.field_78398_a;
      GL11.glPushMatrix();
      GL11.glDisable(3553);
      GL11.glDisable(2884);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 1);
      GL11.glTranslatef((float)x, (float)y, (float)z);
      GL11.glRotatef(ell.field_70177_z, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(-ell.field_70125_A, 1.0F, 0.0F, 0.0F);

      for (float o = 0.0F; o <= radius; o += radius / 8.0F) {
         float color = 1.0F - o * 8.333F;
         if (color < 0.0F) {
            color = 0.0F;
         }

         tessellator.func_78382_b();
         tessellator.func_78369_a(red, color, color, 1.0F);
         tessellator.func_78377_a(0.0F + o, 0.0F - o, 0.0);
         tessellator.func_78377_a(0.0F + o, 0.0F + o, 0.0);
         tessellator.func_78377_a(0.0F + o, 0.0F + o, 0 + distance);
         tessellator.func_78377_a(0.0F + o, 0.0F - o, 0 + distance);
         tessellator.func_78381_a();
         tessellator.func_78382_b();
         tessellator.func_78369_a(red, color, color, 1.0F);
         tessellator.func_78377_a(0.0F - o, 0.0F - o, 0.0);
         tessellator.func_78377_a(0.0F + o, 0.0F - o, 0.0);
         tessellator.func_78377_a(0.0F + o, 0.0F - o, 0 + distance);
         tessellator.func_78377_a(0.0F - o, 0.0F - o, 0 + distance);
         tessellator.func_78381_a();
         tessellator.func_78382_b();
         tessellator.func_78369_a(red, color, color, 1.0F);
         tessellator.func_78377_a(0.0F - o, 0.0F + o, 0.0);
         tessellator.func_78377_a(0.0F - o, 0.0F - o, 0.0);
         tessellator.func_78377_a(0.0F - o, 0.0F - o, 0 + distance);
         tessellator.func_78377_a(0.0F - o, 0.0F + o, 0 + distance);
         tessellator.func_78381_a();
         tessellator.func_78382_b();
         tessellator.func_78369_a(red, color, color, 1.0F);
         tessellator.func_78377_a(0.0F + o, 0.0F + o, 0.0);
         tessellator.func_78377_a(0.0F - o, 0.0F + o, 0.0);
         tessellator.func_78377_a(0.0F - o, 0.0F + o, 0 + distance);
         tessellator.func_78377_a(0.0F + o, 0.0F + o, 0 + distance);
         tessellator.func_78381_a();
      }

      GL11.glDisable(3042);
      GL11.glEnable(3553);
      GL11.glPopMatrix();
   }

   public void func_76986_a(Entity entityLaserBurst, double x, double y, double z, float yaw, float pitch) {
      this.renderLaserBurst((EntityLaserBurst)entityLaserBurst, x, y, z, yaw, pitch);
   }

   protected ResourceLocation func_110775_a(Entity entity) {
      return null;
   }
}
