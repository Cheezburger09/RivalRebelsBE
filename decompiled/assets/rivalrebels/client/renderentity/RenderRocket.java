package assets.rivalrebels.client.renderentity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.model.ModelRocket;
import assets.rivalrebels.common.entity.EntityRocket;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderRocket extends Render {
   ModelRocket md = new ModelRocket();

   public void renderRocket(EntityRocket rocket, double par2, double par4, double par6, float par8, float par9) {
      GL11.glEnable(2896);
      GL11.glPushMatrix();
      GL11.glTranslatef((float)par2, (float)par4, (float)par6);
      GL11.glRotatef(rocket.field_70177_z - 90.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(rocket.field_70125_A - 90.0F, 0.0F, 0.0F, 1.0F);
      GL11.glRotatef(rocket.rotation, 0.0F, 1.0F, 0.0F);
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etrocket);
      this.md.render(rocket.fins);
      GL11.glPopMatrix();
   }

   public void func_76986_a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
      this.renderRocket((EntityRocket)par1Entity, par2, par4, par6, par8, par9);
   }

   protected ResourceLocation func_110775_a(Entity entity) {
      return null;
   }
}
