package assets.rivalrebels.client.blockrenderer;

import assets.rivalrebels.RivalRebels;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

public class SteelBlockRenderer implements ISimpleBlockRenderingHandler {
   public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
      Tessellator tessellator = Tessellator.field_78398_a;
      block.func_149683_g();
      renderer.func_147775_a(block);
      GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
      GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
      tessellator.func_78382_b();
      tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
      renderer.func_147768_a(block, 0.0, 0.0, 0.0, renderer.func_147787_a(block, 0, metadata));
      tessellator.func_78381_a();
      tessellator.func_78382_b();
      tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
      renderer.func_147806_b(block, 0.0, 0.0, 0.0, renderer.func_147787_a(block, 1, metadata));
      tessellator.func_78381_a();
      tessellator.func_78382_b();
      tessellator.func_78375_b(0.0F, 0.0F, -1.0F);
      renderer.func_147761_c(block, 0.0, 0.0, 0.0, renderer.func_147787_a(block, 2, metadata));
      tessellator.func_78381_a();
      tessellator.func_78382_b();
      tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
      renderer.func_147734_d(block, 0.0, 0.0, 0.0, renderer.func_147787_a(block, 3, metadata));
      tessellator.func_78381_a();
      tessellator.func_78382_b();
      tessellator.func_78375_b(-1.0F, 0.0F, 0.0F);
      renderer.func_147798_e(block, 0.0, 0.0, 0.0, renderer.func_147787_a(block, 4, metadata));
      tessellator.func_78381_a();
      tessellator.func_78382_b();
      tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
      renderer.func_147764_f(block, 0.0, 0.0, 0.0, renderer.func_147787_a(block, 5, metadata));
      tessellator.func_78381_a();
      double offset = 0.876;
      double ooffset = -offset;
      tessellator.func_78382_b();
      tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
      renderer.func_147768_a(block, 0.0, offset, 0.0, renderer.func_147787_a(block, 0, metadata));
      tessellator.func_78381_a();
      tessellator.func_78382_b();
      tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
      renderer.func_147806_b(block, 0.0, ooffset, 0.0, renderer.func_147787_a(block, 1, metadata));
      tessellator.func_78381_a();
      tessellator.func_78382_b();
      tessellator.func_78375_b(0.0F, 0.0F, -1.0F);
      renderer.func_147761_c(block, 0.0, 0.0, offset, renderer.func_147787_a(block, 2, metadata));
      tessellator.func_78381_a();
      tessellator.func_78382_b();
      tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
      renderer.func_147734_d(block, 0.0, 0.0, ooffset, renderer.func_147787_a(block, 3, metadata));
      tessellator.func_78381_a();
      tessellator.func_78382_b();
      tessellator.func_78375_b(-1.0F, 0.0F, 0.0F);
      renderer.func_147798_e(block, offset, 0.0, 0.0, renderer.func_147787_a(block, 4, metadata));
      tessellator.func_78381_a();
      tessellator.func_78382_b();
      tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
      renderer.func_147764_f(block, ooffset, 0.0, 0.0, renderer.func_147787_a(block, 5, metadata));
      tessellator.func_78381_a();
      GL11.glTranslatef(0.5F, 0.5F, 0.5F);
   }

   public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
      if (block != RivalRebels.steel) {
         return false;
      }

      renderer.field_147863_w = true;
      float f3 = 0.0F;
      float f4 = 0.0F;
      float f5 = 0.0F;
      float f6 = 0.0F;
      int l = block.func_149677_c(renderer.field_147845_a, x, y, z);
      Tessellator tessellator = Tessellator.field_78398_a;
      tessellator.func_78380_c(0);
      IIcon icon = block.func_149691_a(0, 0);
      renderer.field_147831_S = block.func_149677_c(renderer.field_147845_a, x - 1, y, z);
      renderer.field_147825_U = block.func_149677_c(renderer.field_147845_a, x, y, z - 1);
      renderer.field_147828_V = block.func_149677_c(renderer.field_147845_a, x, y, z + 1);
      renderer.field_147835_X = block.func_149677_c(renderer.field_147845_a, x + 1, y, z);
      renderer.field_147886_y = block.func_149677_c(renderer.field_147845_a, x - 1, y, z);
      renderer.field_147814_A = block.func_149677_c(renderer.field_147845_a, x, y, z - 1);
      renderer.field_147815_B = block.func_149677_c(renderer.field_147845_a, x, y, z + 1);
      renderer.field_147810_D = block.func_149677_c(renderer.field_147845_a, x + 1, y, z);
      boolean flag3 = renderer.field_147845_a.func_147439_a(x + 1, y - 1, z).func_149751_l();
      boolean flag2 = renderer.field_147845_a.func_147439_a(x - 1, y - 1, z).func_149751_l();
      boolean flag5 = renderer.field_147845_a.func_147439_a(x, y - 1, z + 1).func_149751_l();
      boolean flag4 = renderer.field_147845_a.func_147439_a(x, y - 1, z - 1).func_149751_l();
      if (!flag4 && !flag2) {
         renderer.field_147888_x = renderer.field_147886_y;
         renderer.field_147832_R = renderer.field_147831_S;
      } else {
         renderer.field_147888_x = block.func_149677_c(renderer.field_147845_a, x - 1, y, z - 1);
         renderer.field_147832_R = block.func_149677_c(renderer.field_147845_a, x - 1, y, z - 1);
      }

      if (!flag5 && !flag2) {
         renderer.field_147884_z = renderer.field_147886_y;
         renderer.field_147826_T = renderer.field_147831_S;
      } else {
         renderer.field_147884_z = block.func_149677_c(renderer.field_147845_a, x - 1, y, z + 1);
         renderer.field_147826_T = block.func_149677_c(renderer.field_147845_a, x - 1, y, z + 1);
      }

      if (!flag4 && !flag3) {
         renderer.field_147816_C = renderer.field_147810_D;
         renderer.field_147827_W = renderer.field_147835_X;
      } else {
         renderer.field_147816_C = block.func_149677_c(renderer.field_147845_a, x + 1, y, z - 1);
         renderer.field_147827_W = block.func_149677_c(renderer.field_147845_a, x + 1, y, z - 1);
      }

      if (!flag5 && !flag3) {
         renderer.field_147811_E = renderer.field_147810_D;
         renderer.field_147834_Y = renderer.field_147835_X;
      } else {
         renderer.field_147811_E = block.func_149677_c(renderer.field_147845_a, x + 1, y, z + 1);
         renderer.field_147834_Y = block.func_149677_c(renderer.field_147845_a, x + 1, y, z + 1);
      }

      int i1 = l;
      if (renderer.field_147855_j <= 0.0 || !renderer.field_147845_a.func_147439_a(x, y - 1, z).func_149662_c()) {
         i1 = block.func_149677_c(renderer.field_147845_a, x, y - 1, z);
      }

      float f7 = block.func_149677_c(renderer.field_147845_a, x, y - 1, z);
      f3 = (renderer.field_147884_z + renderer.field_147886_y + renderer.field_147815_B + f7) / 4.0F;
      f6 = (renderer.field_147815_B + f7 + renderer.field_147811_E + renderer.field_147810_D) / 4.0F;
      f5 = (f7 + renderer.field_147814_A + renderer.field_147810_D + renderer.field_147816_C) / 4.0F;
      f4 = (renderer.field_147886_y + renderer.field_147888_x + f7 + renderer.field_147814_A) / 4.0F;
      renderer.field_147864_al = renderer.func_147778_a(renderer.field_147826_T, renderer.field_147831_S, renderer.field_147828_V, i1);
      renderer.field_147870_ao = renderer.func_147778_a(renderer.field_147828_V, renderer.field_147834_Y, renderer.field_147835_X, i1);
      renderer.field_147876_an = renderer.func_147778_a(renderer.field_147825_U, renderer.field_147835_X, renderer.field_147827_W, i1);
      renderer.field_147874_am = renderer.func_147778_a(renderer.field_147831_S, renderer.field_147832_R, renderer.field_147825_U, i1);
      renderer.field_147872_ap = renderer.field_147852_aq = renderer.field_147850_ar = renderer.field_147848_as = 0.5F;
      renderer.field_147846_at = renderer.field_147860_au = renderer.field_147858_av = renderer.field_147856_aw = 0.5F;
      renderer.field_147854_ax = renderer.field_147841_ay = renderer.field_147839_az = renderer.field_147833_aA = 0.5F;
      renderer.field_147872_ap *= f3;
      renderer.field_147846_at *= f3;
      renderer.field_147854_ax *= f3;
      renderer.field_147852_aq *= f4;
      renderer.field_147860_au *= f4;
      renderer.field_147841_ay *= f4;
      renderer.field_147850_ar *= f5;
      renderer.field_147858_av *= f5;
      renderer.field_147839_az *= f5;
      renderer.field_147848_as *= f6;
      renderer.field_147856_aw *= f6;
      renderer.field_147833_aA *= f6;
      renderer.func_147768_a(block, x, y, z, icon);
      renderer.field_147880_aa = block.func_149677_c(renderer.field_147845_a, x - 1, y, z);
      renderer.field_147885_ae = block.func_149677_c(renderer.field_147845_a, x + 1, y, z);
      renderer.field_147878_ac = block.func_149677_c(renderer.field_147845_a, x, y, z - 1);
      renderer.field_147887_af = block.func_149677_c(renderer.field_147845_a, x, y, z + 1);
      renderer.field_147813_G = block.func_149677_c(renderer.field_147845_a, x - 1, y, z);
      renderer.field_147824_K = block.func_149677_c(renderer.field_147845_a, x + 1, y, z);
      renderer.field_147822_I = block.func_149677_c(renderer.field_147845_a, x, y, z - 1);
      renderer.field_147817_L = block.func_149677_c(renderer.field_147845_a, x, y, z + 1);
      flag3 = renderer.field_147845_a.func_147439_a(x + 1, y + 1, z).func_149751_l();
      flag2 = renderer.field_147845_a.func_147439_a(x - 1, y + 1, z).func_149751_l();
      flag5 = renderer.field_147845_a.func_147439_a(x, y + 1, z + 1).func_149751_l();
      flag4 = renderer.field_147845_a.func_147439_a(x, y + 1, z - 1).func_149751_l();
      if (!flag4 && !flag2) {
         renderer.field_147812_F = renderer.field_147813_G;
         renderer.field_147836_Z = renderer.field_147880_aa;
      } else {
         renderer.field_147812_F = block.func_149677_c(renderer.field_147845_a, x - 1, y, z - 1);
         renderer.field_147836_Z = block.func_149677_c(renderer.field_147845_a, x - 1, y, z - 1);
      }

      if (!flag4 && !flag3) {
         renderer.field_147823_J = renderer.field_147824_K;
         renderer.field_147879_ad = renderer.field_147885_ae;
      } else {
         renderer.field_147823_J = block.func_149677_c(renderer.field_147845_a, x + 1, y, z - 1);
         renderer.field_147879_ad = block.func_149677_c(renderer.field_147845_a, x + 1, y, z - 1);
      }

      if (!flag5 && !flag2) {
         renderer.field_147821_H = renderer.field_147813_G;
         renderer.field_147881_ab = renderer.field_147880_aa;
      } else {
         renderer.field_147821_H = block.func_149677_c(renderer.field_147845_a, x - 1, y, z + 1);
         renderer.field_147881_ab = block.func_149677_c(renderer.field_147845_a, x - 1, y, z + 1);
      }

      if (!flag5 && !flag3) {
         renderer.field_147818_M = renderer.field_147824_K;
         renderer.field_147882_ag = renderer.field_147885_ae;
      } else {
         renderer.field_147818_M = block.func_149677_c(renderer.field_147845_a, x + 1, y, z + 1);
         renderer.field_147882_ag = block.func_149677_c(renderer.field_147845_a, x + 1, y, z + 1);
      }

      i1 = l;
      if (renderer.field_147857_k >= 1.0 || !renderer.field_147845_a.func_147439_a(x, y + 1, z).func_149662_c()) {
         i1 = block.func_149677_c(renderer.field_147845_a, x, y + 1, z);
      }

      f7 = block.func_149677_c(renderer.field_147845_a, x, y + 1, z);
      f6 = (renderer.field_147821_H + renderer.field_147813_G + renderer.field_147817_L + f7) / 4.0F;
      f3 = (renderer.field_147817_L + f7 + renderer.field_147818_M + renderer.field_147824_K) / 4.0F;
      f4 = (f7 + renderer.field_147822_I + renderer.field_147824_K + renderer.field_147823_J) / 4.0F;
      f5 = (renderer.field_147813_G + renderer.field_147812_F + f7 + renderer.field_147822_I) / 4.0F;
      renderer.field_147870_ao = renderer.func_147778_a(renderer.field_147881_ab, renderer.field_147880_aa, renderer.field_147887_af, i1);
      renderer.field_147864_al = renderer.func_147778_a(renderer.field_147887_af, renderer.field_147882_ag, renderer.field_147885_ae, i1);
      renderer.field_147874_am = renderer.func_147778_a(renderer.field_147878_ac, renderer.field_147885_ae, renderer.field_147879_ad, i1);
      renderer.field_147876_an = renderer.func_147778_a(renderer.field_147880_aa, renderer.field_147836_Z, renderer.field_147878_ac, i1);
      renderer.field_147872_ap = renderer.field_147852_aq = renderer.field_147850_ar = renderer.field_147848_as = 1.0F;
      renderer.field_147846_at = renderer.field_147860_au = renderer.field_147858_av = renderer.field_147856_aw = 1.0F;
      renderer.field_147854_ax = renderer.field_147841_ay = renderer.field_147839_az = renderer.field_147833_aA = 1.0F;
      renderer.field_147872_ap *= f3;
      renderer.field_147846_at *= f3;
      renderer.field_147854_ax *= f3;
      renderer.field_147852_aq *= f4;
      renderer.field_147860_au *= f4;
      renderer.field_147841_ay *= f4;
      renderer.field_147850_ar *= f5;
      renderer.field_147858_av *= f5;
      renderer.field_147839_az *= f5;
      renderer.field_147848_as *= f6;
      renderer.field_147856_aw *= f6;
      renderer.field_147833_aA *= f6;
      renderer.func_147806_b(block, x, y, z, icon);
      renderer.field_147819_N = block.func_149677_c(renderer.field_147845_a, x - 1, y, z);
      renderer.field_147814_A = block.func_149677_c(renderer.field_147845_a, x, y - 1, z);
      renderer.field_147822_I = block.func_149677_c(renderer.field_147845_a, x, y + 1, z);
      renderer.field_147820_O = block.func_149677_c(renderer.field_147845_a, x + 1, y, z);
      renderer.field_147883_ah = block.func_149677_c(renderer.field_147845_a, x - 1, y, z);
      renderer.field_147825_U = block.func_149677_c(renderer.field_147845_a, x, y - 1, z);
      renderer.field_147878_ac = block.func_149677_c(renderer.field_147845_a, x, y + 1, z);
      renderer.field_147866_ai = block.func_149677_c(renderer.field_147845_a, x + 1, y, z);
      flag3 = renderer.field_147845_a.func_147439_a(x + 1, y, z - 1).func_149751_l();
      flag2 = renderer.field_147845_a.func_147439_a(x - 1, y, z - 1).func_149751_l();
      flag5 = renderer.field_147845_a.func_147439_a(x, y + 1, z - 1).func_149751_l();
      flag4 = renderer.field_147845_a.func_147439_a(x, y - 1, z - 1).func_149751_l();
      if (!flag2 && !flag4) {
         renderer.field_147888_x = renderer.field_147819_N;
         renderer.field_147832_R = renderer.field_147883_ah;
      } else {
         renderer.field_147888_x = block.func_149677_c(renderer.field_147845_a, x - 1, y - 1, z);
         renderer.field_147832_R = block.func_149677_c(renderer.field_147845_a, x - 1, y - 1, z);
      }

      if (!flag2 && !flag5) {
         renderer.field_147812_F = renderer.field_147819_N;
         renderer.field_147836_Z = renderer.field_147883_ah;
      } else {
         renderer.field_147812_F = block.func_149677_c(renderer.field_147845_a, x - 1, y + 1, z);
         renderer.field_147836_Z = block.func_149677_c(renderer.field_147845_a, x - 1, y + 1, z);
      }

      if (!flag3 && !flag4) {
         renderer.field_147816_C = renderer.field_147820_O;
         renderer.field_147827_W = renderer.field_147866_ai;
      } else {
         renderer.field_147816_C = block.func_149677_c(renderer.field_147845_a, x + 1, y - 1, z);
         renderer.field_147827_W = block.func_149677_c(renderer.field_147845_a, x + 1, y - 1, z);
      }

      if (!flag3 && !flag5) {
         renderer.field_147823_J = renderer.field_147820_O;
         renderer.field_147879_ad = renderer.field_147866_ai;
      } else {
         renderer.field_147823_J = block.func_149677_c(renderer.field_147845_a, x + 1, y + 1, z);
         renderer.field_147879_ad = block.func_149677_c(renderer.field_147845_a, x + 1, y + 1, z);
      }

      i1 = l;
      if (renderer.field_147851_l <= 0.0 || !renderer.field_147845_a.func_147439_a(x, y, z - 1).func_149662_c()) {
         i1 = block.func_149677_c(renderer.field_147845_a, x, y, z - 1);
      }

      f7 = block.func_149677_c(renderer.field_147845_a, x, y, z - 1);
      f3 = (renderer.field_147819_N + renderer.field_147812_F + f7 + renderer.field_147822_I) / 4.0F;
      f4 = (f7 + renderer.field_147822_I + renderer.field_147820_O + renderer.field_147823_J) / 4.0F;
      f5 = (renderer.field_147814_A + f7 + renderer.field_147816_C + renderer.field_147820_O) / 4.0F;
      f6 = (renderer.field_147888_x + renderer.field_147819_N + renderer.field_147814_A + f7) / 4.0F;
      renderer.field_147864_al = renderer.func_147778_a(renderer.field_147883_ah, renderer.field_147836_Z, renderer.field_147878_ac, i1);
      renderer.field_147874_am = renderer.func_147778_a(renderer.field_147878_ac, renderer.field_147866_ai, renderer.field_147879_ad, i1);
      renderer.field_147876_an = renderer.func_147778_a(renderer.field_147825_U, renderer.field_147827_W, renderer.field_147866_ai, i1);
      renderer.field_147870_ao = renderer.func_147778_a(renderer.field_147832_R, renderer.field_147883_ah, renderer.field_147825_U, i1);
      renderer.field_147872_ap = renderer.field_147852_aq = renderer.field_147850_ar = renderer.field_147848_as = 0.8F;
      renderer.field_147846_at = renderer.field_147860_au = renderer.field_147858_av = renderer.field_147856_aw = 0.8F;
      renderer.field_147854_ax = renderer.field_147841_ay = renderer.field_147839_az = renderer.field_147833_aA = 0.8F;
      renderer.field_147872_ap *= f3;
      renderer.field_147846_at *= f3;
      renderer.field_147854_ax *= f3;
      renderer.field_147852_aq *= f4;
      renderer.field_147860_au *= f4;
      renderer.field_147841_ay *= f4;
      renderer.field_147850_ar *= f5;
      renderer.field_147858_av *= f5;
      renderer.field_147839_az *= f5;
      renderer.field_147848_as *= f6;
      renderer.field_147856_aw *= f6;
      renderer.field_147833_aA *= f6;
      renderer.func_147761_c(block, x, y, z, icon);
      renderer.field_147830_P = block.func_149677_c(renderer.field_147845_a, x - 1, y, z);
      renderer.field_147829_Q = block.func_149677_c(renderer.field_147845_a, x + 1, y, z);
      renderer.field_147815_B = block.func_149677_c(renderer.field_147845_a, x, y - 1, z);
      renderer.field_147817_L = block.func_149677_c(renderer.field_147845_a, x, y + 1, z);
      renderer.field_147868_aj = block.func_149677_c(renderer.field_147845_a, x - 1, y, z);
      renderer.field_147862_ak = block.func_149677_c(renderer.field_147845_a, x + 1, y, z);
      renderer.field_147828_V = block.func_149677_c(renderer.field_147845_a, x, y - 1, z);
      renderer.field_147887_af = block.func_149677_c(renderer.field_147845_a, x, y + 1, z);
      flag3 = renderer.field_147845_a.func_147439_a(x + 1, y, z + 1).func_149751_l();
      flag2 = renderer.field_147845_a.func_147439_a(x - 1, y, z + 1).func_149751_l();
      flag5 = renderer.field_147845_a.func_147439_a(x, y + 1, z + 1).func_149751_l();
      flag4 = renderer.field_147845_a.func_147439_a(x, y - 1, z + 1).func_149751_l();
      if (!flag2 && !flag4) {
         renderer.field_147884_z = renderer.field_147830_P;
         renderer.field_147826_T = renderer.field_147868_aj;
      } else {
         renderer.field_147884_z = block.func_149677_c(renderer.field_147845_a, x - 1, y - 1, z);
         renderer.field_147826_T = block.func_149677_c(renderer.field_147845_a, x - 1, y - 1, z);
      }

      if (!flag2 && !flag5) {
         renderer.field_147821_H = renderer.field_147830_P;
         renderer.field_147881_ab = renderer.field_147868_aj;
      } else {
         renderer.field_147821_H = block.func_149677_c(renderer.field_147845_a, x - 1, y + 1, z);
         renderer.field_147881_ab = block.func_149677_c(renderer.field_147845_a, x - 1, y + 1, z);
      }

      if (!flag3 && !flag4) {
         renderer.field_147811_E = renderer.field_147829_Q;
         renderer.field_147834_Y = renderer.field_147862_ak;
      } else {
         renderer.field_147811_E = block.func_149677_c(renderer.field_147845_a, x + 1, y - 1, z);
         renderer.field_147834_Y = block.func_149677_c(renderer.field_147845_a, x + 1, y - 1, z);
      }

      if (!flag3 && !flag5) {
         renderer.field_147818_M = renderer.field_147829_Q;
         renderer.field_147882_ag = renderer.field_147862_ak;
      } else {
         renderer.field_147818_M = block.func_149677_c(renderer.field_147845_a, x + 1, y + 1, z);
         renderer.field_147882_ag = block.func_149677_c(renderer.field_147845_a, x + 1, y + 1, z);
      }

      i1 = l;
      if (renderer.field_147853_m >= 1.0 || !renderer.field_147845_a.func_147439_a(x, y, z + 1).func_149662_c()) {
         i1 = block.func_149677_c(renderer.field_147845_a, x, y, z + 1);
      }

      f7 = block.func_149677_c(renderer.field_147845_a, x, y, z + 1);
      f3 = (renderer.field_147830_P + renderer.field_147821_H + f7 + renderer.field_147817_L) / 4.0F;
      f6 = (f7 + renderer.field_147817_L + renderer.field_147829_Q + renderer.field_147818_M) / 4.0F;
      f5 = (renderer.field_147815_B + f7 + renderer.field_147811_E + renderer.field_147829_Q) / 4.0F;
      f4 = (renderer.field_147884_z + renderer.field_147830_P + renderer.field_147815_B + f7) / 4.0F;
      renderer.field_147864_al = renderer.func_147778_a(renderer.field_147868_aj, renderer.field_147881_ab, renderer.field_147887_af, i1);
      renderer.field_147870_ao = renderer.func_147778_a(renderer.field_147887_af, renderer.field_147862_ak, renderer.field_147882_ag, i1);
      renderer.field_147876_an = renderer.func_147778_a(renderer.field_147828_V, renderer.field_147834_Y, renderer.field_147862_ak, i1);
      renderer.field_147874_am = renderer.func_147778_a(renderer.field_147826_T, renderer.field_147868_aj, renderer.field_147828_V, i1);
      renderer.field_147872_ap = renderer.field_147852_aq = renderer.field_147850_ar = renderer.field_147848_as = 0.8F;
      renderer.field_147846_at = renderer.field_147860_au = renderer.field_147858_av = renderer.field_147856_aw = 0.8F;
      renderer.field_147854_ax = renderer.field_147841_ay = renderer.field_147839_az = renderer.field_147833_aA = 0.8F;
      renderer.field_147872_ap *= f3;
      renderer.field_147846_at *= f3;
      renderer.field_147854_ax *= f3;
      renderer.field_147852_aq *= f4;
      renderer.field_147860_au *= f4;
      renderer.field_147841_ay *= f4;
      renderer.field_147850_ar *= f5;
      renderer.field_147858_av *= f5;
      renderer.field_147839_az *= f5;
      renderer.field_147848_as *= f6;
      renderer.field_147856_aw *= f6;
      renderer.field_147833_aA *= f6;
      renderer.func_147734_d(block, x, y, z, icon);
      renderer.field_147886_y = block.func_149677_c(renderer.field_147845_a, x, y - 1, z);
      renderer.field_147819_N = block.func_149677_c(renderer.field_147845_a, x, y, z - 1);
      renderer.field_147830_P = block.func_149677_c(renderer.field_147845_a, x, y, z + 1);
      renderer.field_147813_G = block.func_149677_c(renderer.field_147845_a, x, y + 1, z);
      renderer.field_147831_S = block.func_149677_c(renderer.field_147845_a, x, y - 1, z);
      renderer.field_147883_ah = block.func_149677_c(renderer.field_147845_a, x, y, z - 1);
      renderer.field_147868_aj = block.func_149677_c(renderer.field_147845_a, x, y, z + 1);
      renderer.field_147880_aa = block.func_149677_c(renderer.field_147845_a, x, y + 1, z);
      flag3 = renderer.field_147845_a.func_147439_a(x - 1, y + 1, z).func_149751_l();
      flag2 = renderer.field_147845_a.func_147439_a(x - 1, y - 1, z).func_149751_l();
      flag5 = renderer.field_147845_a.func_147439_a(x - 1, y, z - 1).func_149751_l();
      flag4 = renderer.field_147845_a.func_147439_a(x - 1, y, z + 1).func_149751_l();
      if (!flag5 && !flag2) {
         renderer.field_147888_x = renderer.field_147819_N;
         renderer.field_147832_R = renderer.field_147883_ah;
      } else {
         renderer.field_147888_x = block.func_149677_c(renderer.field_147845_a, x, y - 1, z - 1);
         renderer.field_147832_R = block.func_149677_c(renderer.field_147845_a, x, y - 1, z - 1);
      }

      if (!flag4 && !flag2) {
         renderer.field_147884_z = renderer.field_147830_P;
         renderer.field_147826_T = renderer.field_147868_aj;
      } else {
         renderer.field_147884_z = block.func_149677_c(renderer.field_147845_a, x, y - 1, z + 1);
         renderer.field_147826_T = block.func_149677_c(renderer.field_147845_a, x, y - 1, z + 1);
      }

      if (!flag5 && !flag3) {
         renderer.field_147812_F = renderer.field_147819_N;
         renderer.field_147836_Z = renderer.field_147883_ah;
      } else {
         renderer.field_147812_F = block.func_149677_c(renderer.field_147845_a, x, y + 1, z - 1);
         renderer.field_147836_Z = block.func_149677_c(renderer.field_147845_a, x, y + 1, z - 1);
      }

      if (!flag4 && !flag3) {
         renderer.field_147821_H = renderer.field_147830_P;
         renderer.field_147881_ab = renderer.field_147868_aj;
      } else {
         renderer.field_147821_H = block.func_149677_c(renderer.field_147845_a, x, y + 1, z + 1);
         renderer.field_147881_ab = block.func_149677_c(renderer.field_147845_a, x, y + 1, z + 1);
      }

      i1 = l;
      if (renderer.field_147859_h <= 0.0 || !renderer.field_147845_a.func_147439_a(x - 1, y, z).func_149662_c()) {
         i1 = block.func_149677_c(renderer.field_147845_a, x - 1, y, z);
      }

      f7 = block.func_149677_c(renderer.field_147845_a, x - 1, y, z);
      f6 = (renderer.field_147886_y + renderer.field_147884_z + f7 + renderer.field_147830_P) / 4.0F;
      f3 = (f7 + renderer.field_147830_P + renderer.field_147813_G + renderer.field_147821_H) / 4.0F;
      f4 = (renderer.field_147819_N + f7 + renderer.field_147812_F + renderer.field_147813_G) / 4.0F;
      f5 = (renderer.field_147888_x + renderer.field_147886_y + renderer.field_147819_N + f7) / 4.0F;
      renderer.field_147870_ao = renderer.func_147778_a(renderer.field_147831_S, renderer.field_147826_T, renderer.field_147868_aj, i1);
      renderer.field_147864_al = renderer.func_147778_a(renderer.field_147868_aj, renderer.field_147880_aa, renderer.field_147881_ab, i1);
      renderer.field_147874_am = renderer.func_147778_a(renderer.field_147883_ah, renderer.field_147836_Z, renderer.field_147880_aa, i1);
      renderer.field_147876_an = renderer.func_147778_a(renderer.field_147832_R, renderer.field_147831_S, renderer.field_147883_ah, i1);
      renderer.field_147872_ap = renderer.field_147852_aq = renderer.field_147850_ar = renderer.field_147848_as = 0.6F;
      renderer.field_147846_at = renderer.field_147860_au = renderer.field_147858_av = renderer.field_147856_aw = 0.6F;
      renderer.field_147854_ax = renderer.field_147841_ay = renderer.field_147839_az = renderer.field_147833_aA = 0.6F;
      renderer.field_147872_ap *= f3;
      renderer.field_147846_at *= f3;
      renderer.field_147854_ax *= f3;
      renderer.field_147852_aq *= f4;
      renderer.field_147860_au *= f4;
      renderer.field_147841_ay *= f4;
      renderer.field_147850_ar *= f5;
      renderer.field_147858_av *= f5;
      renderer.field_147839_az *= f5;
      renderer.field_147848_as *= f6;
      renderer.field_147856_aw *= f6;
      renderer.field_147833_aA *= f6;
      renderer.func_147798_e(block, x, y, z, icon);
      renderer.field_147810_D = block.func_149677_c(renderer.field_147845_a, x, y - 1, z);
      renderer.field_147820_O = block.func_149677_c(renderer.field_147845_a, x, y, z - 1);
      renderer.field_147829_Q = block.func_149677_c(renderer.field_147845_a, x, y, z + 1);
      renderer.field_147824_K = block.func_149677_c(renderer.field_147845_a, x, y + 1, z);
      renderer.field_147835_X = block.func_149677_c(renderer.field_147845_a, x, y - 1, z);
      renderer.field_147866_ai = block.func_149677_c(renderer.field_147845_a, x, y, z - 1);
      renderer.field_147862_ak = block.func_149677_c(renderer.field_147845_a, x, y, z + 1);
      renderer.field_147885_ae = block.func_149677_c(renderer.field_147845_a, x, y + 1, z);
      flag3 = renderer.field_147845_a.func_147439_a(x + 1, y + 1, z).func_149751_l();
      flag2 = renderer.field_147845_a.func_147439_a(x + 1, y - 1, z).func_149751_l();
      flag5 = renderer.field_147845_a.func_147439_a(x + 1, y, z + 1).func_149751_l();
      flag4 = renderer.field_147845_a.func_147439_a(x + 1, y, z - 1).func_149751_l();
      if (!flag2 && !flag4) {
         renderer.field_147816_C = renderer.field_147820_O;
         renderer.field_147827_W = renderer.field_147866_ai;
      } else {
         renderer.field_147816_C = block.func_149677_c(renderer.field_147845_a, x, y - 1, z - 1);
         renderer.field_147827_W = block.func_149677_c(renderer.field_147845_a, x, y - 1, z - 1);
      }

      if (!flag2 && !flag5) {
         renderer.field_147811_E = renderer.field_147829_Q;
         renderer.field_147834_Y = renderer.field_147862_ak;
      } else {
         renderer.field_147811_E = block.func_149677_c(renderer.field_147845_a, x, y - 1, z + 1);
         renderer.field_147834_Y = block.func_149677_c(renderer.field_147845_a, x, y - 1, z + 1);
      }

      if (!flag3 && !flag4) {
         renderer.field_147823_J = renderer.field_147820_O;
         renderer.field_147879_ad = renderer.field_147866_ai;
      } else {
         renderer.field_147823_J = block.func_149677_c(renderer.field_147845_a, x, y + 1, z - 1);
         renderer.field_147879_ad = block.func_149677_c(renderer.field_147845_a, x, y + 1, z - 1);
      }

      if (!flag3 && !flag5) {
         renderer.field_147818_M = renderer.field_147829_Q;
         renderer.field_147882_ag = renderer.field_147862_ak;
      } else {
         renderer.field_147818_M = block.func_149677_c(renderer.field_147845_a, x, y + 1, z + 1);
         renderer.field_147882_ag = block.func_149677_c(renderer.field_147845_a, x, y + 1, z + 1);
      }

      i1 = l;
      if (renderer.field_147861_i >= 1.0 || !renderer.field_147845_a.func_147439_a(x + 1, y, z).func_149662_c()) {
         i1 = block.func_149677_c(renderer.field_147845_a, x + 1, y, z);
      }

      f7 = block.func_149677_c(renderer.field_147845_a, x + 1, y, z);
      f3 = (renderer.field_147810_D + renderer.field_147811_E + f7 + renderer.field_147829_Q) / 4.0F;
      f4 = (renderer.field_147816_C + renderer.field_147810_D + renderer.field_147820_O + f7) / 4.0F;
      f5 = (renderer.field_147820_O + f7 + renderer.field_147823_J + renderer.field_147824_K) / 4.0F;
      f6 = (f7 + renderer.field_147829_Q + renderer.field_147824_K + renderer.field_147818_M) / 4.0F;
      renderer.field_147864_al = renderer.func_147778_a(renderer.field_147835_X, renderer.field_147834_Y, renderer.field_147862_ak, i1);
      renderer.field_147870_ao = renderer.func_147778_a(renderer.field_147862_ak, renderer.field_147885_ae, renderer.field_147882_ag, i1);
      renderer.field_147876_an = renderer.func_147778_a(renderer.field_147866_ai, renderer.field_147879_ad, renderer.field_147885_ae, i1);
      renderer.field_147874_am = renderer.func_147778_a(renderer.field_147827_W, renderer.field_147835_X, renderer.field_147866_ai, i1);
      renderer.field_147872_ap = renderer.field_147852_aq = renderer.field_147850_ar = renderer.field_147848_as = 0.6F;
      renderer.field_147846_at = renderer.field_147860_au = renderer.field_147858_av = renderer.field_147856_aw = 0.6F;
      renderer.field_147854_ax = renderer.field_147841_ay = renderer.field_147839_az = renderer.field_147833_aA = 0.6F;
      renderer.field_147872_ap *= f3;
      renderer.field_147846_at *= f3;
      renderer.field_147854_ax *= f3;
      renderer.field_147852_aq *= f4;
      renderer.field_147860_au *= f4;
      renderer.field_147841_ay *= f4;
      renderer.field_147850_ar *= f5;
      renderer.field_147858_av *= f5;
      renderer.field_147839_az *= f5;
      renderer.field_147848_as *= f6;
      renderer.field_147856_aw *= f6;
      renderer.field_147833_aA *= f6;
      renderer.func_147764_f(block, x, y, z, icon);
      double offset = 0.124;
      y++;
      renderer.field_147831_S = block.func_149677_c(renderer.field_147845_a, x - 1, y, z);
      renderer.field_147825_U = block.func_149677_c(renderer.field_147845_a, x, y, z - 1);
      renderer.field_147828_V = block.func_149677_c(renderer.field_147845_a, x, y, z + 1);
      renderer.field_147835_X = block.func_149677_c(renderer.field_147845_a, x + 1, y, z);
      renderer.field_147886_y = block.func_149677_c(renderer.field_147845_a, x - 1, y, z);
      renderer.field_147814_A = block.func_149677_c(renderer.field_147845_a, x, y, z - 1);
      renderer.field_147815_B = block.func_149677_c(renderer.field_147845_a, x, y, z + 1);
      renderer.field_147810_D = block.func_149677_c(renderer.field_147845_a, x + 1, y, z);
      flag3 = renderer.field_147845_a.func_147439_a(x + 1, y - 1, z).func_149751_l();
      flag2 = renderer.field_147845_a.func_147439_a(x - 1, y - 1, z).func_149751_l();
      flag5 = renderer.field_147845_a.func_147439_a(x, y - 1, z + 1).func_149751_l();
      flag4 = renderer.field_147845_a.func_147439_a(x, y - 1, z - 1).func_149751_l();
      if (!flag4 && !flag2) {
         renderer.field_147888_x = renderer.field_147886_y;
         renderer.field_147832_R = renderer.field_147831_S;
      } else {
         renderer.field_147888_x = block.func_149677_c(renderer.field_147845_a, x - 1, y, z - 1);
         renderer.field_147832_R = block.func_149677_c(renderer.field_147845_a, x - 1, y, z - 1);
      }

      if (!flag5 && !flag2) {
         renderer.field_147884_z = renderer.field_147886_y;
         renderer.field_147826_T = renderer.field_147831_S;
      } else {
         renderer.field_147884_z = block.func_149677_c(renderer.field_147845_a, x - 1, y, z + 1);
         renderer.field_147826_T = block.func_149677_c(renderer.field_147845_a, x - 1, y, z + 1);
      }

      if (!flag4 && !flag3) {
         renderer.field_147816_C = renderer.field_147810_D;
         renderer.field_147827_W = renderer.field_147835_X;
      } else {
         renderer.field_147816_C = block.func_149677_c(renderer.field_147845_a, x + 1, y, z - 1);
         renderer.field_147827_W = block.func_149677_c(renderer.field_147845_a, x + 1, y, z - 1);
      }

      if (!flag5 && !flag3) {
         renderer.field_147811_E = renderer.field_147810_D;
         renderer.field_147834_Y = renderer.field_147835_X;
      } else {
         renderer.field_147811_E = block.func_149677_c(renderer.field_147845_a, x + 1, y, z + 1);
         renderer.field_147834_Y = block.func_149677_c(renderer.field_147845_a, x + 1, y, z + 1);
      }

      i1 = l;
      if (renderer.field_147855_j <= 0.0 || !renderer.field_147845_a.func_147439_a(x, y - 1, z).func_149662_c()) {
         i1 = block.func_149677_c(renderer.field_147845_a, x, y - 1, z);
      }

      f7 = block.func_149677_c(renderer.field_147845_a, x, y - 1, z);
      f3 = (renderer.field_147884_z + renderer.field_147886_y + renderer.field_147815_B + f7) / 4.0F;
      f6 = (renderer.field_147815_B + f7 + renderer.field_147811_E + renderer.field_147810_D) / 4.0F;
      f5 = (f7 + renderer.field_147814_A + renderer.field_147810_D + renderer.field_147816_C) / 4.0F;
      f4 = (renderer.field_147886_y + renderer.field_147888_x + f7 + renderer.field_147814_A) / 4.0F;
      renderer.field_147864_al = renderer.func_147778_a(renderer.field_147826_T, renderer.field_147831_S, renderer.field_147828_V, i1);
      renderer.field_147870_ao = renderer.func_147778_a(renderer.field_147828_V, renderer.field_147834_Y, renderer.field_147835_X, i1);
      renderer.field_147876_an = renderer.func_147778_a(renderer.field_147825_U, renderer.field_147835_X, renderer.field_147827_W, i1);
      renderer.field_147874_am = renderer.func_147778_a(renderer.field_147831_S, renderer.field_147832_R, renderer.field_147825_U, i1);
      renderer.field_147872_ap = renderer.field_147852_aq = renderer.field_147850_ar = renderer.field_147848_as = 0.5F;
      renderer.field_147846_at = renderer.field_147860_au = renderer.field_147858_av = renderer.field_147856_aw = 0.5F;
      renderer.field_147854_ax = renderer.field_147841_ay = renderer.field_147839_az = renderer.field_147833_aA = 0.5F;
      renderer.field_147872_ap *= f3;
      renderer.field_147846_at *= f3;
      renderer.field_147854_ax *= f3;
      renderer.field_147852_aq *= f4;
      renderer.field_147860_au *= f4;
      renderer.field_147841_ay *= f4;
      renderer.field_147850_ar *= f5;
      renderer.field_147858_av *= f5;
      renderer.field_147839_az *= f5;
      renderer.field_147848_as *= f6;
      renderer.field_147856_aw *= f6;
      renderer.field_147833_aA *= f6;
      renderer.func_147768_a(block, x, y - offset, z, icon);
      y--;
      y--;
      renderer.field_147880_aa = block.func_149677_c(renderer.field_147845_a, x - 1, y, z);
      renderer.field_147885_ae = block.func_149677_c(renderer.field_147845_a, x + 1, y, z);
      renderer.field_147878_ac = block.func_149677_c(renderer.field_147845_a, x, y, z - 1);
      renderer.field_147887_af = block.func_149677_c(renderer.field_147845_a, x, y, z + 1);
      renderer.field_147813_G = block.func_149677_c(renderer.field_147845_a, x - 1, y, z);
      renderer.field_147824_K = block.func_149677_c(renderer.field_147845_a, x + 1, y, z);
      renderer.field_147822_I = block.func_149677_c(renderer.field_147845_a, x, y, z - 1);
      renderer.field_147817_L = block.func_149677_c(renderer.field_147845_a, x, y, z + 1);
      flag3 = renderer.field_147845_a.func_147439_a(x + 1, y + 1, z).func_149751_l();
      flag2 = renderer.field_147845_a.func_147439_a(x - 1, y + 1, z).func_149751_l();
      flag5 = renderer.field_147845_a.func_147439_a(x, y + 1, z + 1).func_149751_l();
      flag4 = renderer.field_147845_a.func_147439_a(x, y + 1, z - 1).func_149751_l();
      if (!flag4 && !flag2) {
         renderer.field_147812_F = renderer.field_147813_G;
         renderer.field_147836_Z = renderer.field_147880_aa;
      } else {
         renderer.field_147812_F = block.func_149677_c(renderer.field_147845_a, x - 1, y, z - 1);
         renderer.field_147836_Z = block.func_149677_c(renderer.field_147845_a, x - 1, y, z - 1);
      }

      if (!flag4 && !flag3) {
         renderer.field_147823_J = renderer.field_147824_K;
         renderer.field_147879_ad = renderer.field_147885_ae;
      } else {
         renderer.field_147823_J = block.func_149677_c(renderer.field_147845_a, x + 1, y, z - 1);
         renderer.field_147879_ad = block.func_149677_c(renderer.field_147845_a, x + 1, y, z - 1);
      }

      if (!flag5 && !flag2) {
         renderer.field_147821_H = renderer.field_147813_G;
         renderer.field_147881_ab = renderer.field_147880_aa;
      } else {
         renderer.field_147821_H = block.func_149677_c(renderer.field_147845_a, x - 1, y, z + 1);
         renderer.field_147881_ab = block.func_149677_c(renderer.field_147845_a, x - 1, y, z + 1);
      }

      if (!flag5 && !flag3) {
         renderer.field_147818_M = renderer.field_147824_K;
         renderer.field_147882_ag = renderer.field_147885_ae;
      } else {
         renderer.field_147818_M = block.func_149677_c(renderer.field_147845_a, x + 1, y, z + 1);
         renderer.field_147882_ag = block.func_149677_c(renderer.field_147845_a, x + 1, y, z + 1);
      }

      i1 = l;
      if (renderer.field_147857_k >= 1.0 || !renderer.field_147845_a.func_147439_a(x, y + 1, z).func_149662_c()) {
         i1 = block.func_149677_c(renderer.field_147845_a, x, y + 1, z);
      }

      f7 = block.func_149677_c(renderer.field_147845_a, x, y + 1, z);
      f6 = (renderer.field_147821_H + renderer.field_147813_G + renderer.field_147817_L + f7) / 4.0F;
      f3 = (renderer.field_147817_L + f7 + renderer.field_147818_M + renderer.field_147824_K) / 4.0F;
      f4 = (f7 + renderer.field_147822_I + renderer.field_147824_K + renderer.field_147823_J) / 4.0F;
      f5 = (renderer.field_147813_G + renderer.field_147812_F + f7 + renderer.field_147822_I) / 4.0F;
      renderer.field_147870_ao = renderer.func_147778_a(renderer.field_147881_ab, renderer.field_147880_aa, renderer.field_147887_af, i1);
      renderer.field_147864_al = renderer.func_147778_a(renderer.field_147887_af, renderer.field_147882_ag, renderer.field_147885_ae, i1);
      renderer.field_147874_am = renderer.func_147778_a(renderer.field_147878_ac, renderer.field_147885_ae, renderer.field_147879_ad, i1);
      renderer.field_147876_an = renderer.func_147778_a(renderer.field_147880_aa, renderer.field_147836_Z, renderer.field_147878_ac, i1);
      renderer.field_147872_ap = renderer.field_147852_aq = renderer.field_147850_ar = renderer.field_147848_as = 1.0F;
      renderer.field_147846_at = renderer.field_147860_au = renderer.field_147858_av = renderer.field_147856_aw = 1.0F;
      renderer.field_147854_ax = renderer.field_147841_ay = renderer.field_147839_az = renderer.field_147833_aA = 1.0F;
      renderer.field_147872_ap *= f3;
      renderer.field_147846_at *= f3;
      renderer.field_147854_ax *= f3;
      renderer.field_147852_aq *= f4;
      renderer.field_147860_au *= f4;
      renderer.field_147841_ay *= f4;
      renderer.field_147850_ar *= f5;
      renderer.field_147858_av *= f5;
      renderer.field_147839_az *= f5;
      renderer.field_147848_as *= f6;
      renderer.field_147856_aw *= f6;
      renderer.field_147833_aA *= f6;
      renderer.func_147806_b(block, x, y + offset, z, icon);
      y++;
      z++;
      renderer.field_147819_N = block.func_149677_c(renderer.field_147845_a, x - 1, y, z);
      renderer.field_147814_A = block.func_149677_c(renderer.field_147845_a, x, y - 1, z);
      renderer.field_147822_I = block.func_149677_c(renderer.field_147845_a, x, y + 1, z);
      renderer.field_147820_O = block.func_149677_c(renderer.field_147845_a, x + 1, y, z);
      renderer.field_147883_ah = block.func_149677_c(renderer.field_147845_a, x - 1, y, z);
      renderer.field_147825_U = block.func_149677_c(renderer.field_147845_a, x, y - 1, z);
      renderer.field_147878_ac = block.func_149677_c(renderer.field_147845_a, x, y + 1, z);
      renderer.field_147866_ai = block.func_149677_c(renderer.field_147845_a, x + 1, y, z);
      flag3 = renderer.field_147845_a.func_147439_a(x + 1, y, z - 1).func_149751_l();
      flag2 = renderer.field_147845_a.func_147439_a(x - 1, y, z - 1).func_149751_l();
      flag5 = renderer.field_147845_a.func_147439_a(x, y + 1, z - 1).func_149751_l();
      flag4 = renderer.field_147845_a.func_147439_a(x, y - 1, z - 1).func_149751_l();
      if (!flag2 && !flag4) {
         renderer.field_147888_x = renderer.field_147819_N;
         renderer.field_147832_R = renderer.field_147883_ah;
      } else {
         renderer.field_147888_x = block.func_149677_c(renderer.field_147845_a, x - 1, y - 1, z);
         renderer.field_147832_R = block.func_149677_c(renderer.field_147845_a, x - 1, y - 1, z);
      }

      if (!flag2 && !flag5) {
         renderer.field_147812_F = renderer.field_147819_N;
         renderer.field_147836_Z = renderer.field_147883_ah;
      } else {
         renderer.field_147812_F = block.func_149677_c(renderer.field_147845_a, x - 1, y + 1, z);
         renderer.field_147836_Z = block.func_149677_c(renderer.field_147845_a, x - 1, y + 1, z);
      }

      if (!flag3 && !flag4) {
         renderer.field_147816_C = renderer.field_147820_O;
         renderer.field_147827_W = renderer.field_147866_ai;
      } else {
         renderer.field_147816_C = block.func_149677_c(renderer.field_147845_a, x + 1, y - 1, z);
         renderer.field_147827_W = block.func_149677_c(renderer.field_147845_a, x + 1, y - 1, z);
      }

      if (!flag3 && !flag5) {
         renderer.field_147823_J = renderer.field_147820_O;
         renderer.field_147879_ad = renderer.field_147866_ai;
      } else {
         renderer.field_147823_J = block.func_149677_c(renderer.field_147845_a, x + 1, y + 1, z);
         renderer.field_147879_ad = block.func_149677_c(renderer.field_147845_a, x + 1, y + 1, z);
      }

      i1 = l;
      if (renderer.field_147851_l <= 0.0 || !renderer.field_147845_a.func_147439_a(x, y, z - 1).func_149662_c()) {
         i1 = block.func_149677_c(renderer.field_147845_a, x, y, z - 1);
      }

      f7 = block.func_149677_c(renderer.field_147845_a, x, y, z - 1);
      f3 = (renderer.field_147819_N + renderer.field_147812_F + f7 + renderer.field_147822_I) / 4.0F;
      f4 = (f7 + renderer.field_147822_I + renderer.field_147820_O + renderer.field_147823_J) / 4.0F;
      f5 = (renderer.field_147814_A + f7 + renderer.field_147816_C + renderer.field_147820_O) / 4.0F;
      f6 = (renderer.field_147888_x + renderer.field_147819_N + renderer.field_147814_A + f7) / 4.0F;
      renderer.field_147864_al = renderer.func_147778_a(renderer.field_147883_ah, renderer.field_147836_Z, renderer.field_147878_ac, i1);
      renderer.field_147874_am = renderer.func_147778_a(renderer.field_147878_ac, renderer.field_147866_ai, renderer.field_147879_ad, i1);
      renderer.field_147876_an = renderer.func_147778_a(renderer.field_147825_U, renderer.field_147827_W, renderer.field_147866_ai, i1);
      renderer.field_147870_ao = renderer.func_147778_a(renderer.field_147832_R, renderer.field_147883_ah, renderer.field_147825_U, i1);
      renderer.field_147872_ap = renderer.field_147852_aq = renderer.field_147850_ar = renderer.field_147848_as = 0.8F;
      renderer.field_147846_at = renderer.field_147860_au = renderer.field_147858_av = renderer.field_147856_aw = 0.8F;
      renderer.field_147854_ax = renderer.field_147841_ay = renderer.field_147839_az = renderer.field_147833_aA = 0.8F;
      renderer.field_147872_ap *= f3;
      renderer.field_147846_at *= f3;
      renderer.field_147854_ax *= f3;
      renderer.field_147852_aq *= f4;
      renderer.field_147860_au *= f4;
      renderer.field_147841_ay *= f4;
      renderer.field_147850_ar *= f5;
      renderer.field_147858_av *= f5;
      renderer.field_147839_az *= f5;
      renderer.field_147848_as *= f6;
      renderer.field_147856_aw *= f6;
      renderer.field_147833_aA *= f6;
      renderer.func_147761_c(block, x, y, z - offset, icon);
      z--;
      z--;
      renderer.field_147830_P = block.func_149677_c(renderer.field_147845_a, x - 1, y, z);
      renderer.field_147829_Q = block.func_149677_c(renderer.field_147845_a, x + 1, y, z);
      renderer.field_147815_B = block.func_149677_c(renderer.field_147845_a, x, y - 1, z);
      renderer.field_147817_L = block.func_149677_c(renderer.field_147845_a, x, y + 1, z);
      renderer.field_147868_aj = block.func_149677_c(renderer.field_147845_a, x - 1, y, z);
      renderer.field_147862_ak = block.func_149677_c(renderer.field_147845_a, x + 1, y, z);
      renderer.field_147828_V = block.func_149677_c(renderer.field_147845_a, x, y - 1, z);
      renderer.field_147887_af = block.func_149677_c(renderer.field_147845_a, x, y + 1, z);
      flag3 = renderer.field_147845_a.func_147439_a(x + 1, y, z + 1).func_149751_l();
      flag2 = renderer.field_147845_a.func_147439_a(x - 1, y, z + 1).func_149751_l();
      flag5 = renderer.field_147845_a.func_147439_a(x, y + 1, z + 1).func_149751_l();
      flag4 = renderer.field_147845_a.func_147439_a(x, y - 1, z + 1).func_149751_l();
      if (!flag2 && !flag4) {
         renderer.field_147884_z = renderer.field_147830_P;
         renderer.field_147826_T = renderer.field_147868_aj;
      } else {
         renderer.field_147884_z = block.func_149677_c(renderer.field_147845_a, x - 1, y - 1, z);
         renderer.field_147826_T = block.func_149677_c(renderer.field_147845_a, x - 1, y - 1, z);
      }

      if (!flag2 && !flag5) {
         renderer.field_147821_H = renderer.field_147830_P;
         renderer.field_147881_ab = renderer.field_147868_aj;
      } else {
         renderer.field_147821_H = block.func_149677_c(renderer.field_147845_a, x - 1, y + 1, z);
         renderer.field_147881_ab = block.func_149677_c(renderer.field_147845_a, x - 1, y + 1, z);
      }

      if (!flag3 && !flag4) {
         renderer.field_147811_E = renderer.field_147829_Q;
         renderer.field_147834_Y = renderer.field_147862_ak;
      } else {
         renderer.field_147811_E = block.func_149677_c(renderer.field_147845_a, x + 1, y - 1, z);
         renderer.field_147834_Y = block.func_149677_c(renderer.field_147845_a, x + 1, y - 1, z);
      }

      if (!flag3 && !flag5) {
         renderer.field_147818_M = renderer.field_147829_Q;
         renderer.field_147882_ag = renderer.field_147862_ak;
      } else {
         renderer.field_147818_M = block.func_149677_c(renderer.field_147845_a, x + 1, y + 1, z);
         renderer.field_147882_ag = block.func_149677_c(renderer.field_147845_a, x + 1, y + 1, z);
      }

      i1 = l;
      if (renderer.field_147853_m >= 1.0 || !renderer.field_147845_a.func_147439_a(x, y, z + 1).func_149662_c()) {
         i1 = block.func_149677_c(renderer.field_147845_a, x, y, z + 1);
      }

      f7 = block.func_149677_c(renderer.field_147845_a, x, y, z + 1);
      f3 = (renderer.field_147830_P + renderer.field_147821_H + f7 + renderer.field_147817_L) / 4.0F;
      f6 = (f7 + renderer.field_147817_L + renderer.field_147829_Q + renderer.field_147818_M) / 4.0F;
      f5 = (renderer.field_147815_B + f7 + renderer.field_147811_E + renderer.field_147829_Q) / 4.0F;
      f4 = (renderer.field_147884_z + renderer.field_147830_P + renderer.field_147815_B + f7) / 4.0F;
      renderer.field_147864_al = renderer.func_147778_a(renderer.field_147868_aj, renderer.field_147881_ab, renderer.field_147887_af, i1);
      renderer.field_147870_ao = renderer.func_147778_a(renderer.field_147887_af, renderer.field_147862_ak, renderer.field_147882_ag, i1);
      renderer.field_147876_an = renderer.func_147778_a(renderer.field_147828_V, renderer.field_147834_Y, renderer.field_147862_ak, i1);
      renderer.field_147874_am = renderer.func_147778_a(renderer.field_147826_T, renderer.field_147868_aj, renderer.field_147828_V, i1);
      renderer.field_147872_ap = renderer.field_147852_aq = renderer.field_147850_ar = renderer.field_147848_as = 0.8F;
      renderer.field_147846_at = renderer.field_147860_au = renderer.field_147858_av = renderer.field_147856_aw = 0.8F;
      renderer.field_147854_ax = renderer.field_147841_ay = renderer.field_147839_az = renderer.field_147833_aA = 0.8F;
      renderer.field_147872_ap *= f3;
      renderer.field_147846_at *= f3;
      renderer.field_147854_ax *= f3;
      renderer.field_147852_aq *= f4;
      renderer.field_147860_au *= f4;
      renderer.field_147841_ay *= f4;
      renderer.field_147850_ar *= f5;
      renderer.field_147858_av *= f5;
      renderer.field_147839_az *= f5;
      renderer.field_147848_as *= f6;
      renderer.field_147856_aw *= f6;
      renderer.field_147833_aA *= f6;
      renderer.func_147734_d(block, x, y, z + offset, icon);
      z++;
      renderer.field_147886_y = block.func_149677_c(renderer.field_147845_a, ++x, y - 1, z);
      renderer.field_147819_N = block.func_149677_c(renderer.field_147845_a, x, y, z - 1);
      renderer.field_147830_P = block.func_149677_c(renderer.field_147845_a, x, y, z + 1);
      renderer.field_147813_G = block.func_149677_c(renderer.field_147845_a, x, y + 1, z);
      renderer.field_147831_S = block.func_149677_c(renderer.field_147845_a, x, y - 1, z);
      renderer.field_147883_ah = block.func_149677_c(renderer.field_147845_a, x, y, z - 1);
      renderer.field_147868_aj = block.func_149677_c(renderer.field_147845_a, x, y, z + 1);
      renderer.field_147880_aa = block.func_149677_c(renderer.field_147845_a, x, y + 1, z);
      flag3 = renderer.field_147845_a.func_147439_a(x - 1, y + 1, z).func_149751_l();
      flag2 = renderer.field_147845_a.func_147439_a(x - 1, y - 1, z).func_149751_l();
      flag5 = renderer.field_147845_a.func_147439_a(x - 1, y, z - 1).func_149751_l();
      flag4 = renderer.field_147845_a.func_147439_a(x - 1, y, z + 1).func_149751_l();
      if (!flag5 && !flag2) {
         renderer.field_147888_x = renderer.field_147819_N;
         renderer.field_147832_R = renderer.field_147883_ah;
      } else {
         renderer.field_147888_x = block.func_149677_c(renderer.field_147845_a, x, y - 1, z - 1);
         renderer.field_147832_R = block.func_149677_c(renderer.field_147845_a, x, y - 1, z - 1);
      }

      if (!flag4 && !flag2) {
         renderer.field_147884_z = renderer.field_147830_P;
         renderer.field_147826_T = renderer.field_147868_aj;
      } else {
         renderer.field_147884_z = block.func_149677_c(renderer.field_147845_a, x, y - 1, z + 1);
         renderer.field_147826_T = block.func_149677_c(renderer.field_147845_a, x, y - 1, z + 1);
      }

      if (!flag5 && !flag3) {
         renderer.field_147812_F = renderer.field_147819_N;
         renderer.field_147836_Z = renderer.field_147883_ah;
      } else {
         renderer.field_147812_F = block.func_149677_c(renderer.field_147845_a, x, y + 1, z - 1);
         renderer.field_147836_Z = block.func_149677_c(renderer.field_147845_a, x, y + 1, z - 1);
      }

      if (!flag4 && !flag3) {
         renderer.field_147821_H = renderer.field_147830_P;
         renderer.field_147881_ab = renderer.field_147868_aj;
      } else {
         renderer.field_147821_H = block.func_149677_c(renderer.field_147845_a, x, y + 1, z + 1);
         renderer.field_147881_ab = block.func_149677_c(renderer.field_147845_a, x, y + 1, z + 1);
      }

      i1 = l;
      if (renderer.field_147859_h <= 0.0 || !renderer.field_147845_a.func_147439_a(x - 1, y, z).func_149662_c()) {
         i1 = block.func_149677_c(renderer.field_147845_a, x - 1, y, z);
      }

      f7 = block.func_149677_c(renderer.field_147845_a, x - 1, y, z);
      f6 = (renderer.field_147886_y + renderer.field_147884_z + f7 + renderer.field_147830_P) / 4.0F;
      f3 = (f7 + renderer.field_147830_P + renderer.field_147813_G + renderer.field_147821_H) / 4.0F;
      f4 = (renderer.field_147819_N + f7 + renderer.field_147812_F + renderer.field_147813_G) / 4.0F;
      f5 = (renderer.field_147888_x + renderer.field_147886_y + renderer.field_147819_N + f7) / 4.0F;
      renderer.field_147870_ao = renderer.func_147778_a(renderer.field_147831_S, renderer.field_147826_T, renderer.field_147868_aj, i1);
      renderer.field_147864_al = renderer.func_147778_a(renderer.field_147868_aj, renderer.field_147880_aa, renderer.field_147881_ab, i1);
      renderer.field_147874_am = renderer.func_147778_a(renderer.field_147883_ah, renderer.field_147836_Z, renderer.field_147880_aa, i1);
      renderer.field_147876_an = renderer.func_147778_a(renderer.field_147832_R, renderer.field_147831_S, renderer.field_147883_ah, i1);
      renderer.field_147872_ap = renderer.field_147852_aq = renderer.field_147850_ar = renderer.field_147848_as = 0.6F;
      renderer.field_147846_at = renderer.field_147860_au = renderer.field_147858_av = renderer.field_147856_aw = 0.6F;
      renderer.field_147854_ax = renderer.field_147841_ay = renderer.field_147839_az = renderer.field_147833_aA = 0.6F;
      renderer.field_147872_ap *= f3;
      renderer.field_147846_at *= f3;
      renderer.field_147854_ax *= f3;
      renderer.field_147852_aq *= f4;
      renderer.field_147860_au *= f4;
      renderer.field_147841_ay *= f4;
      renderer.field_147850_ar *= f5;
      renderer.field_147858_av *= f5;
      renderer.field_147839_az *= f5;
      renderer.field_147848_as *= f6;
      renderer.field_147856_aw *= f6;
      renderer.field_147833_aA *= f6;
      renderer.func_147798_e(block, x - offset, y, z, icon);
      x--;
      renderer.field_147810_D = block.func_149677_c(renderer.field_147845_a, --x, y - 1, z);
      renderer.field_147820_O = block.func_149677_c(renderer.field_147845_a, x, y, z - 1);
      renderer.field_147829_Q = block.func_149677_c(renderer.field_147845_a, x, y, z + 1);
      renderer.field_147824_K = block.func_149677_c(renderer.field_147845_a, x, y + 1, z);
      renderer.field_147835_X = block.func_149677_c(renderer.field_147845_a, x, y - 1, z);
      renderer.field_147866_ai = block.func_149677_c(renderer.field_147845_a, x, y, z - 1);
      renderer.field_147862_ak = block.func_149677_c(renderer.field_147845_a, x, y, z + 1);
      renderer.field_147885_ae = block.func_149677_c(renderer.field_147845_a, x, y + 1, z);
      flag3 = renderer.field_147845_a.func_147439_a(x + 1, y + 1, z).func_149751_l();
      flag2 = renderer.field_147845_a.func_147439_a(x + 1, y - 1, z).func_149751_l();
      flag5 = renderer.field_147845_a.func_147439_a(x + 1, y, z + 1).func_149751_l();
      flag4 = renderer.field_147845_a.func_147439_a(x + 1, y, z - 1).func_149751_l();
      if (!flag2 && !flag4) {
         renderer.field_147816_C = renderer.field_147820_O;
         renderer.field_147827_W = renderer.field_147866_ai;
      } else {
         renderer.field_147816_C = block.func_149677_c(renderer.field_147845_a, x, y - 1, z - 1);
         renderer.field_147827_W = block.func_149677_c(renderer.field_147845_a, x, y - 1, z - 1);
      }

      if (!flag2 && !flag5) {
         renderer.field_147811_E = renderer.field_147829_Q;
         renderer.field_147834_Y = renderer.field_147862_ak;
      } else {
         renderer.field_147811_E = block.func_149677_c(renderer.field_147845_a, x, y - 1, z + 1);
         renderer.field_147834_Y = block.func_149677_c(renderer.field_147845_a, x, y - 1, z + 1);
      }

      if (!flag3 && !flag4) {
         renderer.field_147823_J = renderer.field_147820_O;
         renderer.field_147879_ad = renderer.field_147866_ai;
      } else {
         renderer.field_147823_J = block.func_149677_c(renderer.field_147845_a, x, y + 1, z - 1);
         renderer.field_147879_ad = block.func_149677_c(renderer.field_147845_a, x, y + 1, z - 1);
      }

      if (!flag3 && !flag5) {
         renderer.field_147818_M = renderer.field_147829_Q;
         renderer.field_147882_ag = renderer.field_147862_ak;
      } else {
         renderer.field_147818_M = block.func_149677_c(renderer.field_147845_a, x, y + 1, z + 1);
         renderer.field_147882_ag = block.func_149677_c(renderer.field_147845_a, x, y + 1, z + 1);
      }

      i1 = l;
      if (renderer.field_147861_i >= 1.0 || !renderer.field_147845_a.func_147439_a(x + 1, y, z).func_149662_c()) {
         i1 = block.func_149677_c(renderer.field_147845_a, x + 1, y, z);
      }

      f7 = block.func_149677_c(renderer.field_147845_a, x + 1, y, z);
      f3 = (renderer.field_147810_D + renderer.field_147811_E + f7 + renderer.field_147829_Q) / 4.0F;
      f4 = (renderer.field_147816_C + renderer.field_147810_D + renderer.field_147820_O + f7) / 4.0F;
      f5 = (renderer.field_147820_O + f7 + renderer.field_147823_J + renderer.field_147824_K) / 4.0F;
      f6 = (f7 + renderer.field_147829_Q + renderer.field_147824_K + renderer.field_147818_M) / 4.0F;
      renderer.field_147864_al = renderer.func_147778_a(renderer.field_147835_X, renderer.field_147834_Y, renderer.field_147862_ak, i1);
      renderer.field_147870_ao = renderer.func_147778_a(renderer.field_147862_ak, renderer.field_147885_ae, renderer.field_147882_ag, i1);
      renderer.field_147876_an = renderer.func_147778_a(renderer.field_147866_ai, renderer.field_147879_ad, renderer.field_147885_ae, i1);
      renderer.field_147874_am = renderer.func_147778_a(renderer.field_147827_W, renderer.field_147835_X, renderer.field_147866_ai, i1);
      renderer.field_147872_ap = renderer.field_147852_aq = renderer.field_147850_ar = renderer.field_147848_as = 0.6F;
      renderer.field_147846_at = renderer.field_147860_au = renderer.field_147858_av = renderer.field_147856_aw = 0.6F;
      renderer.field_147854_ax = renderer.field_147841_ay = renderer.field_147839_az = renderer.field_147833_aA = 0.6F;
      renderer.field_147872_ap *= f3;
      renderer.field_147846_at *= f3;
      renderer.field_147854_ax *= f3;
      renderer.field_147852_aq *= f4;
      renderer.field_147860_au *= f4;
      renderer.field_147841_ay *= f4;
      renderer.field_147850_ar *= f5;
      renderer.field_147858_av *= f5;
      renderer.field_147839_az *= f5;
      renderer.field_147848_as *= f6;
      renderer.field_147856_aw *= f6;
      renderer.field_147833_aA *= f6;
      renderer.func_147764_f(block, x + offset, y, z, icon);
      x++;
      renderer.field_147863_w = true;
      return true;
   }

   public int getRenderId() {
      return 485;
   }

   public boolean shouldRender3DInInventory(int modelId) {
      return true;
   }
}
