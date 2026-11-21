package assets.rivalrebels.client.itemrenders;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.objfileloader.ModelFromObj;
import assets.rivalrebels.client.tileentityrender.TileEntityForceFieldNodeRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import org.lwjgl.opengl.GL11;

public class TeslaRenderer implements IItemRenderer {
   ModelFromObj tesla;
   ModelFromObj dynamo;
   int spin = 0;

   public TeslaRenderer() {
      try {
         this.tesla = ModelFromObj.readObjFile("i.obj");
         this.dynamo = ModelFromObj.readObjFile("j.obj");
      } catch (Exception e) {
         System.err.println("Please make sure the model files are in the correct directory.");
      }
   }

   public boolean handleRenderType(ItemStack item, ItemRenderType type) {
      return type == ItemRenderType.FIRST_PERSON_MAP
         || type == ItemRenderType.EQUIPPED
         || type == ItemRenderType.ENTITY
         || type == ItemRenderType.EQUIPPED_FIRST_PERSON;
   }

   public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
      return false;
   }

   public int getDegree(ItemStack item) {
      return item.field_77990_d == null ? 0 : item.field_77990_d.func_74762_e("dial");
   }

   public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
      if (!item.func_77948_v()) {
         GL11.glEnable(2896);
         int degree = this.getDegree(item);
         this.spin = (int)(this.spin + (5.0F + degree / 36.0F));
         Minecraft.func_71410_x().field_71446_o.func_110577_a(RivalRebels.ettesla);
         GL11.glPushMatrix();
         GL11.glTranslatef(0.8F, 0.5F, -0.03F);
         GL11.glRotatef(35.0F, 0.0F, 0.0F, 1.0F);
         GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
         GL11.glScalef(0.12F, 0.12F, 0.12F);
         this.tesla.render();
         GL11.glRotatef(this.spin, 1.0F, 0.0F, 0.0F);
         this.dynamo.render();
         GL11.glPopMatrix();
      } else {
         if (type != ItemRenderType.ENTITY) {
            GL11.glPopMatrix();
         }

         GL11.glPushMatrix();
         Tessellator t = Tessellator.field_78398_a;
         GL11.glBindTexture(
            3553, TileEntityForceFieldNodeRenderer.id[(int)(TileEntityForceFieldNodeRenderer.getTime() / 100L % TileEntityForceFieldNodeRenderer.frames)]
         );
         GL11.glEnable(3042);
         GL11.glScalef(1.01F, 1.01F, 1.01F);
         GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
         GL11.glScalef(0.6F, 0.2F, 0.2F);
         GL11.glTranslatef(-0.99F, 0.5F, 0.0F);
         GL11.glBlendFunc(770, 1);
         GL11.glDisable(2896);
         GL11.glEnable(2884);
         t.func_78382_b();
         t.func_78374_a(-1.0, -1.0, -1.0, 0.0, 0.0);
         t.func_78374_a(-1.0, 1.0, -1.0, 1.0, 0.0);
         t.func_78374_a(-1.0, 1.0, 1.0, 1.0, 1.0);
         t.func_78374_a(-1.0, -1.0, 1.0, 0.0, 1.0);
         t.func_78374_a(1.0, -1.0, -1.0, 0.0, 0.0);
         t.func_78374_a(1.0, -1.0, 1.0, 0.0, 1.0);
         t.func_78374_a(1.0, 1.0, 1.0, 1.0, 1.0);
         t.func_78374_a(1.0, 1.0, -1.0, 1.0, 0.0);
         t.func_78374_a(-1.0, -1.0, -1.0, 0.0, 0.0);
         t.func_78374_a(-1.0, -1.0, 1.0, 0.0, 1.0);
         t.func_78374_a(1.0, -1.0, 1.0, 3.0, 1.0);
         t.func_78374_a(1.0, -1.0, -1.0, 3.0, 0.0);
         t.func_78374_a(-1.0, 1.0, -1.0, 0.0, 0.0);
         t.func_78374_a(1.0, 1.0, -1.0, 3.0, 0.0);
         t.func_78374_a(1.0, 1.0, 1.0, 3.0, 1.0);
         t.func_78374_a(-1.0, 1.0, 1.0, 0.0, 1.0);
         t.func_78374_a(-1.0, -1.0, -1.0, 0.0, 0.0);
         t.func_78374_a(1.0, -1.0, -1.0, 3.0, 0.0);
         t.func_78374_a(1.0, 1.0, -1.0, 3.0, 1.0);
         t.func_78374_a(-1.0, 1.0, -1.0, 0.0, 1.0);
         t.func_78374_a(-1.0, -1.0, 1.0, 0.0, 0.0);
         t.func_78374_a(-1.0, 1.0, 1.0, 0.0, 1.0);
         t.func_78374_a(1.0, 1.0, 1.0, 3.0, 1.0);
         t.func_78374_a(1.0, -1.0, 1.0, 3.0, 0.0);
         t.func_78374_a(-1.0, -1.0, -1.0, 0.0, 0.0);
         t.func_78374_a(-1.0, 1.0, -1.0, 1.0, 0.0);
         t.func_78374_a(-1.0, 1.0, 1.0, 1.0, 1.0);
         t.func_78374_a(-1.0, -1.0, 1.0, 0.0, 1.0);
         t.func_78374_a(1.0, -1.0, -1.0, 0.0, 0.0);
         t.func_78374_a(1.0, -1.0, 1.0, 0.0, 1.0);
         t.func_78374_a(1.0, 1.0, 1.0, 1.0, 1.0);
         t.func_78374_a(1.0, 1.0, -1.0, 1.0, 0.0);
         t.func_78374_a(-1.0, -1.0, -1.0, 0.0, 0.0);
         t.func_78374_a(-1.0, -1.0, 1.0, 0.0, 1.0);
         t.func_78374_a(1.0, -1.0, 1.0, 3.0, 1.0);
         t.func_78374_a(1.0, -1.0, -1.0, 3.0, 0.0);
         t.func_78374_a(-1.0, 1.0, -1.0, 0.0, 0.0);
         t.func_78374_a(1.0, 1.0, -1.0, 3.0, 0.0);
         t.func_78374_a(1.0, 1.0, 1.0, 3.0, 1.0);
         t.func_78374_a(-1.0, 1.0, 1.0, 0.0, 1.0);
         t.func_78374_a(-1.0, -1.0, -1.0, 0.0, 0.0);
         t.func_78374_a(1.0, -1.0, -1.0, 3.0, 0.0);
         t.func_78374_a(1.0, 1.0, -1.0, 3.0, 1.0);
         t.func_78374_a(-1.0, 1.0, -1.0, 0.0, 1.0);
         t.func_78374_a(-1.0, -1.0, 1.0, 0.0, 0.0);
         t.func_78374_a(-1.0, 1.0, 1.0, 0.0, 1.0);
         t.func_78374_a(1.0, 1.0, 1.0, 3.0, 1.0);
         t.func_78374_a(1.0, -1.0, 1.0, 3.0, 0.0);
         t.func_78381_a();
         GL11.glDisable(3042);
         GL11.glEnable(2896);
         GL11.glDisable(2884);
         GL11.glPopMatrix();
         if (type != ItemRenderType.ENTITY) {
            GL11.glPushMatrix();
         }
      }
   }
}
