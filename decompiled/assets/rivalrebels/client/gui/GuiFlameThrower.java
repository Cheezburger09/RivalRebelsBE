package assets.rivalrebels.client.gui;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.guihelper.GuiFTKnob;
import assets.rivalrebels.common.packet.ItemUpdate;
import assets.rivalrebels.common.packet.PacketDispatcher;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import org.lwjgl.input.Keyboard;

public class GuiFlameThrower extends GuiScreen {
   private final int xSizeOfTexture = 256;
   private final int ySizeOfTexture = 256;
   private int posX;
   private int posY;
   private GuiFTKnob knob;
   private int s = 0;

   public GuiFlameThrower(int start) {
      this.s = start;
   }

   public void func_73866_w_() {
      this.posX = (this.field_146294_l - 256) / 2;
      this.posY = (this.field_146295_m - 256) / 2;
      this.field_146292_n.clear();
      this.knob = new GuiFTKnob(0, this.posX + 108, this.posY + 176, -90, 90, this.s, true, "Knob");
      this.field_146292_n.add(this.knob);
   }

   public boolean func_73868_f() {
      return false;
   }

   public void func_73876_c() {
   }

   public void func_73863_a(int x, int y, float d) {
      Tessellator tessellator = Tessellator.field_78398_a;
      float f = 0.00390625F;
      this.field_146297_k = Minecraft.func_71410_x();
      this.field_146297_k.field_71446_o.func_110577_a(RivalRebels.guiflamethrower);
      tessellator.func_78382_b();
      tessellator.func_78374_a(this.posX, this.posY + 256, this.field_73735_i, 0.0, 256.0F * f);
      tessellator.func_78374_a(this.posX + 256, this.posY + 256, this.field_73735_i, 256.0F * f, 256.0F * f);
      tessellator.func_78374_a(this.posX + 256, this.posY, this.field_73735_i, 256.0F * f, 0.0);
      tessellator.func_78374_a(this.posX, this.posY, this.field_73735_i, 0.0, 0.0);
      tessellator.func_78381_a();
      super.func_73863_a(x, y, d);
      if (RivalRebels.altRkey ? !Keyboard.isKeyDown(33) : !Keyboard.isKeyDown(19)) {
         this.field_146297_k.func_147108_a((GuiScreen)null);
         this.field_146297_k.func_71381_h();
         ItemStack itemstack = this.field_146297_k.field_71439_g.field_71071_by.func_70301_a(this.field_146297_k.field_71439_g.field_71071_by.field_70461_c);
         if (itemstack.field_77990_d == null) {
            itemstack.field_77990_d = new NBTTagCompound();
         }

         itemstack.field_77990_d.func_74768_a("mode", this.knob.getDegree());
         PacketDispatcher.packetsys.sendToServer(new ItemUpdate(this.field_146297_k.field_71439_g.field_71071_by.field_70461_c, this.knob.getDegree()));
      }
   }
}
