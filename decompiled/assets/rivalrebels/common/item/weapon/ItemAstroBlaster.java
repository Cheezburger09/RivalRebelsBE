package assets.rivalrebels.common.item.weapon;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import assets.rivalrebels.common.entity.EntityLaserBurst;
import java.util.HashSet;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemAstroBlaster extends ItemTool {
   boolean isA = true;

   public ItemAstroBlaster() {
      super(1.0F, ToolMaterial.EMERALD, new HashSet());
      this.field_77777_bU = 1;
      this.func_77637_a(RivalRebels.rralltab);
   }

   public int func_77619_b() {
      return 100;
   }

   public boolean func_77662_d() {
      return true;
   }

   public EnumAction func_77661_b(ItemStack par1ItemStack) {
      return EnumAction.bow;
   }

   public int func_77626_a(ItemStack par1ItemStack) {
      return 2000;
   }

   public ItemStack func_77659_a(ItemStack item, World world, EntityPlayer player) {
      if (!player.field_71075_bZ.field_75098_d && !player.field_71071_by.func_146028_b(RivalRebels.redrod) && !RivalRebels.infiniteAmmo) {
         if (!world.field_72995_K) {
            player.func_145747_a(new ChatComponentText("§cNot enough redstone rods"));
         }
      } else {
         if (player.field_70170_p.field_72995_K) {
            item.func_82841_c(1);
         }

         player.func_71008_a(item, this.func_77626_a(item));
         RivalRebelsSoundPlayer.playSound(player, 12, 0, 0.7F, 0.7F);
      }

      return item;
   }

   public void onUsingTick(ItemStack is, EntityPlayer player, int count) {
      if (count < 1980 && !player.field_70170_p.field_72995_K) {
         if (!player.field_71075_bZ.field_75098_d && !RivalRebels.infiniteAmmo) {
            int item = -1;

            for (int i = 0; i < 36; i++) {
               if (player.field_71071_by.field_70462_a[i] != null && player.field_71071_by.field_70462_a[i].func_77973_b() == RivalRebels.redrod) {
                  item = i;
               }
            }

            if (item == -1) {
               return;
            }

            player.field_71071_by.field_70462_a[item].func_77972_a(1, player);
            if (player.field_71071_by.field_70462_a[item].func_77960_j() == player.field_71071_by.field_70462_a[item].func_77958_k()) {
               player.field_71071_by.func_70298_a(item, 1);
               player.field_71071_by.func_70441_a(new ItemStack(RivalRebels.emptyrod, 1));
            }
         }

         if (this.isA) {
            RivalRebelsSoundPlayer.playSound(player, 2, 2, 0.5F, 0.3F);
         } else {
            RivalRebelsSoundPlayer.playSound(player, 2, 3, 0.4F, 1.7F);
         }

         this.isA = !this.isA;
         player.field_70170_p
            .func_72838_d(new EntityLaserBurst(player.field_70170_p, player, is.func_77986_q() != null && is.func_77986_q().func_74745_c() > 0));
      } else if (player.field_70170_p.field_72995_K) {
         is.func_82841_c(2000 - count + 1);
      }
   }

   public void func_77615_a(ItemStack item, World world, EntityPlayer player, int par4) {
      if (world.field_72995_K) {
         item.func_82841_c(0);
      }
   }

   public void func_94581_a(IIconRegister iconregister) {
      this.field_77791_bV = iconregister.func_94245_a("RivalRebels:ab");
   }
}
