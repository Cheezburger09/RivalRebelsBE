package assets.rivalrebels.common.packet;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.entity.EntityRhodes;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;

public class RhodesJumpPacket implements IMessage {
   int id = 0;
   boolean jump = false;
   boolean rocket = false;
   boolean laser = false;
   boolean fire = false;
   boolean forcefield = false;
   boolean plasma = false;
   boolean nuke = false;
   boolean stop = false;
   boolean b2spirit = false;
   boolean guard = false;

   public RhodesJumpPacket() {
   }

   public RhodesJumpPacket(EntityRhodes er, boolean j, boolean r, boolean l, boolean f, boolean p, boolean c, boolean n, boolean s, boolean z, boolean g) {
      this.id = er.func_145782_y();
      this.jump = j;
      this.rocket = r;
      this.laser = l;
      this.fire = f;
      this.forcefield = c;
      this.plasma = p;
      this.nuke = n;
      this.stop = s;
      this.b2spirit = z;
      this.guard = g;
   }

   public void fromBytes(ByteBuf buf) {
      this.id = buf.readInt();
      this.jump = buf.readBoolean();
      this.rocket = buf.readBoolean();
      this.laser = buf.readBoolean();
      this.fire = buf.readBoolean();
      this.forcefield = buf.readBoolean();
      this.plasma = buf.readBoolean();
      this.nuke = buf.readBoolean();
      this.stop = buf.readBoolean();
      this.b2spirit = buf.readBoolean();
      this.guard = buf.readBoolean();
   }

   public void toBytes(ByteBuf buf) {
      buf.writeInt(this.id);
      buf.writeBoolean(this.jump);
      buf.writeBoolean(this.rocket);
      buf.writeBoolean(this.laser);
      buf.writeBoolean(this.fire);
      buf.writeBoolean(this.forcefield);
      buf.writeBoolean(this.plasma);
      buf.writeBoolean(this.nuke);
      buf.writeBoolean(this.stop);
      buf.writeBoolean(this.b2spirit);
      buf.writeBoolean(this.guard);
   }

   public static class Handler implements IMessageHandler<RhodesJumpPacket, IMessage> {
      public IMessage onMessage(RhodesJumpPacket m, MessageContext ctx) {
         Entity e = MinecraftServer.func_71276_C().field_71305_c[0].func_73045_a(m.id);
         if (e instanceof EntityRhodes) {
            EntityRhodes er = (EntityRhodes)e;
            er.stop = er.stop ^ m.stop;
            er.rocket = m.rocket;
            er.laser = m.laser;
            er.flame = m.fire;
            er.forcefield = m.forcefield;
            er.plasma = er.plasma ^ m.plasma;
            er.bomb = m.nuke;
            er.jet = m.jump;
            er.b2spirit = m.b2spirit;
            er.guard = m.guard;
            if (m.guard && RivalRebels.rhodesExit && er.rider != null) {
               er.rider.field_71075_bZ.field_75102_a = false;
               er.rider = null;
            }

            if (m.jump && !er.stop) {
               er.flying = 2;
            }
         }

         return null;
      }
   }
}
