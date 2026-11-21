package assets.rivalrebels.common.command;

import assets.rivalrebels.common.packet.InspectPacket;
import assets.rivalrebels.common.packet.ModListPacket;
import assets.rivalrebels.common.packet.PacketDispatcher;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class CommandInspect extends CommandBase {
   public String func_71517_b() {
      return "rrinspect";
   }

   public String func_71518_a(ICommandSender par1ICommandSender) {
      return "/" + this.func_71517_b() + " <player>";
   }

   public List func_71514_a() {
      return null;
   }

   public int func_82362_a() {
      return 3;
   }

   public void func_71515_b(ICommandSender sender, String[] array) {
      ModListPacket.asker = func_71521_c(sender);
      PacketDispatcher.packetsys.sendTo(new InspectPacket(), func_82359_c(sender, array[0]));
   }

   public List func_71516_a(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
      return par2ArrayOfStr.length >= 1 ? func_71530_a(par2ArrayOfStr, MinecraftServer.func_71276_C().func_71213_z()) : null;
   }
}
