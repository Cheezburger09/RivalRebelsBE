package assets.rivalrebels.common.block.crate;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.packet.PacketDispatcher;
import assets.rivalrebels.common.packet.TextPacket;
import assets.rivalrebels.common.tileentity.TileEntityNukeCrate;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockNukeCrate extends BlockContainer {
   @SideOnly(Side.CLIENT)
   IIcon icon;

   public BlockNukeCrate() {
      super(Material.field_151575_d);
   }

   public int determineOrientation(World world, int x, int y, int z, EntityPlayer entity) {
      int orientation = 0;
      if (this == RivalRebels.nukeCrateTop) {
         if (world.func_147439_a(x, y + 1, z) == RivalRebels.nukeCrateBottom) {
            orientation = 0;
         } else if (world.func_147439_a(x, y - 1, z) == RivalRebels.nukeCrateBottom) {
            orientation = 1;
         } else if (world.func_147439_a(x, y, z + 1) == RivalRebels.nukeCrateBottom) {
            orientation = 2;
         } else if (world.func_147439_a(x, y, z - 1) == RivalRebels.nukeCrateBottom) {
            orientation = 3;
         } else if (world.func_147439_a(x + 1, y, z) == RivalRebels.nukeCrateBottom) {
            orientation = 4;
         } else if (world.func_147439_a(x - 1, y, z) == RivalRebels.nukeCrateBottom) {
            orientation = 5;
         }
      }

      if (this == RivalRebels.nukeCrateBottom) {
         if (world.func_147439_a(x, y + 1, z) == RivalRebels.nukeCrateTop) {
            orientation = 1;
         } else if (world.func_147439_a(x, y - 1, z) == RivalRebels.nukeCrateTop) {
            orientation = 0;
         } else if (world.func_147439_a(x, y, z + 1) == RivalRebels.nukeCrateTop) {
            orientation = 3;
         } else if (world.func_147439_a(x, y, z - 1) == RivalRebels.nukeCrateTop) {
            orientation = 2;
         } else if (world.func_147439_a(x + 1, y, z) == RivalRebels.nukeCrateTop) {
            orientation = 5;
         } else if (world.func_147439_a(x - 1, y, z) == RivalRebels.nukeCrateTop) {
            orientation = 4;
         }
      }

      return orientation;
   }

   public void func_149695_a(World world, int x, int y, int z, Block par5) {
      world.func_72921_c(x, y, z, this.determineOrientation(world, x, y, z, null), 0);
   }

   public void func_149726_b(World world, int x, int y, int z) {
      world.func_72921_c(x, y, z, this.determineOrientation(world, x, y, z, null), 0);
      if (world.func_147439_a(x, y + 1, z) == RivalRebels.nukeCrateBottom) {
         this.func_149695_a(world, x, y + 1, z, this);
      } else if (world.func_147439_a(x, y - 1, z) == RivalRebels.nukeCrateBottom) {
         this.func_149695_a(world, x, y - 1, z, this);
      } else if (world.func_147439_a(x, y, z + 1) == RivalRebels.nukeCrateBottom) {
         this.func_149695_a(world, x, y, z + 1, this);
      } else if (world.func_147439_a(x, y, z - 1) == RivalRebels.nukeCrateBottom) {
         this.func_149695_a(world, x, y, z - 1, this);
      } else if (world.func_147439_a(x + 1, y, z) == RivalRebels.nukeCrateBottom) {
         this.func_149695_a(world, x + 1, y, z, this);
      } else if (world.func_147439_a(x - 1, y, z) == RivalRebels.nukeCrateBottom) {
         this.func_149695_a(world, x - 1, y, z, this);
      } else if (world.func_147439_a(x, y + 1, z) == Blocks.field_150353_l) {
         world.func_147449_b(x, y, z, Blocks.field_150350_a);
         world.func_72876_a(null, x, y, z, 3.0F, false);
      } else if (world.func_147439_a(x, y - 1, z) == Blocks.field_150353_l) {
         world.func_147449_b(x, y, z, Blocks.field_150350_a);
         world.func_72876_a(null, x, y, z, 3.0F, false);
      } else if (world.func_147439_a(x, y, z + 1) == Blocks.field_150353_l) {
         world.func_147449_b(x, y, z, Blocks.field_150350_a);
         world.func_72876_a(null, x, y, z, 3.0F, false);
      } else if (world.func_147439_a(x, y, z - 1) == Blocks.field_150353_l) {
         world.func_147449_b(x, y, z, Blocks.field_150350_a);
         world.func_72876_a(null, x, y, z, 3.0F, false);
      } else if (world.func_147439_a(x + 1, y, z) == Blocks.field_150353_l) {
         world.func_147449_b(x, y, z, Blocks.field_150350_a);
         world.func_72876_a(null, x, y, z, 3.0F, false);
      } else if (world.func_147439_a(x - 1, y, z) == Blocks.field_150353_l) {
         world.func_147449_b(x, y, z, Blocks.field_150350_a);
         world.func_72876_a(null, x, y, z, 3.0F, false);
      }
   }

   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
      if (this == RivalRebels.nukeCrateTop) {
         if (par5EntityPlayer.field_71071_by.func_70448_g() != null) {
            if (par5EntityPlayer.field_71071_by.func_70448_g().func_77973_b() == RivalRebels.pliers) {
               if (world.func_147439_a(x + 1, y, z) == RivalRebels.nukeCrateBottom
                  && world.func_147439_a(x, y - 1, z) == RivalRebels.nukeCrateTop
                  && world.func_147439_a(x + 1, y - 1, z) == RivalRebels.nukeCrateBottom) {
                  world.func_147449_b(x, y, z, Blocks.field_150350_a);
                  world.func_147449_b(x + 1, y, z, Blocks.field_150350_a);
                  world.func_147449_b(x, y - 1, z, Blocks.field_150350_a);
                  world.func_147449_b(x + 1, y - 1, z, RivalRebels.antimatterbombblock);
                  world.func_72921_c(x + 1, y - 1, z, 4, 1);
                  return true;
               }

               if (world.func_147439_a(x - 1, y, z) == RivalRebels.nukeCrateBottom
                  && world.func_147439_a(x, y - 1, z) == RivalRebels.nukeCrateTop
                  && world.func_147439_a(x - 1, y - 1, z) == RivalRebels.nukeCrateBottom) {
                  world.func_147449_b(x, y, z, Blocks.field_150350_a);
                  world.func_147449_b(x - 1, y, z, Blocks.field_150350_a);
                  world.func_147449_b(x, y - 1, z, Blocks.field_150350_a);
                  world.func_147449_b(x - 1, y - 1, z, RivalRebels.antimatterbombblock);
                  world.func_72921_c(x - 1, y - 1, z, 5, 1);
                  return true;
               }

               if (world.func_147439_a(x, y, z + 1) == RivalRebels.nukeCrateBottom
                  && world.func_147439_a(x, y - 1, z) == RivalRebels.nukeCrateTop
                  && world.func_147439_a(x, y - 1, z + 1) == RivalRebels.nukeCrateBottom) {
                  world.func_147449_b(x, y, z, Blocks.field_150350_a);
                  world.func_147449_b(x, y, z + 1, Blocks.field_150350_a);
                  world.func_147449_b(x, y - 1, z, Blocks.field_150350_a);
                  world.func_147449_b(x, y - 1, z + 1, RivalRebels.antimatterbombblock);
                  world.func_72921_c(x, y - 1, z + 1, 2, 1);
                  return true;
               }

               if (world.func_147439_a(x, y, z - 1) == RivalRebels.nukeCrateBottom
                  && world.func_147439_a(x, y - 1, z) == RivalRebels.nukeCrateTop
                  && world.func_147439_a(x, y - 1, z - 1) == RivalRebels.nukeCrateBottom) {
                  world.func_147449_b(x, y, z, Blocks.field_150350_a);
                  world.func_147449_b(x, y, z - 1, Blocks.field_150350_a);
                  world.func_147449_b(x, y - 1, z, Blocks.field_150350_a);
                  world.func_147449_b(x, y - 1, z - 1, RivalRebels.antimatterbombblock);
                  world.func_72921_c(x, y - 1, z - 1, 3, 1);
                  return true;
               }

               if (world.func_147439_a(x + 1, y, z) == RivalRebels.nukeCrateBottom
                  && world.func_147439_a(x, y + 1, z) == RivalRebels.nukeCrateTop
                  && world.func_147439_a(x + 1, y + 1, z) == RivalRebels.nukeCrateBottom) {
                  world.func_147449_b(x, y + 1, z, Blocks.field_150350_a);
                  world.func_147449_b(x + 1, y + 1, z, Blocks.field_150350_a);
                  world.func_147449_b(x, y, z, Blocks.field_150350_a);
                  world.func_147449_b(x + 1, y, z, RivalRebels.tachyonbombblock);
                  world.func_72921_c(x + 1, y, z, 4, 1);
                  return true;
               }

               if (world.func_147439_a(x - 1, y, z) == RivalRebels.nukeCrateBottom
                  && world.func_147439_a(x, y + 1, z) == RivalRebels.nukeCrateTop
                  && world.func_147439_a(x - 1, y + 1, z) == RivalRebels.nukeCrateBottom) {
                  world.func_147449_b(x, y + 1, z, Blocks.field_150350_a);
                  world.func_147449_b(x - 1, y + 1, z, Blocks.field_150350_a);
                  world.func_147449_b(x, y, z, Blocks.field_150350_a);
                  world.func_147449_b(x - 1, y, z, RivalRebels.tachyonbombblock);
                  world.func_72921_c(x - 1, y, z, 5, 1);
                  return true;
               }

               if (world.func_147439_a(x, y, z + 1) == RivalRebels.nukeCrateBottom
                  && world.func_147439_a(x, y + 1, z) == RivalRebels.nukeCrateTop
                  && world.func_147439_a(x, y + 1, z + 1) == RivalRebels.nukeCrateBottom) {
                  world.func_147449_b(x, y + 1, z, Blocks.field_150350_a);
                  world.func_147449_b(x, y + 1, z + 1, Blocks.field_150350_a);
                  world.func_147449_b(x, y, z, Blocks.field_150350_a);
                  world.func_147449_b(x, y, z + 1, RivalRebels.tachyonbombblock);
                  world.func_72921_c(x, y, z + 1, 2, 1);
                  return true;
               }

               if (world.func_147439_a(x, y, z - 1) == RivalRebels.nukeCrateBottom
                  && world.func_147439_a(x, y + 1, z) == RivalRebels.nukeCrateTop
                  && world.func_147439_a(x, y + 1, z - 1) == RivalRebels.nukeCrateBottom) {
                  world.func_147449_b(x, y + 1, z, Blocks.field_150350_a);
                  world.func_147449_b(x, y + 1, z - 1, Blocks.field_150350_a);
                  world.func_147449_b(x, y, z, Blocks.field_150350_a);
                  world.func_147449_b(x, y, z - 1, RivalRebels.tachyonbombblock);
                  world.func_72921_c(x, y, z - 1, 3, 1);
                  return true;
               }

               if (world.func_147439_a(x + 1, y, z) == RivalRebels.nukeCrateTop
                  && world.func_147439_a(x + 2, y, z) == RivalRebels.nukeCrateBottom
                  && world.func_147439_a(x + 3, y, z) == RivalRebels.nukeCrateBottom
                  && world.func_147439_a(x, y - 1, z) == RivalRebels.nukeCrateTop
                  && world.func_147439_a(x + 1, y - 1, z) == RivalRebels.nukeCrateTop
                  && world.func_147439_a(x + 2, y - 1, z) == RivalRebels.nukeCrateBottom
                  && world.func_147439_a(x + 3, y - 1, z) == RivalRebels.nukeCrateBottom) {
                  world.func_147449_b(x, y, z, Blocks.field_150350_a);
                  world.func_147449_b(x + 1, y, z, Blocks.field_150350_a);
                  world.func_147449_b(x + 2, y, z, Blocks.field_150350_a);
                  world.func_147449_b(x + 3, y, z, Blocks.field_150350_a);
                  world.func_147449_b(x, y - 1, z, Blocks.field_150350_a);
                  world.func_147449_b(x + 1, y - 1, z, RivalRebels.tsarbombablock);
                  world.func_72921_c(x + 1, y - 1, z, 4, 1);
                  world.func_147449_b(x + 2, y - 1, z, Blocks.field_150350_a);
                  world.func_147449_b(x + 3, y - 1, z, Blocks.field_150350_a);
                  return true;
               }

               if (world.func_147439_a(x - 1, y, z) == RivalRebels.nukeCrateTop
                  && world.func_147439_a(x - 2, y, z) == RivalRebels.nukeCrateBottom
                  && world.func_147439_a(x - 3, y, z) == RivalRebels.nukeCrateBottom
                  && world.func_147439_a(x, y - 1, z) == RivalRebels.nukeCrateTop
                  && world.func_147439_a(x - 1, y - 1, z) == RivalRebels.nukeCrateTop
                  && world.func_147439_a(x - 2, y - 1, z) == RivalRebels.nukeCrateBottom
                  && world.func_147439_a(x - 3, y - 1, z) == RivalRebels.nukeCrateBottom) {
                  world.func_147449_b(x, y, z, Blocks.field_150350_a);
                  world.func_147449_b(x - 1, y, z, Blocks.field_150350_a);
                  world.func_147449_b(x - 2, y, z, Blocks.field_150350_a);
                  world.func_147449_b(x - 3, y, z, Blocks.field_150350_a);
                  world.func_147449_b(x, y - 1, z, Blocks.field_150350_a);
                  world.func_147449_b(x - 1, y - 1, z, RivalRebels.tsarbombablock);
                  world.func_72921_c(x - 1, y - 1, z, 5, 1);
                  world.func_147449_b(x - 2, y - 1, z, Blocks.field_150350_a);
                  world.func_147449_b(x - 3, y - 1, z, Blocks.field_150350_a);
                  return true;
               }

               if (world.func_147439_a(x, y, z + 1) == RivalRebels.nukeCrateTop
                  && world.func_147439_a(x, y, z + 2) == RivalRebels.nukeCrateBottom
                  && world.func_147439_a(x, y, z + 3) == RivalRebels.nukeCrateBottom
                  && world.func_147439_a(x, y - 1, z) == RivalRebels.nukeCrateTop
                  && world.func_147439_a(x, y - 1, z + 1) == RivalRebels.nukeCrateTop
                  && world.func_147439_a(x, y - 1, z + 2) == RivalRebels.nukeCrateBottom
                  && world.func_147439_a(x, y - 1, z + 3) == RivalRebels.nukeCrateBottom) {
                  world.func_147449_b(x, y, z, Blocks.field_150350_a);
                  world.func_147449_b(x, y, z + 1, Blocks.field_150350_a);
                  world.func_147449_b(x, y, z + 2, Blocks.field_150350_a);
                  world.func_147449_b(x, y, z + 3, Blocks.field_150350_a);
                  world.func_147449_b(x, y - 1, z, Blocks.field_150350_a);
                  world.func_147449_b(x, y - 1, z + 1, RivalRebels.tsarbombablock);
                  world.func_72921_c(x, y - 1, z + 1, 2, 1);
                  world.func_147449_b(x, y - 1, z + 2, Blocks.field_150350_a);
                  world.func_147449_b(x, y - 1, z + 3, Blocks.field_150350_a);
                  return true;
               }

               if (world.func_147439_a(x, y, z - 1) == RivalRebels.nukeCrateTop
                  && world.func_147439_a(x, y, z - 2) == RivalRebels.nukeCrateBottom
                  && world.func_147439_a(x, y, z - 3) == RivalRebels.nukeCrateBottom
                  && world.func_147439_a(x, y - 1, z) == RivalRebels.nukeCrateTop
                  && world.func_147439_a(x, y - 1, z - 1) == RivalRebels.nukeCrateTop
                  && world.func_147439_a(x, y - 1, z - 2) == RivalRebels.nukeCrateBottom
                  && world.func_147439_a(x, y - 1, z - 3) == RivalRebels.nukeCrateBottom) {
                  world.func_147449_b(x, y, z, Blocks.field_150350_a);
                  world.func_147449_b(x, y, z - 1, Blocks.field_150350_a);
                  world.func_147449_b(x, y, z - 2, Blocks.field_150350_a);
                  world.func_147449_b(x, y, z - 3, Blocks.field_150350_a);
                  world.func_147449_b(x, y - 1, z, Blocks.field_150350_a);
                  world.func_147449_b(x, y - 1, z - 1, RivalRebels.tsarbombablock);
                  world.func_72921_c(x, y - 1, z - 1, 3, 1);
                  world.func_147449_b(x, y - 1, z - 2, Blocks.field_150350_a);
                  world.func_147449_b(x, y - 1, z - 3, Blocks.field_150350_a);
                  return true;
               }

               if (world.func_147439_a(x + 1, y, z) == RivalRebels.nukeCrateTop
                  && world.func_147439_a(x + 2, y, z) == RivalRebels.nukeCrateBottom
                  && world.func_147439_a(x + 3, y, z) == RivalRebels.nukeCrateBottom
                  && world.func_147439_a(x, y + 1, z) == RivalRebels.nukeCrateTop
                  && world.func_147439_a(x + 1, y + 1, z) == RivalRebels.nukeCrateTop
                  && world.func_147439_a(x + 2, y + 1, z) == RivalRebels.nukeCrateBottom
                  && world.func_147439_a(x + 3, y + 1, z) == RivalRebels.nukeCrateBottom) {
                  world.func_147449_b(x, y, z, Blocks.field_150350_a);
                  world.func_147449_b(x + 1, y + 1, z, Blocks.field_150350_a);
                  world.func_147449_b(x + 2, y, z, Blocks.field_150350_a);
                  world.func_147449_b(x + 3, y, z, Blocks.field_150350_a);
                  world.func_147449_b(x, y + 1, z, Blocks.field_150350_a);
                  world.func_147449_b(x + 1, y, z, RivalRebels.theoreticaltsarbombablock);
                  world.func_72921_c(x + 1, y, z, 4, 1);
                  world.func_147449_b(x + 2, y + 1, z, Blocks.field_150350_a);
                  world.func_147449_b(x + 3, y + 1, z, Blocks.field_150350_a);
                  return true;
               }

               if (world.func_147439_a(x - 1, y, z) == RivalRebels.nukeCrateTop
                  && world.func_147439_a(x - 2, y, z) == RivalRebels.nukeCrateBottom
                  && world.func_147439_a(x - 3, y, z) == RivalRebels.nukeCrateBottom
                  && world.func_147439_a(x, y + 1, z) == RivalRebels.nukeCrateTop
                  && world.func_147439_a(x - 1, y + 1, z) == RivalRebels.nukeCrateTop
                  && world.func_147439_a(x - 2, y + 1, z) == RivalRebels.nukeCrateBottom
                  && world.func_147439_a(x - 3, y + 1, z) == RivalRebels.nukeCrateBottom) {
                  world.func_147449_b(x, y, z, Blocks.field_150350_a);
                  world.func_147449_b(x - 1, y + 1, z, Blocks.field_150350_a);
                  world.func_147449_b(x - 2, y, z, Blocks.field_150350_a);
                  world.func_147449_b(x - 3, y, z, Blocks.field_150350_a);
                  world.func_147449_b(x, y + 1, z, Blocks.field_150350_a);
                  world.func_147449_b(x - 1, y, z, RivalRebels.theoreticaltsarbombablock);
                  world.func_72921_c(x - 1, y, z, 5, 1);
                  world.func_147449_b(x - 2, y + 1, z, Blocks.field_150350_a);
                  world.func_147449_b(x - 3, y + 1, z, Blocks.field_150350_a);
                  return true;
               }

               if (world.func_147439_a(x, y, z + 1) == RivalRebels.nukeCrateTop
                  && world.func_147439_a(x, y, z + 2) == RivalRebels.nukeCrateBottom
                  && world.func_147439_a(x, y, z + 3) == RivalRebels.nukeCrateBottom
                  && world.func_147439_a(x, y + 1, z) == RivalRebels.nukeCrateTop
                  && world.func_147439_a(x, y + 1, z + 1) == RivalRebels.nukeCrateTop
                  && world.func_147439_a(x, y + 1, z + 2) == RivalRebels.nukeCrateBottom
                  && world.func_147439_a(x, y + 1, z + 3) == RivalRebels.nukeCrateBottom) {
                  world.func_147449_b(x, y, z, Blocks.field_150350_a);
                  world.func_147449_b(x, y + 1, z + 1, Blocks.field_150350_a);
                  world.func_147449_b(x, y, z + 2, Blocks.field_150350_a);
                  world.func_147449_b(x, y, z + 3, Blocks.field_150350_a);
                  world.func_147449_b(x, y + 1, z, Blocks.field_150350_a);
                  world.func_147449_b(x, y, z + 1, RivalRebels.theoreticaltsarbombablock);
                  world.func_72921_c(x, y, z + 1, 2, 1);
                  world.func_147449_b(x, y + 1, z + 2, Blocks.field_150350_a);
                  world.func_147449_b(x, y + 1, z + 3, Blocks.field_150350_a);
                  return true;
               }

               if (world.func_147439_a(x, y, z - 1) == RivalRebels.nukeCrateTop
                  && world.func_147439_a(x, y, z - 2) == RivalRebels.nukeCrateBottom
                  && world.func_147439_a(x, y, z - 3) == RivalRebels.nukeCrateBottom
                  && world.func_147439_a(x, y + 1, z) == RivalRebels.nukeCrateTop
                  && world.func_147439_a(x, y + 1, z - 1) == RivalRebels.nukeCrateTop
                  && world.func_147439_a(x, y + 1, z - 2) == RivalRebels.nukeCrateBottom
                  && world.func_147439_a(x, y + 1, z - 3) == RivalRebels.nukeCrateBottom) {
                  world.func_147449_b(x, y, z, Blocks.field_150350_a);
                  world.func_147449_b(x, y + 1, z - 1, Blocks.field_150350_a);
                  world.func_147449_b(x, y, z - 2, Blocks.field_150350_a);
                  world.func_147449_b(x, y, z - 3, Blocks.field_150350_a);
                  world.func_147449_b(x, y + 1, z, Blocks.field_150350_a);
                  world.func_147449_b(x, y, z - 1, RivalRebels.theoreticaltsarbombablock);
                  world.func_72921_c(x, y, z - 1, 3, 1);
                  world.func_147449_b(x, y + 1, z - 2, Blocks.field_150350_a);
                  world.func_147449_b(x, y + 1, z - 3, Blocks.field_150350_a);
                  return true;
               }

               int orientation;
               if (world.func_147439_a(x, y + 1, z) == RivalRebels.nukeCrateBottom) {
                  world.func_147449_b(x, y + 1, z, Blocks.field_150350_a);
                  orientation = 0;
               } else if (world.func_147439_a(x, y - 1, z) == RivalRebels.nukeCrateBottom) {
                  world.func_147449_b(x, y - 1, z, Blocks.field_150350_a);
                  orientation = 1;
               } else if (world.func_147439_a(x, y, z + 1) == RivalRebels.nukeCrateBottom) {
                  world.func_147449_b(x, y, z + 1, Blocks.field_150350_a);
                  orientation = 2;
               } else if (world.func_147439_a(x, y, z - 1) == RivalRebels.nukeCrateBottom) {
                  world.func_147449_b(x, y, z - 1, Blocks.field_150350_a);
                  orientation = 3;
               } else if (world.func_147439_a(x + 1, y, z) == RivalRebels.nukeCrateBottom) {
                  world.func_147449_b(x + 1, y, z, Blocks.field_150350_a);
                  orientation = 4;
               } else {
                  if (world.func_147439_a(x - 1, y, z) != RivalRebels.nukeCrateBottom) {
                     return false;
                  }

                  world.func_147449_b(x - 1, y, z, Blocks.field_150350_a);
                  orientation = 5;
               }

               world.func_147465_d(x, y, z, RivalRebels.nuclearBomb, orientation, 2);
               return true;
            }

            if (!world.field_72995_K) {
               PacketDispatcher.packetsys
                  .sendTo(
                     new TextPacket("RivalRebels.Orders RivalRebels.message.use " + RivalRebels.pliers.func_77658_a() + ".name"),
                     (EntityPlayerMP)par5EntityPlayer
                  );
            }
         } else if (!world.field_72995_K) {
            PacketDispatcher.packetsys
               .sendTo(
                  new TextPacket("RivalRebels.Orders RivalRebels.message.use " + RivalRebels.pliers.func_77658_a() + ".name"), (EntityPlayerMP)par5EntityPlayer
               );
         }
      }

      return false;
   }

   public int func_149645_b() {
      return -1;
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_149662_c() {
      return false;
   }

   public TileEntity func_149915_a(World var1, int var) {
      return new TileEntityNukeCrate();
   }

   public final IIcon func_149691_a(int side, int meta) {
      return this.icon;
   }

   public void func_149651_a(IIconRegister iconregister) {
      if (this == RivalRebels.nukeCrateTop) {
         this.icon = iconregister.func_94245_a("RivalRebels:ay");
      }

      if (this == RivalRebels.nukeCrateBottom) {
         this.icon = iconregister.func_94245_a("RivalRebels:ax");
      }
   }
}
