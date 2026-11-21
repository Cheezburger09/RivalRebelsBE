package assets.rivalrebels.common.packet;

import assets.rivalrebels.common.tileentity.TileEntityReactor;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;

public class ReactorGUIPacket implements IMessage {
   int x;
   int y;
   int z;
   byte type;

   public ReactorGUIPacket() {
   }

   public ReactorGUIPacket(int X, int Y, int Z, byte b) {
      this.x = X;
      this.y = Y;
      this.z = Z;
      this.type = b;
   }

   public void fromBytes(ByteBuf buf) {
      this.x = buf.readInt();
      this.y = buf.readInt();
      this.z = buf.readInt();
      this.type = buf.readByte();
   }

   public void toBytes(ByteBuf buf) {
      buf.writeInt(this.x);
      buf.writeInt(this.y);
      buf.writeInt(this.z);
      buf.writeByte(this.type);
   }

   public static class Handler implements IMessageHandler<ReactorGUIPacket, IMessage> {
      public IMessage onMessage(ReactorGUIPacket m, MessageContext ctx) {
         double var10001 = m.x;
         double var10002 = m.y;
         if (ctx.getServerHandler().field_147369_b.func_70092_e(var10001, var10002, m.z) < 100.0) {
            TileEntity te = ctx.getServerHandler().field_147369_b.field_70170_p.func_147438_o(m.x, m.y, m.z);
            if (te != null && te instanceof TileEntityReactor) {
               TileEntityReactor ter = (TileEntityReactor)te;
               if (m.type == 0) {
                  ter.toggleOn();
               }

               if (m.type == 1) {
                  ter.ejectCore();
               }
            }
         }

         return null;
      }
   }
}
