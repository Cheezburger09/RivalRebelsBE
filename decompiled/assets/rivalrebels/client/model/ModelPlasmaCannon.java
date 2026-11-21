package assets.rivalrebels.client.model;

import assets.rivalrebels.client.renderhelper.RenderHelper;
import assets.rivalrebels.client.renderhelper.TextureFace;
import assets.rivalrebels.client.renderhelper.TextureVertice;
import assets.rivalrebels.client.renderhelper.Vertice;
import org.lwjgl.opengl.GL11;

public class ModelPlasmaCannon {
   TextureFace bodytop = new TextureFace(
      new TextureVertice(0.21875F, 0.71875F),
      new TextureVertice(0.578125F, 0.71875F),
      new TextureVertice(0.578125F, 0.90625F),
      new TextureVertice(0.21875F, 0.90625F)
   );
   TextureFace bodytopfront = new TextureFace(
      new TextureVertice(0.578125F, 0.90625F),
      new TextureVertice(0.671875F, 0.90625F),
      new TextureVertice(0.671875F, 0.71875F),
      new TextureVertice(0.578125F, 0.71875F)
   );
   TextureFace bodytopback = new TextureFace(
      new TextureVertice(0.15625F, 0.625F), new TextureVertice(0.21875F, 0.71875F), new TextureVertice(0.21875F, 0.90625F), new TextureVertice(0.15625F, 1.0F)
   );
   TextureFace bodyback = new TextureFace(
      new TextureVertice(0.109375F, 0.625F), new TextureVertice(0.15625F, 0.625F), new TextureVertice(0.15625F, 1.0F), new TextureVertice(0.109375F, 1.0F)
   );
   TextureFace bodybottomback = new TextureFace(
      new TextureVertice(0.0F, 0.71875F), new TextureVertice(0.109375F, 0.625F), new TextureVertice(0.109375F, 1.0F), new TextureVertice(0.0F, 0.90625F)
   );
   TextureFace bodybottom = new TextureFace(
      new TextureVertice(0.109375F, 0.34375F),
      new TextureVertice(0.421875F, 0.34375F),
      new TextureVertice(0.421875F, 0.53125F),
      new TextureVertice(0.109375F, 0.53125F)
   );
   TextureFace bodybottomfront = new TextureFace(
      new TextureVertice(0.421875F, 0.34375F),
      new TextureVertice(0.515625F, 0.34375F),
      new TextureVertice(0.515625F, 0.53125F),
      new TextureVertice(0.421875F, 0.53125F)
   );
   TextureFace bodytopside = new TextureFace(
      new TextureVertice(0.0F, 0.125F), new TextureVertice(0.0625F, 0.0F), new TextureVertice(0.421875F, 0.0F), new TextureVertice(0.390625F, 0.125F)
   );
   TextureFace bodyside = new TextureFace(
      new TextureVertice(0.0F, 0.21875F), new TextureVertice(0.0F, 0.125F), new TextureVertice(0.390625F, 0.125F), new TextureVertice(0.390625F, 0.21875F)
   );
   TextureFace bodybottomside = new TextureFace(
      new TextureVertice(0.0F, 0.21875F),
      new TextureVertice(0.390625F, 0.21875F),
      new TextureVertice(0.421875F, 0.34375F),
      new TextureVertice(0.109375F, 0.34375F)
   );
   TextureFace bodysidefront = new TextureFace(
      new TextureVertice(0.421875F, 0.21875F),
      new TextureVertice(0.421875F, 0.125F),
      new TextureVertice(0.515625F, 0.125F),
      new TextureVertice(0.484375F, 0.21875F)
   );
   TextureFace bodysidefrontedge = new TextureFace(
      new TextureVertice(0.390625F, 0.21875F),
      new TextureVertice(0.390625F, 0.125F),
      new TextureVertice(0.421875F, 0.125F),
      new TextureVertice(0.421875F, 0.21875F)
   );
   TextureFace bodytopfrontside = new TextureFace(
      new TextureVertice(0.578125F, 0.71875F),
      new TextureVertice(0.671875F, 0.71875F),
      new TextureVertice(0.578125F, 0.59375F),
      new TextureVertice(0.578125F, 0.59375F)
   );
   TextureFace detailpurple = new TextureFace(
      new TextureVertice(0.328125F, 0.71875F),
      new TextureVertice(0.46875F, 0.71875F),
      new TextureVertice(0.46875F, 0.65625F),
      new TextureVertice(0.328125F, 0.65625F)
   );
   TextureFace detailedge1 = new TextureFace(
      new TextureVertice(0.3125F, 0.71875F),
      new TextureVertice(0.328125F, 0.71875F),
      new TextureVertice(0.328125F, 0.65625F),
      new TextureVertice(0.3125F, 0.65625F)
   );
   TextureFace detailedge2 = new TextureFace(
      new TextureVertice(0.46875F, 0.625F),
      new TextureVertice(0.46875F, 0.65625F),
      new TextureVertice(0.328125F, 0.65625F),
      new TextureVertice(0.328125F, 0.625F)
   );
   TextureFace handleside = new TextureFace(
      new TextureVertice(0.0F, 0.34375F), new TextureVertice(0.0F, 0.5625F), new TextureVertice(0.0625F, 0.5625F), new TextureVertice(0.0625F, 0.34375F)
   );
   TextureFace handlefront = new TextureFace(
      new TextureVertice(0.0625F, 0.34375F),
      new TextureVertice(0.0625F, 0.5625F),
      new TextureVertice(0.109375F, 0.5625F),
      new TextureVertice(0.109375F, 0.34375F)
   );
   TextureFace handlebottom = new TextureFace(
      new TextureVertice(0.0625F, 0.5625F), new TextureVertice(0.0F, 0.5625F), new TextureVertice(0.0F, 0.65625F), new TextureVertice(0.0625F, 0.65625F)
   );
   TextureFace bottomside = new TextureFace(
      new TextureVertice(0.765625F, 0.3125F),
      new TextureVertice(0.71875F, 0.40625F),
      new TextureVertice(0.5625F, 0.40625F),
      new TextureVertice(0.5625F, 0.3125F)
   );
   TextureFace bottomfront = new TextureFace(
      new TextureVertice(0.71875F, 0.40625F),
      new TextureVertice(0.78125F, 0.40625F),
      new TextureVertice(0.78125F, 0.53125F),
      new TextureVertice(0.71875F, 0.53125F)
   );
   TextureFace bottombottom = new TextureFace(
      new TextureVertice(0.71875F, 0.53125F),
      new TextureVertice(0.5625F, 0.53125F),
      new TextureVertice(0.5625F, 0.40625F),
      new TextureVertice(0.71875F, 0.40625F)
   );
   TextureFace bottomback = new TextureFace(
      new TextureVertice(0.515625F, 0.40625F),
      new TextureVertice(0.5625F, 0.40625F),
      new TextureVertice(0.5625F, 0.53125F),
      new TextureVertice(0.515625F, 0.53125F)
   );
   Vertice vt1 = new Vertice(3.0F, 12.0F, 3.0F);
   Vertice vt2 = new Vertice(27.0F, 12.0F, 3.0F);
   Vertice vt3 = new Vertice(27.0F, 12.0F, -3.0F);
   Vertice vt4 = new Vertice(3.0F, 12.0F, -3.0F);
   Vertice vf1 = new Vertice(34.0F, 9.0F, 3.0F);
   Vertice vf2 = new Vertice(34.0F, 9.0F, -3.0F);
   Vertice vs1 = new Vertice(0.0F, 9.0F, 6.0F);
   Vertice vs2 = new Vertice(0.0F, 6.0F, 6.0F);
   Vertice vs3 = new Vertice(25.0F, 6.0F, 6.0F);
   Vertice vs4 = new Vertice(25.0F, 9.0F, 6.0F);
   Vertice vs5 = new Vertice(0.0F, 9.0F, -6.0F);
   Vertice vs6 = new Vertice(0.0F, 6.0F, -6.0F);
   Vertice vs7 = new Vertice(25.0F, 6.0F, -6.0F);
   Vertice vs8 = new Vertice(25.0F, 9.0F, -6.0F);
   Vertice vfs1 = new Vertice(25.0F, 6.0F, 4.0F);
   Vertice vfs2 = new Vertice(25.0F, 9.0F, 4.0F);
   Vertice vfs3 = new Vertice(25.0F, 6.0F, -4.0F);
   Vertice vfs4 = new Vertice(25.0F, 9.0F, -4.0F);
   Vertice vff1 = new Vertice(30.0F, 6.0F, 0.0F);
   Vertice vff2 = new Vertice(32.0F, 9.0F, 0.0F);
   Vertice vb1 = new Vertice(7.0F, 3.0F, 3.0F);
   Vertice vb2 = new Vertice(27.0F, 3.0F, 3.0F);
   Vertice vb3 = new Vertice(27.0F, 3.0F, -3.0F);
   Vertice vb4 = new Vertice(7.0F, 3.0F, -3.0F);
   Vertice vfb1 = new Vertice(31.0F, 6.0F, 3.0F);
   Vertice vfb2 = new Vertice(31.0F, 6.0F, -3.0F);
   Vertice vdt1 = new Vertice(10.25F, 12.0F, 1.0F);
   Vertice vdt2 = new Vertice(19.75F, 12.0F, 1.0F);
   Vertice vdt3 = new Vertice(19.75F, 12.0F, -1.0F);
   Vertice vdt4 = new Vertice(10.25F, 12.0F, -1.0F);
   Vertice vdb1 = new Vertice(10.25F, 11.5F, 1.0F);
   Vertice vdb2 = new Vertice(19.75F, 11.5F, 1.0F);
   Vertice vdb3 = new Vertice(19.75F, 11.5F, -1.0F);
   Vertice vdb4 = new Vertice(10.25F, 11.5F, -1.0F);
   Vertice vht1 = new Vertice(11.0F, 0.0F, 2.0F);
   Vertice vht2 = new Vertice(15.0F, 0.0F, 2.0F);
   Vertice vht3 = new Vertice(15.0F, 0.0F, -2.0F);
   Vertice vht4 = new Vertice(11.0F, 0.0F, -2.0F);
   Vertice vhb1 = new Vertice(7.0F, -7.0F, 2.0F);
   Vertice vhb2 = new Vertice(11.0F, -7.0F, 2.0F);
   Vertice vhb3 = new Vertice(11.0F, -7.0F, -2.0F);
   Vertice vhb4 = new Vertice(7.0F, -7.0F, -2.0F);
   Vertice vbt1 = new Vertice(8.0F, 3.0F, 2.0F);
   Vertice vbt2 = new Vertice(23.0F, 3.0F, 2.0F);
   Vertice vbt3 = new Vertice(23.0F, 3.0F, -2.0F);
   Vertice vbt4 = new Vertice(8.0F, 3.0F, -2.0F);
   Vertice vbb1 = new Vertice(8.0F, 0.0F, 2.0F);
   Vertice vbb2 = new Vertice(20.0F, 0.0F, 2.0F);
   Vertice vbb3 = new Vertice(20.0F, 0.0F, -2.0F);
   Vertice vbb4 = new Vertice(8.0F, 0.0F, -2.0F);

   public void render() {
      GL11.glPushMatrix();
      GL11.glDisable(2884);
      RenderHelper.addFace(this.vt1, this.vt2, this.vt3, this.vt4, this.bodytop);
      RenderHelper.addFace(this.vs1, this.vt1, this.vt2, this.vs4, this.bodytopside);
      RenderHelper.addFace(this.vs5, this.vt4, this.vt3, this.vs8, this.bodytopside);
      RenderHelper.addFace(this.vs2, this.vs1, this.vs4, this.vs3, this.bodyside);
      RenderHelper.addFace(this.vs6, this.vs5, this.vs8, this.vs7, this.bodyside);
      RenderHelper.addFace(this.vs1, this.vt1, this.vt4, this.vs5, this.bodytopback);
      RenderHelper.addFace(this.vs2, this.vs1, this.vs5, this.vs6, this.bodyback);
      RenderHelper.addFace(this.vt2, this.vf1, this.vf2, this.vt3, this.bodytopfront);
      RenderHelper.addFace(this.vt2, this.vf1, this.vs4, this.vs4, this.bodytopfrontside);
      RenderHelper.addFace(this.vt3, this.vf2, this.vs8, this.vs8, this.bodytopfrontside);
      RenderHelper.addFace(this.vs3, this.vs4, this.vfs2, this.vfs1, this.bodysidefrontedge);
      RenderHelper.addFace(this.vs7, this.vs8, this.vfs4, this.vfs3, this.bodysidefrontedge);
      RenderHelper.addFace(this.vf2, this.vs8, this.vs4, this.vf1, this.bodybottomback);
      RenderHelper.addFace(this.vfs2, this.vfs1, this.vff1, this.vff2, this.bodysidefront);
      RenderHelper.addFace(this.vfs4, this.vfs3, this.vff1, this.vff2, this.bodysidefront);
      RenderHelper.addFace(this.vb1, this.vb2, this.vb3, this.vb4, this.bodybottom);
      RenderHelper.addFace(this.vs2, this.vs3, this.vb2, this.vb1, this.bodybottomside);
      RenderHelper.addFace(this.vs6, this.vs7, this.vb3, this.vb4, this.bodybottomside);
      RenderHelper.addFace(this.vb2, this.vfb1, this.vs3, this.vs3, this.bodytopfrontside);
      RenderHelper.addFace(this.vb3, this.vfb2, this.vs7, this.vs7, this.bodytopfrontside);
      RenderHelper.addFace(this.vb2, this.vfb1, this.vfb2, this.vb3, this.bodybottomfront);
      RenderHelper.addFace(this.vb1, this.vs2, this.vs6, this.vb4, this.bodybottomback);
      RenderHelper.addFace(this.vfb2, this.vs7, this.vs3, this.vfb1, this.bodybottomback);
      RenderHelper.addFace(this.vbb1, this.vbt1, this.vbt4, this.vbb4, this.bottomfront);
      RenderHelper.addFace(this.vbb3, this.vbt3, this.vbt2, this.vbb2, this.bottomback);
      RenderHelper.addFace(this.vbt2, this.vbb2, this.vbb1, this.vbt1, this.bottomside);
      RenderHelper.addFace(this.vbt3, this.vbb3, this.vbb4, this.vbt4, this.bottomside);
      RenderHelper.addFace(this.vbb3, this.vbb4, this.vbb1, this.vbb2, this.bottombottom);
      RenderHelper.addFace(this.vdt4, this.vdb4, this.vdb1, this.vdt1, this.detailedge1);
      RenderHelper.addFace(this.vdt3, this.vdb3, this.vdb2, this.vdt2, this.detailedge1);
      RenderHelper.addFace(this.vdt2, this.vdb2, this.vdb1, this.vdt1, this.detailedge2);
      RenderHelper.addFace(this.vdt4, this.vdb4, this.vdb3, this.vdt3, this.detailedge2);
      RenderHelper.addFace(this.vdb1, this.vdb2, this.vdb3, this.vdb4, this.detailpurple);
      RenderHelper.addFace(this.vht4, this.vhb4, this.vhb1, this.vht1, this.handlefront);
      RenderHelper.addFace(this.vht2, this.vhb2, this.vhb3, this.vht3, this.handlefront);
      RenderHelper.addFace(this.vht1, this.vhb1, this.vhb2, this.vht2, this.handleside);
      RenderHelper.addFace(this.vht3, this.vhb3, this.vhb4, this.vht4, this.handleside);
      RenderHelper.addFace(this.vhb2, this.vhb1, this.vhb4, this.vhb3, this.handlebottom);
      GL11.glPopMatrix();
   }
}
