package assets.rivalrebels.client.tileentityrender;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.model.ModelNukeCrate;
import assets.rivalrebels.common.tileentity.TileEntityNukeCrate;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

public class TileEntityNukeCrateRenderer extends TileEntitySpecialRenderer {
   private ModelNukeCrate model = new ModelNukeCrate();

   public void renderAModelAt(TileEntityNukeCrate tile, double d, double d1, double d2, float f) {
      GL11.glEnable(2896);
      GL11.glPushMatrix();
      GL11.glTranslatef((float)d + 0.5F, (float)d1 + 0.5F, (float)d2 + 0.5F);
      int metadata = tile.func_145832_p();
      if (metadata == 0) {
         GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
      }

      if (metadata == 2) {
         GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
      }

      if (metadata == 3) {
         GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
      }

      if (metadata == 4) {
         GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
      }

      if (metadata == 5) {
         GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);
      }

      if (tile.func_145831_w().func_147439_a(tile.field_145851_c, tile.field_145848_d, tile.field_145849_e) == RivalRebels.nukeCrateBottom) {
         Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.btnukebottom);
      }

      if (tile.func_145831_w().func_147439_a(tile.field_145851_c, tile.field_145848_d, tile.field_145849_e) == RivalRebels.nukeCrateTop) {
         Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.btnuketop);
      }

      this.model.renderModelA();
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.btcrate);
      this.model.renderModelB();
      GL11.glPopMatrix();
   }

   public void func_147500_a(TileEntity tileentity, double d, double d1, double d2, float f) {
      this.renderAModelAt((TileEntityNukeCrate)tileentity, d, d1, d2, f);
   }
}
