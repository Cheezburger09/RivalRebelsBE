package assets.rivalrebels.common.tileentity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsDamageSource;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import assets.rivalrebels.common.explosion.Explosion;
import assets.rivalrebels.common.item.ItemCore;
import assets.rivalrebels.common.item.ItemRod;
import assets.rivalrebels.common.item.ItemRodNuclear;
import assets.rivalrebels.common.item.ItemRodRedstone;
import assets.rivalrebels.common.packet.PacketDispatcher;
import assets.rivalrebels.common.packet.ReactorUpdatePacket;
import assets.rivalrebels.common.packet.TextPacket;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityReactor extends TileEntity implements IInventory {
   public double slide = 90.0;
   private double test = Math.PI;
   public ItemStack core;
   public ItemStack fuel;
   public boolean on = false;
   public boolean prevOn = false;
   public boolean melt = false;
   public int meltTick = 0;
   public boolean eject = false;
   public double consumed = 0.0;
   public double lasttickconsumed = 0.0;
   public int tickssincelastrod = 0;
   public boolean lastrodwasredstone = false;
   public TileEntityList machines = new TileEntityList();
   public int tick = 0;
   public long lastPacket = System.currentTimeMillis();

   public void func_145839_a(NBTTagCompound par1NBTTagCompound) {
      super.func_145839_a(par1NBTTagCompound);
      int c = par1NBTTagCompound.func_74762_e("core");
      int f = par1NBTTagCompound.func_74762_e("fuel");
      if (c != 0) {
         this.core = new ItemStack(Item.func_150899_d(c));
      }

      if (f != 0) {
         this.fuel = new ItemStack(Item.func_150899_d(f));
      }

      this.consumed = par1NBTTagCompound.func_74762_e("consumed");
      this.on = par1NBTTagCompound.func_74767_n("on");

      for (int i = 0; par1NBTTagCompound.func_74764_b("mx" + i); i++) {
         int x = par1NBTTagCompound.func_74762_e("mx" + i);
         int y = par1NBTTagCompound.func_74762_e("my" + i);
         int z = par1NBTTagCompound.func_74762_e("mz" + i);
         if (this.field_145850_b != null) {
            TileEntity te = this.field_145850_b.func_147438_o(x, y, z);
            if (te != null && te instanceof TileEntityMachineBase) {
               this.machines.add(te);
            }
         }
      }
   }

   public void func_145841_b(NBTTagCompound par1NBTTagCompound) {
      super.func_145841_b(par1NBTTagCompound);
      if (this.core != null) {
         par1NBTTagCompound.func_74768_a("core", Item.func_150891_b(this.core.func_77973_b()));
      }

      if (this.fuel != null) {
         par1NBTTagCompound.func_74768_a("fuel", Item.func_150891_b(this.fuel.func_77973_b()));
      }

      par1NBTTagCompound.func_74768_a("consumed", (int)this.consumed);
      par1NBTTagCompound.func_74757_a("on", this.on);
      if (this.on) {
         for (int i = 0; i < this.machines.getSize(); i++) {
            TileEntityMachineBase te = (TileEntityMachineBase)this.machines.get(i);
            if (te != null && !(te instanceof TileEntityReactive)) {
               par1NBTTagCompound.func_74768_a("mx" + i, te.field_145851_c);
               par1NBTTagCompound.func_74768_a("my" + i, te.field_145848_d);
               par1NBTTagCompound.func_74768_a("mz" + i, te.field_145849_e);
            }
         }
      }
   }

   public void func_145845_h() {
      super.func_145845_h();
      Side side = FMLCommonHandler.instance().getEffectiveSide();
      if (side == Side.CLIENT) {
         this.slide = (Math.cos(this.test) + 1.0) * 45.0;
         List players = this.field_145850_b.field_73010_i;
         Iterator iter = players.iterator();
         boolean flag = false;

         while (iter.hasNext()) {
            EntityPlayer player = (EntityPlayer)iter.next();
            if (player.func_70092_e(this.field_145851_c + 0.5F, this.field_145848_d + 0.5F, this.field_145849_e + 0.5F) <= 9.0) {
               flag = true;
               break;
            }
         }

         if (flag) {
            if (this.slide < 89.995) {
               this.test += 0.05;
            }
         } else if (this.slide > 0.004) {
            this.test -= 0.05;
         }

         if (this.core == null) {
            this.on = false;
            this.consumed = 0.0;
            this.lasttickconsumed = 0.0;
            this.melt = false;
            this.meltTick = 0;
         }

         if (this.eject) {
            this.consumed = 0.0;
            this.lasttickconsumed = 0.0;
            this.fuel = null;
            this.core = null;
            this.melt = false;
            this.meltTick = 0;
            this.on = false;
            this.eject = false;
         }

         if (this.melt) {
            if (this.core != null) {
               for (int i = 0; i < 4; i++) {
                  this.field_145850_b
                     .func_72869_a(
                        "smoke",
                        this.field_145851_c + 0.5,
                        this.field_145848_d + 0.5,
                        this.field_145849_e + 0.5,
                        Math.random() - 0.5,
                        Math.random() / 2.0,
                        Math.random() - 0.5
                     );
               }
            } else {
               this.melt = false;
               this.meltTick = 0;
               this.on = false;
            }
         }

         this.prevOn = this.on;
      } else if (side == Side.SERVER) {
         if (this.eject && this.core != null) {
            this.consumed = 0.0;
            this.lasttickconsumed = 0.0;
            this.field_145850_b
               .func_72838_d(new EntityItem(this.field_145850_b, this.field_145851_c + 0.5, this.field_145848_d + 1, this.field_145849_e + 0.5, this.core));
            this.fuel = null;
            this.core = null;
            this.melt = false;
            this.meltTick = 0;
            this.on = false;
         }

         if (this.melt) {
            if (this.core != null) {
               if (this.meltTick % 20 == 0) {
                  RivalRebelsSoundPlayer.playSound(this.field_145850_b, 21, 1, this.field_145851_c + 0.5, this.field_145848_d + 0.5, this.field_145849_e + 0.5);
               }

               this.on = true;
               this.meltTick++;
               if (this.meltTick == 300) {
                  this.meltDown(10);
               } else if (this.meltTick == 1) {
                  PacketDispatcher.packetsys.sendToAll(new TextPacket("RivalRebels.WARNING RivalRebels.meltdown"));
               }
            } else {
               this.melt = false;
               this.meltTick = 0;
               this.on = false;
            }
         }

         if (this.fuel == null && this.tickssincelastrod != 0) {
            this.tickssincelastrod++;
            if (this.tickssincelastrod >= 100) {
               if (this.lastrodwasredstone) {
                  this.on = false;
               } else {
                  this.melt = true;
               }
            }

            if (this.tickssincelastrod == 20 && !this.lastrodwasredstone) {
            }
         } else {
            this.tickssincelastrod = 0;
         }

         if (this.melt) {
            this.machines.clear();
         }

         if (this.core == null) {
            this.on = false;
            this.consumed = 0.0;
            this.lasttickconsumed = 0.0;
            this.melt = false;
            this.meltTick = 0;
         }

         if (this.on && this.core != null && this.fuel != null && this.core.func_77973_b() instanceof ItemCore && this.fuel.func_77973_b() instanceof ItemRod) {
            if (!this.prevOn && this.on) {
               RivalRebelsSoundPlayer.playSound(this.field_145850_b, 21, 3, this.field_145851_c + 0.5, this.field_145848_d + 0.5, this.field_145849_e + 0.5);
            } else {
               this.tick++;
               if (this.on && this.tick % 39 == 0) {
                  RivalRebelsSoundPlayer.playSound(
                     this.field_145850_b, 21, 2, this.field_145851_c + 0.5, this.field_145848_d + 0.5, this.field_145849_e + 0.5, 0.9F, 0.77F
                  );
               }
            }

            ItemCore c = (ItemCore)this.core.func_77973_b();
            ItemRod r = (ItemRod)this.fuel.func_77973_b();
            if (this.fuel.field_77990_d == null) {
               this.fuel.field_77990_d = new NBTTagCompound();
            }

            float power = r.power * c.timemult - this.fuel.field_77990_d.func_74762_e("fuelLeft");
            float temp = power;

            for (TileEntity te : this.field_145850_b.field_147482_g) {
               if (te != null && te instanceof TileEntityMachineBase) {
                  TileEntityMachineBase temb = (TileEntityMachineBase)te;
                  if (this.field_145850_b.func_147438_o(temb.x, temb.y, temb.z) == null) {
                     double dist = temb.func_145835_a(this.field_145851_c, this.field_145848_d, this.field_145849_e);
                     if (dist < 1024.0) {
                        temb.x = this.field_145851_c;
                        temb.y = this.field_145848_d;
                        temb.z = this.field_145849_e;
                        temb.edist = (float)Math.sqrt(dist);
                        this.machines.add(temb);
                     }
                  }

                  if (temb.x == this.field_145851_c && temb.y == this.field_145848_d && temb.z == this.field_145849_e) {
                     this.machines.add(temb);
                     temb.powerGiven = power;
                     if (power > temb.pInM - temb.pInR) {
                        power -= temb.pInM - temb.pInR;
                        temb.pInR = temb.pInM;
                     } else {
                        temb.pInR += power;
                        power = 0.0F;
                     }

                     temb.powerGiven -= power;
                  }
               }
            }

            this.lasttickconsumed = temp - power;
            this.consumed = this.consumed + this.lasttickconsumed;
            if (this.fuel.field_77990_d.func_74764_b("fuelLeft")) {
               this.fuel.field_77990_d.func_74768_a("fuelLeft", (int)this.consumed);
               double fuelLeft = this.fuel.field_77990_d.func_74762_e("fuelLeft");
               double fuelPercentage = fuelLeft / temp;
               if (r instanceof ItemRodNuclear) {
                  double f2 = fuelPercentage * fuelPercentage;
                  double f4 = f2 * f2;
                  double f8 = f4 * f4;
                  if (this.field_145850_b.field_73012_v.nextFloat() < f8) {
                     this.melt = true;
                  }
               }
            } else {
               this.fuel.field_77990_d.func_74768_a("fuelLeft", 0);
            }

            if (this.fuel.field_77990_d.func_74762_e("fuelLeft") >= temp) {
               this.lastrodwasredstone = r instanceof ItemRodRedstone;
               this.consumed = 0.0;
               this.lasttickconsumed = 0.0;
               this.tickssincelastrod = 1;
               this.fuel = null;
            }
         } else {
            this.machines.clear();
         }

         this.eject = false;
         this.prevOn = this.on;
         if (System.currentTimeMillis() - this.lastPacket > 1000L) {
            this.lastPacket = System.currentTimeMillis();
            PacketDispatcher.packetsys
               .sendToAll(
                  new ReactorUpdatePacket(
                     this.field_145851_c,
                     this.field_145848_d,
                     this.field_145849_e,
                     (float)this.consumed,
                     (float)this.lasttickconsumed,
                     this.melt,
                     this.eject,
                     this.on,
                     this.machines
                  )
               );
         }
      }
   }

   public void meltDown(int radius) {
      this.field_145850_b.func_147449_b(this.field_145851_c, this.field_145848_d, this.field_145849_e, RivalRebels.meltdown);
      new Explosion(this.field_145850_b, this.field_145851_c, this.field_145848_d - 2, this.field_145849_e, 4, false, false, RivalRebelsDamageSource.rocket);
   }

   public int func_70302_i_() {
      return 2;
   }

   public ItemStack func_70301_a(int i) {
      if (i == 0) {
         return this.fuel;
      } else {
         return i == 1 ? this.core : null;
      }
   }

   public ItemStack func_70298_a(int i, int j) {
      if (i == 0) {
         this.fuel.field_77994_a -= j;
         return this.fuel;
      } else if (i == 1) {
         this.core.field_77994_a -= j;
         return this.core;
      } else {
         return null;
      }
   }

   public ItemStack func_70304_b(int i) {
      if (i == 0) {
         return this.fuel;
      } else {
         return i == 1 ? this.core : null;
      }
   }

   public void func_70299_a(int i, ItemStack itemstack) {
      if (i == 0) {
         this.fuel = itemstack;
      } else if (i == 1) {
         this.core = itemstack;
      }
   }

   public int func_70297_j_() {
      return 1;
   }

   public boolean func_70300_a(EntityPlayer entityplayer) {
      return true;
   }

   public boolean func_94041_b(int i, ItemStack itemstack) {
      if (itemstack == null || !(itemstack.func_77973_b() instanceof ItemRod) || !(itemstack.func_77973_b() instanceof ItemCore)) {
         return false;
      } else if (i == 0) {
         return this.fuel == null || !this.on;
      } else {
         return i == 1 ? !this.on : false;
      }
   }

   @SideOnly(Side.CLIENT)
   public double func_145833_n() {
      return 16384.0;
   }

   public AxisAlignedBB getRenderBoundingBox() {
      return AxisAlignedBB.func_72330_a(
         this.field_145851_c - 100,
         this.field_145848_d - 100,
         this.field_145849_e - 100,
         this.field_145851_c + 100,
         this.field_145848_d + 100,
         this.field_145849_e + 100
      );
   }

   public float getPower() {
      if (this.core != null && this.fuel != null) {
         ItemCore c = (ItemCore)this.core.func_77973_b();
         ItemRod r = (ItemRod)this.fuel.func_77973_b();
         if (this.fuel.field_77990_d == null) {
            this.fuel.field_77990_d = new NBTTagCompound();
         }

         return r.power * c.timemult - this.fuel.field_77990_d.func_74762_e("fuelLeft");
      } else {
         return 0.0F;
      }
   }

   public String func_145825_b() {
      return "Tokamak";
   }

   public boolean func_145818_k_() {
      return false;
   }

   public void func_70295_k_() {
   }

   public void func_70305_f() {
   }

   public void toggleOn() {
      this.on = !this.on;
   }

   public void ejectCore() {
      this.eject = true;
   }
}
