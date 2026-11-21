package assets.rivalrebels.common.packet;

import assets.rivalrebels.common.entity.EntityDebris;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;

public class EntityDebrisPacket implements IMessage {
   Block block;
   int metadata = 0;
   int id = 0;

   public EntityDebrisPacket() {
   }

   public EntityDebrisPacket(EntityDebris ed) {
      this.id = ed.func_145782_y();
      this.block = ed.block;
      this.metadata = ed.metadata;
   }

   public void fromBytes(ByteBuf buf) {
      this.id = buf.readInt();
      this.block = Block.func_149729_e(buf.readInt());
      this.metadata = buf.readByte();
   }

   public void toBytes(ByteBuf buf) {
      buf.writeInt(this.id);
      buf.writeInt(Block.func_149682_b(this.block));
      buf.writeByte(this.metadata);
   }

   public static class Handler implements IMessageHandler<EntityDebrisPacket, IMessage> {
      public IMessage onMessage(EntityDebrisPacket m, MessageContext ctx) {
         for (Entity e : Minecraft.func_71410_x().field_71441_e.field_72996_f) {
            if (e.func_145782_y() == m.id && e instanceof EntityDebris) {
               EntityDebris ed = (EntityDebris)e;
               ed.block = m.block;
               ed.metadata = m.metadata;
               break;
            }
         }

         return null;
      }
   }
}
