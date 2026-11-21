package assets.rivalrebels.common.item.weapon;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import assets.rivalrebels.common.entity.EntityCuchillo;
import java.util.HashSet;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.world.World;

public class ItemCuchillo extends ItemTool {
   public ItemCuchillo() {
      super(1.0F, ToolMaterial.IRON, new HashSet());
      this.field_77777_bU = 5;
      this.func_77637_a(RivalRebels.rralltab);
   }

   public EnumAction func_77661_b(ItemStack par1ItemStack) {
      return EnumAction.bow;
   }

   public boolean func_77662_d() {
      return false;
   }

   public int func_77626_a(ItemStack par1ItemStack) {
      return 72000;
   }

   public void func_77615_a(ItemStack itemstack, World world, EntityPlayer player, int i) {
      if (player.field_71075_bZ.field_75098_d || player.field_71071_by.func_146028_b(RivalRebels.knife)) {
         float f = (this.func_77626_a(itemstack) - i) / 20.0F;
         f = (f * f + f * 2.0F) * 0.3333F;
         if (f < 0.1) {
            return;
         }

         if (f > 1.0F) {
            f = 1.0F;
         }

         if (!player.field_71075_bZ.field_75098_d) {
            player.field_71071_by.func_70298_a(player.field_71071_by.field_70461_c, 1);
         }

         RivalRebelsSoundPlayer.playSound(player, 4, 3);
         if (!world.field_72995_K) {
            world.func_72838_d(new EntityCuchillo(world, player, 0.5F + f));
         }
      }
   }

   public ItemStack func_77659_a(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
      par3EntityPlayer.func_71008_a(par1ItemStack, this.func_77626_a(par1ItemStack));
      return par1ItemStack;
   }

   public void func_94581_a(IIconRegister iconregister) {
      this.field_77791_bV = iconregister.func_94245_a("RivalRebels:ad");
   }
}
