package assets.rivalrebels.common.item;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.block.autobuilds.BlockAutoTemplate;
import assets.rivalrebels.common.command.CommandHotPotato;
import assets.rivalrebels.common.packet.PacketDispatcher;
import assets.rivalrebels.common.packet.TextPacket;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemPliers extends Item {
   private int i = 0;

   public ItemPliers() {
      this.field_77777_bU = 1;
      this.func_77642_a(this);
      this.func_77637_a(RivalRebels.rralltab);
   }

   public boolean onItemUseFirst(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int m, float hitX, float hitZ, float hitY) {
      player.func_71038_i();
      if (!world.field_72995_K) {
         if (world.func_147439_a(x, y, z) == RivalRebels.jump && player.field_71075_bZ.field_75098_d) {
            CommandHotPotato.x = x;
            CommandHotPotato.y = y + 400;
            CommandHotPotato.z = z;
            CommandHotPotato.world = world;
            PacketDispatcher.packetsys.sendTo(new TextPacket("Hot Potato drop point set. Use /rrhotpotato to start a round."), (EntityPlayerMP)player);
         }

         if (world.func_147439_a(x, y, z) == RivalRebels.remotecharge) {
            int t = 25;
            this.i++;
            PacketDispatcher.packetsys.sendTo(new TextPacket("RivalRebels.Defuse " + Integer.toString(this.i * 100 / t) + "§7'/."), (EntityPlayerMP)player);
            if (this.i >= t) {
               EntityItem ei = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(RivalRebels.remotecharge, 1));
               world.func_72838_d(ei);
               world.func_147449_b(x, y, z, Blocks.field_150350_a);
               this.i = 0;
               return true;
            }
         }

         if (world.func_147439_a(x, y, z) == RivalRebels.timedbomb) {
            int t = 25;
            this.i++;
            PacketDispatcher.packetsys.sendTo(new TextPacket("RivalRebels.Defuse " + Integer.toString(this.i * 100 / t) + "§7'/."), (EntityPlayerMP)player);
            if (this.i >= t) {
               EntityItem ei = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(RivalRebels.timedbomb, 1));
               world.func_72838_d(ei);
               world.func_147449_b(x, y, z, Blocks.field_150350_a);
               world.func_147449_b(x, y + 1, z, Blocks.field_150350_a);
               this.i = 0;
               return true;
            }
         }

         if (world.func_147439_a(x, y, z) instanceof BlockAutoTemplate) {
            BlockAutoTemplate block = (BlockAutoTemplate)world.func_147439_a(x, y, z);
            this.i++;
            PacketDispatcher.packetsys
               .sendTo(
                  new TextPacket("RivalRebels.Status RivalRebels.building " + Integer.toString(this.i * 100 / block.time) + "§7'/."), (EntityPlayerMP)player
               );
            if (this.i >= block.time) {
               world.func_147449_b(x, y, z, Blocks.field_150350_a);
               block.build(world, x, y, z);
               this.i = 0;
               return true;
            }
         }

         if (world.func_147439_a(x, y, z) == RivalRebels.supplies && world.func_147439_a(x, y - 1, z) == RivalRebels.supplies) {
            this.i++;
            PacketDispatcher.packetsys
               .sendTo(
                  new TextPacket("RivalRebels.Status RivalRebels.building ToKaMaK " + Integer.toString(this.i * 100 / 15) + "§7'/."), (EntityPlayerMP)player
               );
            if (this.i >= 15) {
               world.func_147449_b(x, y, z, Blocks.field_150350_a);
               world.func_147449_b(x, y - 1, z, RivalRebels.reactor);
               this.i = 0;
               return true;
            }
         }
      }

      return false;
   }

   public void func_94581_a(IIconRegister iconregister) {
      this.field_77791_bV = iconregister.func_94245_a("RivalRebels:ap");
   }
}
