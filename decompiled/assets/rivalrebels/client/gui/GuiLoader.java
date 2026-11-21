package assets.rivalrebels.client.gui;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.container.ContainerLoader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.IInventory;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiLoader extends GuiContainer {
   private IInventory upperChestInventory;
   private IInventory lowerChestInventory;
   private int inventoryRows = 0;
   boolean buttondown;

   public GuiLoader(IInventory par1IInventory, IInventory par2IInventory) {
      super(new ContainerLoader(par1IInventory, par2IInventory));
      this.upperChestInventory = par1IInventory;
      this.lowerChestInventory = par2IInventory;
      this.field_146291_p = false;
      short var3 = 222;
      int var4 = var3 - 108;
      this.inventoryRows = par2IInventory.func_70302_i_() / 9;
      this.field_147000_g = var4 + this.inventoryRows * 18;
      this.field_146999_f = 256;
   }

   protected void func_146979_b(int par1, int par2) {
      GL11.glPushMatrix();
      GL11.glRotated(-13.0, 0.0, 0.0, 1.0);
      this.field_146289_q.func_78276_b("Loader", 165, 237, 4473924);
      GL11.glPopMatrix();
      int mousex = par1;
      int mousey = par2;
      int posx = (this.field_146294_l - this.field_146999_f) / 2;
      int posy = (this.field_146295_m - this.field_147000_g) / 2;
      int coordx = posx + 92;
      int coordy = posy + 202;
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
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.guitloader);
      this.func_73729_b(this.field_146294_l / 2 - 128, this.field_146295_m / 2 - 103, 0, 0, 256, 210);
   }
}
