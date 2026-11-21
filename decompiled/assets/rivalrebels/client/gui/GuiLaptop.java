package assets.rivalrebels.client.gui;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.guihelper.GuiButton;
import assets.rivalrebels.common.container.ContainerLaptop;
import assets.rivalrebels.common.packet.LaptopButtonPacket;
import assets.rivalrebels.common.packet.PacketDispatcher;
import assets.rivalrebels.common.tileentity.TileEntityLaptop;
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
public class GuiLaptop extends GuiContainer {
   ContainerLaptop container;
   TileEntityLaptop lt;
   GuiButton button;
   boolean prevButtonDown;
   boolean buttondown;

   public GuiLaptop(Container container) {
      super(container);
      this.container = (ContainerLaptop)container;
   }

   public GuiLaptop(InventoryPlayer inventoryPlayer, TileEntityLaptop tileEntity) {
      super(new ContainerLaptop(inventoryPlayer, tileEntity));
      this.field_147000_g = 206;
      this.lt = tileEntity;
   }

   public void func_73866_w_() {
      super.func_73866_w_();
      int x = (this.field_146294_l - this.field_146999_f) / 2;
      int y = (this.field_146295_m - this.field_147000_g) / 2;
      this.field_146292_n.clear();
      this.button = new GuiButton(0, x + 131, y + 89, 16, 16, "");
      this.field_146292_n.add(this.button);
   }

   protected void func_146979_b(int par1, int par2) {
      super.func_146979_b(par1, par2);
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.guilaptopnuke);
      if (this.lt.isReady()) {
         this.func_73729_b(131, 89, 239, 9, 16, 16);
      } else {
         this.func_73729_b(131, 89, 131, 89, 16, 16);
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
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.guilaptopnuke);
      int x = (this.field_146294_l - this.field_146999_f) / 2;
      int y = (this.field_146295_m - this.field_147000_g) / 2;
      this.func_73729_b(x, y, 0, 0, this.field_146999_f, this.field_147000_g);
      if (this.lt.hasChips()) {
         this.func_73729_b(x + 135, y + 79, 248, 0, 8, 8);
      }

      Minecraft.func_71410_x().field_71466_p.func_78276_b(StatCollector.func_74838_a("RivalRebels.controller.B83"), x + 118, y + 11, 16777215);
      Minecraft.func_71410_x().field_71466_p.func_78276_b(StatCollector.func_74838_a("RivalRebels.controller.b2spirit"), x + 25, y + 11, 16777215);
      Minecraft.func_71410_x().field_71466_p.func_78276_b(StatCollector.func_74838_a("x" + this.lt.b2spirit), x + 154, y + 96, 16777215);
      Minecraft.func_71410_x().field_71466_p.func_78276_b(StatCollector.func_74838_a("x" + this.lt.b2carpet), x + 154, y + 85, 16777215);
      if (this.button.func_146116_c(this.field_146297_k, par2, par3) && Mouse.isButtonDown(0) && !this.prevButtonDown) {
         PacketDispatcher.packetsys.sendToServer(new LaptopButtonPacket(this.lt.field_145851_c, this.lt.field_145848_d, this.lt.field_145849_e));
      }

      this.prevButtonDown = Mouse.isButtonDown(0);
   }
}
