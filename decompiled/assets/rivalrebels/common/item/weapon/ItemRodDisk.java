package assets.rivalrebels.common.item.weapon;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.common.core.RivalRebelsSoundPlayer;
import assets.rivalrebels.common.entity.EntityRoddiskLeader;
import assets.rivalrebels.common.entity.EntityRoddiskOfficer;
import assets.rivalrebels.common.entity.EntityRoddiskRebel;
import assets.rivalrebels.common.entity.EntityRoddiskRegular;
import assets.rivalrebels.common.entity.EntityRoddiskRep;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemRodDisk extends Item {
   boolean pass = false;

   public ItemRodDisk() {
      this.field_77777_bU = 1;
      this.func_77637_a(RivalRebels.rralltab);
   }

   public EnumAction func_77661_b(ItemStack par1ItemStack) {
      return EnumAction.bow;
   }

   public int func_77626_a(ItemStack par1ItemStack) {
      return 300;
   }

   public ItemStack func_77659_a(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
      if (!this.pass) {
         par3EntityPlayer.func_145747_a(new ChatComponentText("Password?"));
         this.pass = true;
      }

      par3EntityPlayer.func_71008_a(par1ItemStack, this.func_77626_a(par1ItemStack));
      if (RivalRebels.round.rrplayerlist.getForName(par3EntityPlayer.func_70005_c_()).rrrank.id > 1) {
         RivalRebelsSoundPlayer.playSound(par3EntityPlayer, 6, 2);
      } else {
         RivalRebelsSoundPlayer.playSound(par3EntityPlayer, 7, 2);
      }

      return par1ItemStack;
   }

   public void func_77615_a(ItemStack item, World world, EntityPlayer player, int i) {
      if (!world.field_72995_K) {
         if (!player.field_71075_bZ.field_75098_d) {
            player.field_71071_by.func_146026_a(this);
         }

         int rank = RivalRebels.round.rrplayerlist.getForName(player.func_70005_c_()).rrrank.id;
         if (rank == 0) {
            Entity entity = new EntityRoddiskRegular(world, player, 1.0F);
            world.func_72838_d(entity);
            RivalRebelsSoundPlayer.playSound(player, 7, 3);
         } else if (rank == 1) {
            Entity entity = new EntityRoddiskRebel(world, player, 1.1F);
            world.func_72838_d(entity);
            RivalRebelsSoundPlayer.playSound(player, 7, 3);
         } else if (rank == 2) {
            Entity entity = new EntityRoddiskOfficer(world, player, 1.2F);
            world.func_72838_d(entity);
            RivalRebelsSoundPlayer.playSound(player, 6, 3);
         } else if (rank == 3) {
            Entity entity = new EntityRoddiskLeader(world, player, 4.0F);
            world.func_72838_d(entity);
            RivalRebelsSoundPlayer.playSound(player, 6, 3);
         } else if (rank == 4) {
            Entity entity = new EntityRoddiskRep(world, player, 4.0F);
            world.func_72838_d(entity);
            RivalRebelsSoundPlayer.playSound(player, 6, 3);
         }
      }
   }

   public void func_94581_a(IIconRegister iconregister) {
      this.field_77791_bV = iconregister.func_94245_a("RivalRebels:as");
   }
}
