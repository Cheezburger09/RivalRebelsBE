package assets.rivalrebels.client.objfileloader;

class Vec2 {
   float x;
   float y;

   public Vec2(float X, float Y) {
      this.x = X;
      this.y = Y;
   }

   public Vec2 clone() {
      return new Vec2(this.x, this.y);
   }
}
