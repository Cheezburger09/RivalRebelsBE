package assets.rivalrebels.common.container;

import assets.rivalrebels.RivalRebels;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class SlotRR extends Slot {
   int maxStack = 64;
   Class<?> limit = Item.class;
   boolean acceptsTrollFace = false;
   boolean acceptsTimedBomb = false;
   public boolean locked = false;

   public SlotRR(IInventory inv, int id, int x, int y, int mstack, Class<?> only) {
      super(inv, id, x, y);
      this.maxStack = mstack;
      this.limit = only;
   }

   public boolean func_82869_a(EntityPlayer par1EntityPlayer) {
      return !this.locked;
   }

   public boolean func_75214_a(ItemStack item) {
      if (this.locked) {
         return false;
      }

      if (item == null) {
         return false;
      }

      boolean isblock = item.func_77973_b() instanceof ItemBlock;
      boolean trollface = this.acceptsTrollFace && item.func_77973_b() == RivalRebels.trollmask;
      boolean timedbomb = this.acceptsTimedBomb && item.func_77973_b() == Item.func_150898_a(RivalRebels.timedbomb);
      boolean itemmatch = this.limit.isAssignableFrom(item.func_77973_b().getClass());
      boolean blockmatch = isblock && this.limit.isAssignableFrom(((ItemBlock)item.func_77973_b()).field_150939_a.getClass());
      return itemmatch || blockmatch || trollface || timedbomb;
   }

   public int func_75219_a() {
      return this.maxStack;
   }

   public SlotRR setAcceptsTrollface(boolean t) {
      this.acceptsTrollFace = t;
      return this;
   }

   public SlotRR setAcceptsTimedBomb(boolean t) {
      this.acceptsTimedBomb = t;
      return this;
   }
}
