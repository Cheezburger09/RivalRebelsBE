package assets.rivalrebels.client.renderentity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.model.ModelBlastRing;
import assets.rivalrebels.client.renderhelper.Vertice;
import assets.rivalrebels.common.entity.EntityNuclearBlast;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderNuclearBlast extends Render {
   private float ring1 = 0.0F;
   private float ring2 = 0.0F;
   private float ring3 = 0.0F;
   private float height = 0.0F;
   static ModelBlastRing model;
   private int textureCoordx = 0;
   private int textureCoordy = 0;

   public RenderNuclearBlast() {
      model = new ModelBlastRing();
   }

   public void renderNuclearBlast(EntityNuclearBlast enb, double x, double y, double z, float yaw, float pitch) {
      GL11.glPushMatrix();
      if (enb.field_70173_aa == 0) {
         this.ring1 = 0.0F;
         this.ring2 = 0.0F;
         this.ring3 = 0.0F;
         this.height = 0.0F;
         this.textureCoordx = enb.field_70170_p.field_73012_v.nextInt(64);
      }

      this.ring1 = (float)(this.ring1 + 0.02);
      this.ring2 = (float)(this.ring2 + Math.sin(this.ring1) * 0.01);
      this.ring3 = (float)(this.ring3 - Math.sin(this.ring1) * 0.01);
      if (this.ring2 < 6.0F) {
         this.ring2 = (float)(this.ring2 + 0.1);
      }

      if (this.ring3 < 8.0F) {
         this.ring3 = (float)(this.ring3 + 0.1);
      }

      if (this.height < 8.0F) {
         this.height = (float)(this.height + 0.1);
      }

      if (enb.field_70173_aa < 600) {
         model.renderModel(RivalRebels.shroomScale * this.ring1 * 15.0F, 64, 4.0F, 0.5F, 0.0F, 0.0F, 0.0F, (float)x, (float)y - 3.0F, (float)z);
         model.renderModel(RivalRebels.shroomScale * this.ring2, 32, 1.0F, 0.5F, 0.0F, 0.0F, 0.0F, (float)x, (float)y + this.height + this.ring3, (float)z);
         model.renderModel(
            RivalRebels.shroomScale * this.ring3, 32, 2.0F, 0.5F, 0.0F, 0.0F, 0.0F, (float)x, (float)y + this.height + 7.0F + this.ring2, (float)z
         );
         if (enb.field_70173_aa > 550) {
            this.ring2 = (float)(this.ring2 + 0.1);
            this.ring3 = (float)(this.ring3 + 0.1);
         }
      } else {
         this.ring1 = 0.0F;
         this.ring2 = 0.0F;
         this.ring3 = 0.0F;
         this.height = 0.0F;
      }

      this.textureCoordy--;
      if (this.textureCoordy <= 0) {
         this.textureCoordy = 128;
      }

      float par5 = (this.textureCoordx + 128) / 128.0F;
      float par6 = this.textureCoordx / 128.0F;
      float par7 = (this.textureCoordy + 128) / 128.0F;
      float par8 = this.textureCoordy / 128.0F;
      GL11.glPushMatrix();
      GL11.glTranslated(x, y - 10.0, z);
      GL11.glScalef(RivalRebels.shroomScale, RivalRebels.shroomScale, RivalRebels.shroomScale);
      GL11.glDisable(2896);
      GL11.glEnable(32826);
      GL11.glScalef(0.5F + (float)enb.field_70181_x * 0.3F, 2.6F + (float)enb.field_70181_x * 0.3F, 0.5F + (float)enb.field_70181_x * 0.3F);
      if (enb.field_70159_w == 1.0) {
         Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.ettroll);
      } else {
         Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etradiation);
      }

      int size = (int)enb.field_70181_x;
      Vertice pxv1 = new Vertice(4.0F, 0.0F - size * 2.5F, 0.0F);
      Vertice nxv1 = new Vertice(-4.0F, 0.0F - size * 2.5F, 0.0F);
      Vertice pzv1 = new Vertice(0.0F, 0.0F - size * 2.5F, 4.0F);
      Vertice nzv1 = new Vertice(0.0F, 0.0F - size * 2.5F, -4.0F);
      Vertice pxv2 = new Vertice(2.0F, 1.5F - size * 2.0F, 0.0F);
      Vertice nxv2 = new Vertice(-2.0F, 1.5F - size * 2.0F, 0.0F);
      Vertice pzv2 = new Vertice(0.0F, 1.5F - size * 2.0F, 2.0F);
      Vertice nzv2 = new Vertice(0.0F, 1.5F - size * 2.0F, -2.0F);
      Vertice pxv3 = new Vertice(1.5F, 3.5F - size * 1.5F, 0.0F);
      Vertice nxv3 = new Vertice(-1.5F, 3.5F - size * 1.5F, 0.0F);
      Vertice pzv3 = new Vertice(0.0F, 3.5F - size * 1.5F, 1.5F);
      Vertice nzv3 = new Vertice(0.0F, 3.5F - size * 1.5F, -1.5F);
      Vertice pxv4 = new Vertice(1.5F, 6.5F - size * 1.0F, 0.0F);
      Vertice nxv4 = new Vertice(-1.5F, 6.5F - size * 1.0F, 0.0F);
      Vertice pzv4 = new Vertice(0.0F, 6.5F - size * 1.0F, 1.5F);
      Vertice nzv4 = new Vertice(0.0F, 6.5F - size * 1.0F, -1.5F);
      Vertice pxv5 = new Vertice(2.0F, 9.5F - size * 0.5F, 0.0F);
      Vertice nxv5 = new Vertice(-2.0F, 9.5F - size * 0.5F, 0.0F);
      Vertice pzv5 = new Vertice(0.0F, 9.5F - size * 0.5F, 2.0F);
      Vertice nzv5 = new Vertice(0.0F, 9.5F - size * 0.5F, -2.0F);
      Vertice pxv6 = new Vertice(3.0F, 11.0F, 0.0F);
      Vertice nxv6 = new Vertice(-3.0F, 11.0F, 0.0F);
      Vertice pzv6 = new Vertice(0.0F, 11.0F, 3.0F);
      Vertice nzv6 = new Vertice(0.0F, 11.0F, -3.0F);
      Vertice pxv7 = new Vertice(16.0F, 10.0F, 0.0F);
      Vertice nxv7 = new Vertice(-16.0F, 10.0F, 0.0F);
      Vertice pzv7 = new Vertice(0.0F, 10.0F, 16.0F);
      Vertice nzv7 = new Vertice(0.0F, 10.0F, -16.0F);
      Vertice ppv7 = new Vertice(8.0F, 10.0F, 8.0F);
      Vertice npv7 = new Vertice(-8.0F, 10.0F, 8.0F);
      Vertice pnv7 = new Vertice(8.0F, 10.0F, -8.0F);
      Vertice nnv7 = new Vertice(-8.0F, 10.0F, -8.0F);
      Vertice pxv8 = new Vertice(32.0F, 12.0F, 0.0F);
      Vertice nxv8 = new Vertice(-32.0F, 12.0F, 0.0F);
      Vertice pzv8 = new Vertice(0.0F, 12.0F, 32.0F);
      Vertice nzv8 = new Vertice(0.0F, 12.0F, -32.0F);
      Vertice ppv8 = new Vertice(22.5F, 12.0F, 22.5F);
      Vertice npv8 = new Vertice(-22.5F, 12.0F, 22.5F);
      Vertice pnv8 = new Vertice(22.5F, 12.0F, -22.5F);
      Vertice nnv8 = new Vertice(-22.5F, 12.0F, -22.5F);
      Vertice pxv9 = new Vertice(16.0F, 13.0F, 0.0F);
      Vertice nxv9 = new Vertice(-16.0F, 13.0F, 0.0F);
      Vertice pzv9 = new Vertice(0.0F, 13.0F, 16.0F);
      Vertice nzv9 = new Vertice(0.0F, 13.0F, -16.0F);
      Vertice ppv9 = new Vertice(11.5F, 13.0F, 11.5F);
      Vertice npv9 = new Vertice(-11.5F, 13.0F, 11.5F);
      Vertice pnv9 = new Vertice(11.5F, 13.0F, -11.5F);
      Vertice nnv9 = new Vertice(-11.5F, 13.0F, -11.5F);
      Vertice v9 = new Vertice(0.0F, 13.0F, 0.0F);
      int time = size * 10;
      if (enb.field_70173_aa > 0 && enb.field_70173_aa < 600 + time) {
         this.addFace(pxv1, nzv1, nzv2, pxv2, par5, par6, par7, par8);
         this.addFace(pzv1, pxv1, pxv2, pzv2, par5, par6, par7, par8);
         this.addFace(nxv1, pzv1, pzv2, nxv2, par5, par6, par7, par8);
         this.addFace(nzv1, nxv1, nxv2, nzv2, par5, par6, par7, par8);
      }

      if (enb.field_70173_aa > 10 && enb.field_70173_aa < 610 + time) {
         this.addFace(pxv2, nzv2, nzv3, pxv3, par5, par6, par7, par8);
         this.addFace(pzv2, pxv2, pxv3, pzv3, par5, par6, par7, par8);
         this.addFace(nxv2, pzv2, pzv3, nxv3, par5, par6, par7, par8);
         this.addFace(nzv2, nxv2, nxv3, nzv3, par5, par6, par7, par8);
      }

      if (enb.field_70173_aa > 20 && enb.field_70173_aa < 620 + time) {
         this.addFace(pxv3, nzv3, nzv4, pxv4, par5, par6, par7, par8);
         this.addFace(pzv3, pxv3, pxv4, pzv4, par5, par6, par7, par8);
         this.addFace(nxv3, pzv3, pzv4, nxv4, par5, par6, par7, par8);
         this.addFace(nzv3, nxv3, nxv4, nzv4, par5, par6, par7, par8);
      }

      if (enb.field_70173_aa > 30 && enb.field_70173_aa < 630 + time) {
         this.addFace(pxv4, nzv4, nzv5, pxv5, par5, par6, par7, par8);
         this.addFace(pzv4, pxv4, pxv5, pzv5, par5, par6, par7, par8);
         this.addFace(nxv4, pzv4, pzv5, nxv5, par5, par6, par7, par8);
         this.addFace(nzv4, nxv4, nxv5, nzv5, par5, par6, par7, par8);
      }

      if (enb.field_70173_aa > 40 && enb.field_70173_aa < 640 + time) {
         this.addFace(pxv5, nzv5, nzv6, pxv6, par5, par6, par7, par8);
         this.addFace(pzv5, pxv5, pxv6, pzv6, par5, par6, par7, par8);
         this.addFace(nxv5, pzv5, pzv6, nxv6, par5, par6, par7, par8);
         this.addFace(nzv5, nxv5, nxv6, nzv6, par5, par6, par7, par8);
      }

      if (enb.field_70173_aa > 30 && enb.field_70173_aa < 650 + time) {
         this.addFace(pxv6, nzv6, nzv7, pxv7, par6, par5, par8, par7);
         this.addFace(pzv6, pxv6, pxv7, pzv7, par6, par5, par8, par7);
         this.addFace(nxv6, pzv6, pzv7, nxv7, par6, par5, par8, par7);
         this.addFace(nzv6, nxv6, nxv7, nzv7, par6, par5, par8, par7);
      }

      if (enb.field_70173_aa > 20 && enb.field_70173_aa < 650 + time) {
         this.addFace(pzv7, ppv7, ppv8, pzv8, par6, par5, par8, par7);
         this.addFace(ppv7, pxv7, pxv8, ppv8, par6, par5, par8, par7);
         this.addFace(pxv7, pnv7, pnv8, pxv8, par6, par5, par8, par7);
         this.addFace(pnv7, nzv7, nzv8, pnv8, par6, par5, par8, par7);
         this.addFace(nzv7, nnv7, nnv8, nzv8, par6, par5, par8, par7);
         this.addFace(nnv7, nxv7, nxv8, nnv8, par6, par5, par8, par7);
         this.addFace(nxv7, npv7, npv8, nxv8, par6, par5, par8, par7);
         this.addFace(npv7, pzv7, pzv8, npv8, par6, par5, par8, par7);
      }

      if (enb.field_70173_aa > 10 && enb.field_70173_aa < 650 + time) {
         this.addFace(pzv8, ppv8, ppv9, pzv9, par6, par5, par8, par7);
         this.addFace(ppv8, pxv8, pxv9, ppv9, par6, par5, par8, par7);
         this.addFace(pxv8, pnv8, pnv9, pxv9, par6, par5, par8, par7);
         this.addFace(pnv8, nzv8, nzv9, pnv9, par6, par5, par8, par7);
         this.addFace(nzv8, nnv8, nnv9, nzv9, par6, par5, par8, par7);
         this.addFace(nnv8, nxv8, nxv9, nnv9, par6, par5, par8, par7);
         this.addFace(nxv8, npv8, npv9, nxv9, par6, par5, par8, par7);
         this.addFace(npv8, pzv8, pzv9, npv9, par6, par5, par8, par7);
         this.addFace(pxv6, pzv6, nxv6, nzv6, par6, par5, par8, par7);
         this.addTri(ppv9, v9, pzv9, par6, par5, par8, par7);
         this.addTri(pxv9, v9, ppv9, par6, par5, par8, par7);
         this.addTri(pnv9, v9, pxv9, par6, par5, par8, par7);
         this.addTri(nzv9, v9, pnv9, par6, par5, par8, par7);
         this.addTri(nnv9, v9, nzv9, par6, par5, par8, par7);
         this.addTri(nxv9, v9, nnv9, par6, par5, par8, par7);
         this.addTri(npv9, v9, nxv9, par6, par5, par8, par7);
         this.addTri(pzv9, v9, npv9, par6, par5, par8, par7);
      }

      GL11.glEnable(2896);
      GL11.glPopMatrix();
      GL11.glPopMatrix();
   }

   public void func_76986_a(Entity entityNuclearBlast, double x, double y, double z, float yaw, float pitch) {
      this.renderNuclearBlast((EntityNuclearBlast)entityNuclearBlast, x, y, z, yaw, pitch);
   }

   private void addFace(Vertice v1, Vertice v2, Vertice v3, Vertice v4, float par5, float par6, float par7, float par8) {
      Tessellator t = Tessellator.field_78398_a;
      t.func_78382_b();
      this.addVertice(v1, par5, par8);
      this.addVertice(v2, par6, par8);
      this.addVertice(v3, par6, par7);
      this.addVertice(v4, par5, par7);
      t.func_78381_a();
   }

   private void addTri(Vertice v1, Vertice v2, Vertice v3, float par5, float par6, float par7, float par8) {
      Tessellator t = Tessellator.field_78398_a;
      t.func_78371_b(6);
      this.addVertice(v3, par5, par8);
      this.addVertice(v1, par6, par8);
      this.addVertice(v2, par6, par7);
      t.func_78381_a();
   }

   private void addVertice(Vertice v, double t, double t2) {
      Tessellator tessellator = Tessellator.field_78398_a;
      tessellator.func_78374_a(v.x, v.y, v.z, t, t2);
   }

   protected ResourceLocation func_110775_a(Entity entity) {
      return null;
   }
}
