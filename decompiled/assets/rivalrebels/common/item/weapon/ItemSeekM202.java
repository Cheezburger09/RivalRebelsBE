package assets.rivalrebels.common.item.weapon;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import assets.rivalrebels.common.entity.EntitySeekB83;
import java.util.HashSet;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemSeekM202 extends ItemTool {
   public ItemSeekM202() {
      super(1.0F, ToolMaterial.EMERALD, new HashSet());
      this.field_77777_bU = 1;
      this.func_77637_a(RivalRebels.rralltab);
   }

   public EnumAction func_77661_b(ItemStack par1ItemStack) {
      return EnumAction.bow;
   }

   public boolean func_77662_d() {
      return true;
   }

   public int func_77626_a(ItemStack p_77626_1_) {
      return 90;
   }

   public ItemStack func_77659_a(ItemStack i, World w, EntityPlayer p) {
      if (p.field_71075_bZ.field_75098_d || p.field_71071_by.func_146028_b(RivalRebels.rocket) || RivalRebels.infiniteAmmo) {
         p.func_71008_a(i, this.func_77626_a(i));
         if (!p.field_71075_bZ.field_75098_d && !RivalRebels.infiniteAmmo) {
            p.field_71071_by.func_146026_a(RivalRebels.rocket);
         }

         RivalRebelsSoundPlayer.playSound(p, 23, 2, 0.4F);
         if (!w.field_72995_K) {
            if (i.func_77986_q() == null) {
               w.func_72838_d(new EntitySeekB83(w, p, 0.1F));
            } else {
               w.func_72838_d(new EntitySeekB83(w, p, 0.1F, 15.0F));
               w.func_72838_d(new EntitySeekB83(w, p, 0.1F, 7.5F));
               w.func_72838_d(new EntitySeekB83(w, p, 0.1F));
               w.func_72838_d(new EntitySeekB83(w, p, 0.1F, -7.5F));
               w.func_72838_d(new EntitySeekB83(w, p, 0.1F, -15.0F));
            }
         }
      } else if (!w.field_72995_K) {
         p.func_145747_a(new ChatComponentText("§cOut of ammunition"));
      }

      return i;
   }

   public void func_94581_a(IIconRegister iconregister) {
      this.field_77791_bV = iconregister.func_94245_a("RivalRebels:bh");
   }
}
