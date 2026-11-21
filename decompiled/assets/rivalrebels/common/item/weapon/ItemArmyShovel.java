package assets.rivalrebels.common.item.weapon;

import assets.rivalrebels.RivalRebels;
import java.util.HashSet;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.Item.ToolMaterial;

public class ItemArmyShovel extends ItemTool {
   private static HashSet<Block> blocksEffectiveAgainst = new HashSet<>();

   public ItemArmyShovel() {
      super(1.0F, ToolMaterial.IRON, blocksEffectiveAgainst);
      this.func_77637_a(RivalRebels.rralltab);
   }

   public boolean func_77645_m() {
      return false;
   }

   public boolean canHarvestBlock(Block par1Block, ItemStack is) {
      return blocksEffectiveAgainst.contains(par1Block);
   }

   public void func_94581_a(IIconRegister iconregister) {
      this.field_77791_bV = iconregister.func_94245_a("RivalRebels:aw");
   }

   static {
      blocksEffectiveAgainst.add(Blocks.field_150348_b);
      blocksEffectiveAgainst.add(Blocks.field_150349_c);
      blocksEffectiveAgainst.add(Blocks.field_150346_d);
      blocksEffectiveAgainst.add(Blocks.field_150347_e);
      blocksEffectiveAgainst.add(Blocks.field_150354_m);
      blocksEffectiveAgainst.add(Blocks.field_150351_n);
      blocksEffectiveAgainst.add(Blocks.field_150433_aE);
      blocksEffectiveAgainst.add(Blocks.field_150431_aC);
      blocksEffectiveAgainst.add(Blocks.field_150435_aG);
      blocksEffectiveAgainst.add(Blocks.field_150458_ak);
      blocksEffectiveAgainst.add(Blocks.field_150425_aM);
      blocksEffectiveAgainst.add(Blocks.field_150391_bh);
      blocksEffectiveAgainst.add(Blocks.field_150486_ae);
      blocksEffectiveAgainst.add(Blocks.field_150450_ax);
      blocksEffectiveAgainst.add(Blocks.field_150366_p);
      blocksEffectiveAgainst.add(Blocks.field_150352_o);
      blocksEffectiveAgainst.add(Blocks.field_150369_x);
      blocksEffectiveAgainst.add(Blocks.field_150482_ag);
      blocksEffectiveAgainst.add(Blocks.field_150412_bA);
      blocksEffectiveAgainst.add(Blocks.field_150451_bX);
      blocksEffectiveAgainst.add(Blocks.field_150339_S);
      blocksEffectiveAgainst.add(Blocks.field_150340_R);
      blocksEffectiveAgainst.add(Blocks.field_150368_y);
      blocksEffectiveAgainst.add(Blocks.field_150484_ah);
      blocksEffectiveAgainst.add(Blocks.field_150475_bE);
      blocksEffectiveAgainst.add(RivalRebels.barricade);
      blocksEffectiveAgainst.add(RivalRebels.reactive);
      blocksEffectiveAgainst.add(RivalRebels.conduit);
      blocksEffectiveAgainst.add(RivalRebels.tower);
      blocksEffectiveAgainst.add(RivalRebels.steel);
      blocksEffectiveAgainst.add(RivalRebels.rhodesactivator);
      blocksEffectiveAgainst.add(RivalRebels.camo1);
      blocksEffectiveAgainst.add(RivalRebels.camo2);
      blocksEffectiveAgainst.add(RivalRebels.camo3);
      blocksEffectiveAgainst.add(RivalRebels.jump);
      blocksEffectiveAgainst.add(RivalRebels.landmine);
      blocksEffectiveAgainst.add(RivalRebels.alandmine);
      blocksEffectiveAgainst.add(RivalRebels.quicksand);
      blocksEffectiveAgainst.add(RivalRebels.aquicksand);
      blocksEffectiveAgainst.add(RivalRebels.mario);
      blocksEffectiveAgainst.add(RivalRebels.amario);
      blocksEffectiveAgainst.add(RivalRebels.loader);
      blocksEffectiveAgainst.add(RivalRebels.reactor);
      blocksEffectiveAgainst.add(RivalRebels.radioactivedirt);
      blocksEffectiveAgainst.add(RivalRebels.radioactivesand);
      blocksEffectiveAgainst.add(RivalRebels.petrifiedstone1);
      blocksEffectiveAgainst.add(RivalRebels.petrifiedstone2);
      blocksEffectiveAgainst.add(RivalRebels.petrifiedstone3);
      blocksEffectiveAgainst.add(RivalRebels.petrifiedstone4);
      blocksEffectiveAgainst.add(RivalRebels.petrifiedwood);
   }
}
