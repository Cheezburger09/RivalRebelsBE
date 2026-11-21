package assets.rivalrebels.common.entity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsDamageSource;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import assets.rivalrebels.common.explosion.Explosion;
import assets.rivalrebels.common.packet.PacketDispatcher;
import assets.rivalrebels.common.packet.RhodesJumpPacket;
import assets.rivalrebels.common.packet.RhodesPacket;
import assets.rivalrebels.common.packet.TextPacket;
import assets.rivalrebels.common.round.RivalRebelsPlayer;
import assets.rivalrebels.common.round.RivalRebelsTeam;
import assets.rivalrebels.common.tileentity.TileEntityNukeCrate;
import assets.rivalrebels.common.tileentity.TileEntityReactor;
import assets.rivalrebels.common.tileentity.TileEntityRhodesActivator;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityRhodes extends Entity {
   public int health = RivalRebels.rhodesHealth;
   public float scale = 1.0F;
   private int damageUntilWake = 100;
   private static HashSet blocklist = new HashSet();
   public static String[] names = new String[]{
      "Rhodes",
      "Magnesium",
      "Arsenic",
      "Vanadium",
      "Aurum",
      "Iodine",
      "Iron",
      "Astatine",
      "Cobalt",
      "Strontium",
      "Bismuth",
      "Zinc",
      "Osmium",
      "Neon",
      "Argent",
      "Wolfram",
      "Space"
   };
   public float bodyyaw = 0.0F;
   public float headyaw = 0.0F;
   public float headpitch = 0.0F;
   public float leftarmyaw = 0.0F;
   public float leftarmpitch = 0.0F;
   public float rightarmyaw = 0.0F;
   public float rightarmpitch = 0.0F;
   public float leftthighpitch = 0.0F;
   public float rightthighpitch = 0.0F;
   public float leftshinpitch = 0.0F;
   public float rightshinpitch = 0.0F;
   public float lastbodyyaw = 0.0F;
   public float lastheadyaw = 0.0F;
   public float lastheadpitch = 0.0F;
   public float lastleftarmyaw = 0.0F;
   public float lastleftarmpitch = 0.0F;
   public float lastrightarmyaw = 0.0F;
   public float lastrightarmpitch = 0.0F;
   public float lastleftthighpitch = 0.0F;
   public float lastrightthighpitch = 0.0F;
   public float lastleftshinpitch = 0.0F;
   public float lastrightshinpitch = 0.0F;
   public boolean field_70151_c;
   public boolean endangered = false;
   public int flying = 0;
   public int ticksSinceLastPacket = 0;
   public byte laserOn = 0;
   public byte colorType = 0;
   public static byte lastct = 0;
   public static int forcecolor = -1;
   public EntityPlayer rider;
   public EntityPlayer passenger1;
   public EntityPlayer passenger2;
   public static final int recharge = 3;
   public static final int ecjet = 13;
   public static final int eclaser = 9;
   public static final int ecshield = 11;
   public static final int maxenergy = 800;
   public int energy = 800;
   public int b2energy = 0;
   public int nukecount = 8;
   public int rocketcount = 5000;
   public int flamecount = 10000;
   public boolean rocket = false;
   public boolean laser = false;
   public boolean prevflame = false;
   public boolean flame = false;
   public boolean forcefield = false;
   public boolean plasma = false;
   public boolean bomb = false;
   public boolean jet = false;
   public boolean stop = true;
   public boolean guard = false;
   public boolean b2spirit = false;
   public boolean freeze = false;
   public int plasmacharge = 0;
   public int tickssincenuke = 10;
   public static String texloc;
   public static int texfolder = -1;
   public String itexloc;
   public int itexfolder;
   public int wakeX = -1;
   public int wakeY = -1;
   public int wakeZ = -1;
   private int ac = 0;
   private int counter = 0;
   private Queue<EntityRhodes.RhodesAction> actionqueue = new LinkedList<>();
   private int teamToRaid;
   private boolean raidedOmegaAlready = false;
   private boolean raidedSigmaAlready = false;
   private int walkstate = 0;
   private Entity lastRocketTarget = null;
   private int lastshot;
   private int shotstaken;
   private int lastrockettargetting = 0;
   boolean nuke = false;
   private Entity lastFlameTarget = null;
   private int lastflametargetting = 0;
   private Entity lastLaserTarget = null;
   private int lastlasertargetting = 0;

   public EntityRhodes(World w) {
      super(w);
      this.field_70158_ak = true;
      this.field_70121_D.func_72324_b(-5.0F * this.scale, -15.0F * this.scale, -5.0F * this.scale, 5.0F * this.scale, 15.0F * this.scale, 5.0F * this.scale);
      this.field_70145_X = true;
      this.field_70144_Y = 100.0F;
      this.field_70129_M = 0.0F;
      this.field_70138_W = 0.0F;
      this.actionqueue.add(new EntityRhodes.RhodesAction(0, 1));
      RivalRebelsSoundPlayer.playSound(this, 12, 1, 90.0F, 1.0F);
      this.itexfolder = texfolder;
      if (texfolder != -1) {
         this.itexloc = texloc;
      }

      if (forcecolor == -1) {
         this.colorType = (byte)RivalRebels.rhodesTeams[lastct];
         if (!w.field_72995_K) {
            lastct++;
            if (lastct == RivalRebels.rhodesTeams.length) {
               lastct = 0;
            }
         }
      } else {
         this.colorType = (byte)forcecolor;
      }

      Random random = new Random(RivalRebels.rhodesRandomSeed);

      for (int i = 0; i < this.colorType * 3; i++) {
         random.nextFloat();
      }

      this.nukecount = RivalRebels.rhodesNukes;
      this.nukecount = (int)(this.nukecount + this.nukecount * random.nextFloat() * RivalRebels.rhodesRandom);
      this.rocketcount = (int)(this.rocketcount + this.rocketcount * random.nextFloat() * RivalRebels.rhodesRandom);
      this.flamecount = (int)(this.flamecount + this.flamecount * random.nextFloat() * RivalRebels.rhodesRandom);
   }

   public EntityRhodes(World w, double x, double y, double z, float s) {
      this(w);
      this.scale = s;
      if (this.scale >= 2.0) {
         this.nukecount = (int)(this.nukecount * 0.25);
         this.rocketcount = (int)(this.rocketcount * 0.004);
      }

      this.health = this.health - 5000 + (int)(5000.0F * Math.min(this.scale, 4.0F));
      this.field_70121_D.func_72324_b(-5.0F * this.scale, -15.0F * this.scale, -5.0F * this.scale, 5.0F * this.scale, 15.0F * this.scale, 5.0F * this.scale);
      this.func_70107_b(x, y, z);
      if (!this.field_70170_p.field_72995_K) {
         PacketDispatcher.packetsys.sendToAll(new TextPacket("RivalRebels.WARNING " + this.getName() + " RivalRebels.tsar.armed"));
      }
   }

   public void func_70071_h_() {
      if (this.wakeY != -1 && this.field_70170_p.func_147439_a(this.wakeX, this.wakeY, this.wakeZ) != RivalRebels.rhodesactivator) {
         this.damageUntilWake -= 100;
      }

      if (this.field_70163_u <= 0.0) {
         this.func_70106_y();
      } else {
         this.field_70134_J = true;
         this.field_70143_R = 0.0F;
         if (this.health > 0) {
            this.field_70142_S = this.field_70165_t;
            this.field_70137_T = this.field_70163_u;
            this.field_70136_U = this.field_70161_v;
            float headY = 0.0F;
            float syaw = MathHelper.func_76126_a(this.bodyyaw * (float) (Math.PI / 180.0));
            float cyaw = MathHelper.func_76134_b(this.bodyyaw * (float) (Math.PI / 180.0));
            float leftlegheight = 7.26756F
               + MathHelper.func_76134_b((this.leftthighpitch + 11.99685F) * (float) (Math.PI / 180.0)) * 7.3316913F
               + MathHelper.func_76134_b((this.leftthighpitch + this.leftshinpitch - 12.215306F) * (float) (Math.PI / 180.0)) * 8.521366F;
            float rightlegheight = 7.26756F
               + MathHelper.func_76134_b((this.rightthighpitch + 11.99685F) * (float) (Math.PI / 180.0)) * 7.3316913F
               + MathHelper.func_76134_b((this.rightthighpitch + this.rightshinpitch - 12.215306F) * (float) (Math.PI / 180.0)) * 8.521366F;
            leftlegheight *= this.scale;
            rightlegheight *= this.scale;
            float bodyY = leftlegheight > rightlegheight ? leftlegheight : rightlegheight;
            if (!this.field_70170_p.field_72995_K) {
               this.doAITick(syaw, cyaw);
               this.breakBlocks(syaw, cyaw, leftlegheight, rightlegheight, bodyY);
               if (this.field_70173_aa % 5 == 0) {
                  PacketDispatcher.packetsys.sendToAll(new RhodesPacket(this));
               }
            }

            this.field_70165_t = this.field_70165_t + this.field_70159_w;
            this.field_70163_u = this.field_70163_u + this.field_70181_x;
            this.field_70161_v = this.field_70161_v + this.field_70179_y;
            if (this.field_70173_aa % 3 == 0) {
               this.doCollisions();
            }

            this.ticksSinceLastPacket++;
            this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            RivalRebels.proxy.setOverlay(this);
            if (this.rider != null) {
               this.rider
                  .func_70107_b(
                     (this.field_70165_t + syaw * 5.5 * this.scale - this.rider.field_70165_t) * 0.33F + this.rider.field_70165_t,
                     (
                              this.field_70163_u
                                 + bodyY
                                 - 10.0F * this.scale
                                 - (this.field_70170_p.field_72995_K ? 0.0F : this.rider.func_70047_e())
                                 - this.rider.field_70163_u
                           )
                           * 0.33F
                        + this.rider.field_70163_u,
                     (this.field_70161_v + cyaw * 5.5 * this.scale - this.rider.field_70161_v) * 0.33F + this.rider.field_70161_v
                  );
               this.rider.field_70122_E = true;
               if (this.field_70170_p.field_72995_K) {
                  RivalRebels.round.setInvisible(this.rider);
               }

               this.rider.func_70110_aj();
               this.rider.field_71075_bZ.field_75102_a = true;
               if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT && this.rider == Minecraft.func_71410_x().field_71439_g) {
                  PacketDispatcher.packetsys
                     .sendToServer(
                        new RhodesJumpPacket(
                           this,
                           RivalRebels.proxy.spacebar(),
                           RivalRebels.proxy.a(),
                           RivalRebels.proxy.w(),
                           RivalRebels.proxy.d(),
                           RivalRebels.proxy.c(),
                           RivalRebels.proxy.f(),
                           RivalRebels.proxy.s(),
                           RivalRebels.proxy.x(),
                           RivalRebels.proxy.z(),
                           RivalRebels.proxy.g()
                        )
                     );
               }
            }

            if (this.passenger1 != null) {
               float offset = 1.62F;
               if (this.field_70170_p.field_72995_K && Minecraft.func_71410_x().field_71439_g == this.passenger1) {
                  offset = 0.0F;
               }

               this.passenger1
                  .func_70107_b(
                     this.field_70165_t + cyaw * 6.5F * this.scale,
                     this.field_70163_u + bodyY - 6.38F * this.scale - offset,
                     this.field_70161_v - syaw * 6.5F * this.scale
                  );
               this.passenger1.field_70122_E = true;
               this.passenger1.func_70110_aj();
            }

            if (this.passenger2 != null) {
               float offset = 1.62F;
               if (this.field_70170_p.field_72995_K && Minecraft.func_71410_x().field_71439_g == this.passenger2) {
                  offset = 0.0F;
               }

               this.passenger2
                  .func_70107_b(
                     this.field_70165_t - cyaw * 6.5F * this.scale,
                     this.field_70163_u + bodyY - 6.38F * this.scale - offset,
                     this.field_70161_v + syaw * 6.5F * this.scale
                  );
               this.passenger2.field_70122_E = true;
               this.passenger2.func_70110_aj();
            }
         } else {
            if (!this.field_70170_p.field_72995_K) {
               if (this.health == 0) {
                  PacketDispatcher.packetsys
                     .sendToAll(
                        new TextPacket(
                           "RivalRebels.Status " + this.getName() + " RivalRebels.meltdown" + (this.rider == null ? "" : " " + this.rider.func_70005_c_())
                        )
                     );
               }

               if (this.field_70173_aa % 5 == 0) {
                  PacketDispatcher.packetsys.sendToAll(new RhodesPacket(this));
               }

               if (this.health < -100) {
                  this.func_70106_y();
               }

               if (this.health == 0) {
                  float syaw = MathHelper.func_76126_a(this.bodyyaw * (float) (Math.PI / 180.0));
                  float cyaw = MathHelper.func_76134_b(this.bodyyaw * (float) (Math.PI / 180.0));
                  this.field_70170_p
                     .func_72838_d(
                        new EntityRhodesHead(
                           this.field_70170_p, this.field_70165_t, this.field_70163_u + 13.0F * this.scale, this.field_70161_v, this.scale, this.colorType
                        )
                     );
                  this.field_70170_p
                     .func_72838_d(
                        new EntityRhodesTorso(
                           this.field_70170_p, this.field_70165_t, this.field_70163_u + 7.0F * this.scale, this.field_70161_v, this.scale, this.colorType
                        )
                     );
                  this.field_70170_p
                     .func_72838_d(
                        new EntityRhodesLeftUpperArm(
                           this.field_70170_p,
                           this.field_70165_t + cyaw * 6.4 * this.scale,
                           this.field_70163_u + 7.0F * this.scale,
                           this.field_70161_v + syaw * 6.4 * this.scale,
                           this.scale,
                           this.colorType
                        )
                     );
                  this.field_70170_p
                     .func_72838_d(
                        new EntityRhodesRightUpperArm(
                           this.field_70170_p,
                           this.field_70165_t - cyaw * 6.4 * this.scale,
                           this.field_70163_u + 7.0F * this.scale,
                           this.field_70161_v - syaw * 6.4 * this.scale,
                           this.scale,
                           this.colorType
                        )
                     );
                  this.field_70170_p
                     .func_72838_d(
                        new EntityRhodesLeftLowerArm(
                           this.field_70170_p,
                           this.field_70165_t + cyaw * 6.4 * this.scale,
                           this.field_70163_u + 3.0F * this.scale,
                           this.field_70161_v + syaw * 6.4 * this.scale,
                           this.scale,
                           this.colorType
                        )
                     );
                  this.field_70170_p
                     .func_72838_d(
                        new EntityRhodesRightLowerArm(
                           this.field_70170_p,
                           this.field_70165_t - cyaw * 6.4 * this.scale,
                           this.field_70163_u + 3.0F * this.scale,
                           this.field_70161_v - syaw * 6.4 * this.scale,
                           this.scale,
                           this.colorType
                        )
                     );
                  this.field_70170_p
                     .func_72838_d(
                        new EntityRhodesLeftUpperLeg(
                           this.field_70170_p,
                           this.field_70165_t + cyaw * 3.0F * this.scale,
                           this.field_70163_u - 3.0F * this.scale,
                           this.field_70161_v + syaw * 3.0F * this.scale,
                           this.scale,
                           this.colorType
                        )
                     );
                  this.field_70170_p
                     .func_72838_d(
                        new EntityRhodesRightUpperLeg(
                           this.field_70170_p,
                           this.field_70165_t - cyaw * 3.0F * this.scale,
                           this.field_70163_u - 3.0F * this.scale,
                           this.field_70161_v - syaw * 3.0F * this.scale,
                           this.scale,
                           this.colorType
                        )
                     );
                  this.field_70170_p
                     .func_72838_d(
                        new EntityRhodesLeftLowerLeg(
                           this.field_70170_p,
                           this.field_70165_t + cyaw * 3.0F * this.scale,
                           this.field_70163_u - 10.0F * this.scale,
                           this.field_70161_v + syaw * 3.0F * this.scale,
                           this.scale,
                           this.colorType
                        )
                     );
                  this.field_70170_p
                     .func_72838_d(
                        new EntityRhodesRightLowerLeg(
                           this.field_70170_p,
                           this.field_70165_t - cyaw * 3.0F * this.scale,
                           this.field_70163_u - 10.0F * this.scale,
                           this.field_70161_v - syaw * 3.0F * this.scale,
                           this.scale,
                           this.colorType
                        )
                     );
               }
            }

            this.health--;
         }

         if (this.rider != null) {
            if ((this.rider.func_70093_af() || this.rider.field_70128_L) && RivalRebels.rhodesExit) {
               this.freeze = false;
               if (!this.rider.field_71075_bZ.field_75098_d) {
                  this.rider.field_71075_bZ.field_75102_a = false;
               }

               this.rider = null;
            }

            if (this.health <= 0 && this.rider != null) {
               this.freeze = false;
               if (!this.rider.field_71075_bZ.field_75098_d) {
                  this.rider.field_71075_bZ.field_75102_a = false;
                  this.rider.func_70097_a(DamageSource.field_76380_i, 2000000.0F);
               }

               this.rider = null;
            }
         }

         if (this.passenger1 != null) {
            if ((this.passenger1.func_70093_af() || this.passenger1.field_70128_L) && RivalRebels.rhodesExit) {
               if (!this.passenger1.field_71075_bZ.field_75098_d) {
                  this.passenger1.field_71075_bZ.field_75102_a = false;
               }

               this.passenger1 = null;
            }

            if (this.health <= 0 && this.passenger1 != null) {
               if (!this.passenger1.field_71075_bZ.field_75098_d) {
                  this.passenger1.field_71075_bZ.field_75102_a = false;
                  this.passenger1.func_70097_a(DamageSource.field_76380_i, 2000000.0F);
               }

               this.passenger1 = null;
            }
         }

         if (this.passenger2 != null) {
            if ((this.passenger2.func_70093_af() || this.passenger2.field_70128_L) && RivalRebels.rhodesExit) {
               if (!this.passenger2.field_71075_bZ.field_75098_d) {
                  this.passenger2.field_71075_bZ.field_75102_a = false;
               }

               this.passenger2 = null;
            }

            if (this.health <= 0 && this.passenger2 != null) {
               if (!this.passenger2.field_71075_bZ.field_75098_d) {
                  this.passenger2.field_71075_bZ.field_75102_a = false;
                  this.passenger2.func_70097_a(DamageSource.field_76380_i, 2000000.0F);
               }

               this.passenger2 = null;
            }
         }

         this.prevflame = this.flame;
      }
   }

   private void breakBlocks(float syaw, float cyaw, float leftlegheight, float rightlegheight, float bodyY) {
      float leftlegstride = MathHelper.func_76126_a((this.leftthighpitch + 11.99685F) * (float) (Math.PI / 180.0)) * 7.3316913F
         + MathHelper.func_76126_a((this.leftthighpitch + this.leftshinpitch - 12.215306F) * (float) (Math.PI / 180.0)) * 8.521366F;
      float rightlegstride = MathHelper.func_76126_a((this.rightthighpitch + 11.99685F) * (float) (Math.PI / 180.0)) * 7.3316913F
         + MathHelper.func_76126_a((this.rightthighpitch + this.rightshinpitch - 12.215306F) * (float) (Math.PI / 180.0)) * 8.521366F;
      leftlegstride *= this.scale;
      rightlegstride *= this.scale;
      float lpx = (float)this.field_70165_t - syaw * leftlegstride + cyaw * 3.6846F * this.scale;
      float lpy = (float)this.field_70163_u - 15.0F * this.scale + bodyY - leftlegheight;
      float lpz = (float)this.field_70161_v - cyaw * leftlegstride - syaw * 3.6846F * this.scale;
      float rpx = (float)this.field_70165_t - syaw * rightlegstride - cyaw * 3.6846F * this.scale;
      float rpy = (float)this.field_70163_u - 15.0F * this.scale + bodyY - rightlegheight;
      float rpz = (float)this.field_70161_v - cyaw * rightlegstride + syaw * 3.6846F * this.scale;
      int ilpx = (int)lpx;
      int ilpy = (int)lpy;
      int ilpz = (int)lpz;
      int irpx = (int)rpx;
      int irpy = (int)rpy;
      int irpz = (int)rpz;
      if (this.ac > 1) {
         if (RivalRebels.rhodesBlockBreak > 0.0F) {
            int sx = (int)(this.field_70165_t - 5.0F * this.scale);
            int sy = (int)(this.field_70163_u - 15.0F * this.scale);
            int sz = (int)(this.field_70161_v - 5.0F * this.scale);
            int ex = (int)(this.field_70165_t + 5.0F * this.scale);
            int ey = (int)(this.field_70163_u + 15.0F * this.scale);
            int ez = (int)(this.field_70161_v + 5.0F * this.scale);

            for (int y = sy; y < ey; y++) {
               if ((y + this.field_70173_aa) % 8 == 0) {
                  for (int x = sx; x < ex; x++) {
                     for (int z = sz; z < ez; z++) {
                        this.field_70170_p.func_147449_b(x, y, z, Blocks.field_150350_a);
                     }
                  }
               }
            }
         } else {
            int irpyyoff = irpy + this.field_70173_aa % 6;
            int ilpyyoff = ilpy + this.field_70173_aa % 6;
            Block b = this.field_70170_p.func_147439_a(irpx, irpyyoff, irpz);
            if (b != Blocks.field_150355_j && b != Blocks.field_150358_i && b != Blocks.field_150350_a) {
               this.field_70170_p.func_147449_b(irpx - 2, irpyyoff, irpz - 2, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(irpx - 2, irpyyoff, irpz - 1, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(irpx - 2, irpyyoff, irpz + 0, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(irpx - 2, irpyyoff, irpz + 1, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(irpx - 2, irpyyoff, irpz + 2, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(irpx - 1, irpyyoff, irpz - 2, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(irpx - 1, irpyyoff, irpz - 1, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(irpx - 1, irpyyoff, irpz + 0, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(irpx - 1, irpyyoff, irpz + 1, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(irpx - 1, irpyyoff, irpz + 2, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(irpx - 0, irpyyoff, irpz - 2, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(irpx - 0, irpyyoff, irpz - 1, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(irpx - 0, irpyyoff, irpz + 0, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(irpx - 0, irpyyoff, irpz + 1, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(irpx - 0, irpyyoff, irpz + 2, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(irpx + 1, irpyyoff, irpz - 2, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(irpx + 1, irpyyoff, irpz - 1, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(irpx + 1, irpyyoff, irpz + 0, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(irpx + 1, irpyyoff, irpz + 1, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(irpx + 1, irpyyoff, irpz + 2, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(irpx + 2, irpyyoff, irpz - 2, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(irpx + 2, irpyyoff, irpz - 1, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(irpx + 2, irpyyoff, irpz + 0, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(irpx + 2, irpyyoff, irpz + 1, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(irpx + 2, irpyyoff, irpz + 2, Blocks.field_150350_a);
            }

            b = this.field_70170_p.func_147439_a(ilpx, ilpyyoff, ilpz);
            if (b != Blocks.field_150355_j && b != Blocks.field_150358_i && b != Blocks.field_150350_a) {
               this.field_70170_p.func_147449_b(ilpx - 2, ilpyyoff, ilpz - 2, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(ilpx - 2, ilpyyoff, ilpz - 1, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(ilpx - 2, ilpyyoff, ilpz + 0, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(ilpx - 2, ilpyyoff, ilpz + 1, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(ilpx - 2, ilpyyoff, ilpz + 2, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(ilpx - 1, ilpyyoff, ilpz - 2, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(ilpx - 1, ilpyyoff, ilpz - 1, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(ilpx - 1, ilpyyoff, ilpz + 0, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(ilpx - 1, ilpyyoff, ilpz + 1, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(ilpx - 1, ilpyyoff, ilpz + 2, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(ilpx - 0, ilpyyoff, ilpz - 2, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(ilpx - 0, ilpyyoff, ilpz - 1, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(ilpx - 0, ilpyyoff, ilpz + 0, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(ilpx - 0, ilpyyoff, ilpz + 1, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(ilpx - 0, ilpyyoff, ilpz + 2, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(ilpx + 1, ilpyyoff, ilpz - 2, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(ilpx + 1, ilpyyoff, ilpz - 1, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(ilpx + 1, ilpyyoff, ilpz + 0, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(ilpx + 1, ilpyyoff, ilpz + 1, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(ilpx + 1, ilpyyoff, ilpz + 2, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(ilpx + 2, ilpyyoff, ilpz - 2, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(ilpx + 2, ilpyyoff, ilpz - 1, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(ilpx + 2, ilpyyoff, ilpz + 0, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(ilpx + 2, ilpyyoff, ilpz + 1, Blocks.field_150350_a);
               this.field_70170_p.func_147449_b(ilpx + 2, ilpyyoff, ilpz + 2, Blocks.field_150350_a);
            }

            int px = (int)this.field_70165_t;
            int py = (int)(this.field_70163_u - 5.0F * this.scale + this.field_70173_aa % 20 * this.scale);
            int pz = (int)this.field_70161_v;

            for (int x = -4; x < 5; x++) {
               for (int z = -4; z < 5; z++) {
                  b = this.field_70170_p.func_147439_a(px + x, py, pz + z);
                  if (b != Blocks.field_150350_a && b != Blocks.field_150355_j && b != Blocks.field_150358_i) {
                     this.field_70170_p.func_147449_b(px + x, py, pz + z, Blocks.field_150350_a);
                     if (this.field_70146_Z.nextInt(333) == 0) {
                        new Explosion(this.field_70170_p, px, py, pz, 3, false, true, RivalRebelsDamageSource.rocket);
                        RivalRebelsSoundPlayer.playSound(this, 23, 3, 4.5F, (float)(0.8F + Math.random() * 0.3F));
                     }
                  }
               }
            }
         }
      }

      boolean bl = blocklist.contains(this.field_70170_p.func_147439_a(ilpx, ilpy - 1, ilpz));
      boolean ol = blocklist.contains(this.field_70170_p.func_147439_a(ilpx, ilpy, ilpz));
      boolean br = blocklist.contains(this.field_70170_p.func_147439_a(irpx, irpy - 1, irpz));
      boolean or = blocklist.contains(this.field_70170_p.func_147439_a(irpx, irpy, irpz));
      if (!bl && !br) {
         if (this.flying == 0) {
            this.field_70181_x -= 0.03F;
            if (!this.field_70151_c && this.field_70146_Z.nextInt(32) == 0) {
               RivalRebelsSoundPlayer.playSound(this, 23, 1, 4.5F, (float)(0.8F + Math.random() * 0.2F));
               this.field_70151_c = true;
            }
         }
      } else if (!ol && !or) {
         if (this.field_70181_x < 0.0) {
            this.field_70181_x = 0.0;
            this.field_70151_c = false;
            this.field_70163_u = (int)this.field_70163_u;
         }
      } else if (this.field_70181_x < 0.125) {
         this.field_70181_x = 0.125;
         if (!this.field_70151_c && this.field_70146_Z.nextInt(32) == 0) {
            RivalRebelsSoundPlayer.playSound(this, 23, 1, 4.5F, (float)(0.8F + Math.random() * 0.2F));
            this.field_70151_c = true;
         }
      }

      if (this.flying != 0) {
         this.flying--;
         if (this.b2spirit) {
            this.field_70181_x = 0.03;
         } else {
            this.field_70181_x += 0.03F;
         }

         if (this.field_70146_Z.nextInt(32) == 0) {
            RivalRebelsSoundPlayer.playSound(this, 23, 1, 4.5F, (float)(0.8F + Math.random() * 0.2F));
         }

         this.field_70151_c = true;
      }
   }

   private void doCollisions() {
      for (Entity e : this.field_70170_p.field_72996_f) {
         if (e != this.rider && e != this.passenger1 && e != this.passenger2) {
            double bbd = (e.field_70130_N + 10.0F * this.scale) * 0.5;
            double bbh = (e.field_70131_O + 30.0F * this.scale) * 0.5;
            if (e instanceof EntityRhodes) {
               bbd = 10.0F * (((EntityRhodes)e).scale + this.scale) * 0.5;
               bbh = 30.0F * (((EntityRhodes)e).scale + this.scale) * 0.5;
            }

            double dist = (e.field_70165_t - this.field_70165_t) * (e.field_70165_t - this.field_70165_t)
               + (e.field_70161_v - this.field_70161_v) * (e.field_70161_v - this.field_70161_v);
            if ((this.ac == 0 || this.ac == 1 || this.ac == 11 || !RivalRebels.rhodesAI)
               && e instanceof EntityPlayer
               && dist < bbd * bbd * 0.25
               && e.field_70163_u < this.field_70163_u + bbh + 1.0
               && e.field_70163_u > this.field_70163_u - bbh + 1.0) {
               if (this.rider == null) {
                  this.rider = (EntityPlayer)e;
                  RivalRebelsSoundPlayer.playSound(this, 12, 1, 90.0F, 1.0F);
               } else if (this.passenger1 == null) {
                  this.passenger1 = (EntityPlayer)e;
                  RivalRebelsSoundPlayer.playSound(this, 12, 1, 90.0F, 1.0F);
               } else if (this.passenger2 == null) {
                  this.passenger2 = (EntityPlayer)e;
                  RivalRebelsSoundPlayer.playSound(this, 12, 1, 90.0F, 1.0F);
               }
            } else if (dist < bbd * bbd && e.field_70163_u > this.field_70163_u - bbh && e.field_70163_u < this.field_70163_u + bbh) {
               if (e != this && !(e instanceof EntityFallingBlock) && !(e instanceof EntityDebris)) {
                  if (e.field_70163_u > this.field_70163_u + 15.0) {
                     e.field_70181_x *= -0.5;
                     e.field_70163_u = this.field_70163_u + bbh;
                  } else if (e.field_70163_u < this.field_70163_u - 15.0) {
                     e.field_70181_x *= -0.5;
                     e.field_70163_u = this.field_70163_u - bbh;
                  } else {
                     e.field_70159_w *= -1.0;
                     e.field_70179_y *= -1.0;
                     double d3 = bbd / Math.sqrt(dist);
                     e.field_70165_t = this.field_70165_t + (e.field_70165_t - this.field_70165_t) * d3;
                     e.field_70161_v = this.field_70161_v + (e.field_70161_v - this.field_70161_v) * d3;
                  }

                  e.func_70107_b(e.field_70165_t, e.field_70163_u, e.field_70161_v);
               }

               if (e instanceof EntityRocket) {
                  ((EntityRocket)e).field_70173_aa = RivalRebels.rpgDecay;
                  this.func_70097_a(DamageSource.field_76377_j, 20.0F);
               } else if (e instanceof EntitySeekB83) {
                  ((EntitySeekB83)e).field_70173_aa = 800;
                  this.func_70097_a(DamageSource.field_76377_j, 24.0F);
               } else if (e instanceof EntityHackB83) {
                  ((EntityHackB83)e).field_70195_i = -100;
                  this.func_70097_a(DamageSource.field_76377_j, 40.0F);
               } else if (e instanceof EntityB83) {
                  ((EntityB83)e).field_70195_i = -100;
                  this.func_70097_a(DamageSource.field_76377_j, 40.0F);
               } else if (e instanceof EntityBomb) {
                  ((EntityBomb)e).explode(true);

                  for (int i = 0; i < RivalRebels.bombDamageToRhodes; i++) {
                     this.func_70097_a(DamageSource.field_76377_j, 50.0F);
                  }
               } else if (e instanceof EntityNuke) {
                  ((EntityNuke)e).field_70195_i = -100;
                  this.func_70097_a(DamageSource.field_76377_j, 80.0F);
               } else if (e instanceof EntityTsar) {
                  ((EntityTsar)e).field_70195_i = -100;
                  this.func_70097_a(DamageSource.field_76377_j, 100.0F);
               } else if (e instanceof EntityTheoreticalTsar) {
                  ((EntityTheoreticalTsar)e).field_70195_i = -100;
                  this.func_70097_a(DamageSource.field_76377_j, 100.0F);
               } else if (e instanceof EntityAntimatterBomb) {
                  ((EntityAntimatterBomb)e).field_70195_i = -100;
                  this.func_70097_a(DamageSource.field_76377_j, 100.0F);
               } else if (e instanceof EntityTachyonBomb) {
                  ((EntityTachyonBomb)e).field_70195_i = -100;
                  this.func_70097_a(DamageSource.field_76377_j, 100.0F);
               } else if (e instanceof EntityHotPotato) {
                  ((EntityHotPotato)e).field_70173_aa = -100;
                  this.func_70097_a(DamageSource.field_76377_j, 100.0F);
               } else if (e instanceof EntityB83NoShroom) {
                  ((EntityB83NoShroom)e).field_70195_i = -100;
                  this.func_70097_a(DamageSource.field_76377_j, 40.0F);
               } else if (e instanceof EntityPlasmoid) {
                  ((EntityPlasmoid)e).explode();
                  this.func_70097_a(DamageSource.field_76377_j, 8.0F);
               } else if (e instanceof EntityFlameBall) {
                  ((EntityFlameBall)e).func_70106_y();
                  this.func_70097_a(DamageSource.field_76377_j, 3.0F);
               } else if (e instanceof EntityFlameBall1) {
                  ((EntityFlameBall1)e).func_70106_y();
                  this.func_70097_a(DamageSource.field_76377_j, 4.0F);
               } else if (e instanceof EntityFlameBall2) {
                  ((EntityFlameBall2)e).func_70106_y();
                  this.func_70097_a(DamageSource.field_76377_j, 2.0F);
               } else if (e instanceof EntityLaserBurst) {
                  ((EntityLaserBurst)e).func_70106_y();
                  this.func_70097_a(DamageSource.field_76377_j, 4.0F);
               }
            }
         }
      }
   }

   private void doAITick(float syaw, float cyaw) {
      if (this.health * 2 < RivalRebels.rhodesHealth) {
         this.endangered = true;
      }

      if (!this.b2spirit) {
         this.field_70159_w = 0.0;
         this.field_70179_y = 0.0;
      }

      if (this.rider != null) {
         if (this.b2spirit && !this.freeze && this.b2energy == 0 && this.scale < 1.5F && this.scale > 0.5F) {
            this.freeze = true;
            this.nukecount--;
            this.health -= 1000;
            this.field_70170_p.func_72838_d(new EntityB2Spirit(this));
         }

         if (!RivalRebels.rhodesHold) {
            if (this.energy < 800) {
               this.energy += 3;
            }

            if (!RivalRebels.infiniteAmmo) {
               this.rocket = this.rocket & this.rocketcount > 0;
               this.flame = this.flame & this.flamecount > 0;
            }

            if (!RivalRebels.infiniteNukes) {
               this.bomb = this.bomb & this.nukecount > 0;
            }

            this.forcefield = this.forcefield & this.energy > 11;
            this.laser = this.laser & this.energy > 9;
            this.jet = this.jet & this.energy + this.b2energy > 13;
            this.b2spirit = this.b2spirit & this.b2energy > 0;
            if (this.forcefield) {
               this.energy -= 11;
               if (this.field_70173_aa % 8 == 0) {
                  RivalRebelsSoundPlayer.playSound(this, 5, 0, 10.0F, 1.0F);
               }
            }

            if (this.laser) {
               this.energy -= 9;
            }

            if (!this.jet && !this.b2spirit) {
               this.flying = 0;
            } else {
               if (this.b2energy > 0) {
                  this.b2energy -= 13;
                  if (this.b2energy <= 0) {
                     this.b2energy = 0;
                     this.field_70170_p.func_72876_a((Entity)null, this.field_70165_t, this.field_70163_u, this.field_70161_v, 6.0F, true);
                     this.field_70170_p.func_72838_d(new EntityB2Frag(this.field_70170_p, this, 0));
                     this.field_70170_p.func_72838_d(new EntityB2Frag(this.field_70170_p, this, 1));
                  }
               } else {
                  this.energy -= 13;
               }

               this.flying = 3;
            }

            this.laserOn = 0;
            if (!this.stop) {
               float goal = ((this.rider.field_70759_as + this.bodyyaw) % 360.0F + 360.0F + 360.0F) % 360.0F - 180.0F;
               this.bodyyaw = this.bodyyaw + Math.max(Math.min(goal, 2.0F), -2.0F);
               if (this.flying > 0) {
                  if (this.b2spirit) {
                     this.field_70159_w += syaw * 0.1F;
                     this.field_70179_y += cyaw * 0.1F;
                     double speed = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
                     if (speed > 0.7) {
                        this.field_70159_w /= speed;
                        this.field_70179_y /= speed;
                        this.field_70159_w *= 0.7F;
                        this.field_70179_y *= 0.7F;
                     }
                  } else {
                     this.field_70159_w = syaw * 0.5F;
                     this.field_70179_y = cyaw * 0.5F;
                  }

                  this.rightthighpitch = this.approach(this.rightthighpitch, -30.0F);
                  this.leftthighpitch = this.approach(this.leftthighpitch, -30.0F);
                  this.rightshinpitch = this.approach(this.rightshinpitch, 60.0F);
                  this.leftshinpitch = this.approach(this.leftshinpitch, 60.0F);
               } else {
                  this.doWalkingAnimation(syaw, cyaw);
               }
            } else {
               this.flying = 0;
               this.rightthighpitch = this.approach(this.rightthighpitch, 0.0F);
               this.leftthighpitch = this.approach(this.leftthighpitch, 0.0F);
               this.rightshinpitch = this.approach(this.rightshinpitch, 0.0F);
               this.leftshinpitch = this.approach(this.leftshinpitch, 0.0F);
            }

            double startx = this.rider.field_70165_t;
            double starty = this.rider.field_70163_u + this.rider.func_70047_e();
            double startz = this.rider.field_70161_v;
            double range = 100.0;
            double endx = startx
               + range
                  * (
                     -MathHelper.func_76126_a(this.rider.field_70177_z / 180.0F * (float) Math.PI)
                        * MathHelper.func_76134_b(this.rider.field_70125_A / 180.0F * (float) Math.PI)
                  );
            double endy = starty + range * -MathHelper.func_76126_a(this.rider.field_70125_A / 180.0F * (float) Math.PI);
            double endz = startz
               + range
                  * (
                     MathHelper.func_76134_b(this.rider.field_70177_z / 180.0F * (float) Math.PI)
                        * MathHelper.func_76134_b(this.rider.field_70125_A / 180.0F * (float) Math.PI)
                  );
            Vec3 hit = this.rayTraceBlocks((float)startx, (float)starty, (float)startz, (float)endx, (float)endy, (float)endz);
            if (hit != null) {
               endx = hit.field_72450_a;
               endy = hit.field_72448_b;
               endz = hit.field_72449_c;
            }

            if (this.laser) {
               this.laserOn = (byte)(this.field_70170_p.field_73012_v.nextInt(2) + 1);
               RivalRebelsSoundPlayer.playSound(this, 22, 1, 30.0F, 0.0F);
               float x = (float)(this.field_70165_t - endx);
               float y = (float)(this.field_70163_u + 13.0F * this.scale - endy);
               float z = (float)(this.field_70161_v - endz);
               float pitch = (720.0F - atan2((float)Math.sqrt(x * x + z * z) * (syaw * x + cyaw * z > 0.0F ? -1.0F : 1.0F), y)) % 360.0F - 270.0F;
               this.headpitch = this.headpitch + Math.max(-20.0F, Math.min(20.0F, pitch - this.headpitch));
               if (Math.abs(this.headpitch - pitch) < 10.0F && this.field_70173_aa % 3 == 0) {
                  range = 70.0F * this.scale;
                  Vec3 start = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u + 13.0F * this.scale, this.field_70161_v);
                  Vec3 end = Vec3.func_72443_a(0.0, 0.0, range);
                  end.func_72440_a(-this.headpitch / 180.0F * (float) Math.PI);
                  end.func_72442_b(this.bodyyaw / 180.0F * (float) Math.PI);
                  end = end.func_72441_c(this.field_70165_t, this.field_70163_u + 13.0F * this.scale, this.field_70161_v);

                  for (Entity e : this.field_70170_p
                     .func_72839_b(
                        this,
                        AxisAlignedBB.func_72330_a(
                           Math.min(start.field_72450_a, end.field_72450_a) - 5.0,
                           Math.min(start.field_72448_b, end.field_72448_b) - 5.0,
                           Math.min(start.field_72449_c, end.field_72449_c) - 5.0,
                           Math.max(start.field_72450_a, end.field_72450_a) + 5.0,
                           Math.max(start.field_72448_b, end.field_72448_b) + 5.0,
                           Math.max(start.field_72449_c, end.field_72449_c) + 5.0
                        )
                     )) {
                     if (!e.field_70128_L
                        && (!(e instanceof EntityLivingBase) || ((EntityLivingBase)e).func_110143_aJ() > 0.0F)
                        && !(e instanceof EntityThrowable)
                        && !(e instanceof EntityInanimate)
                        && !(e instanceof EntityItem)
                        && !(e instanceof EntityBoat)
                        && !(e instanceof EntityMinecart)
                        && e != this.rider) {
                        Vec3 entity = Vec3.func_72443_a(e.field_70165_t, e.field_70163_u, e.field_70161_v);
                        double bbx = 1.0;
                        if (e instanceof EntityRhodes) {
                           bbx = 20.0F * ((EntityRhodes)e).scale;
                        }

                        if (entity.func_72444_a(start).func_72431_c(entity.func_72444_a(end)).func_72445_d(0.0, 0.0, 0.0) < 10000.0 * bbx) {
                           e.func_70097_a(RivalRebelsDamageSource.laserburst, 24.0F);
                           if (e instanceof EntityPlayer) {
                              EntityPlayer player = (EntityPlayer)e;
                              ItemStack[] armorSlots = player.field_71071_by.field_70460_b;
                              int i = this.field_70170_p.field_73012_v.nextInt(4);
                              if (armorSlots[i] != null) {
                                 armorSlots[i].func_77972_a(24, player);
                              }

                              if (player.func_110143_aJ() < 3.0F && player.func_70089_S()) {
                                 player.func_70097_a(RivalRebelsDamageSource.laserburst, 2000000.0F);
                                 player.field_70725_aQ = 0;
                                 this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, e, 0, 0));
                                 this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, e, 1, 0));
                                 this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, e, 2, 0));
                                 this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, e, 2, 0));
                                 this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, e, 3, 0));
                                 this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, e, 3, 0));
                              }
                           } else if (e.field_70128_L || e instanceof EntityLivingBase && ((EntityLivingBase)e).func_110143_aJ() < 3.0F) {
                              int legs = -1;
                              int arms = -1;
                              int mobs = -1;
                              RivalRebelsSoundPlayer.playSound(this, 2, 1, 4.0F);
                              byte var84;
                              if (e instanceof EntityPigZombie) {
                                 legs = 2;
                                 arms = 2;
                                 var84 = 2;
                              } else if (e instanceof EntityZombie) {
                                 legs = 2;
                                 arms = 2;
                                 var84 = 1;
                              } else if (e instanceof EntitySkeleton) {
                                 legs = 2;
                                 arms = 2;
                                 var84 = 3;
                              } else if (e instanceof EntityEnderman) {
                                 legs = 2;
                                 arms = 2;
                                 var84 = 4;
                              } else if (e instanceof EntityCreeper) {
                                 legs = 4;
                                 arms = 0;
                                 var84 = 5;
                              } else if (e instanceof EntityMagmaCube) {
                                 legs = 0;
                                 arms = 0;
                                 var84 = 7;
                              } else if (e instanceof EntitySlime) {
                                 legs = 0;
                                 arms = 0;
                                 var84 = 6;
                              } else if (e instanceof EntityCaveSpider) {
                                 legs = 8;
                                 arms = 0;
                                 var84 = 9;
                              } else if (e instanceof EntitySpider) {
                                 legs = 8;
                                 arms = 0;
                                 var84 = 8;
                              } else if (e instanceof EntityGhast) {
                                 legs = 9;
                                 arms = 0;
                                 var84 = 10;
                              } else {
                                 if (e instanceof EntityB2Spirit || e instanceof EntityRhodes || e instanceof EntityRhodesPiece) {
                                    return;
                                 }

                                 legs = (int)(e.field_70121_D.func_72320_b() * 2.0);
                                 arms = (int)(e.field_70121_D.func_72320_b() * 2.0);
                                 var84 = 11;
                              }

                              this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, e, 0, var84));
                              this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, e, 1, var84));

                              for (int i = 0; i < arms; i++) {
                                 this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, e, 2, var84));
                              }

                              for (int i = 0; i < legs; i++) {
                                 this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, e, 3, var84));
                              }

                              e.func_70106_y();
                           }
                        }
                     }
                  }
               }
            } else {
               this.headpitch = this.rider.field_70125_A;
            }

            if (this.flame || this.prevflame) {
               float px = (float)this.field_70165_t - cyaw * 6.4F * this.scale;
               float py = (float)this.field_70163_u + 6.26759F * this.scale;
               float pz = (float)this.field_70161_v + syaw * 6.4F * this.scale;
               float x = px - (float)endx;
               float y = py - (float)endy;
               float z = pz - (float)endz;
               float yaw = (atan2(x, z) - this.bodyyaw + 810.0F) % 360.0F - 270.0F;
               float pitch = -atan2((float)Math.sqrt(x * x + z * z), y);
               this.rightarmyaw = this.rightarmyaw + Math.max(-3.0F, Math.min(3.0F, yaw - this.rightarmyaw));
               this.rightarmpitch = this.rightarmpitch + Math.max(-3.0F, Math.min(3.0F, pitch - this.rightarmpitch));
               if (this.plasma) {
                  this.plasmacharge++;
                  if (Math.abs(this.rightarmyaw - yaw) < 3.0F && Math.abs(this.rightarmpitch - pitch) < 3.0F && !this.flame && this.prevflame) {
                     float f = this.plasmacharge / 20.0F;
                     f = (f * f + f * 2.0F) * 0.3333F;
                     if (f > 1.0F) {
                        f = 1.0F;
                     }

                     f += 0.7F;
                     RivalRebelsSoundPlayer.playSound(this, 16, 2, 1.0F, 0.5F);
                     float cp = -f / (float)Math.sqrt(x * x + y * y + z * z) * this.scale;
                     x *= cp;
                     y *= cp;
                     z *= cp;
                     this.field_70170_p.func_72838_d(new EntityPlasmoid(this.field_70170_p, px, py, pz, x, y, z, 8.0F));
                     this.flamecount = this.flamecount - this.plasmacharge;
                     this.plasmacharge = 0;
                  }

                  if (this.flame && !this.prevflame) {
                     RivalRebelsSoundPlayer.playSound(this, 16, 1, 0.0F);
                  }
               } else if (Math.abs(this.rightarmyaw - yaw) < 3.0F && Math.abs(this.rightarmpitch - pitch) < 3.0F) {
                  this.flamecount--;
                  RivalRebelsSoundPlayer.playSound(this, 8, 1, 1.0F);
                  float cp = -1.0F / (float)Math.sqrt(x * x + y * y + z * z);
                  x *= cp;
                  y *= cp;
                  z *= cp;
                  this.field_70170_p.func_72838_d(new EntityFlameBall(this.field_70170_p, px, py, pz, x, y, z, (8.0 + Math.random() * 8.0) * this.scale, 0.4F));
                  this.field_70170_p.func_72838_d(new EntityFlameBall(this.field_70170_p, px, py, pz, x, y, z, (8.0 + Math.random() * 8.0) * this.scale, 0.4F));
               }
            }

            this.tickssincenuke++;
            if (this.rocket || this.bomb) {
               float px = (float)this.field_70165_t + cyaw * 6.4F * this.scale;
               float py = (float)this.field_70163_u + 6.26759F * this.scale;
               float pz = (float)this.field_70161_v - syaw * 6.4F * this.scale;
               float x = px - (float)endx;
               float y = py - (float)endy;
               float z = pz - (float)endz;
               float yaw = (atan2(x, z) - this.bodyyaw + 630.0F) % 360.0F - 90.0F;
               float pitch = -atan2((float)Math.sqrt(x * x + z * z), y);
               this.leftarmyaw = this.leftarmyaw + Math.max(-3.0F, Math.min(3.0F, yaw - this.leftarmyaw));
               this.leftarmpitch = this.leftarmpitch + Math.max(-3.0F, Math.min(3.0F, pitch - this.leftarmpitch));
               if (Math.abs(this.leftarmyaw - yaw) < 3.0F && Math.abs(this.leftarmpitch - pitch) < 3.0F) {
                  if (this.bomb && !this.rocket && this.tickssincenuke >= 10) {
                     this.tickssincenuke = 0;
                     this.nukecount--;
                     RivalRebelsSoundPlayer.playSound(this, 23, 10, 1.0F);
                     float cp = -0.5F / (float)Math.sqrt(x * x + y * y + z * z);
                     if (this.scale >= 3.0) {
                        this.field_70170_p.func_72838_d(new EntityHotPotato(this.field_70170_p, px, py, pz, x * cp * 5.0F, y * cp * 5.0F, z * cp * 5.0F));
                     } else if (this.scale >= 2.0) {
                        this.field_70170_p.func_72838_d(new EntityTsar(this.field_70170_p, px, py, pz, x * cp * 5.0F, y * cp * 5.0F, z * cp * 5.0F));
                     } else {
                        this.field_70170_p.func_72838_d(new EntityB83NoShroom(this.field_70170_p, px, py, pz, x * cp, y * cp, z * cp));
                     }
                  }

                  if (this.rocket && this.field_70173_aa - this.lastshot > (this.scale >= 2.0 ? 30 : (this.shotstaken == 21 ? 80 : 5))) {
                     this.rocketcount--;
                     this.lastshot = this.field_70173_aa;
                     if (this.shotstaken == 21) {
                        this.shotstaken = 0;
                     }

                     this.shotstaken++;
                     RivalRebelsSoundPlayer.playSound(this, 23, 10, 1.0F);
                     float cp = -0.5F / (float)Math.sqrt(x * x + y * y + z * z);
                     if (this.scale >= 2.0) {
                        this.field_70170_p.func_72838_d(new EntityB83NoShroom(this.field_70170_p, px, py, pz, x * cp, y * cp, z * cp));
                     } else {
                        this.field_70170_p.func_72838_d(new EntitySeekB83(this.field_70170_p, px, py, pz, x * cp, y * cp, z * cp));
                     }
                  }
               }
            }

            this.ac = 11;
         }
      } else if (RivalRebels.rhodesHold || this.guard) {
         this.rightthighpitch = this.approach(this.rightthighpitch, 0.0F);
         this.leftthighpitch = this.approach(this.leftthighpitch, 0.0F);
         this.rightshinpitch = this.approach(this.rightshinpitch, 0.0F);
         this.leftshinpitch = this.approach(this.leftshinpitch, 0.0F);
         if (RivalRebels.rhodesAI) {
            this.shootRocketsAtBestTarget(-syaw, cyaw);
            this.shootFlameAtBestTarget(-syaw, cyaw);
            this.shootLaserAtBestTarget(-syaw, cyaw);
         }
      } else if (RivalRebels.rhodesAI || this.ac == 0 || this.ac == 1 || this.ac == 11) {
         if (this.counter == 0) {
            if (!this.actionqueue.isEmpty()) {
               EntityRhodes.RhodesAction nextaction = this.actionqueue.remove();
               this.ac = nextaction.action;
               this.counter = nextaction.duration;
            } else {
               this.ac = 2;
            }
         }

         float movescale = this.scale;
         if (RivalRebels.rhodesScaleSpeed) {
            movescale *= RivalRebels.rhodesSpeedScale;
         } else {
            movescale = RivalRebels.rhodesSpeedScale;
         }

         switch (this.ac) {
            case 0:
               if (this.damageUntilWake < 100) {
                  RivalRebelsSoundPlayer.playSound(this, 13, 0, 900.0F, 1.0F);
                  this.actionqueue.add(new EntityRhodes.RhodesAction(1, 1));
               } else {
                  this.counter++;
               }

               this.rightthighpitch = this.approach(this.rightthighpitch, 0.0F);
               this.leftthighpitch = this.approach(this.leftthighpitch, 0.0F);
               this.rightshinpitch = this.approach(this.rightshinpitch, 0.0F);
               this.leftshinpitch = this.approach(this.leftshinpitch, 0.0F);
               this.rightarmpitch = this.approach(this.rightarmpitch, 0.0F);
               this.leftarmpitch = this.approach(this.leftarmpitch, 0.0F);
               this.rightarmyaw = this.approach(this.rightarmyaw, 0.0F);
               this.leftarmyaw = this.approach(this.leftarmyaw, 0.0F);
               this.headpitch = this.approach(this.headpitch, 0.0F);
               break;
            case 1:
               if (this.damageUntilWake <= 0) {
                  RivalRebelsSoundPlayer.playSound(this, 12, 1, 90.0F, 1.0F);
                  this.actionqueue.add(new EntityRhodes.RhodesAction(2, 1));
               } else {
                  this.counter++;
               }

               this.rightthighpitch = this.approach(this.rightthighpitch, 0.0F);
               this.leftthighpitch = this.approach(this.leftthighpitch, 0.0F);
               this.rightshinpitch = this.approach(this.rightshinpitch, 0.0F);
               this.leftshinpitch = this.approach(this.leftshinpitch, 0.0F);
               this.rightarmpitch = this.approach(this.rightarmpitch, 0.0F);
               this.leftarmpitch = this.approach(this.leftarmpitch, 0.0F);
               this.rightarmyaw = this.approach(this.rightarmyaw, 0.0F);
               this.leftarmyaw = this.approach(this.leftarmyaw, 0.0F);
               this.headpitch = this.approach(this.headpitch, 0.0F);
               break;
            case 2:
               if (this.raidedOmegaAlready == this.raidedSigmaAlready) {
                  this.raidedSigmaAlready = this.raidedOmegaAlready = false;
               }

               if (this.endangered && RivalRebels.round.isStarted()) {
                  if (this.teamToRaid == 0) {
                     if (this.raidedOmegaAlready && RivalRebels.round.sigmaHealth > 0) {
                        this.teamToRaid = 2;
                     } else if (this.raidedSigmaAlready && RivalRebels.round.omegaHealth > 0) {
                        this.teamToRaid = 1;
                     } else if (RivalRebels.round.omegaHealth > 0 && RivalRebels.round.sigmaHealth > 0) {
                        RivalRebelsPlayer[] rrps = RivalRebels.round.rrplayerlist.getArray();
                        int o = 0;
                        int s = 0;

                        for (int i = 0; i < rrps.length; i++) {
                           if (rrps[i] != null && rrps[i].rrteam == RivalRebelsTeam.OMEGA) {
                              o++;
                           } else if (rrps[i] != null && rrps[i].rrteam == RivalRebelsTeam.SIGMA) {
                              s++;
                           }
                        }

                        if (o > s) {
                           this.teamToRaid = 1;
                           this.raidedOmegaAlready = true;
                        }

                        if (o < s) {
                           this.teamToRaid = 2;
                           this.raidedSigmaAlready = true;
                        }

                        if (o == s) {
                           this.teamToRaid = this.field_70146_Z.nextBoolean() ? 2 : 1;
                           if (this.teamToRaid == 1) {
                              this.raidedOmegaAlready = true;
                           } else {
                              this.raidedSigmaAlready = true;
                           }
                        }
                     }
                  }

                  if (this.teamToRaid != 0) {
                     float dx = (float)((this.teamToRaid == 1 ? RivalRebels.round.oObjx : RivalRebels.round.sObjx) - this.field_70165_t);
                     float dz = (float)((this.teamToRaid == 1 ? RivalRebels.round.oObjz : RivalRebels.round.sObjz) - this.field_70161_v);
                     float angle = (atan2(dx, dz) - this.bodyyaw) % 360.0F;
                     if (angle > 1.0F) {
                        this.actionqueue.add(new EntityRhodes.RhodesAction(5, (int)Math.abs(angle)));
                     } else if (angle < -1.0F) {
                        this.actionqueue.add(new EntityRhodes.RhodesAction(7, (int)Math.abs(angle)));
                     } else {
                        float d = Math.abs(dx) + Math.abs(dz);
                        if (d < 5.0F) {
                           RivalRebelsSoundPlayer.playSound(this, 13, 0, 900.0F, 1.0F);
                           this.actionqueue.add(new EntityRhodes.RhodesAction(10, 1));
                        } else if (d > 50.0F && this.field_70146_Z.nextBoolean()) {
                           this.actionqueue.add(new EntityRhodes.RhodesAction(9, 100));
                           this.flying = 50;
                        } else {
                           this.actionqueue.add(new EntityRhodes.RhodesAction(3, 20));
                        }
                     }

                     this.actionqueue.add(new EntityRhodes.RhodesAction(2, 1));
                  }
               } else {
                  Entity t = this.findTarget();
                  if (t != null) {
                     float dx = (float)(t.field_70165_t - this.field_70165_t);
                     float dz = (float)(t.field_70161_v - this.field_70161_v);
                     float angle = (atan2(dx, dz) - this.bodyyaw) % 360.0F;
                     if (angle > 1.0F && this.field_70146_Z.nextBoolean()) {
                        this.actionqueue.add(new EntityRhodes.RhodesAction(5, (int)Math.abs(angle)));
                     } else if (angle < -1.0F && this.field_70146_Z.nextBoolean()) {
                        this.actionqueue.add(new EntityRhodes.RhodesAction(7, (int)Math.abs(angle)));
                     } else if (this.field_70146_Z.nextInt(20) < (this.endangered ? 2 : 1)) {
                        this.actionqueue.add(new EntityRhodes.RhodesAction(9, 100));
                        this.flying = 50;
                     } else {
                        this.actionqueue.add(new EntityRhodes.RhodesAction(3, 60));
                     }

                     this.actionqueue.add(new EntityRhodes.RhodesAction(2, 1));
                  } else {
                     this.rightthighpitch = this.approach(this.rightthighpitch, 0.0F);
                     this.leftthighpitch = this.approach(this.leftthighpitch, 0.0F);
                     this.rightshinpitch = this.approach(this.rightshinpitch, 0.0F);
                     this.leftshinpitch = this.approach(this.leftshinpitch, 0.0F);
                     this.rightarmpitch = this.approach(this.rightarmpitch, 0.0F);
                     this.leftarmpitch = this.approach(this.leftarmpitch, 0.0F);
                     this.rightarmyaw = this.approach(this.rightarmyaw, 0.0F);
                     this.leftarmyaw = this.approach(this.leftarmyaw, 0.0F);
                     this.headpitch = this.approach(this.headpitch, 0.0F);
                     this.counter++;
                  }
               }
               break;
            case 3:
               this.shootRocketsAtBestTarget(-syaw, cyaw);
               this.shootFlameAtBestTarget(-syaw, cyaw);
               this.shootLaserAtBestTarget(-syaw, cyaw);
            case 4:
               this.doWalkingAnimation(syaw, cyaw);
               break;
            case 5:
               this.shootRocketsAtBestTarget(-syaw, cyaw);
               this.shootFlameAtBestTarget(-syaw, cyaw);
               this.shootLaserAtBestTarget(-syaw, cyaw);
            case 6:
               this.bodyyaw += 1.5F * movescale;
               this.doWalkingAnimation(syaw, cyaw);
               break;
            case 7:
               this.shootRocketsAtBestTarget(-syaw, cyaw);
               this.shootFlameAtBestTarget(-syaw, cyaw);
               this.shootLaserAtBestTarget(-syaw, cyaw);
            case 8:
               this.bodyyaw -= 1.5F * movescale;
               this.doWalkingAnimation(syaw, cyaw);
               break;
            case 9:
               this.shootRocketsAtBestTarget(-syaw, cyaw);
               this.shootFlameAtBestTarget(-syaw, cyaw);
               this.shootLaserAtBestTarget(-syaw, cyaw);
               this.field_70159_w = syaw * 0.5F * movescale;
               this.field_70179_y = cyaw * 0.5F * movescale;
               this.rightthighpitch = this.approach(this.rightthighpitch, -30.0F);
               this.leftthighpitch = this.approach(this.leftthighpitch, -30.0F);
               this.rightshinpitch = this.approach(this.rightshinpitch, 60.0F);
               this.leftshinpitch = this.approach(this.leftshinpitch, 60.0F);
               break;
            case 10:
               if (this.teamToRaid == 1
                  ? RivalRebels.round.omegaHealth > 0
                     && this.field_70170_p.func_147439_a(RivalRebels.round.oObjx, RivalRebels.round.oObjy, RivalRebels.round.oObjz) == RivalRebels.omegaobj
                  : this.teamToRaid == 2
                     && RivalRebels.round.sigmaHealth > 0
                     && this.field_70170_p.func_147439_a(RivalRebels.round.sObjx, RivalRebels.round.sObjy, RivalRebels.round.sObjz) == RivalRebels.sigmaobj) {
                  this.rightthighpitch = this.approach(this.rightthighpitch, 0.0F);
                  this.leftthighpitch = this.approach(this.leftthighpitch, 0.0F);
                  this.rightshinpitch = this.approach(this.rightshinpitch, 0.0F);
                  this.leftshinpitch = this.approach(this.leftshinpitch, 0.0F);
                  this.rightarmpitch = this.approach(this.rightarmpitch, 0.0F);
                  this.leftarmpitch = this.approach(this.leftarmpitch, 0.0F);
                  this.rightarmyaw = this.approach(this.rightarmyaw, 0.0F);
                  this.leftarmyaw = this.approach(this.leftarmyaw, 0.0F);
                  this.headpitch = this.approach(this.headpitch, 0.0F);
                  this.laserOn = 0;
                  if (this.teamToRaid == 1) {
                     this.health = this.health + RivalRebels.round.takeOmegaHealth(Math.min(50, RivalRebels.rhodesHealth - this.health));
                  }

                  if (this.teamToRaid == 2) {
                     this.health = this.health + RivalRebels.round.takeSigmaHealth(Math.min(50, RivalRebels.rhodesHealth - this.health));
                  }

                  if (this.health != RivalRebels.rhodesHealth) {
                     this.counter++;
                  } else {
                     this.endangered = false;
                     this.teamToRaid = 0;
                     this.actionqueue.add(new EntityRhodes.RhodesAction(2, 1));
                  }
               } else {
                  this.health = 0;
                  RivalRebelsSoundPlayer.playSound(this, 0, 0, 30.0F, 1.0F);
               }
               break;
            case 11:
               this.ac = 1;
               this.counter = 2;
         }

         this.counter--;
      }
   }

   public static float atan2(float y, float x) {
      float dx = (float)Math.sqrt(x * x + y * y) + x;
      if (y > dx) {
         float r = dx / y;
         return 180.0F - (110.86533F - 20.8654F * r * r) * r;
      } else if (y > -dx) {
         float r = y / dx;
         return (110.86533F - 20.8654F * r * r) * r;
      } else {
         float r = dx / y;
         return -180.0F - (110.86533F - 20.8654F * r * r) * r;
      }
   }

   private Entity findTarget() {
      Iterator iter = this.field_70170_p.field_72996_f.iterator();
      Entity target = null;
      double priority = 0.0;

      while (iter.hasNext()) {
         Entity e = (Entity)iter.next();
         if (e != this
            && !e.field_70128_L
            && (!(e instanceof EntityLivingBase) || ((EntityLivingBase)e).func_110143_aJ() > 0.0F)
            && (!(e instanceof EntityRhodes) || RivalRebels.rhodesFF && (RivalRebels.rhodesCC || ((EntityRhodes)e).colorType != this.colorType))
            && !(e instanceof EntityThrowable)
            && !(e instanceof EntityInanimate)
            && !(e instanceof EntityItem)
            && !(e instanceof EntityAnimal)
            && !(e instanceof EntityVillager)
            && !(e instanceof EntityBat)
            && !(e instanceof EntitySquid)
            && !(e instanceof EntityBoat)
            && !(e instanceof EntityMinecart)) {
            double prio = this.getPriority(e) - this.func_70032_d(e);
            if (prio > priority) {
               target = e;
               priority = prio;
            }
         }
      }

      return target;
   }

   private void doWalkingAnimation(float syaw, float cyaw) {
      float movescale = this.scale;
      if (RivalRebels.rhodesScaleSpeed) {
         movescale *= RivalRebels.rhodesSpeedScale;
      } else {
         movescale = RivalRebels.rhodesSpeedScale;
      }

      this.field_70159_w = syaw * 0.125F * movescale;
      this.field_70179_y = cyaw * 0.125F * movescale;
      switch (this.walkstate) {
         case 0:
            int rtgxxxxxxxx = -60;
            int ltgxxxxxxxx = 0;
            int rsgxxxxxxxx = 60;
            int lsgxxxxxxxx = 30;
            this.rightthighpitch = this.approach(this.rightthighpitch, rtgxxxxxxxx);
            this.leftthighpitch = this.approach(this.leftthighpitch, ltgxxxxxxxx);
            this.rightshinpitch = this.approach(this.rightshinpitch, rsgxxxxxxxx);
            this.leftshinpitch = this.approach(this.leftshinpitch, lsgxxxxxxxx);
            if ((int)this.rightthighpitch == rtgxxxxxxxx
               && (int)this.leftthighpitch == ltgxxxxxxxx
               && (int)this.rightshinpitch == rsgxxxxxxxx
               && (int)this.leftshinpitch == lsgxxxxxxxx) {
               this.walkstate++;
            }
            break;
         case 1:
            int rtgxxxxxxx = -60;
            int ltgxxxxxxx = 0;
            int rsgxxxxxxx = 60;
            int lsgxxxxxxx = 60;
            this.rightthighpitch = this.approach(this.rightthighpitch, rtgxxxxxxx);
            this.leftthighpitch = this.approach(this.leftthighpitch, ltgxxxxxxx);
            this.rightshinpitch = this.approach(this.rightshinpitch, rsgxxxxxxx);
            this.leftshinpitch = this.approach(this.leftshinpitch, lsgxxxxxxx);
            if ((int)this.rightthighpitch == rtgxxxxxxx
               && (int)this.leftthighpitch == ltgxxxxxxx
               && (int)this.rightshinpitch == rsgxxxxxxx
               && (int)this.leftshinpitch == lsgxxxxxxx) {
               this.walkstate++;
               RivalRebelsSoundPlayer.playSound(this, 0, 2, 4.5F, 0.8F);
            }
            break;
         case 2:
            int rtgxxxxxx = -30;
            int ltgxxxxxx = 0;
            int rsgxxxxxx = 30;
            int lsgxxxxxx = 90;
            this.rightthighpitch = this.approach(this.rightthighpitch, rtgxxxxxx);
            this.leftthighpitch = this.approach(this.leftthighpitch, ltgxxxxxx);
            this.rightshinpitch = this.approach(this.rightshinpitch, rsgxxxxxx);
            this.leftshinpitch = this.approach(this.leftshinpitch, lsgxxxxxx);
            if ((int)this.rightthighpitch == rtgxxxxxx
               && (int)this.leftthighpitch == ltgxxxxxx
               && (int)this.rightshinpitch == rsgxxxxxx
               && (int)this.leftshinpitch == lsgxxxxxx) {
               this.walkstate++;
            }
            break;
         case 3:
            int rtgxxxxx = 0;
            int ltgxxxxx = -30;
            int rsgxxxxx = 0;
            int lsgxxxxx = 90;
            this.rightthighpitch = this.approach(this.rightthighpitch, rtgxxxxx);
            this.leftthighpitch = this.approach(this.leftthighpitch, ltgxxxxx);
            this.rightshinpitch = this.approach(this.rightshinpitch, rsgxxxxx);
            this.leftshinpitch = this.approach(this.leftshinpitch, lsgxxxxx);
            if ((int)this.rightthighpitch == rtgxxxxx
               && (int)this.leftthighpitch == ltgxxxxx
               && (int)this.rightshinpitch == rsgxxxxx
               && (int)this.leftshinpitch == lsgxxxxx) {
               this.walkstate++;
            }
            break;
         case 4:
            int rtgxxxx = 0;
            int ltgxxxx = -60;
            int rsgxxxx = 30;
            int lsgxxxx = 60;
            this.rightthighpitch = this.approach(this.rightthighpitch, rtgxxxx);
            this.leftthighpitch = this.approach(this.leftthighpitch, ltgxxxx);
            this.rightshinpitch = this.approach(this.rightshinpitch, rsgxxxx);
            this.leftshinpitch = this.approach(this.leftshinpitch, lsgxxxx);
            if ((int)this.rightthighpitch == rtgxxxx
               && (int)this.leftthighpitch == ltgxxxx
               && (int)this.rightshinpitch == rsgxxxx
               && (int)this.leftshinpitch == lsgxxxx) {
               this.walkstate++;
            }
            break;
         case 5:
            int rtgxxx = 0;
            int ltgxxx = -60;
            int rsgxxx = 60;
            int lsgxxx = 60;
            this.rightthighpitch = this.approach(this.rightthighpitch, rtgxxx);
            this.leftthighpitch = this.approach(this.leftthighpitch, ltgxxx);
            this.rightshinpitch = this.approach(this.rightshinpitch, rsgxxx);
            this.leftshinpitch = this.approach(this.leftshinpitch, lsgxxx);
            if ((int)this.rightthighpitch == rtgxxx
               && (int)this.leftthighpitch == ltgxxx
               && (int)this.rightshinpitch == rsgxxx
               && (int)this.leftshinpitch == lsgxxx) {
               this.walkstate++;
               RivalRebelsSoundPlayer.playSound(this, 0, 2, 4.5F, 0.8F);
            }
            break;
         case 6:
            int rtgxx = 0;
            int ltgxx = -30;
            int rsgxx = 90;
            int lsgxx = 30;
            this.rightthighpitch = this.approach(this.rightthighpitch, rtgxx);
            this.leftthighpitch = this.approach(this.leftthighpitch, ltgxx);
            this.rightshinpitch = this.approach(this.rightshinpitch, rsgxx);
            this.leftshinpitch = this.approach(this.leftshinpitch, lsgxx);
            if ((int)this.rightthighpitch == rtgxx
               && (int)this.leftthighpitch == ltgxx
               && (int)this.rightshinpitch == rsgxx
               && (int)this.leftshinpitch == lsgxx) {
               this.walkstate++;
            }
            break;
         case 7:
            int rtgx = -30;
            int ltgx = 0;
            int rsgx = 90;
            int lsgx = 0;
            this.rightthighpitch = this.approach(this.rightthighpitch, rtgx);
            this.leftthighpitch = this.approach(this.leftthighpitch, ltgx);
            this.rightshinpitch = this.approach(this.rightshinpitch, rsgx);
            this.leftshinpitch = this.approach(this.leftshinpitch, lsgx);
            if ((int)this.rightthighpitch == rtgx && (int)this.leftthighpitch == ltgx && (int)this.rightshinpitch == rsgx && (int)this.leftshinpitch == lsgx) {
               this.walkstate++;
            }
            break;
         case 8:
            int rtg = -60;
            int ltg = 0;
            int rsg = 60;
            int lsg = 30;
            this.rightthighpitch = this.approach(this.rightthighpitch, rtg);
            this.leftthighpitch = this.approach(this.leftthighpitch, ltg);
            this.rightshinpitch = this.approach(this.rightshinpitch, rsg);
            this.leftshinpitch = this.approach(this.leftshinpitch, lsg);
            if ((int)this.rightthighpitch == rtg && (int)this.leftthighpitch == ltg && (int)this.rightshinpitch == rsg && (int)this.leftshinpitch == lsg) {
               this.walkstate = 0;
            }
      }
   }

   private float approach(float f, float t) {
      float r = f - t;
      if (r > 1.0F) {
         r = 1.0F;
      }

      if (r < -1.0F) {
         r = -1.0F;
      }

      return f - r;
   }

   private void shootRocketsAtBestTarget(float syaw, float cyaw) {
      if (this.rocketcount >= 0) {
         float px = (float)this.field_70165_t + cyaw * 6.4F * this.scale;
         float py = (float)this.field_70163_u + 6.26759F * this.scale;
         float pz = (float)this.field_70161_v + syaw * 6.4F * this.scale;
         TileEntity te = null;
         this.lastrockettargetting--;
         if (this.lastrockettargetting < 0
            || this.lastRocketTarget == null
            || this.lastRocketTarget.field_70128_L
            || this.lastRocketTarget instanceof EntityLivingBase && ((EntityLivingBase)this.lastRocketTarget).func_110143_aJ() <= 0.0F) {
            this.lastrockettargetting = 10;
            float priority = 0.0F;
            if (this.lastRocketTarget != null && !this.lastRocketTarget.field_70128_L) {
               float dx = (float)this.lastRocketTarget.field_70165_t - px;
               float dz = (float)this.lastRocketTarget.field_70161_v - pz;
               float dot = cyaw * dx + syaw * dz;
               if (dot * Math.abs(dot) > -0.25 * (dx * dx + dz * dz)) {
                  float dy = (float)this.lastRocketTarget.field_70163_u - (float)this.field_70163_u - 6.2F * this.scale;
                  float dist = dx * dx + dy * dy + dz * dz;
                  if (dist < 10000.0F * this.scale * this.scale
                     && this.rayTraceBlocks(
                           px,
                           py,
                           pz,
                           (float)this.lastRocketTarget.field_70165_t,
                           (float)this.lastRocketTarget.field_70163_u + this.lastRocketTarget.field_70131_O / 2.0F,
                           (float)this.lastRocketTarget.field_70161_v
                        )
                        == null) {
                     priority = this.getPriority(this.lastRocketTarget) - (float)Math.sqrt(dist) + 10.0F;
                  }
               }
            }

            if (priority <= 0.0F) {
               this.lastRocketTarget = null;
            }

            for (Entity e : this.field_70170_p
               .func_72839_b(
                  this,
                  AxisAlignedBB.func_72330_a(
                     px - 100.0F * this.scale,
                     py - 100.0F * this.scale,
                     pz - 100.0F * this.scale,
                     px + 100.0F * this.scale,
                     py + 100.0F * this.scale,
                     pz + 100.0F * this.scale
                  )
               )) {
               if (!e.field_70128_L
                  && (!(e instanceof EntityLivingBase) || ((EntityLivingBase)e).func_110143_aJ() > 0.0F)
                  && !(e instanceof EntityThrowable)
                  && !(e instanceof EntityInanimate)
                  && !(e instanceof EntityItem)
                  && !(e instanceof EntityAnimal)
                  && !(e instanceof EntityVillager)
                  && !(e instanceof EntityBat)
                  && !(e instanceof EntitySquid)
                  && !(e instanceof EntityBoat)
                  && !(e instanceof EntityMinecart)) {
                  float dx = (float)e.field_70165_t - px;
                  float dz = (float)e.field_70161_v - pz;
                  float dot = cyaw * dx + syaw * dz;
                  if (dot * Math.abs(dot) > -0.25 * (dx * dx + dz * dz)) {
                     float dy = (float)e.field_70163_u - py;
                     float dist = dx * dx + dy * dy + dz * dz;
                     if (dist < 10000.0F * this.scale * this.scale) {
                        float prio = this.getPriority(e) - (float)Math.sqrt(dist);
                        if (prio > priority
                           && this.rayTraceBlocks(px, py, pz, (float)e.field_70165_t, (float)e.field_70163_u + e.field_70131_O / 2.0F, (float)e.field_70161_v)
                              == null) {
                           this.lastRocketTarget = e;
                           priority = prio;
                        }
                     }
                  }
               }
            }

            Object[] tel = this.field_70170_p.field_147482_g.toArray();

            for (int teli = 0; teli < tel.length; teli++) {
               Object eo = tel[teli];
               if (eo instanceof TileEntityRhodesActivator || eo instanceof TileEntityNukeCrate || eo instanceof TileEntityReactor) {
                  TileEntity e = (TileEntity)eo;
                  float dx = e.field_145851_c - px;
                  float dz = e.field_145849_e - pz;
                  float dot = cyaw * dx + syaw * dz;
                  if (dot * Math.abs(dot) > -0.25 * (dx * dx + dz * dz)) {
                     float dy = e.field_145848_d - py;
                     float dist = dx * dx + dy * dy + dz * dz;
                     if (dist < 10000.0F) {
                        float prio = 300.0F - (float)Math.sqrt(dist);
                        if (prio > priority && this.rayTraceBlocks(px, py, pz, e.field_145851_c, e.field_145848_d, e.field_145849_e) == null) {
                           te = e;
                           this.lastRocketTarget = null;
                           priority = prio;
                        }
                     }
                  }
               }
            }
         }

         if (te != null && !this.nuke) {
            float x = px - te.field_145851_c;
            float y = py - te.field_145848_d;
            float z = pz - te.field_145849_e;
            float yaw = (atan2(x, z) - this.bodyyaw + 630.0F) % 360.0F - 90.0F;
            float pitch = -atan2((float)Math.sqrt(x * x + z * z), y);
            boolean pointing = true;
            if (Math.abs(this.leftarmyaw - yaw) >= 0.001F) {
               this.leftarmyaw = this.leftarmyaw + Math.max(-3.0F, Math.min(3.0F, yaw - this.leftarmyaw));
               if (Math.abs(this.leftarmyaw - yaw) < 3.0F) {
                  pointing &= true;
               } else {
                  pointing = false;
               }
            }

            if (Math.abs(this.leftarmpitch - pitch) >= 0.001F) {
               this.leftarmpitch = this.leftarmpitch + Math.max(-3.0F, Math.min(3.0F, pitch - this.leftarmpitch));
               if (Math.abs(this.leftarmpitch - pitch) < 3.0F) {
                  pointing &= true;
               } else {
                  pointing = false;
               }
            }

            if (pointing && this.field_70173_aa - this.lastshot > (this.scale >= 2.0 ? 30 : (this.shotstaken == 21 ? 80 : 5))) {
               this.rocketcount--;
               this.lastshot = this.field_70173_aa;
               if (this.shotstaken == 21) {
                  this.shotstaken = 0;
               }

               this.shotstaken++;
               RivalRebelsSoundPlayer.playSound(this, 23, 10, 1.0F);
               float cp = -0.5F / (float)Math.sqrt(x * x + y * y + z * z);
               if (this.scale >= 2.0) {
                  this.field_70170_p.func_72838_d(new EntityB83NoShroom(this.field_70170_p, px, py, pz, x * cp, y * cp, z * cp));
               } else {
                  this.field_70170_p.func_72838_d(new EntitySeekB83(this.field_70170_p, px, py, pz, x * cp, y * cp, z * cp));
               }
            }
         } else if (this.lastRocketTarget != null && !this.lastRocketTarget.field_70128_L) {
            float x = px - (float)this.lastRocketTarget.field_70165_t;
            float y = py - (float)this.lastRocketTarget.field_70163_u;
            float z = pz - (float)this.lastRocketTarget.field_70161_v;
            float yaw = (atan2(x, z) - this.bodyyaw + 630.0F) % 360.0F - 90.0F;
            float pitch = -atan2((float)Math.sqrt(x * x + z * z), y);
            boolean pointing = true;
            if (Math.abs(this.leftarmyaw - yaw) >= 0.001F) {
               this.leftarmyaw = this.leftarmyaw + Math.max(-3.0F, Math.min(3.0F, yaw - this.leftarmyaw));
               if (Math.abs(this.leftarmyaw - yaw) < 3.0F) {
                  pointing &= true;
               } else {
                  pointing = false;
               }
            }

            if (Math.abs(this.leftarmpitch - pitch) >= 0.001F) {
               this.leftarmpitch = this.leftarmpitch + Math.max(-3.0F, Math.min(3.0F, pitch - this.leftarmpitch));
               if (Math.abs(this.leftarmpitch - pitch) < 3.0F) {
                  pointing &= true;
               } else {
                  pointing = false;
               }
            }

            if (this.lastRocketTarget instanceof EntityLivingBase && ((EntityLivingBase)this.lastRocketTarget).func_110138_aP() > 1000.0F) {
               if (pointing && this.field_70173_aa % 100 == 0) {
                  RivalRebelsSoundPlayer.playSound(this, 23, 10, 1.0F);
                  float cp = -0.5F / (float)Math.sqrt(x * x + y * y + z * z);
                  if (this.scale >= 2.0) {
                     this.field_70170_p.func_72838_d(new EntityTsar(this.field_70170_p, px, py, pz, x * cp * 5.0F, y * cp * 5.0F, z * cp * 5.0F));
                  } else {
                     this.field_70170_p.func_72838_d(new EntityB83NoShroom(this.field_70170_p, px, py, pz, x * cp, y * cp, z * cp));
                  }
               }
            } else if (pointing && this.field_70173_aa - this.lastshot > (this.scale >= 2.0 ? 30 : (this.shotstaken == 21 ? 80 : 5))) {
               this.rocketcount--;
               this.lastshot = this.field_70173_aa;
               if (this.shotstaken == 21) {
                  this.shotstaken = 0;
               }

               this.shotstaken++;
               RivalRebelsSoundPlayer.playSound(this, 23, 10, 1.0F);
               float cp = -0.5F / (float)Math.sqrt(x * x + y * y + z * z);
               if (this.scale >= 2.0) {
                  this.field_70170_p.func_72838_d(new EntityB83NoShroom(this.field_70170_p, px, py, pz, x * cp, y * cp, z * cp));
               } else {
                  this.field_70170_p.func_72838_d(new EntitySeekB83(this.field_70170_p, px, py, pz, x * cp, y * cp, z * cp));
               }
            }
         }
      }
   }

   private void shootFlameAtBestTarget(float syaw, float cyaw) {
      float px = (float)this.field_70165_t - cyaw * 6.4F * this.scale;
      float py = (float)this.field_70163_u + 6.26759F * this.scale;
      float pz = (float)this.field_70161_v - syaw * 6.4F * this.scale;
      this.lastflametargetting--;
      if (this.lastflametargetting < 0
         || this.lastFlameTarget == null
         || this.lastFlameTarget.field_70128_L
         || this.lastFlameTarget instanceof EntityLivingBase && ((EntityLivingBase)this.lastFlameTarget).func_110143_aJ() <= 0.0F) {
         this.lastflametargetting = 10;
         float priority = 0.0F;
         if (this.lastFlameTarget != null && !this.lastFlameTarget.field_70128_L) {
            float dx = (float)this.lastFlameTarget.field_70165_t - px;
            float dz = (float)this.lastFlameTarget.field_70161_v - pz;
            float dot = -cyaw * dx + -syaw * dz;
            if (dot * Math.abs(dot) > -0.25 * (dx * dx + dz * dz)) {
               float dy = (float)this.lastFlameTarget.field_70163_u - (float)this.field_70163_u - 6.2F;
               float dist = dx * dx + dy * dy + dz * dz;
               if (dist < 1600.0F * this.scale * this.scale
                  && this.rayTraceBlocks(
                        px,
                        py,
                        pz,
                        (float)this.lastFlameTarget.field_70165_t,
                        (float)this.lastFlameTarget.field_70163_u + this.lastFlameTarget.field_70131_O,
                        (float)this.lastFlameTarget.field_70161_v
                     )
                     == null) {
                  priority = this.getPriority(this.lastFlameTarget) - (float)Math.sqrt(dist) + 10.0F;
               }
            }
         }

         if (priority <= 0.0F) {
            this.lastFlameTarget = null;
         }

         for (Entity e : this.field_70170_p
            .func_72839_b(
               this,
               AxisAlignedBB.func_72330_a(
                  px - 40.0F * this.scale,
                  py - 40.0F * this.scale,
                  pz - 40.0F * this.scale,
                  px + 40.0F * this.scale,
                  py + 40.0F * this.scale,
                  pz + 40.0F * this.scale
               )
            )) {
            if (!e.field_70128_L
               && (!(e instanceof EntityLivingBase) || ((EntityLivingBase)e).func_110143_aJ() > 0.0F)
               && !(e instanceof EntityThrowable)
               && !(e instanceof EntityInanimate)
               && !(e instanceof EntityItem)
               && !(e instanceof EntityAnimal)
               && !(e instanceof EntityVillager)
               && !(e instanceof EntityBat)
               && !(e instanceof EntitySquid)
               && !(e instanceof EntityBoat)
               && !(e instanceof EntityMinecart)) {
               float dx = (float)e.field_70165_t - px;
               float dz = (float)e.field_70161_v - pz;
               float dot = -cyaw * dx + -syaw * dz;
               if (dot * Math.abs(dot) > -0.25 * (dx * dx + dz * dz)) {
                  float dy = (float)e.field_70163_u - py;
                  float dist = dx * dx + dy * dy + dz * dz;
                  if (dist < 1600.0F * this.scale * this.scale) {
                     float prio = this.getPriority(e) - (float)Math.sqrt(dist);
                     if (prio > priority
                        && this.rayTraceBlocks(px, py, pz, (float)e.field_70165_t, (float)e.field_70163_u + e.field_70131_O, (float)e.field_70161_v) == null) {
                        this.lastFlameTarget = e;
                        priority = prio;
                     }
                  }
               }
            }
         }
      }

      if (this.lastFlameTarget != null && !this.lastFlameTarget.field_70128_L) {
         float x = px - (float)this.lastFlameTarget.field_70165_t;
         float y = py - (float)this.lastFlameTarget.field_70163_u - this.lastFlameTarget.field_70131_O * 0.5F;
         float z = pz - (float)this.lastFlameTarget.field_70161_v;
         float yaw = (atan2(x, z) - this.bodyyaw + 810.0F) % 360.0F - 270.0F;
         float pitch = -atan2((float)Math.sqrt(x * x + z * z), y);
         boolean pointing = true;
         if (Math.abs(this.rightarmyaw - yaw) >= 0.001F) {
            this.rightarmyaw = this.rightarmyaw + Math.max(-3.0F, Math.min(3.0F, yaw - this.rightarmyaw));
            if (Math.abs(this.rightarmyaw - yaw) < 0.001F) {
               pointing &= true;
            } else {
               pointing = false;
            }
         }

         if (Math.abs(this.rightarmpitch - pitch) >= 0.001F) {
            this.rightarmpitch = this.rightarmpitch + Math.max(-3.0F, Math.min(3.0F, pitch - this.rightarmpitch));
            if (Math.abs(this.rightarmpitch - pitch) < 0.001F) {
               pointing &= true;
            } else {
               pointing = false;
            }
         }

         if (pointing) {
            RivalRebelsSoundPlayer.playSound(this, 8, 1, 1.0F);
            float cp = -1.0F / (float)Math.sqrt(x * x + y * y + z * z);
            x *= cp;
            y *= cp;
            z *= cp;
            this.field_70170_p.func_72838_d(new EntityFlameBall(this.field_70170_p, px, py, pz, x, y, z, (8.0 + Math.random() * 8.0) * this.scale, 0.4F));
            this.field_70170_p.func_72838_d(new EntityFlameBall(this.field_70170_p, px, py, pz, x, y, z, (8.0 + Math.random() * 8.0) * this.scale, 0.4F));
         }
      }
   }

   private void shootLaserAtBestTarget(float syaw, float cyaw) {
      this.lastlasertargetting--;
      if (this.lastlasertargetting < 0
         || this.lastLaserTarget == null
         || this.lastLaserTarget.field_70128_L
         || this.lastLaserTarget instanceof EntityLivingBase && ((EntityLivingBase)this.lastLaserTarget).func_110143_aJ() <= 0.0F) {
         this.lastlasertargetting = 10;
         float priority = 0.0F;
         if (this.lastLaserTarget != null && !this.lastLaserTarget.field_70128_L) {
            float tempdi = (float)(
               (this.lastLaserTarget.field_70165_t - this.field_70165_t) * (this.lastLaserTarget.field_70165_t - this.field_70165_t)
                  + (this.lastLaserTarget.field_70163_u - 13.0 - this.field_70163_u) * (this.lastLaserTarget.field_70163_u - 13.0 - this.field_70163_u)
                  + (this.lastLaserTarget.field_70161_v - this.field_70161_v) * (this.lastLaserTarget.field_70161_v - this.field_70161_v)
            );
            if (Math.abs(cyaw * (this.lastLaserTarget.field_70165_t - this.field_70165_t) + syaw * (this.lastLaserTarget.field_70161_v - this.field_70161_v))
                  < 2.0
               && tempdi < 4900.0F
               && this.rayTraceBlocks(
                     (float)this.field_70165_t,
                     (float)this.field_70163_u + 13.0F,
                     (float)this.field_70161_v,
                     (float)this.lastLaserTarget.field_70165_t,
                     (float)this.lastLaserTarget.field_70163_u + this.lastLaserTarget.field_70131_O / 2.0F,
                     (float)this.lastLaserTarget.field_70161_v
                  )
                  == null) {
               priority = this.getPriority(this.lastLaserTarget) - (float)Math.sqrt(tempdi);
               if (priority > 0.0F) {
                  priority += 10.0F;
               }
            }
         }

         if (priority <= 0.0F) {
            this.lastLaserTarget = null;
         }

         for (Entity e : this.field_70170_p
            .func_72839_b(
               this,
               AxisAlignedBB.func_72330_a(
                  this.field_70165_t - 70.0F * this.scale,
                  this.field_70163_u + 13.0F * this.scale - 70.0F * this.scale,
                  this.field_70161_v - 70.0F * this.scale,
                  this.field_70165_t + 70.0F * this.scale,
                  this.field_70163_u + 13.0F * this.scale + 70.0F * this.scale,
                  this.field_70161_v + 70.0F * this.scale
               )
            )) {
            if (!e.field_70128_L
               && (!(e instanceof EntityLivingBase) || ((EntityLivingBase)e).func_110143_aJ() > 0.0F)
               && !(e instanceof EntityThrowable)
               && !(e instanceof EntityInanimate)
               && !(e instanceof EntityItem)
               && !(e instanceof EntityAnimal)
               && !(e instanceof EntityVillager)
               && !(e instanceof EntityBat)
               && !(e instanceof EntitySquid)
               && !(e instanceof EntityBoat)
               && !(e instanceof EntityMinecart)) {
               float x = (float)(e.field_70165_t - this.field_70165_t);
               float z = (float)(e.field_70161_v - this.field_70161_v);
               if (Math.abs(cyaw * x + syaw * z) < 2.0F) {
                  float y = (float)(e.field_70163_u - 13.0 - this.field_70163_u);
                  float dist = x * x + y * y + z * z;
                  if (dist < 4900.0F * this.scale * this.scale && y * Math.abs(y) > -0.64F * dist) {
                     float prio = this.getPriority(e) - (float)Math.sqrt(dist);
                     if (prio > priority
                        && this.rayTraceBlocks(
                              (float)this.field_70165_t,
                              (float)this.field_70163_u + 13.0F,
                              (float)this.field_70161_v,
                              (float)e.field_70165_t,
                              (float)e.field_70163_u + e.field_70131_O / 2.0F,
                              (float)e.field_70161_v
                           )
                           == null) {
                        this.lastLaserTarget = e;
                        priority = prio;
                     }
                  }
               }
            }
         }
      }

      this.laserOn = 0;
      if (this.lastLaserTarget != null && !this.lastLaserTarget.field_70128_L) {
         float x = (float)(this.field_70165_t - this.lastLaserTarget.field_70165_t);
         float y = (float)(this.field_70163_u + 13.0 - this.lastLaserTarget.field_70163_u);
         float z = (float)(this.field_70161_v - this.lastLaserTarget.field_70161_v);
         float dot = -syaw * x + cyaw * z;
         float pitch = (720.0F - atan2((float)Math.sqrt(x * x + z * z) * (dot > 0.0F ? -1.0F : 1.0F), y)) % 360.0F - 270.0F;
         boolean pointing = true;
         if (Math.abs(this.headpitch - pitch) >= 0.001F) {
            this.headpitch = this.headpitch + Math.max(-20.0F, Math.min(20.0F, pitch - this.headpitch));
            if (Math.abs(this.headpitch - pitch) < 3.0F) {
               pointing = true;
            } else {
               pointing = false;
            }
         }

         if (pointing) {
            this.laserOn = (byte)(this.endangered ? 3 : this.field_70146_Z.nextInt(2) + 1);
            RivalRebelsSoundPlayer.playSound(this, 22, 1, 30.0F, 0.0F);
            if (this.lastLaserTarget instanceof EntityPlayer) {
               EntityPlayer player = (EntityPlayer)this.lastLaserTarget;
               ItemStack[] armorSlots = player.field_71071_by.field_70460_b;
               int i = this.field_70170_p.field_73012_v.nextInt(4);
               if (armorSlots[i] != null) {
                  armorSlots[i].func_77972_a(24, player);
               }

               this.lastLaserTarget.func_70097_a(RivalRebelsDamageSource.laserburst, this.laserOn == 3 ? 16.0F : 8.0F);
               if (player.func_110143_aJ() < 3.0F && player.func_70089_S()) {
                  player.func_70097_a(RivalRebelsDamageSource.laserburst, 2000000.0F);
                  player.field_70725_aQ = 0;
                  this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, this.lastLaserTarget, 0, 0));
                  this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, this.lastLaserTarget, 1, 0));
                  this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, this.lastLaserTarget, 2, 0));
                  this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, this.lastLaserTarget, 2, 0));
                  this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, this.lastLaserTarget, 3, 0));
                  this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, this.lastLaserTarget, 3, 0));
               }
            } else {
               this.lastLaserTarget.func_70097_a(RivalRebelsDamageSource.laserburst, this.laserOn == 3 ? 16.0F : 8.0F);
               if (this.lastLaserTarget.field_70128_L
                  || this.lastLaserTarget instanceof EntityLivingBase && ((EntityLivingBase)this.lastLaserTarget).func_110143_aJ() < 3.0F) {
                  int legs = -1;
                  int arms = -1;
                  int mobs = -1;
                  RivalRebelsSoundPlayer.playSound(this, 2, 1, 4.0F);
                  byte var26;
                  if (this.lastLaserTarget instanceof EntityPigZombie) {
                     legs = 2;
                     arms = 2;
                     var26 = 2;
                  } else if (this.lastLaserTarget instanceof EntityZombie) {
                     legs = 2;
                     arms = 2;
                     var26 = 1;
                  } else if (this.lastLaserTarget instanceof EntitySkeleton) {
                     legs = 2;
                     arms = 2;
                     var26 = 3;
                  } else if (this.lastLaserTarget instanceof EntityEnderman) {
                     legs = 2;
                     arms = 2;
                     var26 = 4;
                  } else if (this.lastLaserTarget instanceof EntityCreeper) {
                     legs = 4;
                     arms = 0;
                     var26 = 5;
                  } else if (this.lastLaserTarget instanceof EntityMagmaCube) {
                     legs = 0;
                     arms = 0;
                     var26 = 7;
                  } else if (this.lastLaserTarget instanceof EntitySlime) {
                     legs = 0;
                     arms = 0;
                     var26 = 6;
                  } else if (this.lastLaserTarget instanceof EntityCaveSpider) {
                     legs = 8;
                     arms = 0;
                     var26 = 9;
                  } else if (this.lastLaserTarget instanceof EntitySpider) {
                     legs = 8;
                     arms = 0;
                     var26 = 8;
                  } else if (this.lastLaserTarget instanceof EntityGhast) {
                     legs = 9;
                     arms = 0;
                     var26 = 10;
                  } else {
                     if (this.lastLaserTarget instanceof EntityB2Spirit
                        || this.lastLaserTarget instanceof EntityRhodes
                        || this.lastLaserTarget instanceof EntityRhodesPiece) {
                        return;
                     }

                     legs = (int)(this.lastLaserTarget.field_70121_D.func_72320_b() * 2.0);
                     arms = (int)(this.lastLaserTarget.field_70121_D.func_72320_b() * 2.0);
                     var26 = 11;
                  }

                  this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, this.lastLaserTarget, 0, var26));
                  this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, this.lastLaserTarget, 1, var26));

                  for (int i = 0; i < arms; i++) {
                     this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, this.lastLaserTarget, 2, var26));
                  }

                  for (int i = 0; i < legs; i++) {
                     this.field_70170_p.func_72838_d(new EntityGore(this.field_70170_p, this.lastLaserTarget, 3, var26));
                  }

                  this.lastLaserTarget.func_70106_y();
               }
            }
         }
      }
   }

   private float getPriority(Entity e) {
      if (e instanceof EntityPlayer) {
         return ((EntityPlayer)e).field_71075_bZ.field_75098_d ? -100.0F : 600.0F;
      } else if (e instanceof EntityLivingBase) {
         return ((EntityLivingBase)e).func_110138_aP() + 100.0F;
      } else if ((!(e instanceof EntityRhodes) || !RivalRebels.rhodesFF || !RivalRebels.rhodesCC && ((EntityRhodes)e).colorType == this.colorType)
         && !(e instanceof EntityB2Spirit)) {
         return e.field_70121_D.func_72320_b() > 3.0 ? (float)(e.field_70121_D.func_72320_b() * 3.0 + 500.0 + e.field_70131_O) : 0.0F;
      } else {
         return 800.0F;
      }
   }

   private Vec3 rayTraceBlocks(float sx, float sy, float sz, float ex, float ey, float ez) {
      int X = (int)sx;
      int Y = (int)sy;
      int Z = (int)sz;
      float dx = ex - sx;
      float dy = ey - sy;
      float dz = ez - sz;
      float distsq = dx * dx + dy * dy + dz * dz;
      int stepX = dx > 0.0F ? 1 : -1;
      int stepY = dy > 0.0F ? 1 : -1;
      int stepZ = dz > 0.0F ? 1 : -1;
      int x = X - stepX;
      int y = Y - stepY;
      int z = Z - stepZ;
      float tDeltaX = stepX / dx;
      float tDeltaY = stepY / dy;
      float tDeltaZ = stepZ / dz;
      float tMaxX = (1 + X - sx) * tDeltaX;
      float tMaxY = (1 + Y - sy) * tDeltaY;
      float tMaxZ = (1 + Z - sz) * tDeltaZ;

      while ((X - x) * (X - x) + (Y - y) * (Y - y) + (Z - z) * (Z - z) < distsq) {
         if (this.field_70170_p.func_147439_a(X, Y, Z).func_149662_c()) {
            return Vec3.func_72443_a(X, Y, Z);
         }

         if (tMaxX < tMaxY) {
            if (tMaxX < tMaxZ) {
               X += stepX;
               tMaxX += tDeltaX;
            } else {
               Z += stepZ;
               tMaxZ += tDeltaZ;
            }
         } else if (tMaxY < tMaxZ) {
            Y += stepY;
            tMaxY += tDeltaY;
         } else {
            Z += stepZ;
            tMaxZ += tDeltaZ;
         }
      }

      return null;
   }

   public float getbodyyaw(float f) {
      return this.lastbodyyaw + (this.bodyyaw - this.lastbodyyaw) * f;
   }

   public float getheadyaw(float f) {
      return this.lastheadyaw + (this.headyaw - this.lastheadyaw) * f;
   }

   public float getheadpitch(float f) {
      return this.lastheadpitch + (this.headpitch - this.lastheadpitch) * f;
   }

   public float getleftarmyaw(float f) {
      return this.lastleftarmyaw + (this.leftarmyaw - this.lastleftarmyaw) * f;
   }

   public float getleftarmpitch(float f) {
      return this.lastleftarmpitch + (this.leftarmpitch - this.lastleftarmpitch) * f;
   }

   public float getrightarmyaw(float f) {
      return this.lastrightarmyaw + (this.rightarmyaw - this.lastrightarmyaw) * f;
   }

   public float getrightarmpitch(float f) {
      return this.lastrightarmpitch + (this.rightarmpitch - this.lastrightarmpitch) * f;
   }

   public float getleftthighpitch(float f) {
      return this.lastleftthighpitch + (this.leftthighpitch - this.lastleftthighpitch) * f;
   }

   public float getrightthighpitch(float f) {
      return this.lastrightthighpitch + (this.rightthighpitch - this.lastrightthighpitch) * f;
   }

   public float getleftshinpitch(float f) {
      return this.lastleftshinpitch + (this.leftshinpitch - this.lastleftshinpitch) * f;
   }

   public float getrightshinpitch(float f) {
      return this.lastrightshinpitch + (this.rightshinpitch - this.lastrightshinpitch) * f;
   }

   public String getName() {
      return names[this.colorType];
   }

   public void func_70014_b(NBTTagCompound nbt) {
      nbt.func_74776_a("bodyyaw", this.bodyyaw);
      nbt.func_74776_a("headyaw", this.headyaw);
      nbt.func_74776_a("headpitch", this.headpitch);
      nbt.func_74776_a("leftarmyaw", this.leftarmyaw);
      nbt.func_74776_a("leftarmpitch", this.leftarmpitch);
      nbt.func_74776_a("rightarmyaw", this.rightarmyaw);
      nbt.func_74776_a("rightarmpitch", this.rightarmpitch);
      nbt.func_74776_a("leftthighpitch", this.leftthighpitch);
      nbt.func_74776_a("rightthighpitch", this.rightthighpitch);
      nbt.func_74776_a("leftshinpitch", this.leftshinpitch);
      nbt.func_74776_a("rightshinpitch", this.rightshinpitch);
      nbt.func_74757_a("endangered", this.endangered);
      nbt.func_74768_a("ac", this.ac);
      nbt.func_74768_a("counter", this.counter);
      nbt.func_74768_a("walkstate", this.walkstate);
      nbt.func_74768_a("health", this.health);
      nbt.func_74768_a("damageuntilwake", this.damageUntilWake);
      nbt.func_74774_a("color", this.colorType);
      nbt.func_74768_a("rocketcount", this.rocketcount);
      nbt.func_74768_a("energy", this.energy);
      nbt.func_74768_a("b2energy", this.b2energy);
      nbt.func_74768_a("flamecount", this.flamecount);
      nbt.func_74768_a("nukecount", this.nukecount);
      nbt.func_74768_a("texfolder", this.itexfolder);
      nbt.func_74776_a("scale", this.scale);
      if (this.itexfolder != -1) {
         nbt.func_74778_a("texloc", this.itexloc);
      }
   }

   public void func_70037_a(NBTTagCompound nbt) {
      this.bodyyaw = nbt.func_74760_g("bodyyaw");
      this.headyaw = nbt.func_74760_g("headyaw");
      this.headpitch = nbt.func_74760_g("headpitch");
      this.leftarmyaw = nbt.func_74760_g("leftarmyaw");
      this.leftarmpitch = nbt.func_74760_g("leftarmpitch");
      this.rightarmyaw = nbt.func_74760_g("rightarmyaw");
      this.rightarmpitch = nbt.func_74760_g("rightarmpitch");
      this.leftthighpitch = nbt.func_74760_g("leftthighpitch");
      this.rightthighpitch = nbt.func_74760_g("rightthighpitch");
      this.leftshinpitch = nbt.func_74760_g("leftshinpitch");
      this.rightshinpitch = nbt.func_74760_g("rightshinpitch");
      this.endangered = nbt.func_74767_n("endangered");
      this.ac = nbt.func_74762_e("ac");
      this.counter = nbt.func_74762_e("counter");
      this.walkstate = nbt.func_74762_e("walkstate");
      this.health = nbt.func_74762_e("health");
      this.damageUntilWake = nbt.func_74762_e("damageuntilwake");
      this.colorType = nbt.func_74771_c("color");
      this.rocketcount = nbt.func_74762_e("rocketcount");
      this.energy = nbt.func_74762_e("energy");
      this.b2energy = nbt.func_74762_e("b2energy");
      this.flamecount = nbt.func_74762_e("flamecount");
      this.nukecount = nbt.func_74762_e("nukecount");
      this.itexfolder = nbt.func_74762_e("texfolder");
      this.scale = nbt.func_74760_g("scale");
      if (this.itexfolder != -1) {
         this.itexloc = nbt.func_74779_i("texloc");
      }
   }

   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
      super.func_70097_a(par1DamageSource, par2);
      if (!this.field_70128_L && !this.field_70170_p.field_72995_K && this.health > 0 && !this.forcefield) {
         if (par2 > 50.0F) {
            this.health -= 50;
            if (this.rider == null) {
               this.damageUntilWake -= 50;
            }

            this.endangered = true;
         } else {
            this.health = (int)(this.health - par2);
            if (this.rider == null) {
               this.damageUntilWake = (int)(this.damageUntilWake - par2);
            }
         }

         if (this.health <= 0) {
            this.health = 0;
            RivalRebelsSoundPlayer.playSound(this, 0, 0, 30.0F, 1.0F);
         }
      }

      return true;
   }

   protected void func_70088_a() {
   }

   public AxisAlignedBB func_70114_g(Entity par1Entity) {
      return null;
   }

   public AxisAlignedBB func_70046_E() {
      return null;
   }

   public boolean func_70067_L() {
      return false;
   }

   public boolean func_70104_M() {
      return false;
   }

   @SideOnly(Side.CLIENT)
   public int func_70070_b(float p_70070_1_) {
      int i = MathHelper.func_76128_c(this.field_70165_t);
      int j = MathHelper.func_76128_c(this.field_70161_v);
      return this.field_70170_p.func_72899_e(i, 0, j) ? this.field_70170_p.func_72802_i(i, 255, j, 0) : 0;
   }

   public float func_70013_c(float p_70013_1_) {
      int i = MathHelper.func_76128_c(this.field_70165_t);
      int j = MathHelper.func_76128_c(this.field_70161_v);
      return this.field_70170_p.func_72899_e(i, 0, j) ? this.field_70170_p.func_72801_o(i, 255, j) : 0.0F;
   }

   public boolean func_70112_a(double par1) {
      return true;
   }

   static {
      blocklist.add(Blocks.field_150357_h);
      blocklist.add(Blocks.field_150346_d);
      blocklist.add(Blocks.field_150348_b);
      blocklist.add(Blocks.field_150354_m);
      blocklist.add(Blocks.field_150322_A);
      blocklist.add(Blocks.field_150351_n);
      blocklist.add(Blocks.field_150339_S);
      blocklist.add(Blocks.field_150368_y);
      blocklist.add(Blocks.field_150333_U);
      blocklist.add(Blocks.field_150417_aV);
      blocklist.add(Blocks.field_150347_e);
      blocklist.add(Blocks.field_150343_Z);
      blocklist.add(Blocks.field_150424_aL);
      blocklist.add(Blocks.field_150377_bs);
      blocklist.add(Blocks.field_150405_ch);
      blocklist.add(Blocks.field_150406_ce);
      blocklist.add(RivalRebels.reactive);
   }

   private class RhodesAction {
      public int action;
      public int duration;

      public RhodesAction(int a, int d) {
         this.action = a;
         this.duration = d;
      }
   }
}
