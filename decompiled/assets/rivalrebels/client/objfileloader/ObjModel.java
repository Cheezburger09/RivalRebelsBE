package assets.rivalrebels.client.objfileloader;

import assets.rivalrebels.RivalRebels;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.lwjgl.opengl.GL11;

public class ObjModel {
   private ObjModel.Vector3[] verts;
   private short[] tris;

   public ObjModel(String path) {
      ByteBuffer buf = null;

      try {
         InputStream in = RivalRebels.instance.getClass().getResourceAsStream("/assets/rivalrebels/models/" + path);
         byte[] data = new byte[in.read() << 24 | in.read() << 16 | in.read() << 8 | in.read()];
         in.read(data);
         buf = ByteBuffer.wrap(data);
      } catch (Exception var5) {
      }

      if (buf != null) {
         this.verts = new ObjModel.Vector3[buf.getShort()];

         for (int i = 0; i < this.verts.length; i++) {
            this.verts[i] = new ObjModel.Vector3(
               buf.getFloat(),
               buf.getFloat(),
               buf.getFloat(),
               (buf.get() - 127) / 127.0F,
               (buf.get() - 127) / 127.0F,
               (buf.get() - 127) / 127.0F,
               (buf.get() - 127) / 127.0F,
               (buf.get() - 127) / 127.0F
            );
         }

         this.tris = new short[buf.getInt() * 3];

         for (int i = 0; i < this.tris.length; i++) {
            this.tris[i] = buf.getShort();
         }
      }
   }

   public void render() {
      GL11.glBegin(4);
      int i = 0;

      while (i < this.tris.length) {
         i++;
      }
   }

   private class Vector3 {
      public float x;
      public float y;
      public float z;
      public float i;
      public float j;
      public float k;
      public float u;
      public float v;

      public Vector3(float X, float Y, float Z, float I, float J, float K, float U, float V) {
         this.x = X;
         this.y = Y;
         this.z = Z;
         this.i = I;
         this.j = J;
         this.k = K;
         this.u = U;
         this.v = V;
      }
   }
}
