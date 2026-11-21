package assets.rivalrebels.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityTarget extends EntityLivingBase {
   private Entity e;

   public EntityTarget(World par1World) {
      super(par1World);
   }

   public EntityTarget(World par1World, Entity relay) {
      super(par1World);
      this.e = relay;
      this.field_70121_D.func_72328_c(this.e.field_70121_D);
      this.field_70139_V = this.e.field_70139_V;
      this.field_70131_O = this.e.field_70131_O;
      this.field_70130_N = this.e.field_70130_N;
      this.field_70129_M = this.e.field_70129_M;
   }

   public void func_70071_h_() {
      if (this.e != null && !this.e.field_70128_L) {
         this.func_70107_b(this.e.field_70165_t, this.e.field_70163_u, this.e.field_70161_v);
      } else {
         this.func_70106_y();
      }
   }

   public boolean func_70097_a(DamageSource ds, float f) {
      this.e.func_70097_a(ds, f);
      return true;
   }

   public ItemStack func_70694_bm() {
      return null;
   }

   public ItemStack func_71124_b(int p_71124_1_) {
      return null;
   }

   public void func_70062_b(int p_70062_1_, ItemStack p_70062_2_) {
   }

   public ItemStack[] func_70035_c() {
      return null;
   }

   public void func_70014_b(NBTTagCompound nbt) {
      nbt.func_74768_a("id", this.e.func_145782_y());
   }

   public void func_70037_a(NBTTagCompound nbt) {
      this.e = this.field_70170_p.func_73045_a(nbt.func_74762_e("id"));
   }
}
