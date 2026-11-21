package assets.rivalrebels.common.container;

import assets.rivalrebels.common.block.crate.BlockNukeCrate;
import assets.rivalrebels.common.block.trap.BlockRemoteCharge;
import assets.rivalrebels.common.item.ItemAntenna;
import assets.rivalrebels.common.item.ItemChip;
import assets.rivalrebels.common.item.ItemRodHydrogen;
import assets.rivalrebels.common.item.ItemRodNuclear;
import assets.rivalrebels.common.tileentity.TileEntityLaptop;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerLaptop extends Container {
   protected TileEntityLaptop entity;

   public ContainerLaptop(InventoryPlayer inventoryPlayer, TileEntityLaptop tileEntity) {
      this.entity = tileEntity;
      this.func_75146_a(new SlotRR(this.entity, 0, 80, 23, 1, ItemChip.class));
      this.func_75146_a(new SlotRR(this.entity, 1, 50, 40, 1, ItemChip.class));
      this.func_75146_a(new SlotRR(this.entity, 2, 111, 40, 1, ItemChip.class));
      this.func_75146_a(new SlotRR(this.entity, 3, 80, 48, 1, ItemChip.class));
      this.func_75146_a(new SlotRR(this.entity, 4, 26, 76, 1, BlockNukeCrate.class));
      this.func_75146_a(new SlotRR(this.entity, 5, 44, 76, 1, BlockNukeCrate.class));
      this.func_75146_a(new SlotRR(this.entity, 6, 62, 76, 1, ItemRodNuclear.class).setAcceptsTimedBomb(true));
      this.func_75146_a(new SlotRR(this.entity, 7, 80, 76, 1, ItemRodNuclear.class).setAcceptsTimedBomb(true));
      this.func_75146_a(new SlotRR(this.entity, 8, 98, 76, 1, ItemRodNuclear.class).setAcceptsTimedBomb(true));
      this.func_75146_a(new SlotRR(this.entity, 9, 26, 94, 1, ItemAntenna.class));
      this.func_75146_a(new SlotRR(this.entity, 10, 44, 94, 1, BlockRemoteCharge.class));
      this.func_75146_a(new SlotRR(this.entity, 11, 62, 94, 1, ItemRodHydrogen.class).setAcceptsTimedBomb(true));
      this.func_75146_a(new SlotRR(this.entity, 12, 80, 94, 1, ItemRodHydrogen.class).setAcceptsTimedBomb(true));
      this.func_75146_a(new SlotRR(this.entity, 13, 98, 94, 1, ItemRodHydrogen.class).setAcceptsTimedBomb(true));
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
