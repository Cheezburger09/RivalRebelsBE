package assets.rivalrebels.common.core;

import assets.rivalrebels.client.gui.GuiAntimatterBomb;
import assets.rivalrebels.client.gui.GuiLaptop;
import assets.rivalrebels.client.gui.GuiLoader;
import assets.rivalrebels.client.gui.GuiNuclearBomb;
import assets.rivalrebels.client.gui.GuiReactor;
import assets.rivalrebels.client.gui.GuiTachyonBomb;
import assets.rivalrebels.client.gui.GuiTheoreticalTsar;
import assets.rivalrebels.client.gui.GuiTray;
import assets.rivalrebels.client.gui.GuiTsar;
import assets.rivalrebels.common.container.ContainerAntimatterBomb;
import assets.rivalrebels.common.container.ContainerLaptop;
import assets.rivalrebels.common.container.ContainerLoader;
import assets.rivalrebels.common.container.ContainerNuclearBomb;
import assets.rivalrebels.common.container.ContainerReactor;
import assets.rivalrebels.common.container.ContainerReciever;
import assets.rivalrebels.common.container.ContainerTachyonBomb;
import assets.rivalrebels.common.container.ContainerTheoreticalTsar;
import assets.rivalrebels.common.container.ContainerTsar;
import assets.rivalrebels.common.tileentity.TileEntityAntimatterBomb;
import assets.rivalrebels.common.tileentity.TileEntityLaptop;
import assets.rivalrebels.common.tileentity.TileEntityLoader;
import assets.rivalrebels.common.tileentity.TileEntityNuclearBomb;
import assets.rivalrebels.common.tileentity.TileEntityReactor;
import assets.rivalrebels.common.tileentity.TileEntityReciever;
import assets.rivalrebels.common.tileentity.TileEntityTachyonBomb;
import assets.rivalrebels.common.tileentity.TileEntityTheoreticalTsarBomba;
import assets.rivalrebels.common.tileentity.TileEntityTsarBomba;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class RivalRebelsGuiHandler implements IGuiHandler {
   public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
      TileEntity tileEntity = world.func_147438_o(x, y, z);
      if (tileEntity instanceof TileEntityTsarBomba) {
         return new ContainerTsar(player.field_71071_by, (TileEntityTsarBomba)tileEntity);
      } else if (tileEntity instanceof TileEntityAntimatterBomb) {
         return new ContainerAntimatterBomb(player.field_71071_by, (TileEntityAntimatterBomb)tileEntity);
      } else if (tileEntity instanceof TileEntityTachyonBomb) {
         return new ContainerTachyonBomb(player.field_71071_by, (TileEntityTachyonBomb)tileEntity);
      } else if (tileEntity instanceof TileEntityTheoreticalTsarBomba) {
         return new ContainerTheoreticalTsar(player.field_71071_by, (TileEntityTheoreticalTsarBomba)tileEntity);
      } else if (tileEntity instanceof TileEntityNuclearBomb) {
         return new ContainerNuclearBomb(player.field_71071_by, (TileEntityNuclearBomb)tileEntity);
      } else if (tileEntity instanceof TileEntityLoader) {
         return new ContainerLoader(player.field_71071_by, (TileEntityLoader)tileEntity);
      } else if (tileEntity instanceof TileEntityReactor) {
         return new ContainerReactor(player.field_71071_by, (TileEntityReactor)tileEntity);
      } else if (tileEntity instanceof TileEntityLaptop) {
         return new ContainerLaptop(player.field_71071_by, (TileEntityLaptop)tileEntity);
      } else {
         return tileEntity instanceof TileEntityReciever ? new ContainerReciever(player.field_71071_by, (TileEntityReciever)tileEntity) : null;
      }
   }

   public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
      TileEntity tileEntity = world.func_147438_o(x, y, z);
      if (tileEntity instanceof TileEntityTsarBomba) {
         return new GuiTsar(player.field_71071_by, (TileEntityTsarBomba)tileEntity);
      } else if (tileEntity instanceof TileEntityAntimatterBomb) {
         return new GuiAntimatterBomb(player.field_71071_by, (TileEntityAntimatterBomb)tileEntity);
      } else if (tileEntity instanceof TileEntityTachyonBomb) {
         return new GuiTachyonBomb(player.field_71071_by, (TileEntityTachyonBomb)tileEntity);
      } else if (tileEntity instanceof TileEntityTheoreticalTsarBomba) {
         return new GuiTheoreticalTsar(player.field_71071_by, (TileEntityTheoreticalTsarBomba)tileEntity);
      } else if (tileEntity instanceof TileEntityNuclearBomb) {
         return new GuiNuclearBomb(player.field_71071_by, (TileEntityNuclearBomb)tileEntity);
      } else if (tileEntity instanceof TileEntityLoader) {
         return new GuiLoader(player.field_71071_by, (TileEntityLoader)tileEntity);
      } else if (tileEntity instanceof TileEntityReactor) {
         return new GuiReactor(player.field_71071_by, (TileEntityReactor)tileEntity);
      } else if (tileEntity instanceof TileEntityLaptop) {
         return new GuiLaptop(player.field_71071_by, (TileEntityLaptop)tileEntity);
      } else {
         return tileEntity instanceof TileEntityReciever ? new GuiTray(player.field_71071_by, (TileEntityReciever)tileEntity) : null;
      }
   }
}
