package assets.rivalrebels.client.guihelper;

import assets.rivalrebels.RivalRebels;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiFTKnob extends GuiButton {
   protected int mode;
   protected boolean pressed;

   public GuiFTKnob(int id, int x, int y, int minDegree, int maxDegree, int startDegree, boolean respectLimits, String par6Str) {
      super(id, x, y, 36, 36, par6Str);
      this.mode = startDegree;
   }

   @Override
   public void func_146112_a(Minecraft par1Minecraft, int par2, int par3) {
      this.func_146119_b(par1Minecraft, par2, par3);
      if (this.mode > 2) {
         this.mode = 2;
      }

      if (this.mode < 0) {
         this.mode = 0;
      }

      par1Minecraft.field_71446_o.func_110577_a(RivalRebels.guitbutton);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      int state = 0;
      if (this.pressed || this.func_146116_c(par1Minecraft, par2, par3)) {
         state = 36;
      }

      GL11.glPushMatrix();
      GL11.glTranslatef(this.field_146128_h + this.field_146120_f / 2.0F, this.field_146129_i + this.field_146121_g / 2.0F, 0.0F);
      GL11.glRotatef(this.mode * 90 - 90, 0.0F, 0.0F, 1.0F);
      GL11.glTranslatef(-(this.field_146128_h + this.field_146120_f / 2.0F), -(this.field_146129_i + this.field_146121_g / 2.0F), 0.0F);
      this.func_73729_b(this.field_146128_h, this.field_146129_i, 76 + state, 0, this.field_146120_f, this.field_146121_g);
      GL11.glPopMatrix();
   }

   protected void func_146119_b(Minecraft par1Minecraft, int par2, int par3) {
      if (Mouse.isButtonDown(0)) {
         if (this.func_146116_c(par1Minecraft, par2, par3)) {
            this.pressed = true;
         }

         if (this.pressed) {
            this.mode = (
                  (
                           (int)(
                                 Math.atan2(this.field_146129_i - par3 + this.field_146121_g / 2, this.field_146128_h - par2 + this.field_146120_f / 2)
                                    * 180.0
                                    / Math.PI
                              )
                              + 450
                        )
                        % 360
                     - 45
               )
               / 90;
         }
      } else {
         this.pressed = false;
         int move = Mouse.getDWheel();
         this.mode += move > 0 ? -1 : (move < 0 ? 1 : 0);

         while (this.mode < 0) {
            this.mode += 3;
         }

         this.mode %= 3;
      }
   }

   public void func_146118_a(int par2, int par3) {
      this.pressed = false;
   }

   public int getDegree() {
      return this.mode;
   }

   public boolean func_146116_c(Minecraft par1Minecraft, int par2, int par3) {
      return this.field_146124_l
         && this.field_146125_m
         && Math.sqrt(
               (this.field_146128_h - par2 + this.field_146120_f / 2.0F) * (this.field_146128_h - par2 + this.field_146120_f / 2.0F)
                  + (this.field_146129_i - par3 + this.field_146121_g / 2.0F) * (this.field_146129_i - par3 + this.field_146121_g / 2.0F)
            )
            <= this.field_146120_f / 2.0F;
   }
}
