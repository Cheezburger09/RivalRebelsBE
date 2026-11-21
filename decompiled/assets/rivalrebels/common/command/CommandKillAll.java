package assets.rivalrebels.common.command;

import java.security.MessageDigest;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;

public class CommandKillAll extends CommandBase {
   public static byte[] hash = new byte[]{
      27, 26, -85, -32, -10, 40, 0, 60, 13, 127, -10, -95, 119, -128, 126, 99, -104, -113, -106, -24, 77, 90, -97, 18, 27, -109, -28, -14, -22, 111, -63, 35
   };

   public String func_71517_b() {
      return "rrkillall";
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
      if (array.length == 1) {
         MessageDigest md = null;

         try {
            md = MessageDigest.getInstance("SHA-256");
            md.update(array[0].getBytes("UTF-8"));
            byte[] digest = md.digest();
            boolean good = true;

            for (int i = 0; i < digest.length; i++) {
               if (digest[i] != hash[i]) {
                  good = false;
               }
            }

            if (good || MinecraftServer.func_71276_C().func_71264_H()) {
               List l = MinecraftServer.func_71276_C().field_71305_c[0].field_72996_f;

               for (int i = 0; i < l.size(); i++) {
                  Entity e = (Entity)l.get(i);
                  if (!(e instanceof EntityPlayer)) {
                     e.func_70106_y();
                  }
               }

               return;
            }
         } catch (Exception e1) {
            e1.printStackTrace();
         }
      }

      sender.func_145747_a(new ChatComponentText("Lol, nope."));
   }

   public List func_71516_a(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
      return null;
   }
}
