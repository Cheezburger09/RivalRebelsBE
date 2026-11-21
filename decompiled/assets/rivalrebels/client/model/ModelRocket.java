package assets.rivalrebels.client.model;

import assets.rivalrebels.client.renderhelper.RenderHelper;
import assets.rivalrebels.client.renderhelper.Vertice;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ModelRocket {
   Vertice vy1 = new Vertice(0.0F, 0.0F, 0.0F);
   Vertice vy2 = new Vertice(0.0F, 2.5F, 0.0F);
   Vertice vpx1 = new Vertice(0.5F, 0.0F, 0.0F);
   Vertice vnx1 = new Vertice(-0.5F, 0.0F, 0.0F);
   Vertice vpz1 = new Vertice(0.0F, 0.0F, 0.5F);
   Vertice vnz1 = new Vertice(0.0F, 0.0F, -0.5F);
   Vertice vpxpz1 = new Vertice(0.3535533F, 0.0F, 0.3535533F);
   Vertice vpxnz1 = new Vertice(0.3535533F, 0.0F, -0.3535533F);
   Vertice vnxpz1 = new Vertice(-0.3535533F, 0.0F, 0.3535533F);
   Vertice vnxnz1 = new Vertice(-0.3535533F, 0.0F, -0.3535533F);
   Vertice vpx2 = new Vertice(0.5F, 2.0F, 0.0F);
   Vertice vnx2 = new Vertice(-0.5F, 2.0F, 0.0F);
   Vertice vpz2 = new Vertice(0.0F, 2.0F, 0.5F);
   Vertice vnz2 = new Vertice(0.0F, 2.0F, -0.5F);
   Vertice vpxpz2 = new Vertice(0.3535533F, 2.0F, 0.3535533F);
   Vertice vpxnz2 = new Vertice(0.3535533F, 2.0F, -0.3535533F);
   Vertice vnxpz2 = new Vertice(-0.3535533F, 2.0F, 0.3535533F);
   Vertice vnxnz2 = new Vertice(-0.3535533F, 2.0F, -0.3535533F);
   Vertice vpx3 = new Vertice(1.0F, -0.2F, 0.0F);
   Vertice vnx3 = new Vertice(-1.0F, -0.2F, 0.0F);
   Vertice vpz3 = new Vertice(0.0F, -0.2F, 1.0F);
   Vertice vnz3 = new Vertice(0.0F, -0.2F, -1.0F);
   Vertice vpx4 = new Vertice(1.0F, 1.0F, 0.0F);
   Vertice vnx4 = new Vertice(-1.0F, 1.0F, 0.0F);
   Vertice vpz4 = new Vertice(0.0F, 1.0F, 1.0F);
   Vertice vnz4 = new Vertice(0.0F, 1.0F, -1.0F);
   float tx1 = 0.0F;
   float tx2 = 0.28125F;
   float tx3 = 0.375F;
   float tx4 = 0.5625F;
   float tx5 = 0.65625F;
   float ty1 = 0.0F;
   float ty2 = 0.09375F;
   float ty3 = 0.1875F;

   public void render(boolean fins) {
      GL11.glPushMatrix();
      GL11.glScalef(0.125F, 0.25F, 0.125F);
      RenderHelper.addFace(this.vpx1, this.vpx2, this.vpxpz2, this.vpxpz1, this.tx1, this.tx2, this.ty1, this.ty2);
      RenderHelper.addFace(this.vpxpz1, this.vpxpz2, this.vpz2, this.vpz1, this.tx1, this.tx2, this.ty1, this.ty2);
      RenderHelper.addFace(this.vpz1, this.vpz2, this.vnxpz2, this.vnxpz1, this.tx1, this.tx2, this.ty1, this.ty2);
      RenderHelper.addFace(this.vnxpz1, this.vnxpz2, this.vnx2, this.vnx1, this.tx1, this.tx2, this.ty1, this.ty2);
      RenderHelper.addFace(this.vnx1, this.vnx2, this.vnxnz2, this.vnxnz1, this.tx1, this.tx2, this.ty1, this.ty2);
      RenderHelper.addFace(this.vnxnz1, this.vnxnz2, this.vnz2, this.vnz1, this.tx1, this.tx2, this.ty1, this.ty2);
      RenderHelper.addFace(this.vnz1, this.vnz2, this.vpxnz2, this.vpxnz1, this.tx1, this.tx2, this.ty1, this.ty2);
      RenderHelper.addFace(this.vpxnz1, this.vpxnz2, this.vpx2, this.vpx1, this.tx1, this.tx2, this.ty1, this.ty2);
      RenderHelper.addFace(this.vpxpz2, this.vpx2, this.vy2, this.vpz2, this.tx2, this.tx3, this.ty1, this.ty2);
      RenderHelper.addFace(this.vnxpz2, this.vpz2, this.vy2, this.vnx2, this.tx2, this.tx3, this.ty1, this.ty2);
      RenderHelper.addFace(this.vnxnz2, this.vnx2, this.vy2, this.vnz2, this.tx2, this.tx3, this.ty1, this.ty2);
      RenderHelper.addFace(this.vpxnz2, this.vnz2, this.vy2, this.vpx2, this.tx2, this.tx3, this.ty1, this.ty2);
      RenderHelper.addFace(this.vpx1, this.vpxpz1, this.vpz1, this.vy1, this.tx4, this.tx5, this.ty1, this.ty2);
      RenderHelper.addFace(this.vpz1, this.vnxpz1, this.vnx1, this.vy1, this.tx4, this.tx5, this.ty1, this.ty2);
      RenderHelper.addFace(this.vnx1, this.vnxnz1, this.vnz1, this.vy1, this.tx4, this.tx5, this.ty1, this.ty2);
      RenderHelper.addFace(this.vnz1, this.vpxnz1, this.vpx1, this.vy1, this.tx4, this.tx5, this.ty1, this.ty2);
      if (fins) {
         RenderHelper.addFace(this.vnx3, this.vpx3, this.vpx4, this.vnx4, this.tx3, this.tx4, this.ty1, this.ty3);
         RenderHelper.addFace(this.vpx3, this.vnx3, this.vnx4, this.vpx4, this.tx3, this.tx4, this.ty1, this.ty3);
         RenderHelper.addFace(this.vnz3, this.vpz3, this.vpz4, this.vnz4, this.tx3, this.tx4, this.ty1, this.ty3);
         RenderHelper.addFace(this.vpz3, this.vnz3, this.vnz4, this.vpz4, this.tx3, this.tx4, this.ty1, this.ty3);
      }

      GL11.glPopMatrix();
   }
}
