package assets.rivalrebels.common.command;

import assets.rivalrebels.RivalRebels;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;

public class CommandMotD extends CommandBase {
   public String func_71517_b() {
      return "rrmotd";
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
      if (array.length == 0) {
         sender.func_145747_a(new ChatComponentText(RivalRebels.round.getMotD()));
      } else {
         RivalRebels.round.setMotD(array);
      }
   }

   public List func_71516_a(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
      return par2ArrayOfStr.length >= 1 ? func_71530_a(par2ArrayOfStr, MinecraftServer.func_71276_C().func_71213_z()) : null;
   }
}
