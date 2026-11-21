package assets.rivalrebels.client.renderentity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.model.ModelAntimatterBombBlast;
import assets.rivalrebels.client.model.ModelBlastRing;
import assets.rivalrebels.client.model.ModelBlastSphere;
import assets.rivalrebels.common.entity.EntityAntimatterBombBlast;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderAntimatterBombBlast extends Render {
   private ModelBlastSphere modelsphere = new ModelBlastSphere();
   private ModelBlastRing modelring;
   private ModelAntimatterBombBlast modelabomb = new ModelAntimatterBombBlast();

   public RenderAntimatterBombBlast() {
      this.modelring = new ModelBlastRing();
   }

   public void func_76986_a(Entity var1, double x, double y, double z, float var8, float var9) {
      EntityAntimatterBombBlast tsar = (EntityAntimatterBombBlast)var1;
      tsar.time++;
      double radius = (tsar.field_70159_w * 10.0 - 1.0) * (tsar.field_70159_w * 10.0 - 1.0) * 2.0 + RivalRebels.tsarBombaStrength;
      GL11.glPushMatrix();
      GL11.glDisable(2896);
      GL11.glPushMatrix();
      GL11.glScalef(RivalRebels.shroomScale, RivalRebels.shroomScale, RivalRebels.shroomScale);
      GL11.glColor3f(0.0F, 0.0F, 0.2F);
      float size = tsar.time % 100 * 2.0F;
      this.modelring.renderModel(size, 64, 6.0F, 2.0F, 0.0F, 0.0F, 0.0F, (float)x, (float)y, (float)z);
      GL11.glPopMatrix();
      if (tsar.time < 60) {
         double elev = tsar.time / 5.0F;
         GL11.glTranslated(x, y + elev, z);
         this.modelsphere.renderModel(tsar.time, 1.0F, 1.0F, 1.0F, 1.0F);
      } else {
         GL11.glTranslated(x, y, z);
         GL11.glScaled(radius * 0.06F, radius * 0.06F, radius * 0.06F);
         GL11.glColor3f(1.0F, 1.0F, 1.0F);
         Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etantimatterblast);
         this.modelabomb.render();
      }

      GL11.glPopMatrix();
      if (RivalRebels.antimatterFlash) {
         int ran = (int)(Math.random() * 10.0 - 5.0);

         for (int i = 0; i < ran; i++) {
            GL11.glPopMatrix();
         }

         for (int i = -5; i < 0; i++) {
            GL11.glPushMatrix();
         }

         GL11.glBlendFunc(1, 1);
         GL11.glScaled(Math.random(), Math.random(), Math.random());
         GL11.glRotated(Math.random() * 360.0, Math.random(), Math.random(), Math.random());
         GL11.glTranslated(Math.random() * 10.0 - 5.0, Math.random() * 10.0 - 5.0, Math.random() * 10.0 - 5.0);
         this.modelsphere.renderModel(tsar.time, (float)Math.random(), (float)Math.random(), (float)Math.random(), 1.0F);
      }
   }

   protected ResourceLocation func_110775_a(Entity entity) {
      return null;
   }
}
