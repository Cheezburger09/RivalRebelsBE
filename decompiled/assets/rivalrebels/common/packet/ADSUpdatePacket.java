package assets.rivalrebels.common.packet;

import assets.rivalrebels.common.tileentity.TileEntityReciever;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;

public class ADSUpdatePacket implements IMessage {
   int x;
   int y;
   int z;
   int range;
   boolean mob;
   boolean chip;
   boolean player;
   boolean haswep;
   String user;

   public ADSUpdatePacket() {
   }

   public ADSUpdatePacket(int X, int Y, int Z, int r, boolean m, boolean c, boolean p, boolean h, String u) {
      this.x = X;
      this.y = Y;
      this.z = Z;
      this.range = r;
      this.mob = m;
      this.chip = c;
      this.player = p;
      this.haswep = h;
      this.user = u;
   }

   public void fromBytes(ByteBuf buf) {
      this.x = buf.readInt();
      this.y = buf.readInt();
      this.z = buf.readInt();
      this.range = buf.readInt();
      this.mob = buf.readBoolean();
      this.chip = buf.readBoolean();
      this.player = buf.readBoolean();
      this.haswep = buf.readBoolean();
      StringBuilder r = new StringBuilder();

      while (buf.isReadable()) {
         byte b = buf.readByte();
         r.append((char)b);
      }

      this.user = r.toString();
   }

   public void toBytes(ByteBuf buf) {
      buf.writeInt(this.x);
      buf.writeInt(this.y);
      buf.writeInt(this.z);
      buf.writeInt(this.range);
      buf.writeBoolean(this.mob);
      buf.writeBoolean(this.chip);
      buf.writeBoolean(this.player);
      buf.writeBoolean(this.haswep);

      for (int i = 0; i < this.user.length(); i++) {
         buf.writeByte((byte)this.user.charAt(i));
      }
   }

   public static class Handler implements IMessageHandler<ADSUpdatePacket, IMessage> {
      public IMessage onMessage(ADSUpdatePacket m, MessageContext ctx) {
         TileEntity te = Minecraft.func_71410_x().field_71441_e.func_147438_o(m.x, m.y, m.z);
         if (te instanceof TileEntityReciever) {
            TileEntityReciever ter = (TileEntityReciever)te;
            ter.yawLimit = m.range;
            ter.kMobs = m.mob;
            ter.kTeam = m.chip;
            ter.kPlayers = m.player;
            ter.hasWeapon = m.haswep;
            ter.username = m.user;
         }

         return null;
      }
   }
}
