package assets.rivalrebels.common.round;

import assets.rivalrebels.common.core.FileRW;
import io.netty.buffer.ByteBuf;
import net.minecraft.server.MinecraftServer;

public class RivalRebelsPlayer {
   public String username;
   public RivalRebelsClass rrclass = RivalRebelsClass.NONE;
   public RivalRebelsTeam rrteam = RivalRebelsTeam.NONE;
   public RivalRebelsRank rrrank = RivalRebelsRank.REGULAR;
   public int resets = -1;
   public boolean isreset = true;
   public boolean voted = false;

   public RivalRebelsPlayer(String user, RivalRebelsTeam rteam, RivalRebelsClass rclass, RivalRebelsRank rrank, int r) {
      this.username = user;
      this.rrteam = rteam;
      this.rrclass = rclass;
      this.rrrank = rrank;
      this.resets = r;
   }

   public RivalRebelsPlayer(ByteBuf buf) {
      this.fromBytes(buf);
   }

   public boolean equals(RivalRebelsPlayer o) {
      return this.username.equals(o.username);
   }

   public void reset() {
      this.resets++;
      this.isreset = true;
   }

   public void clear() {
      this.rrclass = RivalRebelsClass.NONE;
      this.isreset = true;
      this.resets = -1;
   }

   public void clearTeam() {
      this.rrclass = RivalRebelsClass.NONE;
      this.rrteam = RivalRebelsTeam.NONE;
      this.isreset = true;
      this.resets = -1;
      MinecraftServer server = MinecraftServer.func_71276_C();
      if (server != null) {
      }
   }

   public void toBytes(ByteBuf buf) {
      buf.writeByte(this.rrclass.id);
      buf.writeByte(this.rrteam.id);
      buf.writeByte(this.rrrank.id);
      buf.writeByte(this.resets);
      buf.writeByte(this.isreset ? 116 : 102);
      buf.writeByte(this.username.length());
      buf.writeBytes(FileRW.getBytesString(this.username));
   }

   public void fromBytes(ByteBuf buf) {
      this.rrclass = RivalRebelsClass.getForID(buf.readByte());
      this.rrteam = RivalRebelsTeam.getForID(buf.readByte());
      this.rrrank = RivalRebelsRank.getForID(buf.readByte());
      this.resets = buf.readByte();
      this.isreset = buf.readByte() == 116;
      byte[] b = new byte[buf.readByte()];
      buf.readBytes(b);
      this.username = FileRW.getStringBytes(b);
   }
}
