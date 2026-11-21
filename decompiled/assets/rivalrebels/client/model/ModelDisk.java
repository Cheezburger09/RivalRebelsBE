package assets.rivalrebels.client.model;

import assets.rivalrebels.client.renderhelper.RenderHelper;
import assets.rivalrebels.client.renderhelper.TextureVertice;
import assets.rivalrebels.client.renderhelper.Vertice;
import org.lwjgl.opengl.GL11;

public class ModelDisk {
   TextureVertice t1 = new TextureVertice(0.0F, 0.0F);
   TextureVertice t2 = new TextureVertice(0.34375F, 0.0F);
   TextureVertice t3 = new TextureVertice(0.53125F, 0.0F);
   TextureVertice t4 = new TextureVertice(0.0F, 0.1875F);
   TextureVertice t5 = new TextureVertice(0.34375F, 0.1875F);
   TextureVertice t6 = new TextureVertice(0.0F, 0.21875F);
   TextureVertice t7 = new TextureVertice(0.34375F, 0.21875F);
   TextureVertice t8 = new TextureVertice(0.53125F, 0.21875F);
   TextureVertice t9 = new TextureVertice(0.0F, 0.25F);
   TextureVertice t10 = new TextureVertice(0.34375F, 0.25F);
   Vertice v1 = new Vertice(0.45F, -0.03125F, 0.0F);
   Vertice v2 = new Vertice(0.45F, 0.03125F, 0.0F);
   Vertice v3 = new Vertice(0.65F, 0.0625F, 0.0F);
   Vertice v4 = new Vertice(1.0F, 0.0F, 0.0F);
   Vertice v5 = new Vertice(0.65F, -0.0625F, 0.0F);
   private int numOfSegs = 32;
   private float deg = (float) (Math.PI * 2) / this.numOfSegs;
   private float cosdeg = (float)Math.cos(this.deg);
   private float sindeg = (float)Math.sin(this.deg);
   Vertice v6 = new Vertice(0.45F * this.cosdeg, -0.03125F, 0.45F * this.sindeg);
   Vertice v7 = new Vertice(0.45F * this.cosdeg, 0.03125F, 0.45F * this.sindeg);
   Vertice v8 = new Vertice(0.65F * this.cosdeg, 0.0625F, 0.65F * this.sindeg);
   Vertice v9 = new Vertice(1.0F * this.cosdeg, 0.0F, 1.0F * this.sindeg);
   Vertice v10 = new Vertice(0.65F * this.cosdeg, -0.0625F, 0.65F * this.sindeg);

   public void render() {
      float i = 0.0F;

      while (i < 360.0F) {
         GL11.glPushMatrix();
         GL11.glRotatef(i, 0.0F, 1.0F, 0.0F);
         RenderHelper.addFace(this.v2, this.v1, this.v6, this.v7, this.t4, this.t9, this.t10, this.t5);
         if (i != 0.0F && i != 16.0F) {
            RenderHelper.addFace(this.v3, this.v2, this.v7, this.v8, this.t6, this.t1, this.t2, this.t7);
            RenderHelper.addFace(this.v4, this.v3, this.v8, this.v9, this.t6, this.t1, this.t2, this.t7);
            RenderHelper.addFace(this.v5, this.v4, this.v9, this.v10, this.t1, this.t6, this.t7, this.t2);
            RenderHelper.addFace(this.v1, this.v5, this.v10, this.v6, this.t1, this.t6, this.t7, this.t2);
         } else {
            RenderHelper.addFace(this.v3, this.v2, this.v7, this.v8, this.t2, this.t7, this.t8, this.t3);
            RenderHelper.addFace(this.v4, this.v3, this.v8, this.v9, this.t2, this.t7, this.t8, this.t3);
            RenderHelper.addFace(this.v5, this.v4, this.v9, this.v10, this.t2, this.t7, this.t8, this.t3);
            RenderHelper.addFace(this.v1, this.v5, this.v10, this.v6, this.t2, this.t7, this.t8, this.t3);
         }

         GL11.glPopMatrix();
         i += 360 / this.numOfSegs;
      }
   }
}
