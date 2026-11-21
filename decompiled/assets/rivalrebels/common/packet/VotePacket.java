package assets.rivalrebels.common.packet;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.round.RivalRebelsPlayer;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;

public class VotePacket implements IMessage {
   public boolean newround;

   public VotePacket() {
   }

   public VotePacket(boolean vote) {
      this.newround = vote;
   }

   public void fromBytes(ByteBuf buf) {
      this.newround = buf.readBoolean();
   }

   public void toBytes(ByteBuf buf) {
      buf.writeBoolean(this.newround);
   }

   public static class Handler implements IMessageHandler<VotePacket, IMessage> {
      public IMessage onMessage(VotePacket m, MessageContext ctx) {
         RivalRebelsPlayer p = RivalRebels.round.rrplayerlist.getForName(ctx.getServerHandler().field_147369_b.func_70005_c_());
         if (!p.voted) {
            p.voted = true;
            if (m.newround) {
               RivalRebels.round.newBattleVotes++;
            } else {
               RivalRebels.round.waitVotes++;
            }
         }

         return null;
      }
   }
}
