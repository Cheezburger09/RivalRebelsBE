package assets.rivalrebels.client.model;

import assets.rivalrebels.client.renderhelper.RenderHelper;
import assets.rivalrebels.client.renderhelper.Vertice;
import net.minecraft.client.model.ModelBase;
import org.lwjgl.opengl.GL11;

public class ModelBlastRing extends ModelBase {
   public void renderModel(float size, int segments, float thickness, float height, float pitch, float yaw, float roll, float x, float y, float z) {
      GL11.glPushMatrix();
      float innerangle = (float) (Math.PI * 2) / segments;
      Vertice v1 = new Vertice(0.0F, -height, size - thickness);
      Vertice v2 = new Vertice(0.0F, -height, size + thickness);
      Vertice v3 = new Vertice((float)Math.sin(innerangle) * (size - thickness), -height, (float)Math.cos(innerangle) * (size - thickness));
      Vertice v4 = new Vertice((float)Math.sin(innerangle) * (size + thickness), -height, (float)Math.cos(innerangle) * (size + thickness));
      Vertice v5 = new Vertice(0.0F, height, size - thickness);
      Vertice v6 = new Vertice(0.0F, height, size + thickness);
      Vertice v7 = new Vertice((float)Math.sin(innerangle) * (size - thickness), height, (float)Math.cos(innerangle) * (size - thickness));
      Vertice v8 = new Vertice((float)Math.sin(innerangle) * (size + thickness), height, (float)Math.cos(innerangle) * (size + thickness));
      GL11.glTranslatef(x, y, z);
      GL11.glRotatef(pitch, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(yaw, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(roll, 0.0F, 0.0F, 1.0F);

      for (float i = 0.0F; i < 360.0F; i += 360 / segments) {
         GL11.glPushMatrix();
         GL11.glRotatef(i, 0.0F, 1.0F, 0.0F);
         GL11.glDisable(3553);
         RenderHelper.addFace(v5, v6, v8, v7);
         RenderHelper.addFace(v2, v1, v3, v4);
         RenderHelper.addFace(v2, v4, v8, v6);
         RenderHelper.addFace(v3, v1, v5, v7);
         GL11.glEnable(3553);
         GL11.glPopMatrix();
      }

      GL11.glPopMatrix();
   }
}
