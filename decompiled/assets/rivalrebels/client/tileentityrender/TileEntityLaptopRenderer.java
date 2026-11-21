package assets.rivalrebels.client.tileentityrender;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.model.ModelLaptop;
import assets.rivalrebels.common.tileentity.TileEntityLaptop;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class TileEntityLaptopRenderer extends TileEntitySpecialRenderer {
   private ModelLaptop model = new ModelLaptop();

   public void renderAModelAt(TileEntityLaptop tile, double d, double d1, double d2, float f) {
      GL11.glDisable(2896);
      GL11.glPushMatrix();
      GL11.glTranslatef((float)d + 0.5F, (float)d1, (float)d2 + 0.5F);
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

      GL11.glRotatef(var11, 0.0F, 1.0F, 0.0F);
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etlaptop);
      this.model.renderModel((float)(-tile.slide));
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etubuntu);
      this.model.renderScreen((float)(-tile.slide));
      GL11.glPopMatrix();
   }

   public void func_147500_a(TileEntity tileentity, double d, double d1, double d2, float f) {
      this.renderAModelAt((TileEntityLaptop)tileentity, d, d1, d2, f);
   }
}
