package assets.rivalrebels.client.model;

import assets.rivalrebels.client.renderhelper.RenderHelper;
import assets.rivalrebels.client.renderhelper.TextureVertice;
import assets.rivalrebels.client.renderhelper.Vertice;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ModelNukeCrate {
   float s = 0.5F;
   Vertice v1 = new Vertice(this.s, this.s, this.s);
   Vertice v2 = new Vertice(this.s, this.s, -this.s);
   Vertice v3 = new Vertice(-this.s, this.s, -this.s);
   Vertice v4 = new Vertice(-this.s, this.s, this.s);
   Vertice v5 = new Vertice(this.s, -this.s, this.s);
   Vertice v6 = new Vertice(this.s, -this.s, -this.s);
   Vertice v7 = new Vertice(-this.s, -this.s, -this.s);
   Vertice v8 = new Vertice(-this.s, -this.s, this.s);
   TextureVertice t1 = new TextureVertice(0.0F, 0.0F);
   TextureVertice t2 = new TextureVertice(1.0F, 0.0F);
   TextureVertice t3 = new TextureVertice(1.0F, 1.0F);
   TextureVertice t4 = new TextureVertice(0.0F, 1.0F);

   public void renderModelA() {
      GL11.glPushMatrix();
      GL11.glDisable(2896);
      RenderHelper.addFace(this.v4, this.v8, this.v5, this.v1, this.t1, this.t2, this.t3, this.t4);
      RenderHelper.addFace(this.v3, this.v7, this.v8, this.v4, this.t1, this.t2, this.t3, this.t4);
      RenderHelper.addFace(this.v2, this.v6, this.v7, this.v3, this.t1, this.t2, this.t3, this.t4);
      RenderHelper.addFace(this.v1, this.v5, this.v6, this.v2, this.t1, this.t2, this.t3, this.t4);
      GL11.glPopMatrix();
   }

   public void renderModelB() {
      GL11.glPushMatrix();
      GL11.glDisable(2896);
      RenderHelper.addFace(this.v1, this.v2, this.v3, this.v4, this.t1, this.t2, this.t3, this.t4);
      RenderHelper.addFace(this.v8, this.v7, this.v6, this.v5, this.t1, this.t2, this.t3, this.t4);
      GL11.glPopMatrix();
   }
}
