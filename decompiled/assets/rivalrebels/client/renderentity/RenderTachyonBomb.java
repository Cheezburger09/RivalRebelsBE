package assets.rivalrebels.client.renderentity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.entity.EntityTachyonBomb;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderTachyonBomb extends Render {
   public static IModelCustom bomb;

   public RenderTachyonBomb() {
      bomb = AdvancedModelLoader.loadModel(new ResourceLocation("rivalrebels", "models/t.obj"));
   }

   public void renderB83(EntityTachyonBomb b83, double x, double y, double z, float par8, float par9) {
      GL11.glDisable(2896);
      GL11.glPushMatrix();
      GL11.glTranslatef((float)x, (float)y, (float)z);
      GL11.glScalef(RivalRebels.nukeScale, RivalRebels.nukeScale, RivalRebels.nukeScale);
      GL11.glRotatef(b83.field_70177_z - 90.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(b83.field_70125_A, 0.0F, 0.0F, 1.0F);
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.ettachyonbomb);
      bomb.renderAll();
      GL11.glPopMatrix();
   }

   public void func_76986_a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
      this.renderB83((EntityTachyonBomb)par1Entity, par2, par4, par6, par8, par9);
   }

   protected ResourceLocation func_110775_a(Entity entity) {
      return null;
   }
}
