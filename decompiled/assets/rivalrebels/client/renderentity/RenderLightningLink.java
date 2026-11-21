package assets.rivalrebels.client.renderentity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.entity.EntityLightningLink;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderLightningLink extends Render {
   static float red = 0.65F;
   static float green = 0.75F;
   static float blue = 1.0F;

   public void renderLightningLink(EntityLightningLink ell, double x, double y, double z, float yaw, float pitch) {
      float segmentDistance = RivalRebels.teslasegments;
      float distance = (float)ell.field_70159_w * 100.0F;
      distance = 100.0F;
      if (distance > 0.0F) {
         Random rand = new Random(ell.randLong);
         float radius = 0.07F;
         Tessellator tessellator = Tessellator.field_78398_a;
         GL11.glPushMatrix();
         GL11.glEnable(32826);
         GL11.glDisable(3553);
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 1);
         GL11.glTranslatef((float)x, (float)y, (float)z);
         GL11.glRotatef(ell.field_70177_z, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(-ell.field_70125_A, 1.0F, 0.0F, 0.0F);
         double AddedX = 0.0;
         double AddedY = 0.0;
         double prevAddedX = 0.0;
         double prevAddedY = 0.0;

         for (int addedZ = (int)distance; addedZ >= 0; addedZ = (int)(addedZ - segmentDistance)) {
            prevAddedX = AddedX;
            prevAddedY = AddedY;
            AddedX += (rand.nextFloat() - 0.5) * 2.0;
            AddedY += (rand.nextFloat() - 0.5) * 2.0;
            double dist = Math.sqrt(AddedX * AddedX + AddedY * AddedY) / 1.5;
            if (dist != 0.0) {
               double tempAddedX = AddedX / dist;
               double tempAddedY = AddedY / dist;
               if (Math.abs(tempAddedX) < Math.abs(AddedX)) {
                  AddedX = tempAddedX;
               }

               if (Math.abs(tempAddedY) < Math.abs(AddedY)) {
                  AddedY = tempAddedY;
               }
            }

            if (addedZ <= 0) {
               AddedY = 0.0;
               AddedX = 0.0;
            }

            for (float o = 0.0F; o <= radius; o += radius / 8.0F) {
               tessellator.func_78382_b();
               tessellator.func_78369_a(red, green, blue, 0.95F);
               tessellator.func_78377_a(AddedX + o, AddedY - o, addedZ);
               tessellator.func_78377_a(AddedX + o, AddedY + o, addedZ);
               tessellator.func_78377_a(prevAddedX + o, prevAddedY + o, addedZ + segmentDistance);
               tessellator.func_78377_a(prevAddedX + o, prevAddedY - o, addedZ + segmentDistance);
               tessellator.func_78381_a();
               tessellator.func_78382_b();
               tessellator.func_78369_a(red, green, blue, 0.95F);
               tessellator.func_78377_a(AddedX - o, AddedY - o, addedZ);
               tessellator.func_78377_a(AddedX + o, AddedY - o, addedZ);
               tessellator.func_78377_a(prevAddedX + o, prevAddedY - o, addedZ + segmentDistance);
               tessellator.func_78377_a(prevAddedX - o, prevAddedY - o, addedZ + segmentDistance);
               tessellator.func_78381_a();
               tessellator.func_78382_b();
               tessellator.func_78369_a(red, green, blue, 0.95F);
               tessellator.func_78377_a(AddedX - o, AddedY + o, addedZ);
               tessellator.func_78377_a(AddedX - o, AddedY - o, addedZ);
               tessellator.func_78377_a(prevAddedX - o, prevAddedY - o, addedZ + segmentDistance);
               tessellator.func_78377_a(prevAddedX - o, prevAddedY + o, addedZ + segmentDistance);
               tessellator.func_78381_a();
               tessellator.func_78382_b();
               tessellator.func_78369_a(red, green, blue, 0.95F);
               tessellator.func_78377_a(AddedX + o, AddedY + o, addedZ);
               tessellator.func_78377_a(AddedX - o, AddedY + o, addedZ);
               tessellator.func_78377_a(prevAddedX - o, prevAddedY + o, addedZ + segmentDistance);
               tessellator.func_78377_a(prevAddedX + o, prevAddedY + o, addedZ + segmentDistance);
               tessellator.func_78381_a();
            }
         }

         GL11.glDisable(3042);
         GL11.glEnable(3553);
         GL11.glDisable(32826);
         GL11.glPopMatrix();
      }
   }

   public void func_76986_a(Entity entityLightningLink, double x, double y, double z, float yaw, float pitch) {
      this.renderLightningLink((EntityLightningLink)entityLightningLink, x, y, z, yaw, pitch);
   }

   protected ResourceLocation func_110775_a(Entity entity) {
      return null;
   }
}
