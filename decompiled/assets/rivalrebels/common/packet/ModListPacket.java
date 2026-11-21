package assets.rivalrebels.common.packet;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.FileRW;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;

public class ModListPacket implements IMessage {
   public static EntityPlayerMP asker;
   String text;

   public ModListPacket() {
   }

   public ModListPacket(String t) {
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

   public static class Handler implements IMessageHandler<ModListPacket, IMessage> {
      public IMessage onMessage(ModListPacket m, MessageContext ctx) {
         String[] d = m.text.split(",");
         StringBuilder illegalmods = new StringBuilder("§6[§eRival Rebels§6]\n§4Please remove these mods to play on this server:\n§4");
         boolean isillegal = false;
         StringBuilder str = new StringBuilder("-t§e======[§6RRInspect§e]======\n§6");
         str.append(d[0]);
         str.append(" has:\n§6");

         for (int i = 1; i < d.length; i++) {
            str.append(d[i]);
            if (i + 1 < d.length) {
               str.append(",\n§6");
            }

            for (int j = 0; j < RivalRebels.modblacklist.length && RivalRebels.enforceblacklist; j++) {
               if (d[i].toLowerCase().contains(RivalRebels.modblacklist[j])) {
                  isillegal = true;
                  illegalmods.append(d[i]);
                  illegalmods.append(",\n§4");
                  break;
               }
            }
         }

         String s = str.toString();
         if (isillegal) {
            ctx.getServerHandler().func_147360_c(illegalmods.toString());
         }

         if (ModListPacket.asker != null) {
            PacketDispatcher.packetsys.sendTo(new TextPacket(s), ModListPacket.asker);
         }

         return null;
      }
   }
}
