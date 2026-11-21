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
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class BlockSupplies extends Block {
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

   public BlockSupplies() {
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
            new ChatComponentText("§a" + StatCollector.func_74838_a(RivalRebels.armyshovel.func_77658_a() + ".name") + ". §9(Ideal for special blocks.)")
         );
         player.func_145747_a(
            new ChatComponentText("§a" + StatCollector.func_74838_a(RivalRebels.jump.func_149739_a() + ".name") + ". §9(Use at your own risk.)")
         );
         player.func_145747_a(
            new ChatComponentText("§a" + StatCollector.func_74838_a(RivalRebels.quicksand.func_149739_a() + ".name") + ". §9(Sand that is quick)")
         );
         player.func_145747_a(new ChatComponentText("§a" + StatCollector.func_74838_a(RivalRebels.mario.func_149739_a() + ".name") + ". §9(For trap making.)"));
         player.func_145747_a(
            new ChatComponentText("§a" + StatCollector.func_74838_a(RivalRebels.loader.func_149739_a() + ".name") + ". §9(Modular item container.)")
         );
         player.func_145747_a(
            new ChatComponentText("§a" + StatCollector.func_74838_a(RivalRebels.steel.func_149739_a() + ".name") + ". §9(Climbable and blast resistant.)")
         );
         player.func_145747_a(
            new ChatComponentText("§a" + StatCollector.func_74838_a(RivalRebels.expill.func_77658_a() + ".name") + ". §9(Take at your own risk.)")
         );
         player.func_145747_a(
            new ChatComponentText("§a" + StatCollector.func_74838_a(RivalRebels.safepill.func_77658_a() + ".name") + ". §9(Restores health.)")
         );
         player.func_145747_a(
            new ChatComponentText("§a" + StatCollector.func_74838_a(RivalRebels.breadbox.func_149739_a() + ".name") + ". §9(Unlimited toast! You don't say...)")
         );
      }

      if (!world.field_72995_K) {
         EntityItem ei = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(RivalRebels.breadbox, 1));
         EntityItem ei1 = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(RivalRebels.armyshovel));
         EntityItem ei2 = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(RivalRebels.jump, 4));
         EntityItem ei3 = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(RivalRebels.quicksandtrap, 4));
         EntityItem ei4 = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(RivalRebels.steel, 32));
         EntityItem ei5 = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(RivalRebels.loader, 2));
         EntityItem ei6 = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(Items.field_151133_ar, 2));
         EntityItem ei7 = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(RivalRebels.mariotrap, 4));
         EntityItem ei8 = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(RivalRebels.expill, 6));
         EntityItem ei9 = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(RivalRebels.safepill, 3));
         world.func_72838_d(ei);
         world.func_72838_d(ei1);
         world.func_72838_d(ei2);
         world.func_72838_d(ei3);
         world.func_72838_d(ei4);
         world.func_72838_d(ei5);
         world.func_72838_d(ei6);
         world.func_72838_d(ei7);
         world.func_72838_d(ei8);
         world.func_72838_d(ei9);
         world.func_147449_b(x, y, z, Blocks.field_150350_a);
         if (world.field_73012_v.nextInt(5) == 0) {
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
      this.icon3 = iconregister.func_94245_a("RivalRebels:bz");
      this.icon4 = iconregister.func_94245_a("RivalRebels:bz");
      this.icon5 = iconregister.func_94245_a("RivalRebels:bz");
      this.icon6 = iconregister.func_94245_a("RivalRebels:bz");
   }
}
