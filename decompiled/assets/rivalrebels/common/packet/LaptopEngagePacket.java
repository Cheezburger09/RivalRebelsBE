package assets.rivalrebels.common.packet;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.entity.EntityB2Spirit;
import assets.rivalrebels.common.round.RivalRebelsTeam;
import assets.rivalrebels.common.tileentity.TileEntityLaptop;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class LaptopEngagePacket implements IMessage {
   int tx = -1;
   int ty = -1;
   int tz = -1;
   int lx = -1;
   int ly = -1;
   int lz = -1;
   boolean c = false;

   public LaptopEngagePacket() {
   }

   public LaptopEngagePacket(int tX, int tY, int tZ, int lX, int lY, int lZ, boolean carpet) {
      this.tx = tX;
      this.ty = tY;
      this.tz = tZ;
      this.lx = lX;
      this.ly = lY;
      this.lz = lZ;
      this.c = carpet;
   }

   public void fromBytes(ByteBuf buf) {
      this.tx = buf.readInt();
      this.ty = buf.readInt();
      this.tz = buf.readInt();
      this.lx = buf.readInt();
      this.ly = buf.readInt();
      this.lz = buf.readInt();
      this.c = buf.readBoolean();
   }

   public void toBytes(ByteBuf buf) {
      buf.writeInt(this.tx);
      buf.writeInt(this.ty);
      buf.writeInt(this.tz);
      buf.writeInt(this.lx);
      buf.writeInt(this.ly);
      buf.writeInt(this.lz);
      buf.writeBoolean(this.c);
   }

   public static class Handler implements IMessageHandler<LaptopEngagePacket, IMessage> {
      public IMessage onMessage(LaptopEngagePacket m, MessageContext ctx) {
         EntityPlayer player = ctx.getServerHandler().field_147369_b;
         World world = player.field_70170_p;
         if (player.func_70092_e(m.lx, m.ly, m.lz) < 100.0) {
            TileEntity te = world.func_147438_o(m.lx, m.ly, m.lz);
            if (te != null && te instanceof TileEntityLaptop) {
               TileEntityLaptop tel = (TileEntityLaptop)te;
               if (!m.c && tel.b2spirit > 0) {
                  int XX = 11;
                  int ZZ = 10;
                  if (tel.rrteam == RivalRebelsTeam.OMEGA) {
                     XX = m.tx - RivalRebels.round.oObjx;
                     ZZ = m.tz - RivalRebels.round.oObjz;
                  }

                  if (tel.rrteam == RivalRebelsTeam.SIGMA) {
                     XX = m.tx - RivalRebels.round.sObjx;
                     ZZ = m.tz - RivalRebels.round.sObjz;
                  }

                  int xx = m.tx - m.lx;
                  int zz = m.tz - m.lz;
                  if (xx * xx + zz * zz > 625 && XX * XX + ZZ * ZZ > 200) {
                     tel.b2spirit--;
                     world.func_72838_d(
                        new EntityB2Spirit(
                           world, m.tx, m.ty, m.tz, player.field_70165_t, player.field_70163_u, player.field_70161_v, false, player.func_70093_af()
                        )
                     );
                  }
               }

               if (m.c && tel.b2carpet > 0) {
                  int XX = 11;
                  int ZZ = 10;
                  int xx = m.tx - m.lx;
                  int zz = m.tz - m.lz;
                  if (xx * xx + zz * zz > 625 && XX * XX + ZZ * ZZ > 200) {
                     tel.b2carpet--;
                     world.func_72838_d(
                        new EntityB2Spirit(world, m.tx, m.ty, m.tz, player.field_70165_t, player.field_70163_u, player.field_70161_v, true, false)
                     );
                  }
               }
            }
         }

         return null;
      }
   }
}
