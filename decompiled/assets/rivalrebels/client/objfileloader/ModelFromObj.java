package assets.rivalrebels.client.objfileloader;

import assets.rivalrebels.RivalRebels;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.lwjgl.opengl.GL11;

public class ModelFromObj {
   Triangle[] pa;
   public String name;

   public ModelFromObj(Triangle[] PA) {
      this.pa = PA;
   }

   public static ModelFromObj readObjFile(String path) throws Exception {
      String text = "";
      File file = new File("mods");
      String[] files = file.list();
      text = readZippedFile("/assets/rivalrebels/models/" + path);
      String[] lines = text.split("\n");
      String name = "";
      ArrayList<Triangle> tri = new ArrayList<>();
      ArrayList<Vec3> v = new ArrayList<>();
      ArrayList<Vec3> nv = new ArrayList<>();
      ArrayList<Vec2> tv = new ArrayList<>();

      for (int i = 0; i < lines.length; i++) {
         String line = lines[i];
         if (line.startsWith("vt")) {
            String[] tex = line.split(" ");
            tv.add(new Vec2(Float.parseFloat(tex[1]), 1.0F - Float.parseFloat(tex[2])));
         } else if (line.startsWith("vn")) {
            String[] norm = line.split(" ");
            nv.add(new Vec3(Float.parseFloat(norm[1]), Float.parseFloat(norm[2]), Float.parseFloat(norm[3])));
         } else if (line.startsWith("v")) {
            String[] vert = line.split(" ");
            v.add(new Vec3(Float.parseFloat(vert[1]), Float.parseFloat(vert[2]), Float.parseFloat(vert[3])));
         } else if (!line.startsWith("f")) {
            if (line.startsWith("o")) {
               String[] l = line.split(" ");
               name = l[1];
            }
         } else {
            String[] coords = lines[i].split(" ");
            Vertice[] vs = new Vertice[coords.length - 1];

            for (int j = 1; j < coords.length; j++) {
               String[] v1 = coords[j].split("/");
               vs[j - 1] = new Vertice(
                  v.get(Integer.parseInt(v1[0]) - 1).clone(), nv.get(Integer.parseInt(v1[2]) - 1).clone(), tv.get(Integer.parseInt(v1[1]) - 1).clone()
               );
            }

            tri.add(new Triangle(vs));
         }
      }

      Triangle[] polygon = new Triangle[tri.size()];

      for (int i = 0; i < tri.size(); i++) {
         polygon[i] = tri.get(i);
      }

      ModelFromObj modelFromObj = new ModelFromObj(polygon);
      modelFromObj.name = name;
      return modelFromObj;
   }

   public void renderWireframe() {
      GL11.glDisable(3553);

      for (int i = 0; i < this.pa.length; i++) {
         this.pa[i].renderWireframe();
      }

      GL11.glEnable(3553);
   }

   public void normalize() {
      for (int i = 0; i < this.pa.length; i++) {
         this.pa[i].normalize();
      }
   }

   public void scale(float x, float y, float z) {
      for (int i = 0; i < this.pa.length; i++) {
         this.pa[i].scale(new Vec3(x, y, z));
      }
   }

   public void render() {
      for (int i = 0; i < this.pa.length; i++) {
         this.pa[i].render();
      }
   }

   public void refine() {
      ArrayList<Triangle> lp = new ArrayList<>();

      for (int i = 0; i < this.pa.length; i++) {
         Triangle[] p = this.pa[i].refine();

         for (int a = 0; a < p.length; a++) {
            lp.add(p[a]);
         }
      }

      this.pa = new Triangle[lp.size()];

      for (int i = 0; i < lp.size(); i++) {
         this.pa[i] = lp.get(i);
      }
   }

   public static String readZippedFile(String file) {
      StringBuilder source = new StringBuilder();

      try {
         InputStream in = RivalRebels.instance.getClass().getResourceAsStream(file);
         BufferedReader reader = new BufferedReader(new InputStreamReader(in));

         String line;
         while ((line = reader.readLine()) != null) {
            source.append(line).append('\n');
         }
      } catch (Exception e) {
         e.printStackTrace();
      }

      return source.toString();
   }
}
