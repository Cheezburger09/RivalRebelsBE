package assets.rivalrebels.common.tileentity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import assets.rivalrebels.common.entity.EntityRhodes;
import assets.rivalrebels.common.item.weapon.ItemRoda;
import assets.rivalrebels.common.packet.ADSUpdatePacket;
import assets.rivalrebels.common.packet.PacketDispatcher;
import assets.rivalrebels.common.round.RivalRebelsPlayer;
import assets.rivalrebels.common.round.RivalRebelsTeam;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public class TileEntityReciever extends TileEntityMachineBase implements IInventory {
   public double yaw;
   public double pitch;
   public Entity target;
   public double xO = 0.0;
   public double zO = 0.0;
   int direction;
   double ll = -50.0;
   double ul = 90.0;
   double scale = 1.5;
   public ItemStack[] chestContents = new ItemStack[9];
   private int ticksSinceLastTarget = 0;
   public int yawLimit = 180;
   public boolean kTeam = true;
   public boolean kPlayers = false;
   public boolean kMobs = true;
   public boolean hasWeapon = false;
   private RivalRebelsTeam team;
   private int ammoCounter;
   private double prevTx = 0.0;
   private double prevTy = 0.0;
   private double prevTz = 0.0;
   private Entity le = null;
   public int wepSelected;
   public static int staticEntityIndex = 1;
   public int entityIndex = 1;
   public String username = "nohbdy";
   private int ticksincepacket;
   int ticksSinceLastShot = 0;

   public TileEntityReciever() {
      this.entityIndex = staticEntityIndex;
      this.pInM = 400.0F;
      if (RivalRebels.freeDragonAmmo) {
         this.hasWeapon = true;
         this.team = RivalRebelsTeam.NONE;
         this.kPlayers = true;
         this.chestContents[3] = new ItemStack(RivalRebels.battery, 64);
         this.chestContents[4] = new ItemStack(RivalRebels.battery, 64);
         this.chestContents[5] = new ItemStack(RivalRebels.battery, 64);
         this.chestContents[0] = new ItemStack(RivalRebels.fuel, 64);
         this.chestContents[1] = new ItemStack(RivalRebels.fuel, 64);
         this.chestContents[2] = new ItemStack(RivalRebels.fuel, 64);
      }
   }

   @Override
   public void func_145845_h() {
      super.func_145845_h();
      if (this.xO == this.zO) {
         this.updateDirection();
      }

      this.powered(0.0F, 0.0F);
      this.convertBatteryToEnergy();
      if (!this.hasWeapon && this.wepSelected != 0 && this.hasWepReqs()) {
         this.setWep(this.wepSelected);
      }
   }

   @SideOnly(Side.CLIENT)
   public double func_145833_n() {
      return 16384.0;
   }

   public AxisAlignedBB getRenderBoundingBox() {
      return AxisAlignedBB.func_72330_a(
         this.field_145851_c - 1, this.field_145848_d - 1, this.field_145849_e - 1, this.field_145851_c + 2, this.field_145848_d + 2, this.field_145849_e + 2
      );
   }

   private boolean hasBattery() {
      return this.chestContents[3] != null || this.chestContents[4] != null || this.chestContents[5] != null || RivalRebels.infiniteAmmo;
   }

   private void convertBatteryToEnergy() {
      while (this.pInR < this.pInM / 2.0F && this.hasBattery()) {
         this.pInR += 800.0F;
         this.consumeBattery();
      }
   }

   private void consumeBattery() {
      if (this.chestContents[3] != null) {
         this.func_70298_a(3, 1);
      } else if (this.chestContents[4] != null) {
         this.func_70298_a(4, 1);
      } else if (this.chestContents[5] != null) {
         this.func_70298_a(5, 1);
      }
   }

   public boolean hasWepReqs() {
      return this.chestContents[6] != null && this.chestContents[7] != null && this.chestContents[8] != null;
   }

   public void setWep(int wep) {
      if (wep != 0) {
         if (this.chestContents[6] != null && this.chestContents[6].field_77990_d != null) {
            this.team = RivalRebelsTeam.getForID(this.chestContents[6].field_77990_d.func_74762_e("team"));
            this.username = this.chestContents[6].field_77990_d.func_74779_i("username");
         }

         this.chestContents[6] = this.chestContents[7] = this.chestContents[8] = null;
         this.hasWeapon = true;
         this.wepSelected = 0;
      }
   }

   @Override
   public float powered(float power, float distance) {
      if (this.hasWeapon) {
         this.ticksSinceLastTarget++;
         if (this.ticksSinceLastTarget == 3) {
            this.target = this.getTarget();
            this.ticksSinceLastTarget = 0;
         }

         this.ticksSinceLastShot++;
         if (this.ticksSinceLastShot > ItemRoda.rates[this.entityIndex] && this.target != null) {
            this.ticksSinceLastShot = 0;
            this.lookAt(this.target);
            if (this.hasAmmo()) {
               if (this.field_145850_b.field_73012_v.nextInt(3) == 0) {
                  RivalRebelsSoundPlayer.playSound(this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e, 8.0, 1.0, 0.1F);
               }

               float rotationYaw = (float)(180.0 - this.yaw);
               float rotationPitch = (float)(-this.pitch);
               double motionX = -MathHelper.func_76126_a(rotationYaw / 180.0F * (float) Math.PI)
                  * MathHelper.func_76134_b(rotationPitch / 180.0F * (float) Math.PI);
               double motionZ = MathHelper.func_76134_b(rotationYaw / 180.0F * (float) Math.PI)
                  * MathHelper.func_76134_b(rotationPitch / 180.0F * (float) Math.PI);
               double motionY = -MathHelper.func_76126_a(rotationPitch / 180.0F * (float) Math.PI);
               ItemRoda.spawn(
                  this.entityIndex,
                  this.field_145850_b,
                  this.field_145851_c + this.xO + 0.5,
                  this.field_145848_d + 0.75,
                  this.field_145849_e + this.zO + 0.5,
                  motionX,
                  motionY,
                  motionZ,
                  1.0,
                  0.0
               );
               this.useAmmo();
            }

            return power - 4.0F;
         }

         this.ticksincepacket++;
         if (this.ticksincepacket > 6 && !this.field_145850_b.field_72995_K) {
            this.ticksincepacket = 0;
            PacketDispatcher.packetsys
               .sendToAll(
                  new ADSUpdatePacket(
                     this.field_145851_c,
                     this.field_145848_d,
                     this.field_145849_e,
                     this.yawLimit,
                     this.kMobs,
                     this.kTeam,
                     this.kPlayers,
                     this.hasWeapon,
                     this.username
                  )
               );
         }
      }

      return power - 1.0F;
   }

   private boolean hasAmmo() {
      return this.chestContents[0] != null || this.chestContents[1] != null || this.chestContents[2] != null || RivalRebels.infiniteAmmo;
   }

   private boolean useAmmo() {
      this.ammoCounter++;
      if (this.ammoCounter == 9) {
         this.ammoCounter = 0;
         if (this.chestContents[0] != null) {
            this.func_70298_a(0, 1);
         } else if (this.chestContents[1] != null) {
            this.func_70298_a(1, 1);
         } else {
            if (this.chestContents[2] == null) {
               return false;
            }

            this.func_70298_a(2, 1);
         }

         return true;
      } else {
         return true;
      }
   }

   private Entity getTarget() {
      Object[] iter = this.field_145850_b.field_72996_f.toArray();
      double ldist = 1600.0;
      Entity result = null;

      for (int i = 0; i < iter.length; i++) {
         Entity e = (Entity)iter[i];
         double dist = e.func_70092_e(this.field_145851_c + 0.5 + this.xO, this.field_145848_d + 0.5, this.field_145849_e + 0.5 + this.zO);
         if (dist < ldist && this.canTarget(e)) {
            ldist = dist;
            result = e;
         }
      }

      return result;
   }

   private boolean canTarget(Entity e) {
      return e != null
         && (e instanceof EntityLivingBase && ((EntityLivingBase)e).func_110143_aJ() > 0.0F || e instanceof EntityRhodes)
         && this.getPitchTo(e, 0.0) > this.ll
         && this.getPitchTo(e, 0.0) < this.ul
         && this.isValidTarget(e)
         && this.canSee(e);
   }

   private boolean isValidTarget(Entity e) {
      if (e == null) {
         return false;
      }

      if (e instanceof EntityPlayer) {
         EntityPlayer p = (EntityPlayer)e;
         if (p.field_71075_bZ.field_75098_d) {
            return false;
         } else if (this.kPlayers) {
            return true;
         } else if (!this.kTeam) {
            return false;
         } else {
            RivalRebelsPlayer rrp = RivalRebels.round.rrplayerlist.getForName(((EntityPlayer)e).func_70005_c_());
            if (rrp == null) {
               return this.kTeam;
            } else if (rrp.rrteam == RivalRebelsTeam.NONE) {
               return !p.func_70005_c_().equals(this.username);
            } else {
               return rrp.rrteam != this.team ? this.kTeam : false;
            }
         }
      } else {
         return this.kMobs
            && (
               e instanceof EntityRhodes
                  || e instanceof EntityMob
                     && !(e instanceof EntityAnimal)
                     && !(e instanceof EntityBat)
                     && !(e instanceof EntityVillager)
                     && !(e instanceof EntitySquid)
                  || e instanceof EntityGhast
            );
      }
   }

   private boolean canSee(Entity e) {
      int yaw = (int)(this.getYawTo(e, 0.0) - this.getBaseRotation() + 360.0) % 360;
      if (Math.abs(yaw) > this.yawLimit / 2 && Math.abs(yaw) < 360 - this.yawLimit / 2) {
         return false;
      }

      Vec3 start = Vec3.func_72443_a(e.field_70165_t, e.field_70163_u + e.func_70047_e(), e.field_70161_v);
      Vec3 end = Vec3.func_72443_a(this.field_145851_c + 0.5 + this.xO, this.field_145848_d + 0.5, this.field_145849_e + 0.5 + this.zO);
      MovingObjectPosition mop = this.field_145850_b.func_147447_a(start, end, false, true, false);
      return mop == null || mop.field_72311_b == this.field_145851_c && mop.field_72312_c == this.field_145848_d && mop.field_72309_d == this.field_145849_e;
   }

   private void updateDirection() {
      this.direction = this.field_145850_b.func_72805_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
      this.xO = 0.0;
      this.zO = 0.0;
      if (this.direction == 2) {
         this.zO = -0.76F;
      }

      if (this.direction == 4) {
         this.xO = -0.76F;
      }

      if (this.direction == 3) {
         this.zO = 0.76F;
      }

      if (this.direction == 5) {
         this.xO = 0.76F;
      }
   }

   public int lookAt(Entity t) {
      double dist = t.func_70011_f(this.field_145851_c + 0.5 + this.xO, this.field_145848_d + 0.5, this.field_145849_e + 0.5 + this.zO);
      double ya = this.getYawTo(t, this.le == t ? dist * 1.0 : 0.0);
      double pi = this.getPitchTo(t, this.le == t ? dist * 1.0 : 0.0);
      if (pi > this.ll && pi < this.ul) {
         this.pitch = (this.pitch + this.pitch + this.pitch + pi) / 4.0;
         if (this.yaw - ya < -180.0) {
            this.yaw += 360.0;
         } else if (this.yaw - ya > 180.0) {
            this.yaw -= 360.0;
         }

         this.yaw = (this.yaw + this.yaw + this.yaw + ya) / 4.0;
         this.prevTx = t.field_70165_t;
         this.prevTy = t.field_70163_u;
         this.prevTz = t.field_70161_v;
         this.le = t;
         return 1;
      } else {
         return 0;
      }
   }

   public double getYawTo(Entity t, double off) {
      double x = this.field_145851_c + 0.5 + this.xO - t.field_70165_t - (t.field_70165_t - this.prevTx) * off;
      double z = this.field_145849_e + 0.5 + this.zO - t.field_70161_v - (t.field_70161_v - this.prevTz) * off;
      double ya = Math.atan2(x, z);
      return ya / Math.PI * 180.0;
   }

   public double getPitchTo(Entity t, double off) {
      double x = this.field_145851_c + 0.5 + this.xO - t.field_70165_t - (t.field_70165_t - this.prevTx) * off;
      double y = this.field_145848_d + 0.5 * this.scale - t.field_70163_u - t.func_70047_e() - (t.field_70163_u - this.prevTy) * off;
      double z = this.field_145849_e + 0.5 + this.zO - t.field_70161_v - (t.field_70161_v - this.prevTz) * off;
      double d = Math.sqrt(x * x + z * z);
      double pi = Math.atan2(d, -y);
      return 90.0 - pi / Math.PI * 180.0;
   }

   public int getBaseRotation() {
      int m = this.func_145832_p();
      short r = 0;
      if (m == 2) {
         r = 0;
      }

      if (m == 3) {
         r = 180;
      }

      if (m == 4) {
         r = 90;
      }

      if (m == 5) {
         r = 270;
      }

      return r;
   }

   public int func_70302_i_() {
      return 9;
   }

   public ItemStack func_70301_a(int par1) {
      return par1 >= this.func_70302_i_() ? null : this.chestContents[par1];
   }

   public ItemStack func_70298_a(int par1, int par2) {
      if (this.chestContents[par1] != null) {
         if (this.chestContents[par1].field_77994_a <= par2) {
            ItemStack var3 = this.chestContents[par1];
            this.chestContents[par1] = null;
            return var3;
         }

         ItemStack var3 = this.chestContents[par1].func_77979_a(par2);
         if (this.chestContents[par1].field_77994_a == 0) {
            this.chestContents[par1] = null;
         }

         return var3;
      } else {
         return null;
      }
   }

   public ItemStack func_70304_b(int par1) {
      if (par1 >= this.func_70302_i_()) {
         return null;
      } else if (this.chestContents[par1] != null) {
         ItemStack var2 = this.chestContents[par1];
         this.chestContents[par1] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void func_70299_a(int par1, ItemStack par2ItemStack) {
      if (par1 < this.func_70302_i_()) {
         this.chestContents[par1] = par2ItemStack;
         if (par2ItemStack != null && par2ItemStack.field_77994_a > this.func_70297_j_()) {
            par2ItemStack.field_77994_a = this.func_70297_j_();
         }
      }
   }

   public int func_70297_j_() {
      return 64;
   }

   public boolean func_70300_a(EntityPlayer par1EntityPlayer) {
      return this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e) != this
         ? false
         : par1EntityPlayer.func_70092_e(this.field_145851_c + 0.5, this.field_145848_d + 0.5, this.field_145849_e + 0.5) <= 64.0;
   }

   public boolean func_94041_b(int i, ItemStack itemstack) {
      return true;
   }

   @Override
   public void func_145839_a(NBTTagCompound nbt) {
      super.func_145839_a(nbt);
      NBTTagList nbttaglist = nbt.func_150295_c("Items", 10);
      this.chestContents = new ItemStack[this.func_70302_i_()];

      for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
         NBTTagCompound nbt1 = nbttaglist.func_150305_b(i);
         int j = nbt1.func_74771_c("Slot") & 255;
         if (j >= 0 && j < this.chestContents.length) {
            this.chestContents[j] = ItemStack.func_77949_a(nbt1);
         }
      }

      this.yawLimit = nbt.func_74762_e("yawLimit");
      this.kPlayers = nbt.func_74767_n("kPlayers");
      this.kTeam = nbt.func_74767_n("kTeam");
      this.kMobs = nbt.func_74767_n("kMobs");
      this.hasWeapon = nbt.func_74767_n("hasWeapon");
      this.username = nbt.func_74779_i("username");
      this.team = RivalRebelsTeam.getForID(nbt.func_74762_e("team"));
      this.entityIndex = nbt.func_74762_e("entityIndex");
   }

   @Override
   public void func_145841_b(NBTTagCompound nbt) {
      super.func_145841_b(nbt);
      NBTTagList nbttaglist = new NBTTagList();

      for (int i = 0; i < this.chestContents.length; i++) {
         if (this.chestContents[i] != null) {
            NBTTagCompound nbt1 = new NBTTagCompound();
            nbt1.func_74774_a("Slot", (byte)i);
            this.chestContents[i].func_77955_b(nbt1);
            nbttaglist.func_74742_a(nbt1);
         }
      }

      nbt.func_74782_a("Items", nbttaglist);
      nbt.func_74768_a("yawLimit", this.yawLimit);
      nbt.func_74757_a("kPlayers", this.kPlayers);
      nbt.func_74757_a("kTeam", this.kTeam);
      nbt.func_74757_a("kMobs", this.kMobs);
      nbt.func_74757_a("hasWeapon", this.hasWeapon);
      nbt.func_74778_a("username", this.username);
      nbt.func_74768_a("entityIndex", this.entityIndex);
      if (this.team != null) {
         nbt.func_74768_a("team", this.team.ordinal());
      }
   }

   public String func_145825_b() {
      return "Automated Defense System";
   }

   public boolean func_145818_k_() {
      return false;
   }

   public void func_70295_k_() {
   }

   public void func_70305_f() {
   }
}
