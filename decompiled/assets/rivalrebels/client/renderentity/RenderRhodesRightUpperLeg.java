package assets.rivalrebels.client.renderentity;

import assets.rivalrebels.common.entity.EntityRhodesRightUpperLeg;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderRhodesRightUpperLeg extends Render {
   public void renderRhodes(EntityRhodesRightUpperLeg rhodes, double x, double y, double z, float par8, float ptt) {
      GL11.glPushMatrix();
      GL11.glTranslatef((float)x, (float)y, (float)z);
      GL11.glScalef(rhodes.scale, rhodes.scale, rhodes.scale);
      GL11.glColor3f(RenderRhodes.colors[rhodes.color * 3], RenderRhodes.colors[rhodes.color * 3 + 1], RenderRhodes.colors[rhodes.color * 3 + 2]);
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RenderRhodes.texture);
      GL11.glDisable(2884);
      GL11.glRotatef(rhodes.field_70177_z, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(rhodes.field_70125_A, 1.0F, 0.0F, 0.0F);
      GL11.glTranslatef(-3.0F, 5.0F, 0.0F);
      RenderRhodes.thigh.renderAll();
      GL11.glPopMatrix();
   }

   public void func_76986_a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
      this.renderRhodes((EntityRhodesRightUpperLeg)par1Entity, par2, par4, par6, par8, par9);
   }

   protected ResourceLocation func_110775_a(Entity entity) {
      return null;
   }
}
