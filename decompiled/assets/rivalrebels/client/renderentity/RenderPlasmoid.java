package assets.rivalrebels.client.renderentity;

import assets.rivalrebels.client.model.ModelBlastSphere;
import assets.rivalrebels.common.entity.EntityPlasmoid;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderPlasmoid extends Render {
   ModelBlastSphere model = new ModelBlastSphere();

   public void func_76986_a(Entity var1, double var2, double var4, double var6, float var8, float var9) {
      this.renderPlasmoid((EntityPlasmoid)var1, var2, var4, var6, var8, var9);
   }

   public void renderPlasmoid(EntityPlasmoid e, double x, double y, double z, float var8, float var9) {
      GL11.glPushMatrix();
      GL11.glTranslated(x, y, z);
      GL11.glRotatef(e.field_70177_z - 90.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(e.field_70125_A - 90.0F, 0.0F, 0.0F, 1.0F);
      GL11.glScalef(0.4F, 2.5F, 0.4F);
      GL11.glPushMatrix();
      GL11.glRotatef(e.rotation, 0.0F, 1.0F, 0.0F);
      this.model.renderModel(0.4F, 0.65F, 0.55F, 0.95F, 0.9F);
      GL11.glPushMatrix();
      GL11.glRotatef(e.rotation, 0.0F, 1.0F, 0.0F);
      this.model.renderModel(0.6F, 0.65F, 0.55F, 0.95F, 0.9F);
      GL11.glPushMatrix();
      GL11.glRotatef(e.rotation, 0.0F, 1.0F, 0.0F);
      this.model.renderModel(0.8F, 0.65F, 0.55F, 0.95F, 0.9F);
      GL11.glPushMatrix();
      GL11.glRotatef(e.rotation, 0.0F, 1.0F, 0.0F);
      this.model.renderModel(1.0F, 0.65F, 0.55F, 0.95F, 0.9F);
      GL11.glPushMatrix();
      GL11.glRotatef(e.rotation, 0.0F, 1.0F, 0.0F);
      this.model.renderModel(1.2F, 0.65F, 0.55F, 0.95F, 0.9F);
      GL11.glPopMatrix();
      GL11.glPopMatrix();
      GL11.glPopMatrix();
      GL11.glPopMatrix();
      GL11.glPopMatrix();
      GL11.glPopMatrix();
   }

   protected ResourceLocation func_110775_a(Entity entity) {
      return null;
   }
}
