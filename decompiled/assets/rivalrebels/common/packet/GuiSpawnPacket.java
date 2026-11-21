package assets.rivalrebels.common.packet;

import assets.rivalrebels.RivalRebels;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;

public class GuiSpawnPacket implements IMessage {
   public void fromBytes(ByteBuf buf) {
   }

   public void toBytes(ByteBuf buf) {
   }

   public static class Handler implements IMessageHandler<GuiSpawnPacket, IMessage> {
      public IMessage onMessage(GuiSpawnPacket m, MessageContext ctx) {
         if (RivalRebels.round.rrplayerlist.getForName(Minecraft.func_71410_x().field_71439_g.func_70005_c_()).isreset) {
            RivalRebels.proxy.guiClass();
         } else {
            RivalRebels.proxy.guiSpawn();
         }

         return null;
      }
   }
}
