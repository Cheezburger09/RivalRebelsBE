package assets.rivalrebels.client.tileentityrender;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.model.ModelJump;
import assets.rivalrebels.common.tileentity.TileEntityJumpBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class TileEntityJumpBlockRenderer extends TileEntitySpecialRenderer {
   private ModelJump model = new ModelJump();

   public void renderAModelAt(TileEntityJumpBlock tile, double d, double d1, double d2, float f) {
      GL11.glEnable(2896);
      GL11.glPushMatrix();
      GL11.glTranslatef((float)d + 0.5F, (float)d1 + 0.5F, (float)d2 + 0.5F);
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.btcrate);
      this.model.renderModel();
      GL11.glPopMatrix();
   }

   public void func_147500_a(TileEntity tileentity, double d, double d1, double d2, float f) {
      this.renderAModelAt((TileEntityJumpBlock)tileentity, d, d1, d2, f);
   }
}
