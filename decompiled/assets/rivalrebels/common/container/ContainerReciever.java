package assets.rivalrebels.common.container;

import assets.rivalrebels.common.block.crate.BlockWeapons;
import assets.rivalrebels.common.item.ItemBattery;
import assets.rivalrebels.common.item.ItemChip;
import assets.rivalrebels.common.item.ItemFuel;
import assets.rivalrebels.common.tileentity.TileEntityReciever;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerReciever extends Container {
   protected TileEntityReciever entity;

   public ContainerReciever(InventoryPlayer inventoryPlayer, TileEntityReciever tileEntity) {
      this.entity = tileEntity;
      this.func_75146_a(new SlotRR(this.entity, 0, 8, 76, 64, ItemFuel.class));
      this.func_75146_a(new SlotRR(this.entity, 1, 26, 76, 64, ItemFuel.class));
      this.func_75146_a(new SlotRR(this.entity, 2, 44, 76, 64, ItemFuel.class));
      this.func_75146_a(new SlotRR(this.entity, 3, 8, 94, 16, ItemBattery.class));
      this.func_75146_a(new SlotRR(this.entity, 4, 26, 94, 16, ItemBattery.class));
      this.func_75146_a(new SlotRR(this.entity, 5, 44, 94, 16, ItemBattery.class));
      this.func_75146_a(new SlotRR(this.entity, 6, 116, 94, 1, ItemChip.class));
      this.func_75146_a(new SlotRR(this.entity, 7, 134, 94, 1, BlockWeapons.class));
      this.func_75146_a(new SlotRR(this.entity, 8, 152, 94, 1, BlockWeapons.class));
      this.bindPlayerInventory(inventoryPlayer);
   }

   public boolean func_75145_c(EntityPlayer player) {
      return this.entity.func_70300_a(player);
   }

   protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
      for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 9; j++) {
            this.func_75146_a(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 119 + i * 18));
         }
      }

      for (int i = 0; i < 9; i++) {
         this.func_75146_a(new Slot(inventoryPlayer, i, 8 + i * 18, 175));
      }
   }

   public ItemStack func_82846_b(EntityPlayer par1EntityPlayer, int par2) {
      return null;
   }
}
