package assets.rivalrebels.common.tileentity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.entity.EntityNuke;
import assets.rivalrebels.common.packet.PacketDispatcher;
import assets.rivalrebels.common.packet.TextPacket;
import assets.rivalrebels.common.round.RivalRebelsTeam;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityNuclearBomb extends TileEntity implements IInventory {
   public String username = null;
   public RivalRebelsTeam rrteam = null;
   private ItemStack[] chestContents = new ItemStack[36];
   public int numUsingPlayers;
   private int ticksSinceSync;
   public int Countdown = RivalRebels.nuclearBombCountdown * 20;
   public int AmountOfCharges = 0;
   public boolean hasTrollface = false;
   public boolean hasExplosive = false;
   public boolean hasFuse = false;
   public boolean hasChip = false;

   public int func_70302_i_() {
      return 13;
   }

   public ItemStack func_70301_a(int par1) {
      return this.chestContents[par1];
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
      if (this.chestContents[par1] != null) {
         ItemStack var2 = this.chestContents[par1];
         this.chestContents[par1] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void func_70299_a(int par1, ItemStack par2ItemStack) {
      this.chestContents[par1] = par2ItemStack;
      if (par2ItemStack != null && par2ItemStack.field_77994_a > this.func_70297_j_()) {
         par2ItemStack.field_77994_a = this.func_70297_j_();
      }
   }

   public void func_145839_a(NBTTagCompound par1NBTTagCompound) {
      super.func_145839_a(par1NBTTagCompound);
      this.field_145847_g = par1NBTTagCompound.func_74762_e("NuclearBombMetadata");
      NBTTagList var2 = par1NBTTagCompound.func_150295_c("Items", 10);
      this.chestContents = new ItemStack[this.func_70302_i_()];

      for (int var3 = 0; var3 < var2.func_74745_c(); var3++) {
         NBTTagCompound var4 = var2.func_150305_b(var3);
         int var5 = var4.func_74771_c("Slot") & 255;
         if (var5 >= 0 && var5 < this.chestContents.length) {
            this.chestContents[var5] = ItemStack.func_77949_a(var4);
         }
      }
   }

   public void func_145841_b(NBTTagCompound par1NBTTagCompound) {
      super.func_145841_b(par1NBTTagCompound);
      par1NBTTagCompound.func_74768_a("NuclearBombMetadata", this.field_145847_g);
      NBTTagList var2 = new NBTTagList();

      for (int var3 = 0; var3 < this.chestContents.length; var3++) {
         if (this.chestContents[var3] != null) {
            NBTTagCompound var4 = new NBTTagCompound();
            var4.func_74774_a("Slot", (byte)var3);
            this.chestContents[var3].func_77955_b(var4);
            var2.func_74742_a(var4);
         }
      }

      par1NBTTagCompound.func_74782_a("Items", var2);
   }

   public int func_70297_j_() {
      return 1;
   }

   public boolean func_70300_a(EntityPlayer par1EntityPlayer) {
      return this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e) != this
         ? false
         : par1EntityPlayer.func_70092_e(this.field_145851_c + 0.5, this.field_145848_d + 0.5, this.field_145849_e + 0.5) <= 64.0;
   }

   public void func_145836_u() {
      super.func_145836_u();
   }

   public void func_145845_h() {
      this.AmountOfCharges = 0;
      this.hasTrollface = false;

      for (int i = 1; i <= 10; i++) {
         if (this.func_70301_a(i) != null && this.func_70301_a(i).func_77973_b() == RivalRebels.nuclearelement) {
            this.AmountOfCharges++;
         }

         if (this.func_70301_a(i) != null && this.func_70301_a(i).func_77973_b() == RivalRebels.trollmask) {
            this.hasTrollface = true;
         }
      }

      if (this.func_70301_a(0) != null) {
         this.hasFuse = this.func_70301_a(0).func_77973_b() == RivalRebels.fuse;
      } else {
         this.hasFuse = false;
      }

      if (this.func_70301_a(12) != null) {
         this.hasChip = this.func_70301_a(12).func_77973_b() == RivalRebels.chip;
         if (this.hasChip) {
            this.rrteam = RivalRebelsTeam.getForID(this.func_70301_a(12).field_77990_d.func_74762_e("team"));
            this.username = this.func_70301_a(12).field_77990_d.func_74779_i("username");
         }
      } else {
         this.hasChip = false;
      }

      if (this.func_70301_a(11) != null) {
         this.hasExplosive = true;
      } else {
         this.hasExplosive = false;
      }

      boolean sp = false;

      try {
         sp = !MinecraftServer.func_71276_C().func_71262_S() && MinecraftServer.func_71276_C().func_71203_ab().field_72404_b.size() == 1;
      } catch (NullPointerException var4) {
      }

      if (this.hasFuse && this.hasExplosive && this.hasChip) {
         double dist = 1.0E7;
         if (!sp || RivalRebels.stopSelfnukeinSP) {
            if (this.rrteam == RivalRebelsTeam.OMEGA) {
               dist = this.func_145835_a(RivalRebels.round.oObjx, this.field_145848_d, RivalRebels.round.oObjz);
            }

            if (this.rrteam == RivalRebelsTeam.SIGMA) {
               dist = this.func_145835_a(RivalRebels.round.sObjx, this.field_145848_d, RivalRebels.round.sObjz);
            }
         }

         if (dist
            > (RivalRebels.nuclearBombStrength + this.AmountOfCharges * this.AmountOfCharges + 29)
               * (RivalRebels.nuclearBombStrength + this.AmountOfCharges * this.AmountOfCharges + 29)) {
            if (this.Countdown > 0) {
               this.Countdown--;
            }
         } else if (!this.field_145850_b.field_72995_K) {
            this.chestContents[0] = null;
            PacketDispatcher.packetsys.sendToAll(new TextPacket("RivalRebels.WARNING " + this.username));
            PacketDispatcher.packetsys
               .sendToAll(
                  new TextPacket(
                     "RivalRebels.Status "
                        + (
                           this.rrteam == RivalRebelsTeam.OMEGA
                              ? RivalRebels.omegaobj.func_149739_a()
                              : (this.rrteam == RivalRebelsTeam.SIGMA ? RivalRebels.sigmaobj.func_149739_a() : "NONE")
                        )
                        + ".name RivalRebels.Defuse RivalRebels.nuke.name"
                  )
               );
         }
      } else {
         this.Countdown = RivalRebels.nuclearBombCountdown * 20;
      }

      if (this.Countdown == 200 && !this.field_145850_b.field_72995_K && RivalRebels.nuclearBombCountdown > 10) {
         PacketDispatcher.packetsys.sendToAll(new TextPacket("RivalRebels.WARNING RivalRebels.warning1"));
         PacketDispatcher.packetsys.sendToAll(new TextPacket("RivalRebels.WARNING RivalRebels.warning2"));
         PacketDispatcher.packetsys.sendToAll(new TextPacket("RivalRebels.WARNING RivalRebels.warning3"));
      }

      if (this.Countdown == 0 && this.AmountOfCharges != 0 && !this.field_145850_b.field_72995_K) {
         this.field_145850_b.field_73016_r = 2;
         float pitch = 0.0F;
         float yaw = 0.0F;
         switch (this.func_145832_p()) {
            case 1:
               pitch = 90.0F;
               break;
            case 2:
               yaw = 180.0F;
               break;
            case 3:
               yaw = 0.0F;
               break;
            case 4:
               yaw = 270.0F;
               break;
            case 5:
               yaw = 90.0F;
               break;
            default:
               pitch = -90.0F;
         }

         this.field_145850_b
            .func_72838_d(
               new EntityNuke(
                  this.field_145850_b,
                  this.field_145851_c + 0.5F,
                  this.field_145848_d + 0.5F,
                  this.field_145849_e + 0.5F,
                  yaw,
                  pitch,
                  this.AmountOfCharges,
                  this.hasTrollface
               )
            );
         this.field_145850_b.func_147449_b(this.field_145851_c, this.field_145848_d, this.field_145849_e, Blocks.field_150350_a);
      }

      if (this.Countdown == 0 && this.AmountOfCharges == 0) {
         this.field_145850_b.func_72876_a(null, this.field_145851_c, this.field_145848_d, this.field_145849_e, 4.0F, true);
         this.field_145850_b.func_147449_b(this.field_145851_c, this.field_145848_d, this.field_145849_e, Blocks.field_150350_a);
      }

      super.func_145845_h();
   }

   public boolean func_145842_c(int par1, int par2) {
      if (par1 == 1) {
         this.numUsingPlayers = par2;
         return true;
      } else {
         return false;
      }
   }

   public void func_145843_s() {
      this.func_145836_u();
      super.func_145843_s();
   }

   public AxisAlignedBB getRenderBoundingBox() {
      return AxisAlignedBB.func_72330_a(
         this.field_145851_c - 1, this.field_145848_d - 1, this.field_145849_e - 1, this.field_145851_c + 2, this.field_145848_d + 2, this.field_145849_e + 2
      );
   }

   @SideOnly(Side.CLIENT)
   public double func_145833_n() {
      return 65536.0;
   }

   public boolean func_94041_b(int i, ItemStack itemstack) {
      return true;
   }

   public String func_145825_b() {
      return "Nuclear Bomb";
   }

   public boolean func_145818_k_() {
      return false;
   }

   public void func_70295_k_() {
   }

   public void func_70305_f() {
   }
}
