package assets.rivalrebels.client.model;

import assets.rivalrebels.client.renderhelper.RenderHelper;
import assets.rivalrebels.client.renderhelper.TextureVertice;
import assets.rivalrebels.client.renderhelper.Vertice;
import java.util.Random;
import org.lwjgl.opengl.GL11;

public class ModelAntimatterBombBlast {
   private float[][] tsarx = new float[][]{
      {
            7.0F,
            6.0F,
            5.0F,
            4.0F,
            3.0F,
            2.0F,
            1.75F,
            1.5F,
            1.25F,
            1.0F,
            1.0F,
            1.0F,
            1.0F,
            1.0F,
            1.0F,
            1.0F,
            1.0F,
            1.0F,
            1.0F,
            2.5F,
            4.0F,
            6.0F,
            7.0F,
            8.0F,
            8.7F,
            9.5F,
            10.5F,
            11.5F,
            12.0F,
            12.0F,
            11.3F,
            10.0F,
            9.0F,
            7.0F,
            5.0F,
            3.0F,
            0.0F
      },
      {
            7.0F,
            6.0F,
            5.0F,
            4.0F,
            3.0F,
            2.0F,
            1.75F,
            1.5F,
            1.25F,
            1.0F,
            1.0F,
            1.0F,
            1.0F,
            1.0F,
            1.0F,
            1.0F,
            1.0F,
            1.0F,
            1.0F,
            2.5F,
            4.0F,
            6.0F,
            7.0F,
            8.0F,
            8.7F,
            9.5F,
            10.5F,
            11.5F,
            12.0F,
            12.0F,
            11.3F,
            10.0F,
            9.0F,
            7.0F,
            5.0F,
            3.0F,
            0.0F
      }
   };
   private float[][] tsary = new float[][]{
      {
            -9.0F,
            -8.5F,
            -8.0F,
            -7.5F,
            -7.0F,
            -6.0F,
            -5.0F,
            -4.0F,
            -3.0F,
            -2.0F,
            -1.0F,
            0.0F,
            1.0F,
            2.0F,
            3.0F,
            4.0F,
            5.0F,
            6.0F,
            8.0F,
            9.0F,
            9.0F,
            8.0F,
            7.0F,
            5.5F,
            4.0F,
            2.0F,
            0.0F,
            0.0F,
            2.0F,
            4.0F,
            6.0F,
            8.0F,
            9.5F,
            10.8F,
            11.7F,
            12.0F,
            12.0F
      },
      {
            -9.0F,
            -8.5F,
            -8.0F,
            -7.5F,
            -7.0F,
            -6.0F,
            -5.0F,
            -4.0F,
            -3.0F,
            -2.0F,
            -1.0F,
            0.0F,
            1.0F,
            2.0F,
            3.0F,
            4.0F,
            5.0F,
            6.0F,
            8.0F,
            9.0F,
            9.0F,
            8.0F,
            7.0F,
            5.5F,
            4.0F,
            2.0F,
            0.0F,
            0.0F,
            2.0F,
            4.0F,
            6.0F,
            8.0F,
            9.5F,
            10.8F,
            11.7F,
            12.0F,
            12.0F
      }
   };
   private float tsart = 37.0F;
   private int[] time = new int[]{100, 100};
   private float texanim = 0.0F;
   private float texadd = -0.002F;
   private int segments = 20;
   private float deg = (float) (Math.PI * 2) / this.segments;
   private float sin = (float)Math.sin(this.deg);
   private float cos = (float)Math.cos(this.deg);
   private float add = (float)(360 / this.segments);
   private int timer = 0;
   private int index = 0;

   public ModelAntimatterBombBlast() {
      Random rand = new Random();

      for (int f = 0; f < this.tsarx.length; f++) {
         for (int i = 0; i < this.tsarx[f].length; i++) {
            this.tsarx[f][i] = this.tsarx[f][i] + (rand.nextFloat() - 0.5F) * 1.0F;
         }

         for (int i = 0; i < this.tsary[f].length; i++) {
            this.tsary[f][i] = this.tsary[f][i] + (rand.nextFloat() - 0.5F) * 1.0F;
         }
      }
   }

   public void render() {
      if (this.timer == 0) {
         this.timer = this.timer + this.time[this.index];
         this.index++;
      }

      this.index = this.index % this.time.length;
      if (this.timer > 0) {
         this.timer--;
      }

      this.texanim = this.texanim + this.texadd;
      GL11.glPushMatrix();
      GL11.glDisable(2884);

      for (float i = 0.0F; i < this.segments; i++) {
         GL11.glPushMatrix();
         GL11.glRotatef(this.add * i, 0.0F, 1.0F, 0.0F);

         for (int f = 1; f < this.tsart; f++) {
            int ind0 = (this.time.length + this.index - 1) % this.time.length;
            float x0 = this.tsarx[ind0][f - 1] + (this.tsarx[this.index][f - 1] - this.tsarx[ind0][f - 1]) / this.time[ind0] * this.timer;
            float x1 = this.tsarx[ind0][f] + (this.tsarx[this.index][f] - this.tsarx[ind0][f]) / this.time[ind0] * this.timer;
            float y0 = this.tsary[ind0][f - 1] + (this.tsary[this.index][f - 1] - this.tsary[ind0][f - 1]) / this.time[ind0] * this.timer;
            float y1 = this.tsary[ind0][f] + (this.tsary[this.index][f] - this.tsary[ind0][f]) / this.time[ind0] * this.timer;
            TextureVertice t1 = new TextureVertice(1.0F / this.segments * (i - 1.0F), 1.0F / this.tsart * f + this.texanim);
            TextureVertice t2 = new TextureVertice(1.0F / this.segments * (i - 1.0F), 1.0F / this.tsart * (f - 1) + this.texanim);
            TextureVertice t3 = new TextureVertice(1.0F / this.segments * i, 1.0F / this.tsart * (f - 1) + this.texanim);
            TextureVertice t4 = new TextureVertice(1.0F / this.segments * i, 1.0F / this.tsart * f + this.texanim);
            RenderHelper.addFace(
               new Vertice(0.0F, y1, x1),
               new Vertice(0.0F, y0, x0),
               new Vertice(x0 * this.sin, y0, x0 * this.cos),
               new Vertice(x1 * this.sin, y1, x1 * this.cos),
               t1,
               t2,
               t3,
               t4
            );
         }

         GL11.glPopMatrix();
      }

      GL11.glPopMatrix();
   }
}
