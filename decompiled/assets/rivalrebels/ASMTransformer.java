package assets.rivalrebels;

import net.minecraft.launchwrapper.IClassTransformer;

public class ASMTransformer implements IClassTransformer {
   public byte[] transform(String name, String transformedName, byte[] bytes) {
      if (transformedName.equals("net.minecraft.network.NetHandlerPlayServer")) {
         int d = 3;

         for (int i = 0; i < bytes.length - 8 && d != 0; i++) {
            if (bytes[i + 2] == 0 && bytes[i + 3] == 0 && bytes[i + 4] == 0 && bytes[i + 5] == 0 && bytes[i + 6] == 0 && bytes[i + 7] == 0) {
               if (bytes[i] == 64 && bytes[i + 1] == 89) {
                  bytes[i] = 127;
                  bytes[i + 1] = -16;
                  d--;
               } else if (bytes[i] == 63 && bytes[i + 1] == -80) {
                  bytes[i] = 64;
                  bytes[i + 1] = 80;
                  d--;
               } else if (bytes[i] == -65 && bytes[i + 1] == -96) {
                  bytes[i] = 127;
                  bytes[i + 1] = -16;
                  d--;
               }
            }
         }
      }

      if (transformedName.equals("net.minecraft.world.biome.BiomeGenBase")) {
         int d = 3;

         for (int i = 0; i < bytes.length - 4 && d != 0; i++) {
            if (bytes[i] == -65 && bytes[i + 1] == 0 && bytes[i + 2] == 0 && bytes[i + 3] == 0) {
               bytes[i] = 63;
               d--;
            } else if (bytes[i] == -65 && bytes[i + 1] == -128 && bytes[i + 2] == 0 && bytes[i + 3] == 0) {
               bytes[i] = 63;
               d--;
            } else if (bytes[i] == -65 && bytes[i + 1] == -26 && bytes[i + 2] == 102 && bytes[i + 3] == 102) {
               bytes[i] = 63;
               d--;
            }
         }
      }

      return bytes;
   }
}
