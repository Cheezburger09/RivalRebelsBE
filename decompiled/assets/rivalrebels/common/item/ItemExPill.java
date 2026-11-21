package assets.rivalrebels.common.item;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsDamageSource;
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

public class ItemExPill extends Item {
   public ItemExPill() {
      this.field_77777_bU = 6;
      this.func_77637_a(RivalRebels.rralltab);
   }

   public ItemStack func_77659_a(ItemStack item, World world, EntityPlayer player) {
      RivalRebelsSoundPlayer.playSound(player, 15, 0);
      RivalRebelsSoundPlayer.playSound(player, 28, 18, 1.0F, 0.6F);
      player.func_71008_a(item, this.func_77626_a(item));
      if (!world.field_72995_K) {
         int rand = world.field_73012_v.nextInt(100);
         if (rand >= 40) {
            player.func_145747_a(new ChatComponentText("§7[§6Status§7]§e The experiment turned out a success."));
            world.func_72956_a(player, "mob.magmacube.jump", 1.0F, 1.0F);
            world.func_72956_a(player, "mob.ghast.scream", 1.0F, 1.0F);
            player.func_70690_d(new PotionEffect(Potion.field_76440_q.field_76415_H, 30, 20));
            player.func_71024_bL().func_75122_a(20, 200.0F);
            player.func_70691_i(20.0F);
         } else if (rand >= 30) {
            player.func_145747_a(new ChatComponentText("§7[§6Status§7]§e Begrüßen Sie den Uber-Soldat."));
            world.func_72956_a(player, "mob.magmacube.jump", 1.0F, 1.0F);
            world.func_72956_a(player, "mob.ghast.scream", 1.0F, 1.0F);
            player.func_70690_d(new PotionEffect(Potion.field_76440_q.field_76415_H, 30, 20));
            player.func_71024_bL().func_75122_a(20, 200.0F);
            player.func_70691_i(20.0F);
            player.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 450, 20));
            player.func_70690_d(new PotionEffect(Potion.field_76420_g.field_76415_H, 500, 20));
            player.func_70690_d(new PotionEffect(Potion.field_76430_j.field_76415_H, 300, 2));
            player.func_70690_d(new PotionEffect(Potion.field_76422_e.field_76415_H, 500, 2));
            player.func_70690_d(new PotionEffect(Potion.field_76424_c.field_76415_H, 550, 2));
            player.func_70690_d(new PotionEffect(Potion.field_76427_o.field_76415_H, 800, 20));
            player.func_70690_d(new PotionEffect(Potion.field_76426_n.field_76415_H, 800, 20));
         } else if (rand >= 20) {
            player.func_145747_a(new ChatComponentText("§7[§6Status§7]§e The test subject has perished."));
            world.func_72956_a(player, "mob.magmacube.jump", 1.0F, 1.0F);
            world.func_72956_a(player, "mob.ghast.scream", 1.0F, 1.0F);
            player.func_70097_a(RivalRebelsDamageSource.cyanide, 2000.0F);
         } else {
            player.func_145747_a(new ChatComponentText("§7[§6Status§7]§e Unexpected results have occurred."));
            world.func_72956_a(player, "mob.magmacube.jump", 1.0F, 1.0F);
            world.func_72956_a(player, "mob.ghast.scream", 1.0F, 1.0F);
            player.func_70690_d(new PotionEffect(Potion.field_76431_k.field_76415_H, 1500, 20));
            player.func_70690_d(new PotionEffect(Potion.field_76440_q.field_76415_H, 1500, 20));
            player.func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, 1500, 20));
            player.func_70690_d(new PotionEffect(Potion.field_76419_f.field_76415_H, 1500, 20));
            player.func_70690_d(new PotionEffect(Potion.field_76437_t.field_76415_H, 1500, 20));
         }

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
      this.field_77791_bV = iconregister.func_94245_a("RivalRebels:ai");
   }
}
