package assets.rivalrebels.client.guihelper;

import assets.rivalrebels.RivalRebels;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiDial extends GuiButton {
   protected int degree;
   protected int maxdegreelimit = 360;
   protected int mindegreelimit = 0;
   protected boolean pressed;

   public GuiDial(int id, int x, int y, int minDegree, int maxDegree, int startDegree, boolean respectLimits, String par6Str) {
      super(id, x, y, 11, 11, par6Str);
      if (respectLimits) {
         this.maxdegreelimit = maxDegree;
         this.mindegreelimit = minDegree;
      }

      this.degree = startDegree;
   }

   @Override
   public void func_146112_a(Minecraft par1Minecraft, int par2, int par3) {
      this.func_146119_b(par1Minecraft, par2, par3);
      if (this.degree > this.maxdegreelimit) {
         this.degree = this.maxdegreelimit;
      }

      if (this.degree < this.mindegreelimit) {
         this.degree = this.mindegreelimit;
      }

      par1Minecraft.field_71446_o.func_110577_a(RivalRebels.guitbutton);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      int state = 0;
      if (this.pressed || this.func_146116_c(par1Minecraft, par2, par3)) {
         state = 11;
      }

      GL11.glPushMatrix();
      GL11.glTranslatef(this.field_146128_h + this.field_146120_f / 2.0F, this.field_146129_i + this.field_146121_g / 2.0F, 0.0F);
      GL11.glRotatef(this.degree, 0.0F, 0.0F, 1.0F);
      GL11.glTranslatef(-(this.field_146128_h + this.field_146120_f / 2.0F), -(this.field_146129_i + this.field_146121_g / 2.0F), 0.0F);
      this.func_73729_b(this.field_146128_h, this.field_146129_i, 65, state, this.field_146120_f, this.field_146121_g);
      GL11.glPopMatrix();
   }

   protected void func_146119_b(Minecraft par1Minecraft, int par2, int par3) {
      if (Mouse.isButtonDown(0)) {
         if (this.func_146116_c(par1Minecraft, par2, par3)) {
            this.pressed = true;
         }

         if (this.pressed) {
            this.degree = (
                  (int)(
                        Math.atan2(this.field_146129_i - par3 + this.field_146121_g / 2, this.field_146128_h - par2 + this.field_146120_f / 2)
                           * 180.0
                           / Math.PI
                     )
                     + 270
               )
               % 360;
         }
      } else {
         this.pressed = false;
      }
   }

   public void func_146118_a(int par2, int par3) {
      this.pressed = false;
   }

   public int getDegree() {
      return this.degree;
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
