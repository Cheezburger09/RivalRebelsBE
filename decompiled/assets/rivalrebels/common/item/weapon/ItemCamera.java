package assets.rivalrebels.common.item.weapon;

import assets.rivalrebels.RivalRebels;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class ItemCamera extends ItemArmor {
   float zoom = 30.0F;
   float fovset = 0.0F;
   float senset = 0.0F;
   boolean prevheld = false;
   boolean bkey = false;
   public static boolean zoomed = false;

   public ItemCamera() {
      super(ArmorMaterial.CHAIN, 0, 0);
      this.field_77777_bU = 1;
      this.func_77637_a(RivalRebels.rralltab);
   }

   public void onArmorTick(World world, EntityPlayer entity, ItemStack itemStack) {
      if (world.field_72995_K && entity == Minecraft.func_71410_x().field_71439_g) {
         boolean key = Keyboard.isKeyDown(48) && Minecraft.func_71410_x().field_71462_r == null;
         if (key != this.bkey && key) {
            zoomed = !zoomed;
         }

         this.bkey = key;
         if (zoomed) {
            if (!this.prevheld) {
               this.fovset = Minecraft.func_71410_x().field_71474_y.field_74334_X;
               this.senset = Minecraft.func_71410_x().field_71474_y.field_74341_c;
            }

            this.zoom = this.zoom + Mouse.getEventDWheel() * 0.01F;
            if (this.zoom < 10.0F) {
               this.zoom = 10.0F;
            }

            if (this.zoom > 67.0F) {
               this.zoom = 67.0F;
            }

            Minecraft.func_71410_x().field_71474_y.field_74319_N = true;
            Minecraft.func_71410_x().field_71474_y.field_74334_X = this.zoom + (Minecraft.func_71410_x().field_71474_y.field_74334_X - this.zoom) * 0.85F;
            Minecraft.func_71410_x().field_71474_y.field_74341_c = this.senset * MathHelper.func_76129_c(this.zoom) * 0.1F;
         } else if (this.prevheld) {
            Minecraft.func_71410_x().field_71474_y.field_74334_X = this.fovset;
            Minecraft.func_71410_x().field_71474_y.field_74341_c = this.senset;
            Minecraft.func_71410_x().field_71474_y.field_74319_N = false;
         }

         this.prevheld = zoomed;
      }
   }

   public void func_94581_a(IIconRegister iconregister) {
      this.field_77791_bV = iconregister.func_94245_a("RivalRebels:bi");
   }
}
