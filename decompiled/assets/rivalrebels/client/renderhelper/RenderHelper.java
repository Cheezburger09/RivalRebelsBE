package assets.rivalrebels.client.renderhelper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.opengl.GL11;

public class RenderHelper {
   public static void renderBox(float length, float height, float depth, float texLocX, float texLocY, float texXsize, float texYsize, float resolution) {
      GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
      texLocX /= texXsize;
      texLocY /= texYsize;
      float hl = length / 2.0F / resolution;
      float hh = height / 2.0F / resolution;
      float hd = depth / 2.0F / resolution;
      float xtd = length / texXsize;
      float xtl = depth / texXsize;
      float ytd = length / texYsize;
      float yth = height / texYsize;
      Vertice xpypzp = new Vertice(hl, hh, hd);
      Vertice xnypzp = new Vertice(-hl, hh, hd);
      Vertice xnypzn = new Vertice(-hl, hh, -hd);
      Vertice xpypzn = new Vertice(hl, hh, -hd);
      Vertice xpynzp = new Vertice(hl, -hh, hd);
      Vertice xnynzp = new Vertice(-hl, -hh, hd);
      Vertice xnynzn = new Vertice(-hl, -hh, -hd);
      Vertice xpynzn = new Vertice(hl, -hh, -hd);
      TextureVertice t1 = new TextureVertice(texLocX + xtd, texLocY + 0.0F);
      TextureVertice t2 = new TextureVertice(texLocX + xtd + xtl, texLocY + 0.0F);
      TextureVertice t3 = new TextureVertice(texLocX + xtd + xtl + xtl, texLocY + 0.0F);
      TextureVertice t4 = new TextureVertice(texLocX + 0.0F, texLocY + ytd);
      TextureVertice t5 = new TextureVertice(texLocX + xtd, texLocY + ytd);
      TextureVertice t6 = new TextureVertice(texLocX + xtd + xtl, texLocY + ytd);
      TextureVertice t7 = new TextureVertice(texLocX + xtd + xtl + xtd, texLocY + ytd);
      TextureVertice t8 = new TextureVertice(texLocX + xtd + xtl + xtl, texLocY + ytd);
      TextureVertice t9 = new TextureVertice(texLocX + xtd + xtl + xtl + xtd, texLocY + ytd);
      TextureVertice t10 = new TextureVertice(texLocX + 0.0F, texLocY + ytd + yth);
      TextureVertice t11 = new TextureVertice(texLocX + xtd, texLocY + ytd + yth);
      TextureVertice t12 = new TextureVertice(texLocX + xtd + xtl, texLocY + ytd + yth);
      TextureVertice t13 = new TextureVertice(texLocX + xtd + xtl + xtd, texLocY + ytd + yth);
      TextureVertice t14 = new TextureVertice(texLocX + xtd + xtl + xtl + xtd, texLocY + ytd + yth);
      addFace(xpypzn, xnypzn, xnypzp, xpypzp, t6, t2, t1, t5);
      addFace(xpynzp, xnynzp, xnynzn, xpynzn, t6, t2, t3, t8);
      addFace(xnypzp, xnynzp, xpynzp, xpypzp, t4, t10, t11, t5);
      addFace(xpypzp, xpynzp, xpynzn, xpypzn, t5, t11, t12, t6);
      addFace(xpypzn, xpynzn, xnynzn, xnypzn, t6, t12, t13, t7);
      addFace(xnypzn, xnynzn, xnynzp, xnypzp, t7, t13, t14, t9);
   }

   public static void drawPoint(Vertice v1, float size) {
      GL11.glPushMatrix();
      GL11.glTranslatef(v1.x, v1.y, v1.z);
      GL11.glEnable(32826);
      size /= 2.0F;
      Tessellator t = Tessellator.field_78398_a;
      GL11.glRotatef(180.0F - Minecraft.func_71410_x().field_71439_g.field_70177_z, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(90.0F - Minecraft.func_71410_x().field_71439_g.field_70125_A, 1.0F, 0.0F, 0.0F);
      t.func_78382_b();
      t.func_78375_b(0.0F, 1.0F, 0.0F);
      t.func_78374_a(-size, 0.0, -size, 0.0, 0.0);
      t.func_78374_a(size, 0.0, -size, 1.0, 0.0);
      t.func_78374_a(size, 0.0, size, 1.0, 1.0);
      t.func_78374_a(-size, 0.0, size, 0.0, 1.0);
      t.func_78381_a();
      GL11.glDisable(32826);
      GL11.glPopMatrix();
   }

   public static void drawLine(Vertice v1, float size1, Vertice v2, float size2) {
      GL11.glPushMatrix();
      GL11.glTranslatef(v1.x, v1.y, v1.z);
      GL11.glEnable(32826);
      size1 /= 2.0F;
      size2 /= 2.0F;
      Tessellator t = Tessellator.field_78398_a;
      GL11.glRotatef(180.0F - Minecraft.func_71410_x().field_71439_g.field_70177_z, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(90.0F - Minecraft.func_71410_x().field_71439_g.field_70125_A, 1.0F, 0.0F, 0.0F);
      t.func_78382_b();
      t.func_78375_b(0.0F, 1.0F, 0.0F);
      t.func_78374_a(-size1, 0.0, -size1, 0.0, 0.0);
      t.func_78374_a(size1, 0.0, -size1, 1.0, 0.0);
      t.func_78374_a(size1, 0.0, size1, 1.0, 1.0);
      t.func_78374_a(-size1, 0.0, size1, 0.0, 1.0);
      t.func_78381_a();
      GL11.glDisable(32826);
      GL11.glPopMatrix();
   }

   public static void renderBox(float length, float height, float depth) {
      GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
      float hl = length / 2.0F;
      float hh = height / 2.0F;
      float hd = depth / 2.0F;
      Vertice xpypzp = new Vertice(hl, hh, hd);
      Vertice xnypzp = new Vertice(-hl, hh, hd);
      Vertice xnypzn = new Vertice(-hl, hh, -hd);
      Vertice xpypzn = new Vertice(hl, hh, -hd);
      Vertice xpynzp = new Vertice(hl, -hh, hd);
      Vertice xnynzp = new Vertice(-hl, -hh, hd);
      Vertice xnynzn = new Vertice(-hl, -hh, -hd);
      Vertice xpynzn = new Vertice(hl, -hh, -hd);
      addFace(xpypzn, xnypzn, xnypzp, xpypzp);
      addFace(xpynzp, xnynzp, xnynzn, xpynzn);
      addFace(xnypzp, xnynzp, xpynzp, xpypzp);
      addFace(xpypzp, xpynzp, xpynzn, xpypzn);
      addFace(xpypzn, xpynzn, xnynzn, xnypzn);
      addFace(xnypzn, xnynzn, xnynzp, xnypzp);
   }

   public static void addFace(Vertice v1, Vertice v2, Vertice v3, Vertice v4, TextureVertice t1, TextureVertice t2, TextureVertice t3, TextureVertice t4) {
      Tessellator t = Tessellator.field_78398_a;
      Vertice mv = new Vertice((v1.x + v2.x + v3.x + v4.x) / 4.0F, (v1.y + v2.y + v3.y + v4.y) / 4.0F, (v1.z + v2.z + v3.z + v4.z) / 4.0F);
      TextureVertice mt = new TextureVertice((t1.x + t2.x + t3.x + t4.x) / 4.0F, (t1.y + t2.y + t3.y + t4.y) / 4.0F);
      t.func_78371_b(4);
      addVertice(v1, t1);
      addVertice(v2, t2);
      addVertice(mv, mt);
      t.func_78381_a();
      t.func_78371_b(4);
      addVertice(v2, t2);
      addVertice(v3, t3);
      addVertice(mv, mt);
      t.func_78381_a();
      t.func_78371_b(4);
      addVertice(v3, t3);
      addVertice(v4, t4);
      addVertice(mv, mt);
      t.func_78381_a();
      t.func_78371_b(4);
      addVertice(v4, t4);
      addVertice(v1, t1);
      addVertice(mv, mt);
      t.func_78381_a();
   }

   public static void addFace(Vertice v1, Vertice v2, Vertice v3, Vertice v4) {
      Tessellator t = Tessellator.field_78398_a;
      t.func_78371_b(7);
      addVertice(v1);
      addVertice(v2);
      addVertice(v3);
      addVertice(v4);
      t.func_78381_a();
   }

   public static void addFace(Vertice v1, Vertice v2, Vertice v3, Vertice v4, TextureFace t) {
      Tessellator tess = Tessellator.field_78398_a;
      tess.func_78382_b();
      addVertice(v1, t.v1);
      addVertice(v2, t.v2);
      addVertice(v3, t.v3);
      addVertice(v4, t.v4);
      tess.func_78381_a();
   }

   public static void addFace(Vertice v1, Vertice v2, Vertice v3, Vertice v4, float par5, float par6, float par7, float par8) {
      Tessellator t = Tessellator.field_78398_a;
      t.func_78382_b();
      addVertice(v1, par5, par8);
      addVertice(v2, par6, par8);
      addVertice(v3, par6, par7);
      addVertice(v4, par5, par7);
      t.func_78381_a();
   }

   public static void addTri(Vertice v1, Vertice v2, Vertice v3) {
      Tessellator t = Tessellator.field_78398_a;
      t.func_78371_b(6);
      addVertice(v3);
      addVertice(v1);
      addVertice(v2);
      t.func_78381_a();
   }

   public static void addVertice(Vertice v, TextureVertice t) {
      Tessellator tessellator = Tessellator.field_78398_a;
      tessellator.func_78374_a(v.x, v.y, v.z, t.x, t.y);
   }

   public static void addVertice(Vertice v, float x, float y) {
      Tessellator tessellator = Tessellator.field_78398_a;
      tessellator.func_78374_a(v.x, v.y, v.z, x, y);
   }

   public static void addVertice(Vertice v) {
      Tessellator tessellator = Tessellator.field_78398_a;
      tessellator.func_78377_a(v.x, v.y, v.z);
   }
}
