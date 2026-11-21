package assets.rivalrebels.common.item.weapon;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.entity.EntityAntimatterBomb;
import assets.rivalrebels.common.entity.EntityB83;
import assets.rivalrebels.common.entity.EntityBomb;
import assets.rivalrebels.common.entity.EntityCuchillo;
import assets.rivalrebels.common.entity.EntityDebris;
import assets.rivalrebels.common.entity.EntityFlameBall;
import assets.rivalrebels.common.entity.EntityFlameBall1;
import assets.rivalrebels.common.entity.EntityFlameBall2;
import assets.rivalrebels.common.entity.EntityGasGrenade;
import assets.rivalrebels.common.entity.EntityGore;
import assets.rivalrebels.common.entity.EntityHackB83;
import assets.rivalrebels.common.entity.EntityHotPotato;
import assets.rivalrebels.common.entity.EntityLaserBurst;
import assets.rivalrebels.common.entity.EntityNuclearBlast;
import assets.rivalrebels.common.entity.EntityNuke;
import assets.rivalrebels.common.entity.EntityPlasmoid;
import assets.rivalrebels.common.entity.EntityRaytrace;
import assets.rivalrebels.common.entity.EntityRocket;
import assets.rivalrebels.common.entity.EntityRoddiskRebel;
import assets.rivalrebels.common.entity.EntitySeekB83;
import assets.rivalrebels.common.entity.EntityTachyonBomb;
import assets.rivalrebels.common.entity.EntityTheoreticalTsar;
import assets.rivalrebels.common.entity.EntityTsar;
import assets.rivalrebels.common.explosion.NuclearExplosion;
import assets.rivalrebels.common.round.RivalRebelsPlayer;
import assets.rivalrebels.common.round.RivalRebelsRank;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemRoda extends Item {
   public static String[] entities = new String[]{
      "fire1",
      "fire2",
      "fire3",
      "plasma",
      "gas",
      "tesla",
      "cuchillo",
      "rocket",
      "einsten",
      "flesh",
      "bomb",
      "creeper",
      "snowman",
      "roddisk",
      "seeker",
      "pigman",
      "zombie",
      "tnt",
      "irongolem",
      "paratrooper",
      "oreblocks",
      "supplies",
      "blocks",
      "roda",
      "b83",
      "hackb83",
      "enchantedb83",
      "nuke",
      "tsar",
      "theoreticaltsar",
      "fatnuke",
      "antimatter",
      "tachyon"
   };
   static float[] randoms = new float[]{
      0.1F,
      0.1F,
      0.1F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.2F,
      0.9F,
      0.1F,
      0.0F,
      0.1F,
      0.1F,
      0.1F,
      0.0F,
      0.1F,
      0.1F,
      0.1F,
      0.1F,
      0.1F,
      0.1F,
      0.1F,
      0.1F,
      0.1F,
      0.1F,
      0.1F,
      0.1F,
      0.1F,
      0.1F,
      0.1F,
      0.1F,
      0.1F,
      0.1F
   };
   static float[] speeds = new float[]{
      1.6F,
      1.5F,
      1.2F,
      2.0F,
      1.3F,
      100.0F,
      1.3F,
      1.0F,
      3.0F,
      0.5F,
      4.3F,
      0.0F,
      1.5F,
      1.5F,
      1.7F,
      1.0F,
      1.5F,
      1.5F,
      1.5F,
      1.5F,
      1.5F,
      1.5F,
      1.5F,
      1.5F,
      3.0F,
      3.0F,
      3.0F,
      3.0F,
      3.0F,
      3.0F,
      3.0F,
      3.0F,
      3.0F,
      3.0F
   };
   public static int[] rates = new int[]{1, 1, 1, 8, 8, 1, 6, 8, 1, 2, 6, 10, 10, 10, 10, 10, 10, 2, 10, 10, 1, 1, 1, 1, 20, 20, 20, 20, 20, 20, 20, 1, 1};
   public static int rodaindex = 23;
   boolean pass = false;

   public static void spawn(int index, World world, double x, double y, double z, double mx, double my, double mz, double speed, double random) {
      if (entities[index] == "roda") {
         int newindex = world.field_73012_v.nextInt(index);
         spawn(newindex, world, x, y, z, mx, my, mz, speed, random);
      } else {
         speed *= speeds[index];
         random += randoms[index];
         double rx = world.field_73012_v.nextGaussian() * random;
         double ry = world.field_73012_v.nextGaussian() * random;
         double rz = world.field_73012_v.nextGaussian() * random;
         mx *= speed;
         my *= speed;
         mz *= speed;
         mx += rx;
         my += ry;
         mz += rz;
         Entity e = null;
         switch (index) {
            case 0:
               e = new EntityFlameBall(world, x, y, z, mx, my, mz);
               break;
            case 1:
               e = new EntityFlameBall1(world, x, y, z, mx, my, mz);
               break;
            case 2:
               e = new EntityFlameBall2(world, x, y, z, mx, my, mz);
               break;
            case 3:
               e = new EntityPlasmoid(world, x, y, z, mx, my, mz, 1.0F);
               break;
            case 4:
               e = new EntityGasGrenade(world, x, y, z, mx, my, mz);
               break;
            case 5:
               e = new EntityRaytrace(world, x, y, z, mx, my, mz);
               break;
            case 6:
               e = new EntityCuchillo(world, x, y, z, mx, my, mz);
               break;
            case 7:
               e = new EntityRocket(world, x, y, z, mx, my, mz);
               break;
            case 8:
               e = new EntityLaserBurst(world, x, y, z, mx, my, mz);
               break;
            case 9:
               e = new EntityGore(world, x, y, z, mx, my, mz, world.field_73012_v.nextInt(3), world.field_73012_v.nextInt(11) + 1);
               break;
            case 10:
               e = new EntityBomb(world, x, y, z, mx, my, mz);
               break;
            case 11:
               e = new EntityCreeper(world);
               e.func_70107_b(x, y, z);
               e.field_70159_w = mx;
               e.field_70181_x = my;
               e.field_70179_y = mz;
               break;
            case 12:
               e = new EntitySnowman(world);
               e.func_70107_b(x, y, z);
               e.field_70159_w = mx;
               e.field_70181_x = my;
               e.field_70179_y = mz;
               break;
            case 13:
               e = new EntityRoddiskRebel(world);
               e.func_70107_b(x, y, z);
               e.field_70159_w = mx;
               e.field_70181_x = my;
               e.field_70179_y = mz;
               break;
            case 14:
               e = new EntitySeekB83(world);
               e.func_70107_b(x, y, z);
               e.field_70159_w = mx;
               e.field_70181_x = my;
               e.field_70179_y = mz;
               break;
            case 15:
               e = new EntityPigZombie(world);
               e.func_70107_b(x, y, z);
               e.field_70159_w = mx;
               e.field_70181_x = my;
               e.field_70179_y = mz;
               break;
            case 16:
               e = new EntityZombie(world);
               e.func_70107_b(x, y, z);
               e.field_70159_w = mx;
               e.field_70181_x = my;
               e.field_70179_y = mz;
               break;
            case 17:
               e = new EntityTNTPrimed(world);
               e.func_70107_b(x, y, z);
               e.field_70159_w = mx;
               e.field_70181_x = my;
               e.field_70179_y = mz;
               ((EntityTNTPrimed)e).field_70516_a = 80;
               break;
            case 18:
               e = new EntityIronGolem(world);
               e.func_70107_b(x, y, z);
               e.field_70159_w = mx;
               e.field_70181_x = my;
               e.field_70179_y = mz;
               break;
            case 19:
               Entity zomb = new EntityPigZombie(world);
               zomb.func_70107_b(x, y, z);
               zomb.field_70159_w = mx;
               zomb.field_70181_x = my;
               zomb.field_70179_y = mz;
               world.func_72838_d(zomb);
               e = new EntityChicken(world);
               e.func_70107_b(x, y, z);
               e.field_70159_w = mx;
               e.field_70181_x = my;
               e.field_70179_y = mz;
               zomb.func_70078_a(e);
               break;
            case 20:
               Block[] blocks1 = NuclearExplosion.prblocks;
               Block b1 = blocks1[world.field_73012_v.nextInt(blocks1.length)];
               e = new EntityDebris(world, x, y, z, mx, my, mz, b1);
               break;
            case 21:
               Block[] blocks2 = new Block[]{
                  RivalRebels.ammunition, RivalRebels.supplies, RivalRebels.weapons, RivalRebels.explosives, RivalRebels.omegaarmor, RivalRebels.sigmaarmor
               };
               Block b2 = blocks2[world.field_73012_v.nextInt(blocks2.length)];
               e = new EntityDebris(world, x, y, z, mx, my, mz, b2);
               break;
            case 22:
               Block[] blocks3 = new Block[]{Blocks.field_150354_m, Blocks.field_150351_n, Blocks.field_150347_e, Blocks.field_150346_d};
               Block b3 = blocks3[world.field_73012_v.nextInt(blocks3.length)];
               e = new EntityDebris(world, x, y, z, mx, my, mz, b3);
            case 23:
            default:
               break;
            case 24:
               e = new EntityB83(world, x, y, z, mx, my, mz);
               break;
            case 25:
               e = new EntityHackB83(world, x, y, z, mx, my, mz, false);
               break;
            case 26:
               e = new EntityHackB83(world, x, y, z, mx, my, mz, true);
               break;
            case 27:
               e = new EntityNuke(world, x, y, z, mx, my, mz);
               break;
            case 28:
               e = new EntityTsar(world, x, y, z, mx, my, mz, 1);
               break;
            case 29:
               e = new EntityTheoreticalTsar(world, x, y, z, mx, my, mz, 1);
               break;
            case 30:
               e = new EntityHotPotato(world, x, y, z, mx, my, mz);
               break;
            case 31:
               e = new EntityAntimatterBomb(world, x, y, z, mx, my, mz, 1);
               break;
            case 32:
               e = new EntityTachyonBomb(world, x, y, z, mx, my, mz, 1);
         }

         if (!world.field_72995_K) {
            if (e != null) {
               world.func_72838_d(e);
            }
         }
      }
   }

   public ItemRoda() {
      this.field_77777_bU = 1;
      this.func_77637_a(RivalRebels.rralltab);
   }

   public ItemStack func_77659_a(ItemStack item, World world, EntityPlayer player) {
      if (!this.pass) {
         player.func_145747_a(new ChatComponentText("Password?"));
         this.pass = true;
      }

      player.func_71038_i();
      RivalRebelsPlayer rrp = RivalRebels.round.rrplayerlist.getForName(player.func_70005_c_());
      if (MinecraftServer.func_71276_C() != null && MinecraftServer.func_71276_C().func_71264_H()
         || rrp != null && (rrp.rrrank == RivalRebelsRank.LEADER || rrp.rrrank == RivalRebelsRank.OFFICER || rrp.rrrank == RivalRebelsRank.REP)) {
         player.func_71008_a(item, 256);
         item.field_77990_d.func_74768_a("happynewyear", item.field_77990_d.func_74762_e("happynewyear") + 10);
         if (item.field_77990_d.func_74762_e("happynewyear") > 1400 && !world.field_72995_K) {
            world.func_72838_d(new EntityNuclearBlast(world, player.field_70165_t, player.field_70163_u, player.field_70161_v, 6, true));
            player.field_71071_by.field_70462_a[player.field_71071_by.field_70461_c] = null;
            return item;
         }

         double motionX = -MathHelper.func_76126_a(player.field_70177_z / 180.0F * (float) Math.PI)
            * MathHelper.func_76134_b(player.field_70125_A / 180.0F * (float) Math.PI);
         double motionZ = MathHelper.func_76134_b(player.field_70177_z / 180.0F * (float) Math.PI)
            * MathHelper.func_76134_b(player.field_70125_A / 180.0F * (float) Math.PI);
         double motionY = -MathHelper.func_76126_a(player.field_70125_A / 180.0F * (float) Math.PI);
         spawn(rodaindex, world, player.field_70165_t, player.field_70163_u + 3.0, player.field_70161_v, motionX, motionY, motionZ, 1.0, 0.0);
      }

      return item;
   }

   public void func_77663_a(ItemStack item, World world, Entity entity, int par4, boolean par5) {
      if (!world.field_72995_K) {
         if (item.func_77978_p() == null) {
            item.field_77990_d = new NBTTagCompound();
         }

         if (item.field_77990_d.func_74762_e("happynewyear") > 0) {
            item.field_77990_d.func_74768_a("happynewyear", item.field_77990_d.func_74762_e("happynewyear") - 1);
         }
      }
   }

   public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
      if (player.field_70170_p.field_72995_K) {
         return true;
      }

      Random r = player.field_70170_p.field_73012_v;
      double x = entity.field_70165_t - player.field_70165_t;
      double y = entity.field_70163_u - player.field_70163_u;
      double z = entity.field_70161_v - player.field_70161_v;
      double dist = Math.sqrt(x * x + y * y + z * z);
      switch (r.nextInt(4)) {
         case 0:
            x /= -dist;
            y /= -dist;
            z /= -dist;
            entity.field_70159_w = x * 3.0 + (r.nextFloat() - 0.5F) * 0.1;
            entity.field_70181_x = y * 3.0 + (r.nextFloat() - 0.5F) * 0.1;
            entity.field_70179_y = z * 3.0 + (r.nextFloat() - 0.5F) * 0.1;
            break;
         case 1:
            x /= dist;
            y /= dist;
            z /= dist;
            entity.field_70159_w = x * 2.0 + (r.nextFloat() - 0.5F) * 0.1;
            entity.field_70181_x = y * 2.0 + (r.nextFloat() - 0.5F) * 0.1;
            entity.field_70179_y = z * 2.0 + (r.nextFloat() - 0.5F) * 0.1;
      }

      return true;
   }

   public void func_94581_a(IIconRegister iconregister) {
      this.field_77791_bV = iconregister.func_94245_a("RivalRebels:be");
   }

   public boolean func_77662_d() {
      return true;
   }
}
