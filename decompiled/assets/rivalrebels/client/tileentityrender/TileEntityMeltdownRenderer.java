package assets.rivalrebels.client.tileentityrender;

import assets.rivalrebels.client.model.ModelBlastSphere;
import assets.rivalrebels.common.tileentity.TileEntityMeltDown;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class TileEntityMeltdownRenderer extends TileEntitySpecialRenderer {
   ModelBlastSphere model = new ModelBlastSphere();

   public void renderAModelAt(TileEntityMeltDown tile, double d, double d1, double d2, float f) {
      float fsize = (float)Math.sin(tile.size);
      if (!(fsize <= 0.0F)) {
         GL11.glPushMatrix();
         GL11.glTranslatef((float)d + 0.5F, (float)d1 + 0.5F, (float)d2 + 0.5F);
         GL11.glPushMatrix();
         GL11.glRotatef(tile.size * 50.0F, 0.0F, 1.0F, 0.0F);
         this.model.renderModel(fsize * 5.5F, 1.0F, 1.0F, 1.0F, 0.4F);
         GL11.glRotatef(tile.size * 50.0F, 0.0F, 1.0F, 0.0F);
         this.model.renderModel(fsize * 5.6F, 1.0F, 1.0F, 1.0F, 0.4F);
         GL11.glPopMatrix();
         this.model.renderModel(fsize * 5.9F, 1.0F, 1.0F, 1.0F, 0.4F);
         GL11.glPopMatrix();
      }
   }

   public void func_147500_a(TileEntity tileentity, double d, double d1, double d2, float f) {
      this.renderAModelAt((TileEntityMeltDown)tileentity, d, d1, d2, f);
   }
}
