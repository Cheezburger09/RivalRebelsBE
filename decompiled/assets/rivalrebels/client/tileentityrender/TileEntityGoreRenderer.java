package assets.rivalrebels.client.tileentityrender;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.renderhelper.Vertice;
import assets.rivalrebels.common.tileentity.TileEntityGore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class TileEntityGoreRenderer extends TileEntitySpecialRenderer {
   float s = 0.5F;
   Vertice v1 = new Vertice(this.s, this.s, this.s);
   Vertice v2 = new Vertice(this.s, this.s, -this.s);
   Vertice v3 = new Vertice(-this.s, this.s, -this.s);
   Vertice v4 = new Vertice(-this.s, this.s, this.s);
   Vertice v5 = new Vertice(this.s, -this.s, this.s);
   Vertice v6 = new Vertice(this.s, -this.s, -this.s);
   Vertice v7 = new Vertice(-this.s, -this.s, -this.s);
   Vertice v8 = new Vertice(-this.s, -this.s, this.s);

   public void renderAModelAt(TileEntityGore tile, double x, double y, double z, float f) {
      World world = tile.func_145831_w();
      boolean ceil = world.func_147445_c(tile.field_145851_c, tile.field_145848_d + 1, tile.field_145849_e, false);
      boolean floor = world.func_147445_c(tile.field_145851_c, tile.field_145848_d - 1, tile.field_145849_e, false);
      boolean side1 = world.func_147445_c(tile.field_145851_c, tile.field_145848_d, tile.field_145849_e + 1, false);
      boolean side2 = world.func_147445_c(tile.field_145851_c - 1, tile.field_145848_d, tile.field_145849_e, false);
      boolean side3 = world.func_147445_c(tile.field_145851_c, tile.field_145848_d, tile.field_145849_e - 1, false);
      boolean side4 = world.func_147445_c(tile.field_145851_c + 1, tile.field_145848_d, tile.field_145849_e, false);
      int meta = tile.field_145847_g;
      GL11.glPushMatrix();
      GL11.glTranslatef((float)x + 0.5F, (float)y + 0.5F, (float)z + 0.5F);
      if (meta == 0) {
         Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.btsplash1);
      } else if (meta == 1) {
         Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.btsplash2);
      } else if (meta == 2) {
         Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.btsplash3);
      } else if (meta == 3) {
         Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.btsplash4);
      } else if (meta == 4) {
         Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.btsplash5);
      } else if (meta == 5) {
         Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.btsplash6);
      } else {
         Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.btsplash1);
      }

      GL11.glDisable(2896);
      Tessellator tessellator = Tessellator.field_78398_a;
      if (side1) {
         tessellator.func_78382_b();
         this.addVertex(this.v1, 0.0, 0.0, true);
         this.addVertex(this.v5, 1.0, 0.0, true);
         this.addVertex(this.v8, 1.0, 1.0, true);
         this.addVertex(this.v4, 0.0, 1.0, true);
         tessellator.func_78381_a();
      }

      if (side2) {
         tessellator.func_78382_b();
         this.addVertex(this.v4, 0.0, 0.0, true);
         this.addVertex(this.v8, 1.0, 0.0, true);
         this.addVertex(this.v7, 1.0, 1.0, true);
         this.addVertex(this.v3, 0.0, 1.0, true);
         tessellator.func_78381_a();
      }

      if (side3) {
         tessellator.func_78382_b();
         this.addVertex(this.v3, 0.0, 0.0, true);
         this.addVertex(this.v7, 1.0, 0.0, true);
         this.addVertex(this.v6, 1.0, 1.0, true);
         this.addVertex(this.v2, 0.0, 1.0, true);
         tessellator.func_78381_a();
      }

      if (side4) {
         tessellator.func_78382_b();
         this.addVertex(this.v2, 0.0, 0.0, true);
         this.addVertex(this.v6, 1.0, 0.0, true);
         this.addVertex(this.v5, 1.0, 1.0, true);
         this.addVertex(this.v1, 0.0, 1.0, true);
         tessellator.func_78381_a();
      }

      if (ceil) {
         tessellator.func_78382_b();
         this.addVertex(this.v4, 0.0, 0.0, true);
         this.addVertex(this.v3, 1.0, 0.0, true);
         this.addVertex(this.v2, 1.0, 1.0, true);
         this.addVertex(this.v1, 0.0, 1.0, true);
         tessellator.func_78381_a();
      }

      if (floor) {
         tessellator.func_78382_b();
         this.addVertex(this.v5, 0.0, 0.0, true);
         this.addVertex(this.v6, 1.0, 0.0, true);
         this.addVertex(this.v7, 1.0, 1.0, true);
         this.addVertex(this.v8, 0.0, 1.0, true);
         tessellator.func_78381_a();
      }

      GL11.glPopMatrix();
   }

   public void func_147500_a(TileEntity tileentity, double d, double d1, double d2, float f) {
      this.renderAModelAt((TileEntityGore)tileentity, d, d1, d2, f);
   }

   private void addVertex(Vertice v, double t, double t2, boolean offset) {
      Tessellator tessellator = Tessellator.field_78398_a;
      tessellator.func_78374_a(v.x * 0.999, v.y * 0.999, v.z * 0.999, t, t2);
   }
}
