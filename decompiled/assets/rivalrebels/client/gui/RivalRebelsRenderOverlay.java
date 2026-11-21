package assets.rivalrebels.client.gui;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.renderentity.RenderRhodes;
import assets.rivalrebels.client.tileentityrender.TileEntityForceFieldNodeRenderer;
import assets.rivalrebels.common.entity.EntityRhodes;
import assets.rivalrebels.common.item.weapon.ItemBinoculars;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class RivalRebelsRenderOverlay {
   public int tic = 0;
   public boolean r = false;
   public EntityRhodes rhodes = null;
   public long counter = 0L;
   float beep = 0.0F;

   @SubscribeEvent(priority = EventPriority.NORMAL)
   public void eventHandler(RenderGameOverlayEvent event) {
      if (this.rhodes != null) {
         this.renderRhodes(event, Minecraft.func_71410_x().field_71439_g, this.rhodes);
      }

      this.renderItems(event);
   }

   private void renderItems(RenderGameOverlayEvent event) {
      if (event.type == ElementType.HOTBAR) {
         EntityPlayer player = Minecraft.func_71410_x().field_71439_g;
         ItemStack item = player.field_71071_by.func_70448_g();
         if (item == null) {
            return;
         }

         if (item.func_77973_b() instanceof ItemBinoculars) {
            this.renderBinoculars(item, event, player);
         }
      }
   }

   private void renderRhodes(RenderGameOverlayEvent event, EntityPlayer player, EntityRhodes rhodes) {
      if (event.type == ElementType.HOTBAR) {
         this.counter--;
         if (this.counter <= 0L) {
            this.counter = 0L;
            RivalRebels.rrro.rhodes = null;
         }

         Tessellator t = Tessellator.field_78398_a;
         GL11.glDisable(2929);
         GL11.glDepthMask(false);
         GL11.glEnable(3042);
         FontRenderer fr = Minecraft.func_71410_x().field_71466_p;
         int w = event.resolution.func_78326_a();
         int h = event.resolution.func_78328_b();
         GL11.glBlendFunc(770, 771);
         Minecraft.func_71410_x().func_110434_K().func_110577_a(RivalRebels.guirhodesline);
         GL11.glTexParameteri(3553, 10241, 9729);
         GL11.glTexParameteri(3553, 10240, 9729);
         GL11.glColor4f(1.0F, 0.0F, 0.0F, 0.5F);
         t.func_78382_b();
         t.func_78374_a(0.0, h, -90.0, 0.0, 1.0);
         t.func_78374_a(w, h, -90.0, 1.0, 1.0);
         t.func_78374_a(w, 0.0, -90.0, 1.0, 0.0);
         t.func_78374_a(0.0, 0.0, -90.0, 0.0, 0.0);
         t.func_78381_a();
         GL11.glBlendFunc(1, 771);
         Minecraft.func_71410_x().func_110434_K().func_110577_a(RivalRebels.guirhodesout);
         GL11.glTexParameteri(3553, 10241, 9729);
         GL11.glTexParameteri(3553, 10240, 9729);
         GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.333F);
         t.func_78382_b();
         t.func_78374_a(0.0, h, -90.0, 0.0, 1.0);
         t.func_78374_a(w, h, -90.0, 1.0, 1.0);
         t.func_78374_a(w, 0.0, -90.0, 1.0, 0.0);
         t.func_78374_a(0.0, 0.0, -90.0, 0.0, 0.0);
         t.func_78381_a();
         if (Keyboard.isKeyDown(35)) {
            GL11.glBlendFunc(770, 771);
            Minecraft.func_71410_x().func_110434_K().func_110577_a(RivalRebels.guirhodeshelp);
            GL11.glTexParameteri(3553, 10241, 9729);
            GL11.glTexParameteri(3553, 10240, 9729);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            t.func_78382_b();
            t.func_78374_a(w * 0.25F, h * 0.75F, -90.0, 0.0, 1.0);
            t.func_78374_a(w * 0.75F, h * 0.75F, -90.0, 1.0, 1.0);
            t.func_78374_a(w * 0.75F, h * 0.25F, -90.0, 1.0, 0.0);
            t.func_78374_a(w * 0.25F, h * 0.25F, -90.0, 0.0, 0.0);
            t.func_78381_a();
         }

         if (rhodes.itexfolder > -1 && rhodes.itexfolder < 4) {
            GL11.glBlendFunc(770, 771);
            Minecraft.func_71410_x()
               .field_71446_o
               .func_110577_a(new ResourceLocation("rivalrebels", "textures/" + RenderRhodes.texfolders[rhodes.itexfolder] + rhodes.itexloc + ".png"));
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            t.func_78382_b();
            float s = 8.0F;
            float wl = w * 0.5F;
            float hl = h * 0.05F;
            t.func_78374_a(wl - s, hl + s, -90.0, 0.0, 1.0);
            t.func_78374_a(wl + s, hl + s, -90.0, 1.0, 1.0);
            t.func_78374_a(wl + s, hl - s, -90.0, 1.0, 0.0);
            t.func_78374_a(wl - s, hl - s, -90.0, 0.0, 0.0);
            t.func_78381_a();
         }

         GL11.glDisable(3042);
         String disp = "Rival Rebels";
         fr.func_85187_a(disp, (int)(w * 0.05), (int)(h * 0.05), 16777215, false);
         disp = "Robot: " + rhodes.getName();
         fr.func_85187_a(disp, (int)(w * 0.05), (int)(h * 0.1), 16777215, false);
         disp = RivalRebels.reactor.func_149732_F() + ": " + rhodes.health;
         float val = (float)rhodes.health / RivalRebels.rhodesHealth;
         fr.func_85187_a(disp, (int)(w * 0.05), (int)(h * 0.15), ((int)((1.0F - val) * 255.0F) & 0xFF) << 16 | ((int)(val * 255.0F) & 0xFF) << 8, false);
         float yaw = (player.field_70177_z + 360000.0F) % 360.0F;
         disp = yaw >= 315.0F || yaw < 45.0F
            ? StatCollector.func_74838_a("RivalRebels.binoculars.south")
            : (
               yaw >= 45.0F && yaw < 135.0F
                  ? StatCollector.func_74838_a("RivalRebels.binoculars.west")
                  : (
                     yaw >= 135.0F && yaw < 225.0F
                        ? StatCollector.func_74838_a("RivalRebels.binoculars.north")
                        : (yaw >= 225.0F && yaw < 315.0F ? StatCollector.func_74838_a("RivalRebels.binoculars.east") : "Whut")
                  )
            );
         fr.func_85187_a(disp, (int)(w * 0.05), (int)(h * 0.2), 16777215, false);
         disp = StatCollector.func_74838_a(RivalRebels.einsten.func_77658_a() + ".name") + ": " + rhodes.energy;
         fr.func_85187_a(disp, (int)(w * 0.8), (int)(h * 0.05), rhodes.laserOn > 0 ? 16724787 : 16777215, false);
         disp = "Jet: " + rhodes.energy;
         fr.func_85187_a(disp, (int)(w * 0.8), (int)(h * 0.1), RivalRebels.proxy.spacebar() ? 6711039 : 16777215, false);
         disp = RivalRebels.forcefieldnode.func_149732_F() + ": " + rhodes.energy;
         fr.func_85187_a(disp, (int)(w * 0.8), (int)(h * 0.15), rhodes.forcefield ? 12290303 : 16777215, false);
         disp = StatCollector.func_74838_a(RivalRebels.seekm202.func_77658_a() + ".name") + ": " + rhodes.rocketcount;
         fr.func_85187_a(disp, (int)(w * 0.8), (int)(h * 0.2), 16777215, false);
         disp = (rhodes.plasma ? "Plasma: " : StatCollector.func_74838_a(RivalRebels.fuel.func_77658_a() + ".name") + ": ") + rhodes.flamecount;
         fr.func_85187_a(disp, (int)(w * 0.8), (int)(h * 0.25), 16777215, false);
         disp = RivalRebels.nuclearBomb.func_149732_F() + ": " + rhodes.nukecount;
         fr.func_85187_a(disp, (int)(w * 0.8), (int)(h * 0.3), 16777215, false);
         disp = "Guard";
         fr.func_85187_a(disp, (int)(w * 0.8), (int)(h * 0.35), Keyboard.isKeyDown(34) ? 16776960 : 16777215, false);
         disp = rhodes.getName() + " " + RivalRebels.controller.func_149732_F() + ": H";
         fr.func_85187_a(disp, (int)(w * 0.05), (int)(h * 0.95), Keyboard.isKeyDown(35) ? 16776960 : 16777215, false);
         if (rhodes.forcefield) {
            GL11.glBindTexture(
               3553, TileEntityForceFieldNodeRenderer.id[(int)(TileEntityForceFieldNodeRenderer.getTime() / 100L % TileEntityForceFieldNodeRenderer.frames)]
            );
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 1);
            GL11.glDisable(2896);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.7F);
            t.func_78382_b();
            t.func_78374_a(0.0, h, -90.0, 0.0, h * 0.003F);
            t.func_78374_a(w, h, -90.0, w * 0.003F, h * 0.003F);
            t.func_78374_a(w, 0.0, -90.0, w * 0.003F, 0.0);
            t.func_78374_a(0.0, 0.0, -90.0, 0.0, 0.0);
            t.func_78381_a();
            GL11.glDisable(3042);
            GL11.glEnable(2896);
         }
      }
   }

   private void renderBinoculars(ItemStack item, RenderGameOverlayEvent event, EntityPlayer player) {
      if (Mouse.isButtonDown(1)) {
         if (event.isCancelable()) {
            event.setCanceled(true);
         }

         if (event.type == ElementType.HOTBAR) {
            Tessellator t = Tessellator.field_78398_a;
            this.tic++;
            GL11.glDisable(2929);
            GL11.glDepthMask(false);
            Minecraft.func_71410_x().func_110434_K().func_110577_a(RivalRebels.guibinoculars);
            FontRenderer fr = Minecraft.func_71410_x().field_71466_p;
            int w = event.resolution.func_78326_a();
            int h = event.resolution.func_78328_b();
            GL11.glBlendFunc(1, 771);
            GL11.glEnable(3042);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            t.func_78382_b();
            t.func_78374_a(0.0, h, -90.0, 0.0, 1.0);
            t.func_78374_a(w, h, -90.0, 1.0, 1.0);
            t.func_78374_a(w, 0.0, -90.0, 1.0, 0.0);
            t.func_78374_a(0.0, 0.0, -90.0, 0.0, 0.0);
            t.func_78381_a();
            Minecraft.func_71410_x().func_110434_K().func_110577_a(RivalRebels.guibinocularsoverlay);
            GL11.glColor4f(0.333F, 0.333F, 0.333F, 0.5F);
            t.func_78382_b();
            t.func_78374_a(0.0, h, -90.0, 0.0, 1.0);
            t.func_78374_a(w, h, -90.0, 1.0, 1.0);
            t.func_78374_a(w, 0.0, -90.0, 1.0, 0.0);
            t.func_78374_a(0.0, 0.0, -90.0, 0.0, 0.0);
            t.func_78381_a();
            Block id = player.field_70170_p.func_147439_a(ItemBinoculars.tx, ItemBinoculars.ty, ItemBinoculars.tz);
            String disp = "X";
            if (id != null) {
               disp = StatCollector.func_74838_a(id.func_149739_a() + ".name");
            }

            fr.func_85187_a(disp, (int)(w * 0.5 - fr.func_78256_a(disp) / 2.0F), (int)(h * 0.18), 65280, false);
            if (!ItemBinoculars.tooFar) {
               disp = "(" + ItemBinoculars.tx + ", " + ItemBinoculars.ty + ", " + ItemBinoculars.tz + ")";
            } else {
               disp = "";
            }

            fr.func_85187_a(disp, (int)(w * 0.5 - fr.func_78256_a(disp) / 2.0F), (int)(h * 0.13), 65280, false);
            disp = "";
            if (this.tic % 30 == 0) {
               this.r = !this.r;
            }

            disp = "LTD RR";
            fr.func_85187_a(disp, (int)(w * 0.5 - fr.func_78256_a(disp) / 2.0F), (int)(h * 0.8), 16777215, false);
            disp = (int)ItemBinoculars.distblock + "m";
            fr.func_85187_a(disp, (int)(w * 0.637 - fr.func_78256_a(disp) / 2.0F), (int)(h * 0.205), 16777215, false);
            float yaw = (player.field_70177_z + 360000.0F) % 360.0F;
            disp = yaw >= 315.0F || yaw < 45.0F
               ? StatCollector.func_74838_a("RivalRebels.binoculars.south")
               : (
                  yaw >= 45.0F && yaw < 135.0F
                     ? StatCollector.func_74838_a("RivalRebels.binoculars.west")
                     : (
                        yaw >= 135.0F && yaw < 225.0F
                           ? StatCollector.func_74838_a("RivalRebels.binoculars.north")
                           : (yaw >= 225.0F && yaw < 315.0F ? StatCollector.func_74838_a("RivalRebels.binoculars.east") : "Whut")
                     )
               );
            fr.func_85187_a(disp, (int)(w * 0.37 - fr.func_78256_a(disp) / 2.0F), (int)(h * 0.205), 16777215, false);
            if (ItemBinoculars.tooFar) {
               fr.func_85187_a(
                  StatCollector.func_74838_a("RivalRebels.controller.range"),
                  (int)(w * 0.5 - fr.func_78256_a(StatCollector.func_74838_a("RivalRebels.controller.range")) / 2.0F),
                  (int)(h * 0.85),
                  16711680,
                  false
               );
            } else if (ItemBinoculars.tooClose) {
               fr.func_85187_a(
                  StatCollector.func_74838_a("RivalRebels.nextbattle.no"),
                  (int)(w * 0.5 - fr.func_78256_a(StatCollector.func_74838_a("RivalRebels.nextbattle.no")) / 2.0F),
                  (int)(h * 0.85),
                  16711680,
                  false
               );
            } else if (ItemBinoculars.ready) {
               fr.func_85187_a(
                  StatCollector.func_74838_a("RivalRebels.binoculars.target"),
                  (int)(w * 0.5 - fr.func_78256_a(StatCollector.func_74838_a("RivalRebels.binoculars.target")) / 2.0F),
                  (int)(h * 0.85),
                  16711680,
                  false
               );
            }

            fr.func_85187_a(
               StatCollector.func_74838_a("RivalRebels.message.use") + " " + StatCollector.func_74838_a("RivalRebels.sneak") + " B-83 x2",
               (int)(w * 0.05),
               (int)(h * 0.95),
               16711680,
               false
            );
            fr.func_85187_a("Press C to select bomb type", (int)(w * 0.6), (int)(h * 0.95), 16711680, false);
            if ((ItemBinoculars.tasks > 0 || ItemBinoculars.carpet > 0) && ItemBinoculars.dist < 10.0F) {
               Minecraft.func_71410_x().func_110434_K().func_110577_a(ItemBinoculars.c ? RivalRebels.guicarpet : RivalRebels.ittaskb83);
               GL11.glBlendFunc(1, 771);
               float col = 1.0F - ItemBinoculars.dist / 10.0F;
               GL11.glColor4f(col, col, col, 1.0F);
               t.func_78382_b();
               t.func_78374_a(w * 0.72, h * 0.85 + 16.0, -90.0, 0.0, 1.0);
               t.func_78374_a(w * 0.72 + 16.0, h * 0.85 + 16.0, -90.0, 1.0, 1.0);
               t.func_78374_a(w * 0.72 + 16.0, h * 0.85, -90.0, 1.0, 0.0);
               t.func_78374_a(w * 0.72, h * 0.85, -90.0, 0.0, 0.0);
               t.func_78381_a();
               disp = "x" + ItemBinoculars.tasks;
               fr.func_85187_a(disp, (int)(w * 0.76), (int)(h * 0.85), ItemBinoculars.c ? 16776960 : 16711680, false);
               disp = "x" + ItemBinoculars.carpet;
               fr.func_85187_a(disp, (int)(w * 0.76), (int)(h * 0.9), ItemBinoculars.c ? 16711680 : 16776960, false);
               disp = StatCollector.func_74838_a("RivalRebels.tacticalnuke.name");
               if (!this.r) {
                  fr.func_85187_a(disp, (int)(w * 0.5 - fr.func_78256_a(disp) / 2.0F), (int)(h * 0.71), 65280, false);
               }
            } else if ((ItemBinoculars.tasks > 0 || ItemBinoculars.carpet > 0) && ItemBinoculars.hasLaptop) {
               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
               disp = RivalRebels.controller.func_149732_F() + " " + StatCollector.func_74838_a("RivalRebels.controller.range");
               fr.func_85187_a(disp, (int)(w * 0.63), (int)(h * 0.87), 16776960, false);
            }
         }
      }
   }
}
