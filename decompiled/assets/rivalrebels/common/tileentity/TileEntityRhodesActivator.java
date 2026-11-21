package assets.rivalrebels.common.tileentity;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.block.autobuilds.BlockRhodesScaffold;
import assets.rivalrebels.common.entity.EntityRhodes;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class TileEntityRhodesActivator extends TileEntityMachineBase {
   int charge = 0;

   public TileEntityRhodesActivator() {
      this.pInM = 40.0F;
      this.pInR = 20.0F;
   }

   @Override
   public float powered(float power, float distance) {
      if (this.field_145850_b.field_72995_K) {
         return power;
      }

      if (this.charge != 100) {
         this.charge++;
         return 0.0F;
      }

      boolean buildrhodes = true;
      boolean buildrhodes1 = true;
      boolean buildrhodes2 = true;
      int x = this.field_145851_c;
      int y = this.field_145848_d;
      int z = this.field_145849_e;
      int i = 0;

      while (i < 279) {
         byte b = BlockRhodesScaffold.binimg[i];
         int fy = 2 - i / 9;
         int fx1 = -10 + i % 9;
         int fx2 = 7 - i % 9;
         Block s1 = this.field_145850_b.func_147439_a(x + fx1, y + fy, z);
         Block s2 = this.field_145850_b.func_147439_a(x + fx2, y + fy, z);
         if (b != 1 || s1 == RivalRebels.conduit && s2 == RivalRebels.conduit) {
            if (b != 2 || s1 == RivalRebels.rhodesactivator && s2 == RivalRebels.rhodesactivator) {
               i++;
               continue;
            }

            buildrhodes = false;
            break;
         }

         buildrhodes = false;
         break;
      }

      if (!buildrhodes) {
         i = 0;

         while (i < 279) {
            byte b = BlockRhodesScaffold.binimg[i];
            int fy = 2 - i / 9;
            int fx1 = -10 + i % 9;
            int fx2 = 7 - i % 9;
            fy *= 2;
            fx1 *= 2;
            fx2 *= 2;
            Block s1 = this.field_145850_b.func_147439_a(x + fx1, y + fy, z);
            Block s2 = this.field_145850_b.func_147439_a(x + fx2, y + fy, z);
            if (b != 1 || s1 == RivalRebels.conduit && s2 == RivalRebels.conduit) {
               if (b != 2 || s1 == RivalRebels.rhodesactivator && s2 == RivalRebels.rhodesactivator) {
                  i++;
                  continue;
               }

               buildrhodes1 = false;
               break;
            }

            buildrhodes1 = false;
            break;
         }
      }

      if (!buildrhodes && !buildrhodes1) {
         i = 0;

         while (i < 279) {
            byte b = BlockRhodesScaffold.binimg[i];
            int fy = 2 - i / 9;
            int fx1 = -10 + i % 9;
            int fx2 = 7 - i % 9;
            fy *= 3;
            fx1 *= 3;
            fx2 *= 3;
            Block s1 = this.field_145850_b.func_147439_a(x + fx1, y + fy, z);
            Block s2 = this.field_145850_b.func_147439_a(x + fx2, y + fy, z);
            if (b != 1 || s1 == RivalRebels.conduit && s2 == RivalRebels.conduit) {
               if (b != 2 || s1 == RivalRebels.rhodesactivator && s2 == RivalRebels.rhodesactivator) {
                  i++;
                  continue;
               }

               buildrhodes2 = false;
               break;
            }

            buildrhodes2 = false;
            break;
         }
      }

      if (buildrhodes) {
         for (int ix = 0; ix < 279; ix++) {
            byte b = BlockRhodesScaffold.binimg[ix];
            if (b == 1) {
               int fy = 2 - ix / 9;
               int fx1 = -10 + ix % 9;
               int fx2 = 7 - ix % 9;
               this.field_145850_b.func_147449_b(x + fx1, y + fy, z, Blocks.field_150350_a);
               this.field_145850_b.func_147449_b(x + fx2, y + fy, z, Blocks.field_150350_a);
            }
         }

         EntityRhodes er = new EntityRhodes(this.field_145850_b, x - 1.0F, y - 13, z, 1.0F);
         if (this.field_145849_e > this.z) {
            er.bodyyaw = 180.0F;
         }

         this.field_145850_b.func_72838_d(er);
      } else if (buildrhodes1) {
         for (int ix = 0; ix < 279; ix++) {
            byte b = BlockRhodesScaffold.binimg[ix];
            if (b == 1) {
               int fy = 2 - ix / 9;
               int fx1 = -10 + ix % 9;
               int fx2 = 7 - ix % 9;
               fy *= 2;
               fx1 *= 2;
               fx2 *= 2;
               this.field_145850_b.func_147449_b(x + fx1, y + fy, z, Blocks.field_150350_a);
               this.field_145850_b.func_147449_b(x + fx2, y + fy, z, Blocks.field_150350_a);
               this.field_145850_b.func_147449_b(x + fx1 + 1, y + fy, z, Blocks.field_150350_a);
               this.field_145850_b.func_147449_b(x + fx2 + 1, y + fy, z, Blocks.field_150350_a);
               this.field_145850_b.func_147449_b(x + fx1, y + fy + 1, z, Blocks.field_150350_a);
               this.field_145850_b.func_147449_b(x + fx2, y + fy + 1, z, Blocks.field_150350_a);
               this.field_145850_b.func_147449_b(x + fx1 + 1, y + fy + 1, z, Blocks.field_150350_a);
               this.field_145850_b.func_147449_b(x + fx2 + 1, y + fy + 1, z, Blocks.field_150350_a);
            }
         }

         EntityRhodes er = new EntityRhodes(this.field_145850_b, x - 2.0F, y - 26, z, 2.0F);
         if (this.field_145849_e > this.z) {
            er.bodyyaw = 180.0F;
         }

         this.field_145850_b.func_72838_d(er);
      } else if (buildrhodes2) {
         for (int ix = 0; ix < 279; ix++) {
            byte b = BlockRhodesScaffold.binimg[ix];
            if (b == 1) {
               int fy = 2 - ix / 9;
               int fx1 = -10 + ix % 9;
               int fx2 = 7 - ix % 9;
               fy *= 3;
               fx1 *= 3;
               fx2 *= 3;
               this.field_145850_b.func_147449_b(x + fx1, y + fy, z, Blocks.field_150350_a);
               this.field_145850_b.func_147449_b(x + fx2, y + fy, z, Blocks.field_150350_a);
               this.field_145850_b.func_147449_b(x + fx1 + 1, y + fy, z, Blocks.field_150350_a);
               this.field_145850_b.func_147449_b(x + fx2 + 1, y + fy, z, Blocks.field_150350_a);
               this.field_145850_b.func_147449_b(x + fx1 + 2, y + fy, z, Blocks.field_150350_a);
               this.field_145850_b.func_147449_b(x + fx2 + 2, y + fy, z, Blocks.field_150350_a);
               this.field_145850_b.func_147449_b(x + fx1, y + fy + 1, z, Blocks.field_150350_a);
               this.field_145850_b.func_147449_b(x + fx2, y + fy + 1, z, Blocks.field_150350_a);
               this.field_145850_b.func_147449_b(x + fx1 + 1, y + fy + 1, z, Blocks.field_150350_a);
               this.field_145850_b.func_147449_b(x + fx2 + 1, y + fy + 1, z, Blocks.field_150350_a);
               this.field_145850_b.func_147449_b(x + fx1 + 2, y + fy + 1, z, Blocks.field_150350_a);
               this.field_145850_b.func_147449_b(x + fx2 + 2, y + fy + 1, z, Blocks.field_150350_a);
               this.field_145850_b.func_147449_b(x + fx1, y + fy + 2, z, Blocks.field_150350_a);
               this.field_145850_b.func_147449_b(x + fx2, y + fy + 2, z, Blocks.field_150350_a);
               this.field_145850_b.func_147449_b(x + fx1 + 1, y + fy + 2, z, Blocks.field_150350_a);
               this.field_145850_b.func_147449_b(x + fx2 + 1, y + fy + 2, z, Blocks.field_150350_a);
               this.field_145850_b.func_147449_b(x + fx1 + 2, y + fy + 2, z, Blocks.field_150350_a);
               this.field_145850_b.func_147449_b(x + fx2 + 2, y + fy + 2, z, Blocks.field_150350_a);
            }
         }

         EntityRhodes er = new EntityRhodes(this.field_145850_b, x - 3.0F, y - 39, z, 3.0F);
         if (this.field_145849_e > this.z) {
            er.bodyyaw = 180.0F;
         }

         this.field_145850_b.func_72838_d(er);
      } else if (this.field_145850_b.func_147439_a(x, y + 1, z) == RivalRebels.conduit
         && this.field_145850_b.func_147439_a(x - 1, y, z) == RivalRebels.steel
         && this.field_145850_b.func_147439_a(x + 1, y, z) == RivalRebels.steel
         && this.field_145850_b.func_147439_a(x - 1, y + 1, z) == RivalRebels.steel
         && this.field_145850_b.func_147439_a(x + 1, y + 1, z) == RivalRebels.steel
         && this.field_145850_b.func_147439_a(x - 1, y + 3, z) == RivalRebels.steel
         && this.field_145850_b.func_147439_a(x + 1, y + 3, z) == RivalRebels.steel
         && this.field_145850_b.func_147439_a(x, y + 3, z) == RivalRebels.steel
         && this.field_145850_b.func_147439_a(x, y + 2, z) == RivalRebels.conduit
         && this.field_145850_b.func_147439_a(x - 1, y + 2, z) == RivalRebels.steel
         && this.field_145850_b.func_147439_a(x + 1, y + 2, z) == RivalRebels.steel) {
         this.field_145850_b.func_147449_b(x, y + 1, z, Blocks.field_150350_a);
         this.field_145850_b.func_147449_b(x, y + 2, z, Blocks.field_150350_a);
         this.field_145850_b.func_147449_b(x, y + 3, z, Blocks.field_150350_a);
         EntityRhodes er = new EntityRhodes(this.field_145850_b, x + 0.5F, y + 2.5F, z + 0.5F, 0.06666667F);
         er.wakeX = x;
         er.wakeY = y;
         er.wakeZ = z;
         if (this.field_145849_e > this.z) {
            er.bodyyaw = 180.0F;
         }

         this.field_145850_b.func_72838_d(er);
      } else if (this.field_145850_b.func_147439_a(x, y + 1, z) == RivalRebels.conduit
         && this.field_145850_b.func_147439_a(x - 1, y, z) == RivalRebels.steel
         && this.field_145850_b.func_147439_a(x + 1, y, z) == RivalRebels.steel
         && this.field_145850_b.func_147439_a(x - 1, y + 1, z) == RivalRebels.steel
         && this.field_145850_b.func_147439_a(x + 1, y + 1, z) == RivalRebels.steel
         && this.field_145850_b.func_147439_a(x - 1, y + 2, z) == RivalRebels.steel
         && this.field_145850_b.func_147439_a(x + 1, y + 2, z) == RivalRebels.steel
         && this.field_145850_b.func_147439_a(x, y + 2, z) == RivalRebels.steel) {
         this.field_145850_b.func_147449_b(x, y + 1, z, Blocks.field_150350_a);
         this.field_145850_b.func_147449_b(x, y + 2, z, Blocks.field_150350_a);
         EntityRhodes er = new EntityRhodes(this.field_145850_b, x + 0.5F, y + 1.5F, z + 0.5F, 0.033333335F);
         er.wakeX = x;
         er.wakeY = y;
         er.wakeZ = z;
         if (this.field_145849_e > this.z) {
            er.bodyyaw = 180.0F;
         }

         this.field_145850_b.func_72838_d(er);
      }

      return power * 0.5F;
   }
}
