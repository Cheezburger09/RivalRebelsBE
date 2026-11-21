package assets.rivalrebels.client.renderentity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.objfileloader.ModelFromObj;
import assets.rivalrebels.common.entity.EntityB2Spirit;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderB2Spirit extends Render {
   ModelFromObj b2;
   public static ModelFromObj shuttle;
   public static ModelFromObj tupolev;

   public RenderB2Spirit() {
      try {
         this.b2 = ModelFromObj.readObjFile("d.obj");
         this.b2.scale(3.0F, 3.0F, 3.0F);
         tupolev = ModelFromObj.readObjFile("tupolev.obj");
         shuttle = ModelFromObj.readObjFile("shuttle.obj");
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public void renderB2Spirit(EntityB2Spirit b2spirit, double x, double y, double z, float par8, float par9) {
      GL11.glEnable(2896);
      GL11.glPushMatrix();
      GL11.glTranslatef((float)x, (float)y, (float)z);
      GL11.glRotatef(b2spirit.field_70177_z, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(b2spirit.field_70125_A, 1.0F, 0.0F, 0.0F);
      GL11.glDisable(2884);
      if (RivalRebels.bombertype.equals("sh")) {
         GL11.glScalef(3.0F, 3.0F, 3.0F);
         Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etb2spirit);
         shuttle.render();
      } else if (RivalRebels.bombertype.equals("tu")) {
         Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.ettupolev);
         tupolev.render();
      } else {
         Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etb2spirit);
         this.b2.render();
      }

      GL11.glPopMatrix();
   }

   public void func_76986_a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
      this.renderB2Spirit((EntityB2Spirit)par1Entity, par2, par4, par6, par8, par9);
   }

   protected ResourceLocation func_110775_a(Entity entity) {
      return null;
   }
}
