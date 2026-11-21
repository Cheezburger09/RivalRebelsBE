package assets.rivalrebels.common.packet;

import assets.rivalrebels.common.tileentity.TileEntityReciever;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;

public class ADSClosePacket implements IMessage {
   int x;
   int y;
   int z;
   boolean mobs;
   boolean chip;
   boolean player;
   int range;

   public ADSClosePacket() {
   }

   public ADSClosePacket(int X, int Y, int Z, boolean m, boolean c, boolean p, int r) {
      this.x = X;
      this.y = Y;
      this.z = Z;
      this.mobs = m;
      this.chip = c;
      this.player = p;
      this.range = r;
   }

   public void fromBytes(ByteBuf buf) {
      this.x = buf.readInt();
      this.y = buf.readInt();
      this.z = buf.readInt();
      this.mobs = buf.readBoolean();
      this.chip = buf.readBoolean();
      this.player = buf.readBoolean();
      this.range = buf.readInt();
   }

   public void toBytes(ByteBuf buf) {
      buf.writeInt(this.x);
      buf.writeInt(this.y);
      buf.writeInt(this.z);
      buf.writeBoolean(this.mobs);
      buf.writeBoolean(this.chip);
      buf.writeBoolean(this.player);
      buf.writeInt(this.range);
   }

   public static class Handler implements IMessageHandler<ADSClosePacket, IMessage> {
      public IMessage onMessage(ADSClosePacket m, MessageContext ctx) {
         TileEntity te = ctx.getServerHandler().field_147369_b.field_70170_p.func_147438_o(m.x, m.y, m.z);
         if (te instanceof TileEntityReciever) {
            double var10001 = m.x;
            double var10002 = m.y;
            if (ctx.getServerHandler().field_147369_b.func_70092_e(var10001, var10002, m.z) < 100.0) {
               TileEntityReciever ter = (TileEntityReciever)te;
               ter.kMobs = m.mobs;
               ter.kTeam = m.chip;
               ter.kPlayers = m.player;
               ter.yawLimit = m.range;
            }
         }

         return null;
      }
   }
}
