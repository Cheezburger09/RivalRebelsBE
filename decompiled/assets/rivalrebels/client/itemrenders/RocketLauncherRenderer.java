package assets.rivalrebels.client.itemrenders;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.model.ModelRocketLauncherBody;
import assets.rivalrebels.client.model.ModelRocketLauncherHandle;
import assets.rivalrebels.client.model.ModelRocketLauncherTube;
import assets.rivalrebels.client.tileentityrender.TileEntityForceFieldNodeRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import org.lwjgl.opengl.GL11;

public class RocketLauncherRenderer implements IItemRenderer {
   ModelRocketLauncherHandle md2 = new ModelRocketLauncherHandle();
   ModelRocketLauncherBody md3 = new ModelRocketLauncherBody();
   ModelRocketLauncherTube md4 = new ModelRocketLauncherTube();

   public boolean handleRenderType(ItemStack item, ItemRenderType type) {
      return type == ItemRenderType.FIRST_PERSON_MAP
         || type == ItemRenderType.EQUIPPED
         || type == ItemRenderType.ENTITY
         || type == ItemRenderType.EQUIPPED_FIRST_PERSON;
   }

   public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
      return false;
   }

   public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
      GL11.glPushMatrix();
      GL11.glEnable(2896);
      GL11.glTranslatef(0.4F, 0.35F, -0.03F);
      GL11.glRotatef(-55.0F, 0.0F, 0.0F, 1.0F);
      GL11.glTranslatef(0.0F, 0.05F, 0.05F);
      if (type == ItemRenderType.EQUIPPED_FIRST_PERSON) {
         GL11.glScalef(1.0F, 1.0F, -1.0F);
      }

      GL11.glPushMatrix();
      GL11.glTranslatef(0.22F, -0.025F, 0.0F);
      GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
      GL11.glScalef(0.03125F, 0.03125F, 0.03125F);
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etrocketlauncherhandle);
      this.md2.render();
      if (item.func_77986_q() != null) {
         GL11.glBindTexture(
            3553, TileEntityForceFieldNodeRenderer.id[(int)(TileEntityForceFieldNodeRenderer.getTime() / 100L % TileEntityForceFieldNodeRenderer.frames)]
         );
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 1);
         GL11.glDisable(2896);
         this.md2.render();
         GL11.glDisable(3042);
         GL11.glEnable(2896);
      }

      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(-0.07F, 0.31F, 0.0F);
      GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
      GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
      GL11.glScalef(0.4F, 0.4F, 0.4F);
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etrocketlauncherbody);
      this.md3.render();
      if (item.func_77986_q() != null) {
         GL11.glBindTexture(
            3553, TileEntityForceFieldNodeRenderer.id[(int)(TileEntityForceFieldNodeRenderer.getTime() / 100L % TileEntityForceFieldNodeRenderer.frames)]
         );
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 1);
         GL11.glDisable(2896);
         this.md3.render();
         GL11.glDisable(3042);
         GL11.glEnable(2896);
      }

      GL11.glPopMatrix();
      float s = 0.0812F;
      GL11.glPushMatrix();
      GL11.glTranslatef(-0.07F + s, 0.71F, s);
      GL11.glScalef(0.15F, 0.1F, 0.15F);
      Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.etrocketlaunchertube);
      this.md4.render();
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(-0.07F - s, 0.71F, s);
      GL11.glScalef(0.15F, 0.1F, 0.15F);
      this.md4.render();
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(-0.07F + s, 0.71F, -s);
      GL11.glScalef(0.15F, 0.1F, 0.15F);
      this.md4.render();
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(-0.07F - s, 0.71F, -s);
      GL11.glScalef(0.15F, 0.1F, 0.15F);
      this.md4.render();
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(-0.07F + s, -0.285F, s);
      GL11.glScalef(0.15F, -0.1F, 0.15F);
      this.md4.render();
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(-0.07F - s, -0.285F, s);
      GL11.glScalef(0.15F, -0.1F, 0.15F);
      this.md4.render();
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(-0.07F + s, -0.285F, -s);
      GL11.glScalef(0.15F, -0.1F, 0.15F);
      this.md4.render();
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(-0.07F - s, -0.285F, -s);
      GL11.glScalef(0.15F, -0.1F, 0.15F);
      this.md4.render();
      GL11.glPopMatrix();
      GL11.glEnable(2896);
      GL11.glPopMatrix();
   }
}
