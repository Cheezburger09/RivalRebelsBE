package assets.rivalrebels.client.renderentity;

import assets.rivalrebels.RivalRebels;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderGoo extends Render {
   public void func_76986_a(Entity entity, double x, double y, double z, float f, float f1) {
      if (entity.field_70173_aa > 1) {
         GL11.glPushMatrix();
         GL11.glTranslatef((float)x, (float)y, (float)z);
         GL11.glScalef(0.25F, 0.25F, 0.25F);
         Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etgoo);
         this.renderFaceMe();
         GL11.glPopMatrix();
      }
   }

   private void renderFaceMe() {
      float var7 = 1.0F;
      float var8 = 0.5F;
      float var9 = 0.25F;
      Tessellator t = Tessellator.field_78398_a;
      GL11.glRotatef(180.0F - this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(-this.field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
      t.func_78382_b();
      t.func_78375_b(0.0F, 1.0F, 0.0F);
      t.func_78374_a(0.0F - var8, 0.0F - var9, 0.0, 0.0, 0.0);
      t.func_78374_a(var7 - var8, 0.0F - var9, 0.0, 1.0, 0.0);
      t.func_78374_a(var7 - var8, var7 - var9, 0.0, 1.0, 1.0);
      t.func_78374_a(0.0F - var8, var7 - var9, 0.0, 0.0, 1.0);
      t.func_78381_a();
   }

   protected ResourceLocation func_110775_a(Entity entity) {
      return null;
   }
}
