package assets.rivalrebels.common.packet;

import assets.rivalrebels.common.tileentity.TileEntityList;
import assets.rivalrebels.common.tileentity.TileEntityMachineBase;
import assets.rivalrebels.common.tileentity.TileEntityReactive;
import assets.rivalrebels.common.tileentity.TileEntityReactor;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;

public class ReactorUpdatePacket implements IMessage {
   int x;
   int y;
   int z;
   float consumed;
   float lasttick;
   boolean melt;
   boolean eject;
   boolean on;
   TileEntityList machines;
   ByteBuf bbuf;

   public ReactorUpdatePacket() {
   }

   public ReactorUpdatePacket(int X, int Y, int Z, float cons, float last, boolean mt, boolean ej, boolean o, TileEntityList mach) {
      this.x = X;
      this.y = Y;
      this.z = Z;
      this.consumed = cons;
      this.lasttick = last;
      this.melt = mt;
      this.eject = ej;
      this.on = o;
      this.machines = mach;
   }

   public void fromBytes(ByteBuf buf) {
      this.bbuf = buf.copy();
   }

   public void toBytes(ByteBuf buf) {
      buf.writeInt(this.x);
      buf.writeInt(this.y);
      buf.writeInt(this.z);
      buf.writeFloat(this.consumed);
      buf.writeFloat(this.lasttick);
      buf.writeBoolean(this.melt);
      buf.writeBoolean(this.eject);
      buf.writeBoolean(this.on);
      if (this.machines != null) {
         for (int i = 0; i < this.machines.getSize(); i++) {
            TileEntityMachineBase te = (TileEntityMachineBase)this.machines.get(i);
            if (te != null && !(te instanceof TileEntityReactive)) {
               buf.writeInt(te.field_145851_c);
               buf.writeInt(te.field_145848_d);
               buf.writeInt(te.field_145849_e);
               buf.writeFloat(te.powerGiven);
               buf.writeFloat(te.pInR);
            }
         }
      }
   }

   public static class Handler implements IMessageHandler<ReactorUpdatePacket, IMessage> {
      public IMessage onMessage(ReactorUpdatePacket m, MessageContext ctx) {
         int x = m.bbuf.readInt();
         int y = m.bbuf.readInt();
         int z = m.bbuf.readInt();
         TileEntity te = Minecraft.func_71410_x().field_71441_e.func_147438_o(x, y, z);
         if (te instanceof TileEntityReactor) {
            TileEntityReactor ter = (TileEntityReactor)te;
            ter.consumed = m.bbuf.readFloat();
            ter.lasttickconsumed = m.bbuf.readFloat();
            ter.melt = m.bbuf.readBoolean();
            ter.eject = m.bbuf.readBoolean();
            ter.on = m.bbuf.readBoolean();
            ter.machines.clear();

            while (m.bbuf.isReadable()) {
               int xx = m.bbuf.readInt();
               int yy = m.bbuf.readInt();
               int zz = m.bbuf.readInt();
               TileEntity temb = Minecraft.func_71410_x().field_71441_e.func_147438_o(xx, yy, zz);
               if (temb instanceof TileEntityMachineBase) {
                  TileEntityMachineBase tembr = (TileEntityMachineBase)temb;
                  tembr.powerGiven = m.bbuf.readFloat();
                  tembr.pInR = m.bbuf.readFloat();
                  tembr.x = x;
                  tembr.y = y;
                  tembr.z = z;
                  tembr.edist = (float)Math.sqrt(tembr.func_145835_a(x, y, z));
                  ter.machines.add(temb);
               } else {
                  m.bbuf.readFloat();
                  m.bbuf.readFloat();
               }
            }
         }

         return null;
      }
   }
}
