package assets.rivalrebels.client.gui;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.guihelper.GuiButton;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.StatCollector;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class GuiOptiFineWarning extends GuiScreen {
   private final int xSizeOfTexture = 256;
   private final int ySizeOfTexture = 256;
   private int posX;
   private int posY;
   private GuiButton ok;
   private boolean prevclick;
   private int num = 0;
   private int count = 0;

   public void func_73866_w_() {
      this.posX = (this.field_146294_l - 256) / 2;
      this.posY = (this.field_146295_m - 256) / 2;
      this.field_146292_n.clear();
      this.field_146297_k = Minecraft.func_71410_x();
      this.field_146289_q = this.field_146297_k.field_71466_p;
      this.ok = new GuiButton(0, this.posX + 96, this.posY + 203, 60, 11, "RivalRebels.class.done");
      this.field_146292_n.add(this.ok);
   }

   public void func_146282_l() {
   }

   public boolean func_73868_f() {
      return false;
   }

   public void func_73876_c() {
   }

   public void func_73863_a(int x, int y, float d) {
      this.count++;
      if (this.count == 60) {
         this.num = 1 - this.num;
         this.count = 0;
      }

      Tessellator tessellator = Tessellator.field_78398_a;
      float f = 0.00390625F;
      if (this.num == 0) {
         this.field_146297_k.field_71446_o.func_110577_a(RivalRebels.guitwarning0);
      }

      if (this.num == 1) {
         this.field_146297_k.field_71446_o.func_110577_a(RivalRebels.guitwarning1);
      }

      tessellator.func_78382_b();
      tessellator.func_78374_a(this.posX, this.posY + 256, this.field_73735_i, 0.0, 256.0F * f);
      tessellator.func_78374_a(this.posX + 256, this.posY + 256, this.field_73735_i, 256.0F * f, 256.0F * f);
      tessellator.func_78374_a(this.posX + 256, this.posY, this.field_73735_i, 256.0F * f, 0.0);
      tessellator.func_78374_a(this.posX, this.posY, this.field_73735_i, 0.0, 0.0);
      tessellator.func_78381_a();
      float scalefactor = 4.0F;
      GL11.glScalef(scalefactor, scalefactor, scalefactor);
      this.func_73732_a(
         this.field_146289_q,
         StatCollector.func_74838_a("RivalRebels.WARNING"),
         (int)(this.field_146294_l / 2 / scalefactor),
         (int)((this.field_146295_m / 2 - 100) / scalefactor),
         16777215
      );
      GL11.glScalef(1.0F / scalefactor, 1.0F / scalefactor, 1.0F / scalefactor);
      this.field_146289_q
         .func_78279_b("OptiFine glitches the Force-Field render! Deinstall OptiFine to render it properly.", this.posX + 72, this.posY + 160, 128, 16777215);
      super.func_73863_a(x, y, d);
      if (Mouse.isButtonDown(0) && !this.prevclick && this.ok.func_146116_c(this.field_146297_k, x, y)) {
         this.field_146297_k.func_147108_a(null);
      }

      this.prevclick = Mouse.isButtonDown(0);
   }
}
