package assets.rivalrebels.client.objfileloader;

class Vec3 {
   float x;
   float y;
   float z;

   public Vec3(float X, float Y, float Z) {
      this.x = X;
      this.y = Y;
      this.z = Z;
   }

   public Vec3 clone() {
      return new Vec3(this.x, this.y, this.z);
   }
}
