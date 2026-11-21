package assets.rivalrebels.client.guihelper;

import assets.rivalrebels.RivalRebels;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiButton extends net.minecraft.client.gui.GuiButton {
   public GuiButton(int par1, int par2, int par3, String par4Str) {
      this(par1, par2, par3, 60, 11, par4Str);
   }

   public GuiButton(int par1, int par2, int par3, int par4, int par5, String par6Str) {
      super(par1, par2, par3, par4, par5, par6Str);
   }

   public void func_146112_a(Minecraft par1Minecraft, int par2, int par3) {
      if (this.field_146125_m) {
         FontRenderer fontrenderer = par1Minecraft.field_71466_p;
         par1Minecraft.field_71446_o.func_110577_a(RivalRebels.guitbutton);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         this.field_146123_n = par2 >= this.field_146128_h
            && par3 >= this.field_146129_i
            && par2 < this.field_146128_h + this.field_146120_f
            && par3 < this.field_146129_i + this.field_146121_g;
         int k = this.func_146114_a(this.field_146123_n);
         this.func_73729_b(this.field_146128_h, this.field_146129_i, 5, k * 11, this.field_146120_f, this.field_146121_g);
         this.func_146119_b(par1Minecraft, par2, par3);
         int l = 16777215;
         if (!this.field_146124_l) {
            l = 13421772;
         } else if (this.field_146123_n) {
            l = 8972543;
         }

         this.func_73732_a(
            fontrenderer,
            StatCollector.func_74838_a(this.field_146126_j),
            this.field_146128_h + this.field_146120_f / 2,
            this.field_146129_i + (this.field_146121_g - 7) / 2,
            l
         );
      }
   }
}
