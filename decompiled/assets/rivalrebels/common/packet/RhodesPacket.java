package assets.rivalrebels.common.packet;

import assets.rivalrebels.common.core.FileRW;
import assets.rivalrebels.common.entity.EntityRhodes;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class RhodesPacket implements IMessage {
   int id = 0;
   boolean fire = false;
   boolean forcefield = false;
   boolean plasma = false;
   float scale = 0.0F;
   float headyaw = 0.0F;
   float headpitch = 0.0F;
   float leftarmyaw = 0.0F;
   float leftarmpitch = 0.0F;
   float rightarmyaw = 0.0F;
   float rightarmpitch = 0.0F;
   float leftthighpitch = 0.0F;
   float rightthighpitch = 0.0F;
   float leftshinpitch = 0.0F;
   float rightshinpitch = 0.0F;
   int health;
   byte laserOn;
   byte colorType;
   int b2energy;
   int riderid;
   int pass1id;
   int pass2id;
   int rocketcount;
   int energy;
   int flamecount;
   int nukecount;
   public float bodyyaw;
   String texloc;
   int texfolder;

   public RhodesPacket() {
   }

   public RhodesPacket(EntityRhodes er) {
      this.id = er.func_145782_y();
      this.fire = er.field_70151_c;
      this.plasma = er.plasma;
      this.bodyyaw = er.bodyyaw;
      this.headyaw = er.headyaw;
      this.headpitch = er.headpitch;
      this.leftarmyaw = er.leftarmyaw;
      this.leftarmpitch = er.leftarmpitch;
      this.rightarmyaw = er.rightarmyaw;
      this.rightarmpitch = er.rightarmpitch;
      this.leftthighpitch = er.leftthighpitch;
      this.rightthighpitch = er.rightthighpitch;
      this.leftshinpitch = er.leftshinpitch;
      this.rightshinpitch = er.rightshinpitch;
      this.health = er.health;
      this.laserOn = er.laserOn;
      this.forcefield = er.forcefield;
      this.colorType = er.colorType;
      this.b2energy = er.b2energy;
      this.riderid = er.rider != null ? er.rider.func_145782_y() : -1;
      this.pass1id = er.passenger1 != null ? er.passenger1.func_145782_y() : -1;
      this.pass2id = er.passenger2 != null ? er.passenger2.func_145782_y() : -1;
      this.rocketcount = er.rocketcount;
      this.energy = er.energy;
      this.flamecount = er.flamecount;
      this.nukecount = er.nukecount;
      this.texloc = er.itexloc;
      this.texfolder = er.itexfolder;
      this.scale = er.scale;
   }

   public void fromBytes(ByteBuf buf) {
      this.id = buf.readInt();
      this.fire = buf.readBoolean();
      this.plasma = buf.readBoolean();
      this.forcefield = buf.readBoolean();
      this.bodyyaw = buf.readShort() * 0.005493248F;
      this.headyaw = buf.readShort() * 0.005493248F;
      this.headpitch = buf.readShort() * 0.005493248F;
      this.leftarmyaw = buf.readShort() * 0.005493248F;
      this.leftarmpitch = buf.readShort() * 0.005493248F;
      this.rightarmyaw = buf.readShort() * 0.005493248F;
      this.rightarmpitch = buf.readShort() * 0.005493248F;
      this.leftthighpitch = buf.readShort() * 0.005493248F;
      this.rightthighpitch = buf.readShort() * 0.005493248F;
      this.leftshinpitch = buf.readShort() * 0.005493248F;
      this.rightshinpitch = buf.readShort() * 0.005493248F;
      this.health = buf.readShort();
      this.laserOn = buf.readByte();
      this.colorType = buf.readByte();
      this.b2energy = buf.readShort();
      this.riderid = buf.readInt();
      this.pass1id = buf.readInt();
      this.pass2id = buf.readInt();
      this.scale = buf.readFloat();
      this.rocketcount = buf.readShort();
      this.energy = buf.readShort();
      this.flamecount = buf.readShort();
      this.nukecount = buf.readByte();
      this.texfolder = buf.readByte();
      if (this.texfolder != 0) {
         byte[] dst = new byte[this.texfolder % 10];
         buf.readBytes(dst);
         this.texloc = FileRW.getStringBytes(dst);
         this.texfolder = this.texfolder - this.texfolder % 10;
         this.texfolder /= 10;
      } else {
         this.texfolder = -1;
      }
   }

   public void toBytes(ByteBuf buf) {
      buf.writeInt(this.id);
      buf.writeBoolean(this.fire);
      buf.writeBoolean(this.plasma);
      buf.writeBoolean(this.forcefield);
      buf.writeShort((short)(this.bodyyaw * 182.04167F));
      buf.writeShort((short)(this.headyaw * 182.04167F));
      buf.writeShort((short)(this.headpitch * 182.04167F));
      buf.writeShort((short)(this.leftarmyaw * 182.04167F));
      buf.writeShort((short)(this.leftarmpitch * 182.04167F));
      buf.writeShort((short)(this.rightarmyaw * 182.04167F));
      buf.writeShort((short)(this.rightarmpitch * 182.04167F));
      buf.writeShort((short)(this.leftthighpitch * 182.04167F));
      buf.writeShort((short)(this.rightthighpitch * 182.04167F));
      buf.writeShort((short)(this.leftshinpitch * 182.04167F));
      buf.writeShort((short)(this.rightshinpitch * 182.04167F));
      buf.writeShort(this.health);
      buf.writeByte(this.laserOn);
      buf.writeByte(this.colorType);
      buf.writeShort(this.b2energy);
      buf.writeInt(this.riderid);
      buf.writeInt(this.pass1id);
      buf.writeInt(this.pass2id);
      buf.writeFloat(this.scale);
      buf.writeShort(this.rocketcount);
      buf.writeShort(this.energy);
      buf.writeShort(this.flamecount);
      buf.writeByte(this.nukecount);
      if (this.texfolder == -1) {
         buf.writeByte(0);
      } else {
         buf.writeByte(this.texfolder * 10 + this.texloc.length());
         buf.writeBytes(FileRW.getBytesString(this.texloc));
      }
   }

   public static class Handler implements IMessageHandler<RhodesPacket, IMessage> {
      public IMessage onMessage(RhodesPacket m, MessageContext ctx) {
         Entity e = Minecraft.func_71410_x().field_71441_e.func_73045_a(m.id);
         if (e instanceof EntityRhodes) {
            EntityRhodes er = (EntityRhodes)e;
            er.lastbodyyaw = er.bodyyaw;
            er.lastheadyaw = er.headyaw;
            er.lastheadpitch = er.headpitch;
            er.lastleftarmyaw = er.leftarmyaw;
            er.lastleftarmpitch = er.leftarmpitch;
            er.lastrightarmyaw = er.rightarmyaw;
            er.lastrightarmpitch = er.rightarmpitch;
            er.lastleftthighpitch = er.leftthighpitch;
            er.lastrightthighpitch = er.rightthighpitch;
            er.lastleftshinpitch = er.leftshinpitch;
            er.lastrightshinpitch = er.rightshinpitch;
            er.field_70151_c = m.fire;
            er.plasma = m.plasma;
            if (Math.abs(er.bodyyaw - m.bodyyaw) > 90.0F) {
               er.lastbodyyaw = m.bodyyaw;
            }

            if (Math.abs(er.rightarmyaw - m.rightarmyaw) > 90.0F) {
               er.lastrightarmyaw = m.rightarmyaw;
            }

            if (Math.abs(er.leftarmyaw - m.leftarmyaw) > 90.0F) {
               er.lastleftarmyaw = m.leftarmyaw;
            }

            er.bodyyaw = m.bodyyaw;
            er.headyaw = m.headyaw;
            er.headpitch = m.headpitch;
            er.leftarmyaw = m.leftarmyaw;
            er.leftarmpitch = m.leftarmpitch;
            er.rightarmyaw = m.rightarmyaw;
            er.rightarmpitch = m.rightarmpitch;
            er.leftthighpitch = m.leftthighpitch;
            er.rightthighpitch = m.rightthighpitch;
            er.leftshinpitch = m.leftshinpitch;
            er.rightshinpitch = m.rightshinpitch;
            er.health = m.health;
            er.laserOn = m.laserOn;
            er.forcefield = m.forcefield;
            er.colorType = m.colorType;
            er.b2energy = m.b2energy;
            er.ticksSinceLastPacket = 0;
            er.rocketcount = m.rocketcount;
            er.energy = m.energy;
            er.flamecount = m.flamecount;
            er.nukecount = m.nukecount;
            er.itexloc = m.texloc;
            er.itexfolder = m.texfolder;
            er.scale = m.scale;
            if (er.health <= 0 && er.rider != null) {
               er.rider.func_70107_b(er.field_70165_t + 5.0, er.field_70163_u - 12.0, er.field_70161_v);
               er.rider.field_71075_bZ.field_75102_a = false;
               er.rider = null;
            } else {
               er.rider = m.riderid == -1 ? null : (EntityPlayer)er.field_70170_p.func_73045_a(m.riderid);
               er.passenger1 = m.pass1id == -1 ? null : (EntityPlayer)er.field_70170_p.func_73045_a(m.pass1id);
               er.passenger2 = m.pass2id == -1 ? null : (EntityPlayer)er.field_70170_p.func_73045_a(m.pass2id);
            }
         }

         return null;
      }
   }
}
