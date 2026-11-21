package assets.rivalrebels;

import assets.rivalrebels.client.gui.RivalRebelsRenderOverlay;
import assets.rivalrebels.client.itemrenders.AstroBlasterRenderer;
import assets.rivalrebels.client.itemrenders.BatteryRenderer;
import assets.rivalrebels.client.itemrenders.BinocularsRenderer;
import assets.rivalrebels.client.itemrenders.EmptyRodRenderer;
import assets.rivalrebels.client.itemrenders.FlamethrowerRenderer;
import assets.rivalrebels.client.itemrenders.GasRenderer;
import assets.rivalrebels.client.itemrenders.HackRocketLauncherRenderer;
import assets.rivalrebels.client.itemrenders.HydrogenRodRenderer;
import assets.rivalrebels.client.itemrenders.LaptopRenderer;
import assets.rivalrebels.client.itemrenders.LoaderRenderer;
import assets.rivalrebels.client.itemrenders.NuclearRodRenderer;
import assets.rivalrebels.client.itemrenders.PlasmaCannonRenderer;
import assets.rivalrebels.client.itemrenders.ReactorRenderer;
import assets.rivalrebels.client.itemrenders.RedstoneRodRenderer;
import assets.rivalrebels.client.itemrenders.RocketLauncherRenderer;
import assets.rivalrebels.client.itemrenders.RocketRenderer;
import assets.rivalrebels.client.itemrenders.RodDiskRenderer;
import assets.rivalrebels.client.itemrenders.RodaRenderer;
import assets.rivalrebels.client.itemrenders.SeekRocketLauncherRenderer;
import assets.rivalrebels.client.itemrenders.TeslaRenderer;
import assets.rivalrebels.client.model.RenderLibrary;
import assets.rivalrebels.common.block.BlockCamo1;
import assets.rivalrebels.common.block.BlockCamo2;
import assets.rivalrebels.common.block.BlockCamo3;
import assets.rivalrebels.common.block.BlockConduit;
import assets.rivalrebels.common.block.BlockCycle;
import assets.rivalrebels.common.block.BlockForceShield;
import assets.rivalrebels.common.block.BlockGore;
import assets.rivalrebels.common.block.BlockLight;
import assets.rivalrebels.common.block.BlockMeltDown;
import assets.rivalrebels.common.block.BlockPlasmaExplosion;
import assets.rivalrebels.common.block.BlockReactive;
import assets.rivalrebels.common.block.BlockSmartCamo;
import assets.rivalrebels.common.block.BlockSteel;
import assets.rivalrebels.common.block.autobuilds.BlockAutoBarricade;
import assets.rivalrebels.common.block.autobuilds.BlockAutoBunker;
import assets.rivalrebels.common.block.autobuilds.BlockAutoEaster;
import assets.rivalrebels.common.block.autobuilds.BlockAutoForceField;
import assets.rivalrebels.common.block.autobuilds.BlockAutoMarioTrap;
import assets.rivalrebels.common.block.autobuilds.BlockAutoMineTrap;
import assets.rivalrebels.common.block.autobuilds.BlockAutoQuickSandTrap;
import assets.rivalrebels.common.block.autobuilds.BlockAutoTower;
import assets.rivalrebels.common.block.autobuilds.BlockGameStart;
import assets.rivalrebels.common.block.autobuilds.BlockRhodesScaffold;
import assets.rivalrebels.common.block.crate.BlockAmmunition;
import assets.rivalrebels.common.block.crate.BlockExplosives;
import assets.rivalrebels.common.block.crate.BlockFlag;
import assets.rivalrebels.common.block.crate.BlockFlagBox1;
import assets.rivalrebels.common.block.crate.BlockFlagBox3;
import assets.rivalrebels.common.block.crate.BlockFlagBox4;
import assets.rivalrebels.common.block.crate.BlockFlagBox5;
import assets.rivalrebels.common.block.crate.BlockFlagBox6;
import assets.rivalrebels.common.block.crate.BlockFlagBox7;
import assets.rivalrebels.common.block.crate.BlockNukeCrate;
import assets.rivalrebels.common.block.crate.BlockOmegaArmor;
import assets.rivalrebels.common.block.crate.BlockSigmaArmor;
import assets.rivalrebels.common.block.crate.BlockSupplies;
import assets.rivalrebels.common.block.crate.BlockWeapons;
import assets.rivalrebels.common.block.machine.BlockBreadBox;
import assets.rivalrebels.common.block.machine.BlockForceField;
import assets.rivalrebels.common.block.machine.BlockForceFieldNode;
import assets.rivalrebels.common.block.machine.BlockLaptop;
import assets.rivalrebels.common.block.machine.BlockLoader;
import assets.rivalrebels.common.block.machine.BlockOmegaObjective;
import assets.rivalrebels.common.block.machine.BlockReactor;
import assets.rivalrebels.common.block.machine.BlockReciever;
import assets.rivalrebels.common.block.machine.BlockRhodesActivator;
import assets.rivalrebels.common.block.machine.BlockSigmaObjective;
import assets.rivalrebels.common.block.trap.BlockAntimatterBomb;
import assets.rivalrebels.common.block.trap.BlockFlare;
import assets.rivalrebels.common.block.trap.BlockJump;
import assets.rivalrebels.common.block.trap.BlockLandMine;
import assets.rivalrebels.common.block.trap.BlockMario;
import assets.rivalrebels.common.block.trap.BlockNuclearBomb;
import assets.rivalrebels.common.block.trap.BlockPetrifiedStone;
import assets.rivalrebels.common.block.trap.BlockPetrifiedWood;
import assets.rivalrebels.common.block.trap.BlockQuickSand;
import assets.rivalrebels.common.block.trap.BlockRadioactiveDirt;
import assets.rivalrebels.common.block.trap.BlockRadioactiveSand;
import assets.rivalrebels.common.block.trap.BlockRemoteCharge;
import assets.rivalrebels.common.block.trap.BlockTachyonBomb;
import assets.rivalrebels.common.block.trap.BlockTheoreticalTsarBomba;
import assets.rivalrebels.common.block.trap.BlockTimedBomb;
import assets.rivalrebels.common.block.trap.BlockToxicGas;
import assets.rivalrebels.common.block.trap.BlockTsarBomba;
import assets.rivalrebels.common.command.CommandConfig;
import assets.rivalrebels.common.command.CommandContinueRound;
import assets.rivalrebels.common.command.CommandHotPotato;
import assets.rivalrebels.common.command.CommandInspect;
import assets.rivalrebels.common.command.CommandKillAll;
import assets.rivalrebels.common.command.CommandKillme;
import assets.rivalrebels.common.command.CommandMotD;
import assets.rivalrebels.common.command.CommandPassword;
import assets.rivalrebels.common.command.CommandPlaySound;
import assets.rivalrebels.common.command.CommandResetGame;
import assets.rivalrebels.common.command.CommandRobot;
import assets.rivalrebels.common.command.CommandStopRounds;
import assets.rivalrebels.common.core.RivalRebelsGuiHandler;
import assets.rivalrebels.common.core.RivalRebelsRecipes;
import assets.rivalrebels.common.core.RivalRebelsSoundEventHandler;
import assets.rivalrebels.common.core.RivalRebelsTab;
import assets.rivalrebels.common.core.RivalRebelsTranslations;
import assets.rivalrebels.common.entity.EntityAntimatterBomb;
import assets.rivalrebels.common.entity.EntityAntimatterBombBlast;
import assets.rivalrebels.common.entity.EntityB2Frag;
import assets.rivalrebels.common.entity.EntityB2Spirit;
import assets.rivalrebels.common.entity.EntityB83;
import assets.rivalrebels.common.entity.EntityB83NoShroom;
import assets.rivalrebels.common.entity.EntityBlood;
import assets.rivalrebels.common.entity.EntityBomb;
import assets.rivalrebels.common.entity.EntityCuchillo;
import assets.rivalrebels.common.entity.EntityDebris;
import assets.rivalrebels.common.entity.EntityFlameBall;
import assets.rivalrebels.common.entity.EntityFlameBall1;
import assets.rivalrebels.common.entity.EntityFlameBall2;
import assets.rivalrebels.common.entity.EntityFlameBallGreen;
import assets.rivalrebels.common.entity.EntityGasGrenade;
import assets.rivalrebels.common.entity.EntityGoo;
import assets.rivalrebels.common.entity.EntityGore;
import assets.rivalrebels.common.entity.EntityHackB83;
import assets.rivalrebels.common.entity.EntityHotPotato;
import assets.rivalrebels.common.entity.EntityLaptop;
import assets.rivalrebels.common.entity.EntityLaserBurst;
import assets.rivalrebels.common.entity.EntityLaserLink;
import assets.rivalrebels.common.entity.EntityLightningLink;
import assets.rivalrebels.common.entity.EntityNuclearBlast;
import assets.rivalrebels.common.entity.EntityNuke;
import assets.rivalrebels.common.entity.EntityPassiveFire;
import assets.rivalrebels.common.entity.EntityPlasmoid;
import assets.rivalrebels.common.entity.EntityPropulsionFX;
import assets.rivalrebels.common.entity.EntityRaytrace;
import assets.rivalrebels.common.entity.EntityRhodes;
import assets.rivalrebels.common.entity.EntityRhodesHead;
import assets.rivalrebels.common.entity.EntityRhodesLeftLowerArm;
import assets.rivalrebels.common.entity.EntityRhodesLeftLowerLeg;
import assets.rivalrebels.common.entity.EntityRhodesLeftUpperArm;
import assets.rivalrebels.common.entity.EntityRhodesLeftUpperLeg;
import assets.rivalrebels.common.entity.EntityRhodesRightLowerArm;
import assets.rivalrebels.common.entity.EntityRhodesRightLowerLeg;
import assets.rivalrebels.common.entity.EntityRhodesRightUpperArm;
import assets.rivalrebels.common.entity.EntityRhodesRightUpperLeg;
import assets.rivalrebels.common.entity.EntityRhodesTorso;
import assets.rivalrebels.common.entity.EntityRocket;
import assets.rivalrebels.common.entity.EntityRoddiskLeader;
import assets.rivalrebels.common.entity.EntityRoddiskOfficer;
import assets.rivalrebels.common.entity.EntityRoddiskRebel;
import assets.rivalrebels.common.entity.EntityRoddiskRegular;
import assets.rivalrebels.common.entity.EntityRoddiskRep;
import assets.rivalrebels.common.entity.EntitySeekB83;
import assets.rivalrebels.common.entity.EntitySphereBlast;
import assets.rivalrebels.common.entity.EntityTachyonBomb;
import assets.rivalrebels.common.entity.EntityTachyonBombBlast;
import assets.rivalrebels.common.entity.EntityTarget;
import assets.rivalrebels.common.entity.EntityTheoreticalTsar;
import assets.rivalrebels.common.entity.EntityTheoreticalTsarBlast;
import assets.rivalrebels.common.entity.EntityTsar;
import assets.rivalrebels.common.entity.EntityTsarBlast;
import assets.rivalrebels.common.item.ItemAntenna;
import assets.rivalrebels.common.item.ItemArmorCamo;
import assets.rivalrebels.common.item.ItemBattery;
import assets.rivalrebels.common.item.ItemChip;
import assets.rivalrebels.common.item.ItemClassArmor;
import assets.rivalrebels.common.item.ItemCoreCopper;
import assets.rivalrebels.common.item.ItemCoreTitanium;
import assets.rivalrebels.common.item.ItemCoreTungsten;
import assets.rivalrebels.common.item.ItemExPill;
import assets.rivalrebels.common.item.ItemFuel;
import assets.rivalrebels.common.item.ItemFuse;
import assets.rivalrebels.common.item.ItemPliers;
import assets.rivalrebels.common.item.ItemRemote;
import assets.rivalrebels.common.item.ItemRocket;
import assets.rivalrebels.common.item.ItemRodEmpty;
import assets.rivalrebels.common.item.ItemRodHydrogen;
import assets.rivalrebels.common.item.ItemRodNuclear;
import assets.rivalrebels.common.item.ItemRodRedstone;
import assets.rivalrebels.common.item.ItemSafePill;
import assets.rivalrebels.common.item.ItemTrollHelmet;
import assets.rivalrebels.common.item.weapon.ItemArmyShovel;
import assets.rivalrebels.common.item.weapon.ItemAstroBlaster;
import assets.rivalrebels.common.item.weapon.ItemBinoculars;
import assets.rivalrebels.common.item.weapon.ItemCamera;
import assets.rivalrebels.common.item.weapon.ItemCuchillo;
import assets.rivalrebels.common.item.weapon.ItemFlameThrower;
import assets.rivalrebels.common.item.weapon.ItemGasGrenade;
import assets.rivalrebels.common.item.weapon.ItemHackM202;
import assets.rivalrebels.common.item.weapon.ItemPlasmaCannon;
import assets.rivalrebels.common.item.weapon.ItemRPG;
import assets.rivalrebels.common.item.weapon.ItemRodDisk;
import assets.rivalrebels.common.item.weapon.ItemRoda;
import assets.rivalrebels.common.item.weapon.ItemSeekM202;
import assets.rivalrebels.common.item.weapon.ItemTesla;
import assets.rivalrebels.common.packet.PacketDispatcher;
import assets.rivalrebels.common.round.RivalRebelsRound;
import assets.rivalrebels.common.tileentity.TileEntityAntimatterBomb;
import assets.rivalrebels.common.tileentity.TileEntityConduit;
import assets.rivalrebels.common.tileentity.TileEntityForceFieldNode;
import assets.rivalrebels.common.tileentity.TileEntityGore;
import assets.rivalrebels.common.tileentity.TileEntityJumpBlock;
import assets.rivalrebels.common.tileentity.TileEntityLaptop;
import assets.rivalrebels.common.tileentity.TileEntityLoader;
import assets.rivalrebels.common.tileentity.TileEntityMeltDown;
import assets.rivalrebels.common.tileentity.TileEntityNuclearBomb;
import assets.rivalrebels.common.tileentity.TileEntityNukeCrate;
import assets.rivalrebels.common.tileentity.TileEntityOmegaObjective;
import assets.rivalrebels.common.tileentity.TileEntityPlasmaExplosion;
import assets.rivalrebels.common.tileentity.TileEntityReactive;
import assets.rivalrebels.common.tileentity.TileEntityReactor;
import assets.rivalrebels.common.tileentity.TileEntityReciever;
import assets.rivalrebels.common.tileentity.TileEntityRhodesActivator;
import assets.rivalrebels.common.tileentity.TileEntitySigmaObjective;
import assets.rivalrebels.common.tileentity.TileEntityTachyonBomb;
import assets.rivalrebels.common.tileentity.TileEntityTheoreticalTsarBomba;
import assets.rivalrebels.common.tileentity.TileEntityTsarBomba;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLServerStoppedEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import java.io.File;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringTranslate;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = "rivalrebels", name = "Rival Rebels", version = "1.7.10Z1")
public class RivalRebels {
   public static final String MODID = "rivalrebels";
   public static final String rrname = "Rival Rebels";
   public static final String mcversion = "1.7.10";
   public static final String rrversion = "1.7.10Z1";
   public static final String packagename = "assets.rivalrebels.";
   @SidedProxy(clientSide = "assets.rivalrebels.ClientProxy", serverSide = "assets.rivalrebels.CommonProxy")
   public static CommonProxy proxy;
   @Instance("rivalrebels")
   public static RivalRebels instance;
   public Configuration config;
   public StringTranslate translator;
   public static RivalRebelsTab rralltab;
   public static RivalRebelsTab rrarmortab;
   public static RivalRebelsRound round;
   static ArmorMaterial armorCamo = EnumHelper.addArmorMaterial("Camo", 50, new int[]{2, 9, 5, 2}, 10);
   static ArmorMaterial armorCamo2 = EnumHelper.addArmorMaterial("Camo2", 50, new int[]{2, 9, 5, 2}, 10);
   static ArmorMaterial orebelarmor = EnumHelper.addArmorMaterial("rebelo", 150, new int[]{6, 18, 6, 6}, 6);
   static ArmorMaterial onukerarmor = EnumHelper.addArmorMaterial("nukero", 100, new int[]{8, 20, 8, 6}, 2);
   static ArmorMaterial ointelarmor = EnumHelper.addArmorMaterial("intelo", 80, new int[]{4, 11, 6, 5}, 10);
   static ArmorMaterial ohackerarmor = EnumHelper.addArmorMaterial("hackero", 60, new int[]{2, 11, 6, 5}, 10);
   static ArmorMaterial srebelarmor = EnumHelper.addArmorMaterial("rebels", 150, new int[]{6, 18, 6, 6}, 6);
   static ArmorMaterial snukerarmor = EnumHelper.addArmorMaterial("nukers", 100, new int[]{8, 20, 8, 6}, 2);
   static ArmorMaterial sintelarmor = EnumHelper.addArmorMaterial("intels", 80, new int[]{4, 11, 6, 5}, 10);
   static ArmorMaterial shackerarmor = EnumHelper.addArmorMaterial("hackers", 60, new int[]{2, 11, 6, 5}, 10);
   public static int teleportDist;
   public static boolean flareExplode;
   public static boolean infiniteAmmo;
   public static boolean infiniteNukes;
   public static boolean infiniteGrenades;
   public static int landmineExplodeSize;
   public static int chargeExplodeSize;
   public static int timedbombExplodeSize;
   public static int rpgExplodeSize;
   public static int flamethrowerDecay;
   public static int rpgDecay;
   public static int teslaDecay;
   public static int timedbombTimer;
   public static int nuclearBombCountdown;
   public static int nuclearBombStrength;
   public static int tsarBombaStrength;
   public static int b83Strength;
   public static int resetMax;
   public static int spawnradius;
   public static int bunkerradius;
   public static int objectivedistance;
   public static float knifeThrowStrengthDecay;
   public static int plasmoidDecay;
   public static int tsarBombaSpeed;
   public static int b2spirithealth;
   public static boolean rtarget;
   public static boolean lctarget;
   public static boolean bzoom;
   public static int roundsperreset;
   public static boolean goodRender;
   public static int teslasegments;
   public static boolean goreEnabled;
   public static boolean stopSelfnukeinSP;
   public static boolean freeb83nukes;
   public static boolean scoreboardenabled;
   public static boolean prefillrhodes;
   public static boolean altRkey;
   public static float rhodesChance;
   public static int rhodesHealth;
   public static int rhodesNukes;
   public static float rhodesRandom;
   public static int rhodesRandomSeed;
   public static int[] rhodesTeams;
   public static boolean rhodesPromode;
   public static boolean rhodesFF;
   public static boolean rhodesAI;
   public static boolean rhodesExit = true;
   public static boolean rhodesHold;
   public static boolean rhodesCC;
   public static int objectiveHealth;
   public static boolean freeDragonAmmo;
   public static int bombDamageToRhodes;
   public static boolean rhodesRoundsBase;
   public static boolean rhodesScaleSpeed;
   public static float rhodesSpeedScale;
   public static float rhodesBlockBreak;
   public static boolean nukedrop = true;
   public static boolean elevation = true;
   public static int nametagrange = 7;
   public static String bombertype = "b2";
   public static float nukeScale = 1.0F;
   public static float shroomScale = 1.0F;
   public static boolean antimatterFlash = true;
   public static Block amario;
   public static Block aquicksand;
   public static Block barricade;
   public static Block tower;
   public static Block easteregg;
   public static Block bunker;
   public static Block smartcamo;
   public static Block camo1;
   public static Block camo2;
   public static Block camo3;
   public static Block steel;
   public static Block flag1;
   public static Block flag2;
   public static Block flag3;
   public static Block flag4;
   public static Block flag5;
   public static Block flag6;
   public static Block flag7;
   public static Block flagbox1;
   public static Block flagbox5;
   public static Block flagbox6;
   public static Block flagbox3;
   public static Block flagbox4;
   public static Block flagbox7;
   public static Block sigmaarmor;
   public static Block omegaarmor;
   public static Block weapons;
   public static Block ammunition;
   public static Block explosives;
   public static Block supplies;
   public static Block mario;
   public static Block jump;
   public static Block quicksand;
   public static Block landmine;
   public static Block remotecharge;
   public static Block timedbomb;
   public static Block flare;
   public static Block light;
   public static Block light2;
   public static Block cycle;
   public static Block toxicgas;
   public static Block fshield;
   public static Block gamestart;
   public static Block breadbox;
   public static Block alandmine;
   public static Block nuclearBomb;
   public static Block nukeCrateTop;
   public static Block nukeCrateBottom;
   public static Block radioactivedirt;
   public static Block radioactivesand;
   public static Block plasmaexplosion;
   public static Block reactor;
   public static Block loader;
   public static Block omegaobj;
   public static Block sigmaobj;
   public static Block petrifiedwood;
   public static Block petrifiedstone1;
   public static Block petrifiedstone2;
   public static Block petrifiedstone3;
   public static Block petrifiedstone4;
   public static Block tsarbombablock;
   public static Block forcefieldnode;
   public static Block goreblock;
   public static Block reactive;
   public static Block bastion;
   public static Block conduit;
   public static Block controller;
   public static Block mariotrap;
   public static Block minetrap;
   public static Block quicksandtrap;
   public static Block forcefield;
   public static Block meltdown;
   public static Block ffreciever;
   public static Block buildrhodes;
   public static Block rhodesactivator;
   public static Block theoreticaltsarbombablock;
   public static Block antimatterbombblock;
   public static Block tachyonbombblock;
   public static Item rpg;
   public static Item flamethrower;
   public static Item tesla;
   public static Item einsten;
   public static Item rocket;
   public static Item fuel;
   public static Item battery;
   public static Item redrod;
   public static Item pliers;
   public static Item armyshovel;
   public static Item knife;
   public static Item gasgrenade;
   public static Item safepill;
   public static Item expill;
   public static Item remote;
   public static Item fuse;
   public static Item nuclearelement;
   public static Item hydrod;
   public static Item plasmacannon;
   public static Item roddisk;
   public static Item antenna;
   public static Item emptyrod;
   public static Item core1;
   public static Item core2;
   public static Item core3;
   public static Item binoculars;
   public static Item camera;
   public static Item b2spirit;
   public static Item chip;
   public static Item roda;
   public static Item nikolatesla;
   public static Item trollmask;
   public static Item hackm202;
   public static Item seekm202;
   public static Item orebelhelmet;
   public static Item orebelchest;
   public static Item orebelpants;
   public static Item orebelboots;
   public static Item onukerhelmet;
   public static Item onukerchest;
   public static Item onukerpants;
   public static Item onukerboots;
   public static Item ointelhelmet;
   public static Item ointelchest;
   public static Item ointelpants;
   public static Item ointelboots;
   public static Item ohackerhelmet;
   public static Item ohackerchest;
   public static Item ohackerpants;
   public static Item ohackerboots;
   public static Item srebelhelmet;
   public static Item srebelchest;
   public static Item srebelpants;
   public static Item srebelboots;
   public static Item snukerhelmet;
   public static Item snukerchest;
   public static Item snukerpants;
   public static Item snukerboots;
   public static Item sintelhelmet;
   public static Item sintelchest;
   public static Item sintelpants;
   public static Item sintelboots;
   public static Item shackerhelmet;
   public static Item shackerchest;
   public static Item shackerpants;
   public static Item shackerboots;
   public static Item camohat;
   public static Item camoshirt;
   public static Item camopants;
   public static Item camoshoes;
   public static Item camohat2;
   public static Item camoshirt2;
   public static Item camopants2;
   public static Item camoshoes2;
   public static ResourceLocation guitrivalrebels;
   public static ResourceLocation guitbutton;
   public static ResourceLocation guitspawn;
   public static ResourceLocation guitclass;
   public static ResourceLocation guitrebel;
   public static ResourceLocation guitnuker;
   public static ResourceLocation guitintel;
   public static ResourceLocation guithacker;
   public static ResourceLocation guitnuke;
   public static ResourceLocation guittsar;
   public static ResourceLocation guitwarning0;
   public static ResourceLocation guitwarning1;
   public static ResourceLocation guitloader;
   public static ResourceLocation guittokamak;
   public static ResourceLocation guibinoculars;
   public static ResourceLocation guibinocularsoverlay;
   public static ResourceLocation guilaptopnuke;
   public static ResourceLocation guitesla;
   public static ResourceLocation guitray;
   public static ResourceLocation guiflamethrower;
   public static ResourceLocation guirhodesline;
   public static ResourceLocation guirhodesout;
   public static ResourceLocation guirhodeshelp;
   public static ResourceLocation guicarpet;
   public static ResourceLocation guitheoreticaltsar;
   public static ResourceLocation guitantimatterbomb;
   public static ResourceLocation guitachyonbomb;
   public static ResourceLocation etdisk0;
   public static ResourceLocation etdisk1;
   public static ResourceLocation etdisk2;
   public static ResourceLocation etdisk3;
   public static ResourceLocation etrocket;
   public static ResourceLocation etfire;
   public static ResourceLocation etflame;
   public static ResourceLocation etgasgrenade;
   public static ResourceLocation etknife;
   public static ResourceLocation etloader;
   public static ResourceLocation etomegaobj;
   public static ResourceLocation etsigmaobj;
   public static ResourceLocation etplasmacannon;
   public static ResourceLocation ethydrod;
   public static ResourceLocation etradrod;
   public static ResourceLocation etredrod;
   public static ResourceLocation ettroll;
   public static ResourceLocation etreactor;
   public static ResourceLocation etlaptop;
   public static ResourceLocation etubuntu;
   public static ResourceLocation etscreen;
   public static ResourceLocation ettsarshell;
   public static ResourceLocation ettsarfins;
   public static ResourceLocation ettsarflame;
   public static ResourceLocation etnuke;
   public static ResourceLocation etnukepillar;
   public static ResourceLocation etradiation;
   public static ResourceLocation eteinstenbarrel;
   public static ResourceLocation eteinstenback;
   public static ResourceLocation eteinstenhandle;
   public static ResourceLocation etblood;
   public static ResourceLocation etgoo;
   public static ResourceLocation etcorona;
   public static ResourceLocation etemptyrod;
   public static ResourceLocation etzombie;
   public static ResourceLocation etrocketlauncherbody;
   public static ResourceLocation etrocketlauncherhandle;
   public static ResourceLocation etrocketlaunchertube;
   public static ResourceLocation etbinoculars;
   public static ResourceLocation etelectrode;
   public static ResourceLocation etb83;
   public static ResourceLocation etb2spirit;
   public static ResourceLocation etrust;
   public static ResourceLocation etreciever;
   public static ResourceLocation ettesla;
   public static ResourceLocation etbattery;
   public static ResourceLocation etflamethrower;
   public static ResourceLocation ettube;
   public static ResourceLocation etadsdragon;
   public static ResourceLocation etflamecone;
   public static ResourceLocation etflameball;
   public static ResourceLocation etflamebluered;
   public static ResourceLocation etflameblue;
   public static ResourceLocation ethack202;
   public static ResourceLocation etseek202;
   public static ResourceLocation etrocketseek202;
   public static ResourceLocation etrocketseekhandle202;
   public static ResourceLocation etrocketseektube202;
   public static ResourceLocation ettheoreticaltsarshell1;
   public static ResourceLocation ettheoreticaltsarshell2;
   public static ResourceLocation etblacktsar;
   public static ResourceLocation etwacknuke;
   public static ResourceLocation ettupolev;
   public static ResourceLocation etbooster;
   public static ResourceLocation etflameballgreen;
   public static ResourceLocation etantimatterbomb;
   public static ResourceLocation etantimatterblast;
   public static ResourceLocation ettachyonbomb;
   public static ResourceLocation btcrate;
   public static ResourceLocation btnuketop;
   public static ResourceLocation btnukebottom;
   public static ResourceLocation btsteel;
   public static ResourceLocation btsplash1;
   public static ResourceLocation btsplash2;
   public static ResourceLocation btsplash3;
   public static ResourceLocation btsplash4;
   public static ResourceLocation btsplash5;
   public static ResourceLocation btsplash6;
   public static ResourceLocation ittaskb83;
   public static ResourceLocation banner;
   public static String bannerName;
   public static RivalRebelsRenderOverlay rrro;
   public static boolean optiFineWarn = false;
   public static String[] modblacklist;
   public static boolean enforceblacklist = true;

   @EventHandler
   public void PreInit(FMLPreInitializationEvent event) {
      this.config = new Configuration(event.getSuggestedConfigurationFile());
      this.config.load();
      if (!this.config.get("Version", "RRVersion", "1.7.10Z1").getString().equals("1.7.10Z1")) {
         this.config.save();
         File file = new File("config/rivalrebels.cfg");
         file.delete();
         this.config = new Configuration(event.getSuggestedConfigurationFile());
         this.config.load();
         this.config.get("Version", "RRVersion", "1.7.10Z1");
      }

      teleportDist = this.config.get("buildsize", "TeleportDistance", 150).getInt();
      spawnradius = this.config.get("buildsize", "SpawnDomeRadius", 20).getInt();
      bunkerradius = this.config.get("buildsize", "BunkerRadius", 10).getInt();
      objectivedistance = this.config.get("buildsize", "objectivedistance", 200).getInt();
      this.config.addCustomCategoryComment("buildsize", "Measured in blocks.");
      flareExplode = this.config.get("misc", "FlareExplodeOnBreak", true).getBoolean(true);
      infiniteAmmo = this.config.get("misc", "InfiniteAmmo", false).getBoolean(false);
      infiniteNukes = this.config.get("misc", "InfiniteNukes", false).getBoolean(false);
      infiniteGrenades = this.config.get("misc", "InfiniteGrenades", false).getBoolean(false);
      boolean safemode = this.config.get("misc", "safemode", true).getBoolean(true);
      resetMax = this.config.get("misc", "MaximumResets", 2).getInt();
      b2spirithealth = this.config.get("misc", "B2SpiritHealth", 1000).getInt();
      rtarget = this.config.get("misc", "RKeyTarget", true).getBoolean(true);
      lctarget = this.config.get("misc", "LeftClickTarget", true).getBoolean(true);
      bzoom = this.config.get("misc", "BKeyZoom", true).getBoolean(true);
      goodRender = !this.config.get("misc", "HBLaptop", false).getBoolean(false);
      teslasegments = this.config.get("misc", "teslasegments", 2).getInt();
      goreEnabled = this.config.get("misc", "goreEnabled", true).getBoolean(true);
      stopSelfnukeinSP = this.config.get("misc", "stopSelfnukeinSinglePlayer", false).getBoolean(false);
      freeb83nukes = this.config.get("misc", "freeb83nukes", false).getBoolean(false);
      scoreboardenabled = this.config.get("misc", "scoreboardEnabled", true).getBoolean(true);
      prefillrhodes = this.config.get("misc", "prefillrhodes", true).getBoolean(true);
      altRkey = this.config.get("misc", "useFkeyInsteadofRkey", false).getBoolean(false);
      rhodesChance = this.config.get("misc", "rhodesInRoundsChance", 0).getInt() / 100.0F;
      rhodesRoundsBase = this.config.get("misc", "rhodesInRoundsBase", true).getBoolean(false);
      rhodesHealth = this.config.get("misc", "rhodesHealth", 15000).getInt();
      rhodesNukes = this.config.get("misc", "rhodesNukes", 8).getInt();
      rhodesTeams = this.config
         .get(
            "misc",
            "rhodesTeams",
            new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15},
            "Range: 0-15. Repeat the numbers for multiple occurences of the same rhodes. 0:Rhodes 1:Magnesium 2:Arsenic 3:Vanadium 4:Aurum 5:Iodine 6:Iron 7:Astatine 8:Cobalt 9:Strontium 10:Bismuth 11:Zinc 12:Osmium 13:Neon 14:Argent, 15:Wolfram"
         )
         .getIntList();
      rhodesRandom = this.config.getFloat("rhodesRandom", "misc", 1.0F, 0.0F, 5.0F, "Multiplies the Rhodes' random ammo bonus. Set to 0 to disable bonus.");
      rhodesRandomSeed = this.config.get("misc", "rhodesRandomSeed", 2168344).getInt();
      rhodesFF = this.config.get("misc", "rhodesFriendlyFire", true).getBoolean(true);
      rhodesAI = this.config.get("misc", "rhodesAIEnabled", true).getBoolean(true);
      rhodesCC = this.config.get("misc", "rhodesTeamFriendlyFire", true).getBoolean(true);
      rhodesPromode = this.config.get("misc", "rhodesPromode", false).getBoolean(false);
      bombertype = this.config.get("misc", "BomberType", "b2", "For the B2 bomber, set to 'b2', for Warfare Shuttle 'sh', for Tupolev-95 'tu'.").getString();
      objectiveHealth = this.config.get("misc", "objectiveHealth", 15000).getInt();
      freeDragonAmmo = this.config.get("misc", "freeDragonAmmo", false).getBoolean(false);
      bombDamageToRhodes = this.config.get("misc", "bombDamageToRhodes", 20).getInt();
      rhodesScaleSpeed = this.config.get("misc", "rhodesScaleSpeed", false).getBoolean(false);
      rhodesSpeedScale = (float)this.config.get("misc", "rhodesSpeedScale", 1.0).getDouble(1.0);
      rhodesBlockBreak = (float)this.config.get("misc", "rhodesBlockBreak", 1.0).getDouble(1.0);
      nametagrange = this.config.get("misc", "nametagrange", 7).getInt();
      if (nametagrange > 7) {
         nametagrange = 7;
      }

      this.config.addCustomCategoryComment("misc", "Miscellaneous.");
      String tempstring = this.config.get("modblacklist", "modblacklist", "").getString().toLowerCase();
      modblacklist = tempstring.split(",");
      enforceblacklist = tempstring.length() > 0;
      this.config
         .addCustomCategoryComment(
            "modblacklist",
            "Write illegal mods in comma separated format. Not case sensitive, use nonplural for more matches eg. hack instead of hacks. Do not put spaces unless intended for matching the spaces in mod names. Example: hack,xray,x-ray,x ray,cheat,fly,wireframe,wire-frame,wire frame"
         );
      landmineExplodeSize = this.config.get("explosionsize", "LandmineExplosionSize", 2).getInt();
      chargeExplodeSize = this.config.get("explosionsize", "ChargeExplosionSize", 5).getInt();
      timedbombExplodeSize = this.config.get("explosionsize", "TimedBombExplosionSize", 6).getInt();
      rpgExplodeSize = this.config.get("explosionsize", "RocketExplosionSize", 4).getInt();
      nuclearBombStrength = this.config.get("explosionsize", "NuclearBombStrength", 10).getInt();
      tsarBombaStrength = this.config.get("explosionsize", "tsarBombaStrength", 24).getInt();
      b83Strength = this.config.get("explosionsize", "b83Strength", 15).getInt();
      tsarBombaSpeed = this.config.get("explosionsize", "tsarBombaSpeed", 8).getInt();
      elevation = this.config.get("explosionsize", "elevation", true).getBoolean(true);
      nukedrop = this.config.get("explosionsize", "nukedrop", true).getBoolean(true);
      antimatterFlash = this.config.get("explosionsize", "antimatterFlash", true).getBoolean(true);
      nukeScale = (float)this.config.get("explosionsize", "nukeScale", 1.0).getDouble(1.0);
      shroomScale = (float)this.config.get("explosionsize", "shroomScale", 1.0).getDouble(1.0);
      this.config.addCustomCategoryComment("explosionsize", "Measured in blocks. Nuclear bomb just adds the specified number to its calculation.");
      flamethrowerDecay = this.config.get("decay", "FlamethrowerDecay", 64).getInt();
      rpgDecay = this.config.get("decay", "RPGDecay", 200).getInt();
      plasmoidDecay = this.config.get("decay", "plasmoidDecay", 70).getInt();
      teslaDecay = this.config.get("decay", "TeslaDecay", 250).getInt();
      knifeThrowStrengthDecay = this.config.get("decay", "KnifeThrowStrengthDecay", 91).getInt() / 100.0F;
      this.config.addCustomCategoryComment("decay", "Measured in ticks of existence. Tesla is in blocks.");
      timedbombTimer = this.config.get("timing", "TimedBombSeconds", 25).getInt();
      nuclearBombCountdown = this.config.get("timing", "NuclearBombCountdown", 25).getInt();
      this.config.addCustomCategoryComment("timing", "Measured in seconds.");
      this.config.save();
      if (safemode) {
         this.limitConfigValues();
      }

      instance = this;
      rralltab = new RivalRebelsTab("Rival Rebels", 0);
      rrarmortab = new RivalRebelsTab("Rival Rebels", 1);
      this.registerTextures();
      this.registerEntities();
      this.registerBlocks();
      this.registerItems();
      this.registerArmor();
      RivalRebelsRecipes.registerRecipes();
      this.registerGuis();
      this.registerClientSide(event);
      RivalRebelsTranslations.registerLanguage();
      PacketDispatcher.registerPackets();
      FMLCommonHandler.instance().bus().register(round = new RivalRebelsRound(spawnradius, teleportDist, objectivedistance));
   }

   @EventHandler
   public void onServerStart(FMLServerStartedEvent event) {
      round.load();
   }

   @EventHandler
   public void onServerStop(FMLServerStoppedEvent event) {
      round.save();
   }

   public void limitConfigValues() {
      if (teleportDist <= 70) {
         teleportDist = 70;
      }

      if (teleportDist >= 500) {
         teleportDist = 500;
      }

      if (landmineExplodeSize <= 1) {
         landmineExplodeSize = 1;
      }

      if (landmineExplodeSize >= 15) {
         landmineExplodeSize = 15;
      }

      if (chargeExplodeSize <= 1) {
         chargeExplodeSize = 1;
      }

      if (chargeExplodeSize >= 15) {
         chargeExplodeSize = 15;
      }

      if (timedbombExplodeSize <= 1) {
         timedbombExplodeSize = 1;
      }

      if (timedbombExplodeSize >= 20) {
         timedbombExplodeSize = 20;
      }

      if (rpgExplodeSize <= 1) {
         rpgExplodeSize = 1;
      }

      if (rpgExplodeSize >= 10) {
         rpgExplodeSize = 10;
      }

      if (teslaDecay <= 20) {
         teslaDecay = 20;
      }

      if (teslaDecay >= 400) {
         teslaDecay = 400;
      }

      if (timedbombTimer <= 10) {
         timedbombTimer = 10;
      }

      if (timedbombTimer >= 300) {
         timedbombTimer = 300;
      }

      if (nuclearBombCountdown <= 1) {
         nuclearBombCountdown = 1;
      }

      if (nuclearBombStrength <= 2) {
         nuclearBombStrength = 2;
      }

      if (nuclearBombStrength >= 30) {
         nuclearBombStrength = 30;
      }

      if (tsarBombaStrength <= 0) {
         tsarBombaStrength = 0;
      }

      if (tsarBombaStrength >= 50) {
         tsarBombaStrength = 50;
      }

      if (b83Strength <= 0) {
         b83Strength = 0;
      }

      if (b83Strength >= 50) {
         b83Strength = 50;
      }

      if (resetMax >= 100) {
         resetMax = 100;
      }

      if (resetMax <= 0) {
         resetMax = 0;
      }

      if (spawnradius >= 30) {
         spawnradius = 30;
      }

      if (spawnradius <= 10) {
         spawnradius = 10;
      }

      if (bunkerradius >= 15) {
         bunkerradius = 15;
      }

      if (bunkerradius <= 7) {
         bunkerradius = 7;
      }

      if (knifeThrowStrengthDecay <= 0.8F) {
         knifeThrowStrengthDecay = 0.8F;
      }

      if (knifeThrowStrengthDecay >= 1.0F) {
         knifeThrowStrengthDecay = 1.0F;
      }

      if (tsarBombaSpeed <= 4) {
         tsarBombaSpeed = 4;
      }

      if (rhodesHealth < 15000) {
         rhodesHealth = 15000;
      }
   }

   private void registerTextures() {
      Loader.instance().getModList().iterator().next();
      guitbutton = new ResourceLocation("rivalrebels:textures/gui/a.png");
      guitspawn = new ResourceLocation("rivalrebels:textures/gui/b.png");
      guitclass = new ResourceLocation("rivalrebels:textures/gui/c.png");
      guitrebel = new ResourceLocation("rivalrebels:textures/gui/d.png");
      guitnuker = new ResourceLocation("rivalrebels:textures/gui/e.png");
      guitintel = new ResourceLocation("rivalrebels:textures/gui/f.png");
      guithacker = new ResourceLocation("rivalrebels:textures/gui/g.png");
      guitrivalrebels = new ResourceLocation("rivalrebels:textures/gui/h.png");
      guitloader = new ResourceLocation("rivalrebels:textures/gui/i.png");
      guitnuke = new ResourceLocation("rivalrebels:textures/gui/j.png");
      guittsar = new ResourceLocation("rivalrebels:textures/gui/k.png");
      guitwarning0 = new ResourceLocation("rivalrebels:textures/gui/l.png");
      guitwarning1 = new ResourceLocation("rivalrebels:textures/gui/m.png");
      guittokamak = new ResourceLocation("rivalrebels:textures/gui/n.png");
      guibinoculars = new ResourceLocation("rivalrebels:textures/gui/o.png");
      guibinocularsoverlay = new ResourceLocation("rivalrebels:textures/gui/p.png");
      guilaptopnuke = new ResourceLocation("rivalrebels:textures/gui/q.png");
      guitesla = new ResourceLocation("rivalrebels:textures/gui/r.png");
      guitray = new ResourceLocation("rivalrebels:textures/gui/s.png");
      guiflamethrower = new ResourceLocation("rivalrebels:textures/gui/u.png");
      guirhodesline = new ResourceLocation("rivalrebels:textures/gui/rhodes-gui_line.png");
      guirhodesout = new ResourceLocation("rivalrebels:textures/gui/rhodes-gui_out.png");
      guirhodeshelp = new ResourceLocation("rivalrebels:textures/gui/rhodes-gui_help.png");
      guicarpet = new ResourceLocation("rivalrebels:textures/gui/v.png");
      guitheoreticaltsar = new ResourceLocation("rivalrebels:textures/gui/w.png");
      guitantimatterbomb = new ResourceLocation("rivalrebels:textures/gui/x.png");
      guitachyonbomb = new ResourceLocation("rivalrebels:textures/gui/y.png");
      etdisk0 = new ResourceLocation("rivalrebels:textures/entity/ba.png");
      etdisk1 = new ResourceLocation("rivalrebels:textures/entity/bb.png");
      etdisk2 = new ResourceLocation("rivalrebels:textures/entity/bc.png");
      etdisk3 = new ResourceLocation("rivalrebels:textures/entity/bd.png");
      etrocket = new ResourceLocation("rivalrebels:textures/entity/az.png");
      etfire = new ResourceLocation("rivalrebels:textures/entity/ar.png");
      etflame = new ResourceLocation("rivalrebels:textures/entity/as.png");
      etgasgrenade = new ResourceLocation("rivalrebels:textures/entity/bf.png");
      etknife = new ResourceLocation("rivalrebels:textures/entity/be.png");
      etloader = new ResourceLocation("rivalrebels:textures/entity/ac.png");
      etomegaobj = new ResourceLocation("rivalrebels:textures/entity/aa.png");
      etsigmaobj = new ResourceLocation("rivalrebels:textures/entity/ab.png");
      etplasmacannon = new ResourceLocation("rivalrebels:textures/entity/ay.png");
      ethydrod = new ResourceLocation("rivalrebels:textures/entity/ao.png");
      etradrod = new ResourceLocation("rivalrebels:textures/entity/an.png");
      etredrod = new ResourceLocation("rivalrebels:textures/entity/ap.png");
      etemptyrod = new ResourceLocation("rivalrebels:textures/entity/aq.png");
      ettroll = new ResourceLocation("rivalrebels:textures/entity/am.png");
      etreactor = new ResourceLocation("rivalrebels:textures/entity/ad.png");
      etlaptop = new ResourceLocation("rivalrebels:textures/entity/ah.png");
      etubuntu = new ResourceLocation("rivalrebels:textures/entity/aj.png");
      etscreen = new ResourceLocation("rivalrebels:textures/entity/ai.png");
      ettsarshell = new ResourceLocation("rivalrebels:textures/entity/af.png");
      ettsarfins = new ResourceLocation("rivalrebels:textures/entity/ag.png");
      ettsarflame = new ResourceLocation("rivalrebels:textures/entity/al.png");
      etnuke = new ResourceLocation("rivalrebels:textures/entity/ae.png");
      etradiation = new ResourceLocation("rivalrebels:textures/entity/ak.png");
      eteinstenbarrel = new ResourceLocation("rivalrebels:textures/entity/av.png");
      eteinstenback = new ResourceLocation("rivalrebels:textures/entity/aw.png");
      eteinstenhandle = new ResourceLocation("rivalrebels:textures/entity/ax.png");
      etblood = new ResourceLocation("rivalrebels:textures/entity/at.png");
      etgoo = new ResourceLocation("rivalrebels:textures/entity/au.png");
      etrocketlauncherbody = new ResourceLocation("rivalrebels:textures/entity/bh.png");
      etrocketlauncherhandle = new ResourceLocation("rivalrebels:textures/entity/bg.png");
      etrocketlaunchertube = new ResourceLocation("rivalrebels:textures/entity/bi.png");
      etbinoculars = new ResourceLocation("rivalrebels:textures/entity/bj.png");
      etelectrode = new ResourceLocation("rivalrebels:textures/entity/bk.png");
      etb83 = new ResourceLocation("rivalrebels:textures/entity/bl.png");
      etb2spirit = new ResourceLocation("rivalrebels:textures/entity/bm.png");
      etrust = new ResourceLocation("rivalrebels:textures/entity/bn.png");
      etreciever = new ResourceLocation("rivalrebels:textures/entity/bo.png");
      ettesla = new ResourceLocation("rivalrebels:textures/entity/bp.png");
      etbattery = new ResourceLocation("rivalrebels:textures/entity/bq.png");
      ettube = new ResourceLocation("rivalrebels:textures/entity/br.png");
      etadsdragon = new ResourceLocation("rivalrebels:textures/entity/bs.png");
      etflamethrower = new ResourceLocation("rivalrebels:textures/entity/bt.png");
      etflamecone = new ResourceLocation("rivalrebels:textures/entity/bu.png");
      etflameball = new ResourceLocation("rivalrebels:textures/entity/bv.png");
      etflameblue = new ResourceLocation("rivalrebels:textures/entity/bw.png");
      etflamebluered = new ResourceLocation("rivalrebels:textures/entity/bx.png");
      ethack202 = new ResourceLocation("rivalrebels:textures/entity/by.png");
      etseek202 = new ResourceLocation("rivalrebels:textures/entity/bz.png");
      etrocketseek202 = new ResourceLocation("rivalrebels:textures/entity/ca.png");
      etrocketseekhandle202 = new ResourceLocation("rivalrebels:textures/entity/cb.png");
      etrocketseektube202 = new ResourceLocation("rivalrebels:textures/entity/cc.png");
      ettheoreticaltsarshell1 = new ResourceLocation("rivalrebels:textures/entity/cd.png");
      ettheoreticaltsarshell2 = new ResourceLocation("rivalrebels:textures/entity/ce.png");
      etblacktsar = new ResourceLocation("rivalrebels:textures/entity/cf.png");
      etwacknuke = new ResourceLocation("rivalrebels:textures/entity/cg.png");
      etflameballgreen = new ResourceLocation("rivalrebels:textures/entity/ch.png");
      etantimatterbomb = new ResourceLocation("rivalrebels:textures/entity/ci.png");
      ettupolev = new ResourceLocation("rivalrebels:textures/entity/tupolev.png");
      etbooster = new ResourceLocation("rivalrebels:textures/entity/booster.png");
      etantimatterblast = new ResourceLocation("rivalrebels:textures/entity/cj.png");
      ettachyonbomb = new ResourceLocation("rivalrebels:textures/entity/ck.png");
      btcrate = new ResourceLocation("rivalrebels:textures/blocks/ah.png");
      btnuketop = new ResourceLocation("rivalrebels:textures/blocks/ay.png");
      btnukebottom = new ResourceLocation("rivalrebels:textures/blocks/ax.png");
      btsteel = new ResourceLocation("rivalrebels:textures/blocks/bx.png");
      btsplash1 = new ResourceLocation("rivalrebels:textures/blocks/br.png");
      btsplash2 = new ResourceLocation("rivalrebels:textures/blocks/bs.png");
      btsplash3 = new ResourceLocation("rivalrebels:textures/blocks/bt.png");
      btsplash4 = new ResourceLocation("rivalrebels:textures/blocks/bu.png");
      btsplash5 = new ResourceLocation("rivalrebels:textures/blocks/bv.png");
      btsplash6 = new ResourceLocation("rivalrebels:textures/blocks/bw.png");
      ittaskb83 = new ResourceLocation("rivalrebels:textures/items/bc.png");
   }

   private void registerClientSide(FMLPreInitializationEvent event) {
      if (event.getSide().isClient()) {
         optiFineWarn = FMLClientHandler.instance().hasOptifine();
         ClientProxy.registerRenderInformation();
         RendererLivingEntity.NAME_TAG_RANGE_SNEAK = nametagrange;
         RendererLivingEntity.NAME_TAG_RANGE = nametagrange;
         MinecraftForge.EVENT_BUS.register(new RivalRebelsSoundEventHandler());
         MinecraftForgeClient.registerItemRenderer(roddisk, new RodDiskRenderer());
         MinecraftForgeClient.registerItemRenderer(plasmacannon, new PlasmaCannonRenderer());
         MinecraftForgeClient.registerItemRenderer(einsten, new AstroBlasterRenderer());
         MinecraftForgeClient.registerItemRenderer(hydrod, new HydrogenRodRenderer());
         MinecraftForgeClient.registerItemRenderer(redrod, new RedstoneRodRenderer());
         MinecraftForgeClient.registerItemRenderer(nuclearelement, new NuclearRodRenderer());
         MinecraftForgeClient.registerItemRenderer(emptyrod, new EmptyRodRenderer());
         MinecraftForgeClient.registerItemRenderer(reactor.func_149650_a(1, null, 1), new ReactorRenderer());
         MinecraftForgeClient.registerItemRenderer(loader.func_149650_a(1, null, 1), new LoaderRenderer());
         MinecraftForgeClient.registerItemRenderer(controller.func_149650_a(1, null, 1), new LaptopRenderer());
         MinecraftForgeClient.registerItemRenderer(rpg, new RocketLauncherRenderer());
         MinecraftForgeClient.registerItemRenderer(binoculars, new BinocularsRenderer());
         MinecraftForgeClient.registerItemRenderer(tesla, new TeslaRenderer());
         MinecraftForgeClient.registerItemRenderer(battery, new BatteryRenderer());
         MinecraftForgeClient.registerItemRenderer(flamethrower, new FlamethrowerRenderer());
         MinecraftForgeClient.registerItemRenderer(fuel, new GasRenderer());
         MinecraftForgeClient.registerItemRenderer(roda, new RodaRenderer());
         MinecraftForgeClient.registerItemRenderer(hackm202, new HackRocketLauncherRenderer());
         MinecraftForgeClient.registerItemRenderer(seekm202, new SeekRocketLauncherRenderer());
         MinecraftForgeClient.registerItemRenderer(rocket, new RocketRenderer());
         rrro = new RivalRebelsRenderOverlay();
         RenderLibrary rl = new RenderLibrary();
         rl.init();
         MinecraftForge.EVENT_BUS.register(rrro);
      }
   }

   @EventHandler
   public void serverStarting(FMLServerStartingEvent event) {
      ICommandManager commandManager = MinecraftServer.func_71276_C().func_71187_D();
      ServerCommandManager serverCommandManager = (ServerCommandManager)commandManager;
      this.addCommands(serverCommandManager);
   }

   public void addCommands(ServerCommandManager manager) {
      manager.func_71560_a(new CommandResetGame());
      manager.func_71560_a(new CommandPassword());
      manager.func_71560_a(new CommandKillme());
      manager.func_71560_a(new CommandPlaySound());
      manager.func_71560_a(new CommandStopRounds());
      manager.func_71560_a(new CommandContinueRound());
      manager.func_71560_a(new CommandInspect());
      manager.func_71560_a(new CommandMotD());
      manager.func_71560_a(new CommandKillAll());
      manager.func_71560_a(new CommandRobot());
      manager.func_71560_a(new CommandConfig());
      manager.func_71560_a(new CommandHotPotato());
   }

   private void registerBlocks() {
      int nextNum = 0;
      amario = new BlockMario().func_149647_a(rralltab).func_149711_c(1.5F).func_149752_b(10.0F).func_149663_c("rivalrebels.blocks." + nextNum++);
      aquicksand = new BlockQuickSand().func_149647_a(rralltab).func_149711_c(0.5F).func_149663_c("rivalrebels.blocks." + nextNum++);
      barricade = new BlockAutoBarricade().func_149711_c(0.7F).func_149647_a(rralltab).func_149663_c("rivalrebels.blocks." + nextNum++);
      tower = new BlockAutoTower().func_149711_c(0.7F).func_149647_a(rralltab).func_149663_c("rivalrebels.blocks." + nextNum++);
      easteregg = new BlockAutoEaster().func_149711_c(0.5F).func_149647_a(rralltab).func_149663_c("rivalrebels.blocks." + nextNum++);
      bunker = new BlockAutoBunker().func_149711_c(0.5F).func_149647_a(rralltab).func_149663_c("rivalrebels.blocks." + nextNum++);
      smartcamo = new BlockSmartCamo().func_149647_a(rralltab).func_149663_c("rivalrebels.block." + nextNum++);
      camo1 = new BlockCamo1().func_149711_c(2.0F).func_149752_b(25.0F).func_149647_a(rralltab).func_149663_c("rivalrebels.blocks." + nextNum++);
      camo2 = new BlockCamo2().func_149711_c(2.0F).func_149752_b(25.0F).func_149647_a(rralltab).func_149663_c("rivalrebels.blocks." + nextNum++);
      camo3 = new BlockCamo3().func_149711_c(2.0F).func_149752_b(25.0F).func_149647_a(rralltab).func_149663_c("rivalrebels.blocks." + nextNum++);
      steel = new BlockSteel().func_149711_c(1.0F).func_149752_b(10.0F).func_149647_a(rralltab).func_149663_c("rivalrebels.blocks." + nextNum++);
      flag1 = new BlockFlag("bi").func_149663_c("rivalrebels.blocks." + nextNum++);
      flag2 = new BlockFlag("dd").func_149663_c("rivalrebels.blocks." + nextNum++);
      flag3 = new BlockFlag("ar").func_149663_c("rivalrebels.blocks." + nextNum++);
      flag4 = new BlockFlag("aw").func_149663_c("rivalrebels.blocks." + nextNum++);
      flag5 = new BlockFlag("aq").func_149663_c("rivalrebels.blocks." + nextNum++);
      flag6 = new BlockFlag("al").func_149663_c("rivalrebels.blocks." + nextNum++);
      flag7 = new BlockFlag("aj").func_149663_c("rivalrebels.blocks." + nextNum++);
      flagbox1 = new BlockFlagBox1().func_149722_s().func_149647_a(rrarmortab).func_149663_c("rivalrebels.blocks." + nextNum++);
      flagbox5 = new BlockFlagBox5().func_149722_s().func_149647_a(rrarmortab).func_149663_c("rivalrebels.blocks." + nextNum++);
      flagbox6 = new BlockFlagBox6().func_149722_s().func_149647_a(rrarmortab).func_149663_c("rivalrebels.blocks." + nextNum++);
      flagbox3 = new BlockFlagBox3().func_149722_s().func_149647_a(rrarmortab).func_149663_c("rivalrebels.blocks." + nextNum++);
      flagbox4 = new BlockFlagBox4().func_149722_s().func_149647_a(rrarmortab).func_149663_c("rivalrebels.blocks." + nextNum++);
      flagbox7 = new BlockFlagBox7().func_149722_s().func_149647_a(rrarmortab).func_149663_c("rivalrebels.blocks." + nextNum++);
      sigmaarmor = new BlockSigmaArmor().func_149711_c(0.5F).func_149752_b(10.0F).func_149647_a(rrarmortab).func_149663_c("rivalrebels.blocks." + nextNum++);
      omegaarmor = new BlockOmegaArmor().func_149711_c(0.5F).func_149752_b(10.0F).func_149647_a(rrarmortab).func_149663_c("rivalrebels.blocks." + nextNum++);
      weapons = new BlockWeapons().func_149711_c(0.5F).func_149752_b(10.0F).func_149647_a(rralltab).func_149663_c("rivalrebels.blocks." + nextNum++);
      ammunition = new BlockAmmunition().func_149711_c(0.5F).func_149752_b(10.0F).func_149647_a(rralltab).func_149663_c("rivalrebels.blocks." + nextNum++);
      explosives = new BlockExplosives().func_149711_c(0.5F).func_149752_b(10.0F).func_149647_a(rralltab).func_149663_c("rivalrebels.blocks." + nextNum++);
      supplies = new BlockSupplies().func_149711_c(0.5F).func_149752_b(10.0F).func_149647_a(rralltab).func_149663_c("rivalrebels.blocks." + nextNum++);
      mario = new BlockMario().func_149711_c(1.5F).func_149752_b(10.0F).func_149663_c("rivalrebels.blocks." + nextNum++);
      jump = new BlockJump().func_149711_c(2.0F).func_149752_b(5.0F).func_149647_a(rralltab).func_149663_c("rivalrebels.blocks." + nextNum++);
      quicksand = new BlockQuickSand().func_149711_c(0.5F).func_149663_c("rivalrebels.blocks." + nextNum++);
      landmine = new BlockLandMine().func_149752_b(1.0F).func_149711_c(0.6F).func_149663_c("rivalrebels.blocks." + nextNum++);
      remotecharge = new BlockRemoteCharge().func_149711_c(0.5F).func_149647_a(rralltab).func_149663_c("rivalrebels.blocks." + nextNum++);
      timedbomb = new BlockTimedBomb().func_149647_a(rralltab).func_149663_c("rivalrebels.blocks." + nextNum++);
      flare = new BlockFlare().func_149715_a(0.5F).func_149647_a(rralltab).func_149663_c("rivalrebels.blocks." + nextNum++);
      light = new BlockLight(23).func_149715_a(1.0F).func_149663_c("rivalrebels.blocks." + nextNum++);
      light2 = new BlockLight(-1).func_149715_a(1.0F).func_149663_c("rivalrebels.blocks." + nextNum++);
      cycle = new BlockCycle().func_149647_a(rrarmortab).func_149663_c("rivalrebels.blocks." + nextNum++);
      toxicgas = new BlockToxicGas().func_149722_s().func_149663_c("rivalrebels.blocks." + nextNum++);
      fshield = new BlockForceShield()
         .func_149711_c(0.2F)
         .func_149752_b(10.0F)
         .func_149713_g(0)
         .func_149715_a(0.25F)
         .func_149647_a(rralltab)
         .func_149663_c("rivalrebels.blocks." + nextNum++);
      gamestart = new BlockGameStart().func_149647_a(rralltab).func_149663_c("rivalrebels.blocks." + nextNum++);
      breadbox = new BlockBreadBox().func_149647_a(rralltab).func_149722_s().func_149663_c("rivalrebels.blocks." + nextNum++);
      alandmine = new BlockLandMine().func_149647_a(rralltab).func_149752_b(1.0F).func_149711_c(0.6F).func_149663_c("rivalrebels.blocks." + nextNum++);
      nuclearBomb = new BlockNuclearBomb().func_149711_c(5.0F).func_149663_c("rivalrebels.blocks." + nextNum++);
      nukeCrateTop = new BlockNukeCrate().func_149647_a(rralltab).func_149711_c(0.5F).func_149663_c("rivalrebels.blocks." + nextNum++);
      nukeCrateBottom = new BlockNukeCrate().func_149647_a(rralltab).func_149711_c(0.5F).func_149663_c("rivalrebels.blocks." + nextNum++);
      radioactivedirt = new BlockRadioactiveDirt().func_149647_a(rralltab).func_149711_c(0.5F).func_149663_c("rivalrebels.blocks." + nextNum++);
      radioactivesand = new BlockRadioactiveSand().func_149647_a(rralltab).func_149711_c(0.5F).func_149663_c("rivalrebels.blocks." + nextNum++);
      plasmaexplosion = new BlockPlasmaExplosion().func_149715_a(1.0F).func_149663_c("rivalrebels.blocks." + nextNum++);
      reactor = new BlockReactor().func_149711_c(1.0F).func_149752_b(10.0F).func_149715_a(1.0F).func_149663_c("rivalrebels.blocks." + nextNum++);
      loader = new BlockLoader().func_149711_c(2.0F).func_149752_b(10.0F).func_149647_a(rralltab).func_149663_c("rivalrebels.blocks." + nextNum++);
      omegaobj = new BlockOmegaObjective()
         .func_149715_a(1.0F)
         .func_149711_c(1.0F)
         .func_149752_b(10.0F)
         .func_149647_a(rralltab)
         .func_149663_c("rivalrebels.blocks." + nextNum++);
      sigmaobj = new BlockSigmaObjective()
         .func_149715_a(1.0F)
         .func_149711_c(1.0F)
         .func_149752_b(10.0F)
         .func_149647_a(rralltab)
         .func_149663_c("rivalrebels.blocks." + nextNum++);
      petrifiedwood = new BlockPetrifiedWood()
         .func_149711_c(1.25F)
         .func_149752_b(10.0F)
         .func_149647_a(rralltab)
         .func_149663_c("rivalrebels.blocks." + nextNum++);
      petrifiedstone1 = new BlockPetrifiedStone("c")
         .func_149711_c(1.5F)
         .func_149752_b(10.0F)
         .func_149647_a(rralltab)
         .func_149663_c("rivalrebels.blocks." + nextNum++);
      petrifiedstone2 = new BlockPetrifiedStone("d")
         .func_149711_c(1.5F)
         .func_149752_b(10.0F)
         .func_149647_a(rralltab)
         .func_149663_c("rivalrebels.blocks." + nextNum++);
      petrifiedstone3 = new BlockPetrifiedStone("e")
         .func_149711_c(1.5F)
         .func_149752_b(10.0F)
         .func_149647_a(rralltab)
         .func_149663_c("rivalrebels.blocks." + nextNum++);
      petrifiedstone4 = new BlockPetrifiedStone("f")
         .func_149711_c(1.5F)
         .func_149752_b(10.0F)
         .func_149647_a(rralltab)
         .func_149663_c("rivalrebels.blocks." + nextNum++);
      tsarbombablock = new BlockTsarBomba().func_149711_c(5.0F).func_149663_c("rivalrebels.blocks." + nextNum++);
      forcefieldnode = new BlockForceFieldNode().func_149711_c(5.0F).func_149647_a(rralltab).func_149663_c("rivalrebels.blocks." + nextNum++);
      goreblock = new BlockGore().func_149711_c(0.0F).func_149647_a(rrarmortab).func_149663_c("rivalrebels.blocks." + nextNum++);
      reactive = new BlockReactive().func_149711_c(2.0F).func_149752_b(100.0F).func_149647_a(rralltab).func_149663_c("rivalrebels.blocks." + nextNum++);
      bastion = new BlockAutoForceField().func_149711_c(0.5F).func_149752_b(10.0F).func_149647_a(rralltab).func_149663_c("rivalrebels.blocks." + nextNum++);
      conduit = new BlockConduit().func_149711_c(0.5F).func_149752_b(10.0F).func_149647_a(rralltab).func_149663_c("rivalrebels.blocks." + nextNum++);
      controller = new BlockLaptop().func_149711_c(0.3F).func_149752_b(1.0F).func_149647_a(rralltab).func_149663_c("rivalrebels.blocks." + nextNum++);
      mariotrap = new BlockAutoMarioTrap().func_149711_c(0.5F).func_149752_b(10.0F).func_149647_a(rralltab).func_149663_c("rivalrebels.blocks." + nextNum++);
      minetrap = new BlockAutoMineTrap().func_149711_c(0.5F).func_149752_b(10.0F).func_149647_a(rralltab).func_149663_c("rivalrebels.blocks." + nextNum++);
      quicksandtrap = new BlockAutoQuickSandTrap()
         .func_149711_c(0.5F)
         .func_149752_b(10.0F)
         .func_149647_a(rralltab)
         .func_149663_c("rivalrebels.blocks." + nextNum++);
      forcefield = new BlockForceField()
         .func_149711_c(1000000.0F)
         .func_149752_b(1000000.0F)
         .func_149715_a(0.5F)
         .func_149663_c("rivalrebels.blocks." + nextNum++);
      meltdown = new BlockMeltDown().func_149711_c(0.5F).func_149752_b(10.0F).func_149663_c("rivalrebels.blocks." + nextNum++);
      ffreciever = new BlockReciever().func_149711_c(2.0F).func_149752_b(100.0F).func_149647_a(rralltab).func_149663_c("rivalrebels.blocks." + nextNum++);
      buildrhodes = new BlockRhodesScaffold()
         .func_149711_c(2.0F)
         .func_149752_b(100.0F)
         .func_149647_a(rralltab)
         .func_149663_c("rivalrebels.blocks." + nextNum++);
      rhodesactivator = new BlockRhodesActivator()
         .func_149711_c(0.1F)
         .func_149752_b(100.0F)
         .func_149647_a(rralltab)
         .func_149663_c("rivalrebels.blocks." + nextNum++);
      theoreticaltsarbombablock = new BlockTheoreticalTsarBomba().func_149711_c(5.0F).func_149715_a(0.4F).func_149663_c("rivalrebels.blocks." + nextNum++);
      antimatterbombblock = new BlockAntimatterBomb().func_149711_c(5.0F).func_149715_a(0.4F).func_149663_c("rivalrebels.blocks." + nextNum++);
      tachyonbombblock = new BlockTachyonBomb().func_149711_c(5.0F).func_149715_a(0.4F).func_149663_c("rivalrebels.blocks." + nextNum++);
      nextNum = 0;
      GameRegistry.registerBlock(amario, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(aquicksand, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(barricade, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(tower, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(easteregg, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(bunker, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(flag1, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(flag2, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(flag3, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(flag4, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(flag5, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(flag6, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(flag7, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(flagbox1, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(flagbox5, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(flagbox6, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(flagbox3, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(flagbox4, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(flagbox7, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(smartcamo, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(camo1, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(camo2, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(camo3, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(steel, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(sigmaarmor, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(omegaarmor, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(weapons, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(ammunition, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(explosives, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(supplies, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(mario, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(jump, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(quicksand, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(landmine, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(remotecharge, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(timedbomb, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(flare, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(light, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(cycle, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(light2, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(toxicgas, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(fshield, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(gamestart, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(breadbox, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(alandmine, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(nuclearBomb, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(nukeCrateTop, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(nukeCrateBottom, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(radioactivedirt, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(radioactivesand, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(plasmaexplosion, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(reactor, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(loader, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(omegaobj, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(sigmaobj, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(petrifiedwood, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(petrifiedstone1, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(petrifiedstone2, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(petrifiedstone3, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(petrifiedstone4, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(tsarbombablock, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(forcefieldnode, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(reactive, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(ffreciever, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(bastion, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(conduit, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(controller, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(mariotrap, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(minetrap, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(quicksandtrap, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(forcefield, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(meltdown, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(buildrhodes, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(rhodesactivator, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(theoreticaltsarbombablock, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(antimatterbombblock, "rivalrebelsblock" + nextNum++);
      GameRegistry.registerBlock(tachyonbombblock, "rivalrebelsblock" + nextNum++);
   }

   private void registerItems() {
      int nextNum = 0;
      rpg = new ItemRPG().func_77655_b("rivalrebelsitem" + nextNum++);
      flamethrower = new ItemFlameThrower().func_77655_b("rivalrebelsitem" + nextNum++);
      tesla = new ItemTesla().func_77655_b("rivalrebelsitem" + nextNum++);
      rocket = new ItemRocket().func_77655_b("rivalrebelsitem" + nextNum++);
      fuel = new ItemFuel().func_77655_b("rivalrebelsitem" + nextNum++);
      battery = new ItemBattery().func_77655_b("rivalrebelsitem" + nextNum++);
      pliers = new ItemPliers().func_77655_b("rivalrebelsitem" + nextNum++);
      armyshovel = new ItemArmyShovel().func_77655_b("rivalrebelsitem" + nextNum++);
      knife = new ItemCuchillo().func_77655_b("rivalrebelsitem" + nextNum++);
      gasgrenade = new ItemGasGrenade().func_77655_b("rivalrebelsitem" + nextNum++);
      safepill = new ItemSafePill().func_77655_b("rivalrebelsitem" + nextNum++);
      expill = new ItemExPill().func_77655_b("rivalrebelsitem" + nextNum++);
      remote = new ItemRemote().func_77655_b("rivalrebelsitem" + nextNum++);
      fuse = new ItemFuse().func_77655_b("rivalrebelsitem" + nextNum++);
      nuclearelement = new ItemRodNuclear().func_77655_b("rivalrebelsitem" + nextNum++);
      hydrod = new ItemRodHydrogen().func_77655_b("rivalrebelsitem" + nextNum++);
      plasmacannon = new ItemPlasmaCannon().func_77655_b("rivalrebelsitem" + nextNum++);
      roddisk = new ItemRodDisk().func_77655_b("rivalrebelsitem" + nextNum++);
      antenna = new ItemAntenna().func_77655_b("rivalrebelsitem" + nextNum++);
      einsten = new ItemAstroBlaster().func_77655_b("rivalrebelsitem" + nextNum++);
      redrod = new ItemRodRedstone().func_77655_b("rivalrebelsitem" + nextNum++);
      emptyrod = new ItemRodEmpty().func_77655_b("rivalrebelsitem" + nextNum++);
      core1 = new ItemCoreCopper().func_77655_b("rivalrebelsitem" + nextNum++);
      core2 = new ItemCoreTungsten().func_77655_b("rivalrebelsitem" + nextNum++);
      core3 = new ItemCoreTitanium().func_77655_b("rivalrebelsitem" + nextNum++);
      binoculars = new ItemBinoculars().func_77655_b("rivalrebelsitem" + nextNum++);
      chip = new ItemChip().func_77655_b("rivalrebelsitem" + nextNum++);
      roda = new ItemRoda().func_77655_b("rivalrebelsitems" + nextNum++);
      trollmask = new ItemTrollHelmet().func_77655_b("rivalrebelsitems" + nextNum++);
      hackm202 = new ItemHackM202().func_77655_b("rivalrebelsitems" + nextNum++);
      seekm202 = new ItemSeekM202().func_77655_b("rivalrebelsitems" + nextNum++);
      camera = new ItemCamera().func_77655_b("rivalrebelsitem" + nextNum++);
      nextNum = 0;
      GameRegistry.registerItem(rpg, "rivalrebelsitem" + nextNum++);
      GameRegistry.registerItem(flamethrower, "rivalrebelsitem" + nextNum++);
      GameRegistry.registerItem(tesla, "rivalrebelsitem" + nextNum++);
      GameRegistry.registerItem(rocket, "rivalrebelsitem" + nextNum++);
      GameRegistry.registerItem(fuel, "rivalrebelsitem" + nextNum++);
      GameRegistry.registerItem(battery, "rivalrebelsitem" + nextNum++);
      GameRegistry.registerItem(pliers, "rivalrebelsitem" + nextNum++);
      GameRegistry.registerItem(armyshovel, "rivalrebelsitem" + nextNum++);
      GameRegistry.registerItem(knife, "rivalrebelsitem" + nextNum++);
      GameRegistry.registerItem(gasgrenade, "rivalrebelsitem" + nextNum++);
      GameRegistry.registerItem(safepill, "rivalrebelsitem" + nextNum++);
      GameRegistry.registerItem(expill, "rivalrebelsitem" + nextNum++);
      GameRegistry.registerItem(remote, "rivalrebelsitem" + nextNum++);
      GameRegistry.registerItem(fuse, "rivalrebelsitem" + nextNum++);
      GameRegistry.registerItem(nuclearelement, "rivalrebelsitem" + nextNum++);
      GameRegistry.registerItem(hydrod, "rivalrebelsitem" + nextNum++);
      GameRegistry.registerItem(plasmacannon, "rivalrebelsitem" + nextNum++);
      GameRegistry.registerItem(roddisk, "rivalrebelsitem" + nextNum++);
      GameRegistry.registerItem(antenna, "rivalrebelsitem" + nextNum++);
      GameRegistry.registerItem(einsten, "rivalrebelsitem" + nextNum++);
      GameRegistry.registerItem(redrod, "rivalrebelsitem" + nextNum++);
      GameRegistry.registerItem(emptyrod, "rivalrebelsitem" + nextNum++);
      GameRegistry.registerItem(binoculars, "rivalrebelsitem" + nextNum++);
      GameRegistry.registerItem(core1, "rivalrebelsitem" + nextNum++);
      GameRegistry.registerItem(core2, "rivalrebelsitem" + nextNum++);
      GameRegistry.registerItem(core3, "rivalrebelsitem" + nextNum++);
      GameRegistry.registerItem(chip, "rivalrebelsitem" + nextNum++);
      GameRegistry.registerItem(roda, "rivalrebelsitem" + nextNum++);
      GameRegistry.registerItem(trollmask, "rivalrebelsitem" + nextNum++);
      GameRegistry.registerItem(hackm202, "rivalrebelsitem" + nextNum++);
      GameRegistry.registerItem(seekm202, "rivalrebelsitem" + nextNum++);
      GameRegistry.registerItem(camera, "rivalrebelsitem" + nextNum++);
   }

   private void registerArmor() {
      int orebelarmorrenderer = proxy.addArmor("orebelarmor");
      int onukerarmorrenderer = proxy.addArmor("onukerarmor");
      int ointelarmorrenderer = proxy.addArmor("ointelarmor");
      int ohackerarmorrenderer = proxy.addArmor("ohackerarmor");
      int srebelarmorrenderer = proxy.addArmor("srebelarmor");
      int snukerarmorrenderer = proxy.addArmor("snukerarmor");
      int sintelarmorrenderer = proxy.addArmor("sintelarmor");
      int shackerarmorrenderer = proxy.addArmor("shackerarmor");
      int nextNum = 0;
      orebelhelmet = new ItemClassArmor(orebelarmor, orebelarmorrenderer, 0, 0, 0).func_77655_b("rivalrebelsarmor" + nextNum++);
      orebelchest = new ItemClassArmor(orebelarmor, orebelarmorrenderer, 1, 0, 0).func_77655_b("rivalrebelsarmor" + nextNum++);
      orebelpants = new ItemClassArmor(orebelarmor, orebelarmorrenderer, 2, 0, 0).func_77655_b("rivalrebelsarmor" + nextNum++);
      orebelboots = new ItemClassArmor(orebelarmor, orebelarmorrenderer, 3, 0, 0).func_77655_b("rivalrebelsarmor" + nextNum++);
      onukerhelmet = new ItemClassArmor(onukerarmor, onukerarmorrenderer, 0, 0, 1).func_77655_b("rivalrebelsarmor" + nextNum++);
      onukerchest = new ItemClassArmor(onukerarmor, onukerarmorrenderer, 1, 0, 1).func_77655_b("rivalrebelsarmor" + nextNum++);
      onukerpants = new ItemClassArmor(onukerarmor, onukerarmorrenderer, 2, 0, 1).func_77655_b("rivalrebelsarmor" + nextNum++);
      onukerboots = new ItemClassArmor(onukerarmor, onukerarmorrenderer, 3, 0, 1).func_77655_b("rivalrebelsarmor" + nextNum++);
      ointelhelmet = new ItemClassArmor(ointelarmor, ointelarmorrenderer, 0, 0, 2).func_77655_b("rivalrebelsarmor" + nextNum++);
      ointelchest = new ItemClassArmor(ointelarmor, ointelarmorrenderer, 1, 0, 2).func_77655_b("rivalrebelsarmor" + nextNum++);
      ointelpants = new ItemClassArmor(ointelarmor, ointelarmorrenderer, 2, 0, 2).func_77655_b("rivalrebelsarmor" + nextNum++);
      ointelboots = new ItemClassArmor(ointelarmor, ointelarmorrenderer, 3, 0, 2).func_77655_b("rivalrebelsarmor" + nextNum++);
      ohackerhelmet = new ItemClassArmor(ohackerarmor, ohackerarmorrenderer, 0, 0, 3).func_77655_b("rivalrebelsarmor" + nextNum++);
      ohackerchest = new ItemClassArmor(ohackerarmor, ohackerarmorrenderer, 1, 0, 3).func_77655_b("rivalrebelsarmor" + nextNum++);
      ohackerpants = new ItemClassArmor(ohackerarmor, ohackerarmorrenderer, 2, 0, 3).func_77655_b("rivalrebelsarmor" + nextNum++);
      ohackerboots = new ItemClassArmor(ohackerarmor, ohackerarmorrenderer, 3, 0, 3).func_77655_b("rivalrebelsarmor" + nextNum++);
      srebelhelmet = new ItemClassArmor(srebelarmor, srebelarmorrenderer, 0, 1, 0).func_77655_b("rivalrebelsarmor" + nextNum++);
      srebelchest = new ItemClassArmor(srebelarmor, srebelarmorrenderer, 1, 1, 0).func_77655_b("rivalrebelsarmor" + nextNum++);
      srebelpants = new ItemClassArmor(srebelarmor, srebelarmorrenderer, 2, 1, 0).func_77655_b("rivalrebelsarmor" + nextNum++);
      srebelboots = new ItemClassArmor(srebelarmor, srebelarmorrenderer, 3, 1, 0).func_77655_b("rivalrebelsarmor" + nextNum++);
      snukerhelmet = new ItemClassArmor(snukerarmor, snukerarmorrenderer, 0, 1, 1).func_77655_b("rivalrebelsarmor" + nextNum++);
      snukerchest = new ItemClassArmor(snukerarmor, snukerarmorrenderer, 1, 1, 1).func_77655_b("rivalrebelsarmor" + nextNum++);
      snukerpants = new ItemClassArmor(snukerarmor, snukerarmorrenderer, 2, 1, 1).func_77655_b("rivalrebelsarmor" + nextNum++);
      snukerboots = new ItemClassArmor(snukerarmor, snukerarmorrenderer, 3, 1, 1).func_77655_b("rivalrebelsarmor" + nextNum++);
      sintelhelmet = new ItemClassArmor(sintelarmor, sintelarmorrenderer, 0, 1, 2).func_77655_b("rivalrebelsarmor" + nextNum++);
      sintelchest = new ItemClassArmor(sintelarmor, sintelarmorrenderer, 1, 1, 2).func_77655_b("rivalrebelsarmor" + nextNum++);
      sintelpants = new ItemClassArmor(sintelarmor, sintelarmorrenderer, 2, 1, 2).func_77655_b("rivalrebelsarmor" + nextNum++);
      sintelboots = new ItemClassArmor(sintelarmor, sintelarmorrenderer, 3, 1, 2).func_77655_b("rivalrebelsarmor" + nextNum++);
      shackerhelmet = new ItemClassArmor(shackerarmor, shackerarmorrenderer, 0, 1, 3).func_77655_b("rivalrebelsarmor" + nextNum++);
      shackerchest = new ItemClassArmor(shackerarmor, shackerarmorrenderer, 1, 1, 3).func_77655_b("rivalrebelsarmor" + nextNum++);
      shackerpants = new ItemClassArmor(shackerarmor, shackerarmorrenderer, 2, 1, 3).func_77655_b("rivalrebelsarmor" + nextNum++);
      shackerboots = new ItemClassArmor(shackerarmor, shackerarmorrenderer, 3, 1, 3).func_77655_b("rivalrebelsarmor" + nextNum++);
      int rendererCamo = proxy.addArmor("Camo");
      int rendererCamo2 = proxy.addArmor("Camo2");
      camohat = new ItemArmorCamo(armorCamo, rendererCamo, 0, 0).func_77655_b("rivalrebelsarmor" + nextNum++);
      camoshirt = new ItemArmorCamo(armorCamo, rendererCamo, 1, 0).func_77655_b("rivalrebelsarmor" + nextNum++);
      camopants = new ItemArmorCamo(armorCamo, rendererCamo, 2, 0).func_77655_b("rivalrebelsarmor" + nextNum++);
      camoshoes = new ItemArmorCamo(armorCamo, rendererCamo, 3, 0).func_77655_b("rivalrebelsarmor" + nextNum++);
      camohat2 = new ItemArmorCamo(armorCamo2, rendererCamo2, 0, 1).func_77655_b("rivalrebelsarmor" + nextNum++);
      camoshirt2 = new ItemArmorCamo(armorCamo2, rendererCamo2, 1, 1).func_77655_b("rivalrebelsarmor" + nextNum++);
      camopants2 = new ItemArmorCamo(armorCamo2, rendererCamo2, 2, 1).func_77655_b("rivalrebelsarmor" + nextNum++);
      camoshoes2 = new ItemArmorCamo(armorCamo2, rendererCamo2, 3, 1).func_77655_b("rivalrebelsarmor" + nextNum++);
      nextNum = 0;
      GameRegistry.registerItem(orebelhelmet, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(orebelchest, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(orebelpants, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(orebelboots, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(onukerhelmet, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(onukerchest, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(onukerpants, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(onukerboots, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(ointelhelmet, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(ointelchest, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(ointelpants, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(ointelboots, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(ohackerhelmet, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(ohackerchest, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(ohackerpants, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(ohackerboots, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(srebelhelmet, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(srebelchest, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(srebelpants, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(srebelboots, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(snukerhelmet, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(snukerchest, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(snukerpants, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(snukerboots, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(sintelhelmet, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(sintelchest, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(sintelpants, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(sintelboots, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(shackerhelmet, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(shackerchest, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(shackerpants, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(shackerboots, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(camohat, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(camoshirt, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(camopants, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(camoshoes, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(camohat2, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(camoshirt2, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(camopants2, "rivalrebelsarmor" + nextNum++);
      GameRegistry.registerItem(camoshoes2, "rivalrebelsarmor" + nextNum++);
   }

   private void registerEntities() {
      int nextNum = -1;
      GameRegistry.registerTileEntity(TileEntityNukeCrate.class, "rivalrebelstileentity" + ++nextNum);
      GameRegistry.registerTileEntity(TileEntityJumpBlock.class, "rivalrebelstileentity" + ++nextNum);
      GameRegistry.registerTileEntity(TileEntityNuclearBomb.class, "rivalrebelstileentity" + ++nextNum);
      GameRegistry.registerTileEntity(TileEntityPlasmaExplosion.class, "rivalrebelstileentity" + ++nextNum);
      GameRegistry.registerTileEntity(TileEntityReactor.class, "rivalrebelstileentity" + ++nextNum);
      GameRegistry.registerTileEntity(TileEntityLoader.class, "rivalrebelstileentity" + ++nextNum);
      GameRegistry.registerTileEntity(TileEntityOmegaObjective.class, "rivalrebelstileentity" + ++nextNum);
      GameRegistry.registerTileEntity(TileEntitySigmaObjective.class, "rivalrebelstileentity" + ++nextNum);
      GameRegistry.registerTileEntity(TileEntityTsarBomba.class, "rivalrebelstileentity" + ++nextNum);
      GameRegistry.registerTileEntity(TileEntityForceFieldNode.class, "rivalrebelstileentity" + ++nextNum);
      GameRegistry.registerTileEntity(TileEntityGore.class, "rivalrebelstileentity" + ++nextNum);
      GameRegistry.registerTileEntity(TileEntityConduit.class, "rivalrebelstileentity" + ++nextNum);
      GameRegistry.registerTileEntity(TileEntityLaptop.class, "rivalrebelstileentity" + ++nextNum);
      GameRegistry.registerTileEntity(TileEntityReciever.class, "rivalrebelstileentity" + ++nextNum);
      GameRegistry.registerTileEntity(TileEntityReactive.class, "rivalrebelstileentity" + ++nextNum);
      GameRegistry.registerTileEntity(TileEntityMeltDown.class, "rivalrebelstileentity" + ++nextNum);
      GameRegistry.registerTileEntity(TileEntityRhodesActivator.class, "rivalrebelstileentity" + ++nextNum);
      GameRegistry.registerTileEntity(TileEntityTheoreticalTsarBomba.class, "rivalrebelstileentity" + ++nextNum);
      GameRegistry.registerTileEntity(TileEntityAntimatterBomb.class, "rivalrebelstileentity" + ++nextNum);
      GameRegistry.registerTileEntity(TileEntityTachyonBomb.class, "rivalrebelstileentity" + ++nextNum);
      nextNum = -1;
      EntityRegistry.registerModEntity(EntityGasGrenade.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityCuchillo.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityPropulsionFX.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 9, true);
      EntityRegistry.registerModEntity(EntityPassiveFire.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 9, true);
      EntityRegistry.registerModEntity(EntityRocket.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityPlasmoid.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 400, 1, true);
      EntityRegistry.registerModEntity(EntityRaytrace.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityLightningLink.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityNuclearBlast.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityFlameBall.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityFlameBall1.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityFlameBall2.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityLaptop.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityRoddiskRegular.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityRoddiskRebel.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityRoddiskOfficer.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityRoddiskLeader.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityTsarBlast.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityLaserLink.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityGore.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityBlood.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 4, true);
      EntityRegistry.registerModEntity(EntityGoo.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 4, true);
      EntityRegistry.registerModEntity(EntityLaserBurst.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 400, 1, true);
      EntityRegistry.registerModEntity(EntityB83.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityB2Spirit.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 400, 1, true);
      EntityRegistry.registerModEntity(EntityB2Frag.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityDebris.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 3, true);
      EntityRegistry.registerModEntity(EntityHackB83.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntitySeekB83.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityRhodes.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 400, 1, true);
      EntityRegistry.registerModEntity(EntityRhodesHead.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityRhodesTorso.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityRhodesLeftUpperArm.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityRhodesRightUpperArm.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityRhodesLeftLowerArm.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityRhodesRightLowerArm.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityRhodesLeftUpperLeg.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityRhodesRightUpperLeg.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityRhodesLeftLowerLeg.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityRhodesRightLowerLeg.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityTarget.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityB83NoShroom.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntitySphereBlast.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityNuke.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityTsar.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityRoddiskRep.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityHotPotato.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityBomb.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityTheoreticalTsar.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityTheoreticalTsarBlast.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityFlameBallGreen.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityAntimatterBomb.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityAntimatterBombBlast.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityTachyonBombBlast.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
      EntityRegistry.registerModEntity(EntityTachyonBomb.class, "rivalrebelsentity" + ++nextNum, nextNum, this, 250, 1, true);
   }

   private void registerGuis() {
      NetworkRegistry.INSTANCE.registerGuiHandler(this, new RivalRebelsGuiHandler());
   }
}
