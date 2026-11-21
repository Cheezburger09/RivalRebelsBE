package assets.rivalrebels.client.itemrenders;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.model.ModelRod;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import org.lwjgl.opengl.GL11;

public class HydrogenRodRenderer implements IItemRenderer {
   ModelRod md = new ModelRod();

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
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.ethydrod);
      GL11.glEnable(2896);
      GL11.glPushMatrix();
      GL11.glTranslatef(0.5F, 0.5F, -0.03F);
      GL11.glRotatef(35.0F, 0.0F, 0.0F, 1.0F);
      GL11.glScalef(0.5F, 1.25F, 0.5F);
      GL11.glPushMatrix();
      this.md.render();
      GL11.glPopMatrix();
      GL11.glPopMatrix();
   }
}
