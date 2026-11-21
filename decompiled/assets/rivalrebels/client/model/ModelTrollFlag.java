package assets.rivalrebels.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class ModelTrollFlag {
   public void renderModel(World world, double x, double y, double z, int metadata) {
      Tessellator var5 = Tessellator.field_78398_a;
      double var18 = 0.05;
      if (metadata == 5) {
         var5.func_78382_b();
         var5.func_78374_a(var18, 1.0, 1.0, 0.0, 0.0);
         var5.func_78374_a(var18, 0.0, 1.0, 0.0, 1.0);
         var5.func_78374_a(var18, 0.0, 0.0, 1.0, 1.0);
         var5.func_78374_a(var18, 1.0, 0.0, 1.0, 0.0);
         var5.func_78381_a();
         var5.func_78382_b();
         var5.func_78374_a(var18, 1.0, 0.0, 1.0, 0.0);
         var5.func_78374_a(var18, 0.0, 0.0, 1.0, 1.0);
         var5.func_78374_a(var18, 0.0, 1.0, 0.0, 1.0);
         var5.func_78374_a(var18, 1.0, 1.0, 0.0, 0.0);
         var5.func_78381_a();
      }

      if (metadata == 4) {
         var5.func_78382_b();
         var5.func_78374_a(1.0 - var18, 0.0, 1.0, 1.0, 1.0);
         var5.func_78374_a(1.0 - var18, 1.0, 1.0, 1.0, 0.0);
         var5.func_78374_a(1.0 - var18, 1.0, 0.0, 0.0, 0.0);
         var5.func_78374_a(1.0 - var18, 0.0, 0.0, 0.0, 1.0);
         var5.func_78381_a();
         var5.func_78382_b();
         var5.func_78374_a(1.0 - var18, 0.0, 0.0, 0.0, 1.0);
         var5.func_78374_a(1.0 - var18, 1.0, 0.0, 0.0, 0.0);
         var5.func_78374_a(1.0 - var18, 1.0, 1.0, 1.0, 0.0);
         var5.func_78374_a(1.0 - var18, 0.0, 1.0, 1.0, 1.0);
         var5.func_78381_a();
      }

      if (metadata == 3) {
         var5.func_78382_b();
         var5.func_78374_a(1.0, 0.0, var18, 1.0, 1.0);
         var5.func_78374_a(1.0, 1.0, var18, 1.0, 0.0);
         var5.func_78374_a(0.0, 1.0, var18, 0.0, 0.0);
         var5.func_78374_a(0.0, 0.0, var18, 0.0, 1.0);
         var5.func_78381_a();
         var5.func_78382_b();
         var5.func_78374_a(0.0, 0.0, var18, 0.0, 1.0);
         var5.func_78374_a(0.0, 1.0, var18, 0.0, 0.0);
         var5.func_78374_a(1.0, 1.0, var18, 1.0, 0.0);
         var5.func_78374_a(1.0, 0.0, var18, 1.0, 1.0);
         var5.func_78381_a();
      }

      if (metadata == 2) {
         var5.func_78382_b();
         var5.func_78374_a(1.0, 1.0, 1.0 - var18, 0.0, 0.0);
         var5.func_78374_a(1.0, 0.0, 1.0 - var18, 0.0, 1.0);
         var5.func_78374_a(0.0, 0.0, 1.0 - var18, 1.0, 1.0);
         var5.func_78374_a(0.0, 1.0, 1.0 - var18, 1.0, 0.0);
         var5.func_78381_a();
         var5.func_78382_b();
         var5.func_78374_a(0.0, 1.0, 1.0 - var18, 1.0, 0.0);
         var5.func_78374_a(0.0, 0.0, 1.0 - var18, 1.0, 1.0);
         var5.func_78374_a(1.0, 0.0, 1.0 - var18, 0.0, 1.0);
         var5.func_78374_a(1.0, 1.0, 1.0 - var18, 0.0, 0.0);
         var5.func_78381_a();
      }
   }
}
