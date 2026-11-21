package assets.rivalrebels.common.block.trap;

import assets.rivalrebels.common.core.RivalRebelsDamageSource;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockRadioactiveDirt extends Block {
   public BlockRadioactiveDirt() {
      super(Material.field_151578_c);
   }

   public void func_149724_b(World world, int par2, int par3, int par4, Entity entity) {
      if (world.field_73012_v.nextInt(2) == 0) {
         entity.func_70097_a(RivalRebelsDamageSource.radioactivepoisoning, world.field_73012_v.nextInt(2));
      }
   }

   public void func_149734_b(World world, int x, int y, int z, Random random) {
      world.func_72869_a("reddust", x + random.nextFloat(), y + 1.1 + random.nextFloat() * 0.1, z + random.nextFloat(), 0.3F, 6.0, 0.5);
   }

   public int func_149745_a(Random random) {
      return 1;
   }

   public final IIcon func_149691_a(int side, int meta) {
      return Blocks.field_150346_d.func_149691_a(side, meta);
   }

   public void func_149651_a(IIconRegister iconregister) {
   }
}
