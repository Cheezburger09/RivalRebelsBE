package assets.rivalrebels.common.packet;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import java.io.File;
import net.minecraft.client.Minecraft;

public class InspectPacket implements IMessage {
   public void fromBytes(ByteBuf buf) {
   }

   public void toBytes(ByteBuf buf) {
   }

   public static class Handler implements IMessageHandler<InspectPacket, IMessage> {
      public IMessage onMessage(InspectPacket m, MessageContext ctx) {
         StringBuilder str = new StringBuilder();
         str.append(Minecraft.func_71410_x().field_71439_g.func_70005_c_());
         File file = Minecraft.func_71410_x().field_71412_D;
         String[] coremods = new File(file, "coremods").list();
         String[] mods = new File(file, "mods").list();
         if (coremods != null) {
            for (int i = 0; i < coremods.length; i++) {
               str.append(",");
               str.append(coremods[i]);
            }
         }

         if (mods != null) {
            for (int i = 0; i < mods.length; i++) {
               str.append(",");
               str.append(mods[i]);
            }
         }

         for (ModContainer c : Loader.instance().getActiveModList()) {
            str.append(",");
            str.append(c.getModId());
         }

         String s = str.toString();
         return new ModListPacket(s);
      }
   }
}
