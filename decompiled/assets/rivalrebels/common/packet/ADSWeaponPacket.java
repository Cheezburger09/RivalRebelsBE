package assets.rivalrebels.common.packet;

import assets.rivalrebels.common.tileentity.TileEntityReciever;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;

public class ADSWeaponPacket implements IMessage {
   int x;
   int y;
   int z;
   int wep;

   public ADSWeaponPacket() {
   }

   public ADSWeaponPacket(int X, int Y, int Z, int w) {
      this.x = X;
      this.y = Y;
      this.z = Z;
      this.wep = w;
   }

   public void fromBytes(ByteBuf buf) {
      this.x = buf.readInt();
      this.y = buf.readInt();
      this.z = buf.readInt();
      this.wep = buf.readInt();
   }

   public void toBytes(ByteBuf buf) {
      buf.writeInt(this.x);
      buf.writeInt(this.y);
      buf.writeInt(this.z);
      buf.writeInt(this.wep);
   }

   public static class Handler implements IMessageHandler<ADSWeaponPacket, IMessage> {
      public IMessage onMessage(ADSWeaponPacket m, MessageContext ctx) {
         TileEntity te = ctx.getServerHandler().field_147369_b.field_70170_p.func_147438_o(m.x, m.y, m.z);
         if (te instanceof TileEntityReciever) {
            TileEntityReciever ter = (TileEntityReciever)te;
            if (ter.hasWepReqs()) {
               ter.setWep(m.wep);
            }
         }

         return null;
      }
   }
}
