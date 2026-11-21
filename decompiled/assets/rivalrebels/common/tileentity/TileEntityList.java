package assets.rivalrebels.common.tileentity;

import java.util.Arrays;
import net.minecraft.tileentity.TileEntity;

public class TileEntityList {
   private int size = 0;
   private TileEntity[] list = new TileEntity[0];

   public int getSize() {
      return this.size;
   }

   public int getFFSize() {
      int result = 0;

      for (int i = 0; i < this.list.length; i++) {
         if (this.list[i] != null && !(this.list[i] instanceof TileEntityReactive)) {
            result++;
         }
      }

      return result;
   }

   public TileEntity[] getArray() {
      return this.list;
   }

   public void add(TileEntity o) {
      int index = this.get(o);
      if (index == -1) {
         this.size++;
         if (this.size <= this.list.length) {
            this.list[this.size - 1] = o;
         } else {
            int nsize = this.list.length * 3 / 2 + 1;
            if (nsize < this.size) {
               nsize = this.size;
            }

            this.list = Arrays.copyOf(this.list, nsize);
            this.list[this.size - 1] = o;
         }
      } else {
         this.list[index] = o;
      }
   }

   public TileEntity get(int index) {
      return this.list[index];
   }

   public int get(TileEntity tile) {
      for (int i = 0; i < this.size; i++) {
         if (this.list[i].equals(tile)) {
            return i;
         }
      }

      return -1;
   }

   @Override
   public String toString() {
      StringBuilder strB = new StringBuilder();
      strB.append("tileentities:\n");

      for (int i = 0; i < this.size; i++) {
         strB.append(this.list[i].field_145851_c + ", " + this.list[i].field_145848_d + ", " + this.list[i].field_145849_e + ", " + this.list[i].toString());
         strB.append(",\n");
      }

      return strB.toString();
   }

   public void remove(TileEntityMachineBase temb) {
      this.remove(this.get(temb));
   }

   public void remove(int index) {
      if (index != -1) {
         while (index < this.size) {
            this.list[index++] = index == this.size ? null : this.list[index];
         }

         this.size--;
      }
   }

   public void clear() {
      this.size = 0;
      this.list = new TileEntity[0];
   }
}
