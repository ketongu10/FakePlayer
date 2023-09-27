package fakeplayer.ketongu10.objects.items;

import fakeplayer.ketongu10.FakePlayer;
import fakeplayer.ketongu10.init.ItemInit;

import net.minecraft.item.ItemFood;

public class DarkApple extends ItemFood
{
	public DarkApple(String name, int amount, float saturation, boolean isWolfFood) 
	{
		super(amount, saturation, isWolfFood);
		setUnlocalizedName(name);	
		setRegistryName(name);
		setCreativeTab(FakePlayer.fakeplayerTAB);
		
		ItemInit.ITEMS.add(this);
	}
} 
