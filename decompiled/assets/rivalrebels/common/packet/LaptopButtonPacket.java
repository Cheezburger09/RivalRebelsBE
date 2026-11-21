package assets.rivalrebels.common.packet;

import assets.rivalrebels.common.tileentity.TileEntityLaptop;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;

public class LaptopButtonPacket implements IMessage {
   int x;
   int y;
   int z;

   public LaptopButtonPacket() {
   }

   public LaptopButtonPacket(int X, int Y, int Z) {
      this.x = X;
      this.y = Y;
      this.z = Z;
   }

   public void fromBytes(ByteBuf buf) {
      this.x = buf.readInt();
      this.y = buf.readInt();
      this.z = buf.readInt();
   }

   public void toBytes(ByteBuf buf) {
      buf.writeInt(this.x);
      buf.writeInt(this.y);
      buf.writeInt(this.z);
   }

   public static class Handler implements IMessageHandler<LaptopButtonPacket, IMessage> {
      public IMessage onMessage(LaptopButtonPacket m, MessageContext ctx) {
         double var10001 = m.x;
         double var10002 = m.y;
         if (ctx.getServerHandler().field_147369_b.func_70092_e(var10001, var10002, m.z) < 100.0) {
            TileEntity te = ctx.getServerHandler().field_147369_b.field_70170_p.func_147438_o(m.x, m.y, m.z);
            if (te != null && te instanceof TileEntityLaptop) {
               ((TileEntityLaptop)te).onGoButtonPressed();
            }
         }

         return null;
      }
   }
}
