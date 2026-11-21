package assets.rivalrebels.common.item.weapon;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import assets.rivalrebels.common.entity.EntityGasGrenade;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemGasGrenade extends Item {
   public ItemGasGrenade() {
      this.field_77777_bU = 6;
      this.func_77637_a(RivalRebels.rralltab);
   }

   public EnumAction func_77661_b(ItemStack par1ItemStack) {
      return EnumAction.bow;
   }

   public int func_77626_a(ItemStack par1ItemStack) {
      return 75;
   }

   public void func_77615_a(ItemStack itemstack, World world, EntityPlayer player, int i) {
      if (player.field_71075_bZ.field_75098_d || player.field_71071_by.func_146028_b(RivalRebels.gasgrenade) || RivalRebels.infiniteGrenades) {
         float f = (this.func_77626_a(itemstack) - i) / 20.0F;
         f = (f * f + f * 2.0F) * 0.3333F;
         if (f > 1.0F) {
            f = 1.0F;
         }

         EntityGasGrenade entitysuperarrow = new EntityGasGrenade(world, player, 0.3F + f * 0.5F);
         if (!player.field_71075_bZ.field_75098_d) {
            player.field_71071_by.func_146026_a(RivalRebels.gasgrenade);
         }

         RivalRebelsSoundPlayer.playSound(player, 4, 3, 1.0F, 0.9F);
         if (!world.field_72995_K) {
            world.func_72838_d(entitysuperarrow);
            entitysuperarrow.func_70107_b(entitysuperarrow.field_70165_t, entitysuperarrow.field_70163_u - 0.05, entitysuperarrow.field_70161_v);
         }
      }
   }

   public ItemStack func_77659_a(ItemStack par1ItemStack, World world, EntityPlayer player) {
      player.func_71008_a(par1ItemStack, this.func_77626_a(par1ItemStack));
      world.func_72956_a(player, "mob.slimeattack", 1.0F, 1.0F);
      return par1ItemStack;
   }

   public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
      int time = 75 - count;
      if (time == 15 || time == 30 || time == 45 || time == 60) {
         player.field_70170_p.func_72956_a(player, "note.snare", 1.0F, 1.0F);
      }

      if (time == 75) {
         player.field_70170_p.func_72956_a(player, "note.snare", 1.0F, 1.0F);
         player.func_70690_d(new PotionEffect(Potion.field_76436_u.field_76415_H, 80, 1));
         player.func_70690_d(new PotionEffect(Potion.field_76431_k.field_76415_H, 200, 0));
         player.func_70690_d(new PotionEffect(Potion.field_76440_q.field_76415_H, 80, 0));
         player.func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, 80, 0));
         if (!player.field_71075_bZ.field_75098_d) {
            player.field_71071_by.func_146026_a(RivalRebels.gasgrenade);
         }
      }
   }

   public void func_94581_a(IIconRegister iconregister) {
      this.field_77791_bV = iconregister.func_94245_a("RivalRebels:ah");
   }
}
