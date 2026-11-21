package assets.rivalrebels.common.core;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class RivalRebelsSoundPlayer {
   static String[] directory = new String[]{
      "aa",
      "ab",
      "ac",
      "ad",
      "ae",
      "af",
      "af.a",
      "af.b",
      "ag",
      "ah",
      "ai",
      "aj",
      "ak",
      "al",
      "am",
      "an",
      "ao",
      "ap",
      "aq",
      "ar",
      "as",
      "at",
      "au",
      "av",
      "aw",
      "ax",
      "ay",
      "az",
      "ba"
   };
   static String[][] number = new String[][]{
      {"a", "b", "c", "d"},
      {"a"},
      {"a", "b", "c", "d"},
      {"a"},
      {"a", "b", "c", "d", "e"},
      {"a", "b", "c"},
      {"a", "b", "c", "d"},
      {"a", "b", "c", "d"},
      {"a", "b", "c"},
      {"a", "b", "c", "d"},
      {"a", "b", "c", "d", "e", "f", "g", "h", "i"},
      {"a", "b"},
      {"a", "b", "c"},
      {"a", "b"},
      {"a"},
      {"a", "b"},
      {"a", "b", "c"},
      {"a"},
      {"a", "b"},
      {"a", "b", "c"},
      {"a"},
      {"a", "b", "c", "d"},
      {"a", "b", "c", "d"},
      {"a", "b", "c", "d", "e"},
      {"a", "b", "c", "d", "e"},
      {"a", "b"},
      {"a", "b", "c"},
      {"a"},
      {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s"}
   };

   public static boolean playSound(World world, int dir, int num, double x, double y, double z, float volume, float pitch) {
      if (world != null && dir >= 0 && dir < directory.length && num >= 0 && num < number[dir].length) {
         String sound = "rivalrebels:" + dir + "." + num;
         world.func_72908_a(x, y, z, sound, volume, pitch);
         return true;
      } else {
         return false;
      }
   }

   public static boolean playSound(World world, int dir, int num, double x, double y, double z, float volume) {
      return playSound(world, dir, num, x, y, z, volume, 1.0F);
   }

   public static boolean playSound(World world, int dir, int num, double x, double y, double z) {
      return playSound(world, dir, num, x, y, z, 1.0F, 1.0F);
   }

   public static boolean playSound(Entity entity, int dir, int num, float volume, float pitch) {
      return entity != null
         ? playSound(entity.field_70170_p, dir, num, entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, volume, pitch)
         : false;
   }

   public static boolean playSound(Entity entity, int dir, int num, float volume) {
      return playSound(entity, dir, num, volume, 1.0F);
   }

   public static boolean playSound(Entity entity, int dir, int num) {
      return playSound(entity, dir, num, 1.0F, 1.0F);
   }
}
