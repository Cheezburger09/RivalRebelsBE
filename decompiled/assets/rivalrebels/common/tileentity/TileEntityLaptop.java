package assets.rivalrebels.common.tileentity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.item.weapon.ItemBinoculars;
import assets.rivalrebels.common.packet.LaptopRefreshPacket;
import assets.rivalrebels.common.packet.PacketDispatcher;
import assets.rivalrebels.common.round.RivalRebelsTeam;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityLaptop extends TileEntity implements IInventory {
   public String username = null;
   public RivalRebelsTeam rrteam = null;
   private ItemStack[] chestContents = new ItemStack[14];
   public double slide = 0.0;
   double test = Math.PI;
   public int b2spirit = 0;
   public int b2carpet = 0;
   public int numUsingPlayers;
   private int ticksSinceSync;
   private boolean listed;

   public int func_70302_i_() {
      return 14;
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

      this.b2spirit = nbt.func_74762_e("b2spirit");
      this.b2carpet = nbt.func_74762_e("b2carpet");
   }

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
      nbt.func_74768_a("b2spirit", this.b2spirit);
      nbt.func_74768_a("b2carpet", this.b2carpet);
   }

   public int func_70297_j_() {
      return 64;
   }

   public boolean func_70300_a(EntityPlayer par1EntityPlayer) {
      return this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e) != this
         ? false
         : par1EntityPlayer.func_70092_e(this.field_145851_c + 0.5, this.field_145848_d + 0.5, this.field_145849_e + 0.5) <= 64.0;
   }

   public void onGoButtonPressed() {
      if (this.isReady()) {
         for (int j = 0; j < 3; j++) {
            if (this.func_70301_a(j + 6) != null && this.func_70301_a(j + 11) != null) {
               if (this.func_70301_a(j + 6).func_77973_b() == RivalRebels.nuclearelement && this.func_70301_a(j + 11).func_77973_b() == RivalRebels.hydrod) {
                  this.b2spirit++;
                  this.func_70299_a(j + 6, null);
                  this.func_70299_a(j + 11, null);
               } else if (this.func_70301_a(j + 6).func_77973_b() == Item.func_150898_a(RivalRebels.timedbomb)
                  && this.func_70301_a(j + 11).func_77973_b() == Item.func_150898_a(RivalRebels.timedbomb)) {
                  this.b2carpet++;
                  this.func_70299_a(j + 6, null);
                  this.func_70299_a(j + 11, null);
               }
            }
         }

         this.func_70299_a(4, null);
         this.func_70299_a(5, null);
         this.func_70299_a(9, null);
         this.func_70299_a(10, null);
      }

      if (RivalRebels.freeb83nukes) {
         this.b2spirit += 10;
         this.b2carpet += 10;
      }

      this.refreshTasks();
   }

   public boolean hasChips() {
      boolean r = true;
      this.rrteam = RivalRebelsTeam.NONE;

      for (int j = 0; j < 4; j++) {
         if (this.func_70301_a(j) == null) {
            r = false;
         } else {
            if (this.func_70301_a(j).field_77990_d == null) {
               this.func_70301_a(j).field_77990_d = new NBTTagCompound();
            }

            if (this.rrteam == RivalRebelsTeam.NONE) {
               this.rrteam = RivalRebelsTeam.getForID(this.func_70301_a(j).field_77990_d.func_74762_e("team"));
            } else if (this.rrteam != RivalRebelsTeam.getForID(this.func_70301_a(j).field_77990_d.func_74762_e("team"))) {
               r = false;
            }
         }
      }

      return r;
   }

   public void func_145845_h() {
      super.func_145845_h();
      this.ticksSinceSync++;
      this.slide = (Math.cos(this.test) + 1.0) * 45.0;
      ItemBinoculars.add(this);
      List players = this.field_145850_b.field_73010_i;
      Iterator iter = players.iterator();
      boolean i = false;

      while (iter.hasNext()) {
         EntityPlayer player = (EntityPlayer)iter.next();
         if (player.func_70092_e(this.field_145851_c + 0.5F, this.field_145848_d + 0.5F, this.field_145849_e + 0.5F) <= 9.0) {
            i = true;
         }
      }

      if (i) {
         if (this.slide < 89.995) {
            this.test += 0.05;
         }
      } else if (this.slide > 0.004) {
         this.test -= 0.05;
      }

      if (this.b2spirit > 0 && !this.hasChips()) {
         this.b2spirit--;
         this.refreshTasks();
      }
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
      super.func_145843_s();
      this.func_145836_u();
      ItemBinoculars.remove(this);
   }

   public boolean func_94041_b(int i, ItemStack itemstack) {
      return true;
   }

   public String func_145825_b() {
      return "Laptop";
   }

   public boolean func_145818_k_() {
      return false;
   }

   public void func_70295_k_() {
   }

   public void func_70305_f() {
   }

   public void refreshTasks() {
      PacketDispatcher.packetsys
         .sendToAll(new LaptopRefreshPacket(this.field_145851_c, this.field_145848_d, this.field_145849_e, this.b2spirit, this.b2carpet));
   }

   public boolean isReady() {
      return this.hasChips() && this.func_70301_a(4) != null && this.func_70301_a(5) != null && this.func_70301_a(9) != null && this.func_70301_a(10) != null;
   }
}
