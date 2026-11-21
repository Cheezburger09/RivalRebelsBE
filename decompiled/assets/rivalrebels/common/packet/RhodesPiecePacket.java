package assets.rivalrebels.common.packet;

import assets.rivalrebels.common.entity.EntityRhodesPiece;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;

public class RhodesPiecePacket implements IMessage {
   int id = 0;
   float scale;
   int color;

   public RhodesPiecePacket() {
   }

   public RhodesPiecePacket(EntityRhodesPiece piece) {
      this.id = piece.func_145782_y();
      this.scale = piece.scale;
      this.color = piece.color;
   }

   public void fromBytes(ByteBuf buf) {
      this.id = buf.readInt();
      this.scale = buf.readFloat();
      this.color = buf.readByte();
   }

   public void toBytes(ByteBuf buf) {
      buf.writeInt(this.id);
      buf.writeFloat(this.scale);
      buf.writeByte(this.color);
   }

   public static class Handler implements IMessageHandler<RhodesPiecePacket, IMessage> {
      public IMessage onMessage(RhodesPiecePacket m, MessageContext ctx) {
         Entity e = Minecraft.func_71410_x().field_71441_e.func_73045_a(m.id);
         if (e instanceof EntityRhodesPiece) {
            EntityRhodesPiece er = (EntityRhodesPiece)e;
            er.color = m.color;
            er.scale = m.scale;
         }

         return null;
      }
   }
}
