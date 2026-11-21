package assets.rivalrebels.common.item;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.block.trap.BlockRemoteCharge;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemRemote extends Item {
   int RCpX;
   int RCpY;
   int RCpZ;

   public ItemRemote() {
      this.field_77777_bU = 1;
      this.func_77637_a(RivalRebels.rralltab);
   }

   public ItemStack func_77659_a(ItemStack item, World world, EntityPlayer player) {
      if (player.field_70170_p.func_147439_a(this.RCpX, this.RCpY + 1, this.RCpZ) == RivalRebels.remotecharge && player.func_70093_af()) {
         player.func_71038_i();
         RivalRebelsSoundPlayer.playSound(player, 22, 3);
         BlockRemoteCharge.explode(world, this.RCpX, this.RCpY + 1, this.RCpZ);
      }

      return item;
   }

   public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
      if ((
            player.field_71075_bZ.field_75098_d && world.func_147439_a(x, y + 1, z) == Blocks.field_150350_a
               || player.field_71071_by.func_146028_b(Item.func_150898_a(RivalRebels.remotecharge))
                  && world.func_147439_a(x, y + 1, z) == Blocks.field_150350_a
         )
         && !player.func_70093_af()) {
         RivalRebelsSoundPlayer.playSound(player, 22, 2);
         player.func_71038_i();
         if (!world.field_72995_K) {
            player.func_145747_a(new ChatComponentText("§7[§4Orders§7] §cShift-click (Sneak) to detonate."));
         }

         this.RCpX = x;
         this.RCpY = y;
         this.RCpZ = z;
         player.field_71071_by.func_146026_a(Item.func_150898_a(RivalRebels.remotecharge));
         world.func_147449_b(x, y + 1, z, RivalRebels.remotecharge);
         return false;
      } else {
         return false;
      }
   }

   public void func_94581_a(IIconRegister iconregister) {
      this.field_77791_bV = iconregister.func_94245_a("RivalRebels:am");
   }
}
