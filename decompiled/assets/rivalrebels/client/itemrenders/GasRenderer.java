package assets.rivalrebels.client.itemrenders;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.objfileloader.ModelFromObj;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import org.lwjgl.opengl.GL11;

public class GasRenderer implements IItemRenderer {
   ModelFromObj ft;

   public GasRenderer() {
      try {
         this.ft = ModelFromObj.readObjFile("o.obj");
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
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etflamethrower);
      GL11.glEnable(2896);
      GL11.glPushMatrix();
      GL11.glTranslatef(0.8F, 0.5F, -0.03F);
      GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(160.0F, 0.0F, 0.0F, 1.0F);
      GL11.glScalef(0.15F, 0.15F, 0.15F);
      this.ft.render();
      GL11.glPopMatrix();
   }
}
