package assets.rivalrebels.common.block;

import assets.rivalrebels.RivalRebels;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockForceShield extends Block {
   boolean Destroy = false;
   @SideOnly(Side.CLIENT)
   IIcon icon1;
   IIcon icon2;

   public BlockForceShield() {
      super(Material.field_151573_f);
   }

   public int func_149745_a(Random par1Random) {
      return 0;
   }

   public void func_149749_a(World world, int i, int j, int k, Block l, int s) {
      Block id = world.func_147439_a(i, j, k);
      if (!this.Destroy && id != RivalRebels.fshield && id != RivalRebels.omegaobj && id != RivalRebels.sigmaobj && id != RivalRebels.reactive) {
         world.func_147449_b(i, j, k, this);
      }

      this.Destroy = false;
   }

   public void func_149681_a(World world, int x, int y, int z, int m, EntityPlayer player) {
      if (!world.field_72995_K && player.field_71075_bZ.field_75098_d && player.func_70093_af()) {
         this.Destroy = true;
         world.func_147449_b(x, y, z, Blocks.field_150350_a);
      } else {
         this.Destroy = false;
         world.func_147449_b(x, y, z, this);
      }
   }

   public boolean func_149662_c() {
      return false;
   }

   public int func_149656_h() {
      return 2;
   }

   public final IIcon func_149691_a(int side, int meta) {
      return side != 0 && side != 1 ? this.icon1 : this.icon2;
   }

   public void func_149651_a(IIconRegister iconregister) {
      this.icon1 = iconregister.func_94245_a("RivalRebels:ao");
      this.icon2 = iconregister.func_94245_a("RivalRebels:ap");
   }
}
