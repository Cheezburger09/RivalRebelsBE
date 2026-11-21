package assets.rivalrebels.client.gui;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.guihelper.GuiCustomButton;
import assets.rivalrebels.client.guihelper.GuiDropdownOption;
import assets.rivalrebels.client.guihelper.GuiRotor;
import assets.rivalrebels.client.guihelper.Rectangle;
import assets.rivalrebels.client.guihelper.Vector;
import assets.rivalrebels.client.tileentityrender.TileEntityRecieverRenderer;
import assets.rivalrebels.common.container.ContainerReciever;
import assets.rivalrebels.common.packet.ADSClosePacket;
import assets.rivalrebels.common.packet.ADSWeaponPacket;
import assets.rivalrebels.common.packet.PacketDispatcher;
import assets.rivalrebels.common.tileentity.TileEntityReciever;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.StatCollector;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiTray extends GuiContainer {
   ContainerReciever container;
   public TileEntityReciever r;
   private float xSize_lo;
   private float ySize_lo;
   GuiRotor range;
   GuiCustomButton chip;
   GuiCustomButton players;
   GuiCustomButton mobs;
   GuiDropdownOption select1;
   boolean buttondown;
   static int spinfac = 0;

   public GuiTray(Container container) {
      super(container);
      this.container = (ContainerReciever)container;
   }

   public GuiTray(InventoryPlayer inventoryPlayer, TileEntityReciever tileEntity) {
      super(new ContainerReciever(inventoryPlayer, tileEntity));
      this.field_147000_g = 206;
      this.r = tileEntity;
   }

   public void func_73866_w_() {
      super.func_73866_w_();
      int x = (this.field_146294_l - this.field_146999_f) / 2;
      int y = (this.field_146295_m - this.field_147000_g) / 2;
      this.field_146292_n.clear();
      this.range = new GuiRotor(0, x + 93 - 16, y + 92 - 16, this.r.yawLimit, "Range");
      this.chip = new GuiCustomButton(1, new Rectangle(x + 94, y + 10, 19, 19), RivalRebels.guitray, new Vector(237, 10), true);
      this.chip.isPressed = this.r.kTeam;
      this.players = new GuiCustomButton(2, new Rectangle(x + 94, y + 28, 19, 19), RivalRebels.guitray, new Vector(237, 28), true);
      this.players.isPressed = this.r.kPlayers;
      this.mobs = new GuiCustomButton(3, new Rectangle(x + 94, y + 46, 19, 19), RivalRebels.guitray, new Vector(237, 46), true);
      this.mobs.isPressed = this.r.kMobs;
      this.select1 = new GuiDropdownOption(4, new Vector(119 + x, 8 + y), 45, 0, "RivalRebels.ads.dragon", this);
      this.field_146292_n.add(this.range);
      this.field_146292_n.add(this.chip);
      this.field_146292_n.add(this.players);
      this.field_146292_n.add(this.mobs);
      this.field_146292_n.add(this.select1);
   }

   public void func_73863_a(int par1, int par2, float par3) {
      super.func_73863_a(par1, par2, par3);
      this.xSize_lo = par1;
      this.ySize_lo = par2;
   }

   protected void func_73869_a(char par1, int par2) {
      if (par2 == 1) {
         this.field_146297_k.func_147108_a((GuiScreen)null);
         this.field_146297_k.func_71381_h();
         PacketDispatcher.packetsys
            .sendToServer(
               new ADSClosePacket(
                  this.r.field_145851_c,
                  this.r.field_145848_d,
                  this.r.field_145849_e,
                  this.mobs.isPressed,
                  this.chip.isPressed,
                  this.players.isPressed,
                  this.range.getDegree() * 2
               )
            );
      }
   }

   protected void func_146979_b(int par1, int par2) {
      super.func_146979_b(par1, par2);
      if (this.select1.isPressed) {
         PacketDispatcher.packetsys.sendToServer(new ADSWeaponPacket(this.r.field_145851_c, this.r.field_145848_d, this.r.field_145849_e, 1));
      }

      this.select1.isPressed = false;
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

   public void drawADS(int x, int y, int scale, float px, float py) {
      spinfac++;
      GL11.glEnable(2903);
      GL11.glPushMatrix();
      GL11.glTranslatef(x, y - 40, 50.0F);
      GL11.glScalef(-scale, scale, scale);
      GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
      GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
      RenderHelper.func_74519_b();
      GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotated(20.0, 1.0, 0.0, 0.0);
      if (!this.r.hasWeapon) {
         GL11.glTranslatef(0.0F, 0.0F, -0.5F);
         GL11.glRotatef(spinfac, 0.0F, 1.0F, 0.0F);
         GL11.glTranslatef(0.0F, 0.0F, 0.5F);
      }

      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etreciever);
      GL11.glRotated(180.0, 0.0, 1.0, 0.0);
      GL11.glTranslated(0.0, -0.75, 1.2600000000000002);
      TileEntityRecieverRenderer.base.render();
      if (this.r.hasWeapon) {
         GL11.glTranslated(0.0, 0.75, -1.2600000000000002);
         GL11.glRotated(-Math.atan(px / 40.0F) * 40.0, 0.0, 1.0, 0.0);
         TileEntityRecieverRenderer.arm.render();
         GL11.glRotated(Math.atan(py / 40.0F) * 40.0 + 20.0, 1.0, 0.0, 0.0);
         Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etadsdragon);
         TileEntityRecieverRenderer.adsdragon.render();
      }

      GL11.glPopMatrix();
      RenderHelper.func_74518_a();
      GL11.glDisable(32826);
      OpenGlHelper.func_77473_a(OpenGlHelper.field_77476_b);
      GL11.glDisable(3553);
      OpenGlHelper.func_77473_a(OpenGlHelper.field_77478_a);
   }

   protected void func_146976_a(float par1, int par2, int par3) {
      GL11.glColor3f(1.0F, 1.0F, 1.0F);
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.guitray);
      int x = (this.field_146294_l - this.field_146999_f) / 2;
      int y = (this.field_146295_m - this.field_147000_g) / 2;
      this.func_73729_b(x, y, 0, 0, this.field_146999_f, this.field_147000_g);
      if (this.r.pInR > 0.0F) {
         this.func_73729_b(x + 104, y + 68, 248, 0, 8, 8);
      }

      Minecraft.func_71410_x().field_71466_p.func_78276_b(StatCollector.func_74838_a("RivalRebels.ads.tray"), x + 25, y + 66, 16777215);
      this.drawADS(this.field_147003_i + 51, this.field_147009_r + 75, 30, this.field_147003_i + 51 - this.xSize_lo, this.field_147009_r + 25 - this.ySize_lo);
   }
}
