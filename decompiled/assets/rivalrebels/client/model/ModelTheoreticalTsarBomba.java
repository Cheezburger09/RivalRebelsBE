package assets.rivalrebels.client.model;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.renderhelper.RenderHelper;
import assets.rivalrebels.client.renderhelper.TextureVertice;
import assets.rivalrebels.client.renderhelper.Vertice;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class ModelTheoreticalTsarBomba {
   private float[] tsarx = new float[]{0.5F, 0.5F, 0.875F, 1.0F, 1.0F, 0.875F, 0.5F, 0.0F};
   private float[] tsary = new float[]{-5.0F, -3.5F, -2.0F, -1.0F, 1.0F, 2.0F, 2.75F, 3.0F};
   private float[] tsart = new float[]{1.0F, 0.8125F, 0.625F, 0.5F, 0.25F, 0.125F, 0.03125F, 0.0F};
   private int segments = 20;
   private float deg = (float) (Math.PI * 2) / this.segments;
   private float sin = (float)Math.sin(this.deg);
   private float cos = (float)Math.cos(this.deg);
   private float add = (float)(360 / this.segments);

   public void render() {
      GL11.glPushMatrix();
      GL11.glScalef(RivalRebels.nukeScale, RivalRebels.nukeScale, RivalRebels.nukeScale);
      GL11.glDisable(2884);
      GL11.glPushMatrix();
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.ettheoreticaltsarshell1);

      for (float i = 0.0F; i < this.segments; i++) {
         GL11.glPushMatrix();
         GL11.glRotatef(this.add * i, 0.0F, 1.0F, 0.0F);

         for (int f = 1; f < this.tsarx.length; f++) {
            TextureVertice t1 = new TextureVertice(1.0F / this.segments * i, this.tsart[f]);
            TextureVertice t2 = new TextureVertice(1.0F / this.segments * i, this.tsart[f - 1]);
            TextureVertice t3 = new TextureVertice(1.0F / this.segments * (i + 1.0F), this.tsart[f - 1]);
            TextureVertice t4 = new TextureVertice(1.0F / this.segments * (i + 1.0F), this.tsart[f]);
            RenderHelper.addFace(
               new Vertice(0.0F, this.tsary[f], this.tsarx[f]),
               new Vertice(0.0F, this.tsary[f - 1], this.tsarx[f - 1]),
               new Vertice(this.tsarx[f - 1] * this.sin, this.tsary[f - 1], this.tsarx[f - 1] * this.cos),
               new Vertice(this.tsarx[f] * this.sin, this.tsary[f], this.tsarx[f] * this.cos),
               t1,
               t2,
               t3,
               t4
            );
         }

         GL11.glPopMatrix();
      }

      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.ettheoreticaltsarshell2);

      for (float i = 0.0F; i < this.segments; i++) {
         GL11.glPushMatrix();
         GL11.glRotatef(this.add * i, 0.0F, 1.0F, 0.0F);
         GL11.glScalef(0.85F, 0.95F, 0.85F);

         for (int f = 1; f < this.tsarx.length; f++) {
            TextureVertice t1 = new TextureVertice(1.0F / this.segments * i, this.tsart[f]);
            TextureVertice t2 = new TextureVertice(1.0F / this.segments * i, this.tsart[f - 1]);
            TextureVertice t3 = new TextureVertice(1.0F / this.segments * (i + 1.0F), this.tsart[f - 1]);
            TextureVertice t4 = new TextureVertice(1.0F / this.segments * (i + 1.0F), this.tsart[f]);
            RenderHelper.addFace(
               new Vertice(0.0F, this.tsary[f], this.tsarx[f]),
               new Vertice(0.0F, this.tsary[f - 1], this.tsarx[f - 1]),
               new Vertice(this.tsarx[f - 1] * this.sin, this.tsary[f - 1], this.tsarx[f - 1] * this.cos),
               new Vertice(this.tsarx[f] * this.sin, this.tsary[f], this.tsarx[f] * this.cos),
               t1,
               t2,
               t3,
               t4
            );
         }

         GL11.glPopMatrix();
      }

      GL11.glPopMatrix();
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.ettsarfins);
      GL11.glPushMatrix();
      TextureVertice t5 = new TextureVertice(0.2734375F, 0.0F);
      TextureVertice t6 = new TextureVertice(0.5234375F, 0.0F);
      TextureVertice t7 = new TextureVertice(0.5234375F, 0.25F);
      TextureVertice t8 = new TextureVertice(0.2734375F, 0.25F);
      RenderHelper.addFace(
         new Vertice(0.5F, -5.0F, 0.5F), new Vertice(-0.5F, -5.0F, 0.5F), new Vertice(-0.5F, -5.0F, -0.5F), new Vertice(0.5F, -5.0F, -0.5F), t5, t6, t7, t8
      );
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      TextureVertice t1 = new TextureVertice(0.0F, 0.0F);
      TextureVertice t2 = new TextureVertice(0.2734375F, 0.0F);
      TextureVertice t3 = new TextureVertice(0.2734375F, 0.375F);
      TextureVertice t4 = new TextureVertice(0.0F, 0.375F);
      RenderHelper.addFace(
         new Vertice(0.0F, -5.0F, -1.4F), new Vertice(0.0F, -5.0F, -0.5F), new Vertice(0.0F, -3.5F, -0.5F), new Vertice(0.0F, -3.5F, -1.4F), t1, t2, t3, t4
      );
      GL11.glRotatef(120.0F, 0.0F, 1.0F, 0.0F);
      RenderHelper.addFace(
         new Vertice(0.0F, -5.0F, -1.4F), new Vertice(0.0F, -5.0F, -0.5F), new Vertice(0.0F, -3.5F, -0.5F), new Vertice(0.0F, -3.5F, -1.4F), t1, t2, t3, t4
      );
      GL11.glRotatef(120.0F, 0.0F, 1.0F, 0.0F);
      RenderHelper.addFace(
         new Vertice(0.0F, -5.0F, -1.4F), new Vertice(0.0F, -5.0F, -0.5F), new Vertice(0.0F, -3.5F, -0.5F), new Vertice(0.0F, -3.5F, -1.4F), t1, t2, t3, t4
      );
      GL11.glPopMatrix();
      GL11.glPopMatrix();
   }
}
