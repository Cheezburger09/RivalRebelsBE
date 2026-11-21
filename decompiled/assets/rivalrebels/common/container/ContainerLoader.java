package assets.rivalrebels.common.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerLoader extends Container {
   private IInventory lowerLoaderInventory;
   private IInventory upperLoaderInventory;

   public ContainerLoader(IInventory par1IInventory, IInventory par2IInventory) {
      this.lowerLoaderInventory = par2IInventory;
      this.upperLoaderInventory = par1IInventory;
      this.addSlots();
   }

   public boolean func_75145_c(EntityPlayer par1EntityPlayer) {
      return this.lowerLoaderInventory.func_70300_a(par1EntityPlayer);
   }

   public ItemStack func_82846_b(EntityPlayer par1EntityPlayer, int par2) {
      ItemStack var3 = null;
      Slot var4 = (Slot)this.field_75151_b.get(par2);
      if (var4 != null && var4.func_75216_d()) {
         ItemStack var5 = var4.func_75211_c();
         var3 = var5.func_77946_l();
         if (par2 < 60) {
            if (!this.func_75135_a(var5, 60, this.field_75151_b.size(), true)) {
               return null;
            }
         } else if (!this.func_75135_a(var5, 0, 60, false)) {
            return null;
         }

         if (var5.field_77994_a == 0) {
            var4.func_75215_d((ItemStack)null);
         } else {
            var4.func_75218_e();
         }
      }

      return var3;
   }

   public void clearSlots() {
      this.field_75151_b.clear();
   }

   public void addSlots() {
      for (int var4 = 0; var4 < 6; var4++) {
         for (int var5 = 0; var5 < 2; var5++) {
            this.func_75146_a(new Slot(this.lowerLoaderInventory, var5 + var4 * 2, 10 + var5 * 18, 73 + var4 * 18));
         }
      }

      for (int var3 = 0; var3 < 6; var3++) {
         for (int var5 = 0; var5 < 2; var5++) {
            this.func_75146_a(new Slot(this.lowerLoaderInventory, 12 + var5 + var3 * 2, 212 + var5 * 18, 73 + var3 * 18));
         }
      }

      for (int var41 = 0; var41 < 4; var41++) {
         for (int var5 = 0; var5 < 9; var5++) {
            this.func_75146_a(new Slot(this.lowerLoaderInventory, 24 + var5 + var41 * 9, 48 + var5 * 18, 48 + var41 * 18));
         }
      }

      for (int var51 = 0; var51 < 3; var51++) {
         for (int var5x = 0; var5x < 9; var5x++) {
            this.func_75146_a(new Slot(this.upperLoaderInventory, var5x + var51 * 9 + 9, 48 + var5x * 18, 127 + var51 * 18));
         }
      }

      for (int var6 = 0; var6 < 9; var6++) {
         this.func_75146_a(new Slot(this.upperLoaderInventory, var6, 48 + var6 * 18, 183));
      }
   }

   public void func_75134_a(EntityPlayer par1EntityPlayer) {
      super.func_75134_a(par1EntityPlayer);
   }
}
