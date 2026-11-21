package assets.rivalrebels.client.model;

import assets.rivalrebels.client.renderhelper.RenderHelper;
import assets.rivalrebels.client.renderhelper.TextureVertice;
import assets.rivalrebels.client.renderhelper.Vertice;
import org.lwjgl.opengl.GL11;

public class ModelRod {
   public boolean rendersecondcap = true;
   int numOfSegs = 16;
   float deg = (float) (Math.PI * 2) / this.numOfSegs;
   TextureVertice t1 = new TextureVertice(0.0625F, 0.0F);
   TextureVertice t2 = new TextureVertice(0.03125F, 0.09375F);
   TextureVertice t3 = new TextureVertice(0.09375F, 0.09375F);
   TextureVertice t4 = new TextureVertice(0.0F, 0.1875F);
   TextureVertice t5 = new TextureVertice(0.125F, 0.1875F);
   TextureVertice t6 = new TextureVertice(0.03125F, 0.21875F);
   TextureVertice t7 = new TextureVertice(0.09375F, 0.21875F);
   TextureVertice t8 = new TextureVertice(0.03125F, 0.59375F);
   TextureVertice t9 = new TextureVertice(0.09375F, 0.59375F);
   Vertice v0 = new Vertice(0.0F, 0.3125F, 0.0F);
   Vertice v1 = new Vertice(0.25F, 0.28125F, 0.0F);
   Vertice v2 = new Vertice(0.28125F, 0.1875F, 0.0F);
   Vertice v3 = new Vertice(0.25F, 0.15625F, 0.0F);
   Vertice v4 = new Vertice(0.25F, -0.15625F, 0.0F);
   Vertice v5 = new Vertice(0.28125F, -0.1875F, 0.0F);
   Vertice v6 = new Vertice(0.25F, -0.28125F, 0.0F);
   Vertice v7 = new Vertice(0.0F, -0.3125F, 0.0F);
   Vertice vd1 = new Vertice(0.25F * (float)Math.cos(this.deg), 0.28125F, 0.25F * (float)Math.sin(this.deg));
   Vertice vd2 = new Vertice(0.28125F * (float)Math.cos(this.deg), 0.1875F, 0.28125F * (float)Math.sin(this.deg));
   Vertice vd3 = new Vertice(0.25F * (float)Math.cos(this.deg), 0.15625F, 0.25F * (float)Math.sin(this.deg));
   Vertice vd4 = new Vertice(0.25F * (float)Math.cos(this.deg), -0.15625F, 0.25F * (float)Math.sin(this.deg));
   Vertice vd5 = new Vertice(0.28125F * (float)Math.cos(this.deg), -0.1875F, 0.28125F * (float)Math.sin(this.deg));
   Vertice vd6 = new Vertice(0.25F * (float)Math.cos(this.deg), -0.28125F, 0.25F * (float)Math.sin(this.deg));

   public void render() {
      float i = 0.0F;

      while (i < 360.0F) {
         GL11.glPushMatrix();
         GL11.glDisable(2896);
         GL11.glRotatef(i, 0.0F, 1.0F, 0.0F);
         RenderHelper.addFace(this.v0, this.vd1, this.v1, this.v0, this.t1, this.t3, this.t2, this.t1);
         RenderHelper.addFace(this.vd1, this.vd2, this.v2, this.v1, this.t2, this.t4, this.t5, this.t3);
         RenderHelper.addFace(this.vd2, this.vd3, this.v3, this.v2, this.t4, this.t6, this.t7, this.t5);
         RenderHelper.addFace(this.vd3, this.vd4, this.v4, this.v3, this.t6, this.t8, this.t9, this.t7);
         if (this.rendersecondcap) {
            RenderHelper.addFace(this.v7, this.v6, this.vd6, this.v7, this.t1, this.t3, this.t2, this.t1);
            RenderHelper.addFace(this.v6, this.v5, this.vd5, this.vd6, this.t2, this.t4, this.t5, this.t3);
            RenderHelper.addFace(this.v5, this.v4, this.vd4, this.vd5, this.t4, this.t6, this.t7, this.t5);
         }

         GL11.glPopMatrix();
         i += 360 / this.numOfSegs;
      }
   }
}
