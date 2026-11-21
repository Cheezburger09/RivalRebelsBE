package assets.rivalrebels.common.round;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.FileRW;
import assets.rivalrebels.common.entity.EntityRhodes;
import assets.rivalrebels.common.packet.GuiSpawnPacket;
import assets.rivalrebels.common.packet.InspectPacket;
import assets.rivalrebels.common.packet.PacketDispatcher;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.Type;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.scoreboard.IScoreObjectiveCriteria;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class RivalRebelsRound implements IMessage {
   private File rounddata;
   private int cSpawnx = -1;
   private int cSpawnz = -1;
   public int oObjx = -1;
   public int oObjy = -1;
   public int oObjz = -1;
   public int sObjx = -1;
   public int sObjy = -1;
   public int sObjz = -1;
   private String MotD = "Select your class and nuke the enemy team's objective to win.";
   public RivalRebelsPlayerList rrplayerlist = new RivalRebelsPlayerList();
   public World world;
   private int winCountdown = 0;
   private int omegaWins = 0;
   private int sigmaWins = 0;
   private boolean lastwinomega = false;
   private boolean fatnuke = false;
   public int waitVotes = 0;
   public int newBattleVotes = 0;
   private int spawnRadius = 20;
   private int spawnRadius2 = 400;
   private int objRadius = 29;
   private int objRadius2 = 841;
   private int spawnDist = 150;
   private int objDist = 200;
   private boolean roundstarted = false;
   public int omegaHealth = RivalRebels.objectiveHealth;
   public int sigmaHealth = RivalRebels.objectiveHealth;
   private List<RivalRebelsRound.PlayerInvisibility> players = new ArrayList<>();

   public RivalRebelsRound() {
   }

   public RivalRebelsRound(int spr, int spd, int obd) {
      this();
      this.spawnRadius = spr;
      this.spawnRadius2 = spr * spr;
      this.spawnDist = spd;
      this.objDist = obd;
   }

   public void fromBytes(ByteBuf buf) {
      this.roundstarted = buf.readBoolean();
      this.cSpawnx = buf.readInt();
      this.cSpawnz = buf.readInt();
      this.oObjx = buf.readInt();
      this.oObjy = buf.readInt();
      this.oObjz = buf.readInt();
      this.sObjx = buf.readInt();
      this.sObjy = buf.readInt();
      this.sObjz = buf.readInt();
      this.winCountdown = buf.readInt();
      this.omegaWins = buf.readInt();
      this.sigmaWins = buf.readInt();
      this.lastwinomega = buf.readBoolean();
      this.fatnuke = buf.readBoolean();
      byte[] bytes = new byte[buf.readInt()];
      buf.readBytes(bytes);
      this.MotD = FileRW.getStringBytes(bytes);
      this.rrplayerlist.fromBytes(buf);
   }

   public void toBytes(ByteBuf buf) {
      buf.writeBoolean(this.roundstarted);
      buf.writeInt(this.cSpawnx);
      buf.writeInt(this.cSpawnz);
      buf.writeInt(this.oObjx);
      buf.writeInt(this.oObjy);
      buf.writeInt(this.oObjz);
      buf.writeInt(this.sObjx);
      buf.writeInt(this.sObjy);
      buf.writeInt(this.sObjz);
      buf.writeInt(this.winCountdown);
      buf.writeInt(this.omegaWins);
      buf.writeInt(this.sigmaWins);
      buf.writeBoolean(this.lastwinomega);
      buf.writeBoolean(this.fatnuke);
      buf.writeInt(this.MotD.length());
      buf.writeBytes(FileRW.getBytesString(this.MotD));
      this.rrplayerlist.toBytes(buf);
   }

   public void copy(RivalRebelsRound m) {
      this.roundstarted = m.roundstarted;
      this.cSpawnx = m.cSpawnx;
      this.cSpawnz = m.cSpawnz;
      this.oObjx = m.oObjx;
      this.oObjy = m.oObjy;
      this.oObjz = m.oObjz;
      this.sObjx = m.sObjx;
      this.sObjy = m.sObjy;
      this.sObjz = m.sObjz;
      this.winCountdown = m.winCountdown;
      this.omegaWins = m.omegaWins;
      this.sigmaWins = m.sigmaWins;
      this.lastwinomega = m.lastwinomega;
      this.MotD = m.MotD;
      this.rrplayerlist = m.rrplayerlist;
   }

   public void newRound() {
      this.fatnuke = false;
      if (!this.roundstarted) {
         this.startRound(0, 0);
      } else {
         this.rrplayerlist = new RivalRebelsPlayerList();

         for (EntityPlayer player : this.world.field_73010_i) {
            player.func_70097_a(DamageSource.field_76380_i, 20000.0F);
            player.field_71071_by.func_146027_a(null, -1);
         }

         this.cSpawnz = this.cSpawnz + this.spawnDist;
         this.world.func_72950_A(this.cSpawnx, 200, this.cSpawnz);
         float f = RivalRebels.rhodesChance;

         while (f >= 1.0F) {
            f--;
            this.world.func_72838_d(new EntityRhodes(this.world, this.cSpawnx + Math.random() - 0.5, 170.0, this.cSpawnz + Math.random() - 0.5, 1.0F));
         }

         if (f > Math.random()) {
            this.world.func_72838_d(new EntityRhodes(this.world, this.cSpawnx + Math.random() - 0.5, 170.0, this.cSpawnz + Math.random() - 0.5, 1.0F));
         }

         this.buildSpawn();
         this.omegaHealth = RivalRebels.objectiveHealth;
         this.sigmaHealth = RivalRebels.objectiveHealth;
         PacketDispatcher.packetsys.sendToAll(this);
      }
   }

   public void startRound(int x, int z) {
      this.fatnuke = false;
      this.roundstarted = true;
      this.cSpawnx = x;
      this.cSpawnz = z - this.spawnDist;
      this.newRound();
   }

   public void roundManualStart() {
      if (!this.roundstarted || this.fatnuke) {
         this.fatnuke = true;
         this.roundstarted = true;
         this.rrplayerlist = new RivalRebelsPlayerList();
         this.cSpawnx = (this.oObjx + this.sObjx) / 2;
         this.cSpawnz = (this.oObjz + this.sObjz) / 2;
         this.world.func_72950_A(this.cSpawnx, this.world.func_72976_f(this.cSpawnx, this.cSpawnz), this.cSpawnz);
         this.omegaHealth = RivalRebels.objectiveHealth;
         this.sigmaHealth = RivalRebels.objectiveHealth;
         PacketDispatcher.packetsys.sendToAll(this);
      }
   }

   public void setInvisible(EntityPlayer player) {
      if (player != null) {
         boolean contained = false;

         for (int i = this.players.size() - 1; i >= 0; i--) {
            RivalRebelsRound.PlayerInvisibility t = this.players.get(i);
            if (t.player == player) {
               t.durationleft = 120;
               contained = true;
            }
         }

         if (!contained) {
            this.players.add(new RivalRebelsRound.PlayerInvisibility(player, 120));
         }
      }
   }

   @SubscribeEvent
   public void updateRound(TickEvent event) {
      if (this.roundstarted && this.winCountdown > 0 && event.phase.equals(Phase.END)) {
         if (event.type == Type.SERVER) {
            this.updateServer();
         }

         if (event.type == Type.CLIENT) {
            this.updateClient();
         }
      }

      if (event.type == Type.CLIENT && event.phase.equals(Phase.END)) {
         this.updateInvisible();
      }
   }

   public void updateServer() {
      this.winCountdown--;
      if (this.winCountdown == 0 && !this.fatnuke) {
         if (this.newBattleVotes >= this.waitVotes) {
            this.newBattleVotes = 0;
            this.waitVotes = 0;
            this.rrplayerlist.clearVotes();
            this.newRound();
         } else {
            this.newBattleVotes = 0;
            this.waitVotes = 0;
            this.rrplayerlist.clearVotes();
            this.winCountdown = 1199;
            PacketDispatcher.packetsys.sendToAll(this);
         }
      }
   }

   @SideOnly(Side.CLIENT)
   public void updateInvisible() {
      if (Minecraft.func_71410_x().field_71441_e != null) {
         List playerlist = Minecraft.func_71410_x().field_71441_e.field_73010_i;

         for (int i = 0; i < playerlist.size(); i++) {
            EntityPlayer e = (EntityPlayer)playerlist.get(i);
            if (e.field_71071_by.field_70460_b[3] != null && e.field_71071_by.field_70460_b[3].func_77973_b() == RivalRebels.camera) {
               this.setInvisible(e);
            }
         }

         for (int i = this.players.size() - 1; i >= 0; i--) {
            RivalRebelsRound.PlayerInvisibility t = this.players.get(i);
            t.durationleft--;
            if (t.durationleft <= 0) {
               t.player.field_70155_l = 1.0;
               this.players.remove(i);
            } else {
               t.player.field_70155_l = 0.0;
            }
         }
      }
   }

   @SideOnly(Side.CLIENT)
   public void updateClient() {
      this.winCountdown--;
      if (this.winCountdown == 0 && !this.fatnuke) {
         RivalRebels.proxy.closeGui();
      } else if (this.winCountdown == 400 && !this.fatnuke) {
         RivalRebels.proxy.nextBattle();
      } else if (this.winCountdown == 1000) {
         RivalRebels.proxy.closeGui();
      } else if (this.winCountdown == 1200) {
         RivalRebels.proxy.teamWin(this.lastwinomega);
      }
   }

   public void load() {
      MinecraftServer server = MinecraftServer.func_71276_C();
      if (server != null) {
         this.world = server.func_71218_a(0);
         Scoreboard scrb = this.world.func_96441_U();

         try {
            ScorePlayerTeam omega = scrb.func_96527_f(RivalRebelsTeam.OMEGA.toString());
            ScorePlayerTeam sigma = scrb.func_96527_f(RivalRebelsTeam.SIGMA.toString());
            omega.func_96666_b("§aΩ");
            sigma.func_96666_b("§9Σ");
            omega.func_96660_a(false);
            sigma.func_96660_a(false);
            ScoreObjective kills = scrb.func_96535_a("kills", IScoreObjectiveCriteria.field_96639_d);
            scrb.func_96530_a(0, kills);
            ScoreObjective deaths = scrb.func_96535_a("deaths", IScoreObjectiveCriteria.field_96642_c);
            if (RivalRebels.scoreboardenabled) {
               scrb.func_96530_a(1, deaths);
            }

            deaths.func_96681_a("§8R§7I§fV§7A§8L R§7E§fBE§7L§8S");
         } catch (Exception var7) {
         }

         this.world.func_82736_K().func_82764_b("keepInventory", "true");
         this.rounddata = new File(this.world.func_72860_G().func_75765_b(), "rivalrebelsgamedata");
         if (this.rounddata.exists()) {
            this.fromBytes(Unpooled.wrappedBuffer(FileRW.readbytes(this.rounddata)));
         }
      }
   }

   public void save() {
      ByteBuf data = Unpooled.buffer();
      this.toBytes(data);
      FileRW.writebytes(this.rounddata, Arrays.copyOf(data.array(), data.writerIndex()));
   }

   @SubscribeEvent
   public void onPlayerLogin(PlayerLoggedInEvent event) {
      PacketDispatcher.packetsys.sendTo(new InspectPacket(), (EntityPlayerMP)event.player);
      if (this.roundstarted) {
         if (!this.rrplayerlist.contains(event.player.func_70005_c_())) {
            event.player.field_71071_by.func_146027_a(null, -1);
            event.player.func_70012_b(this.cSpawnx, 200.0, this.cSpawnz, 0.0F, 0.0F);
         }

         PacketDispatcher.packetsys.sendTo(this.rrplayerlist, (EntityPlayerMP)event.player);
         if (this.isInSpawn(event.player)) {
            PacketDispatcher.packetsys.sendTo(new GuiSpawnPacket(), (EntityPlayerMP)event.player);
         }
      }
   }

   @SubscribeEvent
   public void onPlayerRespawn(PlayerRespawnEvent event) {
      if (this.roundstarted) {
         event.player.func_70012_b(this.cSpawnx, 200.0, this.cSpawnz, 0.0F, 0.0F);
         PacketDispatcher.packetsys.sendTo(new GuiSpawnPacket(), (EntityPlayerMP)event.player);
      }
   }

   private void buildSpawn() {
      int r = this.spawnRadius;
      int rs4 = (this.spawnRadius - 2) * (this.spawnRadius - 2);
      int rs1 = (this.spawnRadius - 1) * (this.spawnRadius - 1);
      int hrs = (int)(this.spawnRadius * 0.65F);

      for (int x1 = -this.spawnRadius; x1 < this.spawnRadius; x1++) {
         int XX = x1 * x1;

         for (int z1 = -this.spawnRadius; z1 < this.spawnRadius; z1++) {
            int ZZ = z1 * z1 + XX;

            for (int y1 = -5; y1 < hrs; y1++) {
               int YY = y1 * y1 + ZZ;
               if (YY > rs4 && YY < this.spawnRadius2 || (y1 == -2 || y1 == -3 || y1 == -4) && YY < rs1) {
                  this.world.func_147449_b(this.cSpawnx + x1, 200 + y1, this.cSpawnz + z1, RivalRebels.fshield);
               }
            }
         }
      }

      this.oObjx = this.cSpawnx + this.objDist;
      this.oObjz = this.cSpawnz;
      this.sObjx = this.cSpawnx - this.objDist;
      this.sObjz = this.cSpawnz;
      Chunk chunk = this.world.func_72938_d(this.oObjx, this.oObjz);
      int x = this.oObjx & 15;
      int z = this.oObjz & 15;

      for (this.oObjy = chunk.func_76625_h() + 15; this.oObjy > 0; this.oObjy--) {
         Block block = chunk.func_150810_a(x, this.oObjy, z);
         if (block != Blocks.field_150350_a) {
            break;
         }
      }

      chunk = this.world.func_72938_d(this.sObjx, this.sObjz);
      x = this.sObjx & 15;
      z = this.sObjz & 15;

      for (this.sObjy = chunk.func_76625_h() + 15; this.sObjy > 0; this.sObjy--) {
         Block block = chunk.func_150810_a(x, this.sObjy, z);
         if (block != Blocks.field_150350_a) {
            break;
         }
      }

      for (int xx = -this.objRadius; xx <= this.objRadius; xx++) {
         int XX = xx * xx;

         for (int zz = -this.objRadius; zz <= this.objRadius; zz++) {
            int ZZ = zz * zz + XX;
            if (ZZ <= this.objRadius2) {
               if (Math.abs(xx) == 15 && Math.abs(zz) == 15) {
                  this.world.func_147449_b(this.oObjx + xx, this.oObjy, this.oObjz + zz, RivalRebels.fshield);
                  this.world.func_147449_b(this.sObjx + xx, this.sObjy, this.sObjz + zz, RivalRebels.fshield);
               } else {
                  this.world.func_147449_b(this.oObjx + xx, this.oObjy, this.oObjz + zz, RivalRebels.reactive);
                  this.world.func_147449_b(this.sObjx + xx, this.sObjy, this.sObjz + zz, RivalRebels.reactive);
               }

               for (int yy = 1; yy <= 7; yy++) {
                  this.world.func_147449_b(this.oObjx + xx, this.oObjy + yy, this.oObjz + zz, Blocks.field_150350_a);
                  this.world.func_147449_b(this.sObjx + xx, this.sObjy + yy, this.sObjz + zz, Blocks.field_150350_a);
               }
            }
         }
      }

      this.world.func_147449_b(this.oObjx + 21, this.oObjy, this.oObjz + 21, RivalRebels.conduit);
      this.world.func_147449_b(this.oObjx + 21, this.oObjy, this.oObjz - 21, RivalRebels.conduit);
      this.world.func_147449_b(this.oObjx - 21, this.oObjy, this.oObjz + 21, RivalRebels.conduit);
      this.world.func_147449_b(this.oObjx - 21, this.oObjy, this.oObjz - 21, RivalRebels.conduit);
      this.world.func_147449_b(this.sObjx + 21, this.sObjy, this.sObjz + 21, RivalRebels.conduit);
      this.world.func_147449_b(this.sObjx + 21, this.sObjy, this.sObjz - 21, RivalRebels.conduit);
      this.world.func_147449_b(this.sObjx - 21, this.sObjy, this.sObjz + 21, RivalRebels.conduit);
      this.world.func_147449_b(this.sObjx - 21, this.sObjy, this.sObjz - 21, RivalRebels.conduit);

      for (int i = 0; i < 4; i++) {
         this.world.func_147449_b(this.oObjx + 21, this.oObjy + 1 + i, this.oObjz + 21, Blocks.field_150350_a);
         this.world.func_147449_b(this.oObjx + 21, this.oObjy + 1 + i, this.oObjz - 21, Blocks.field_150350_a);
         this.world.func_147449_b(this.oObjx - 21, this.oObjy + 1 + i, this.oObjz + 21, Blocks.field_150350_a);
         this.world.func_147449_b(this.oObjx - 21, this.oObjy + 1 + i, this.oObjz - 21, Blocks.field_150350_a);
         this.world.func_147449_b(this.sObjx + 21, this.sObjy + 1 + i, this.sObjz + 21, Blocks.field_150350_a);
         this.world.func_147449_b(this.sObjx + 21, this.sObjy + 1 + i, this.sObjz - 21, Blocks.field_150350_a);
         this.world.func_147449_b(this.sObjx - 21, this.sObjy + 1 + i, this.sObjz + 21, Blocks.field_150350_a);
         this.world.func_147449_b(this.sObjx - 21, this.sObjy + 1 + i, this.sObjz - 21, Blocks.field_150350_a);
      }

      this.world.func_147449_b(this.oObjx, this.oObjy + 1, this.oObjz, RivalRebels.omegaobj);
      this.world.func_147449_b(this.sObjx, this.sObjy + 1, this.sObjz, RivalRebels.sigmaobj);
      if (RivalRebels.rhodesRoundsBase) {
         this.world.func_147449_b(this.oObjx, this.oObjy + 2, this.oObjz, RivalRebels.buildrhodes);
         this.world.func_147449_b(this.sObjx, this.sObjy + 2, this.sObjz, RivalRebels.buildrhodes);
      }
   }

   private boolean isInSpawn(EntityPlayer player) {
      return player.field_70163_u < 203.0 && player.field_70163_u > 198.0 && player.func_70092_e(this.cSpawnx, 200.0, this.cSpawnz) < this.spawnRadius2;
   }

   public void winSigma() {
      if (this.roundstarted) {
         this.winCountdown = 1400;
         this.sigmaWins++;
         this.lastwinomega = false;
         this.world.func_147449_b(this.oObjx, this.oObjy, this.oObjz, RivalRebels.plasmaexplosion);
         this.world.func_147449_b(this.sObjx, this.sObjy, this.sObjz, RivalRebels.plasmaexplosion);

         for (int xpl = -this.objRadius; xpl < this.objRadius; xpl++) {
            int xxpl = xpl * xpl;

            for (int zpl = -this.objRadius; zpl < this.objRadius; zpl++) {
               int zzpl = zpl * zpl + xxpl;
               if (zzpl < this.objRadius2) {
                  for (int ypl = -1; ypl < 7; ypl++) {
                     for (int i = 0; i < 16; i++) {
                        this.world.func_147449_b(this.oObjx + xpl, this.oObjy + ypl, this.oObjz + zpl, Blocks.field_150350_a);
                     }
                  }
               }
            }
         }

         PacketDispatcher.packetsys.sendToAll(this);
      }
   }

   public void winOmega() {
      if (this.roundstarted) {
         this.winCountdown = 1400;
         this.omegaWins++;
         this.lastwinomega = true;
         this.world.func_147449_b(this.oObjx, this.oObjy, this.oObjz, RivalRebels.plasmaexplosion);
         this.world.func_147449_b(this.sObjx, this.sObjy, this.sObjz, RivalRebels.plasmaexplosion);

         for (int xpl = -this.objRadius; xpl < this.objRadius; xpl++) {
            int xxpl = xpl * xpl;

            for (int zpl = -this.objRadius; zpl < this.objRadius; zpl++) {
               int zzpl = zpl * zpl + xxpl;
               if (zzpl < this.objRadius2) {
                  for (int ypl = -1; ypl < 7; ypl++) {
                     for (int i = 0; i < 16; i++) {
                        this.world.func_147449_b(this.sObjx + xpl, this.sObjy + ypl, this.sObjz + zpl, Blocks.field_150350_a);
                     }
                  }
               }
            }
         }

         PacketDispatcher.packetsys.sendToAll(this);
      }
   }

   public void stopRounds() {
      if (this.roundstarted) {
         this.world.func_147449_b(this.oObjx, this.oObjy, this.oObjz, RivalRebels.plasmaexplosion);
         this.world.func_147449_b(this.sObjx, this.sObjy, this.sObjz, RivalRebels.plasmaexplosion);
         this.winCountdown = 0;
         this.roundstarted = false;
         this.rrplayerlist.clearTeam();
         PacketDispatcher.packetsys.sendToAll(this);
      }
   }

   public int takeOmegaHealth(int amnt) {
      if (amnt > this.omegaHealth) {
         int tmp = this.omegaHealth;
         this.omegaHealth = 0;
         this.winSigma();
         return tmp;
      } else {
         this.omegaHealth -= amnt;
         return amnt;
      }
   }

   public int takeSigmaHealth(int amnt) {
      if (amnt > this.sigmaHealth) {
         int tmp = this.sigmaHealth;
         this.sigmaHealth = 0;
         this.winOmega();
         return tmp;
      } else {
         this.sigmaHealth -= amnt;
         return amnt;
      }
   }

   public int getOmegaWins() {
      return this.omegaWins;
   }

   public int getSigmaWins() {
      return this.sigmaWins;
   }

   public String getMotD() {
      return this.MotD;
   }

   public void setMotD(String[] array) {
      StringBuilder strb = new StringBuilder();

      for (int i = 0; i < array.length; i++) {
         strb.append(array[i]);
         strb.append(" ");
      }

      this.MotD = strb.toString();
      PacketDispatcher.packetsys.sendToAll(this);
   }

   public boolean isStarted() {
      return this.roundstarted;
   }

   public float addOmegaHealth(float power) {
      this.omegaHealth = (int)(this.omegaHealth + power);
      if (this.omegaHealth > RivalRebels.objectiveHealth) {
         int tmp = this.omegaHealth - RivalRebels.objectiveHealth;
         this.omegaHealth = RivalRebels.objectiveHealth;
         return tmp;
      } else {
         return 0.0F;
      }
   }

   public float addSigmaHealth(float power) {
      this.sigmaHealth = (int)(this.sigmaHealth + power);
      if (this.sigmaHealth > RivalRebels.objectiveHealth) {
         int tmp = this.sigmaHealth - RivalRebels.objectiveHealth;
         this.sigmaHealth = RivalRebels.objectiveHealth;
         return tmp;
      } else {
         return 0.0F;
      }
   }

   public static class Handler implements IMessageHandler<RivalRebelsRound, IMessage> {
      public IMessage onMessage(RivalRebelsRound m, MessageContext ctx) {
         RivalRebels.round.copy(m);
         return null;
      }
   }

   public class PlayerInvisibility {
      public EntityPlayer player;
      public int durationleft;

      public PlayerInvisibility(EntityPlayer p, int i) {
         this.player = p;
         this.durationleft = i;
      }
   }
}
