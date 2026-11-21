package assets.rivalrebels.common.command;

import assets.rivalrebels.RivalRebels;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class CommandContinueRound extends CommandBase {
   public String func_71517_b() {
      return "rrstartround";
   }

   public String func_71518_a(ICommandSender par1ICommandSender) {
      return "/" + this.func_71517_b();
   }

   public int func_82362_a() {
      return 3;
   }

   public List func_71514_a() {
      return null;
   }

   public void func_71515_b(ICommandSender sender, String[] array) {
      RivalRebels.round.stopRounds();
      RivalRebels.round.newRound();
      sender.func_145747_a(new ChatComponentText("The current round has been successfully started."));
   }
}
