package assets.rivalrebels.client.objfileloader;

import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.opengl.GL11;

public class Triangle {
   public Vertice[] pa;
   private Tessellator tes = Tessellator.field_78398_a;

   public Triangle(Vertice[] PA) {
      if (PA.length != 3) {
         throw new IllegalArgumentException("Invalid Triangle! Specified Vec3 Array must have 3 Vec3s");
      }

      this.pa = PA;
   }

   public void render() {
      this.tes.func_78371_b(4);

      for (int i = 0; i < this.pa.length; i++) {
         this.pa[i].render();
      }

      this.tes.func_78381_a();
   }

   public void renderWireframe() {
      GL11.glLineWidth(2.0F);
      this.tes.func_78371_b(2);

      for (int i = 0; i < this.pa.length; i++) {
         this.pa[i].renderWireframe();
      }

      this.tes.func_78381_a();
   }

   public void normalize() {
      for (int i = 0; i < this.pa.length; i++) {
         this.pa[i].normalize();
      }
   }

   public void scale(Vec3 v) {
      for (int i = 0; i < this.pa.length; i++) {
         this.pa[i].scale(v);
      }
   }

   public Triangle[] refine() {
      Triangle[] p = new Triangle[4];
      if (this.pa.length == 3) {
         Vertice mp1 = Vertice.average(this.pa[0], this.pa[1]);
         Vertice mp2 = Vertice.average(this.pa[1], this.pa[2]);
         Vertice mp3 = Vertice.average(this.pa[2], this.pa[0]);
         p[0] = new Triangle(new Vertice[]{this.pa[0].clone(), mp1.clone(), mp3.clone()});
         p[1] = new Triangle(new Vertice[]{this.pa[1].clone(), mp2.clone(), mp1.clone()});
         p[2] = new Triangle(new Vertice[]{this.pa[2].clone(), mp3.clone(), mp2.clone()});
         p[3] = new Triangle(new Vertice[]{mp1.clone(), mp2.clone(), mp3.clone()});
      }

      return p;
   }
}
