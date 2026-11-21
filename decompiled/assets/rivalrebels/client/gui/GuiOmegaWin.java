package assets.rivalrebels.client.gui;

import assets.rivalrebels.RivalRebels;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiOmegaWin extends GuiScreen {
   public void func_73866_w_() {
   }

   public boolean func_73868_f() {
      return false;
   }

   public void func_73876_c() {
   }

   public void func_73863_a(int x, int y, float d) {
      Tessellator tessellator = Tessellator.field_78398_a;
      this.func_73732_a(
         this.field_146289_q, StatCollector.func_74838_a("RivalRebels.omegawin.subtitle"), this.field_146294_l / 2, this.field_146295_m / 2 - 120, 16777215
      );
      float scalefactor = 4.0F;
      GL11.glScalef(scalefactor, scalefactor, scalefactor);
      this.func_73732_a(
         this.field_146289_q,
         StatCollector.func_74838_a("RivalRebels.omegawin.title"),
         (int)(this.field_146294_l / 2 / scalefactor),
         (int)((this.field_146295_m / 2 - 100) / scalefactor),
         16777215
      );
      GL11.glScalef(1.0F / scalefactor, 1.0F / scalefactor, 1.0F / scalefactor);
      this.field_146289_q.func_78261_a("Omega: " + RivalRebels.round.getOmegaWins(), this.field_146294_l / 2 - 60, this.field_146295_m / 2 + 70, 4521796);
      this.field_146289_q.func_78261_a("Sigma: " + RivalRebels.round.getSigmaWins(), this.field_146294_l / 2 + 10, this.field_146295_m / 2 + 70, 4474111);
   }
}
