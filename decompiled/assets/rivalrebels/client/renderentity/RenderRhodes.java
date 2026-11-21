package assets.rivalrebels.client.renderentity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.model.ModelBlastSphere;
import assets.rivalrebels.client.objfileloader.ModelFromObj;
import assets.rivalrebels.client.tileentityrender.TileEntityForceFieldNodeRenderer;
import assets.rivalrebels.common.entity.EntityRhodes;
import assets.rivalrebels.common.round.RivalRebelsPlayer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderRhodes extends Render {
   public static ResourceLocation texture;
   public static ResourceLocation flametex;
   public static IModelCustom head;
   public static IModelCustom torso;
   public static IModelCustom flag;
   public static IModelCustom upperarm;
   public static IModelCustom lowerarm;
   public static IModelCustom flamethrower;
   public static IModelCustom rocketlauncher;
   public static IModelCustom thigh;
   public static IModelCustom shin;
   private static IModelCustom booster;
   private static IModelCustom flame;
   private static IModelCustom laser;
   public static IModelCustom ffhead;
   public static IModelCustom fftorso;
   public static IModelCustom ffupperarm;
   public static IModelCustom fflowerarm;
   public static IModelCustom ffthigh;
   public static IModelCustom ffshin;
   private ModelBlastSphere modelsphere;
   public static ModelFromObj md;
   public static ModelFromObj b2jet;
   public static String[] texfolders = new String[]{"blocks/", "entity/", "items/", "flags/"};
   public static float[] colors = new float[]{
      1.0F,
      1.0F,
      1.0F,
      0.49019608F,
      0.5568628F,
      0.7058824F,
      0.57254905F,
      0.26666668F,
      0.26666668F,
      0.4F,
      0.4F,
      0.3764706F,
      0.8509804F,
      0.7921569F,
      0.46666667F,
      0.6901961F,
      0.49803922F,
      0.98039216F,
      0.6F,
      0.5372549F,
      0.34901962F,
      0.99215686F,
      0.69803923F,
      0.5568628F,
      0.44705883F,
      0.73333335F,
      1.0F,
      0.9843137F,
      0.81960785F,
      0.38039216F,
      0.5372549F,
      0.627451F,
      0.56078434F,
      0.9019608F,
      0.5882353F,
      0.98039216F,
      0.5058824F,
      0.48235294F,
      0.6392157F,
      0.827451F,
      0.92156863F,
      0.44313726F,
      0.5686275F,
      0.6392157F,
      0.6862745F,
      0.13333334F,
      0.12156863F,
      0.12156863F,
      1.0F,
      1.0F,
      1.0F
   };

   public RenderRhodes() {
      texture = new ResourceLocation("rivalrebels", "textures/entity/rhodes.png");
      flametex = new ResourceLocation("rivalrebels", "textures/entity/flame.png");
      head = AdvancedModelLoader.loadModel(new ResourceLocation("rivalrebels", "models/rhodes/head.obj"));
      torso = AdvancedModelLoader.loadModel(new ResourceLocation("rivalrebels", "models/rhodes/torso.obj"));
      flag = AdvancedModelLoader.loadModel(new ResourceLocation("rivalrebels", "models/rhodes/flag.obj"));
      upperarm = AdvancedModelLoader.loadModel(new ResourceLocation("rivalrebels", "models/rhodes/upperarm.obj"));
      lowerarm = AdvancedModelLoader.loadModel(new ResourceLocation("rivalrebels", "models/rhodes/lowerarm.obj"));
      flamethrower = AdvancedModelLoader.loadModel(new ResourceLocation("rivalrebels", "models/rhodes/flamethrower.obj"));
      rocketlauncher = AdvancedModelLoader.loadModel(new ResourceLocation("rivalrebels", "models/rhodes/rocketlauncher.obj"));
      thigh = AdvancedModelLoader.loadModel(new ResourceLocation("rivalrebels", "models/rhodes/thigh.obj"));
      shin = AdvancedModelLoader.loadModel(new ResourceLocation("rivalrebels", "models/rhodes/shin.obj"));
      flame = AdvancedModelLoader.loadModel(new ResourceLocation("rivalrebels", "models/rhodes/flame.obj"));
      laser = AdvancedModelLoader.loadModel(new ResourceLocation("rivalrebels", "models/rhodes/laser.obj"));
      booster = AdvancedModelLoader.loadModel(new ResourceLocation("rivalrebels", "models/booster.obj"));
      ffhead = AdvancedModelLoader.loadModel(new ResourceLocation("rivalrebels", "models/rhodes/ffhead.obj"));
      fftorso = AdvancedModelLoader.loadModel(new ResourceLocation("rivalrebels", "models/rhodes/fftorso.obj"));
      ffupperarm = AdvancedModelLoader.loadModel(new ResourceLocation("rivalrebels", "models/rhodes/ffupperarm.obj"));
      fflowerarm = AdvancedModelLoader.loadModel(new ResourceLocation("rivalrebels", "models/rhodes/fflowerarm.obj"));
      ffthigh = AdvancedModelLoader.loadModel(new ResourceLocation("rivalrebels", "models/rhodes/ffthigh.obj"));
      ffshin = AdvancedModelLoader.loadModel(new ResourceLocation("rivalrebels", "models/rhodes/ffshin.obj"));
      this.modelsphere = new ModelBlastSphere();

      try {
         md = ModelFromObj.readObjFile("d.obj");
         b2jet = ModelFromObj.readObjFile("s.obj");
         md.scale(2.5F, 2.5F, 2.5F);
         b2jet.scale(2.5F, 2.5F, 2.5F);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public void renderRhodes(EntityRhodes rhodes, double x, double y, double z, float par8, float tt) {
      if (rhodes.health > 0) {
         float ptt = Math.min((rhodes.ticksSinceLastPacket + tt) / 5.0F, 1.0F);
         if (rhodes.field_70173_aa < 10) {
            ptt = 1.0F;
         }

         GL11.glPushMatrix();
         GL11.glTranslatef((float)x, (float)y, (float)z);
         GL11.glScalef(rhodes.scale, rhodes.scale, rhodes.scale);
         FontRenderer fontrenderer = this.func_76983_a();
         float f = 5.0F;
         float f1 = 0.016666668F * f;
         GL11.glPushMatrix();
         GL11.glTranslatef(0.0F, 16.0F, 0.0F);
         GL11.glNormal3f(0.0F, 1.0F, 0.0F);
         GL11.glRotatef(-this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(this.field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
         GL11.glScalef(-f1, -f1, f1);
         GL11.glDisable(2896);
         GL11.glDepthMask(false);
         GL11.glDisable(2929);
         GL11.glEnable(3042);
         OpenGlHelper.func_148821_a(770, 771, 1, 0);
         Tessellator tessellator = Tessellator.field_78398_a;
         GL11.glDisable(3553);
         tessellator.func_78382_b();
         String name = rhodes.getName();
         int color = -1;
         if (rhodes.rider != null) {
            name = name + " - " + rhodes.rider.getDisplayName();
            RivalRebelsPlayer rrp = RivalRebels.round.rrplayerlist.getForName(rhodes.rider.func_70005_c_());
            if (rrp != null) {
               switch (rrp.rrteam) {
                  case OMEGA:
                     color = 4521796;
                     break;
                  case SIGMA:
                     color = 4474111;
                     break;
                  case NONE:
                     color = -1;
               }
            }
         }

         int j = fontrenderer.func_78256_a(name) / 2;
         tessellator.func_78369_a(0.0F, 0.0F, 0.0F, 0.25F);
         tessellator.func_78377_a(-j - 1, -1.0, 0.0);
         tessellator.func_78377_a(-j - 1, 8.0, 0.0);
         tessellator.func_78377_a(j + 1, 8.0, 0.0);
         tessellator.func_78377_a(j + 1, -1.0, 0.0);
         tessellator.func_78381_a();
         GL11.glEnable(3553);
         fontrenderer.func_78276_b(name, -fontrenderer.func_78256_a(name) / 2, 0, color);
         GL11.glEnable(2929);
         GL11.glDepthMask(true);
         fontrenderer.func_78276_b(name, -fontrenderer.func_78256_a(name) / 2, 0, color);
         GL11.glEnable(2896);
         GL11.glDisable(3042);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GL11.glPopMatrix();
         if (rhodes.colorType == 16) {
            GL11.glPushMatrix();
            GL11.glRotatef(rhodes.getbodyyaw(ptt), 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(0.0F, 10.0F, 0.0F);
            Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etbooster);
            booster.renderAll();
            Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etb2spirit);
            GL11.glPushMatrix();
            GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
            GL11.glTranslatef(0.0F, 4.0F, -2.0F);
            GL11.glScalef(2.2F, 2.2F, 2.2F);
            if (rhodes.b2energy > 0) {
               RenderB2Spirit.shuttle.render();
            }

            GL11.glPopMatrix();
            GL11.glPopMatrix();
         } else {
            Minecraft.func_71410_x().field_71446_o.func_110577_a(texture);
            GL11.glTexParameteri(3553, 10241, 9729);
            GL11.glTexParameteri(3553, 10240, 9729);
            GL11.glDisable(2884);
            GL11.glRotatef(rhodes.getbodyyaw(ptt), 0.0F, 1.0F, 0.0F);
            float leftlegheight = -7.73244F
               + MathHelper.func_76134_b((rhodes.getleftthighpitch(ptt) + 11.99685F) * (float) (Math.PI / 180.0)) * 7.3316913F
               + MathHelper.func_76134_b((rhodes.getleftthighpitch(ptt) + rhodes.getleftshinpitch(ptt) - 12.215306F) * (float) (Math.PI / 180.0)) * 8.521366F;
            float rightlegheight = -7.73244F
               + MathHelper.func_76134_b((rhodes.getrightthighpitch(ptt) + 11.99685F) * (float) (Math.PI / 180.0)) * 7.3316913F
               + MathHelper.func_76134_b((rhodes.getrightthighpitch(ptt) + rhodes.getrightshinpitch(ptt) - 12.215306F) * (float) (Math.PI / 180.0)) * 8.521366F;
            GL11.glPushMatrix();
            GL11.glColor3f(colors[rhodes.colorType * 3], colors[rhodes.colorType * 3 + 1], colors[rhodes.colorType * 3 + 2]);
            GL11.glTranslatef(0.0F, leftlegheight > rightlegheight ? leftlegheight : rightlegheight, 0.0F);
            Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etb2spirit);
            GL11.glPushMatrix();
            GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
            GL11.glTranslatef(0.0F, 4.0F, -2.0F);
            if (rhodes.b2energy > 0) {
               md.render();
            }

            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 1);
            Minecraft.func_71410_x().field_71446_o.func_110577_a(flametex);
            GL11.glTexParameteri(3553, 10241, 9729);
            GL11.glTexParameteri(3553, 10240, 9729);
            if (rhodes.jet && rhodes.b2energy > 0) {
               b2jet.render();
            }

            GL11.glDisable(3042);
            GL11.glPopMatrix();
            Minecraft.func_71410_x().field_71446_o.func_110577_a(texture);
            torso.renderAll();
            GL11.glPushMatrix();
            GL11.glTranslatef(-6.4F, 0.0F, 0.0F);
            GL11.glRotatef(rhodes.getrightarmyaw(ptt), 0.0F, 1.0F, 0.0F);
            GL11.glScalef(-1.0F, 1.0F, 1.0F);
            upperarm.renderAll();
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, -1.5F, 0.0F);
            GL11.glRotatef(rhodes.getrightarmpitch(ptt), 1.0F, 0.0F, 0.0F);
            lowerarm.renderAll();
            GL11.glScalef(-1.0F, 1.0F, 1.0F);
            flamethrower.renderAll();
            GL11.glPopMatrix();
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glTranslatef(6.4F, 0.0F, 0.0F);
            GL11.glRotatef(rhodes.getleftarmyaw(ptt), 0.0F, 1.0F, 0.0F);
            upperarm.renderAll();
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, -1.5F, 0.0F);
            GL11.glRotatef(rhodes.getleftarmpitch(ptt), 1.0F, 0.0F, 0.0F);
            lowerarm.renderAll();
            rocketlauncher.renderAll();
            GL11.glPopMatrix();
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, -7.26756F, -0.27904F);
            GL11.glRotatef(rhodes.getrightthighpitch(ptt), 1.0F, 0.0F, 0.0F);
            GL11.glScalef(-1.0F, 1.0F, 1.0F);
            thigh.renderAll();
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, -7.17156F, -1.52395F);
            GL11.glRotatef(rhodes.getrightshinpitch(ptt), 1.0F, 0.0F, 0.0F);
            shin.renderAll();
            if (rhodes.field_70151_c) {
               GL11.glEnable(3042);
               GL11.glBlendFunc(770, 1);
               Minecraft.func_71410_x().field_71446_o.func_110577_a(flametex);
               GL11.glTexParameteri(3553, 10241, 9729);
               GL11.glTexParameteri(3553, 10240, 9729);
               flame.renderAll();
               Minecraft.func_71410_x().field_71446_o.func_110577_a(texture);
               GL11.glDisable(3042);
            }

            GL11.glPopMatrix();
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, -7.26756F, -0.27904F);
            GL11.glRotatef(rhodes.getleftthighpitch(ptt), 1.0F, 0.0F, 0.0F);
            thigh.renderAll();
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, -7.17156F, -1.52395F);
            GL11.glRotatef(rhodes.getleftshinpitch(ptt), 1.0F, 0.0F, 0.0F);
            shin.renderAll();
            if (rhodes.field_70151_c) {
               GL11.glEnable(3042);
               GL11.glBlendFunc(770, 1);
               Minecraft.func_71410_x().field_71446_o.func_110577_a(flametex);
               flame.renderAll();
               Minecraft.func_71410_x().field_71446_o.func_110577_a(texture);
               GL11.glDisable(3042);
            }

            GL11.glPopMatrix();
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 5.23244F, 0.0F);
            GL11.glRotatef(rhodes.getheadpitch(ptt), 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(rhodes.getheadyaw(ptt), 0.0F, 1.0F, 0.0F);
            head.renderAll();
            GL11.glEnable(2884);
            GL11.glEnable(3042);
            GL11.glBlendFunc(1, 1);
            GL11.glDisable(3553);
            GL11.glColor4f(1.0F, 0.0F, 0.0F, 0.5F);
            if ((rhodes.laserOn & 1) == 1) {
               laser.renderAll();
            }

            if ((rhodes.laserOn & 2) == 2) {
               GL11.glScalef(1.0F, -1.0F, 1.0F);
               GL11.glCullFace(1028);
               laser.renderAll();
               GL11.glCullFace(1029);
            }

            GL11.glEnable(3553);
            GL11.glDisable(2884);
            GL11.glDisable(3042);
            GL11.glPopMatrix();
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glColor3f(1.0F, 1.0F, 1.0F);
            GL11.glTranslatef(0.0F, leftlegheight > rightlegheight ? leftlegheight : rightlegheight, 0.0F);
            if (rhodes.itexfolder != -1) {
               try {
                  Minecraft.func_71410_x()
                     .field_71446_o
                     .func_110577_a(new ResourceLocation("rivalrebels", "textures/" + texfolders[rhodes.itexfolder] + rhodes.itexloc + ".png"));
                  flag.renderAll();
               } catch (Exception var21) {
               }
            }

            if (rhodes.forcefield) {
               GL11.glBindTexture(
                  3553, TileEntityForceFieldNodeRenderer.id[(int)(TileEntityForceFieldNodeRenderer.getTime() / 100L % TileEntityForceFieldNodeRenderer.frames)]
               );
               GL11.glEnable(3042);
               GL11.glBlendFunc(770, 1);
               GL11.glDisable(2896);
               fftorso.renderAll();
               GL11.glPushMatrix();
               GL11.glTranslatef(-6.4F, 0.0F, 0.0F);
               GL11.glRotatef(rhodes.getrightarmyaw(ptt), 0.0F, 1.0F, 0.0F);
               GL11.glScalef(-1.0F, 1.0F, 1.0F);
               ffupperarm.renderAll();
               GL11.glPushMatrix();
               GL11.glTranslatef(0.0F, -1.5F, 0.0F);
               GL11.glRotatef(rhodes.getrightarmpitch(ptt), 1.0F, 0.0F, 0.0F);
               fflowerarm.renderAll();
               GL11.glPopMatrix();
               GL11.glPopMatrix();
               GL11.glPushMatrix();
               GL11.glTranslatef(6.4F, 0.0F, 0.0F);
               GL11.glRotatef(rhodes.getleftarmyaw(ptt), 0.0F, 1.0F, 0.0F);
               ffupperarm.renderAll();
               GL11.glPushMatrix();
               GL11.glTranslatef(0.0F, -1.5F, 0.0F);
               GL11.glRotatef(rhodes.getleftarmpitch(ptt), 1.0F, 0.0F, 0.0F);
               fflowerarm.renderAll();
               GL11.glPopMatrix();
               GL11.glPopMatrix();
               GL11.glPushMatrix();
               GL11.glTranslatef(0.0F, -7.26756F, -0.27904F);
               GL11.glRotatef(rhodes.getrightthighpitch(ptt), 1.0F, 0.0F, 0.0F);
               GL11.glScalef(-1.0F, 1.0F, 1.0F);
               ffthigh.renderAll();
               GL11.glPushMatrix();
               GL11.glTranslatef(0.0F, -7.17156F, -1.52395F);
               GL11.glRotatef(rhodes.getrightshinpitch(ptt), 1.0F, 0.0F, 0.0F);
               ffshin.renderAll();
               GL11.glPopMatrix();
               GL11.glPopMatrix();
               GL11.glPushMatrix();
               GL11.glTranslatef(0.0F, -7.26756F, -0.27904F);
               GL11.glRotatef(rhodes.getleftthighpitch(ptt), 1.0F, 0.0F, 0.0F);
               ffthigh.renderAll();
               GL11.glPushMatrix();
               GL11.glTranslatef(0.0F, -7.17156F, -1.52395F);
               GL11.glRotatef(rhodes.getleftshinpitch(ptt), 1.0F, 0.0F, 0.0F);
               ffshin.renderAll();
               GL11.glPopMatrix();
               GL11.glPopMatrix();
               GL11.glPushMatrix();
               GL11.glTranslatef(0.0F, 5.23244F, 0.0F);
               GL11.glRotatef(rhodes.getheadpitch(ptt), 1.0F, 0.0F, 0.0F);
               GL11.glRotatef(rhodes.getheadyaw(ptt), 0.0F, 1.0F, 0.0F);
               ffhead.renderAll();
               GL11.glPopMatrix();
               GL11.glDisable(3042);
               GL11.glEnable(2896);
            }

            GL11.glPopMatrix();
         }

         GL11.glPopMatrix();
      }

      if (rhodes.health < 1) {
         GL11.glPushMatrix();
         GL11.glTranslatef((float)x, (float)y, (float)z);
         GL11.glDisable(2884);
         GL11.glEnable(3042);
         GL11.glBlendFunc(1, 1);
         GL11.glDisable(3553);
         double elev = Math.sin((rhodes.health - tt) * -0.0314159265359) * 15.0;
         GL11.glPushMatrix();
         GL11.glRotatef((float)(elev * 2.0), 0.0F, 1.0F, 0.0F);
         GL11.glRotatef((float)(elev * 3.0), 1.0F, 0.0F, 0.0F);
         this.modelsphere.renderModel((float)elev, 1.0F, 0.25F, 0.0F, 1.0F);
         GL11.glPopMatrix();
         GL11.glPushMatrix();
         GL11.glRotatef((float)(elev * -2.0), 0.0F, 1.0F, 0.0F);
         GL11.glRotatef((float)(elev * 4.0), 0.0F, 0.0F, 1.0F);
         this.modelsphere.renderModel((float)(elev - 0.2F), 1.0F, 0.5F, 0.0F, 1.0F);
         GL11.glPopMatrix();
         GL11.glPushMatrix();
         GL11.glRotatef((float)(elev * -3.0), 1.0F, 0.0F, 0.0F);
         GL11.glRotatef((float)(elev * 2.0), 0.0F, 0.0F, 1.0F);
         this.modelsphere.renderModel((float)(elev - 0.4F), 1.0F, 0.0F, 0.0F, 1.0F);
         GL11.glPopMatrix();
         GL11.glPushMatrix();
         GL11.glRotatef((float)(elev * -1.0), 0.0F, 1.0F, 0.0F);
         GL11.glRotatef((float)(elev * 3.0), 0.0F, 0.0F, 1.0F);
         this.modelsphere.renderModel((float)(elev - 0.6F), 1.0F, 1.0F, 0.0F, 1.0F);
         GL11.glPopMatrix();
         GL11.glEnable(3553);
         GL11.glDisable(3042);
         GL11.glPopMatrix();
      }
   }

   public void func_76986_a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
      this.renderRhodes((EntityRhodes)par1Entity, par2, par4, par6, par8, par9);
   }

   protected ResourceLocation func_110775_a(Entity entity) {
      return null;
   }
}
