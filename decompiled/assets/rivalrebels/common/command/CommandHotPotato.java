package assets.rivalrebels.common.command;

import assets.rivalrebels.common.entity.EntityHotPotato;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class CommandHotPotato extends CommandBase {
   public static int x = -1;
   public static int y = -1;
   public static int z = -1;
   public static World world = null;
   public static boolean roundinprogress = false;

   public String func_71517_b() {
      return "rrhotpotato";
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
      if (world == null) {
         sender.func_145747_a(new ChatComponentText("§cPlace a jump block and use pliers on it to set the hot potato drop point."));
      } else if (array.length == 1) {
         String str = array[0];
         if ("stop".equals(str)) {
            roundinprogress = false;
            sender.func_145747_a(new ChatComponentText("§cRound stopped."));
         } else if (roundinprogress) {
            sender.func_145747_a(new ChatComponentText("§cRound already in progress! Do /rrhotpotato stop to end the current round."));
         } else {
            int n = Integer.parseInt(array[0]);
            sender.func_145747_a(new ChatComponentText("§cLet the Hot Potato games begin! " + n + " rounds."));
            EntityHotPotato tsar = new EntityHotPotato(world, x, y, z, n);
            world.func_72838_d(tsar);
            roundinprogress = true;
         }
      } else {
         sender.func_145747_a(new ChatComponentText("§cUsage: /rrhotpotato [number of rounds]"));
      }
   }

   public List func_71516_a(ICommandSender p, String[] s) {
      List l = new ArrayList();
      l.add("nuketime");
      return l;
   }
}
