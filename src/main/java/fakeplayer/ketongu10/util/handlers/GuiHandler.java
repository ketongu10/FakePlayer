package fakeplayer.ketongu10.util.handlers;

import fakeplayer.ketongu10.objects.blocks.silver_chest.GuiSilverChest;
import fakeplayer.ketongu10.energy.ContainerGlowstoneGenerator;
import fakeplayer.ketongu10.energy.GuiGlowstoneGenerator;
import fakeplayer.ketongu10.energy.TileEntityGlowstoneGenerator;
import fakeplayer.ketongu10.objects.blocks.silver_chest.ContainerSilverChest;
import fakeplayer.ketongu10.objects.blocks.silver_chest.TileEntitySilverChest;
import fakeplayer.ketongu10.objects.blocks.silver_chest_na.ContainerSilverChestNA;
import fakeplayer.ketongu10.objects.blocks.silver_chest_na.GuiSilverChestNA;
import fakeplayer.ketongu10.objects.blocks.silver_chest_na.TileEntitySilverChestNA;
import fakeplayer.ketongu10.objects.blocks.silver_furnace.ContainerSilverFurnace;
import fakeplayer.ketongu10.objects.blocks.silver_furnace.GuiSilverFurnace;
import fakeplayer.ketongu10.objects.blocks.silver_furnace.TileEntitySilverFurnace;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == ConfigHandler.GUI_SILVER_CHEST)
		{
			return new ContainerSilverChest(player.inventory, (TileEntitySilverChest)world.getTileEntity(new BlockPos(x, y, z)), player);
		}
		
		if(ID == ConfigHandler.GUI_SILVER_CHEST_NA)
		{
			return new ContainerSilverChestNA(player.inventory, (TileEntitySilverChestNA)world.getTileEntity(new BlockPos(x, y, z)), player);
		}
		
		if(ID == ConfigHandler.GUI_SILVER_FURNACE)
		{
			return new ContainerSilverFurnace(player.inventory, (TileEntitySilverFurnace)world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		if(ID == ConfigHandler.GUI_GLOWSTONE_GENERATOR) 
		{
			return new ContainerGlowstoneGenerator(player.inventory, (TileEntityGlowstoneGenerator)world.getTileEntity(new BlockPos(x,y,z)));
		}
		return null;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == ConfigHandler.GUI_SILVER_CHEST)
		{
			return new GuiSilverChest(player.inventory, (TileEntitySilverChest)world.getTileEntity(new BlockPos(x, y, z)), player);
		}
		
		if(ID == ConfigHandler.GUI_SILVER_CHEST_NA)
		{
			return new GuiSilverChestNA(player.inventory, (TileEntitySilverChestNA)world.getTileEntity(new BlockPos(x, y, z)), player);
		}
		
		if(ID == ConfigHandler.GUI_SILVER_FURNACE)
		{
			return new GuiSilverFurnace(player.inventory, (TileEntitySilverFurnace)world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		if(ID == ConfigHandler.GUI_GLOWSTONE_GENERATOR) 
		{
			return new GuiGlowstoneGenerator(player.inventory, (TileEntityGlowstoneGenerator)world.getTileEntity(new BlockPos(x,y,z)));
		}
		return null;
	}
}
