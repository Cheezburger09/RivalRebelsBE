package assets.rivalrebels.common.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import java.util.List;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class TileEntitySigmaObjective extends TileEntity implements IInventory, ICommandSender {
   private ItemStack[] chestContents = new ItemStack[16];
   public double slide = 0.0;
   double test = 3.0915926535897933;
   public int numUsingPlayers;
   private int ticksSinceSync;

   public int func_70302_i_() {
      return 16;
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
      return 64;
   }

   public boolean func_70300_a(EntityPlayer par1EntityPlayer) {
      return this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e) != this
         ? false
         : par1EntityPlayer.func_70092_e(this.field_145851_c + 0.5, this.field_145848_d + 0.5, this.field_145849_e + 0.5) <= 64.0;
   }

   public void func_145845_h() {
      super.func_145845_h();
      this.ticksSinceSync++;
      this.slide = (Math.cos(this.test) + 1.0) / 32.0 * 10.0;
      super.func_145845_h();
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
         if (this.slide < 0.621) {
            this.test += 0.05;
         }
      } else if (this.slide > 0.004) {
         this.test -= 0.05;
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

   public void openChest() {
      this.numUsingPlayers++;
   }

   public void closeChest() {
      this.numUsingPlayers--;
   }

   public AxisAlignedBB getRenderBoundingBox() {
      return AxisAlignedBB.func_72330_a(
         this.field_145851_c - 1, this.field_145848_d - 1, this.field_145849_e - 1, this.field_145851_c + 2, this.field_145848_d + 2, this.field_145849_e + 2
      );
   }

   @SideOnly(Side.CLIENT)
   public double func_145833_n() {
      return 16384.0;
   }

   public void func_145843_s() {
      super.func_145843_s();
      this.func_145836_u();
   }

   public boolean func_94041_b(int i, ItemStack itemstack) {
      return true;
   }

   public String func_70005_c_() {
      return "RivalRebelsSigma";
   }

   public boolean func_70003_b(int i, String s) {
      return true;
   }

   public ChunkCoordinates func_82114_b() {
      return new ChunkCoordinates(this.field_145851_c, this.field_145848_d, this.field_145849_e);
   }

   public World func_130014_f_() {
      return this.field_145850_b;
   }

   public IChatComponent func_145748_c_() {
      return null;
   }

   public void func_145747_a(IChatComponent p_145747_1_) {
   }

   public String func_145825_b() {
      return "Objective";
   }

   public boolean func_145818_k_() {
      return false;
   }

   public void func_70295_k_() {
   }

   public void func_70305_f() {
   }
}
