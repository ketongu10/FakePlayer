package fakeplayer.ketongu10.init;

import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryInit 
{
	public static void registerOres()
	{
		OreDictionary.registerOre("ingotObsidian", ItemInit.OBSIDIAN_INGOT);
		OreDictionary.registerOre("blockSilver", BlockInit.SILVER_BLOCK);
	}
}
