package assets.rivalrebels.client.renderentity;

import assets.rivalrebels.client.model.ModelBlastSphere;
import assets.rivalrebels.common.entity.EntitySphereBlast;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderSphereBlast extends Render {
   private ModelBlastSphere modelsphere = new ModelBlastSphere();

   public void func_76986_a(Entity var1, double x, double y, double z, float var8, float var9) {
      EntitySphereBlast tsar = (EntitySphereBlast)var1;
      tsar.time++;
      GL11.glPushMatrix();
      GL11.glDisable(2896);
      double elev = (MathHelper.func_76126_a(tsar.time / 40.0F) + 1.5F) * 10.0F;
      GL11.glTranslated(x, y + elev, z);
      GL11.glPushMatrix();
      GL11.glRotatef((float)(elev * 2.0), 0.0F, 1.0F, 0.0F);
      GL11.glRotatef((float)(elev * 3.0), 1.0F, 0.0F, 0.0F);
      this.modelsphere.renderModel((float)elev, 1.0F, 0.25F, 0.0F, 1.0F);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glRotatef((float)(elev * -2.0), 0.0F, 1.0F, 0.0F);
      GL11.glRotatef((float)(elev * 4.0), 0.0F, 0.0F, 1.0F);
      this.modelsphere.renderModel((float)(elev - 0.2F), 1.0F, 0.5F, 0.0F, 1.0F);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glRotatef((float)(elev * -3.0), 1.0F, 0.0F, 0.0F);
      GL11.glRotatef((float)(elev * 2.0), 0.0F, 0.0F, 1.0F);
      this.modelsphere.renderModel((float)(elev - 0.4F), 1.0F, 0.0F, 0.0F, 1.0F);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glRotatef((float)(elev * -1.0), 0.0F, 1.0F, 0.0F);
      GL11.glRotatef((float)(elev * 3.0), 0.0F, 0.0F, 1.0F);
      this.modelsphere.renderModel((float)(elev - 0.6F), 1.0F, 1.0F, 0.0F, 1.0F);
      GL11.glPopMatrix();
      GL11.glPopMatrix();
   }

   protected ResourceLocation func_110775_a(Entity entity) {
      return null;
   }
}
