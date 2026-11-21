package assets.rivalrebels.common.block.trap;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsDamageSource;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.BlockFalling;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BlockTimedBomb extends BlockFalling {
   int ticksSincePlaced = 0;
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

   public int func_149745_a(Random par1Random) {
      return 0;
   }

   public void func_149723_a(World par1World, int par2, int par3, int par4, Explosion explosion) {
      par1World.func_147449_b(par2, par3, par4, Blocks.field_150350_a);
      new assets.rivalrebels.common.explosion.Explosion(
         par1World, par2 + 0.5F, par3 + 0.5F, par4 + 0.5F, RivalRebels.timedbombExplodeSize, false, true, RivalRebelsDamageSource.timebomb
      );
      RivalRebelsSoundPlayer.playSound(par1World, 26, 0, par2 + 0.5F, par3 + 0.5F, par4 + 0.5F, 2.0F, 0.3F);
   }

   public void func_149664_b(World world, int i, int j, int k, int l) {
      world.func_147449_b(i, j, k, Blocks.field_150350_a);
      new assets.rivalrebels.common.explosion.Explosion(
         world, i + 0.5F, j + 0.5F, k + 0.5F, RivalRebels.timedbombExplodeSize, false, true, RivalRebelsDamageSource.timebomb
      );
      RivalRebelsSoundPlayer.playSound(world, 26, 0, i + 0.5F, j + 0.5F, k + 0.5F, 2.0F, 0.3F);
   }

   public void func_149726_b(World par1World, int par2, int par3, int par4) {
      this.ticksSincePlaced = 0;
      par1World.func_147464_a(par2, par3, par4, this, 8);
   }

   public void func_149674_a(World par1World, int par2, int par3, int par4, Random par5Random) {
      par1World.func_147464_a(par2, par3, par4, this, 8);
      this.ticksSincePlaced++;
      if (this.ticksSincePlaced >= RivalRebels.timedbombTimer * 2.5) {
         par1World.func_147449_b(par2, par3, par4, Blocks.field_150350_a);
         new assets.rivalrebels.common.explosion.Explosion(
            par1World, par2 + 0.5F, par3 + 0.5F, par4 + 0.5F, RivalRebels.timedbombExplodeSize, false, true, RivalRebelsDamageSource.timebomb
         );
         RivalRebelsSoundPlayer.playSound(par1World, 26, 0, par2 + 0.5F, par3 + 0.5F, par4 + 0.5F, 2.0F, 0.3F);
      }

      if (this.ticksSincePlaced == 100) {
         this.ticksSincePlaced = 0;
      }

      if (par1World.func_147439_a(par2, par3 + 1, par4) == RivalRebels.light && this.ticksSincePlaced <= 93) {
         par1World.func_147449_b(par2, par3 + 1, par4, Blocks.field_150350_a);
         par1World.func_72908_a(par2 + 0.5, par3 + 0.5, par4 + 0.5, "random.click", 1.0F, 1.0F);
      } else if (this.ticksSincePlaced <= 93) {
         par1World.func_147449_b(par2, par3 + 1, par4, RivalRebels.light);
         par1World.func_72908_a(par2 + 0.5, par3 + 0.5, par4 + 0.5, "random.click", 1.0F, 0.7F);
      } else {
         par1World.func_72908_a(par2 + 0.5, par3 + 0.5, par4 + 0.5, "random.click", 2.0F, 2.0F);
      }
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
      this.icon1 = iconregister.func_94245_a("RivalRebels:ac");
      this.icon2 = iconregister.func_94245_a("RivalRebels:ae");
      this.icon3 = iconregister.func_94245_a("RivalRebels:ac");
      this.icon4 = iconregister.func_94245_a("RivalRebels:ac");
      this.icon5 = iconregister.func_94245_a("RivalRebels:ab");
      this.icon6 = iconregister.func_94245_a("RivalRebels:ab");
   }

   public void onFinishFalling(World par1World, int par2, int par3, int par4, int par5) {
      par1World.func_147449_b(par2, par3, par4, Blocks.field_150350_a);
      new assets.rivalrebels.common.explosion.Explosion(
         par1World, par2 + 0.5F, par3 + 0.5F, par4 + 0.5F, RivalRebels.timedbombExplodeSize, false, true, RivalRebelsDamageSource.timebomb
      );
      RivalRebelsSoundPlayer.playSound(par1World, 26, 0, par2 + 0.5F, par3 + 0.5F, par4 + 0.5F, 2.0F, 0.3F);
   }
}
