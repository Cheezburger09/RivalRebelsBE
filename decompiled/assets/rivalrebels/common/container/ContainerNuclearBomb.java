package assets.rivalrebels.common.container;

import assets.rivalrebels.common.block.trap.BlockTimedBomb;
import assets.rivalrebels.common.item.ItemChip;
import assets.rivalrebels.common.item.ItemFuse;
import assets.rivalrebels.common.item.ItemRodNuclear;
import assets.rivalrebels.common.tileentity.TileEntityNuclearBomb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerNuclearBomb extends Container {
   protected TileEntityNuclearBomb tileEntity;

   public ContainerNuclearBomb(InventoryPlayer inventoryPlayer, TileEntityNuclearBomb te) {
      this.tileEntity = te;
      this.func_75146_a(new SlotRR(this.tileEntity, 0, 16, 34, 1, ItemFuse.class));

      for (int i = 0; i <= 4; i++) {
         this.func_75146_a(new SlotRR(this.tileEntity, i + 1, 38 + i * 18, 25, 1, ItemRodNuclear.class).setAcceptsTrollface(true));
         this.func_75146_a(new SlotRR(this.tileEntity, i + 6, 38 + i * 18, 43, 1, ItemRodNuclear.class).setAcceptsTrollface(true));
      }

      this.func_75146_a(new SlotRR(this.tileEntity, 11, 133, 34, 1, BlockTimedBomb.class));
      this.func_75146_a(new SlotRR(this.tileEntity, 12, 152, 34, 1, ItemChip.class));
      this.bindPlayerInventory(inventoryPlayer);
   }

   public boolean func_75145_c(EntityPlayer player) {
      return this.tileEntity.func_70300_a(player);
   }

   protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
      for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 9; j++) {
            this.func_75146_a(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
         }
      }

      for (int i = 0; i < 9; i++) {
         this.func_75146_a(new Slot(inventoryPlayer, i, 8 + i * 18, 139));
      }
   }

   public ItemStack func_82846_b(EntityPlayer par1EntityPlayer, int par2) {
      return null;
   }
}
