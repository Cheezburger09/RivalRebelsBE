package assets.rivalrebels.client.renderentity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.model.ModelLaptop;
import assets.rivalrebels.common.entity.EntityLaptop;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderLaptop extends Render {
   ModelLaptop ml = new ModelLaptop();

   public void func_76986_a(Entity var1, double d, double d1, double d2, float var8, float var9) {
      GL11.glEnable(2896);
      EntityLaptop tile = (EntityLaptop)var1;
      GL11.glPushMatrix();
      GL11.glTranslatef((float)d, (float)d1, (float)d2);
      GL11.glRotatef(180.0F - var1.field_70177_z, 0.0F, 1.0F, 0.0F);
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etlaptop);
      this.ml.renderModel((float)(-tile.slide));
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etubuntu);
      this.ml.renderScreen((float)(-tile.slide));
      GL11.glPopMatrix();
   }

   protected ResourceLocation func_110775_a(Entity entity) {
      return null;
   }
}
