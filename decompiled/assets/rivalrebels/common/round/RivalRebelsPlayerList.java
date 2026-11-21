package assets.rivalrebels.common.round;

import assets.rivalrebels.RivalRebels;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;

public class RivalRebelsPlayerList implements IMessage {
   private int size = 0;
   private RivalRebelsPlayer[] list = new RivalRebelsPlayer[0];

   public int getSize() {
      return this.size;
   }

   public RivalRebelsPlayer add(RivalRebelsPlayer o) {
      this.size++;
      if (this.size <= this.list.length) {
         this.list[this.size - 1] = o;
      } else {
         int nsize = this.list.length * 3 / 2 + 1;
         if (nsize < this.size) {
            nsize = this.size;
         }

         this.list = Arrays.copyOf(this.list, nsize);
         this.list[this.size - 1] = o;
      }

      return o;
   }

   public void clear() {
      for (int i = 0; i < this.size; i++) {
         this.list[i].clear();
      }
   }

   public void clearTeam() {
      for (int i = 0; i < this.size; i++) {
         this.list[i].clearTeam();
      }
   }

   public boolean contains(String o) {
      for (int i = 0; i < this.size; i++) {
         if (this.list[i].username.equals(o)) {
            return true;
         }
      }

      return false;
   }

   public RivalRebelsPlayer getForName(String user) {
      for (int i = 0; i < this.size; i++) {
         if (this.list[i].username.equals(user)) {
            return this.list[i];
         }
      }

      return this.add(new RivalRebelsPlayer(user, RivalRebelsTeam.NONE, RivalRebelsClass.NONE, RivalRebelsRank.REGULAR, RivalRebels.resetMax));
   }

   public void clearVotes() {
      for (int i = 0; i < this.size; i++) {
         this.list[i].voted = false;
      }
   }

   public void fromBytes(ByteBuf buf) {
      this.size = buf.readInt();
      this.list = new RivalRebelsPlayer[this.size];

      for (int i = 0; i < this.size; i++) {
         this.list[i] = new RivalRebelsPlayer(buf);
      }
   }

   public void toBytes(ByteBuf buf) {
      buf.writeInt(this.size);

      for (int i = 0; i < this.size; i++) {
         this.list[i].toBytes(buf);
      }
   }

   public RivalRebelsPlayer[] getArray() {
      return this.list;
   }

   public static class Handler implements IMessageHandler<RivalRebelsPlayerList, IMessage> {
      public IMessage onMessage(RivalRebelsPlayerList m, MessageContext ctx) {
         RivalRebels.round.rrplayerlist = m;
         return null;
      }
   }
}
