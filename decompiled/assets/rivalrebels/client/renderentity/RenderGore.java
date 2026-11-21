package assets.rivalrebels.client.renderentity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.renderhelper.RenderHelper;
import assets.rivalrebels.common.entity.EntityGore;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderGore extends Render {
   private static final ResourceLocation player = new ResourceLocation("textures/entity/steve.png");
   private static final ResourceLocation creeper = new ResourceLocation("textures/entity/creeper/creeper.png");
   private static final ResourceLocation enderman = new ResourceLocation("textures/entity/enderman/enderman.png");
   private static final ResourceLocation ghast = new ResourceLocation("textures/entity/ghast/ghast.png");
   private static final ResourceLocation skeleton = new ResourceLocation("textures/entity/skeleton/skeleton.png");
   private static final ResourceLocation slime = new ResourceLocation("textures/entity/slime/slime.png");
   private static final ResourceLocation magmacube = new ResourceLocation("textures/entity/slime/magmacube.png");
   private static final ResourceLocation spider = new ResourceLocation("textures/entity/spider/spider.png");
   private static final ResourceLocation cavespider = new ResourceLocation("textures/entity/spider/cave_spider.png");
   private static final ResourceLocation zombiepigman = new ResourceLocation("textures/entity/zombie_pigman.png");
   private static final ResourceLocation zombie = new ResourceLocation("textures/entity/zombie/zombie.png");
   RenderHelper md = new RenderHelper();

   public void func_76986_a(Entity entity, double x, double y, double z, float f, float f1) {
      GL11.glPushMatrix();
      GL11.glEnable(2896);
      GL11.glTranslated(x, y, z);
      GL11.glRotatef(-entity.field_70177_z + 180.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(entity.field_70125_A, 1.0F, 0.0F, 0.0F);
      EntityGore eg = (EntityGore)entity;
      int mob = eg.mob;
      int type = eg.type;
      double size = eg.size;
      if (mob == 0) {
         if (eg.playerSkin != null) {
            Minecraft.func_71410_x().field_71446_o.func_110577_a(eg.playerSkin);
         } else {
            Minecraft.func_71410_x().field_71446_o.func_110577_a(player);
         }

         if (type == 0) {
            RenderHelper.renderBox(8.0F, 8.0F, 8.0F, 0.0F, 0.0F, 64.0F, 32.0F, 16.0F);
         } else if (type == 1) {
            RenderHelper.renderBox(4.0F, 12.0F, 8.0F, 16.0F, 16.0F, 64.0F, 32.0F, 16.0F);
         } else if (type == 2) {
            RenderHelper.renderBox(4.0F, 12.0F, 4.0F, 40.0F, 16.0F, 64.0F, 32.0F, 16.0F);
         } else if (type == 3) {
            RenderHelper.renderBox(4.0F, 12.0F, 4.0F, 0.0F, 16.0F, 64.0F, 32.0F, 16.0F);
         }
      } else if (mob == 1) {
         Minecraft.func_71410_x().field_71446_o.func_110577_a(zombie);
         if (type == 0) {
            RenderHelper.renderBox(8.0F, 8.0F, 8.0F, 0.0F, 0.0F, 64.0F, 64.0F, 16.0F);
         } else if (type == 1) {
            RenderHelper.renderBox(4.0F, 12.0F, 8.0F, 16.0F, 16.0F, 64.0F, 64.0F, 16.0F);
         } else if (type == 2) {
            RenderHelper.renderBox(4.0F, 12.0F, 4.0F, 40.0F, 16.0F, 64.0F, 64.0F, 16.0F);
         } else if (type == 3) {
            RenderHelper.renderBox(4.0F, 12.0F, 4.0F, 0.0F, 16.0F, 64.0F, 64.0F, 16.0F);
         }
      } else if (mob == 2) {
         Minecraft.func_71410_x().field_71446_o.func_110577_a(zombiepigman);
         if (type == 0) {
            RenderHelper.renderBox(8.0F, 8.0F, 8.0F, 0.0F, 0.0F, 64.0F, 64.0F, 16.0F);
         } else if (type == 1) {
            RenderHelper.renderBox(4.0F, 12.0F, 8.0F, 16.0F, 16.0F, 64.0F, 64.0F, 16.0F);
         } else if (type == 2) {
            RenderHelper.renderBox(4.0F, 12.0F, 4.0F, 40.0F, 16.0F, 64.0F, 64.0F, 16.0F);
         } else if (type == 3) {
            RenderHelper.renderBox(4.0F, 12.0F, 4.0F, 0.0F, 16.0F, 64.0F, 64.0F, 16.0F);
         }
      } else if (mob == 3) {
         Minecraft.func_71410_x().field_71446_o.func_110577_a(skeleton);
         GL11.glDisable(2884);
         if (type == 0) {
            RenderHelper.renderBox(8.0F, 8.0F, 8.0F, 0.0F, 0.0F, 64.0F, 32.0F, 16.0F);
         } else if (type == 1) {
            RenderHelper.renderBox(4.0F, 12.0F, 8.0F, 16.0F, 16.0F, 64.0F, 32.0F, 16.0F);
         } else if (type == 2) {
            RenderHelper.renderBox(2.0F, 10.0F, 2.0F, 40.0F, 16.0F, 64.0F, 32.0F, 16.0F);
         } else if (type == 3) {
            RenderHelper.renderBox(2.0F, 10.0F, 2.0F, 0.0F, 16.0F, 64.0F, 32.0F, 16.0F);
         }
      } else if (mob == 4) {
         Minecraft.func_71410_x().field_71446_o.func_110577_a(enderman);
         if (type == 0) {
            RenderHelper.renderBox(8.0F, 8.0F, 8.0F, 0.0F, 0.0F, 64.0F, 32.0F, 16.0F);
            GL11.glTranslated(0.0, -0.125, 0.0);
            GL11.glScaled(0.875, 0.875, 0.875);
            RenderHelper.renderBox(8.0F, 8.0F, 8.0F, 0.0F, 16.0F, 64.0F, 32.0F, 16.0F);
         } else if (type == 1) {
            RenderHelper.renderBox(4.0F, 12.0F, 8.0F, 32.0F, 16.0F, 64.0F, 32.0F, 16.0F);
         } else if (type == 2) {
            RenderHelper.renderBox(2.0F, 30.0F, 2.0F, 56.0F, 0.0F, 64.0F, 32.0F, 16.0F);
         } else if (type == 3) {
            RenderHelper.renderBox(2.0F, 30.0F, 2.0F, 56.0F, 0.0F, 64.0F, 32.0F, 16.0F);
         }
      } else if (mob == 5) {
         Minecraft.func_71410_x().field_71446_o.func_110577_a(creeper);
         if (type == 0) {
            RenderHelper.renderBox(8.0F, 8.0F, 8.0F, 0.0F, 0.0F, 64.0F, 32.0F, 16.0F);
         } else if (type == 1) {
            RenderHelper.renderBox(4.0F, 12.0F, 8.0F, 16.0F, 16.0F, 64.0F, 32.0F, 16.0F);
         } else if (type == 3) {
            RenderHelper.renderBox(4.0F, 6.0F, 4.0F, 0.0F, 16.0F, 64.0F, 32.0F, 16.0F);
         }
      } else if (mob == 6) {
         Minecraft.func_71410_x().field_71446_o.func_110577_a(slime);
         if (type == 0) {
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            RenderHelper.renderBox(8.0F, 8.0F, 8.0F, 0.0F, 0.0F, 64.0F, 32.0F, 16.0F);
         } else if (type == 1) {
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            RenderHelper.renderBox(6.0F, 6.0F, 6.0F, 0.0F, 16.0F, 64.0F, 32.0F, 16.0F);
         }
      } else if (mob == 7) {
         Minecraft.func_71410_x().field_71446_o.func_110577_a(magmacube);
         if (type == 0) {
            RenderHelper.renderBox(8.0F, 8.0F, 8.0F, 0.0F, 0.0F, 64.0F, 32.0F, 16.0F);
         } else if (type == 1) {
            RenderHelper.renderBox(6.0F, 6.0F, 6.0F, 0.0F, 16.0F, 64.0F, 32.0F, 16.0F);
         }
      } else if (mob == 8) {
         Minecraft.func_71410_x().field_71446_o.func_110577_a(spider);
         if (type == 0) {
            RenderHelper.renderBox(8.0F, 8.0F, 8.0F, 32.0F, 4.0F, 64.0F, 32.0F, 16.0F);
         } else if (type == 1) {
            GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
            RenderHelper.renderBox(8.0F, 12.0F, 10.0F, 4.0F, 12.0F, 64.0F, 32.0F, 16.0F);
         } else if (type == 3) {
            RenderHelper.renderBox(2.0F, 2.0F, 16.0F, 18.0F, 0.0F, 64.0F, 32.0F, 16.0F);
         }
      } else if (mob == 9) {
         Minecraft.func_71410_x().field_71446_o.func_110577_a(cavespider);
         GL11.glScalef(0.666F, 0.666F, 0.666F);
         if (type == 0) {
            RenderHelper.renderBox(8.0F, 8.0F, 8.0F, 32.0F, 4.0F, 64.0F, 32.0F, 16.0F);
         } else if (type == 1) {
            GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
            RenderHelper.renderBox(8.0F, 12.0F, 10.0F, 4.0F, 12.0F, 64.0F, 32.0F, 16.0F);
         } else if (type == 3) {
            RenderHelper.renderBox(2.0F, 2.0F, 16.0F, 18.0F, 0.0F, 64.0F, 32.0F, 16.0F);
         }
      } else if (mob == 10) {
         Minecraft.func_71410_x().field_71446_o.func_110577_a(ghast);
         if (type == 0) {
            RenderHelper.renderBox(16.0F, 16.0F, 16.0F, 0.0F, 0.0F, 64.0F, 32.0F, 4.0F);
         } else if (type == 3) {
            RenderHelper.renderBox(2.0F, 14.0F, 2.0F, 0.0F, 0.0F, 64.0F, 32.0F, 4.0F);
         }
      } else if (mob == 11) {
         if (size < 1.0) {
            Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.btsplash5);
         } else if (size < 2.0) {
            Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.btsplash1);
         } else {
            Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.btsplash3);
         }

         if (type == 0) {
            RenderHelper.renderBox((int)(8.0 * size), (int)(8.0 * size), (int)(8.0 * size), 0.0F, 0.0F, 64.0F, 64.0F, 16.0F);
         } else if (type == 1) {
            RenderHelper.renderBox((int)(4.0 * size), (int)(12.0 * size), (int)(8.0 * size), 0.0F, 0.0F, 64.0F, 64.0F, 16.0F);
         } else if (type == 2) {
            RenderHelper.renderBox((int)(4.0 * size), (int)(12.0 * size), (int)(4.0 * size), 0.0F, 0.0F, 64.0F, 64.0F, 16.0F);
         } else if (type == 3) {
            RenderHelper.renderBox((int)(4.0 * size), (int)(12.0 * size), (int)(4.0 * size), 0.0F, 0.0F, 64.0F, 64.0F, 16.0F);
         }
      }

      GL11.glPopMatrix();
   }

   protected ResourceLocation func_110775_a(Entity entity) {
      return null;
   }
}
