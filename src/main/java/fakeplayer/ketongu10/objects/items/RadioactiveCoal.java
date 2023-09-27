package fakeplayer.ketongu10.objects.items;

import fakeplayer.ketongu10.FakePlayer;
import fakeplayer.ketongu10.init.ItemInit;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RadioactiveCoal extends Item
{
	public RadioactiveCoal(String name) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(FakePlayer.fakeplayerTAB);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public int getItemBurnTime(ItemStack itemStack) 
	{
		return 3000;
	}
}
