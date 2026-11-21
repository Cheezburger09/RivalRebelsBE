package assets.rivalrebels.common.command;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import assets.rivalrebels.common.packet.PacketDispatcher;
import assets.rivalrebels.common.round.RivalRebelsPlayer;
import assets.rivalrebels.common.round.RivalRebelsRank;
import java.security.MessageDigest;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;

public class CommandPassword extends CommandBase {
   String[] rhashes = new String[]{"23742137371982715120014159120241255637172", "1518918615824625494170109603025017352201241"};
   String[] ohashes = new String[]{"127254246888283236291831726971211129135192", "17314923891217222431372172462419922385201191"};
   String[] lhashes = new String[]{"612401057716617559272422511992314614422575", "99188249382921446717719913013762206120"};
   String[] shashes = new String[]{"222152281681152820718419502273648223209", "107170188164102246158207236028166217204217177"};

   public String func_71517_b() {
      return "rr";
   }

   public String func_71518_a(ICommandSender par1ICommandSender) {
      return "/" + this.func_71517_b() + " <code> [player]";
   }

   public List func_71514_a() {
      return null;
   }

   public boolean func_71519_b(ICommandSender par1) {
      return true;
   }

   public void func_71515_b(ICommandSender sender, String[] array) {
      ChatComponentText message = new ChatComponentText("nope.");
      if (array.length == 0) {
         sender.func_145747_a(message);
      } else {
         EntityPlayer person = func_71521_c(sender);
         String code = array[0];
         String encrypted = this.encrypt(code);
         System.out.println(encrypted);
         RivalRebelsRank rank = RivalRebelsRank.REGULAR;
         if (this.rhashes[0].equals(encrypted) || this.rhashes[1].equals(encrypted)) {
            rank = RivalRebelsRank.REBEL;
            message = new ChatComponentText("Welcome, rebel!");
         } else if (this.ohashes[0].equals(encrypted) || this.ohashes[1].equals(encrypted)) {
            rank = RivalRebelsRank.OFFICER;
            message = new ChatComponentText("Welcome, officer!");
         } else if (this.lhashes[0].equals(encrypted) || this.lhashes[1].equals(encrypted)) {
            rank = RivalRebelsRank.LEADER;
            message = new ChatComponentText("Welcome, leader!");
         } else if (this.shashes[0].equals(encrypted) || this.shashes[1].equals(encrypted)) {
            rank = RivalRebelsRank.REP;
            message = new ChatComponentText("Welcome, representative!");
         }

         RivalRebelsPlayer p = RivalRebels.round.rrplayerlist.getForName(person.func_70005_c_());
         if (p.rrrank != rank || rank == RivalRebelsRank.REGULAR) {
            p.rrrank = rank;
            RivalRebelsSoundPlayer.playSound(person, 28, rank.snf);
            PacketDispatcher.packetsys.sendToAll(RivalRebels.round.rrplayerlist);
            sender.func_145747_a(message);
         }
      }
   }

   private String getString(byte[] bytes) {
      StringBuffer sb = new StringBuffer();

      for (int i = 0; i < bytes.length; i++) {
         byte b = bytes[i];
         sb.append(255 & b);
      }

      return sb.toString();
   }

   public String encrypt(String source) {
      try {
         MessageDigest md = MessageDigest.getInstance("MD5");
         byte[] bytes = md.digest(source.getBytes());
         return this.getString(bytes);
      } catch (Exception e) {
         e.printStackTrace();
         return null;
      }
   }

   public List func_71516_a(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
      return par2ArrayOfStr.length >= 1 ? func_71530_a(par2ArrayOfStr, MinecraftServer.func_71276_C().func_71213_z()) : null;
   }
}
