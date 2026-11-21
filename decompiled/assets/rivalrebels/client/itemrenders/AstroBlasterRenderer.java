package assets.rivalrebels.client.itemrenders;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.model.ModelAstroBlasterBack;
import assets.rivalrebels.client.model.ModelAstroBlasterBarrel;
import assets.rivalrebels.client.model.ModelAstroBlasterBody;
import assets.rivalrebels.client.model.ModelAstroBlasterHandle;
import assets.rivalrebels.client.model.ModelRod;
import assets.rivalrebels.client.tileentityrender.TileEntityForceFieldNodeRenderer;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import org.lwjgl.opengl.GL11;

public class AstroBlasterRenderer implements IItemRenderer {
   ModelAstroBlasterBarrel md1;
   ModelAstroBlasterHandle md2;
   ModelAstroBlasterBody md3;
   ModelAstroBlasterBack md4;
   ModelRod md5;
   float pullback = 0.0F;
   float rotation = 0.0F;
   boolean isreloading = false;
   int stage = 0;
   int spin = 0;
   int time = 1;
   int reloadcooldown = 0;

   public AstroBlasterRenderer() {
      this.md1 = new ModelAstroBlasterBarrel();
      this.md2 = new ModelAstroBlasterHandle();
      this.md3 = new ModelAstroBlasterBody();
      this.md4 = new ModelAstroBlasterBack();
      this.md5 = new ModelRod();
   }

   public boolean handleRenderType(ItemStack item, ItemRenderType type) {
      return type == ItemRenderType.FIRST_PERSON_MAP
         || type == ItemRenderType.EQUIPPED
         || type == ItemRenderType.ENTITY
         || type == ItemRenderType.EQUIPPED_FIRST_PERSON;
   }

   public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
      return false;
   }

   public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
      this.spin++;
      if (item.func_82838_A() >= 1) {
         this.spin = (int)(this.spin + item.func_82838_A() / 2.2);
      }

      this.spin %= 628;
      if (this.reloadcooldown > 0) {
         this.reloadcooldown--;
      }

      if (item.func_82838_A() > 20 && this.reloadcooldown == 0) {
         this.isreloading = true;
      }

      if (this.isreloading) {
         if (this.stage == 0) {
            if (this.pullback < 0.3) {
               this.pullback = (float)(this.pullback + 0.03);
            } else {
               this.stage = 1;
            }
         }

         if (this.stage == 1) {
            if (this.rotation < 90.0F) {
               this.rotation = (float)(this.rotation + 4.5);
            } else {
               this.stage = 2;
            }
         }

         if (this.stage == 2) {
            if (this.pullback > 0.0F) {
               this.pullback = (float)(this.pullback - 0.03);
            } else {
               this.stage = 0;
               this.isreloading = false;
               this.reloadcooldown = 60;
               this.rotation = 0.0F;
            }
         }
      }

      GL11.glPushMatrix();
      GL11.glDisable(2896);
      GL11.glTranslatef(0.4F, 0.35F, -0.03F);
      GL11.glRotatef(-55.0F, 0.0F, 0.0F, 1.0F);
      GL11.glTranslatef(0.0F, -0.05F, 0.05F);
      GL11.glPushMatrix();
      GL11.glTranslatef(0.0F, 0.9F, 0.0F);
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.eteinstenbarrel);
      this.md1.render();
      if (item.func_77986_q() != null && item.func_77986_q().func_74745_c() > 0) {
         GL11.glBindTexture(
            3553, TileEntityForceFieldNodeRenderer.id[(int)(TileEntityForceFieldNodeRenderer.getTime() / 100L % TileEntityForceFieldNodeRenderer.frames)]
         );
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 1);
         GL11.glDisable(2896);
         this.md1.render();
         GL11.glDisable(3042);
         GL11.glEnable(2896);
      }

      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(0.22F, -0.025F, 0.0F);
      GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
      GL11.glScalef(0.03125F, 0.03125F, 0.03125F);
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.eteinstenhandle);
      this.md2.render();
      if (item.func_77986_q() != null && item.func_77986_q().func_74745_c() > 0) {
         GL11.glBindTexture(
            3553, TileEntityForceFieldNodeRenderer.id[(int)(TileEntityForceFieldNodeRenderer.getTime() / 100L % TileEntityForceFieldNodeRenderer.frames)]
         );
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 1);
         GL11.glDisable(2896);
         this.md2.render();
         GL11.glDisable(3042);
         GL11.glEnable(2896);
      }

      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(0.0F, 0.2F, 0.0F);
      GL11.glScaled(0.85, 0.85, 0.85);
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.eteinstenback);
      this.md4.render();
      if (item.func_77986_q() != null && item.func_77986_q().func_74745_c() > 0) {
         GL11.glBindTexture(
            3553, TileEntityForceFieldNodeRenderer.id[(int)(TileEntityForceFieldNodeRenderer.getTime() / 100L % TileEntityForceFieldNodeRenderer.frames)]
         );
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 1);
         GL11.glDisable(2896);
         this.md4.render();
         GL11.glDisable(3042);
         GL11.glEnable(2896);
      }

      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(0.0F, -this.pullback, 0.0F);
      GL11.glRotatef(this.rotation, 0.0F, 1.0F, 0.0F);
      GL11.glPushMatrix();
      GL11.glTranslatef(0.12F, 0.1F, 0.12F);
      GL11.glRotatef(this.pullback * 270.0F, 0.0F, 1.0F, 0.0F);
      GL11.glScalef(0.3F, 0.7F, 0.3F);
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etredrod);
      this.md5.render();
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(-0.12F, 0.1F, 0.12F);
      GL11.glRotatef(this.pullback * 270.0F, 0.0F, 1.0F, 0.0F);
      GL11.glScalef(0.3F, 0.7F, 0.3F);
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etredrod);
      this.md5.render();
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(-0.12F, 0.1F, -0.12F);
      GL11.glRotatef(this.pullback * 270.0F, 0.0F, 1.0F, 0.0F);
      GL11.glScalef(0.3F, 0.7F, 0.3F);
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etredrod);
      this.md5.render();
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(0.12F, 0.1F, -0.12F);
      GL11.glRotatef(this.pullback * 270.0F, 0.0F, 1.0F, 0.0F);
      GL11.glScalef(0.3F, 0.7F, 0.3F);
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etredrod);
      this.md5.render();
      GL11.glPopMatrix();
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glDisable(3553);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 1);
      GL11.glTranslatef(0.0F, 0.25F, 0.0F);
      float segmentDistance = 0.1F;
      float distance = 0.5F;
      float radius = 0.01F;
      Random rand = new Random();
      Tessellator tessellator = Tessellator.field_78398_a;
      double AddedX = 0.0;
      double AddedZ = 0.0;
      double prevAddedX = 0.0;
      double prevAddedZ = 0.0;

      for (float AddedY = distance; AddedY >= 0.0F; AddedY -= segmentDistance) {
         prevAddedX = AddedX;
         prevAddedZ = AddedZ;
         AddedX = (rand.nextFloat() - 0.5) * 0.1F;
         AddedZ = (rand.nextFloat() - 0.5) * 0.1F;
         double dist = Math.sqrt(AddedX * AddedX + AddedZ * AddedZ);
         if (dist != 0.0) {
            double tempAddedX = AddedX / dist;
            double tempAddedZ = AddedZ / dist;
            if (Math.abs(tempAddedX) < Math.abs(AddedX)) {
               AddedX = tempAddedX;
            }

            if (Math.abs(tempAddedZ) < Math.abs(AddedZ)) {
               AddedZ = tempAddedZ;
            }
         }

         if (AddedY <= 0.0F) {
            AddedZ = 0.0;
            AddedX = 0.0;
         }

         for (float o = 0.0F; o <= radius; o += radius / 2.0F) {
            tessellator.func_78382_b();
            tessellator.func_78369_a(1.0F, 0.0F, 0.0F, 1.0F);
            tessellator.func_78377_a(AddedX + o, AddedY, AddedZ - o);
            tessellator.func_78377_a(AddedX + o, AddedY, AddedZ + o);
            tessellator.func_78377_a(prevAddedX + o, AddedY + segmentDistance, prevAddedZ + o);
            tessellator.func_78377_a(prevAddedX + o, AddedY + segmentDistance, prevAddedZ - o);
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78369_a(1.0F, 0.0F, 0.0F, 1.0F);
            tessellator.func_78377_a(AddedX - o, AddedY, AddedZ - o);
            tessellator.func_78377_a(AddedX + o, AddedY, AddedZ - o);
            tessellator.func_78377_a(prevAddedX + o, AddedY + segmentDistance, prevAddedZ - o);
            tessellator.func_78377_a(prevAddedX - o, AddedY + segmentDistance, prevAddedZ - o);
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78369_a(1.0F, 0.0F, 0.0F, 1.0F);
            tessellator.func_78377_a(AddedX - o, AddedY, AddedZ + o);
            tessellator.func_78377_a(AddedX - o, AddedY, AddedZ - o);
            tessellator.func_78377_a(prevAddedX - o, AddedY + segmentDistance, prevAddedZ - o);
            tessellator.func_78377_a(prevAddedX - o, AddedY + segmentDistance, prevAddedZ + o);
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78369_a(1.0F, 0.0F, 0.0F, 1.0F);
            tessellator.func_78377_a(AddedX + o, AddedY, AddedZ + o);
            tessellator.func_78377_a(AddedX - o, AddedY, AddedZ + o);
            tessellator.func_78377_a(prevAddedX - o, AddedY + segmentDistance, prevAddedZ + o);
            tessellator.func_78377_a(prevAddedX + o, AddedY + segmentDistance, prevAddedZ + o);
            tessellator.func_78381_a();
         }
      }

      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(0.0F, 0.8F, 0.0F);
      GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
      GL11.glRotatef(this.spin, 0.0F, 1.0F, 0.0F);
      GL11.glScaled(0.9, 4.1, 0.9);
      this.md3.render((float)(0.22F + Math.sin(this.spin / 10) * 0.005), 0.5F, 0.0F, 0.0F, 1.0F);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(0.0F, 0.8F, 0.0F);
      GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
      GL11.glRotatef(-this.spin, 0.0F, 1.0F, 0.0F);
      GL11.glScaled(0.9, 4.1, 0.9);
      this.md3.render((float)(0.22F + Math.cos(-this.spin / 15) * 0.005), 0.5F, 0.0F, 0.0F, 1.0F);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
      GL11.glPopMatrix();
   }
}
