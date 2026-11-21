package assets.rivalrebels.common.noise;

public class RivalRebelsCellularNoise {
   public static int pointa2D = 32;
   public static RivalRebelsCellularNoise.Point[] points2D = new RivalRebelsCellularNoise.Point[pointa2D];
   public static int pointa3D = 32;
   public static RivalRebelsCellularNoise.Point[] points3D = new RivalRebelsCellularNoise.Point[pointa3D];

   public static void refresh2D() {
      for (int i = 0; i < pointa2D; i++) {
         points2D[i] = new RivalRebelsCellularNoise.Point(Math.random(), Math.random());
      }
   }

   public static void refresh3D() {
      for (int i = 0; i < pointa3D; i++) {
         points3D[i] = new RivalRebelsCellularNoise.Point(Math.random(), Math.random(), Math.random());
      }
   }

   public static double noise(double xin, double yin) {
      double result = 1.0;

      for (int i = 0; i < pointa2D; i++) {
         RivalRebelsCellularNoise.Point point = points2D[i];
         double dist = getDist(point, xin, yin);
         if (dist <= result) {
            result = dist;
         }
      }

      return Math.sqrt(result) * 2.0 - 1.0;
   }

   public static double noise(double xin, double yin, double zin) {
      double result = 1.0;

      for (int i = 0; i < pointa3D; i++) {
         RivalRebelsCellularNoise.Point point = points3D[i];
         double dist = getDist(point, xin, yin, zin);
         if (dist <= result) {
            result = dist;
         }
      }

      return Math.sqrt(result) * 4.0 - 0.75;
   }

   private static double getDist(RivalRebelsCellularNoise.Point point, double xin, double yin) {
      double result = 1.0;

      for (int x = -1; x <= 1; x++) {
         double xx = point.x - (xin + x);
         double X = xx * xx;

         for (int y = -1; y <= 1; y++) {
            double yy = point.y - (yin + y);
            double Y = yy * yy + X;
            if (Y < result) {
               result = Y;
            }
         }
      }

      return result;
   }

   private static double getDist(RivalRebelsCellularNoise.Point point, double xin, double yin, double zin) {
      double result = 1.0;

      for (int x = -1; x <= 1; x++) {
         double xx = point.x - (xin + x);
         double X = xx * xx;

         for (int y = -1; y <= 1; y++) {
            double yy = point.y - (yin + y);
            double Y = yy * yy + X;

            for (int z = -1; z <= 1; z++) {
               double zz = point.z - (zin + z);
               double Z = zz * zz + Y;
               if (Z < result) {
                  result = Z;
               }
            }
         }
      }

      return result;
   }

   private static class Point {
      double x;
      double y;
      double z;

      Point(double x, double y) {
         this.x = x;
         this.y = y;
      }

      Point(double x, double y, double z) {
         this.x = x;
         this.y = y;
         this.z = z;
      }
   }
}
