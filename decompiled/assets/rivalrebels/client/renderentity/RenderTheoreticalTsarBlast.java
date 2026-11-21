package assets.rivalrebels.client.renderentity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.model.ModelBlastSphere;
import assets.rivalrebels.client.model.ModelTsarBlast;
import assets.rivalrebels.common.entity.EntityTsarBlast;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderTheoreticalTsarBlast extends Render {
   private ModelTsarBlast model = new ModelTsarBlast();
   private ModelBlastSphere modelsphere = new ModelBlastSphere();

   public void func_76986_a(Entity var1, double x, double y, double z, float var8, float var9) {
      EntityTsarBlast tsar = (EntityTsarBlast)var1;
      tsar.time++;
      double radius = (tsar.field_70159_w * 10.0 - 1.0) * (tsar.field_70159_w * 10.0 - 1.0) * 2.0 + RivalRebels.tsarBombaStrength;
      GL11.glPushMatrix();
      GL11.glDisable(2896);
      if (tsar.time < 60) {
         double elev = tsar.time / 5.0F;
         GL11.glTranslated(x, y + elev, z);
         this.modelsphere.renderModel(tsar.time * RivalRebels.shroomScale, 1.0F, 1.0F, 1.0F, 1.0F);
      } else if (tsar.time < 300 && radius - RivalRebels.tsarBombaStrength > 9.0) {
         double elev = (tsar.time - 60.0F) / 4.0F;
         GL11.glTranslated(x, y + elev, z);
         GL11.glScalef(RivalRebels.shroomScale, RivalRebels.shroomScale, RivalRebels.shroomScale);
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
      } else {
         Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etblacktsar);
         GL11.glTranslated(x, y + 10.0 + (tsar.field_70159_w - 0.1) * 14.14213562, z);
         GL11.glScalef(RivalRebels.shroomScale, RivalRebels.shroomScale, RivalRebels.shroomScale);
         GL11.glScalef((float)(radius * 0.116F), (float)(radius * 0.065F), (float)(radius * 0.116F));
         GL11.glScalef(0.8F, 0.8F, 0.8F);
         this.model.render();
      }

      GL11.glPopMatrix();
   }

   protected ResourceLocation func_110775_a(Entity entity) {
      return null;
   }
}
