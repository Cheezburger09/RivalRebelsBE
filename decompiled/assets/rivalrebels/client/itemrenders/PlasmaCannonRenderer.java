package assets.rivalrebels.client.itemrenders;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.model.ModelRod;
import assets.rivalrebels.client.objfileloader.ModelFromObj;
import assets.rivalrebels.client.tileentityrender.TileEntityForceFieldNodeRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import org.lwjgl.opengl.GL11;

public class PlasmaCannonRenderer implements IItemRenderer {
   ModelRod md2 = new ModelRod();
   ModelRod md3;
   ModelFromObj model;

   public PlasmaCannonRenderer() {
      this.md2.rendersecondcap = false;
      this.md3 = new ModelRod();

      try {
         this.model = ModelFromObj.readObjFile("m.obj");
      } catch (Exception e) {
         System.err.println("Please make sure the model files are in the correct directory.");
      }
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
      GL11.glEnable(2896);
      GL11.glPushMatrix();
      GL11.glTranslatef(-0.1F, 0.0F, 0.0F);
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etplasmacannon);
      GL11.glPushMatrix();
      GL11.glTranslatef(0.5F, 0.2F, -0.03F);
      GL11.glRotatef(35.0F, 0.0F, 0.0F, 1.0F);
      GL11.glScalef(0.03125F, 0.03125F, 0.03125F);
      GL11.glPushMatrix();
      this.model.render();
      if (item.func_77986_q() != null) {
         GL11.glBindTexture(
            3553, TileEntityForceFieldNodeRenderer.id[(int)(TileEntityForceFieldNodeRenderer.getTime() / 100L % TileEntityForceFieldNodeRenderer.frames)]
         );
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 1);
         GL11.glDisable(2896);
         this.model.render();
         GL11.glDisable(3042);
         GL11.glEnable(2896);
      }

      GL11.glPopMatrix();
      GL11.glPopMatrix();
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.ethydrod);
      GL11.glPushMatrix();
      GL11.glTranslatef(0.5F, 0.2F, -0.03F);
      GL11.glRotatef(35.0F, 0.0F, 0.0F, 1.0F);
      GL11.glPushMatrix();
      GL11.glRotatef(225.0F, 0.0F, 0.0F, 1.0F);
      GL11.glTranslatef(-0.5F, 0.5F, 0.0F);
      GL11.glScalef(0.25F, 0.5F, 0.25F);
      this.md2.render();
      if (item.func_77986_q() != null) {
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
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(0.5F, 0.2F, -0.03F);
      GL11.glRotatef(35.0F, 0.0F, 0.0F, 1.0F);
      GL11.glPushMatrix();
      GL11.glRotatef(247.5F, 0.0F, 0.0F, 1.0F);
      GL11.glTranslatef(-0.175F, 0.1F, 0.0F);
      GL11.glScalef(0.25F, 0.5F, 0.25F);
      this.md3.render();
      if (item.func_77986_q() != null) {
         GL11.glBindTexture(
            3553, TileEntityForceFieldNodeRenderer.id[(int)(TileEntityForceFieldNodeRenderer.getTime() / 100L % TileEntityForceFieldNodeRenderer.frames)]
         );
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 1);
         GL11.glDisable(2896);
         this.md3.render();
         GL11.glDisable(3042);
         GL11.glEnable(2896);
      }

      GL11.glPopMatrix();
      GL11.glPopMatrix();
      GL11.glPopMatrix();
   }
}
