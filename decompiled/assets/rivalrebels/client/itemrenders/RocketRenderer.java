package assets.rivalrebels.client.itemrenders;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.model.ModelRocket;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import org.lwjgl.opengl.GL11;

public class RocketRenderer implements IItemRenderer {
   ModelRocket rock = new ModelRocket();

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
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etrocket);
      GL11.glPushMatrix();
      GL11.glTranslatef(0.8F, 0.3F, -0.03F);
      GL11.glScaled(2.0, 2.0, 2.0);
      this.rock.render(true);
      GL11.glPopMatrix();
   }
}
