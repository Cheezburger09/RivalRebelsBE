package assets.rivalrebels.client.gui;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.guihelper.GuiButton;
import assets.rivalrebels.client.guihelper.GuiScroll;
import assets.rivalrebels.common.round.RivalRebelsClass;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class GuiClass extends GuiScreen {
   private final int xSizeOfTexture = 256;
   private final int ySizeOfTexture = 256;
   private int posX;
   private int posY;
   private String[] displaytext = new String[15];
   private float[] sizelookup = new float[]{
      1.0F,
      1.0F,
      1.0F,
      1.0F,
      1.0F,
      1.0F,
      1.0F,
      1.0F,
      1.0F,
      1.0F,
      1.0F,
      1.0F,
      1.0F,
      1.0F,
      1.0F,
      1.0F,
      1.0F,
      1.0F,
      1.0F,
      1.0F,
      1.0F,
      1.0F,
      1.0F,
      1.0F,
      1.0F,
      1.0F,
      1.0F,
      1.0F,
      1.0F,
      1.0F,
      1.0F,
      1.0F,
      1.0F,
      1.0F,
      1.0F,
      1.0F
   };
   private GuiButton nextButton;
   private GuiButton doneButton;
   private GuiScroll gameScroll;
   private boolean prevClick = true;
   private RivalRebelsClass rrclass = RivalRebelsClass.NONE;

   public GuiClass(RivalRebelsClass rrc) {
      this.posX = (this.field_146294_l - 256) / 2;
      this.posY = (this.field_146295_m - 256) / 2;
      this.rrclass = rrc;
   }

   public void func_73866_w_() {
      this.posX = (this.field_146294_l - 256) / 2;
      this.posY = (this.field_146295_m - 256) / 2;
      this.field_146292_n.clear();
      this.nextButton = new GuiButton(0, this.posX + 188, this.posY + 102, 60, 11, "RivalRebels.class.next");
      this.doneButton = new GuiButton(1, this.posX + 188, this.posY + 119, 60, 11, "RivalRebels.class.done");
      this.gameScroll = new GuiScroll(2, this.posX + 243, this.posY + 9, 74);
      this.field_146292_n.add(this.nextButton);
      this.field_146292_n.add(this.doneButton);
      this.field_146292_n.add(this.gameScroll);
   }

   public void func_73876_c() {
   }

   public boolean func_73868_f() {
      return false;
   }

   public void func_146282_l() {
   }

   public void func_73863_a(int x, int y, float d) {
      if (this.rrclass == RivalRebelsClass.NONE) {
         this.rrclass = RivalRebelsClass.REBEL;
      }

      Tessellator tessellator = Tessellator.field_78398_a;
      float f = 0.00390625F;
      this.func_146276_q_();
      this.func_73733_a(this.posX, this.posY, this.posX + 256, this.posY + 256, -16777216, -16777216);
      this.drawPanel(this.posX + 162, this.posY + 40, 80, 74, this.gameScroll.getScroll(), this.gameScroll.limit, this.rrclass.name + ".description");
      this.func_73733_a(this.posX + 160, this.posY + 9, this.posX + 244, this.posY + 38, -16777216, -16777216);
      GL11.glColor3f(1.0F, 1.0F, 1.0F);
      this.field_146297_k.field_71446_o.func_110577_a(RivalRebels.guitclass);
      tessellator.func_78382_b();
      tessellator.func_78374_a(this.posX, this.posY + 256, this.field_73735_i, 0.0, 256.0F * f);
      tessellator.func_78374_a(this.posX + 256, this.posY + 256, this.field_73735_i, 256.0F * f, 256.0F * f);
      tessellator.func_78374_a(this.posX + 256, this.posY, this.field_73735_i, 256.0F * f, 0.0);
      tessellator.func_78374_a(this.posX, this.posY, this.field_73735_i, 0.0, 0.0);
      tessellator.func_78381_a();
      this.field_146297_k.field_71446_o.func_110577_a(this.rrclass.resource);
      tessellator.func_78382_b();
      tessellator.func_78374_a(this.posX + 12, this.posY + 140, this.field_73735_i, 0.0, 256.0F * f);
      tessellator.func_78374_a(this.posX + 140, this.posY + 140, this.field_73735_i, 256.0F * f, 256.0F * f);
      tessellator.func_78374_a(this.posX + 140, this.posY + 12, this.field_73735_i, 256.0F * f, 0.0);
      tessellator.func_78374_a(this.posX + 12, this.posY + 12, this.field_73735_i, 0.0, 0.0);
      tessellator.func_78381_a();
      float scalefactor = 1.5F;
      GL11.glScalef(scalefactor * 1.2F, scalefactor, scalefactor);
      this.func_73732_a(
         this.field_146289_q, this.rrclass.name, (int)((this.posX + 76) / (scalefactor * 1.2F)), (int)((this.posY + 16) / scalefactor), this.rrclass.color
      );
      GL11.glScalef(1.0F / (scalefactor * 1.2F), 1.0F / scalefactor, 1.0F / scalefactor);
      scalefactor = 0.666F;
      GL11.glScalef(scalefactor, scalefactor, scalefactor);
      this.func_73732_a(
         this.field_146289_q,
         StatCollector.func_74838_a("RivalRebels.class." + this.rrclass.name + ".minidesc"),
         (int)((this.posX + 76) / scalefactor),
         (int)((this.posY + 28) / scalefactor),
         this.rrclass.color
      );
      GL11.glScalef(1.0F / scalefactor, 1.0F / scalefactor, 1.0F / scalefactor);
      scalefactor = 0.666F;
      GL11.glScalef(scalefactor, scalefactor, scalefactor);
      this.func_73732_a(
         this.field_146289_q,
         StatCollector.func_74838_a("RivalRebels.class.description"),
         (int)((this.posX + 181) / scalefactor),
         (int)((this.posY + 28) / scalefactor),
         this.rrclass.color
      );
      GL11.glScalef(1.0F / scalefactor, 1.0F / scalefactor, 1.0F / scalefactor);
      GL11.glColor3f(1.0F, 1.0F, 1.0F);

      for (int i = 0; i < this.sizelookup.length; i++) {
         int X = this.posX + 18 + i % 9 * 22;
         int Y = this.posY + 158 + 22 * (int)Math.floor(i / 9);
         float size = this.sizelookup[i];
         if (x >= X && y >= Y && x < X + 16 && y < Y + 16) {
            if (size < 1.5) {
               size = (float)(size + 0.1);
            }
         } else if (size > 1.0F) {
            size = (float)(size - 0.1);
         }

         this.sizelookup[i] = size;
      }

      GL11.glDisable(2896);
      GL11.glBlendFunc(770, 1);

      for (int i = this.rrclass.inventory.length - 1; i >= 0; i--) {
         int X = this.posX + 18 + i % 9 * 22;
         int Y = this.posY + 158 + 22 * (i / 9);
         GL11.glPushMatrix();
         GL11.glTranslatef(X + 8, Y + 8, 0.0F);
         GL11.glScaled(this.sizelookup[i], this.sizelookup[i], this.sizelookup[i]);
         GL11.glTranslatef(-X - 8, -Y - 8, 0.0F);
         RenderItem.getInstance().renderItemIntoGUI(this.field_146289_q, this.field_146297_k.func_110434_K(), this.rrclass.inventory[i], X, Y, false);
         GL11.glPopMatrix();
         GL11.glDisable(2896);
         GL11.glBlendFunc(770, 1);
      }

      for (int i = this.rrclass.inventory.length - 1; i >= 0; i--) {
         int X = this.posX + 18 + i % 9 * 22;
         int Y = this.posY + 158 + 22 * (i / 9);
         GL11.glPushMatrix();
         GL11.glTranslatef(X + 8, Y + 8, 20.0F);
         GL11.glScaled(this.sizelookup[i], this.sizelookup[i], this.sizelookup[i]);
         GL11.glTranslatef(-X - 8, -Y - 8, 0.0F);
         ItemStack itemstack = this.rrclass.inventory[i];
         if (itemstack.field_77994_a > 1) {
            this.field_146289_q
               .func_78261_a("" + itemstack.field_77994_a, X + 17 - this.field_146289_q.func_78256_a("" + itemstack.field_77994_a), Y + 9, 16777215);
         }

         if (this.sizelookup[i] > 1.0F) {
            this.func_73733_a(
               X + 17,
               Y + 3,
               (int)(X + (this.field_146289_q.func_78256_a(itemstack.func_82833_r()) + 4) * (this.sizelookup[i] - 1.0F) * 2.0F + 15.0F),
               Y + 13,
               -1441722095,
               -1441722095
            );
            this.field_146289_q.func_78261_a(itemstack.func_82833_r(), X + 18, Y + 4, 16777215);
         }

         GL11.glPopMatrix();
      }

      super.func_73863_a(x, y, d);
      if (Mouse.isButtonDown(0) && !this.prevClick) {
         if (this.nextButton.func_146116_c(this.field_146297_k, x, y)) {
            switch (this.rrclass) {
               case HACKER:
                  this.rrclass = RivalRebelsClass.REBEL;
                  break;
               case INTEL:
                  this.rrclass = RivalRebelsClass.HACKER;
                  break;
               case NONE:
                  this.rrclass = RivalRebelsClass.REBEL;
                  break;
               case NUKER:
                  this.rrclass = RivalRebelsClass.INTEL;
                  break;
               case REBEL:
                  this.rrclass = RivalRebelsClass.NUKER;
            }
         }

         if (this.doneButton.func_146116_c(this.field_146297_k, x, y)) {
            this.field_146297_k.func_147108_a(new GuiSpawn(this.rrclass));
         }
      }

      this.prevClick = Mouse.isButtonDown(0);
   }

   protected void drawPanel(int x, int y, int width, int height, int scroll, int scrolllimit, String display) {
      int length = 10;
      int dist = (int)(-((float)scroll / scrolllimit) * (length * 10 - height));
      float scalefactor = 0.6666F;
      GL11.glScalef(scalefactor, scalefactor, scalefactor);
      this.field_146289_q
         .func_78279_b(StatCollector.func_74838_a("RivalRebels.class." + display), (int)(x * 1.5), (int)((y + dist) * 1.5), (int)(width * 1.5), 16777215);
      GL11.glScalef(1.0F / scalefactor, 1.0F / scalefactor, 1.0F / scalefactor);
   }
}
