package assets.rivalrebels.common.container;

import assets.rivalrebels.common.item.ItemCore;
import assets.rivalrebels.common.item.ItemRod;
import assets.rivalrebels.common.tileentity.TileEntityReactor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerReactor extends Container {
   protected TileEntityReactor entity;
   public SlotRR fuel;
   public SlotRR core;

   public ContainerReactor(IInventory par1iInventory, IInventory par2iInventory) {
      this.entity = (TileEntityReactor)par2iInventory;
      this.fuel = new SlotRR(this.entity, 0, 58, 139, 1, ItemRod.class);
      this.core = new SlotRR(this.entity, 1, 103, 139, 1, ItemCore.class);
      this.func_75146_a(this.fuel);
      this.func_75146_a(this.core);
      this.bindPlayerInventory(par1iInventory);
   }

   public boolean func_75145_c(EntityPlayer player) {
      return this.entity.func_70300_a(player);
   }

   protected void bindPlayerInventory(IInventory inventoryPlayer) {
      for (int i = 0; i < 9; i++) {
         this.func_75146_a(new Slot(inventoryPlayer, i, 8 + i * 18, 172));
      }
   }

   public ItemStack func_82846_b(EntityPlayer par1EntityPlayer, int par2) {
      return null;
   }
}
