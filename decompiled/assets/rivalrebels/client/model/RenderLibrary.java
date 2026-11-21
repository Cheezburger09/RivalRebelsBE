package assets.rivalrebels.client.model;

import java.util.Random;
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.opengl.GL11;

public class RenderLibrary {
   Tessellator t = Tessellator.field_78398_a;
   Random random = new Random();
   public static RenderLibrary instance;

   public void init() {
      instance = this;
   }

   public void renderModel(
      float x1,
      float y1,
      float z1,
      float x,
      float y,
      float z,
      float segDist,
      float radius,
      int steps,
      float arcRatio,
      float rvar,
      float r,
      float g,
      float b,
      float a
   ) {
      GL11.glPushMatrix();
      GL11.glTranslatef(x1, y1, z1);
      GL11.glEnable(32826);
      GL11.glDisable(3553);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 1);
      GL11.glRotated(Math.atan2(x, z) * 57.295779513 - 90.0, 0.0, 1.0, 0.0);
      GL11.glColor4f(r, g, b, a);
      double dist = Math.sqrt(x * x + z * z);
      double hdist = dist / 2.0;
      double hdists = hdist * hdist;
      double rs = radius / steps;
      int segNum = (int)Math.ceil(dist / segDist) + 1;
      double[] xv = new double[segNum];
      double[] yv = new double[segNum];
      double[] zv = new double[segNum];

      for (int i = 1; i < segNum; i++) {
         double interp = (double)i / segNum;
         double X = dist * interp;
         double Y = y * interp;
         double ihdist = dist * interp - hdist;
         Y += (hdists - ihdist * ihdist) / hdists * arcRatio;
         xv[i] = X;
         yv[i] = Y + this.random.nextGaussian() * rvar;
         zv[i] = this.random.nextGaussian() * rvar;
      }

      xv[0] = 0.0;
      yv[0] = 0.0;
      zv[0] = 0.0;

      for (int o = 0; o < steps; o++) {
         this.t.func_78382_b();

         for (int i = 1; i < segNum; i++) {
            double s = rs * o;
            this.t.func_78377_a(xv[i - 1], yv[i - 1] + s, zv[i - 1] - s);
            this.t.func_78377_a(xv[i - 1], yv[i - 1] + s, zv[i - 1] + s);
            this.t.func_78377_a(xv[i], yv[i] + s, zv[i] + s);
            this.t.func_78377_a(xv[i], yv[i] + s, zv[i] - s);
            this.t.func_78377_a(xv[i - 1], yv[i - 1] + s, zv[i - 1] + s);
            this.t.func_78377_a(xv[i - 1], yv[i - 1] - s, zv[i - 1] + s);
            this.t.func_78377_a(xv[i], yv[i] - s, zv[i] + s);
            this.t.func_78377_a(xv[i], yv[i] + s, zv[i] + s);
            this.t.func_78377_a(xv[i - 1], yv[i - 1] - s, zv[i - 1] - s);
            this.t.func_78377_a(xv[i - 1], yv[i - 1] + s, zv[i - 1] - s);
            this.t.func_78377_a(xv[i], yv[i] + s, zv[i] - s);
            this.t.func_78377_a(xv[i], yv[i] - s, zv[i] - s);
            this.t.func_78377_a(xv[i - 1], yv[i - 1] - s, zv[i - 1] + s);
            this.t.func_78377_a(xv[i - 1], yv[i - 1] - s, zv[i - 1] - s);
            this.t.func_78377_a(xv[i], yv[i] - s, zv[i] - s);
            this.t.func_78377_a(xv[i], yv[i] - s, zv[i] + s);
         }

         this.t.func_78381_a();
      }

      GL11.glDisable(3042);
      GL11.glEnable(3553);
      GL11.glDisable(32826);
      GL11.glPopMatrix();
   }
}
