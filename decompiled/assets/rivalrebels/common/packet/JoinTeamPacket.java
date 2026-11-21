package assets.rivalrebels.common.packet;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.round.RivalRebelsClass;
import assets.rivalrebels.common.round.RivalRebelsPlayer;
import assets.rivalrebels.common.round.RivalRebelsTeam;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import net.minecraft.scoreboard.Scoreboard;

public class JoinTeamPacket implements IMessage {
   RivalRebelsClass rrclass;
   RivalRebelsTeam rrteam;

   public JoinTeamPacket() {
   }

   public JoinTeamPacket(RivalRebelsTeam rrt, RivalRebelsClass rrc) {
      this.rrclass = rrc;
      this.rrteam = rrt;
   }

   public void fromBytes(ByteBuf buf) {
      this.rrclass = RivalRebelsClass.getForID(buf.readByte());
      this.rrteam = RivalRebelsTeam.getForID(buf.readByte());
   }

   public void toBytes(ByteBuf buf) {
      buf.writeByte(this.rrclass.id);
      buf.writeByte(this.rrteam.id);
   }

   public static class Handler implements IMessageHandler<JoinTeamPacket, IMessage> {
      public IMessage onMessage(JoinTeamPacket m, MessageContext ctx) {
         RivalRebelsPlayer p = RivalRebels.round.rrplayerlist.getForName(ctx.getServerHandler().field_147369_b.func_70005_c_());
         if (p.isreset) {
            p.isreset = false;
            p.rrclass = m.rrclass;
            p.rrteam = m.rrteam;
            Scoreboard scrb = RivalRebels.round.world.func_96441_U();
            scrb.func_96524_g(p.username);
            scrb.func_151392_a(p.username, p.rrteam.toString());
            ItemStack[] inventory = m.rrclass.inventory;

            for (int i = 0; i < inventory.length; i++) {
               ctx.getServerHandler().field_147369_b.field_71071_by.func_70441_a(inventory[i].func_77946_l());
            }

            if (m.rrteam == RivalRebelsTeam.OMEGA) {
               switch (m.rrclass) {
                  case REBEL:
                     ctx.getServerHandler().field_147369_b.field_71071_by.field_70460_b = new ItemStack[]{
                        new ItemStack(RivalRebels.orebelboots),
                        new ItemStack(RivalRebels.orebelpants),
                        new ItemStack(RivalRebels.orebelchest),
                        new ItemStack(RivalRebels.orebelhelmet)
                     };
                     break;
                  case NUKER:
                     ctx.getServerHandler().field_147369_b.field_71071_by.field_70460_b = new ItemStack[]{
                        new ItemStack(RivalRebels.onukerboots),
                        new ItemStack(RivalRebels.onukerpants),
                        new ItemStack(RivalRebels.onukerchest),
                        new ItemStack(RivalRebels.onukerhelmet)
                     };
                     break;
                  case INTEL:
                     ctx.getServerHandler().field_147369_b.field_71071_by.field_70460_b = new ItemStack[]{
                        new ItemStack(RivalRebels.ointelboots),
                        new ItemStack(RivalRebels.ointelpants),
                        new ItemStack(RivalRebels.ointelchest),
                        new ItemStack(RivalRebels.ointelhelmet)
                     };
                     break;
                  case HACKER:
                     ctx.getServerHandler().field_147369_b.field_71071_by.field_70460_b = new ItemStack[]{
                        new ItemStack(RivalRebels.ohackerboots),
                        new ItemStack(RivalRebels.ohackerpants),
                        new ItemStack(RivalRebels.ohackerchest),
                        new ItemStack(RivalRebels.ohackerhelmet)
                     };
                  case NONE:
               }
            } else if (m.rrteam == RivalRebelsTeam.SIGMA) {
               switch (m.rrclass) {
                  case REBEL:
                     ctx.getServerHandler().field_147369_b.field_71071_by.field_70460_b = new ItemStack[]{
                        new ItemStack(RivalRebels.srebelboots),
                        new ItemStack(RivalRebels.srebelpants),
                        new ItemStack(RivalRebels.srebelchest),
                        new ItemStack(RivalRebels.srebelhelmet)
                     };
                     break;
                  case NUKER:
                     ctx.getServerHandler().field_147369_b.field_71071_by.field_70460_b = new ItemStack[]{
                        new ItemStack(RivalRebels.snukerboots),
                        new ItemStack(RivalRebels.snukerpants),
                        new ItemStack(RivalRebels.snukerchest),
                        new ItemStack(RivalRebels.snukerhelmet)
                     };
                     break;
                  case INTEL:
                     ctx.getServerHandler().field_147369_b.field_71071_by.field_70460_b = new ItemStack[]{
                        new ItemStack(RivalRebels.sintelboots),
                        new ItemStack(RivalRebels.sintelpants),
                        new ItemStack(RivalRebels.sintelchest),
                        new ItemStack(RivalRebels.sintelhelmet)
                     };
                     break;
                  case HACKER:
                     ctx.getServerHandler().field_147369_b.field_71071_by.field_70460_b = new ItemStack[]{
                        new ItemStack(RivalRebels.shackerboots),
                        new ItemStack(RivalRebels.shackerpants),
                        new ItemStack(RivalRebels.shackerchest),
                        new ItemStack(RivalRebels.shackerhelmet)
                     };
                  case NONE:
               }
            }

            PacketDispatcher.packetsys.sendToAll(RivalRebels.round.rrplayerlist);
         }

         if (m.rrteam == RivalRebelsTeam.OMEGA) {
            double sx = RivalRebels.round.oObjx + (RivalRebels.round.world.field_73012_v.nextInt(2) - 0.5) * 30.0 + 0.5;
            double sy = RivalRebels.round.oObjy + 1;
            double sz = RivalRebels.round.oObjz + (RivalRebels.round.world.field_73012_v.nextInt(2) - 0.5) * 30.0 + 0.5;
            ctx.getServerHandler().field_147369_b.field_71135_a.func_147364_a(sx, sy, sz, 0.0F, 0.0F);
         } else if (m.rrteam == RivalRebelsTeam.SIGMA) {
            double sx = RivalRebels.round.sObjx + (RivalRebels.round.world.field_73012_v.nextInt(2) - 0.5) * 30.0 + 0.5;
            double sy = RivalRebels.round.sObjy + 1;
            double sz = RivalRebels.round.sObjz + (RivalRebels.round.world.field_73012_v.nextInt(2) - 0.5) * 30.0 + 0.5;
            ctx.getServerHandler().field_147369_b.field_71135_a.func_147364_a(sx, sy, sz, 0.0F, 0.0F);
         }

         return null;
      }
   }
}
