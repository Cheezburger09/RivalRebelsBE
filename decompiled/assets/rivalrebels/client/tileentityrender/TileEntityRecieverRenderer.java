package assets.rivalrebels.client.tileentityrender;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.objfileloader.ModelFromObj;
import assets.rivalrebels.common.tileentity.TileEntityReciever;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class TileEntityRecieverRenderer extends TileEntitySpecialRenderer {
   public static ModelFromObj base;
   public static ModelFromObj arm;
   public static ModelFromObj adsdragon;

   public TileEntityRecieverRenderer() {
      try {
         base = ModelFromObj.readObjFile("p.obj");
         arm = ModelFromObj.readObjFile("q.obj");
         adsdragon = ModelFromObj.readObjFile("r.obj");
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public void renderAModelAt(TileEntityReciever tile, double x, double y, double z, float f) {
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etreciever);
      GL11.glPushMatrix();
      GL11.glTranslated(x + 0.5, y, z + 0.5);
      GL11.glEnable(3553);
      GL11.glEnable(2896);
      int m = tile.func_145832_p();
      short r = 0;
      if (m == 2) {
         r = 0;
      }

      if (m == 3) {
         r = 180;
      }

      if (m == 4) {
         r = 90;
      }

      if (m == 5) {
         r = -90;
      }

      GL11.glPushMatrix();
      GL11.glRotatef(r, 0.0F, 1.0F, 0.0F);
      GL11.glTranslated(0.0, 0.0, 0.5);
      base.render();
      if (tile.hasWeapon) {
         GL11.glTranslated(0.0, 0.75, -1.2600000000000002);
         GL11.glRotated(tile.yaw - r, 0.0, 1.0, 0.0);
         arm.render();
         GL11.glRotated(tile.pitch, 1.0, 0.0, 0.0);
         Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etadsdragon);
         adsdragon.render();
      }

      GL11.glPopMatrix();
      GL11.glPopMatrix();
   }

   public void func_147500_a(TileEntity tileentity, double d, double d1, double d2, float f) {
      this.renderAModelAt((TileEntityReciever)tileentity, d, d1, d2, f);
   }
}
