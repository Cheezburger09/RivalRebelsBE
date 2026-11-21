package assets.rivalrebels.common.block;

import assets.rivalrebels.RivalRebels;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockSmartCamo extends Block {
   @SideOnly(Side.CLIENT)
   IIcon icon;

   public BlockSmartCamo() {
      super(Material.field_151573_f);
   }

   public void func_149726_b(World world, int x, int y, int z) {
      if (world.func_147439_a(x + 1, y, z) == Blocks.field_150431_aC
         || world.func_147439_a(x - 1, y, z) == Blocks.field_150431_aC
         || world.func_147439_a(x, y, z - 1) == Blocks.field_150431_aC
         || world.func_147439_a(x, y, z + 1) == Blocks.field_150431_aC) {
         world.func_147449_b(x, y, z, RivalRebels.camo3);
      } else if (world.func_147439_a(x, y - 1, z) == Blocks.field_150349_c || world.func_147439_a(x, y - 1, z) == Blocks.field_150346_d) {
         world.func_147449_b(x, y, z, RivalRebels.camo1);
      } else if (world.func_147439_a(x, y - 1, z) == Blocks.field_150354_m || world.func_147439_a(x, y - 1, z) == Blocks.field_150322_A) {
         world.func_147449_b(x, y, z, RivalRebels.camo2);
      } else if (world.func_147439_a(x, y - 1, z) == Blocks.field_150348_b
         || world.func_147439_a(x, y - 1, z) == Blocks.field_150351_n
         || world.func_147439_a(x, y - 1, z) == Blocks.field_150357_h
         || world.func_147439_a(x, y - 1, z) == Blocks.field_150347_e) {
         world.func_147449_b(x, y, z, RivalRebels.camo3);
      } else if (world.func_147439_a(x, y - 1, z) == RivalRebels.camo2
         || world.func_147439_a(x + 1, y, z) == RivalRebels.camo2
         || world.func_147439_a(x - 1, y, z) == RivalRebels.camo2
         || world.func_147439_a(x, y, z + 1) == RivalRebels.camo2
         || world.func_147439_a(x, y, z - 1) == RivalRebels.camo2
         || world.func_147439_a(x, y + 1, z) == RivalRebels.camo2) {
         world.func_147449_b(x, y, z, RivalRebels.camo2);
      } else if (world.func_147439_a(x, y - 1, z) != RivalRebels.camo3
         && world.func_147439_a(x + 1, y, z) != RivalRebels.camo3
         && world.func_147439_a(x - 1, y, z) != RivalRebels.camo3
         && world.func_147439_a(x, y, z + 1) != RivalRebels.camo3
         && world.func_147439_a(x, y, z - 1) != RivalRebels.camo3
         && world.func_147439_a(x, y + 1, z) != RivalRebels.camo3) {
         world.func_147449_b(x, y, z, RivalRebels.camo1);
      } else {
         world.func_147449_b(x, y, z, RivalRebels.camo3);
      }
   }

   public final IIcon func_149691_a(int side, int meta) {
      return this.icon;
   }

   public void func_149651_a(IIconRegister iconregister) {
      this.icon = iconregister.func_94245_a("RivalRebels:bq");
   }
}
