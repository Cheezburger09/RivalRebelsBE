package assets.rivalrebels.common.tileentity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import assets.rivalrebels.common.entity.EntityTsar;
import assets.rivalrebels.common.packet.PacketDispatcher;
import assets.rivalrebels.common.packet.TextPacket;
import assets.rivalrebels.common.round.RivalRebelsTeam;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityTsarBomba extends TileEntity implements IInventory {
   public String username = null;
   public RivalRebelsTeam rrteam = null;
   private ItemStack[] chestContents = new ItemStack[36];
   public int numUsingPlayers;
   private int ticksSinceSync;
   public int countdown = RivalRebels.nuclearBombCountdown * 20;
   public int nuclear = 0;
   public int hydrogen = 0;
   public boolean hasAntennae = false;
   public boolean hasExplosive = false;
   public boolean hasFuse = false;
   public boolean hasChip = false;
   public boolean hasTrollface = false;
   public float megaton = 0.0F;

   public int func_70302_i_() {
      return 21;
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
      this.field_145847_g = par1NBTTagCompound.func_74762_e("TsarBombaMetadata");
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
      par1NBTTagCompound.func_74768_a("TsarBombaMetadata", this.field_145847_g);
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
      this.nuclear = 0;
      this.hydrogen = 0;

      for (int i = 3; i <= 18; i++) {
         if (this.func_70301_a(i) != null) {
            Item item = this.func_70301_a(i).func_77973_b();
            if (i < 11 && item == RivalRebels.nuclearelement) {
               this.nuclear++;
            } else if (i > 10 && item == RivalRebels.hydrod) {
               this.hydrogen++;
            }

            if (item == RivalRebels.trollmask) {
               this.hasTrollface = true;
            }
         }
      }

      if (this.nuclear == this.hydrogen) {
         this.megaton = this.nuclear * 6.25F;
      }

      if (this.func_70301_a(0) != null) {
         this.hasFuse = this.func_70301_a(0).func_77973_b() == RivalRebels.fuse;
      } else {
         this.hasFuse = false;
      }

      if (this.func_70301_a(20) != null) {
         this.hasChip = this.func_70301_a(20).func_77973_b() == RivalRebels.chip;
         if (this.hasChip) {
            this.rrteam = RivalRebelsTeam.getForID(this.func_70301_a(20).field_77990_d.func_74762_e("team"));
            this.username = this.func_70301_a(20).field_77990_d.func_74779_i("username");
         }
      } else {
         this.hasChip = false;
      }

      if (this.func_70301_a(1) != null && this.func_70301_a(2) != null) {
         this.hasAntennae = this.func_70301_a(1).func_77973_b() == RivalRebels.antenna && this.func_70301_a(2).func_77973_b() == RivalRebels.antenna;
      } else {
         this.hasAntennae = false;
      }

      if (this.func_70301_a(19) != null) {
         this.hasExplosive = true;
      } else {
         this.hasExplosive = false;
      }

      boolean sp = false;

      try {
         sp = !MinecraftServer.func_71276_C().func_71262_S() && MinecraftServer.func_71276_C().func_71203_ab().field_72404_b.size() == 1;
      } catch (NullPointerException var5) {
      }

      if (this.hasFuse && this.hasExplosive && this.nuclear == this.hydrogen && this.hasAntennae && this.hasChip) {
         double dist = 1000000.0;
         if (!sp || RivalRebels.stopSelfnukeinSP) {
            if (this.rrteam == RivalRebelsTeam.OMEGA) {
               dist = this.func_145835_a(RivalRebels.round.oObjx, this.field_145848_d, RivalRebels.round.oObjz);
            }

            if (this.rrteam == RivalRebelsTeam.SIGMA) {
               dist = this.func_145835_a(RivalRebels.round.sObjx, this.field_145848_d, RivalRebels.round.sObjz);
            }
         }

         if (dist > (RivalRebels.tsarBombaStrength + this.nuclear * this.hydrogen + 29) * (RivalRebels.tsarBombaStrength + this.nuclear * this.hydrogen + 29)) {
            if (this.countdown > 0) {
               this.countdown--;
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
                        + ".name RivalRebels.Defuse RivalRebels.tsar.tsar"
                  )
               );
         }
      } else {
         this.countdown = RivalRebels.nuclearBombCountdown * 20;
         if (RivalRebels.nuclearBombCountdown == 0) {
            this.countdown = 10;
         }
      }

      if (this.countdown == 200 && !this.field_145850_b.field_72995_K && RivalRebels.nuclearBombCountdown > 10) {
         PacketDispatcher.packetsys.sendToAll(new TextPacket("RivalRebels.WARNING RivalRebels.warning1"));
         PacketDispatcher.packetsys.sendToAll(new TextPacket("RivalRebels.WARNING RivalRebels.warning2"));
         PacketDispatcher.packetsys.sendToAll(new TextPacket("RivalRebels.WARNING RivalRebels.warning3"));
      }

      if (this.countdown % 20 == 0 && this.countdown <= 200 && RivalRebels.nuclearBombCountdown > 10) {
         RivalRebelsSoundPlayer.playSound(this.field_145850_b, 14, 0, this.field_145851_c, this.field_145848_d, this.field_145849_e, 100.0F);
      }

      if (this.countdown == 0 && this.nuclear != 0 && this.hydrogen != 0 && !this.field_145850_b.field_72995_K && this.nuclear == this.hydrogen) {
         this.field_145850_b.func_147449_b(this.field_145851_c, this.field_145848_d, this.field_145849_e, Blocks.field_150350_a);
         this.field_145850_b.field_73016_r = 2;
         float pitch = 0.0F;
         float yaw = 0.0F;
         switch (this.func_145832_p()) {
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
         }

         EntityTsar tsar = new EntityTsar(
            this.field_145850_b,
            this.field_145851_c + 0.5F,
            this.field_145848_d + 1.0F,
            this.field_145849_e + 0.5F,
            yaw,
            pitch,
            this.hydrogen,
            this.hasTrollface
         );
         this.field_145850_b.func_72838_d(tsar);
      }

      if (this.countdown == 0 && this.nuclear == 0 && this.hydrogen == 0) {
         this.field_145850_b.func_147449_b(this.field_145851_c, this.field_145848_d, this.field_145849_e, Blocks.field_150350_a);
         this.field_145850_b.func_72876_a(null, this.field_145851_c, this.field_145848_d, this.field_145849_e, 4.0F, false);
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
         this.field_145851_c - 5, this.field_145848_d, this.field_145849_e - 5, this.field_145851_c + 6, this.field_145848_d + 2, this.field_145849_e + 6
      );
   }

   @SideOnly(Side.CLIENT)
   public double func_145833_n() {
      return 16384.0;
   }

   public boolean func_94041_b(int i, ItemStack itemstack) {
      return true;
   }

   public String func_145825_b() {
      return "Tsar Bomba";
   }

   public boolean func_145818_k_() {
      return false;
   }

   public void func_70295_k_() {
   }

   public void func_70305_f() {
   }
}
