package assets.rivalrebels.client.objfileloader;

import net.minecraft.client.renderer.Tessellator;

public class Vertice {
   public Vec3 p;
   public Vec3 n;
   public Vec2 t;
   private Tessellator tes = Tessellator.field_78398_a;

   public Vertice(float a, float b, float c, float d, float e, float f, float g, float h) {
      this.p = new Vec3(a, b, c);
      this.n = new Vec3(d, e, f);
      this.t = new Vec2(g, h);
   }

   public Vertice(Vec3 P, Vec3 N, Vec2 T) {
      this.p = P;
      this.n = N;
      this.t = T;
   }

   public void normalize() {
      double l = Math.sqrt(this.n.x * this.n.x + this.n.y * this.n.y + this.n.z * this.n.z);
      this.n.x = (float)(this.n.x / l);
      this.n.y = (float)(this.n.y / l);
      this.n.z = (float)(this.n.z / l);
   }

   public void render() {
      this.tes.func_78385_a(this.t.x, this.t.y);
      this.tes.func_78375_b(this.n.x, this.n.y, this.n.z);
      this.tes.func_78377_a(this.p.x, this.p.y, this.p.z);
   }

   public void renderWireframe() {
      this.tes.func_78377_a(this.p.x, this.p.y, this.p.z);
   }

   public Vertice clone() {
      return new Vertice(this.p.clone(), this.n.clone(), this.t.clone());
   }

   public static Vertice average(Vertice v1, Vertice v2) {
      return new Vertice(
         (v1.p.x + v2.p.x) / 2.0F,
         (v1.p.y + v2.p.y) / 2.0F,
         (v1.p.z + v2.p.z) / 2.0F,
         (v1.n.x + v2.n.x) / 2.0F,
         (v1.n.y + v2.n.y) / 2.0F,
         (v1.n.z + v2.n.z) / 2.0F,
         (v1.t.x + v2.t.x) / 2.0F,
         (v1.t.y + v2.t.y) / 2.0F
      );
   }

   public void scale(Vec3 v) {
      this.p.x = this.p.x * v.x;
      this.p.y = this.p.y * v.y;
      this.p.z = this.p.z * v.z;
   }
}
