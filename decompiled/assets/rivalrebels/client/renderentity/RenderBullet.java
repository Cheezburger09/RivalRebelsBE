package assets.rivalrebels.client.renderentity;

import assets.rivalrebels.RivalRebels;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderBullet extends Render {
   private String path;

   public RenderBullet(String par1) {
      this.path = par1;
   }

   public void func_76986_a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
      if (par1Entity.field_70173_aa > 1) {
         GL11.glPushMatrix();
         GL11.glTranslatef((float)par2, (float)par4, (float)par6);
         GL11.glScalef(0.5F, 0.5F, 0.5F);
         if (this.path == "flame") {
            Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etflame);
         }

         if (this.path == "fire") {
            Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etfire);
         }

         Tessellator var10 = Tessellator.field_78398_a;
         this.func_77026_a(var10);
         GL11.glPopMatrix();
      }
   }

   private void func_77026_a(Tessellator par1Tessellator) {
      float var7 = 1.0F;
      float var8 = 0.5F;
      float var9 = 0.25F;
      GL11.glRotatef(180.0F - this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(-this.field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
      par1Tessellator.func_78382_b();
      par1Tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
      par1Tessellator.func_78374_a(0.0F - var8, 0.0F - var9, 0.0, 0.0, 0.0);
      par1Tessellator.func_78374_a(var7 - var8, 0.0F - var9, 0.0, 1.0, 0.0);
      par1Tessellator.func_78374_a(var7 - var8, var7 - var9, 0.0, 1.0, 1.0);
      par1Tessellator.func_78374_a(0.0F - var8, var7 - var9, 0.0, 0.0, 1.0);
      par1Tessellator.func_78381_a();
   }

   protected ResourceLocation func_110775_a(Entity entity) {
      return null;
   }
}
