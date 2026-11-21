package assets.rivalrebels.client.model;

import assets.rivalrebels.client.renderhelper.RenderHelper;
import assets.rivalrebels.client.renderhelper.Vertice;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.Tessellator;

@SideOnly(Side.CLIENT)
public class ModelJump {
   float s = 0.501F;
   float t = 0.25F;
   Vertice v1 = new Vertice(this.s, this.t, this.s);
   Vertice v2 = new Vertice(this.s, this.t, -this.s);
   Vertice v3 = new Vertice(-this.s, this.t, -this.s);
   Vertice v4 = new Vertice(-this.s, this.t, this.s);
   Vertice v5 = new Vertice(this.s, -this.t, this.s);
   Vertice v6 = new Vertice(this.s, -this.t, -this.s);
   Vertice v7 = new Vertice(-this.s, -this.t, -this.s);
   Vertice v8 = new Vertice(-this.s, -this.t, this.s);

   public void renderModel() {
      Tessellator tessellator = Tessellator.field_78398_a;
      tessellator.func_78382_b();
      RenderHelper.addVertice(this.v2, 0.0F, 0.0F);
      RenderHelper.addVertice(this.v1, 1.0F, 0.0F);
      RenderHelper.addVertice(this.v4, 1.0F, 1.0F);
      RenderHelper.addVertice(this.v3, 0.0F, 1.0F);
      tessellator.func_78381_a();
      tessellator.func_78382_b();
      RenderHelper.addVertice(this.v5, 0.0F, 0.0F);
      RenderHelper.addVertice(this.v6, 1.0F, 0.0F);
      RenderHelper.addVertice(this.v7, 1.0F, 1.0F);
      RenderHelper.addVertice(this.v8, 0.0F, 1.0F);
      tessellator.func_78381_a();
   }
}
