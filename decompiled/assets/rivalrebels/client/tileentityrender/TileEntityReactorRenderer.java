package assets.rivalrebels.client.tileentityrender;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.model.ModelLaptop;
import assets.rivalrebels.client.model.ModelReactor;
import assets.rivalrebels.client.model.RenderLibrary;
import assets.rivalrebels.client.objfileloader.ModelFromObj;
import assets.rivalrebels.common.tileentity.TileEntityMachineBase;
import assets.rivalrebels.common.tileentity.TileEntityReactor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class TileEntityReactorRenderer extends TileEntitySpecialRenderer {
   private ModelReactor mr = new ModelReactor();
   private ModelLaptop ml = new ModelLaptop();
   private ModelFromObj mo;

   public TileEntityReactorRenderer() {
      try {
         this.mo = ModelFromObj.readObjFile("a.obj");
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public void renderAModelAt(TileEntityReactor tile, double d, double d1, double d2, float f) {
      GL11.glEnable(2896);
      int var9 = tile.func_145832_p();
      short var11 = 0;
      if (var9 == 2) {
         var11 = 180;
      }

      if (var9 == 3) {
         var11 = 0;
      }

      if (var9 == 4) {
         var11 = -90;
      }

      if (var9 == 5) {
         var11 = 90;
      }

      GL11.glPushMatrix();
      GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.1875F, (float)d2 + 0.5F);
      GL11.glRotatef(var11, 0.0F, 1.0F, 0.0F);
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etlaptop);
      this.ml.renderModel((float)(-tile.slide));
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etscreen);
      this.ml.renderScreen((float)(-tile.slide));
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef((float)d + 0.5F, (float)d1 + 0.5F, (float)d2 + 0.5F);
      GL11.glRotatef(var11, 0.0F, 1.0F, 0.0F);
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etreactor);
      this.mr.renderModel();
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etelectrode);
      GL11.glTranslatef(0.0F, 2.0F, -0.125F);
      GL11.glScalef(0.2F, 0.2F, 0.2F);
      this.mo.render();
      GL11.glPopMatrix();

      for (int i = 0; i < tile.machines.getSize(); i++) {
         TileEntityMachineBase temb = (TileEntityMachineBase)tile.machines.get(i);
         if (temb.powerGiven > 0.0F) {
            float radius = temb.powerGiven * temb.powerGiven / 40000.0F;
            radius = (float)(radius + 0.03);
            int steps = 2;
            if (radius > 0.05) {
               steps++;
            }

            if (radius > 0.1) {
               steps++;
            }

            if (radius > 0.15) {
               steps++;
            }

            if (radius > 0.25) {
               radius = 0.25F;
            }

            RenderLibrary.instance
               .renderModel(
                  (float)d + 0.5F,
                  (float)d1 + 2.5F,
                  (float)d2 + 0.5F,
                  temb.field_145851_c - tile.field_145851_c,
                  temb.field_145848_d - tile.field_145848_d - 2.5F,
                  temb.field_145849_e - tile.field_145849_e,
                  0.5F,
                  radius,
                  steps,
                  temb.edist / 2.0F,
                  0.1F,
                  0.45F,
                  0.45F,
                  0.5F,
                  0.5F
               );
         }
      }
   }

   public void func_147500_a(TileEntity tileentity, double d, double d1, double d2, float f) {
      this.renderAModelAt((TileEntityReactor)tileentity, d, d1, d2, f);
   }
}
