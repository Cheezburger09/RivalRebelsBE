package assets.rivalrebels.common.entity;

import assets.rivalrebels.RivalRebels;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityLaptop extends EntityInanimate {
   public double slide = 0.0;
   double test = Math.PI;

   public EntityLaptop(World par1World) {
      super(par1World);
      this.func_70105_a(1.0F, 0.6F);
      this.field_70121_D.func_72324_b(-0.21875, 0.0, -0.28125, 0.21875, 0.125, 0.28125);
   }

   public AxisAlignedBB func_70114_g(Entity par1Entity) {
      return par1Entity.field_70121_D;
   }

   public AxisAlignedBB func_70046_E() {
      return this.field_70121_D;
   }

   public boolean func_70067_L() {
      return !this.field_70128_L;
   }

   public boolean func_70104_M() {
      return true;
   }

   public EntityLaptop(World par1World, float x, float y, float z, float yaw) {
      super(par1World);
      this.func_70107_b(x, y, z);
      this.field_70177_z = yaw;
      this.field_70121_D.func_72324_b(-0.21875, 0.0, -0.28125, 0.21875, 0.125, 0.28125);
   }

   public void func_70071_h_() {
      super.func_70071_h_();
      this.slide = (Math.cos(this.test) + 1.0) * 45.0;
      List players = this.field_70170_p.field_73010_i;
      Iterator iter = players.iterator();
      boolean i = false;

      while (iter.hasNext()) {
         EntityPlayer player = (EntityPlayer)iter.next();
         if (player.func_70092_e(this.field_70165_t + 0.5, this.field_70163_u + 0.5, this.field_70161_v + 0.5) <= 9.0) {
            i = true;
         }
      }

      if (i) {
         if (this.slide < 89.995) {
            this.test += 0.05;
         }
      } else if (this.slide > 0.004) {
         this.test -= 0.05;
      }
   }

   public boolean func_130002_c(EntityPlayer player) {
      if (player.func_70093_af() && !player.field_70170_p.field_72995_K) {
         FMLNetworkHandler.openGui(player, RivalRebels.instance, 0, player.field_70170_p, 0, 0, 0);
      }

      if (!player.func_70093_af() && player.field_71071_by.func_70441_a(new ItemStack(RivalRebels.controller))) {
         player.func_71038_i();
         this.func_70106_y();
      }

      return true;
   }

   @Override
   protected void func_70088_a() {
   }

   @Override
   protected void func_70037_a(NBTTagCompound nbttagcompound) {
   }

   @Override
   protected void func_70014_b(NBTTagCompound nbttagcompound) {
   }
}
