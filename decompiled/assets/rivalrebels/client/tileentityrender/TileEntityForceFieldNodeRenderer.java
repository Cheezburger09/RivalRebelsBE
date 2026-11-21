package assets.rivalrebels.client.tileentityrender;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.renderhelper.RenderHelper;
import assets.rivalrebels.common.noise.RivalRebelsCellularNoise;
import assets.rivalrebels.common.tileentity.TileEntityForceFieldNode;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.BufferUtils;
import org.lwjgl.Sys;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class TileEntityForceFieldNodeRenderer extends TileEntitySpecialRenderer {
   public static int frames = 28;
   public static int[] id = new int[frames];
   RenderHelper model;
   int count = 0;

   public TileEntityForceFieldNodeRenderer() {
      this.model = new RenderHelper();
      id = this.genTexture(28, 28, frames);
   }

   public void renderAModelAt(TileEntityForceFieldNode tile, double x, double y, double z, float f) {
      if (!(tile.pInR <= 0.0F) && RivalRebels.goodRender) {
         this.count++;
         GL11.glPushMatrix();
         GL11.glTranslatef((float)x + 0.5F, (float)y + 0.5F, (float)z + 0.5F);
         if (tile.func_145832_p() == 2) {
            GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
         }

         if (tile.func_145832_p() == 3) {
            GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
         }

         if (tile.func_145832_p() == 4) {
            GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
         }

         GL11.glBindTexture(3553, id[(int)(getTime() / 100L % frames)]);
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 1);
         GL11.glDisable(2896);
         GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
         GL11.glTranslatef(0.0F, 0.0F, 0.5F);
         Tessellator tess = Tessellator.field_78398_a;
         tess.func_78382_b();
         tess.func_78374_a(-0.0625, 3.5, 0.0, 0.0, 0.0);
         tess.func_78374_a(-0.0625, -3.5, 0.0, 0.0, 1.0);
         tess.func_78374_a(-0.0625, -3.5, 35.0, 5.0, 1.0);
         tess.func_78374_a(-0.0625, 3.5, 35.0, 5.0, 0.0);
         tess.func_78381_a();
         tess.func_78382_b();
         tess.func_78374_a(0.0625, -3.5, 0.0, 0.0, 1.0);
         tess.func_78374_a(0.0625, 3.5, 0.0, 0.0, 0.0);
         tess.func_78374_a(0.0625, 3.5, 35.0, 5.0, 0.0);
         tess.func_78374_a(0.0625, -3.5, 35.0, 5.0, 1.0);
         tess.func_78381_a();
         GL11.glEnable(3553);
         GL11.glEnable(2896);
         GL11.glDisable(3042);
         GL11.glPopMatrix();
         if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT && RivalRebels.optiFineWarn) {
            FMLNetworkHandler.openGui(Minecraft.func_71410_x().field_71439_g, RivalRebels.instance, 24, tile.func_145831_w(), 0, 0, 0);
            RivalRebels.optiFineWarn = false;
         }
      }
   }

   private int[] genTexture(int xs, int zs, int ys) {
      int[] ids = new int[ys];
      RivalRebelsCellularNoise.refresh3D();
      int size = xs * zs * 4;
      byte red = -69;
      byte grn = -120;
      byte blu = -1;

      for (int i = 0; i < ys; i++) {
         ByteBuffer bb = BufferUtils.createByteBuffer(size);
         bb.order(ByteOrder.nativeOrder());

         for (int x = 0; x < xs; x++) {
            for (int z = 0; z < zs; z++) {
               bb.put(red);
               bb.put(grn);
               bb.put(blu);
               bb.put((byte)((RivalRebelsCellularNoise.noise((double)x / xs, (double)z / zs, (double)i / ys) + 1.0) * 127.0));
            }
         }

         ((Buffer)bb).flip();
         int id = GL11.glGenTextures();
         GL11.glEnable(3553);
         GL11.glBindTexture(3553, id);
         GL11.glTexParameteri(3553, 10242, 10497);
         GL11.glTexParameteri(3553, 10243, 10497);
         GL11.glTexParameteri(3553, 10241, 9729);
         GL11.glTexParameteri(3553, 10240, 9729);
         GL11.glTexImage2D(3553, 0, 32856, xs, zs, 0, 6408, 5121, bb);
         ids[i] = id;
      }

      return ids;
   }

   protected float lerp(float f1, float f2, float f3) {
      return f1 * f3 + f2 * (1.0F - f3);
   }

   public static long getTime() {
      return Sys.getTime() * 1000L / Sys.getTimerResolution();
   }

   public void func_147500_a(TileEntity tileentity, double d, double d1, double d2, float f) {
      this.renderAModelAt((TileEntityForceFieldNode)tileentity, d, d1, d2, f);
   }
}
