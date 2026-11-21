package assets.rivalrebels.client.model;

import assets.rivalrebels.client.renderhelper.Vertice;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ModelSteel {
   Tessellator tessellator = Tessellator.field_78398_a;
   float s = 0.5F;
   Vertice v1 = new Vertice(this.s, this.s, this.s);
   Vertice v2 = new Vertice(this.s, this.s, -this.s);
   Vertice v3 = new Vertice(-this.s, this.s, -this.s);
   Vertice v4 = new Vertice(-this.s, this.s, this.s);
   Vertice v5 = new Vertice(this.s, -this.s, this.s);
   Vertice v6 = new Vertice(this.s, -this.s, -this.s);
   Vertice v7 = new Vertice(-this.s, -this.s, -this.s);
   Vertice v8 = new Vertice(-this.s, -this.s, this.s);

   public void renderModel() {
      GL11.glPushMatrix();
      GL11.glDisable(2896);
      this.tessellator.func_78382_b();
      this.addVertex(this.v1, 0.0, 0.0, true);
      this.addVertex(this.v5, 1.0, 0.0, true);
      this.addVertex(this.v8, 1.0, 1.0, true);
      this.addVertex(this.v4, 0.0, 1.0, true);
      this.tessellator.func_78381_a();
      this.tessellator.func_78382_b();
      this.addVertex(this.v4, 0.0, 0.0, true);
      this.addVertex(this.v8, 1.0, 0.0, true);
      this.addVertex(this.v7, 1.0, 1.0, true);
      this.addVertex(this.v3, 0.0, 1.0, true);
      this.tessellator.func_78381_a();
      this.tessellator.func_78382_b();
      this.addVertex(this.v3, 0.0, 0.0, true);
      this.addVertex(this.v7, 1.0, 0.0, true);
      this.addVertex(this.v6, 1.0, 1.0, true);
      this.addVertex(this.v2, 0.0, 1.0, true);
      this.tessellator.func_78381_a();
      this.tessellator.func_78382_b();
      this.addVertex(this.v2, 0.0, 0.0, true);
      this.addVertex(this.v6, 1.0, 0.0, true);
      this.addVertex(this.v5, 1.0, 1.0, true);
      this.addVertex(this.v1, 0.0, 1.0, true);
      this.tessellator.func_78381_a();
      this.tessellator.func_78382_b();
      this.addVertex(this.v4, 0.0, 0.0, true);
      this.addVertex(this.v3, 1.0, 0.0, true);
      this.addVertex(this.v2, 1.0, 1.0, true);
      this.addVertex(this.v1, 0.0, 1.0, true);
      this.tessellator.func_78381_a();
      this.tessellator.func_78382_b();
      this.addVertex(this.v5, 0.0, 0.0, true);
      this.addVertex(this.v6, 1.0, 0.0, true);
      this.addVertex(this.v7, 1.0, 1.0, true);
      this.addVertex(this.v8, 0.0, 1.0, true);
      this.tessellator.func_78381_a();
      GL11.glPopMatrix();
   }

   private void addVertex(Vertice v, double t, double t2, boolean offset) {
      Tessellator tessellator = Tessellator.field_78398_a;
      tessellator.func_78374_a(v.x * 0.999, v.y * 0.999, v.z * 0.999, t, t2);
   }
}
