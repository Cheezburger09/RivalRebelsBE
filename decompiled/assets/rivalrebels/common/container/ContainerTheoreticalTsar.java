package assets.rivalrebels.common.container;

import assets.rivalrebels.common.block.trap.BlockTimedBomb;
import assets.rivalrebels.common.item.ItemAntenna;
import assets.rivalrebels.common.item.ItemChip;
import assets.rivalrebels.common.item.ItemFuse;
import assets.rivalrebels.common.item.ItemRodNuclear;
import assets.rivalrebels.common.tileentity.TileEntityTheoreticalTsarBomba;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerTheoreticalTsar extends Container {
   protected TileEntityTheoreticalTsarBomba entity;

   public ContainerTheoreticalTsar(InventoryPlayer inventoryPlayer, TileEntityTheoreticalTsarBomba tileEntity) {
      this.entity = tileEntity;
      this.func_75146_a(new SlotRR(this.entity, 0, 18, 48, 1, ItemFuse.class));
      this.func_75146_a(new SlotRR(this.entity, 1, 40, 59, 1, ItemAntenna.class));
      this.func_75146_a(new SlotRR(this.entity, 2, 40, 37, 1, ItemAntenna.class));

      for (int i = 0; i <= 3; i++) {
         this.func_75146_a(new SlotRR(this.entity, i + 3, 62 + i * 18, 19, 1, ItemRodNuclear.class).setAcceptsTrollface(true));
         this.func_75146_a(new SlotRR(this.entity, i + 7, 62 + i * 18, 37, 1, ItemRodNuclear.class).setAcceptsTrollface(true));
         this.func_75146_a(new SlotRR(this.entity, i + 11, 62 + i * 18, 59, 1, ItemRodNuclear.class).setAcceptsTrollface(true));
         this.func_75146_a(new SlotRR(this.entity, i + 15, 62 + i * 18, 77, 1, ItemRodNuclear.class).setAcceptsTrollface(true));
      }

      this.func_75146_a(new SlotRR(this.entity, 19, 138, 48, 1, BlockTimedBomb.class));
      this.func_75146_a(new SlotRR(this.entity, 20, 98, 99, 1, ItemChip.class));
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
      ItemStack var3 = null;
      Slot var4 = (Slot)this.field_75151_b.get(par2);
      if (var4 != null && var4.func_75216_d()) {
         ItemStack var5 = var4.func_75211_c();
         var3 = var5.func_77946_l();
         if (par2 <= 19) {
            if (!this.func_75135_a(var5, 19, this.field_75151_b.size(), true)) {
               return null;
            }
         } else if (!this.func_75135_a(var5, 0, 19, false)) {
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
}
