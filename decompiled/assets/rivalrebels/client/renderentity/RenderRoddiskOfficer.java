package assets.rivalrebels.client.renderentity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.model.ModelDisk;
import assets.rivalrebels.common.entity.EntityRoddiskOfficer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderRoddiskOfficer extends Render {
   int er = 0;
   private ModelDisk model = new ModelDisk();

   public void func_76986_a(Entity var1, double var2, double var4, double var6, float var8, float var9) {
      this.er = (int)(this.er + 13.46);
      EntityRoddiskOfficer erd = (EntityRoddiskOfficer)var1;
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etdisk2);
      GL11.glPushMatrix();
      GL11.glTranslatef((float)var2, (float)var4, (float)var6);
      GL11.glRotatef(erd.field_70125_A, 0.0F, 0.0F, 1.0F);
      GL11.glRotatef(erd.field_70177_z - 90.0F + this.er, 0.0F, 1.0F, 0.0F);
      GL11.glScalef(0.4F, 0.4F, 0.4F);
      GL11.glPushMatrix();
      this.model.render();
      GL11.glPopMatrix();
      GL11.glDisable(32826);
      GL11.glPopMatrix();
   }

   protected ResourceLocation func_110775_a(Entity entity) {
      return null;
   }
}
