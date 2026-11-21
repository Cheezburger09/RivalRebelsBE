package assets.rivalrebels.client.renderentity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.objfileloader.ModelFromObj;
import assets.rivalrebels.common.entity.EntityB2Frag;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderB2Frag extends Render {
   ModelFromObj md1;
   ModelFromObj md2;

   public RenderB2Frag() {
      try {
         this.md1 = ModelFromObj.readObjFile("f.obj");
         this.md1.scale(3.0F, 3.0F, 3.0F);
         this.md2 = ModelFromObj.readObjFile("g.obj");
         this.md2.scale(3.0F, 3.0F, 3.0F);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public void renderB2Frag(EntityB2Frag b2spirit, double x, double y, double z, float par8, float par9) {
      GL11.glEnable(2896);
      GL11.glPushMatrix();
      GL11.glTranslatef((float)x, (float)y, (float)z);
      GL11.glRotatef(b2spirit.field_70177_z, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(b2spirit.field_70125_A, 0.0F, 0.0F, 1.0F);
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etb2spirit);
      GL11.glDisable(2884);
      if (b2spirit.type == 0) {
         this.md1.render();
      }

      if (b2spirit.type == 1) {
         this.md2.render();
      }

      GL11.glPopMatrix();
   }

   public void func_76986_a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
      this.renderB2Frag((EntityB2Frag)par1Entity, par2, par4, par6, par8, par9);
   }

   protected ResourceLocation func_110775_a(Entity entity) {
      return null;
   }
}
