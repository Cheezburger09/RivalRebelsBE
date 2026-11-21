package assets.rivalrebels.client.itemrenders;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.objfileloader.ModelFromObj;
import assets.rivalrebels.client.tileentityrender.TileEntityForceFieldNodeRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import org.lwjgl.opengl.GL11;

public class RodaRenderer implements IItemRenderer {
   ModelFromObj model;

   public RodaRenderer() {
      try {
         this.model = ModelFromObj.readObjFile("e.obj");
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
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etrust);
      GL11.glPushMatrix();
      GL11.glTranslatef(0.5F, 0.5F, -0.03F);
      GL11.glRotatef(35.0F, 0.0F, 0.0F, 1.0F);
      GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
      GL11.glScalef(0.35F, 0.35F, 0.35F);
      if (type != ItemRenderType.EQUIPPED_FIRST_PERSON) {
         GL11.glScalef(-1.0F, 1.0F, 1.0F);
      }

      GL11.glTranslatef(0.2F, -0.55F, 0.1F);
      this.model.render();
      GL11.glPushMatrix();
      GL11.glBindTexture(
         3553, TileEntityForceFieldNodeRenderer.id[(int)(TileEntityForceFieldNodeRenderer.getTime() / 100L % TileEntityForceFieldNodeRenderer.frames)]
      );
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 1);
      GL11.glDisable(2896);
      this.model.render();
      GL11.glDisable(3042);
      GL11.glEnable(2896);
      GL11.glPopMatrix();
      GL11.glPopMatrix();
   }
}
