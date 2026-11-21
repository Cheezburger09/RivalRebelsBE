package assets.rivalrebels.common.entity;

import assets.rivalrebels.common.packet.EntityDebrisPacket;
import assets.rivalrebels.common.packet.PacketDispatcher;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityDebris extends EntityInanimate {
   public Block block;
   public int metadata;
   public int field_70173_aa;
   public boolean grounded;
   public NBTTagCompound tileEntityData;

   public EntityDebris(World w) {
      super(w);
   }

   public EntityDebris(World w, int x, int y, int z) {
      super(w);
      this.block = w.func_147439_a(x, y, z);
      this.metadata = w.func_72805_g(x, y, z);
      w.func_147449_b(x, y, z, Blocks.field_150350_a);
      this.func_70105_a(1.0F, 1.0F);
      this.field_70129_M = 0.5F;
      this.func_70107_b(x + 0.5F, y + 0.5F, z + 0.5F);
      this.field_70169_q = x + 0.5F;
      this.field_70167_r = y + 0.5F;
      this.field_70166_s = z + 0.5F;
   }

   public EntityDebris(World w, double x, double y, double z, double mx, double my, double mz, Block b) {
      super(w);
      this.block = b;
      this.metadata = 0;
      this.func_70105_a(1.0F, 1.0F);
      this.field_70129_M = 0.5F;
      this.func_70107_b(x, y, z);
      this.field_70169_q = x;
      this.field_70167_r = y;
      this.field_70166_s = z;
      this.field_70159_w = mx;
      this.field_70181_x = my;
      this.field_70179_y = mz;
   }

   @Override
   protected void func_70088_a() {
   }

   public void func_70071_h_() {
      if (this.field_70173_aa == 0 && FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER) {
         PacketDispatcher.packetsys.sendToAll(new EntityDebrisPacket(this));
      }

      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      this.field_70173_aa++;
      this.field_70181_x -= 0.04;
      this.field_70159_w *= 0.98;
      this.field_70181_x *= 0.98;
      this.field_70179_y *= 0.98;
      this.field_70165_t = this.field_70165_t + this.field_70159_w;
      this.field_70163_u = this.field_70163_u + this.field_70181_x;
      this.field_70161_v = this.field_70161_v + this.field_70179_y;
      if (!this.field_70170_p.field_72995_K
         && this.field_70170_p
            .func_147439_a(
               MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v)
            )
            .func_149662_c()) {
         this.die(this.field_70169_q, this.field_70167_r, this.field_70166_s);
      }
   }

   public void die(double X, double Y, double Z) {
      int x = MathHelper.func_76128_c(X);
      int y = MathHelper.func_76128_c(Y);
      int z = MathHelper.func_76128_c(Z);
      this.func_70106_y();
      this.field_70170_p.func_147465_d(x, y, z, this.block, this.metadata, 3);
      if (this.block instanceof BlockFalling) {
         ((BlockFalling)this.block).func_149828_a(this.field_70170_p, x, y, z, this.metadata);
      }

      if (this.tileEntityData != null && this.block instanceof ITileEntityProvider) {
         TileEntity tileentity = this.field_70170_p.func_147438_o(x, y, z);
         if (tileentity != null) {
            NBTTagCompound nbttagcompound = new NBTTagCompound();
            tileentity.func_145841_b(nbttagcompound);

            for (String s : this.tileEntityData.func_150296_c()) {
               NBTBase nbtbase = this.tileEntityData.func_74781_a(s);
               if (!s.equals("x") && !s.equals("y") && !s.equals("z")) {
                  nbttagcompound.func_74782_a(s, nbtbase.func_74737_b());
               }
            }

            tileentity.func_145839_a(nbttagcompound);
            tileentity.func_70296_d();
         }
      }
   }

   @Override
   protected void func_70014_b(NBTTagCompound nbt) {
      nbt.func_74774_a("Tile", (byte)Block.func_149682_b(this.block));
      nbt.func_74768_a("TileID", Block.func_149682_b(this.block));
      nbt.func_74774_a("Data", (byte)this.metadata);
      nbt.func_74774_a("Time", (byte)this.field_70173_aa);
      if (this.tileEntityData != null) {
         nbt.func_74782_a("TileEntityData", this.tileEntityData);
      }
   }

   @Override
   protected void func_70037_a(NBTTagCompound nbt) {
      if (nbt.func_150297_b("TileID", 99)) {
         this.block = Block.func_149729_e(nbt.func_74762_e("TileID"));
      } else {
         this.block = Block.func_149729_e(nbt.func_74771_c("Tile") & 255);
      }

      this.metadata = nbt.func_74771_c("Data") & 255;
      this.field_70173_aa = nbt.func_74771_c("Time") & 255;
      if (nbt.func_150297_b("TileEntityData", 10)) {
         this.tileEntityData = nbt.func_74775_l("TileEntityData");
      }
   }

   public void func_85029_a(CrashReportCategory crash) {
      super.func_85029_a(crash);
      crash.func_71507_a("Immitating block ID", Block.func_149682_b(this.block));
      crash.func_71507_a("Immitating block data", this.metadata);
   }
}
