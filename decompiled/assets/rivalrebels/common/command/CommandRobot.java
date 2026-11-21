package assets.rivalrebels.common.command;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.entity.EntityRhodes;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChunkCoordinates;

public class CommandRobot extends CommandBase {
   private static String[] names = new String[]{
      "rhodes",
      "magnesium",
      "arsenic",
      "vanadium",
      "aurum",
      "iodine",
      "iron",
      "astatine",
      "cobalt",
      "strontium",
      "bismuth",
      "zinc",
      "osmium",
      "neon",
      "argent",
      "wolfram",
      "space"
   };

   public String func_71517_b() {
      return "rrrobot";
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
         if (str.equals("spawn") && !sender.func_130014_f_().field_72995_K) {
            String str2 = array[1];

            try {
               float scale = Float.parseFloat(str2);
               ChunkCoordinates cc = sender.func_82114_b();
               EntityRhodes er = new EntityRhodes(sender.func_130014_f_(), cc.field_71574_a, cc.field_71572_b, cc.field_71573_c, scale / 30.0F);
               sender.func_130014_f_().func_72838_d(er);
            } catch (Exception e) {
               sender.func_145747_a(new ChatComponentText("§cUsage: /rrrobot spawn <blocks high>"));
            }

            return;
         }

         if (str.equals("speedscale")) {
            String str2 = array[1];
            if (str2.equals("on")) {
               RivalRebels.rhodesScaleSpeed = true;
               sender.func_145747_a(new ChatComponentText("§cRhodes Speed Scaling Enabled"));
            } else if (str2.equals("off")) {
               RivalRebels.rhodesScaleSpeed = false;
               sender.func_145747_a(new ChatComponentText("§cRhodes Speed Scaling Disabled"));
            } else {
               float scale = -1.0F;

               try {
                  scale = Float.parseFloat(str2);
                  RivalRebels.rhodesSpeedScale = scale;
               } catch (Exception e) {
                  sender.func_145747_a(new ChatComponentText("§cUsage: /rrrobot speedscale [on|off|number]"));
               }
            }

            return;
         }

         if (str.equals("rekt")) {
            String str2 = array[1];
            if (str2.equals("on")) {
               RivalRebels.rhodesBlockBreak = 1.0F;
               sender.func_145747_a(new ChatComponentText("§cRhodes Rekt Enabled"));
            } else if (str2.equals("off")) {
               RivalRebels.rhodesBlockBreak = 0.0F;
               sender.func_145747_a(new ChatComponentText("§cRhodes Rekt Disabled"));
            } else {
               sender.func_145747_a(new ChatComponentText("§cUsage: /rrrobot rekt [on|off]"));
            }

            return;
         }

         if (str.equals("exit")) {
            String str2 = array[1];
            if (str2.equals("on")) {
               RivalRebels.rhodesExit = true;
               sender.func_145747_a(new ChatComponentText("§cRhodes Exitting Enabled"));
            } else if (str2.equals("off")) {
               RivalRebels.rhodesExit = false;
               sender.func_145747_a(new ChatComponentText("§cRhodes Exitting Disabled"));
            } else {
               sender.func_145747_a(new ChatComponentText("§cUsage: /rrrobot exit [on|off]"));
            }

            return;
         }

         if (str.equals("stop")) {
            String str2 = array[1];
            MessageDigest md = null;

            try {
               md = MessageDigest.getInstance("SHA-256");
               md.update(str2.getBytes("UTF-8"));
               byte[] digest = md.digest();
               boolean good = true;

               for (int i = 0; i < digest.length; i++) {
                  if (digest[i] != CommandKillAll.hash[i]) {
                     good = false;
                  }
               }

               if (good) {
                  RivalRebels.rhodesHold = !RivalRebels.rhodesHold;
                  sender.func_145747_a(new ChatComponentText("§cRhodes Stop " + RivalRebels.rhodesHold));
                  return;
               }
            } catch (Exception e1) {
               e1.printStackTrace();
            }

            sender.func_145747_a(new ChatComponentText("§cUsage: /rrrobot stop [password]"));
            return;
         }

         if (str.equals("ai")) {
            String str2 = array[1];
            if (str2.equals("on")) {
               RivalRebels.rhodesAI = true;
               sender.func_145747_a(new ChatComponentText("§cRhodes AI Enabled"));
            } else if (str2.equals("off")) {
               RivalRebels.rhodesAI = false;
               sender.func_145747_a(new ChatComponentText("§cRhodes AI Disabled"));
            } else {
               sender.func_145747_a(new ChatComponentText("§cUsage: /rrrobot ai [on|off]"));
            }

            return;
         }

         if (str.equals("tff")) {
            String str2 = array[1];
            if (str2.equals("on")) {
               RivalRebels.rhodesCC = true;
               sender.func_145747_a(new ChatComponentText("§cRhodes Team Friendly Fire Enabled"));
            } else if (str2.equals("off")) {
               RivalRebels.rhodesCC = false;
               sender.func_145747_a(new ChatComponentText("§cRhodes Team Friendly Fire Disabled"));
            } else {
               sender.func_145747_a(new ChatComponentText("§cUsage: /rrrobot tff [on|off]"));
            }

            return;
         }

         if (str.equals("ff")) {
            String str2 = array[1];
            if (str2.equals("on")) {
               RivalRebels.rhodesFF = true;
               sender.func_145747_a(new ChatComponentText("§cRhodes Friendly Fire Enabled"));
            } else if (str2.equals("off")) {
               RivalRebels.rhodesFF = false;
               sender.func_145747_a(new ChatComponentText("§cRhodes Friendly Fire Disabled"));
            } else {
               sender.func_145747_a(new ChatComponentText("§cUsage: /rrrobot ff [on|off]"));
            }

            return;
         }

         if (str.equals("logo")) {
            String str2 = array[1];
            EntityRhodes.texfolder = -1;
            int i = -1;
            byte var24;
            if (str2.startsWith("blocks/")) {
               var24 = 0;
            } else if (str2.startsWith("entity/")) {
               var24 = 1;
            } else if (str2.startsWith("items/")) {
               var24 = 2;
            } else {
               var24 = 3;
            }

            if (!str2.contains("/") && str2.length() < 11) {
               EntityRhodes.texfolder = var24;
               EntityRhodes.texloc = str2;
               sender.func_145747_a(new ChatComponentText("§cNext Rhodes Flag is " + str2));
               return;
            }

            String str3 = str2.substring(str2.indexOf("/") + 1);
            if (!str3.contains("/") && str3.length() < 11) {
               EntityRhodes.texfolder = var24;
               EntityRhodes.texloc = str3;
               sender.func_145747_a(new ChatComponentText("§cNext Rhodes Flag is " + str2));
               return;
            }

            sender.func_145747_a(new ChatComponentText("§cUsage: /rrrobot logo [flags|blocks|items|entity]/{texturename}"));
            sender.func_145747_a(new ChatComponentText("§cOpen up the jar and see for yourself which textures are available!"));
            return;
         }

         if (str.equals("model")) {
            String str2 = array[1];
            if (str2.equals("none")) {
               EntityRhodes.forcecolor = -1;
               sender.func_145747_a(new ChatComponentText("§cNext Rhodes: " + EntityRhodes.names[EntityRhodes.lastct]));
               return;
            }

            int which = -1;

            try {
               which = Integer.parseInt(str2) - 1;
            } catch (Exception e) {
               which = -1;
            }

            if (which == -1) {
               int distance = 10000;

               for (int i = 0; i < names.length; i++) {
                  int d = distance(str2, names[i]);
                  if (d < distance) {
                     distance = d;
                     which = i;
                  }
               }
            }

            if (which > -1 && which < names.length) {
               EntityRhodes.forcecolor = which;
               sender.func_145747_a(new ChatComponentText("§cNext Rhodes: " + EntityRhodes.names[which]));
               return;
            }
         }
      }

      sender.func_145747_a(new ChatComponentText("§cUsage: /rrrobot [model|logo|ai|ff|tff|exit|stop|rekt|speedscale|spawn]"));
   }

   public List func_71516_a(ICommandSender p, String[] s) {
      List l = new ArrayList();
      if (s.length > 0 && s[0] != null) {
         if (s[0].equals("model")) {
            for (int i = 0; i < names.length; i++) {
               l.add(names[i]);
            }
         } else if (s[0].equals("logo")) {
            l.add("flags/");
            l.add("items/");
            l.add("blocks/");
            l.add("entity/");
         } else if (s[0].equals("ai") || s[0].equals("ff") || s[0].equals("tff") || s[0].equals("exit") || s[0].equals("rekt") || s[0].equals("speedscale")) {
            l.add("on");
            l.add("off");
         } else if (s[0].equals("spawn")) {
            l.add("30");
         } else {
            l.add("logo");
            l.add("model");
            l.add("ai");
            l.add("ff");
            l.add("tff");
            l.add("exit");
            l.add("stop");
            l.add("speedscale");
            l.add("spawn");
         }
      } else {
         l.add("logo");
         l.add("model");
         l.add("ai");
         l.add("ff");
         l.add("tff");
         l.add("exit");
         l.add("stop");
         l.add("rekt");
         l.add("speedscale");
         l.add("spawn");
      }

      return l;
   }

   public static int distance(String a, String b) {
      a = a.toLowerCase();
      int[] costs = new int[b.length() + 1];
      int j = 0;

      while (j < costs.length) {
         costs[j] = j++;
      }

      for (int i = 1; i <= a.length(); i++) {
         costs[0] = i;
         int nw = i - 1;

         for (int jx = 1; jx <= b.length(); jx++) {
            int cj = Math.min(1 + Math.min(costs[jx], costs[jx - 1]), a.charAt(i - 1) == b.charAt(jx - 1) ? nw : nw + 1);
            nw = costs[jx];
            costs[jx] = cj;
         }
      }

      return costs[b.length()];
   }
}
