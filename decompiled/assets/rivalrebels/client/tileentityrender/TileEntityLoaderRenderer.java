package assets.rivalrebels.client.tileentityrender;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.model.ModelLoader;
import assets.rivalrebels.client.objfileloader.ModelFromObj;
import assets.rivalrebels.common.tileentity.TileEntityLoader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class TileEntityLoaderRenderer extends TileEntitySpecialRenderer {
   private ModelLoader loaderModel = new ModelLoader();
   private ModelFromObj tube;

   public TileEntityLoaderRenderer() {
      try {
         this.tube = ModelFromObj.readObjFile("l.obj");
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public void renderLoaderAt(TileEntityLoader tile, double par2, double par4, double par6, float par8) {
      GL11.glEnable(2896);
      GL11.glPushMatrix();
      GL11.glTranslatef((float)par2 + 0.5F, (float)par4 + 0.5F, (float)par6 + 0.5F);
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etloader);
      int var9 = tile.func_145832_p();
      short var11 = 0;
      if (var9 == 2) {
         var11 = 90;
      }

      if (var9 == 3) {
         var11 = -90;
      }

      if (var9 == 4) {
         var11 = 180;
      }

      if (var9 == 5) {
         var11 = 0;
      }

      GL11.glRotatef(var11, 0.0F, 1.0F, 0.0F);
      this.loaderModel.renderA();
      this.loaderModel.renderB((float)tile.slide);
      GL11.glPopMatrix();

      for (int i = 0; i < tile.machines.getSize(); i++) {
         GL11.glPushMatrix();
         GL11.glTranslatef((float)par2 + 0.5F, (float)par4 + 0.5F, (float)par6 + 0.5F);
         int xdif = tile.machines.get(i).field_145851_c - tile.field_145851_c;
         int zdif = tile.machines.get(i).field_145849_e - tile.field_145849_e;
         GL11.glRotated(-90.0 + Math.atan2(xdif, zdif) / Math.PI * 180.0, 0.0, 1.0, 0.0);
         GL11.glTranslatef(-1.0F, -0.4F, 0.0F);
         Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.ettube);
         GL11.glScaled(0.5, 0.15, 0.15);
         int dist = (int)Math.sqrt(xdif * xdif + zdif * zdif);

         for (int d = 0; d < dist; d++) {
            GL11.glTranslatef(2.0F, 0.0F, 0.0F);
            this.tube.render();
         }

         GL11.glPopMatrix();
      }
   }

   public void func_147500_a(TileEntity par1TileEntity, double par2, double par4, double par6, float par8) {
      this.renderLoaderAt((TileEntityLoader)par1TileEntity, par2, par4, par6, par8);
   }
}
