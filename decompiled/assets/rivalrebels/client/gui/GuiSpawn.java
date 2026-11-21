package assets.rivalrebels.client.gui;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.guihelper.GuiButton;
import assets.rivalrebels.client.guihelper.GuiScroll;
import assets.rivalrebels.common.packet.JoinTeamPacket;
import assets.rivalrebels.common.packet.PacketDispatcher;
import assets.rivalrebels.common.packet.ResetPacket;
import assets.rivalrebels.common.round.RivalRebelsClass;
import assets.rivalrebels.common.round.RivalRebelsPlayer;
import assets.rivalrebels.common.round.RivalRebelsTeam;
import cpw.mods.fml.common.registry.LanguageRegistry;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiPlayerInfo;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.StatCollector;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class GuiSpawn extends GuiScreen {
   private final int xSizeOfTexture = 256;
   private final int ySizeOfTexture = 256;
   private int posX;
   private int posY;
   private GuiButton classButton;
   private GuiButton resetButton;
   private GuiButton omegaButton;
   private GuiButton sigmaButton;
   private GuiScroll omegaScroll;
   private GuiScroll sigmaScroll;
   private GuiScroll playerScroll;
   private GuiScroll gameScroll;
   private boolean prevClick = true;
   private RivalRebelsClass rrclass = RivalRebelsClass.NONE;

   public GuiSpawn(RivalRebelsClass rrc) {
      this.posX = (this.field_146294_l - 256) / 2;
      this.posY = (this.field_146295_m - 256) / 2;
      this.rrclass = rrc;
   }

   public void func_73866_w_() {
      this.posX = (this.field_146294_l - 256) / 2;
      this.posY = (this.field_146295_m - 256) / 2;
      this.field_146292_n.clear();
      this.classButton = new GuiButton(0, this.posX + 188, this.posY + 102, 60, 11, "RivalRebels.spawn.class");
      this.resetButton = new GuiButton(1, this.posX + 188, this.posY + 119, 60, 11, "RivalRebels.spawn.reset");
      this.omegaButton = new GuiButton(2, this.posX + 35, this.posY + 237, 60, 11, "RivalRebels.spawn.joinomega");
      this.sigmaButton = new GuiButton(3, this.posX + 160, this.posY + 237, 60, 11, "RivalRebels.spawn.joinsigma");
      this.omegaScroll = new GuiScroll(4, this.posX + 118, this.posY + 140, 80);
      this.sigmaScroll = new GuiScroll(5, this.posX + 243, this.posY + 140, 80);
      this.playerScroll = new GuiScroll(6, this.posX + 154, this.posY + 103, 16);
      this.gameScroll = new GuiScroll(7, this.posX + 243, this.posY + 66, 16);
      RivalRebelsPlayer nw = RivalRebels.round.rrplayerlist.getForName(Minecraft.func_71410_x().field_71439_g.func_70005_c_());
      this.resetButton.field_146124_l = nw.resets > 0 && !nw.isreset;
      this.omegaButton.field_146124_l = nw.rrteam == RivalRebelsTeam.NONE || nw.rrteam == RivalRebelsTeam.OMEGA;
      this.sigmaButton.field_146124_l = nw.rrteam == RivalRebelsTeam.NONE || nw.rrteam == RivalRebelsTeam.SIGMA;
      this.classButton.field_146124_l = nw.isreset;
      this.field_146292_n.add(this.classButton);
      this.field_146292_n.add(this.resetButton);
      this.field_146292_n.add(this.omegaButton);
      this.field_146292_n.add(this.sigmaButton);
      this.field_146292_n.add(this.omegaScroll);
      this.field_146292_n.add(this.sigmaScroll);
      this.field_146292_n.add(this.playerScroll);
      this.field_146292_n.add(this.gameScroll);
   }

   public boolean func_73868_f() {
      return false;
   }

   public void func_146282_l() {
   }

   public void func_73876_c() {
   }

   public void func_73863_a(int x, int y, float d) {
      RivalRebelsPlayer nw = RivalRebels.round.rrplayerlist.getForName(Minecraft.func_71410_x().field_71439_g.func_70005_c_());
      this.classButton.field_146124_l = nw.isreset;
      this.omegaButton.field_146124_l = nw.rrteam == RivalRebelsTeam.NONE || nw.rrteam == RivalRebelsTeam.OMEGA;
      this.sigmaButton.field_146124_l = nw.rrteam == RivalRebelsTeam.NONE || nw.rrteam == RivalRebelsTeam.SIGMA;
      this.resetButton.field_146124_l = nw.resets > 0 && !nw.isreset;
      Tessellator tessellator = Tessellator.field_78398_a;
      float f = 0.00390625F;
      this.func_146276_q_();
      this.func_73733_a(this.posX, this.posY, this.posX + 256, this.posY + 256, -16777216, -16777216);
      this.drawPanel(this.posX + 10, this.posY + 142, 80, this.omegaScroll.getScroll(), this.omegaScroll.limit, RivalRebelsTeam.OMEGA);
      this.drawPanel(this.posX + 135, this.posY + 142, 80, this.sigmaScroll.getScroll(), this.sigmaScroll.limit, RivalRebelsTeam.SIGMA);
      this.drawPanel(
         this.posX + 10,
         this.posY + 68,
         228,
         50,
         this.gameScroll.getScroll(),
         this.gameScroll.limit,
         RivalRebels.round.getMotD() + "\nMod by Rodolphito. \nVisit www.RivalRebels.com for official downloads."
      );
      this.func_73733_a(this.posX + 6, this.posY + 99, this.posX + 161, this.posY + 131, -16777216, -16777216);
      this.drawPanel(
         this.posX + 10,
         this.posY + 105,
         50,
         this.playerScroll.getScroll(),
         this.playerScroll.limit,
         new String[]{this.rrclass.name},
         new int[]{this.rrclass.color}
      );
      new Random();
      GL11.glColor3f(1.0F, 1.0F, 1.0F);
      this.field_146297_k.field_71446_o.func_110577_a(RivalRebels.guitspawn);
      tessellator.func_78382_b();
      tessellator.func_78374_a(this.posX, this.posY + 256, this.field_73735_i, 0.0, 256.0F * f);
      tessellator.func_78374_a(this.posX + 256, this.posY + 256, this.field_73735_i, 256.0F * f, 256.0F * f);
      tessellator.func_78374_a(this.posX + 256, this.posY, this.field_73735_i, 256.0F * f, 0.0);
      tessellator.func_78374_a(this.posX, this.posY, this.field_73735_i, 0.0, 0.0);
      tessellator.func_78381_a();
      if (RivalRebels.banner != null) {
         this.field_146297_k.field_71446_o.func_110577_a(RivalRebels.banner);
         tessellator.func_78382_b();
         tessellator.func_78374_a(this.posX + 3, this.posY + 61, this.field_73735_i, 0.0, 1.0);
         tessellator.func_78374_a(this.posX + 253, this.posY + 61, this.field_73735_i, 1.0, 1.0);
         tessellator.func_78374_a(this.posX + 253, this.posY + 3, this.field_73735_i, 1.0, 0.0);
         tessellator.func_78374_a(this.posX + 3, this.posY + 3, this.field_73735_i, 0.0, 0.0);
         tessellator.func_78381_a();
      }

      super.func_73863_a(x, y, d);
      this.field_146289_q.func_78276_b("" + RivalRebels.round.getOmegaWins(), this.posX + 9, this.posY + 239, 16777215);
      this.field_146289_q.func_78276_b("" + RivalRebels.round.getSigmaWins(), this.posX + 134, this.posY + 239, 16777215);
      if (this.resetButton.func_146116_c(this.field_146297_k, x, y) && this.resetButton.field_146124_l) {
         this.func_73733_a(x, y, x + 120, y + 20, -1441722095, -1441722095);
         float scalefactor = 0.666F;
         GL11.glScalef(scalefactor, scalefactor, scalefactor);
         this.field_146289_q
            .func_78279_b(
               LanguageRegistry.instance().getStringLocalization("RivalRebels.spawn.resetwarning"),
               (int)((x + 2) / scalefactor),
               (int)((y + 2) / scalefactor),
               (int)(116.0F / scalefactor),
               16711680
            );
         GL11.glScalef(1.0F / scalefactor, 1.0F / scalefactor, 1.0F / scalefactor);
      }

      if (Mouse.isButtonDown(0) && !this.prevClick) {
         if (this.classButton.func_146116_c(this.field_146297_k, x, y)) {
            this.field_146297_k.func_147108_a(new GuiClass(this.rrclass));
         }

         if (this.resetButton.func_146116_c(this.field_146297_k, x, y)) {
            this.field_146297_k.func_147108_a(new GuiClass(this.rrclass));
            PacketDispatcher.packetsys.sendToServer(new ResetPacket());
         }

         if (this.omegaButton.func_146116_c(this.field_146297_k, x, y)) {
            PacketDispatcher.packetsys.sendToServer(new JoinTeamPacket(RivalRebelsTeam.OMEGA, this.rrclass));
            this.field_146297_k.func_147108_a(null);
         }

         if (this.sigmaButton.func_146116_c(this.field_146297_k, x, y)) {
            PacketDispatcher.packetsys.sendToServer(new JoinTeamPacket(RivalRebelsTeam.SIGMA, this.rrclass));
            this.field_146297_k.func_147108_a(null);
         }
      }

      this.prevClick = Mouse.isButtonDown(0);
   }

   protected void drawPanel(int x, int y, int height, int scroll, int scrolllimit, RivalRebelsTeam team) {
      RivalRebelsPlayer[] nlist = new RivalRebelsPlayer[RivalRebels.round.rrplayerlist.getSize()];
      RivalRebelsPlayer[] list = RivalRebels.round.rrplayerlist.getArray();
      int index = 0;

      for (int i = 0; i < nlist.length; i++) {
         if (this.isOnline(list[i].username) && list[i].rrteam.equals(team)) {
            nlist[index] = list[i];
            index++;
         }
      }

      for (int i = 0; i < nlist.length; i++) {
         if (!this.isOnline(list[i].username) && list[i].rrteam.equals(team)) {
            nlist[index] = list[i];
            index++;
         }
      }

      if (index != 0) {
         int dist = (int)(-((float)scroll / scrolllimit) * (index * 10 - height));
         boolean shouldScroll = index * 10 > height;

         for (int i = 0; i < nlist.length && nlist[i] != null; i++) {
            int Y = dist + i * 10;
            if (!shouldScroll) {
               Y -= dist;
            }

            if (Y > -9 && Y < height + 9) {
               int color = nlist[i].rrclass.color;
               int r = (color & 0xFF0000) >> 16;
               int g = (color & 0xFF00) >> 8;
               int b = color & 0xFF;
               if (!this.isOnline(nlist[i].username)) {
                  r /= 2;
                  g /= 2;
                  b /= 2;
               }

               color = r << 16 | g << 8 | b;
               this.func_73731_b(this.field_146289_q, nlist[i].username, x, y + Y, color);
            }
         }
      }
   }

   protected void drawPanel(int x, int y, int height, int scroll, int scrolllimit, String[] display, int[] color) {
      int dist = (int)(-((float)scroll / scrolllimit) * (display.length * 10 - height));
      boolean shouldScroll = display.length * 10 > height;

      for (int i = 0; i < display.length; i++) {
         int Y = dist + i * 10;
         if (!shouldScroll) {
            Y -= dist;
         }

         if (Y > -9 && Y < height + 9) {
            this.func_73731_b(this.field_146289_q, StatCollector.func_74838_a(display[i]), x, y + Y, color[i]);
         }
      }
   }

   protected void drawPanel(int x, int y, int width, int height, int scroll, int scrolllimit, String display) {
      int length = 10;
      int dist = (int)(-((float)scroll / scrolllimit) * (length * 10 - height));
      float scalefactor = 0.6666F;
      GL11.glScalef(scalefactor, scalefactor, scalefactor);
      this.field_146289_q.func_78279_b(display, (int)(x * 1.5), (int)((y + dist) * 1.5), (int)(width * 1.5), 16777215);
      GL11.glScalef(1.0F / scalefactor, 1.0F / scalefactor, 1.0F / scalefactor);
   }

   protected boolean isOnline(String user) {
      if (Minecraft.func_71410_x().func_147114_u() != null && Minecraft.func_71410_x().func_147114_u().field_147303_b != null) {
         Iterator iter = Minecraft.func_71410_x().func_147114_u().field_147303_b.iterator();

         while (iter.hasNext()) {
            if (user.equals(((GuiPlayerInfo)iter.next()).field_78831_a)) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }
}
