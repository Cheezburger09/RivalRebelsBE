package assets.rivalrebels.common.command;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.packet.PacketDispatcher;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;

public class CommandResetGame extends CommandBase {
   public String func_71517_b() {
      return "rrreset";
   }

   public String func_71518_a(ICommandSender par1ICommandSender) {
      return "/" + this.func_71517_b() + " <player>";
   }

   public int func_82362_a() {
      return 3;
   }

   public List func_71514_a() {
      return null;
   }

   public void func_71515_b(ICommandSender sender, String[] array) {
      EntityPlayer player = func_71521_c(sender);
      if (array.length == 1 && array[0].length() > 0) {
         if (array[0].equals("all")) {
            RivalRebels.round.rrplayerlist.clearTeam();
            PacketDispatcher.packetsys.sendToAll(RivalRebels.round.rrplayerlist);
            player.func_145747_a(new ChatComponentText("§7All players have been reset."));
         } else if (RivalRebels.round.rrplayerlist.contains(array[0])) {
            RivalRebels.round.rrplayerlist.getForName(array[0]).clearTeam();
            PacketDispatcher.packetsys.sendToAll(RivalRebels.round.rrplayerlist);
            player.func_145747_a(new ChatComponentText("§7Player successfully reset."));
         } else {
            player.func_145747_a(new ChatComponentText("§7No player by that name."));
         }
      }
   }

   public List func_71516_a(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
      return par2ArrayOfStr.length >= 1 ? func_71530_a(par2ArrayOfStr, MinecraftServer.func_71276_C().func_71213_z()) : null;
   }
}
