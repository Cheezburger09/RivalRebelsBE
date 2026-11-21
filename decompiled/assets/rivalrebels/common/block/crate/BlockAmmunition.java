package assets.rivalrebels.common.block.crate;

import assets.rivalrebels.RivalRebels;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class BlockAmmunition extends Block {
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

   public BlockAmmunition() {
      super(Material.field_151575_d);
   }

   public int func_149745_a(Random par1Random) {
      return 0;
   }

   public void func_149699_a(World world, int x, int y, int z, EntityPlayer player) {
      this.blockActivated(world, x, y, z, player);
   }

   public boolean blockActivated(World world, int x, int y, int z, EntityPlayer player) {
      if (world.field_72995_K) {
         player.func_145747_a(new ChatComponentText(StatCollector.func_74838_a("RivalRebels.Inventory")));
         player.func_145747_a(
            new ChatComponentText(
               "§a"
                  + StatCollector.func_74838_a(RivalRebels.rocket.func_77658_a() + ".name")
                  + ". §9("
                  + StatCollector.func_74838_a(RivalRebels.rpg.func_77658_a() + ".name")
                  + " "
                  + StatCollector.func_74838_a("RivalRebels.ammunition")
                  + ")"
            )
         );
         player.func_145747_a(
            new ChatComponentText(
               "§a"
                  + StatCollector.func_74838_a(RivalRebels.battery.func_77658_a() + ".name")
                  + ". §9("
                  + StatCollector.func_74838_a(RivalRebels.tesla.func_77658_a() + ".name")
                  + " "
                  + StatCollector.func_74838_a("RivalRebels.ammunition")
                  + ")"
            )
         );
         player.func_145747_a(
            new ChatComponentText(
               "§a"
                  + StatCollector.func_74838_a(RivalRebels.hydrod.func_77658_a() + ".name")
                  + ". §9("
                  + StatCollector.func_74838_a(RivalRebels.plasmacannon.func_77658_a() + ".name")
                  + " "
                  + StatCollector.func_74838_a("RivalRebels.ammunition")
                  + ")"
            )
         );
         player.func_145747_a(
            new ChatComponentText(
               "§a"
                  + StatCollector.func_74838_a(RivalRebels.fuel.func_77658_a() + ".name")
                  + ". §9("
                  + StatCollector.func_74838_a(RivalRebels.flamethrower.func_77658_a() + ".name")
                  + " "
                  + StatCollector.func_74838_a("RivalRebels.ammunition")
                  + ")"
            )
         );
         player.func_145747_a(
            new ChatComponentText(
               "§a"
                  + StatCollector.func_74838_a(RivalRebels.redrod.func_77658_a() + ".name")
                  + ". §9("
                  + StatCollector.func_74838_a(RivalRebels.einsten.func_77658_a() + ".name")
                  + " "
                  + StatCollector.func_74838_a("RivalRebels.ammunition")
                  + ")"
            )
         );
         player.func_145747_a(
            new ChatComponentText(
               "§a"
                  + StatCollector.func_74838_a(RivalRebels.gasgrenade.func_77658_a() + ".name")
                  + ". §9("
                  + StatCollector.func_74838_a("RivalRebels.chemicalweapon")
                  + ")"
            )
         );
      }

      if (!world.field_72995_K) {
         EntityItem ei = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(RivalRebels.rocket, 32));
         EntityItem ei1 = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(RivalRebels.battery, 16));
         EntityItem ei2 = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(RivalRebels.hydrod, 1));
         EntityItem ei3 = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(RivalRebels.hydrod, 1));
         EntityItem ei4 = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(RivalRebels.hydrod, 1));
         EntityItem ei5 = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(RivalRebels.hydrod, 1));
         EntityItem ei10 = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(RivalRebels.fuel, 64));
         EntityItem ei11 = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(RivalRebels.gasgrenade, 6));
         EntityItem ei12 = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(RivalRebels.redrod, 1));
         EntityItem ei13 = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(RivalRebels.redrod, 1));
         EntityItem ei14 = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(RivalRebels.redrod, 1));
         EntityItem ei15 = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(RivalRebels.redrod, 1));
         world.func_72838_d(ei);
         world.func_72838_d(ei1);
         world.func_72838_d(ei2);
         world.func_72838_d(ei3);
         world.func_72838_d(ei4);
         world.func_72838_d(ei5);
         world.func_72838_d(ei10);
         world.func_72838_d(ei11);
         world.func_72838_d(ei12);
         world.func_72838_d(ei13);
         world.func_72838_d(ei14);
         world.func_72838_d(ei15);
         world.func_147449_b(x, y, z, Blocks.field_150350_a);
         if (world.field_73012_v.nextInt(3) == 0) {
            world.func_72838_d(new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(RivalRebels.nuclearelement, 1)));
            player.func_145747_a(
               new ChatComponentText("§a" + StatCollector.func_74838_a(RivalRebels.nuclearelement.func_77658_a() + ".name") + ". §9(Used in nuclear weapons)")
            );
         }

         return true;
      } else {
         return true;
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
      this.icon1 = iconregister.func_94245_a("RivalRebels:ah");
      this.icon2 = iconregister.func_94245_a("RivalRebels:ai");
      this.icon3 = iconregister.func_94245_a("RivalRebels:aa");
      this.icon4 = iconregister.func_94245_a("RivalRebels:aa");
      this.icon5 = iconregister.func_94245_a("RivalRebels:aa");
      this.icon6 = iconregister.func_94245_a("RivalRebels:aa");
   }
}
