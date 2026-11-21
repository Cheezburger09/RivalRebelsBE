package assets.rivalrebels.common.block.autobuilds;

import assets.rivalrebels.common.core.BlackList;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class BlockAutoTemplate extends BlockFalling {
   public int time = 15;
   public String name = "building";

   public void func_149699_a(World world, int x, int y, int z, EntityPlayer player) {
      if (!world.field_72995_K) {
         player.func_145747_a(new ChatComponentText("§4[§cWarning§4]§c Use pliers to build."));
      }
   }

   public void build(World world, int x, int y, int z) {
      RivalRebelsSoundPlayer.playSound(world, 1, 0, x, y, z, 10.0F, 1.0F);
   }

   public void placeBlockCarefully(World world, int i, int j, int z, Block block) {
      if (!BlackList.autobuild(world.func_147439_a(i, j, z))) {
         world.func_147449_b(i, j, z, block);
      }
   }

   public void placeBlockCarefully(World world, int i, int j, int z, Block block, int m, int f) {
      if (!BlackList.autobuild(world.func_147439_a(i, j, z))) {
         world.func_147465_d(i, j, z, block, m, f);
      }
   }

   public void func_149828_a(World world, int x, int y, int z, int par5) {
      if (!world.field_72995_K) {
         this.build(world, x, y, z);
      }
   }
}
