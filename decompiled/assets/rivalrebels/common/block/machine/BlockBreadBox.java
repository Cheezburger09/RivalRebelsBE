package assets.rivalrebels.common.block.machine;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockBreadBox extends Block {
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

   public BlockBreadBox() {
      super(Material.field_151573_f);
   }

   public int func_149745_a(Random random) {
      return 1;
   }

   public void func_149699_a(World world, int x, int y, int z, EntityPlayer player) {
      this.blockActivated(world, x, y, z, player);
   }

   public boolean blockActivated(World world, int x, int y, int z, EntityPlayer player) {
      if (!player.func_70093_af()) {
         EntityItem ei = new EntityItem(world, x + 0.5, y + 1, z + 0.5, new ItemStack(Items.field_151025_P, 1));
         if (!world.field_72995_K) {
            world.func_72838_d(ei);
            if (world.field_73012_v.nextInt(64) == 0) {
               player.func_145747_a(new ChatComponentText("§7[§4Orders§7] §cShift-click (Sneak) to pack up toaster."));
            }
         }
      } else {
         world.func_147449_b(x, y, z, Blocks.field_150350_a);
         EntityItem ei = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(this));
         if (!world.field_72995_K) {
            world.func_72838_d(ei);
         }
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
      this.icon1 = iconregister.func_94245_a("RivalRebels:ca");
      this.icon2 = iconregister.func_94245_a("RivalRebels:cc");
      this.icon3 = iconregister.func_94245_a("RivalRebels:cb");
      this.icon4 = iconregister.func_94245_a("RivalRebels:ca");
      this.icon5 = iconregister.func_94245_a("RivalRebels:ca");
      this.icon6 = iconregister.func_94245_a("RivalRebels:ca");
   }
}
