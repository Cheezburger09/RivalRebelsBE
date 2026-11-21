package assets.rivalrebels.common.packet;

import assets.rivalrebels.common.core.FileRW;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;

public class TextPacket implements IMessage {
   String text;

   public TextPacket() {
   }

   public TextPacket(String t) {
      this.text = t;
   }

   public void fromBytes(ByteBuf buf) {
      byte[] dst = new byte[buf.readInt()];
      buf.readBytes(dst);
      this.text = FileRW.getStringBytes(dst);
   }

   public void toBytes(ByteBuf buf) {
      buf.writeInt(this.text.length());
      buf.writeBytes(FileRW.getBytesString(this.text));
   }

   public static class Handler implements IMessageHandler<TextPacket, IMessage> {
      public IMessage onMessage(TextPacket m, MessageContext ctx) {
         if (m.text.startsWith("-t")) {
            String[] str = m.text.substring(2, m.text.length()).split("\n");

            for (int i = 0; i < str.length; i++) {
               Minecraft.func_71410_x().field_71439_g.func_145747_a(new ChatComponentText(str[i]));
            }
         } else {
            String[] s = m.text.split(" ");
            StringBuilder strb = new StringBuilder();

            for (int i = 0; i < s.length; i++) {
               strb.append(StatCollector.func_74838_a(s[i]));
               strb.append(" ");
            }

            Minecraft.func_71410_x().field_71439_g.func_145747_a(new ChatComponentText(strb.toString()));
         }

         return null;
      }
   }
}
