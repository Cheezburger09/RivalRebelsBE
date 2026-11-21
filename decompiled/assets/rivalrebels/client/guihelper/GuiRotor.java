package assets.rivalrebels.client.guihelper;

import assets.rivalrebels.RivalRebels;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiRotor extends GuiButton {
   protected int degree;
   protected boolean pressed;

   public GuiRotor(int id, int x, int y, int yawLimit, String par6Str) {
      super(id, x, y, 32, 32, par6Str);
      this.degree = yawLimit / 2;
   }

   @Override
   public void func_146112_a(Minecraft par1Minecraft, int par2, int par3) {
      this.func_146119_b(par1Minecraft, par2, par3);
      par1Minecraft.field_71446_o.func_110577_a(RivalRebels.guitray);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glPushMatrix();
      int deg = this.degree % 180;
      if (this.degree >= 180) {
         deg = 180 - deg;
      }

      if (deg < 22) {
         deg = 22;
      }

      this.degree = deg;
      this.func_73729_b(this.field_146128_h, this.field_146129_i, 224, 66, this.field_146120_f, this.field_146121_g * deg / 180);
      this.func_73732_a(
         par1Minecraft.field_71466_p, deg * 2 + "°", this.field_146128_h + this.field_146120_f / 2, this.field_146129_i + this.field_146121_g / 2 - 4, 16777215
      );
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
