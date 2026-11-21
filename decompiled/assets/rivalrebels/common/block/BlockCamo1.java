package assets.rivalrebels.common.block;

import assets.rivalrebels.RivalRebels;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class BlockCamo1 extends Block {
   @SideOnly(Side.CLIENT)
   IIcon icon;

   public BlockCamo1() {
      super(Material.field_151573_f);
   }

   public int func_149745_a(Random par1Random) {
      return 1;
   }

   public Item func_149650_a(int i, Random r, int j) {
      return Item.func_150898_a(RivalRebels.smartcamo);
   }

   public final IIcon func_149691_a(int side, int meta) {
      return this.icon;
   }

   public void func_149651_a(IIconRegister iconregister) {
      this.icon = iconregister.func_94245_a("RivalRebels:as");
   }
}
