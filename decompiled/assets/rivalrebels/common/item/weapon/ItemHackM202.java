package assets.rivalrebels.common.item.weapon;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsDamageSource;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import assets.rivalrebels.common.entity.EntityHackB83;
import assets.rivalrebels.common.explosion.Explosion;
import java.util.HashSet;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.world.World;

public class ItemHackM202 extends ItemTool {
   public ItemHackM202() {
      super(1.0F, ToolMaterial.EMERALD, new HashSet());
      this.field_77777_bU = 1;
      this.func_77637_a(RivalRebels.rralltab);
   }

   public int func_77619_b() {
      return 100;
   }

   public boolean func_77662_d() {
      return true;
   }

   public ItemStack func_77659_a(ItemStack par1ItemStack, World par2World, EntityPlayer p) {
      p.field_71071_by.field_70462_a[p.field_71071_by.field_70461_c] = null;
      if (!par2World.field_72995_K) {
         par2World.func_72838_d(
            new EntityHackB83(
               par2World, p.field_70165_t, p.field_70163_u, p.field_70161_v, -p.field_70759_as, p.field_70125_A, par1ItemStack.func_77986_q() != null
            )
         );
      }

      RivalRebelsSoundPlayer.playSound(p, 23, 2, 0.4F);
      new Explosion(par2World, p.field_70165_t, p.field_70163_u, p.field_70161_v, 2, true, false, RivalRebelsDamageSource.flare);
      return par1ItemStack;
   }

   public void func_94581_a(IIconRegister iconregister) {
      this.field_77791_bV = iconregister.func_94245_a("RivalRebels:bg");
   }
}
