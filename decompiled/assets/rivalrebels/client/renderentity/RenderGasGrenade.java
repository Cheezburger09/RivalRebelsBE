package assets.rivalrebels.client.renderentity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.entity.EntityGasGrenade;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderGasGrenade extends Render {
   public void renderGasGrenade(EntityGasGrenade par1EntityArrow, double par2, double par4, double par6, float par8, float par9) {
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etgasgrenade);
      GL11.glEnable(2896);
      GL11.glPushMatrix();
      GL11.glTranslatef((float)par2, (float)par4, (float)par6);
      GL11.glRotatef(par1EntityArrow.field_70126_B + (par1EntityArrow.field_70177_z - par1EntityArrow.field_70126_B) * par9 - 90.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(par1EntityArrow.field_70127_C + (par1EntityArrow.field_70125_A - par1EntityArrow.field_70127_C) * par9, 0.0F, 0.0F, 1.0F);
      Tessellator var10 = Tessellator.field_78398_a;
      byte var11 = 0;
      float var12 = 0.0F;
      float var13 = 0.5F;
      float var14 = (0 + var11 * 10) / 32.0F;
      float var15 = (5 + var11 * 10) / 32.0F;
      float var16 = 0.0F;
      float var17 = 0.15625F;
      float var18 = (5 + var11 * 10) / 32.0F;
      float var19 = (10 + var11 * 10) / 32.0F;
      float var20 = 0.05625F;
      GL11.glRotatef(45.0F, 1.0F, 0.0F, 0.0F);
      GL11.glScalef(var20, var20, var20);
      GL11.glTranslatef(-4.0F, 0.0F, 0.0F);
      GL11.glNormal3f(var20, 0.0F, 0.0F);
      var10.func_78382_b();
      var10.func_78374_a(-7.0, -2.0, -2.0, var16, var18);
      var10.func_78374_a(-7.0, -2.0, 2.0, var17, var18);
      var10.func_78374_a(-7.0, 2.0, 2.0, var17, var19);
      var10.func_78374_a(-7.0, 2.0, -2.0, var16, var19);
      var10.func_78381_a();
      GL11.glNormal3f(-var20, 0.0F, 0.0F);
      var10.func_78382_b();
      var10.func_78374_a(-7.0, 2.0, -2.0, var16, var18);
      var10.func_78374_a(-7.0, 2.0, 2.0, var17, var18);
      var10.func_78374_a(-7.0, -2.0, 2.0, var17, var19);
      var10.func_78374_a(-7.0, -2.0, -2.0, var16, var19);
      var10.func_78381_a();

      for (int var23 = 0; var23 < 4; var23++) {
         GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
         GL11.glNormal3f(0.0F, 0.0F, var20);
         var10.func_78382_b();
         var10.func_78374_a(-8.0, -2.0, 0.0, var12, var14);
         var10.func_78374_a(8.0, -2.0, 0.0, var13, var14);
         var10.func_78374_a(8.0, 2.0, 0.0, var13, var15);
         var10.func_78374_a(-8.0, 2.0, 0.0, var12, var15);
         var10.func_78381_a();
      }

      GL11.glPopMatrix();
   }

   public void func_76986_a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
      this.renderGasGrenade((EntityGasGrenade)par1Entity, par2, par4, par6, par8, par9);
   }

   protected ResourceLocation func_110775_a(Entity entity) {
      return null;
   }
}
