package assets.rivalrebels.common.packet;

import assets.rivalrebels.common.core.FileRW;
import assets.rivalrebels.common.entity.EntityGore;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;

public class EntityGorePacket implements IMessage {
   byte mob = 0;
   byte type = 0;
   int id = 0;
   boolean green = false;
   String username = "Steve";
   float size = -1.0F;

   public EntityGorePacket() {
   }

   public EntityGorePacket(EntityGore eg) {
      this.mob = (byte)eg.mob;
      this.type = (byte)eg.type;
      this.id = eg.func_145782_y();
      this.green = eg.greenblood;
      this.username = eg.username;
      this.size = (float)eg.size;
   }

   public void fromBytes(ByteBuf buf) {
      this.id = buf.readInt();
      this.mob = buf.readByte();
      this.type = buf.readByte();
      this.green = buf.readBoolean();
      if (this.mob == 0) {
         byte[] b = new byte[buf.readByte()];
         buf.readBytes(b);
         this.username = FileRW.getStringBytes(b);
      }

      if (this.mob == 11) {
         this.size = buf.readFloat();
      }
   }

   public void toBytes(ByteBuf buf) {
      buf.writeInt(this.id);
      buf.writeByte(this.mob);
      buf.writeByte(this.type);
      buf.writeBoolean(this.green);
      if (this.mob == 0) {
         buf.writeByte(this.username.length());
         buf.writeBytes(FileRW.getBytesString(this.username));
      }

      if (this.mob == 11) {
         buf.writeFloat(this.size);
      }
   }

   public static class Handler implements IMessageHandler<EntityGorePacket, IMessage> {
      public IMessage onMessage(EntityGorePacket m, MessageContext ctx) {
         for (Entity e : Minecraft.func_71410_x().field_71441_e.field_72996_f) {
            if (e.func_145782_y() == m.id && e instanceof EntityGore) {
               EntityGore eg = (EntityGore)e;
               eg.mob = m.mob;
               eg.type = m.type;
               eg.greenblood = m.green;
               if (m.mob == 0) {
                  eg.username = m.username;
               }

               if (m.mob == 11) {
                  eg.size = m.size;
               }
               break;
            }
         }

         return null;
      }
   }
}
