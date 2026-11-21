package assets.rivalrebels.client.renderhelper;

public class Vertice {
   public float x;
   public float y;
   public float z;

   public Vertice(float X, float Y, float Z) {
      this.x = X;
      this.y = Y;
      this.z = Z;
   }

   public Vertice normalize() {
      float l = (float)Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
      this.x /= l;
      this.y /= l;
      this.z /= l;
      return this;
   }
}
