package assets.rivalrebels.client.renderentity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.model.ModelBlastSphere;
import assets.rivalrebels.client.model.ModelNuclearBomb;
import assets.rivalrebels.common.entity.EntityBomb;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderBomb extends Render {
   private ModelNuclearBomb model;
   private ModelBlastSphere modelsphere = new ModelBlastSphere();

   public RenderBomb() {
      this.model = new ModelNuclearBomb();
   }

   public void renderB83(EntityBomb b83, double x, double y, double z, float par8, float par9) {
      GL11.glEnable(2896);
      GL11.glPushMatrix();
      GL11.glTranslatef((float)x, (float)y, (float)z);
      GL11.glRotatef(b83.field_70177_z - 90.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(b83.field_70125_A - 90.0F, 0.0F, 0.0F, 1.0F);
      if (b83.field_70159_w != 0.0 || b83.field_70179_y != 0.0) {
         Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etnuke);
         GL11.glScalef(0.25F, 0.5F, 0.25F);
         this.model.renderModel(true);
      } else if (b83.field_70181_x == 1.0) {
         this.modelsphere.renderModel(b83.field_70173_aa * 0.2F, 0.25F, 0.25F, 1.0F, 0.75F);
      } else if (b83.field_70181_x == 0.0) {
         this.modelsphere.renderModel(b83.field_70173_aa * 0.2F, 0.8F, 0.8F, 1.0F, 0.75F);
      }

      GL11.glPopMatrix();
   }

   public void func_76986_a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
      this.renderB83((EntityBomb)par1Entity, par2, par4, par6, par8, par9);
   }

   protected ResourceLocation func_110775_a(Entity entity) {
      return null;
   }
}
