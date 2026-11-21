package assets.rivalrebels.client.gui;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.container.ContainerTachyonBomb;
import assets.rivalrebels.common.container.ContainerTsar;
import assets.rivalrebels.common.tileentity.TileEntityTachyonBomb;
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
public class GuiTachyonBomb extends GuiContainer {
   ContainerTsar container;
   TileEntityTachyonBomb tsar;
   boolean buttondown;

   public GuiTachyonBomb(Container container) {
      super(container);
      this.container = (ContainerTsar)container;
   }

   public GuiTachyonBomb(InventoryPlayer inventoryPlayer, TileEntityTachyonBomb tileEntity) {
      super(new ContainerTachyonBomb(inventoryPlayer, tileEntity));
      this.field_147000_g = 206;
      this.tsar = tileEntity;
   }

   protected void func_146979_b(int par1, int par2) {
      super.func_146979_b(par1, par2);
      int seconds = this.tsar.countdown / 20;
      int millis = this.tsar.countdown % 20 * 3;
      String milli;
      if (millis < 10) {
         milli = "0" + millis;
      } else {
         milli = "" + millis;
      }

      if (this.tsar.countdown % 20 >= 10) {
         this.field_146289_q
            .func_78276_b(StatCollector.func_74838_a("RivalRebels.tsar.timer") + ": -" + seconds + ":" + milli, 6, this.field_147000_g - 107, 16777215);
      } else {
         this.field_146289_q
            .func_78276_b(StatCollector.func_74838_a("RivalRebels.tsar.timer") + ": -" + seconds + ":" + milli, 6, this.field_147000_g - 107, 16711680);
      }

      float scalef = 0.666F;
      GL11.glPushMatrix();
      GL11.glScalef(scalef, scalef, scalef);
      this.field_146289_q.func_78276_b("Tachyon", 18, 16, 4210752);
      GL11.glPopMatrix();
      if (this.tsar.nuclear != this.tsar.hydrogen) {
         this.field_146289_q.func_78276_b(StatCollector.func_74838_a("RivalRebels.tsar.unbalanced"), 6, this.field_147000_g - 97, 16711680);
      } else if (this.tsar.hasExplosive && this.tsar.hasFuse && this.tsar.hasAntennae) {
         this.field_146289_q.func_78276_b(StatCollector.func_74838_a("RivalRebels.tsar.armed"), 6, this.field_147000_g - 97, 16711680);
      } else {
         this.field_146289_q
            .func_78276_b(this.tsar.megaton + " " + StatCollector.func_74838_a("RivalRebels.tsar.megatons"), 6, this.field_147000_g - 97, 16777215);
      }

      int mousex = par1;
      int mousey = par2;
      int posx = (this.field_146294_l - this.field_146999_f) / 2;
      int posy = (this.field_146295_m - this.field_147000_g) / 2;
      int coordx = posx + 53;
      int coordy = posy + 194;
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
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.guitachyonbomb);
      int x = (this.field_146294_l - this.field_146999_f) / 2;
      int y = (this.field_146295_m - this.field_147000_g) / 2;
      this.func_73729_b(x, y, 0, 0, this.field_146999_f, this.field_147000_g);
   }
}
