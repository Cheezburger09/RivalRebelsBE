package assets.rivalrebels.common.item.weapon;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.packet.LaptopEngagePacket;
import assets.rivalrebels.common.packet.PacketDispatcher;
import assets.rivalrebels.common.round.RivalRebelsTeam;
import assets.rivalrebels.common.tileentity.TileEntityLaptop;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class ItemBinoculars extends Item {
   private static ArrayList<TileEntityLaptop> ltel = new ArrayList<>();
   public static int tx = -1;
   public static int ty = -1;
   public static int tz = -1;
   public static int lx = -1;
   public static int ly = -1;
   public static int lz = -1;
   public static int tasks = 0;
   public static int carpet = 0;
   public static float dist = 0.0F;
   public static float distblock = 0.0F;
   public static boolean hasLaptop = false;
   public static boolean tooClose = false;
   public static boolean tooFar = true;
   public static boolean ready = false;
   public static boolean c = false;
   public static boolean sc = false;
   public static int slot = -1;
   float zoom = 30.0F;
   float fovset = 0.0F;
   float senset = 0.0F;
   boolean zoomed = false;
   boolean prevzoomed = false;
   boolean prevmclick;

   public ItemBinoculars() {
      this.field_77777_bU = 1;
      this.func_77637_a(RivalRebels.rralltab);
   }

   public boolean func_77662_d() {
      return true;
   }

   public EnumAction func_77661_b(ItemStack par1ItemStack) {
      return EnumAction.bow;
   }

   public int func_77626_a(ItemStack par1ItemStack) {
      return 200;
   }

   public ItemStack func_77659_a(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
      par3EntityPlayer.func_71008_a(par1ItemStack, this.func_77626_a(par1ItemStack));
      return par1ItemStack;
   }

   public void func_77663_a(ItemStack item, World world, Entity entity, int par4, boolean par5) {
      Side side = FMLCommonHandler.instance().getEffectiveSide();
      if (entity instanceof EntityPlayer && side == Side.CLIENT && entity == Minecraft.func_71410_x().field_71439_g) {
         EntityPlayer player = (EntityPlayer)entity;
         boolean strike = this.isMousePressed() && !this.prevmclick;
         c = c ^ (Keyboard.isKeyDown(46) && !sc);
         sc = Keyboard.isKeyDown(46);
         this.prevzoomed = this.zoomed;
         this.zoomed = Mouse.isButtonDown(1)
            && (player.field_71071_by.func_70448_g() == item || this.zoomed)
            && !GameSettings.func_100015_a(Minecraft.func_71410_x().field_71474_y.field_74316_C)
            && Minecraft.func_71410_x().field_71462_r == null;
         if (!this.zoomed) {
            if (this.prevzoomed) {
               Minecraft.func_71410_x().field_71474_y.field_74334_X = this.fovset;
               Minecraft.func_71410_x().field_71474_y.field_74341_c = this.senset;
            }
         } else {
            if (!this.prevzoomed) {
               this.fovset = Minecraft.func_71410_x().field_71474_y.field_74334_X;
               this.senset = Minecraft.func_71410_x().field_71474_y.field_74341_c;
            }

            slot = -1;
            lx = -1;
            ly = -1;
            lz = -1;
            distblock = 130.0F;
            hasLaptop = false;
            tasks = 0;
            carpet = 0;
            dist = 6.0F;
            tooFar = true;
            tooClose = false;
            tx = -1;
            ty = -1;
            tz = -1;
            ready = false;

            for (int i = 0; i < 9; i++) {
               if (player.field_71071_by.field_70462_a[i] == item) {
                  player.field_71071_by.field_70461_c = i;
                  slot = i;
                  break;
               }
            }

            if (slot != -1) {
               this.zoom = this.zoom + Mouse.getDWheel() * 0.01F;
               if (this.zoom < 10.0F) {
                  this.zoom = 10.0F;
               }

               if (this.zoom > 67.0F) {
                  this.zoom = 67.0F;
               }

               Minecraft.func_71410_x().field_71474_y.field_74334_X = this.zoom + (Minecraft.func_71410_x().field_71474_y.field_74334_X - this.zoom) * 0.85F;
               Minecraft.func_71410_x().field_71474_y.field_74341_c = this.senset * MathHelper.func_76129_c(this.zoom) * 0.1F;
               if (Mouse.isButtonDown(1)) {
                  double cospitch = MathHelper.func_76134_b(player.field_70125_A / 180.0F * (float) Math.PI);
                  double sinpitch = MathHelper.func_76126_a(player.field_70125_A / 180.0F * (float) Math.PI);
                  double cosyaw = MathHelper.func_76134_b(player.field_70177_z / 180.0F * (float) Math.PI);
                  double sinyaw = MathHelper.func_76126_a(player.field_70177_z / 180.0F * (float) Math.PI);
                  double dx = -sinyaw * cospitch * 130.0;
                  double dz = cosyaw * cospitch * 130.0;
                  double dy = -sinpitch * 130.0;
                  Vec3 var17 = Vec3.func_72443_a(player.field_70165_t, player.field_70163_u, player.field_70161_v);
                  Vec3 var3x = Vec3.func_72443_a(player.field_70165_t + dx, player.field_70163_u + dy, player.field_70161_v + dz);
                  MovingObjectPosition MOP = world.func_72901_a(var17, var3x, false);
                  TileEntityLaptop t = null;
                  Iterator iter = ltel.iterator();
                  double d = 100.0;

                  while (iter.hasNext()) {
                     t = (TileEntityLaptop)iter.next();
                     if (t.b2spirit > 0 || t.b2carpet > 0) {
                        hasLaptop = true;
                        double temp = player.func_70092_e(t.field_145851_c + 0.5, t.field_145848_d + 0.5, t.field_145849_e + 0.5);
                        if (temp < d) {
                           d = temp;
                           lx = t.field_145851_c;
                           ly = t.field_145848_d;
                           lz = t.field_145849_e;
                        }
                     }
                  }

                  if (MOP != null) {
                     tx = MOP.field_72311_b;
                     ty = MOP.field_72312_c;
                     tz = MOP.field_72309_d;
                     distblock = (float)player.func_70011_f(tx + 0.5F, ty + 0.5F, tz + 0.5F);
                     tooFar = false;
                     if (t != null) {
                        tasks = t.b2spirit;
                        carpet = t.b2carpet;
                        dist = (float)Math.sqrt(d);
                        int XX = 11;
                        int ZZ = 10;
                        if (t.rrteam == RivalRebelsTeam.OMEGA) {
                           XX = MOP.field_72311_b - RivalRebels.round.oObjx;
                           ZZ = MOP.field_72309_d - RivalRebels.round.oObjz;
                        }

                        if (t.rrteam == RivalRebelsTeam.SIGMA) {
                           XX = MOP.field_72311_b - RivalRebels.round.sObjx;
                           ZZ = MOP.field_72309_d - RivalRebels.round.sObjz;
                        }

                        tooClose = (tx - lx) * (tx - lx) + (tz - lz) * (tz - lz) < 625;
                        if (!tooClose && XX * XX + ZZ * ZZ > 200) {
                           ready = true;
                           if (strike) {
                              PacketDispatcher.packetsys.sendToServer(new LaptopEngagePacket(tx, ty, tz, lx, ly, lz, c));
                           }
                        }
                     }
                  }
               }
            }
         }

         this.prevmclick = this.isMousePressed();
      }
   }

   public boolean isMousePressed() {
      return (RivalRebels.altRkey ? Keyboard.isKeyDown(33) : Keyboard.isKeyDown(19)) && RivalRebels.rtarget || Mouse.isButtonDown(0) && RivalRebels.lctarget;
   }

   public static void add(TileEntityLaptop tel) {
      if (!ltel.contains(tel)) {
         ltel.add(tel);
      }
   }

   public static void remove(TileEntityLaptop tel) {
      ltel.remove(tel);
   }

   public void func_94581_a(IIconRegister iconregister) {
      this.field_77791_bV = iconregister.func_94245_a("RivalRebels:bb");
   }
}
