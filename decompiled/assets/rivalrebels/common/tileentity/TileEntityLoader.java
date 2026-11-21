package assets.rivalrebels.common.tileentity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.item.ItemRod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityLoader extends TileEntity implements IInventory {
   private ItemStack[] chestContents = new ItemStack[64];
   public double slide = 0.0;
   double test = Math.PI;
   int counter;
   public TileEntityList machines = new TileEntityList();

   public int func_70302_i_() {
      return 60;
   }

   @SideOnly(Side.CLIENT)
   public double func_145833_n() {
      return 16384.0;
   }

   public AxisAlignedBB getRenderBoundingBox() {
      return AxisAlignedBB.func_72330_a(
         this.field_145851_c - 5, this.field_145848_d - 1, this.field_145849_e - 5, this.field_145851_c + 6, this.field_145848_d + 2, this.field_145849_e + 6
      );
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
      this.slide = (Math.cos(this.test) + 1.0) / 32.0 * 14.0;
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
         if (this.slide < 0.871) {
            this.test += 0.05;
         }
      } else if (this.slide > 0.004) {
         this.test -= 0.05;
      }

      this.counter++;
      if (this.counter % 10 == 0) {
         for (int x = 1; x < 7; x++) {
            TileEntity te = this.field_145850_b.func_147438_o(this.field_145851_c + x, this.field_145848_d, this.field_145849_e);
            if (te != null && (te instanceof TileEntityReactor || te instanceof TileEntityReciever)) {
               this.machines.add(te);
            }

            te = this.field_145850_b.func_147438_o(this.field_145851_c - x, this.field_145848_d, this.field_145849_e);
            if (te != null && (te instanceof TileEntityReactor || te instanceof TileEntityReciever)) {
               this.machines.add(te);
            }

            te = this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e + x);
            if (te != null && (te instanceof TileEntityReactor || te instanceof TileEntityReciever)) {
               this.machines.add(te);
            }

            te = this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e - x);
            if (te != null && (te instanceof TileEntityReactor || te instanceof TileEntityReciever)) {
               this.machines.add(te);
            }
         }

         for (int index = 0; index < this.machines.getSize(); index++) {
            TileEntity te = this.machines.get(index);
            if (te != null && !te.func_145837_r()) {
               if (te instanceof TileEntityReactor) {
                  TileEntityReactor ter = (TileEntityReactor)te;
                  if (ter.on) {
                     for (int q = 0; q < this.chestContents.length && ter.fuel == null; q++) {
                        if (this.chestContents[q] != null
                           && this.chestContents[q].func_77973_b() instanceof ItemRod
                           && this.chestContents[q].func_77973_b() != RivalRebels.emptyrod) {
                           ter.fuel = this.chestContents[q];
                           this.chestContents[q] = new ItemStack(RivalRebels.emptyrod, 1);
                        }
                     }
                  }
               }

               if (te instanceof TileEntityReciever) {
                  TileEntityReciever ter = (TileEntityReciever)te;

                  for (int q = 0; q < this.chestContents.length; q++) {
                     if (this.chestContents[q] != null && this.chestContents[q].func_77973_b() == RivalRebels.fuel) {
                        int amount = this.chestContents[q].field_77994_a;
                        if (ter.chestContents[0] != null && ter.chestContents[0].field_77994_a >= 64) {
                           if (ter.chestContents[1] != null && ter.chestContents[1].field_77994_a >= 64) {
                              if (ter.chestContents[2] == null || ter.chestContents[2].field_77994_a < 64) {
                                 if (ter.chestContents[2] == null) {
                                    ter.chestContents[2] = this.chestContents[q].func_77946_l();
                                    ter.chestContents[2].field_77994_a = amount;
                                 } else {
                                    ter.chestContents[2].field_77994_a += amount;
                                 }

                                 amount = 0;
                                 if (ter.chestContents[2].field_77994_a > 64) {
                                    amount = ter.chestContents[2].field_77994_a - 64;
                                    ter.chestContents[2].field_77994_a = 64;
                                 }
                              }
                           } else {
                              if (ter.chestContents[1] == null) {
                                 ter.chestContents[1] = this.chestContents[q].func_77946_l();
                                 ter.chestContents[1].field_77994_a = amount;
                              } else {
                                 ter.chestContents[1].field_77994_a += amount;
                              }

                              amount = 0;
                              if (ter.chestContents[1].field_77994_a > 64) {
                                 amount = ter.chestContents[1].field_77994_a - 64;
                                 ter.chestContents[1].field_77994_a = 64;
                              }
                           }
                        } else {
                           if (ter.chestContents[0] == null) {
                              ter.chestContents[0] = this.chestContents[q].func_77946_l();
                              ter.chestContents[0].field_77994_a = amount;
                           } else {
                              ter.chestContents[0].field_77994_a += amount;
                           }

                           amount = 0;
                           if (ter.chestContents[0].field_77994_a > 64) {
                              amount = ter.chestContents[0].field_77994_a - 64;
                              ter.chestContents[0].field_77994_a = 64;
                           }
                        }

                        this.chestContents[q].field_77994_a = amount;
                        if (this.chestContents[q].field_77994_a == 0) {
                           this.chestContents[q] = null;
                        }
                     }

                     if (this.chestContents[q] != null && this.chestContents[q].func_77973_b() == RivalRebels.battery) {
                        int amount = this.chestContents[q].field_77994_a;
                        if (ter.chestContents[3] != null && ter.chestContents[3].field_77994_a >= 16) {
                           if (ter.chestContents[4] != null && ter.chestContents[4].field_77994_a >= 16) {
                              if (ter.chestContents[5] == null || ter.chestContents[5].field_77994_a < 16) {
                                 if (ter.chestContents[5] == null) {
                                    ter.chestContents[5] = this.chestContents[q].func_77946_l();
                                    ter.chestContents[5].field_77994_a = amount;
                                 } else {
                                    ter.chestContents[5].field_77994_a += amount;
                                 }

                                 amount = 0;
                                 if (ter.chestContents[5].field_77994_a > 16) {
                                    amount = ter.chestContents[5].field_77994_a - 16;
                                    ter.chestContents[5].field_77994_a = 16;
                                 }
                              }
                           } else {
                              if (ter.chestContents[4] == null) {
                                 ter.chestContents[4] = this.chestContents[q].func_77946_l();
                                 ter.chestContents[4].field_77994_a = amount;
                              } else {
                                 ter.chestContents[4].field_77994_a += amount;
                              }

                              amount = 0;
                              if (ter.chestContents[4].field_77994_a > 16) {
                                 amount = ter.chestContents[4].field_77994_a - 16;
                                 ter.chestContents[4].field_77994_a = 16;
                              }
                           }
                        } else {
                           if (ter.chestContents[3] == null) {
                              ter.chestContents[3] = this.chestContents[q].func_77946_l();
                              ter.chestContents[3].field_77994_a = amount;
                           } else {
                              ter.chestContents[3].field_77994_a += amount;
                           }

                           amount = 0;
                           if (ter.chestContents[3].field_77994_a > 16) {
                              amount = ter.chestContents[3].field_77994_a - 16;
                              ter.chestContents[3].field_77994_a = 16;
                           }
                        }

                        this.chestContents[q].field_77994_a = amount;
                        if (this.chestContents[q].field_77994_a == 0) {
                           this.chestContents[q] = null;
                        }
                     }
                  }
               }
            } else {
               this.machines.remove(index);
            }
         }

         TileEntity te = this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d - 1, this.field_145849_e);
         if (te instanceof TileEntityLoader) {
            TileEntityLoader tel = (TileEntityLoader)te;

            for (int q = 0; q < this.chestContents.length; q++) {
               if (this.chestContents[q] != null) {
                  for (int j = 0; j < tel.chestContents.length; j++) {
                     if (tel.chestContents[j] == null) {
                        tel.chestContents[j] = this.chestContents[q];
                        this.chestContents[q] = null;
                        return;
                     }
                  }
               }
            }
         }
      }
   }

   public void func_145843_s() {
      super.func_145843_s();
      this.func_145836_u();
   }

   public boolean func_94041_b(int i, ItemStack itemstack) {
      return true;
   }

   public String func_145825_b() {
      return "Loader";
   }

   public boolean func_145818_k_() {
      return false;
   }

   public void func_70295_k_() {
   }

   public void func_70305_f() {
   }
}
