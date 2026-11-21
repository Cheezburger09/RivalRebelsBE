package assets.rivalrebels.common.command;

import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChunkCoordinates;

public class CommandPlaySound extends CommandBase {
   public String func_71517_b() {
      return "rrsoundsystem";
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
      if (array.length == 4) {
         int dir = 0;
         int num = 0;
         float vol = 0.0F;
         float pit = 0.0F;

         try {
            dir = Integer.parseInt(array[0].trim());
            num = Integer.parseInt(array[1].trim());
            vol = Float.parseFloat(array[2].trim());
            pit = Float.parseFloat(array[3].trim());
         } catch (Exception E) {
            sender.func_145747_a(new ChatComponentText("No!"));
         }

         ChunkCoordinates cc = sender.func_82114_b();
         RivalRebelsSoundPlayer.playSound(sender.func_130014_f_(), dir, num, cc.field_71574_a, cc.field_71572_b, cc.field_71573_c, vol, pit);
      } else {
         sender.func_145747_a(new ChatComponentText("No!"));
      }
   }

   public List func_71516_a(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
      return null;
   }
}
