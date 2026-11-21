package assets.rivalrebels.common.block.crate;

import assets.rivalrebels.RivalRebels;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Direction;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFlag extends Block {
   String texpath = "rivalrebels:";
   @SideOnly(Side.CLIENT)
   IIcon icon;

   public BlockFlag(String name) {
      super(Material.field_151580_n);
      this.texpath = this.texpath + name;
   }

   public int func_149745_a(Random random) {
      return 1;
   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return this == RivalRebels.flag2 ? RivalRebels.trollmask : Item.func_150898_a(this);
   }

   public void func_149683_g() {
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public int func_149645_b() {
      return 20;
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
      int l = p_149719_1_.func_72805_g(p_149719_2_, p_149719_3_, p_149719_4_);
      float f1 = 1.0F;
      float f2 = 1.0F;
      float f3 = 1.0F;
      float f4 = 0.0F;
      float f5 = 0.0F;
      float f6 = 0.0F;
      boolean flag = l > 0;
      if ((l & 2) != 0) {
         f4 = Math.max(f4, 0.0625F);
         f1 = 0.0F;
         f2 = 0.0F;
         f5 = 1.0F;
         f3 = 0.0F;
         f6 = 1.0F;
         flag = true;
      }

      if ((l & 8) != 0) {
         f1 = Math.min(f1, 0.9375F);
         f4 = 1.0F;
         f2 = 0.0F;
         f5 = 1.0F;
         f3 = 0.0F;
         f6 = 1.0F;
         flag = true;
      }

      if ((l & 4) != 0) {
         f6 = Math.max(f6, 0.0625F);
         f3 = 0.0F;
         f1 = 0.0F;
         f4 = 1.0F;
         f2 = 0.0F;
         f5 = 1.0F;
         flag = true;
      }

      if ((l & 1) != 0) {
         f3 = Math.min(f3, 0.9375F);
         f6 = 1.0F;
         f1 = 0.0F;
         f4 = 1.0F;
         f2 = 0.0F;
         f5 = 1.0F;
         flag = true;
      }

      if (!flag && this.func_150093_a(p_149719_1_.func_147439_a(p_149719_2_, p_149719_3_ + 1, p_149719_4_))) {
         f2 = Math.min(f2, 0.9375F);
         f5 = 1.0F;
         f1 = 0.0F;
         f4 = 1.0F;
         f3 = 0.0F;
         f6 = 1.0F;
      }

      this.func_149676_a(f1, f2, f3, f4, f5, f6);
   }

   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
      return null;
   }

   public boolean func_149707_d(World p_149707_1_, int p_149707_2_, int p_149707_3_, int p_149707_4_, int p_149707_5_) {
      switch (p_149707_5_) {
         case 1:
            return this.func_150093_a(p_149707_1_.func_147439_a(p_149707_2_, p_149707_3_ + 1, p_149707_4_));
         case 2:
            return this.func_150093_a(p_149707_1_.func_147439_a(p_149707_2_, p_149707_3_, p_149707_4_ + 1));
         case 3:
            return this.func_150093_a(p_149707_1_.func_147439_a(p_149707_2_, p_149707_3_, p_149707_4_ - 1));
         case 4:
            return this.func_150093_a(p_149707_1_.func_147439_a(p_149707_2_ + 1, p_149707_3_, p_149707_4_));
         case 5:
            return this.func_150093_a(p_149707_1_.func_147439_a(p_149707_2_ - 1, p_149707_3_, p_149707_4_));
         default:
            return false;
      }
   }

   private boolean func_150093_a(Block p_150093_1_) {
      return p_150093_1_.func_149686_d();
   }

   private boolean func_150094_e(World p_150094_1_, int p_150094_2_, int p_150094_3_, int p_150094_4_) {
      int l = p_150094_1_.func_72805_g(p_150094_2_, p_150094_3_, p_150094_4_);
      int i1 = l;
      if (l > 0) {
         for (int j1 = 0; j1 <= 3; j1++) {
            int k1 = 1 << j1;
            if ((l & k1) != 0
               && !this.func_150093_a(
                  p_150094_1_.func_147439_a(p_150094_2_ + Direction.field_71583_a[j1], p_150094_3_, p_150094_4_ + Direction.field_71581_b[j1])
               )
               && (
                  p_150094_1_.func_147439_a(p_150094_2_, p_150094_3_ + 1, p_150094_4_) != this
                     || (p_150094_1_.func_72805_g(p_150094_2_, p_150094_3_ + 1, p_150094_4_) & k1) == 0
               )) {
               i1 &= ~k1;
            }
         }
      }

      if (i1 == 0 && !this.func_150093_a(p_150094_1_.func_147439_a(p_150094_2_, p_150094_3_ + 1, p_150094_4_))) {
         return false;
      }

      if (i1 != l) {
         p_150094_1_.func_72921_c(p_150094_2_, p_150094_3_, p_150094_4_, i1, 2);
      }

      return true;
   }

   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
      if (!p_149695_1_.field_72995_K && !this.func_150094_e(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_)) {
         this.func_149697_b(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_), 0);
         p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_, p_149695_4_);
      }
   }

   public int func_149660_a(
      World p_149660_1_,
      int p_149660_2_,
      int p_149660_3_,
      int p_149660_4_,
      int p_149660_5_,
      float p_149660_6_,
      float p_149660_7_,
      float p_149660_8_,
      int p_149660_9_
   ) {
      byte b0 = 0;
      switch (p_149660_5_) {
         case 2:
            b0 = 1;
            break;
         case 3:
            b0 = 4;
            break;
         case 4:
            b0 = 8;
            break;
         case 5:
            b0 = 2;
      }

      return b0 != 0 ? b0 : p_149660_9_;
   }

   public final IIcon func_149691_a(int side, int meta) {
      return this.icon;
   }

   public void func_149651_a(IIconRegister iconregister) {
      this.icon = iconregister.func_94245_a(this.texpath);
   }
}
