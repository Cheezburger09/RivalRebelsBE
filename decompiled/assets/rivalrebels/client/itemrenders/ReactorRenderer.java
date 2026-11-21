package assets.rivalrebels.client.itemrenders;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.model.ModelLaptop;
import assets.rivalrebels.client.model.ModelReactor;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import org.lwjgl.opengl.GL11;

public class ReactorRenderer implements IItemRenderer {
   ModelReactor mr = new ModelReactor();
   ModelLaptop ml = new ModelLaptop();

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
      GL11.glTranslatef(0.5F, 1.1875F, 0.5F);
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etlaptop);
      this.ml.renderModel(0.0F);
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etscreen);
      this.ml.renderScreen(0.0F);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(0.5F, 0.5F, 0.5F);
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etreactor);
      this.mr.renderModel();
      GL11.glPopMatrix();
   }
}
