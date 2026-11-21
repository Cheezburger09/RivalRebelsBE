package assets.rivalrebels.common.command;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.entity.EntityB2Spirit;
import assets.rivalrebels.common.item.weapon.ItemRoda;
import assets.rivalrebels.common.tileentity.TileEntityReciever;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class CommandConfig extends CommandBase {
   public String func_71517_b() {
      return "rrconfig";
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
      if (array.length == 2) {
         String str = array[0];
         if (str.equals("nuketime")) {
            String str2 = array[1];
            int i = Integer.parseInt(str2);
            if (i < 1) {
               i = 1;
            }

            RivalRebels.nuclearBombCountdown = i;
            sender.func_145747_a(new ChatComponentText("§cnuketime has been set to " + i));
            return;
         }

         if (str.equals("b2trash")) {
            String str2 = array[1];
            boolean i = Boolean.parseBoolean(str2);
            EntityB2Spirit.trash = i;
            sender.func_145747_a(new ChatComponentText("§cb2trash has been set to " + i));
            return;
         }

         if (str.equals("flash")) {
            String str2 = array[1];
            boolean i = Boolean.parseBoolean(str2);
            RivalRebels.antimatterFlash = i;
            sender.func_145747_a(new ChatComponentText("§cflash has been set to " + i));
            return;
         }

         if (str.equals("bignuke")) {
            String str2 = array[1];
            float i = Float.parseFloat(str2);
            RivalRebels.nukeScale = i;
            sender.func_145747_a(new ChatComponentText("§cNuke scale is " + i + "x"));
            return;
         }

         if (str.equals("bigshroom")) {
            String str2 = array[1];
            float i = Float.parseFloat(str2);
            RivalRebels.shroomScale = i;
            sender.func_145747_a(new ChatComponentText("§cMushroom scale is " + i + "x"));
            return;
         }

         if (str.equals("b2leave")) {
            String str2 = array[1];
            boolean i = Boolean.parseBoolean(str2);
            EntityB2Spirit.leave = i;
            sender.func_145747_a(new ChatComponentText("§cb2leave has been set to " + i));
            return;
         }

         if (str.equals("nukepancake")) {
            String str2 = array[1];
            if (str2.equals("off")) {
               RivalRebels.elevation = true;
               sender.func_145747_a(new ChatComponentText("§cNew Pancake off"));
            } else if (str2.equals("on")) {
               RivalRebels.elevation = false;
               sender.func_145747_a(new ChatComponentText("§cNew Pancake on"));
            } else {
               sender.func_145747_a(new ChatComponentText("§cPlease give a value of either on or off."));
            }

            return;
         }

         if (str.equals("nukedrop")) {
            String str2 = array[1];
            if (str2.equals("off")) {
               RivalRebels.nukedrop = false;
               sender.func_145747_a(new ChatComponentText("§cNuke drop off"));
            } else if (str2.equals("on")) {
               RivalRebels.nukedrop = true;
               sender.func_145747_a(new ChatComponentText("§cNuke drop on"));
            } else {
               sender.func_145747_a(new ChatComponentText("§cPlease give a value of either on or off."));
            }

            return;
         }

         if (str.equals("b2chance")) {
            String str2 = array[1];
            if (str2.equals("off")) {
               EntityB2Spirit.randchance = false;
               sender.func_145747_a(new ChatComponentText("§cB2 chance off"));
            } else if (str2.equals("on")) {
               EntityB2Spirit.randchance = true;
               sender.func_145747_a(new ChatComponentText("§cB2 chance on"));
            } else {
               sender.func_145747_a(new ChatComponentText("§cPlease give a value of either on or off."));
            }

            return;
         }

         if (str.equals("dragon") || str.equals("b2")) {
            String str2 = array[1];
            int index = -1;

            for (int i = 0; i < ItemRoda.entities.length; i++) {
               if (str2.equals(ItemRoda.entities[i])) {
                  index = i;
                  break;
               }
            }

            if (index != -1) {
               if (str.equals("dragon")) {
                  TileEntityReciever.staticEntityIndex = index;
               } else if (str.equals("b2")) {
                  EntityB2Spirit.staticEntityIndex = index;
               }
            } else {
               sender.func_145747_a(new ChatComponentText("§cPlease give a value of " + String.join(", ", ItemRoda.entities) + "."));
            }

            return;
         }
      }

      sender.func_145747_a(new ChatComponentText("§cUsage: /rrconfig nuketime|nukedrop|bignuke|bigshroom|flash|b2chance|nukepancake|dragon|b2"));
   }

   public List func_71516_a(ICommandSender p, String[] s) {
      List l = new ArrayList();
      l.add("nuketime");
      l.add("nukedrop");
      l.add("nukepancake");
      l.add("dragon");
      l.add("b2");
      return l;
   }
}
