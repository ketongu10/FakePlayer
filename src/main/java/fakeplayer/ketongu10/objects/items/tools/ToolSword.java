package fakeplayer.ketongu10.objects.items.tools;

import fakeplayer.ketongu10.FakePlayer;
import fakeplayer.ketongu10.init.ItemInit;

import net.minecraft.item.ItemSword;

public class ToolSword extends ItemSword
{
	public ToolSword(String name, ToolMaterial material) 
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(FakePlayer.fakeplayerTAB);
		
		ItemInit.ITEMS.add(this);
	}
}
