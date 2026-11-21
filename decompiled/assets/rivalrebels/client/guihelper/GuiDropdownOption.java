package assets.rivalrebels.client.guihelper;

import assets.rivalrebels.client.gui.GuiTray;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.util.StatCollector;
import org.lwjgl.input.Mouse;

@SideOnly(Side.CLIENT)
public class GuiDropdownOption extends net.minecraft.client.gui.GuiButton {
   Rectangle bbox;
   public boolean isPressed = false;
   public boolean mouseDown = false;
   public String text = "";
   public GuiTray t;

   public GuiDropdownOption(int id, Vector p, int l, int n, String text, GuiTray tray) {
      super(id, p.x, p.y + n * 10, l, (n + 1) * 10, text);
      this.bbox = new Rectangle(p.x, p.y + n * 10, l, (n + 1) * 10);
      this.text = text;
      this.t = tray;
   }

   public void func_146112_a(Minecraft par1Minecraft, int par2, int par3) {
      boolean inside = this.bbox.isVecInside(new Vector(par2, par3));
      boolean current = Mouse.isButtonDown(0) && inside;
      boolean on = this.t.r.hasWepReqs();
      if (current && !this.mouseDown && on) {
         this.isPressed = !this.isPressed;
      }

      int color = 10066329;
      if (on) {
         int team = 0;
         if (this.t.r.chestContents[6] != null && this.t.r.chestContents[6].field_77990_d != null) {
            team = this.t.r.chestContents[6].field_77990_d.func_74762_e("team");
         }

         if (team == 0) {
            color = 16777045;
         }

         if (team == 1) {
            color = 5635925;
         }

         if (team == 2) {
            color = 5592575;
         }
      }

      if (inside && on) {
         color = 16777215;
      }

      this.func_73731_b(Minecraft.func_71410_x().field_71466_p, StatCollector.func_74838_a(this.text), this.bbox.xMin + 1, this.bbox.yMin + 1, color);
      this.mouseDown = current;
   }
}
