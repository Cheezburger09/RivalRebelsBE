package assets.rivalrebels.common.packet;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.round.RivalRebelsPlayer;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;

public class ResetPacket implements IMessage {
   public void fromBytes(ByteBuf buf) {
   }

   public void toBytes(ByteBuf buf) {
   }

   public static class Handler implements IMessageHandler<ResetPacket, IMessage> {
      public IMessage onMessage(ResetPacket m, MessageContext ctx) {
         RivalRebelsPlayer p = RivalRebels.round.rrplayerlist.getForName(ctx.getServerHandler().field_147369_b.func_70005_c_());
         if (!p.isreset && p.resets > 0) {
            p.isreset = true;
            p.resets--;
            ctx.getServerHandler().field_147369_b.field_71071_by.func_146027_a(null, -1);
            PacketDispatcher.packetsys.sendToAll(RivalRebels.round.rrplayerlist);
         }

         return null;
      }
   }
}
