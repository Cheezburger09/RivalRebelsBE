package assets.rivalrebels.common.block.trap;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockQuickSand extends Block {
   public BlockQuickSand() {
      super(Material.field_151578_c);
   }

   public void func_149670_a(World par1World, int par2, int par3, int par4, Entity par5Entity) {
      par5Entity.field_70143_R = 0.0F;
      par5Entity.field_70181_x *= 0.005;
      if (par1World.field_73012_v.nextFloat() > 0.95) {
         RivalRebelsSoundPlayer.playSound(par1World, 20, 0, par2, par3, par4, 0.2F);
      }
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   @SideOnly(Side.CLIENT)
   public int func_149635_D() {
      return this == RivalRebels.quicksand ? Blocks.field_150349_c.func_149635_D() : 16777215;
   }

   @SideOnly(Side.CLIENT)
   public int func_149741_i(int par1) {
      return this == RivalRebels.quicksand ? Blocks.field_150349_c.func_149741_i(par1) : 16777215;
   }

   @SideOnly(Side.CLIENT)
   public int func_149720_d(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
      return this == RivalRebels.quicksand ? Blocks.field_150349_c.func_149720_d(par1IBlockAccess, par2, par3, par4) : 16777215;
   }

   public AxisAlignedBB func_149668_a(World par1World, int par2, int par3, int i) {
      return null;
   }

   public Item func_149650_a(int i, Random r, int j) {
      return Item.func_150898_a(RivalRebels.aquicksand);
   }

   public int func_149745_a(Random random) {
      return 1;
   }

   public final IIcon func_149673_e(IBlockAccess world, int x, int y, int z, int s) {
      if (this == RivalRebels.quicksand) {
         return Blocks.field_150349_c.func_149673_e(world, x, y, z, s);
      }

      Block[] n = new Block[]{
         world.func_147439_a(x + 1, y, z),
         world.func_147439_a(x - 1, y, z),
         world.func_147439_a(x, y + 1, z),
         world.func_147439_a(x, y - 1, z),
         world.func_147439_a(x, y, z + 1),
         world.func_147439_a(x, y, z - 1)
      };
      int popularity1 = 0;
      int popularity2 = 0;
      Block mode = Blocks.field_150354_m;
      Block array_item = null;

      for (int i = 0; i < 6; i++) {
         array_item = n[i];
         if (array_item != null
            && array_item.func_149662_c()
            && array_item != RivalRebels.landmine
            && array_item != RivalRebels.alandmine
            && array_item != RivalRebels.mario
            && array_item != RivalRebels.amario
            && array_item != RivalRebels.quicksand
            && array_item != RivalRebels.aquicksand) {
            for (int j = 0; j < n.length; j++) {
               if (array_item == n[j]) {
                  popularity1++;
               }

               if (popularity1 >= popularity2) {
                  mode = array_item;
                  popularity2 = popularity1;
               }
            }

            popularity1 = 0;
         }
      }

      return mode.func_149673_e(world, x, y, z, s);
   }

   public void func_149726_b(World world, int x, int y, int z) {
      Block[] n = new Block[]{
         world.func_147439_a(x + 1, y, z),
         world.func_147439_a(x - 1, y, z),
         world.func_147439_a(x, y + 1, z),
         world.func_147439_a(x, y - 1, z),
         world.func_147439_a(x, y, z + 1),
         world.func_147439_a(x, y, z - 1)
      };
      int popularity1 = 0;
      int popularity2 = 0;
      Block mode = Blocks.field_150354_m;
      Block array_item = null;

      for (int i = 0; i < 6; i++) {
         array_item = n[i];
         if (array_item != null
            && array_item.func_149662_c()
            && array_item != RivalRebels.landmine
            && array_item != RivalRebels.alandmine
            && array_item != RivalRebels.mario
            && array_item != RivalRebels.amario
            && array_item != RivalRebels.quicksand
            && array_item != RivalRebels.aquicksand) {
            for (int j = 0; j < n.length; j++) {
               if (array_item == n[j]) {
                  popularity1++;
               }

               if (popularity1 >= popularity2) {
                  mode = array_item;
                  popularity2 = popularity1;
               }
            }

            popularity1 = 0;
         }
      }

      if (mode == Blocks.field_150349_c) {
         world.func_147449_b(x, y, z, RivalRebels.quicksand);
      }
   }

   public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player) {
      return new ItemStack(RivalRebels.aquicksand);
   }

   public final IIcon func_149691_a(int side, int meta) {
      return this == RivalRebels.aquicksand ? Blocks.field_150354_m.func_149691_a(side, meta) : Blocks.field_150349_c.func_149691_a(side, meta);
   }

   public void func_149651_a(IIconRegister iconregister) {
   }
}
