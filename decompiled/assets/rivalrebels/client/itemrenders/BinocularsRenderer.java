package assets.rivalrebels.client.itemrenders;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.objfileloader.ModelFromObj;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class BinocularsRenderer implements IItemRenderer {
   ModelFromObj model;

   public BinocularsRenderer() {
      try {
         this.model = ModelFromObj.readObjFile("b.obj");
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
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etbinoculars);
      GL11.glEnable(2896);
      GL11.glPushMatrix();
      GL11.glTranslatef(0.5F, 0.5F, -0.03F);
      GL11.glRotatef(35.0F, 0.0F, 0.0F, 1.0F);
      GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
      GL11.glScalef(0.35F, 0.35F, 0.35F);
      if (type == ItemRenderType.EQUIPPED_FIRST_PERSON && Mouse.isButtonDown(1)) {
         GL11.glPopMatrix();
      } else {
         GL11.glTranslatef(0.6F, 0.05F, 0.3F);
         if (this.model.name.equals("")) {
            Minecraft.func_71410_x()
               .field_71439_g
               .func_145747_a(
                  new ChatComponentText(
                     "§43D ERROR:§f Cannot find RivalRebels.zip or RivalRebels folder inside mods folder. Please make sure the RivalRebels mod file is named RivalRebels.zip, or visit §2www.rivalrebels.com §ffor support."
                  )
               );
         }

         this.model.render();
         GL11.glPopMatrix();
      }
   }
}
