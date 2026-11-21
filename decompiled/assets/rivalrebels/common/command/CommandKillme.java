package assets.rivalrebels.common.command;

import assets.rivalrebels.common.core.RivalRebelsDamageSource;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;

public class CommandKillme extends CommandBase {
   public String func_71517_b() {
      return "killme";
   }

   public String func_71518_a(ICommandSender par1ICommandSender) {
      return "/" + this.func_71517_b();
   }

   public List func_71514_a() {
      return null;
   }

   public boolean func_71519_b(ICommandSender par1) {
      return true;
   }

   public void func_71515_b(ICommandSender sender, String[] array) {
      EntityPlayer person = func_71521_c(sender);
      person.func_70097_a(RivalRebelsDamageSource.cyanide, 10000.0F);
      sender.func_145747_a(new ChatComponentText("Do you think the cyanide tasted good?"));
   }

   public List func_71516_a(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
      return par2ArrayOfStr.length >= 1 ? func_71530_a(par2ArrayOfStr, MinecraftServer.func_71276_C().func_71213_z()) : null;
   }
}
