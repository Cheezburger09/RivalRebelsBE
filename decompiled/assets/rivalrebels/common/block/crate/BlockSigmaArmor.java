package assets.rivalrebels.common.block.crate;

import assets.rivalrebels.RivalRebels;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockSigmaArmor extends Block {
   @SideOnly(Side.CLIENT)
   IIcon icon1;
   @SideOnly(Side.CLIENT)
   IIcon icon2;
   @SideOnly(Side.CLIENT)
   IIcon icon3;
   @SideOnly(Side.CLIENT)
   IIcon icon4;
   @SideOnly(Side.CLIENT)
   IIcon icon5;
   @SideOnly(Side.CLIENT)
   IIcon icon6;

   public BlockSigmaArmor() {
      super(Material.field_151575_d);
   }

   public int func_149745_a(Random par1Random) {
      return 0;
   }

   public void func_149699_a(World world, int x, int y, int z, EntityPlayer player) {
      this.blockActivated(world, x, y, z, player);
   }

   public boolean blockActivated(World world, int x, int y, int z, EntityPlayer player) {
      if (!world.field_72995_K) {
         player.func_145747_a(new ChatComponentText("§7[§2Inventory§7]"));
         player.func_145747_a(new ChatComponentText("§aArmor. §9(Sigma's color armor.)"));
         player.func_145747_a(new ChatComponentText("§7[§4Orders§7] §cEquipt your set of armor."));
         EntityItem ei7 = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(RivalRebels.camohat2));
         EntityItem ei8 = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(RivalRebels.camoshirt2));
         EntityItem ei9 = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(RivalRebels.camopants2));
         EntityItem ei10 = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(RivalRebels.camoshoes2));
         world.func_72838_d(ei7);
         world.func_72838_d(ei8);
         world.func_72838_d(ei9);
         world.func_72838_d(ei10);
         world.func_147449_b(x, y, z, Blocks.field_150350_a);
      }

      return true;
   }

   @SideOnly(Side.CLIENT)
   public final IIcon func_149691_a(int side, int meta) {
      if (side == 0) {
         return this.icon1;
      } else if (side == 1) {
         return this.icon2;
      } else if (side == 2) {
         return this.icon3;
      } else if (side == 3) {
         return this.icon4;
      } else if (side == 4) {
         return this.icon5;
      } else {
         return side == 5 ? this.icon6 : this.icon1;
      }
   }

   @SideOnly(Side.CLIENT)
   public void func_149651_a(IIconRegister iconregister) {
      this.icon1 = iconregister.func_94245_a("RivalRebels:ah");
      this.icon2 = iconregister.func_94245_a("RivalRebels:ai");
      this.icon3 = iconregister.func_94245_a("RivalRebels:bo");
      this.icon4 = iconregister.func_94245_a("RivalRebels:bo");
      this.icon5 = iconregister.func_94245_a("RivalRebels:ah");
      this.icon6 = iconregister.func_94245_a("RivalRebels:ah");
   }
}
