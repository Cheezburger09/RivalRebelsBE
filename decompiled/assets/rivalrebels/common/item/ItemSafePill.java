package assets.rivalrebels.common.item;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemSafePill extends Item {
   public ItemSafePill() {
      this.field_77777_bU = 6;
      this.func_77637_a(RivalRebels.rralltab);
   }

   public ItemStack func_77659_a(ItemStack item, World world, EntityPlayer player) {
      player.func_71008_a(item, this.func_77626_a(item));
      if (!world.field_72995_K) {
         player.func_145747_a(new ChatComponentText("§7[§6Status§7]§e Regenerating..."));
         RivalRebelsSoundPlayer.playSound(player, 15, 1);
         RivalRebelsSoundPlayer.playSound(player, 28, 18);
         world.func_72956_a(player, "mob.magmacube.jump", 1.0F, 1.0F);
         world.func_72956_a(player, "mob.ghast.scream", 1.0F, 1.0F);
         player.func_70690_d(new PotionEffect(Potion.field_76440_q.field_76415_H, 10, 20));
         player.func_71024_bL().func_75122_a(10, 200.0F);
         player.func_70691_i(10.0F);
         player.field_71071_by.func_146026_a(item.func_77973_b());
      }

      return item;
   }

   public EnumAction func_77661_b(ItemStack par1ItemStack) {
      return EnumAction.eat;
   }

   public int func_77626_a(ItemStack par1ItemStack) {
      return 32;
   }

   public void func_94581_a(IIconRegister iconregister) {
      this.field_77791_bV = iconregister.func_94245_a("RivalRebels:ak");
   }
}
