package assets.rivalrebels.common.item.weapon;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import assets.rivalrebels.common.entity.EntityBomb;
import assets.rivalrebels.common.entity.EntityRocket;
import java.util.HashSet;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemRPG extends ItemTool {
   public ItemRPG() {
      super(1.0F, ToolMaterial.EMERALD, new HashSet());
      this.field_77777_bU = 1;
      this.func_77637_a(RivalRebels.rralltab);
   }

   public boolean func_77662_d() {
      return true;
   }

   public EnumAction func_77661_b(ItemStack par1ItemStack) {
      return EnumAction.bow;
   }

   public int func_77626_a(ItemStack par1ItemStack) {
      return 144;
   }

   public ItemStack func_77659_a(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
      if (par3EntityPlayer.field_71075_bZ.field_75098_d || par3EntityPlayer.field_71071_by.func_146028_b(RivalRebels.rocket) || RivalRebels.infiniteAmmo) {
         par3EntityPlayer.func_71008_a(par1ItemStack, this.func_77626_a(par1ItemStack));
         if (!par2World.field_72995_K && !par3EntityPlayer.field_71075_bZ.field_75098_d && !RivalRebels.infiniteAmmo) {
            par3EntityPlayer.field_71071_by.func_146026_a(RivalRebels.rocket);
         }

         if (par1ItemStack.func_77986_q() == null) {
            RivalRebelsSoundPlayer.playSound(par3EntityPlayer, 23, 2, 0.4F);
         } else {
            RivalRebelsSoundPlayer.playSound(par3EntityPlayer, 10, 4, 1.0F);
         }

         if (!par2World.field_72995_K) {
            if (par1ItemStack.func_77986_q() == null) {
               par2World.func_72838_d(new EntityRocket(par2World, par3EntityPlayer, 0.1F));
            } else {
               par2World.func_72838_d(new EntityBomb(par2World, par3EntityPlayer, 0.1F));
            }
         }
      } else if (!par2World.field_72995_K) {
         par3EntityPlayer.func_145747_a(new ChatComponentText("§cOut of ammunition"));
      }

      return par1ItemStack;
   }

   public void func_94581_a(IIconRegister iconregister) {
      this.field_77791_bV = iconregister.func_94245_a("RivalRebels:aq");
   }
}
