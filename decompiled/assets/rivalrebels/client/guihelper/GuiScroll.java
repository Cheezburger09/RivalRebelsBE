package assets.rivalrebels.client.guihelper;

import assets.rivalrebels.RivalRebels;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class GuiScroll extends net.minecraft.client.gui.GuiButton {
   public int limit;
   public int scroll;
   public boolean pressed = false;

   public GuiScroll(int par1, int par2, int par3, int par4) {
      super(par1, par2, par3, 5, 11, "");
      this.limit = par4;
      this.pressed = false;
   }

   public void func_146112_a(Minecraft par1Minecraft, int par2, int par3) {
      this.func_146119_b(par1Minecraft, par2, par3);
      if (this.scroll > this.limit) {
         this.scroll = this.limit;
      }

      if (this.scroll < 0) {
         this.scroll = 0;
      }

      par1Minecraft.field_71446_o.func_110577_a(RivalRebels.guitbutton);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      int state = 0;
      if (this.pressed || this.func_146116_c(par1Minecraft, par2, par3)) {
         state = 11;
      }

      this.func_73729_b(this.field_146128_h, this.field_146129_i + this.scroll, 0, state, this.field_146120_f, this.field_146121_g);
   }

   protected void func_146119_b(Minecraft par1Minecraft, int par2, int par3) {
      if (Mouse.isButtonDown(0)) {
         if (this.func_146116_c(par1Minecraft, par2, par3)) {
            this.pressed = true;
         }

         if (this.pressed) {
            this.scroll = par3 - this.field_146129_i - 5;
         }
      } else {
         this.pressed = false;
      }
   }

   public void func_146118_a(int par2, int par3) {
      this.pressed = false;
   }

   public int getScroll() {
      return this.scroll;
   }

   public boolean func_146116_c(Minecraft par1Minecraft, int par2, int par3) {
      return this.field_146124_l
         && this.field_146125_m
         && par2 >= this.field_146128_h
         && par3 >= this.field_146129_i
         && par2 < this.field_146128_h + this.field_146120_f
         && par3 < this.field_146129_i + this.limit + this.field_146121_g;
   }
}
