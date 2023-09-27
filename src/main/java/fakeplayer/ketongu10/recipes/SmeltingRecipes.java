package fakeplayer.ketongu10.recipes;

import fakeplayer.ketongu10.init.ItemInit;
import fakeplayer.ketongu10.util.handlers.ConfigHandler;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SmeltingRecipes 
{
	public static void init()
	{
		if(ConfigHandler.OBSIDIAN_INGOT_R)
		{
			GameRegistry.addSmelting(new ItemStack(Blocks.OBSIDIAN), new ItemStack(ItemInit.OBSIDIAN_INGOT), 0.4F);
		}
	}
}
