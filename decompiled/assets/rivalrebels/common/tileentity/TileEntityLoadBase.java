package assets.rivalrebels.common.tileentity;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public abstract class TileEntityLoadBase extends TileEntity {
   public Item[] acceptable = new Item[0];
   public ItemStack[] input;
   public ItemStack[] inventory;
   public ItemStack[] output;
   public TileEntityLoader loader = null;

   public TileEntityLoadBase(int slots1, int slots2, int slots3) {
      this.input = new ItemStack[slots1];
      this.inventory = new ItemStack[slots2];
      this.output = new ItemStack[slots3];
   }

   public void func_145845_h() {
   }

   public void add(ItemStack item, ItemStack[] itemarray) {
      int add = item.field_77994_a;
      int max = item.func_77976_d();

      for (int i = 0; i < itemarray.length; i++) {
         if (itemarray[i] == null) {
            itemarray[i] = item;
            itemarray[i].field_77994_a = add;
            return;
         }

         if (itemarray[i] == item) {
            itemarray[i].field_77994_a += add;
            if (itemarray[i].field_77994_a <= max) {
               return;
            }

            add = itemarray[i].field_77994_a - max;
            itemarray[i].field_77994_a = max;
         }
      }
   }

   public int remove(ItemStack item, ItemStack[] itemarray) {
      int remove = item.field_77994_a;

      for (int i = 0; i < itemarray.length; i++) {
         if (itemarray != null && itemarray[i] == item) {
            itemarray[i].field_77994_a -= remove;
            if (itemarray[i].field_77994_a >= 0) {
               return 0;
            }

            remove = -itemarray[i].field_77994_a;
            itemarray[i].field_77994_a = 0;
         }
      }

      return remove;
   }

   public void func_145839_a(NBTTagCompound nbt) {
      super.func_145839_a(nbt);
      NBTTagList nbtlist = nbt.func_150295_c("Items", 10);

      for (int i = 0; i < nbtlist.func_74745_c(); i++) {
         NBTTagCompound itemnbt = nbtlist.func_150305_b(i);
         int slot = itemnbt.func_74771_c("Slot") & 255;
         if (slot >= 0) {
            if (slot < this.input.length) {
               this.input[slot] = ItemStack.func_77949_a(itemnbt);
            } else if (slot < this.inventory.length) {
               this.inventory[slot] = ItemStack.func_77949_a(itemnbt);
            } else if (slot < this.output.length) {
               this.output[slot] = ItemStack.func_77949_a(itemnbt);
            }
         }
      }
   }

   public void func_145841_b(NBTTagCompound nbt) {
      super.func_145841_b(nbt);
      NBTTagList nbtlist = new NBTTagList();

      for (int i = 0; i < this.input.length; i++) {
         if (this.input[i] != null) {
            NBTTagCompound itemnbt = new NBTTagCompound();
            itemnbt.func_74774_a("Slot", (byte)i);
            this.input[i].func_77955_b(itemnbt);
            nbtlist.func_74742_a(itemnbt);
         }
      }

      for (int i = 0; i < this.inventory.length; i++) {
         if (this.inventory[i] != null) {
            NBTTagCompound itemnbt = new NBTTagCompound();
            itemnbt.func_74774_a("Slot", (byte)(i + this.input.length));
            this.inventory[i].func_77955_b(itemnbt);
            nbtlist.func_74742_a(itemnbt);
         }
      }

      for (int i = 0; i < this.output.length; i++) {
         if (this.output[i] != null) {
            NBTTagCompound itemnbt = new NBTTagCompound();
            itemnbt.func_74774_a("Slot", (byte)(i + this.inventory.length + this.input.length));
            this.output[i].func_77955_b(itemnbt);
            nbtlist.func_74742_a(itemnbt);
         }
      }

      nbt.func_74782_a("Items", nbtlist);
   }
}
