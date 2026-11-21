package assets.rivalrebels.common.item;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.round.RivalRebelsTeam;
import java.util.List;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemChip extends Item {
   public ItemChip() {
      this.field_77777_bU = 1;
      this.func_77637_a(RivalRebels.rralltab);
   }

   public void func_77663_a(ItemStack item, World world, Entity entity, int count, boolean flag) {
      if (item.func_77978_p() == null) {
         item.field_77990_d = new NBTTagCompound();
      }

      if (RivalRebels.round.isStarted() && !item.func_77978_p().func_74767_n("isReady") && entity instanceof EntityPlayer) {
         EntityPlayer player = (EntityPlayer)entity;
         item.func_77978_p().func_74778_a("username", player.func_70005_c_());
         item.func_77978_p().func_74768_a("team", RivalRebels.round.rrplayerlist.getForName(player.func_70005_c_()).rrteam.ordinal());
         item.func_77978_p().func_74757_a("isReady", true);
      }
   }

   public boolean onItemUseFirst(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int m, float hitX, float hitZ, float hitY) {
      player.func_71038_i();
      if (!world.field_72995_K && world.func_147439_a(x, y, z) == RivalRebels.buildrhodes) {
         world.func_147449_b(x - 1, y, z, RivalRebels.steel);
         world.func_147449_b(x + 1, y, z, RivalRebels.steel);
         world.func_147449_b(x, y + 1, z, RivalRebels.conduit);
         world.func_147449_b(x - 1, y + 1, z, RivalRebels.steel);
         world.func_147449_b(x + 1, y + 1, z, RivalRebels.steel);
         world.func_147449_b(x, y + 2, z, RivalRebels.steel);
         world.func_147449_b(x - 1, y + 2, z, RivalRebels.steel);
         world.func_147449_b(x + 1, y + 2, z, RivalRebels.steel);
         if (world.func_147439_a(x, y - 1, z) == RivalRebels.buildrhodes) {
            world.func_147449_b(x, y, z, RivalRebels.conduit);
            world.func_147449_b(x, y - 1, z, RivalRebels.rhodesactivator);
            world.func_147449_b(x - 1, y - 1, z, RivalRebels.steel);
            world.func_147449_b(x + 1, y - 1, z, RivalRebels.steel);
         } else {
            world.func_147449_b(x, y, z, RivalRebels.rhodesactivator);
         }

         return true;
      } else {
         return false;
      }
   }

   public void func_77624_a(ItemStack item, EntityPlayer player, List list, boolean par4) {
      if (item.field_77990_d != null) {
         list.add(RivalRebelsTeam.getForID(item.field_77990_d.func_74762_e("team")).name());
         list.add(item.field_77990_d.func_74779_i("username"));
      }
   }

   public void func_94581_a(IIconRegister iconregister) {
      this.field_77791_bV = iconregister.func_94245_a("RivalRebels:bd");
   }
}
