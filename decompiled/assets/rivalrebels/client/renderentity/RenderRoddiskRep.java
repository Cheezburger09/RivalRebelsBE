package assets.rivalrebels.client.renderentity;

import assets.rivalrebels.client.model.ModelDisk;
import assets.rivalrebels.client.tileentityrender.TileEntityForceFieldNodeRenderer;
import assets.rivalrebels.common.entity.EntityRoddiskRep;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderRoddiskRep extends Render {
   int er = 0;
   private ModelDisk model = new ModelDisk();

   public void func_76986_a(Entity var1, double var2, double var4, double var6, float var8, float var9) {
      this.er = (int)(this.er + 13.46);
      EntityRoddiskRep erd = (EntityRoddiskRep)var1;
      GL11.glBindTexture(
         3553, TileEntityForceFieldNodeRenderer.id[(int)(TileEntityForceFieldNodeRenderer.getTime() / 100L % TileEntityForceFieldNodeRenderer.frames)]
      );
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 1);
      GL11.glDisable(2896);
      GL11.glPushMatrix();
      GL11.glScalef(0.4F, 0.4F, 0.4F);
      GL11.glTranslatef((float)var2, (float)var4, (float)var6);
      GL11.glPushMatrix();
      GL11.glRotatef(erd.field_70125_A, 0.0F, 0.0F, 1.0F);
      GL11.glRotatef(erd.field_70177_z - 90.0F + this.er, 0.0F, 1.0F, 0.0F);
      this.model.render();
      this.model.render();
      this.model.render();
      GL11.glPopMatrix();
      GL11.glPopMatrix();
      GL11.glDisable(3042);
      GL11.glEnable(2896);
   }

   protected ResourceLocation func_110775_a(Entity entity) {
      return null;
   }
}
