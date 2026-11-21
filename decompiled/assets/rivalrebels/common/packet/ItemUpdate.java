package assets.rivalrebels.common.packet;

import assets.rivalrebels.common.item.weapon.ItemFlameThrower;
import assets.rivalrebels.common.item.weapon.ItemTesla;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemUpdate implements IMessage {
   public int item;
   public int value;

   public ItemUpdate() {
   }

   public ItemUpdate(int currentItem, int i) {
      this.item = currentItem;
      this.value = i;
   }

   public void fromBytes(ByteBuf buf) {
      this.item = buf.readByte();
      this.value = buf.readByte();
   }

   public void toBytes(ByteBuf buf) {
      buf.writeByte(this.item);
      buf.writeByte(this.value);
   }

   public static class Handler implements IMessageHandler<ItemUpdate, IMessage> {
      public IMessage onMessage(ItemUpdate message, MessageContext ctx) {
         ItemStack itemstack = ctx.getServerHandler().field_147369_b.field_71071_by.func_70301_a(message.item);
         if (itemstack.func_77973_b() instanceof ItemTesla) {
            if (itemstack.field_77990_d == null) {
               itemstack.field_77990_d = new NBTTagCompound();
            }

            itemstack.field_77990_d.func_74768_a("dial", message.value);
         }

         if (itemstack.func_77973_b() instanceof ItemFlameThrower) {
            if (itemstack.field_77990_d == null) {
               itemstack.field_77990_d = new NBTTagCompound();
            }

            itemstack.field_77990_d.func_74768_a("mode", message.value);
         }

         return null;
      }
   }
}
