package assets.rivalrebels.client.tileentityrender;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.model.ModelObjective;
import assets.rivalrebels.common.tileentity.TileEntityOmegaObjective;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class TileEntityOmegaObjectiveRenderer extends TileEntitySpecialRenderer {
   private ModelObjective loaderModel = new ModelObjective();

   public void renderLoaderAt(TileEntityOmegaObjective par1TileEntityLoader, double par2, double par4, double par6, float par8) {
      GL11.glPushMatrix();
      GL11.glTranslatef((float)par2 + 0.5F, (float)par4 + 0.5F, (float)par6 + 0.5F);
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etomegaobj);
      GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
      this.loaderModel.renderA();
      GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
      this.loaderModel.renderB((float)par1TileEntityLoader.slide, 0.375F, 0.34375F, 0.125F, 0.84375F);
      GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);
      this.loaderModel.renderB((float)par1TileEntityLoader.slide, 0.125F, 0.34375F, 0.625F, 0.84375F);
      GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
      this.loaderModel.renderB((float)par1TileEntityLoader.slide, 0.375F, 0.84375F, 0.625F, 0.84375F);
      GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
      this.loaderModel.renderB((float)par1TileEntityLoader.slide, 0.625F, 0.34375F, 0.625F, 0.84375F);
      GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
      this.loaderModel.renderB((float)par1TileEntityLoader.slide, 0.875F, 0.84375F, 0.625F, 0.84375F);
      GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);
      this.loaderModel.renderB((float)par1TileEntityLoader.slide, 0.875F, 0.34375F, 0.625F, 0.84375F);
      GL11.glPopMatrix();
   }

   public void func_147500_a(TileEntity par1TileEntity, double par2, double par4, double par6, float par8) {
      this.renderLoaderAt((TileEntityOmegaObjective)par1TileEntity, par2, par4, par6, par8);
   }
}
