package assets.rivalrebels.client.gui;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.guihelper.GuiCustomButton;
import assets.rivalrebels.client.guihelper.GuiScroll;
import assets.rivalrebels.client.guihelper.Rectangle;
import assets.rivalrebels.client.guihelper.Vector;
import assets.rivalrebels.common.container.ContainerReactor;
import assets.rivalrebels.common.item.ItemCore;
import assets.rivalrebels.common.item.ItemRod;
import assets.rivalrebels.common.noise.RivalRebelsSimplexNoise;
import assets.rivalrebels.common.packet.PacketDispatcher;
import assets.rivalrebels.common.packet.ReactorGUIPacket;
import assets.rivalrebels.common.tileentity.TileEntityReactor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiReactor extends GuiContainer {
   private IInventory upperChestInventory;
   private IInventory lowerChestInventory;
   private static DecimalFormat df = new DecimalFormat("0.0");
   private float frame = 0.0F;
   private float resolution = 4.0F;
   private TileEntityReactor ter;
   private Block[] machineslist = new Block[]{RivalRebels.forcefieldnode, RivalRebels.reactive};
   private Block[] machines = new Block[]{null, null, null, null};
   private boolean[] onmachines = new boolean[this.machines.length];
   private boolean[] enabledmachines = new boolean[this.machineslist.length];
   private boolean[] prevenabledmachines = new boolean[this.machineslist.length];
   private GuiScroll scroll;
   private GuiCustomButton power;
   private GuiCustomButton eject;
   private float melttick = 30.0F;
   boolean buttondown;
   boolean buttondown2;

   public GuiReactor(IInventory par1IInventory, IInventory par2IInventory) {
      super(new ContainerReactor(par1IInventory, par2IInventory));
      this.ter = (TileEntityReactor)par2IInventory;
      this.upperChestInventory = par1IInventory;
      this.lowerChestInventory = par2IInventory;
      this.field_147000_g = 200;
      RivalRebelsSimplexNoise.refresh();
   }

   public void func_73866_w_() {
      super.func_73866_w_();
      int posX = (this.field_146294_l - 256) / 2;
      int posY = (this.field_146295_m - 256) / 2;
      this.scroll = new GuiScroll(0, posX + 236, posY + 127, 60);
      this.power = new GuiCustomButton(1, new Rectangle(posX + 70, posY + 164, 22, 22), RivalRebels.guittokamak, new Vector(212, 0), true);
      this.eject = new GuiCustomButton(2, new Rectangle(posX + 164, posY + 164, 22, 22), RivalRebels.guittokamak, new Vector(234, 0), false);
      this.power.isPressed = this.ter.on;
      this.field_146292_n.add(this.scroll);
      this.field_146292_n.add(this.power);
      this.field_146292_n.add(this.eject);
   }

   protected void func_146979_b(int par1, int par2) {
      GL11.glPushMatrix();
      GL11.glScalef(1.25F, 1.0F, 1.0F);
      if (this.field_147002_h instanceof ContainerReactor) {
         ((ContainerReactor)this.field_147002_h).core.locked = this.ter.on;
         ((ContainerReactor)this.field_147002_h).fuel.locked = this.ter.fuel != null && this.ter.on;
      }

      this.field_146289_q.func_78276_b("ToKaMaK", 10, 8, 4473924);
      GL11.glPopMatrix();
      this.field_146289_q.func_78276_b("Teslas: " + df.format(this.ter.getPower() - this.ter.consumed), 120, 8, 16777215);
      this.field_146289_q.func_78276_b("Output/t: " + df.format(this.ter.lasttickconsumed), 140, 18, 16777215);
      int mousex = par1;
      int mousey = par2;
      int posx = (this.field_146294_l - this.field_146999_f) / 2;
      int posy = (this.field_146295_m - this.field_147000_g) / 2;
      int coordx = posx + 53;
      int coordy = posy + 191;
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
      if (this.ter.func_145837_r()) {
         Minecraft.func_71410_x().field_71462_r = null;
      }

      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.guittokamak);
      this.func_73729_b(this.field_146294_l / 2 - 89, this.field_146295_m / 2 - 103, 0, 0, 212, 208);
      float s = (float)this.scroll.scroll / this.scroll.limit;
      int off = (int)Math.floor((this.machineslist.length - 2) * s);
      if (off < 0) {
         off = 0;
      }

      int X = 89 + this.field_146294_l / 2;
      int Y = 0 + this.field_146295_m / 2;

      for (int i = 0; i < 4; i++) {
         if (off + i >= this.machineslist.length) {
            this.machines[i] = null;
         } else {
            boolean current = new Rectangle(X, Y, 15, 15).isVecInside(new Vector(par2, par3));
            if (off + i < this.machineslist.length && off + i >= 0) {
               this.machines[i] = this.machineslist[off + i];
               this.onmachines[i] = this.enabledmachines[off + i];
               if (Mouse.isButtonDown(0) && current) {
                  this.enabledmachines[off + i] = !this.prevenabledmachines[off + i];
               } else {
                  this.prevenabledmachines[off + i] = this.enabledmachines[off + i];
               }
            } else {
               this.machines[i] = null;
               this.onmachines[i] = false;
            }

            Y += 18;
         }
      }

      this.drawDock();
      long time = System.currentTimeMillis();
      if (this.ter.on && this.ter.fuel != null && this.ter.core != null) {
         float radius = 10.0F;
         if (this.ter.fuel.func_77978_p() != null) {
            radius += (
                  ((ItemRod)this.ter.fuel.func_77973_b()).power * ((ItemCore)this.ter.core.func_77973_b()).timemult
                     - this.ter.fuel.func_77978_p().func_74762_e("fuelLeft")
               )
               / (((ItemRod)this.ter.fuel.func_77973_b()).power * ((ItemCore)this.ter.core.func_77973_b()).timemult)
               * 30.0F;
         }

         this.melttick = 30.0F;
         float brightness = 0.0F;
         if (this.ter.core.func_77973_b() == RivalRebels.core1) {
            brightness = -0.4F;
         }

         if (this.ter.core.func_77973_b() == RivalRebels.core2) {
            brightness = -0.25F;
         }

         if (this.ter.core.func_77973_b() == RivalRebels.core3) {
            brightness = -0.1F;
         }

         if (this.ter.fuel.func_77973_b() == RivalRebels.nuclearelement) {
            this.drawNoiseSphere(0.9F, 1.0F, 0.1F, 0.0F, 1.0F, 0.1F, this.frame, 4, (int)radius, (int)(50.0F - radius), this.resolution, 0.02F, brightness);
         }

         if (this.ter.fuel.func_77973_b() == RivalRebels.hydrod) {
            this.drawNoiseSphere(1.0F, 1.0F, 1.0F, 0.7F, 0.0F, 1.0F, this.frame, 4, (int)radius, (int)(50.0F - radius), this.resolution, 0.02F, brightness);
         }

         if (this.ter.fuel.func_77973_b() == RivalRebels.redrod) {
            this.drawNoiseSphere(1.0F, 0.8F, 0.0F, 1.0F, 0.0F, 0.0F, this.frame, 4, (int)radius, (int)(50.0F - radius), this.resolution, 0.02F, brightness);
         }
      } else if (this.ter.melt || this.ter.on && this.ter.fuel == null) {
         if (this.melttick > 1.0F) {
            this.melttick -= 0.03F;
         }

         this.drawNoiseSphere(
            1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, this.frame, 4, (int)(20.0 + Math.sin(this.frame / this.melttick) * 20.0), 10, this.resolution, 0.02F, 0.0F
         );
      } else if (this.ter.fuel != null && this.ter.core != null) {
      }

      long elapsed = System.currentTimeMillis() - time;
      if (elapsed > 30L) {
         if (this.resolution == 0.25) {
            this.resolution = 0.125F;
         }

         if (this.resolution == 0.5) {
            this.resolution = 0.25F;
         }

         if (this.resolution == 1.0F) {
            this.resolution = 0.5F;
         }

         if (this.resolution == 2.0F) {
            this.resolution = 1.0F;
         }

         if (this.resolution == 4.0F) {
            this.resolution = 2.0F;
         }
      }

      this.frame = (float)(this.frame + (0.75 + this.ter.lasttickconsumed / 100.0));
      if (!this.buttondown2 && Mouse.isButtonDown(0)) {
         if (this.power.func_146116_c(this.field_146297_k, par2, par3)) {
            PacketDispatcher.packetsys.sendToServer(new ReactorGUIPacket(this.ter.field_145851_c, this.ter.field_145848_d, this.ter.field_145849_e, (byte)0));
         }

         if (this.eject.func_146116_c(this.field_146297_k, par2, par3)) {
            PacketDispatcher.packetsys.sendToServer(new ReactorGUIPacket(this.ter.field_145851_c, this.ter.field_145848_d, this.ter.field_145849_e, (byte)1));
         }
      }

      this.power.isPressed = this.ter.on;
      this.buttondown2 = Mouse.isButtonDown(0);
   }

   protected void drawDock() {
      int X = 89 + this.field_146294_l / 2;
      int Y = 0 + this.field_146295_m / 2;

      for (int i = 0; i < 4; i++) {
         if (this.machines[i] == null) {
            return;
         }

         Block display = this.machines[i];
         int meta = 2;
         String toppath = "Minecraft:textures/blocks/" + display.func_149691_a(1, meta).func_94215_i() + ".png";
         String lsidepath = "Minecraft:textures/blocks/" + display.func_149691_a(4, meta).func_94215_i() + ".png";
         String rsidepath = "Minecraft:textures/blocks/" + display.func_149691_a(2, meta).func_94215_i() + ".png";
         if (toppath.contains("RivalRebels:")) {
            toppath = "RivalRebels:textures/blocks/" + display.func_149733_h(1).func_94215_i().split("RivalRebels:")[1] + ".png";
         }

         if (lsidepath.contains("RivalRebels:")) {
            lsidepath = "RivalRebels:textures/blocks/" + display.func_149733_h(4).func_94215_i().split("RivalRebels:")[1] + ".png";
         }

         if (rsidepath.contains("RivalRebels:")) {
            rsidepath = "RivalRebels:textures/blocks/" + display.func_149733_h(2).func_94215_i().split("RivalRebels:")[1] + ".png";
         }

         Tessellator tessellator = Tessellator.field_78398_a;
         GL11.glEnable(3042);
         float alpha = 0.5F;
         if (this.onmachines[i]) {
            alpha = 1.0F;
         }

         GL11.glColor4f(1.0F, 1.0F, 1.0F, alpha);
         this.field_146297_k.field_71446_o.func_110577_a(new ResourceLocation(toppath));
         tessellator.func_78382_b();
         tessellator.func_78374_a(X + 1, Y + 3.5, this.field_73735_i, 0.0, 1.0);
         tessellator.func_78374_a(X + 8, Y + 7, this.field_73735_i, 0.0, 0.0);
         tessellator.func_78374_a(X + 15, Y + 3.5, this.field_73735_i, 1.0, 0.0);
         tessellator.func_78374_a(X + 8, Y, this.field_73735_i, 1.0, 1.0);
         tessellator.func_78381_a();
         GL11.glColor4f(0.666F, 0.666F, 0.666F, alpha);
         this.field_146297_k.field_71446_o.func_110577_a(new ResourceLocation(lsidepath));
         tessellator.func_78382_b();
         tessellator.func_78374_a(X + 1, Y + 3.5, this.field_73735_i, 0.0, 0.0);
         tessellator.func_78374_a(X + 1, Y + 12.5, this.field_73735_i, 0.0, 1.0);
         tessellator.func_78374_a(X + 8, Y + 16, this.field_73735_i, 1.0, 1.0);
         tessellator.func_78374_a(X + 8, Y + 7, this.field_73735_i, 1.0, 0.0);
         tessellator.func_78381_a();
         GL11.glColor4f(0.5F, 0.5F, 0.5F, alpha);
         this.field_146297_k.field_71446_o.func_110577_a(new ResourceLocation(rsidepath));
         tessellator.func_78382_b();
         tessellator.func_78374_a(X + 15, Y + 12.5, this.field_73735_i, 1.0, 1.0);
         tessellator.func_78374_a(X + 15, Y + 3.5, this.field_73735_i, 1.0, 0.0);
         tessellator.func_78374_a(X + 8, Y + 7, this.field_73735_i, 0.0, 0.0);
         tessellator.func_78374_a(X + 8, Y + 16, this.field_73735_i, 0.0, 1.0);
         tessellator.func_78381_a();
         GL11.glDisable(3042);
         Y += 18;
      }
   }

   protected void drawNoiseSphere(
      float red,
      float grn,
      float blu,
      float red1,
      float grn1,
      float blu1,
      float frame,
      int o,
      int radius,
      int outer,
      float resolution,
      float sscale,
      float startcol
   ) {
      Tessellator t = Tessellator.field_78398_a;
      ScaledResolution scaledresolution = new ScaledResolution(this.field_146297_k, this.field_146297_k.field_71443_c, this.field_146297_k.field_71440_d);
      GL11.glPushMatrix();
      GL11.glPointSize(scaledresolution.func_78325_e() / resolution);
      GL11.glDisable(3553);
      GL11.glEnable(3042);
      t.func_78371_b(0);
      radius = (int)(radius * resolution);
      int outerR = (int)(radius + outer * resolution);
      int maxdist = outerR - radius;
      float hheight = this.field_146295_m / 2 - 45;
      float hwidth = this.field_146294_l / 2;
      float rradius = radius * radius;

      for (int x = 1 - outerR; x < outerR; x++) {
         int xs = x * x;
         double X = (double)x / resolution + hwidth;

         for (int y = 1 - outerR; y < outerR; y++) {
            int ys = y * y + xs;
            double Y = (double)y / resolution + hheight;
            double fdist = Math.sqrt(ys);
            if (fdist >= radius && fdist < outerR) {
               float v = 0.0F;
               float a = 1.0F;
               float s = sscale;

               for (int e = 0; e < o; e++) {
                  v += (float)((1.0 + RivalRebelsSimplexNoise.noise(X * s, Y * s, frame * s)) / 2.0) * a;
                  s *= 2.0F;
                  a /= 2.0F;
               }

               v = (float)(v * (1.0 - (fdist - radius) / maxdist));
               t.func_78369_a(this.lerp(red, red1, v), this.lerp(grn, grn1, v), this.lerp(blu, blu1, v), v);
               t.func_78377_a(X, Y, 4.0);
            } else {
               double Z = Math.sqrt(rradius - ys) / resolution;
               float v = startcol;
               float a = 1.0F;
               float s = sscale;

               for (int e = 0; e < o; e++) {
                  v += (float)((1.0 + RivalRebelsSimplexNoise.noise(X * s, Y * s, Z * s, frame * s)) / 2.0) * a;
                  s *= 2.0F;
                  a /= 2.0F;
               }

               t.func_78369_a(this.lerp(red, red1, v), this.lerp(grn, grn1, v), this.lerp(blu, blu1, v), v);
               t.func_78377_a(X, Y, 4.0);
            }
         }
      }

      t.func_78381_a();
      GL11.glEnable(3553);
      GL11.glPopMatrix();
   }

   protected float lerp(float f1, float f2, float f3) {
      return f1 * f3 + f2 * (1.0F - f3);
   }

   protected void drawInfographic(float resolution, int radius, int sep, int width1, int width2, float outerRatio, float innerRatio1, float innerRatio2) {
      Tessellator t = Tessellator.field_78398_a;
      GL11.glPushMatrix();
      GL11.glPointSize(4.0F / resolution);
      GL11.glDisable(3553);
      GL11.glEnable(3042);
      t.func_78371_b(0);
      radius = (int)(radius * resolution);
      sep = (int)(sep * resolution);
      width1 = (int)(width1 * resolution);
      width2 = (int)(width2 * resolution);
      innerRatio1 *= outerRatio;
      innerRatio2 *= outerRatio;
      innerRatio2 += outerRatio;
      outerRatio = (float)(outerRatio * (Math.PI * 2));
      innerRatio1 = (float)(innerRatio1 * (Math.PI * 2));
      innerRatio2 = (float)(innerRatio2 * (Math.PI * 2));
      int midR1 = radius + width1;
      int midR2 = midR1 + sep;
      int outerR = midR2 + width2;
      float hheight = this.field_146295_m / 2;
      float hwidth = this.field_146294_l / 2;

      for (int x = 1 - outerR; x < outerR; x++) {
         int xs = x * x;
         double X = (double)x / resolution;

         for (int y = 1 - outerR; y < outerR; y++) {
            int ys = y * y;
            double fdist = Math.sqrt(xs + ys);
            if (fdist >= radius && fdist < midR1) {
               double Y = (double)y / resolution;
               double angle = Math.PI + Math.atan2(X, Y);
               if (angle <= outerRatio) {
                  if (angle <= innerRatio1) {
                     t.func_78369_a(0.25F, 0.25F, 1.0F, 1.0F);
                  } else {
                     t.func_78369_a(0.75F, 0.75F, 1.0F, 1.0F);
                  }
               } else if (angle <= innerRatio2) {
                  t.func_78369_a(1.0F, 0.25F, 0.25F, 1.0F);
               } else {
                  t.func_78369_a(1.0F, 0.75F, 0.75F, 1.0F);
               }

               t.func_78377_a(hwidth + X, hheight + Y - 45.0, 4.0);
            } else if (fdist >= midR2 && fdist < outerR) {
               double Y = (double)y / resolution;
               double angle = Math.PI + Math.atan2(X, Y);
               if (angle <= outerRatio) {
                  t.func_78369_a(0.0F, 0.0F, 1.0F, 1.0F);
               } else {
                  t.func_78369_a(1.0F, 0.0F, 0.0F, 1.0F);
               }

               t.func_78377_a(hwidth + X, hheight + Y - 45.0, 4.0);
            }
         }
      }

      t.func_78381_a();
      GL11.glEnable(3553);
      GL11.glPopMatrix();
   }
}
