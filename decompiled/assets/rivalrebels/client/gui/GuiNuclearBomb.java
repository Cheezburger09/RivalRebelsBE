package assets.rivalrebels.client.gui;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.container.ContainerNuclearBomb;
import assets.rivalrebels.common.tileentity.TileEntityNuclearBomb;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.StatCollector;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiNuclearBomb extends GuiContainer {
   ContainerNuclearBomb container;
   TileEntityNuclearBomb nuclearbomb;
   boolean buttondown;

   public GuiNuclearBomb(Container par1Container) {
      super(par1Container);
      this.container = (ContainerNuclearBomb)par1Container;
   }

   public GuiNuclearBomb(InventoryPlayer inventoryPlayer, TileEntityNuclearBomb tileEntity) {
      super(new ContainerNuclearBomb(inventoryPlayer, tileEntity));
      this.nuclearbomb = tileEntity;
   }

   protected void func_146979_b(int par1, int par2) {
      super.func_146979_b(par1, par2);
      int seconds = this.nuclearbomb.Countdown / 20;
      int millis = this.nuclearbomb.Countdown % 20 * 3;
      String milli;
      if (millis < 10) {
         milli = "0" + millis;
      } else {
         milli = "" + millis;
      }

      if (this.nuclearbomb.Countdown % 20 >= 10) {
         this.field_146289_q.func_78276_b(StatCollector.func_74838_a("RivalRebels.tsar.timer") + ": -" + seconds + ":" + milli, 80, 6, 0);
      } else {
         this.field_146289_q.func_78276_b(StatCollector.func_74838_a("RivalRebels.tsar.timer") + ": -" + seconds + ":" + milli, 80, 6, 16711680);
      }

      this.field_146289_q.func_78276_b(StatCollector.func_74838_a("RivalRebels.nuke.name"), 8, 6, 16777215);
      this.field_146289_q.func_78276_b(StatCollector.func_74838_a("container.inventory"), 8, this.field_147000_g - 96 + 2, 16777215);
      if (this.nuclearbomb.hasExplosive && this.nuclearbomb.hasFuse) {
         this.field_146289_q.func_78276_b(StatCollector.func_74838_a("RivalRebels.tsar.armed"), 80, this.field_147000_g - 96 + 2, 16777215);
      } else if (!this.nuclearbomb.hasTrollface) {
         this.field_146289_q
            .func_78276_b(
               this.nuclearbomb.AmountOfCharges * 2.5 + " " + StatCollector.func_74838_a("RivalRebels.tsar.megatons"),
               80,
               this.field_147000_g - 96 + 2,
               16777215
            );
      } else {
         this.field_146289_q.func_78276_b("Umad bro?", 80, this.field_147000_g - 96 + 2, 16777215);
      }

      int mousex = par1;
      int mousey = par2;
      int posx = (this.field_146294_l - this.field_146999_f) / 2;
      int posy = (this.field_146295_m - this.field_147000_g) / 2;
      int coordx = posx + 53;
      int coordy = posy + 158;
      int widthx = 72;
      int widthy = 8;
      if (mousex > coordx && mousey > coordy && mousex < coordx + widthx && mousey < coordy + widthy) {
         mousex -= posx;
         mousey -= posy;
         this.func_73733_a(mousex, mousey, mousex + this.field_146289_q.func_78256_a("rivalrebels.com") + 3, mousey + 12, -1441722095, -1441722095);
         this.field_146289_q.func_78276_b("rivalrebels.com", mousex + 2, mousey + 2, 16777215);
         if (Desktop.isDesktopSupported() && !this.buttondown && Mouse.isButtonDown(0)) {
            try {
               Desktop.getDesktop().browse(new URI("http://rivalrebels.com"));
            } catch (IOException e) {
               e.printStackTrace();
            } catch (URISyntaxException e) {
               e.printStackTrace();
            }
         }
      }

      this.buttondown = Mouse.isButtonDown(0);
   }

   protected void func_146976_a(float par1, int par2, int par3) {
      GL11.glColor3f(1.0F, 1.0F, 1.0F);
      if (this.nuclearbomb.AmountOfCharges != 0) {
         GL11.glColor3f(this.nuclearbomb.AmountOfCharges * 0.1F, 1.0F - this.nuclearbomb.AmountOfCharges * 0.1F, 0.0F);
      }

      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.guitnuke);
      int x = (this.field_146294_l - this.field_146999_f) / 2;
      int y = (this.field_146295_m - this.field_147000_g) / 2;
      this.func_73729_b(x, y, 0, 0, this.field_146999_f, 81);
      GL11.glColor3f(1.0F, 1.0F, 1.0F);
      this.func_73729_b(x, y + 81, 0, 81, this.field_146999_f, this.field_147000_g - 81);
   }
}
