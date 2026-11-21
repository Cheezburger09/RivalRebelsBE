package assets.rivalrebels.common.item;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsDamageSource;
import java.util.Random;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemRodNuclear extends ItemRod {
   public ItemRodNuclear() {
      this.power = 3000000;
      this.field_77777_bU = 1;
      this.func_77637_a(RivalRebels.rralltab);
   }

   public void func_77663_a(ItemStack item, World world, Entity entity, int par4, boolean par5) {
      if (entity instanceof EntityPlayer) {
         EntityPlayer player = (EntityPlayer)entity;
         Random rand = new Random();
         if (player.field_71071_by.func_70301_a(player.field_71071_by.field_70461_c) != null
            && player.field_71071_by.func_70301_a(player.field_71071_by.field_70461_c).func_77973_b() == RivalRebels.nuclearelement
            && rand.nextInt(16) == 0
            && !player.field_71075_bZ.field_75098_d) {
            player.func_70097_a(RivalRebelsDamageSource.radioactivepoisoning, rand.nextInt(4));
         }
      }
   }

   public void func_94581_a(IIconRegister iconregister) {
      this.field_77791_bV = iconregister.func_94245_a("RivalRebels:av");
   }
}
