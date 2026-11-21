package assets.rivalrebels.client.tileentityrender;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.renderentity.RenderNuke;
import assets.rivalrebels.common.tileentity.TileEntityNuclearBomb;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class TileEntityNuclearBombRenderer extends TileEntitySpecialRenderer {
   public void renderAModelAt(TileEntityNuclearBomb tile, double d, double d1, double d2, float f) {
      GL11.glEnable(2896);
      GL11.glPushMatrix();
      GL11.glTranslatef((float)d + 0.5F, (float)d1 + 0.5F, (float)d2 + 0.5F);
      GL11.glScalef(RivalRebels.nukeScale, RivalRebels.nukeScale, RivalRebels.nukeScale);
      int metadata = tile.func_145832_p();
      if (metadata == 0) {
         GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
      }

      if (metadata == 1) {
         GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
      }

      if (metadata == 2) {
         GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
      }

      if (metadata == 3) {
         GL11.glRotatef(0.0F, 0.0F, 1.0F, 0.0F);
      }

      if (metadata == 4) {
         GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
      }

      if (metadata == 5) {
         GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
      }

      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etwacknuke);
      RenderNuke.model.renderAll();
      GL11.glPopMatrix();
   }

   public void func_147500_a(TileEntity tileentity, double d, double d1, double d2, float f) {
      this.renderAModelAt((TileEntityNuclearBomb)tileentity, d, d1, d2, f);
   }
}
