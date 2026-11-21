package assets.rivalrebels.client.model;

import assets.rivalrebels.client.renderhelper.RenderHelper;
import assets.rivalrebels.client.renderhelper.TextureVertice;
import assets.rivalrebels.client.renderhelper.Vertice;
import org.lwjgl.opengl.GL11;

public class ModelNukeCloud {
   private float[] topx = new float[]{0.7F, 1.2F, 1.2F, 1.2F, 1.75F, 2.5F, 3.0F, 3.5F, 3.5F, 3.0F, 2.25F, 2.0F, 1.75F, 1.25F, 0.0F};
   private float[] topy = new float[]{6.5F, 5.0F, 6.0F, 7.0F, 7.1F, 7.25F, 7.5F, 8.25F, 9.0F, 9.25F, 9.4F, 9.75F, 10.1F, 10.25F, 10.25F};
   private float[] bottomx = new float[]{1.22F, 1.12F, 1.03F, 0.95F, 0.88F, 0.82F, 0.77F, 0.73F, 0.71F, 0.7F, 0.7F};
   private float[] bottomy = new float[]{-4.0F, -3.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, 3.25F, 4.5F, 5.5F, 6.5F};
   private int segments = 18;
   private float deg = (float) (Math.PI * 2) / this.segments;
   private float sin = (float)Math.sin(this.deg);
   private float cos = (float)Math.cos(this.deg);
   private float add = (float)(360 / this.segments);

   public void renderTop() {
      for (float i = 0.0F; i < this.segments; i++) {
         GL11.glPushMatrix();
         GL11.glRotatef(this.add * i, 0.0F, 1.0F, 0.0F);

         for (int f = 1; f < this.topx.length; f++) {
            TextureVertice t1 = new TextureVertice(1.0F / this.segments * (i - 1.0F), 1.0F / this.topx.length * f);
            TextureVertice t2 = new TextureVertice(1.0F / this.segments * (i - 1.0F), 1.0F / this.topx.length * (f - 1));
            TextureVertice t3 = new TextureVertice(1.0F / this.segments * i, 1.0F / this.topx.length * (f - 1));
            TextureVertice t4 = new TextureVertice(1.0F / this.segments * i, 1.0F / this.topx.length * f);
            RenderHelper.addFace(
               new Vertice(0.0F, this.topy[f], this.topx[f]),
               new Vertice(0.0F, this.topy[f - 1], this.topx[f - 1]),
               new Vertice(this.topx[f - 1] * this.sin, this.topy[f - 1], this.topx[f - 1] * this.cos),
               new Vertice(this.topx[f] * this.sin, this.topy[f], this.topx[f] * this.cos),
               t1,
               t2,
               t3,
               t4
            );
         }

         GL11.glPopMatrix();
      }
   }

   public void renderBottom() {
      for (float i = 0.0F; i < this.segments; i++) {
         GL11.glPushMatrix();
         GL11.glRotatef(this.add * i, 0.0F, 1.0F, 0.0F);

         for (int f = 1; f < this.bottomx.length; f++) {
            TextureVertice t1 = new TextureVertice(1.0F / this.segments * (i - 1.0F), 1.0F / this.bottomx.length * f);
            TextureVertice t2 = new TextureVertice(1.0F / this.segments * (i - 1.0F), 1.0F / this.bottomx.length * (f - 1));
            TextureVertice t3 = new TextureVertice(1.0F / this.segments * i, 1.0F / this.bottomx.length * (f - 1));
            TextureVertice t4 = new TextureVertice(1.0F / this.segments * i, 1.0F / this.bottomx.length * f);
            RenderHelper.addFace(
               new Vertice(0.0F, this.bottomy[f], this.bottomx[f]),
               new Vertice(0.0F, this.bottomy[f - 1], this.bottomx[f - 1]),
               new Vertice(this.bottomx[f - 1] * this.sin, this.bottomy[f - 1], this.bottomx[f - 1] * this.cos),
               new Vertice(this.bottomx[f] * this.sin, this.bottomy[f], this.bottomx[f] * this.cos),
               t1,
               t2,
               t3,
               t4
            );
         }

         GL11.glPopMatrix();
      }
   }
}
