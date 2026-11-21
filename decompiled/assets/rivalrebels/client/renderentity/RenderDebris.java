package assets.rivalrebels.client.renderentity;

import assets.rivalrebels.common.entity.EntityDebris;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class RenderDebris extends Render {
   private final RenderBlocks blockrenderer = new RenderBlocks();

   public RenderDebris() {
      this.field_76989_e = 0.5F;
   }

   public void func_76986_a(Entity e, double x, double y, double z, float pitch, float yaw) {
      GL11.glEnable(2896);
      if (!e.field_70128_L) {
         EntityDebris debris = (EntityDebris)e;
         World world = debris.field_70170_p;
         Block block = debris.block;
         int m = debris.metadata;
         int i = MathHelper.func_76128_c(debris.field_70165_t);
         int j = MathHelper.func_76128_c(debris.field_70163_u);
         int k = MathHelper.func_76128_c(debris.field_70161_v);
         if (block != null) {
            GL11.glPushMatrix();
            GL11.glTranslated(x, y, z);
            this.func_110777_b(debris);
            GL11.glDisable(2896);
            Tessellator tessellator = Tessellator.field_78398_a;
            this.blockrenderer.field_147845_a = world;
            block.func_149719_a(world, i, j, k);
            this.blockrenderer.func_147775_a(block);
            int color = block.func_149635_D();
            float r = (color >> 16 & 0xFF) / 255.0F;
            float g = (color >> 8 & 0xFF) / 255.0F;
            float b = (color & 0xFF) / 255.0F;
            tessellator.func_78382_b();
            tessellator.func_78380_c(block.func_149677_c(world, i, j, k));
            tessellator.func_78386_a(0.5F * r, 0.5F * g, 0.5F * b);
            this.blockrenderer.func_147768_a(block, -0.5, -0.5, -0.5, this.blockrenderer.func_147787_a(block, 0, m));
            tessellator.func_78386_a(r, g, b);
            this.blockrenderer.func_147806_b(block, -0.5, -0.5, -0.5, this.blockrenderer.func_147787_a(block, 1, m));
            tessellator.func_78386_a(0.8F * r, 0.8F * g, 0.8F * b);
            this.blockrenderer.func_147761_c(block, -0.5, -0.5, -0.5, this.blockrenderer.func_147787_a(block, 2, m));
            this.blockrenderer.func_147734_d(block, -0.5, -0.5, -0.5, this.blockrenderer.func_147787_a(block, 3, m));
            tessellator.func_78386_a(0.6F * r, 0.6F * g, 0.6F * b);
            this.blockrenderer.func_147798_e(block, -0.5, -0.5, -0.5, this.blockrenderer.func_147787_a(block, 4, m));
            this.blockrenderer.func_147764_f(block, -0.5, -0.5, -0.5, this.blockrenderer.func_147787_a(block, 5, m));
            tessellator.func_78381_a();
            GL11.glEnable(2896);
            GL11.glPopMatrix();
         }
      }
   }

   protected ResourceLocation func_110775_a(Entity r) {
      return TextureMap.field_110575_b;
   }
}
