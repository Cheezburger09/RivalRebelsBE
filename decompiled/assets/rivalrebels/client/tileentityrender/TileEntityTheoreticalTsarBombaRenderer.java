package assets.rivalrebels.client.tileentityrender;

import assets.rivalrebels.client.model.ModelTheoreticalTsarBomba;
import assets.rivalrebels.common.tileentity.TileEntityTheoreticalTsarBomba;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class TileEntityTheoreticalTsarBombaRenderer extends TileEntitySpecialRenderer {
   private ModelTheoreticalTsarBomba model = new ModelTheoreticalTsarBomba();

   public void renderAModelAt(TileEntityTheoreticalTsarBomba tile, double d, double d1, double d2, float f) {
      GL11.glDisable(2896);
      GL11.glPushMatrix();
      GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.0F, (float)d2 + 0.5F);
      GL11.glScalef(1.3F, 1.3F, 1.3F);
      int metadata = tile.func_145832_p();
      if (metadata == 2) {
         GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
      }

      if (metadata == 3) {
         GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
      }

      if (metadata == 4) {
         GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
      }

      if (metadata == 5) {
         GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
      }

      this.model.render();
      GL11.glPopMatrix();
   }

   public void func_147500_a(TileEntity tileentity, double d, double d1, double d2, float f) {
      this.renderAModelAt((TileEntityTheoreticalTsarBomba)tileentity, d, d1, d2, f);
   }
}
