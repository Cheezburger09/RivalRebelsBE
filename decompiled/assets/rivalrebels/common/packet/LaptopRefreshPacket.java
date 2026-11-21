package assets.rivalrebels.common.packet;

import assets.rivalrebels.common.tileentity.TileEntityLaptop;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;

public class LaptopRefreshPacket implements IMessage {
   int x;
   int y;
   int z;
   int tasks;
   int carpet;

   public LaptopRefreshPacket() {
   }

   public LaptopRefreshPacket(int X, int Y, int Z, int T, int C) {
      this.x = X;
      this.y = Y;
      this.z = Z;
      this.tasks = T;
      this.carpet = C;
   }

   public void fromBytes(ByteBuf buf) {
      this.x = buf.readInt();
      this.y = buf.readInt();
      this.z = buf.readInt();
      this.tasks = buf.readInt();
      this.carpet = buf.readInt();
   }

   public void toBytes(ByteBuf buf) {
      buf.writeInt(this.x);
      buf.writeInt(this.y);
      buf.writeInt(this.z);
      buf.writeInt(this.tasks);
      buf.writeInt(this.carpet);
   }

   public static class Handler implements IMessageHandler<LaptopRefreshPacket, IMessage> {
      public IMessage onMessage(LaptopRefreshPacket m, MessageContext ctx) {
         TileEntity te = Minecraft.func_71410_x().field_71441_e.func_147438_o(m.x, m.y, m.z);
         if (te != null && te instanceof TileEntityLaptop) {
            ((TileEntityLaptop)te).b2spirit = m.tasks;
            ((TileEntityLaptop)te).b2carpet = m.carpet;
         }

         return null;
      }
   }
}
