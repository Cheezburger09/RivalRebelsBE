package assets.rivalrebels.client.renderentity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.model.ModelBlastSphere;
import assets.rivalrebels.client.model.ModelTsarBlast;
import assets.rivalrebels.common.entity.EntityTachyonBombBlast;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderTachyonBombBlast extends Render {
   private ModelTsarBlast model = new ModelTsarBlast();
   private ModelBlastSphere modelsphere = new ModelBlastSphere();

   public void func_76986_a(Entity var1, double x, double y, double z, float var8, float var9) {
      EntityTachyonBombBlast tsar = (EntityTachyonBombBlast)var1;
      tsar.time++;
      double radius = (tsar.field_70159_w * 10.0 - 1.0) * (tsar.field_70159_w * 10.0 - 1.0) * 2.0 + RivalRebels.tsarBombaStrength;
      GL11.glPushMatrix();
      GL11.glDisable(2896);
      if (tsar.time < 60) {
         double elev = tsar.time / 5.0F;
         GL11.glTranslated(x, y + elev, z);
         this.modelsphere.renderModel(tsar.time * RivalRebels.shroomScale, 1.0F, 1.0F, 1.0F, 1.0F);
      } else if (tsar.time < 600 && radius - RivalRebels.tsarBombaStrength > 9.0) {
         double elev = (tsar.time - 60.0F) / 32.0F + 10.0F;
         GL11.glPushMatrix();
         GL11.glTranslated(x, y, z);
         GL11.glScalef(RivalRebels.shroomScale * 2.0F, RivalRebels.shroomScale, RivalRebels.shroomScale * 2.0F);
         GL11.glRotatef((float)(elev * 2.0), 0.0F, 1.0F, 0.0F);
         GL11.glRotatef((float)(elev * 3.0), 1.0F, 0.0F, 0.0F);
         this.modelsphere.renderModel((float)elev, 1.0F, 0.25F, 0.0F, 1.0F);
         GL11.glPopMatrix();
         GL11.glPushMatrix();
         GL11.glTranslated(x, y, z);
         GL11.glScalef(RivalRebels.shroomScale * 2.0F, RivalRebels.shroomScale, RivalRebels.shroomScale * 2.0F);
         GL11.glRotatef((float)(elev * -2.0), 0.0F, 1.0F, 0.0F);
         GL11.glRotatef((float)(elev * 4.0), 0.0F, 0.0F, 1.0F);
         this.modelsphere.renderModel((float)(elev - 0.2F), 1.0F, 0.5F, 0.0F, 1.0F);
         GL11.glPopMatrix();
         GL11.glPushMatrix();
         GL11.glTranslated(x, y + elev * 4.0, z);
         GL11.glScalef(RivalRebels.shroomScale, RivalRebels.shroomScale * 3.0F, RivalRebels.shroomScale);
         GL11.glRotatef((float)(elev * -3.0), 1.0F, 0.0F, 0.0F);
         GL11.glRotatef((float)(elev * 2.0), 0.0F, 0.0F, 1.0F);
         this.modelsphere.renderModel((float)(elev - 0.4F), 1.0F, 0.0F, 0.0F, 1.0F);
         GL11.glPopMatrix();
         GL11.glPushMatrix();
         GL11.glTranslated(x, y + elev * 4.0, z);
         GL11.glScalef(RivalRebels.shroomScale, RivalRebels.shroomScale * 3.0F, RivalRebels.shroomScale);
         GL11.glRotatef((float)(elev * -1.0), 0.0F, 1.0F, 0.0F);
         GL11.glRotatef((float)(elev * 3.0), 0.0F, 0.0F, 1.0F);
         this.modelsphere.renderModel((float)(elev - 0.6F), 1.0F, 1.0F, 0.0F, 1.0F);
         GL11.glPopMatrix();
      } else {
         float elev = (tsar.time - (radius - RivalRebels.tsarBombaStrength > 9.0 ? 600.0F : 0.0F)) / 8.0F;
         RenderNuclearBlast.model.renderModel(RivalRebels.shroomScale * elev * 1.0F, 32, 2.0F, 0.5F, 0.0F, 0.0F, 0.0F, (float)x, (float)(y + 2.0), (float)z);
         RenderNuclearBlast.model.renderModel(RivalRebels.shroomScale * elev * 1.1F, 32, 2.0F, 0.5F, 0.0F, 0.0F, 0.0F, (float)x, (float)(y + 6.0), (float)z);
         RenderNuclearBlast.model.renderModel(RivalRebels.shroomScale * elev * 1.2F, 32, 2.0F, 0.5F, 0.0F, 0.0F, 0.0F, (float)x, (float)(y + 10.0), (float)z);
         RenderNuclearBlast.model.renderModel(RivalRebels.shroomScale * elev * 1.3F, 32, 2.0F, 0.5F, 0.0F, 0.0F, 0.0F, (float)x, (float)(y + 14.0), (float)z);
         RenderNuclearBlast.model.renderModel(RivalRebels.shroomScale * elev * 1.4F, 32, 2.0F, 0.5F, 0.0F, 0.0F, 0.0F, (float)x, (float)(y + 18.0), (float)z);
         RenderNuclearBlast.model.renderModel(RivalRebels.shroomScale * elev * 1.5F, 32, 2.0F, 0.5F, 0.0F, 0.0F, 0.0F, (float)x, (float)(y + 22.0), (float)z);
         RenderNuclearBlast.model.renderModel(RivalRebels.shroomScale * elev * 1.6F, 32, 2.0F, 0.5F, 0.0F, 0.0F, 0.0F, (float)x, (float)(y + 26.0), (float)z);
         RenderNuclearBlast.model.renderModel(RivalRebels.shroomScale * elev * 1.7F, 32, 2.0F, 0.5F, 0.0F, 0.0F, 0.0F, (float)x, (float)(y + 30.0), (float)z);
         Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.ettsarflame);
         GL11.glTranslated(x, y + 10.0 + (tsar.field_70159_w - 0.1) * 14.14213562, z);
         GL11.glScalef(RivalRebels.shroomScale, RivalRebels.shroomScale, RivalRebels.shroomScale);
         float horizontal = elev * 0.025F + 1.0F;
         GL11.glScalef((float)(horizontal * radius * 0.116F), (float)(radius * 0.065F), (float)(horizontal * radius * 0.116F));
         GL11.glScalef(0.8F, 0.8F, 0.8F);
         GL11.glEnable(3042);
         GL11.glBlendFunc(1, 1);
         this.model.render();
         GL11.glDisable(3042);
      }

      GL11.glPopMatrix();
   }

   protected ResourceLocation func_110775_a(Entity entity) {
      return null;
   }
}
