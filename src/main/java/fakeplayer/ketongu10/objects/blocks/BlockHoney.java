package fakeplayer.ketongu10.objects.blocks;

import fakeplayer.ketongu10.FakePlayer;
import fakeplayer.ketongu10.init.BlockInit;
import fakeplayer.ketongu10.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;

public class BlockHoney extends Block
{
	public BlockHoney(String name) 
	{
		super(Material.CAKE);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(FakePlayer.fakeplayerTAB);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
}
