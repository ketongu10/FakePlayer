package fakeplayer.ketongu10.objects.blocks;

import java.util.Random;

import fakeplayer.ketongu10.FakePlayer;
import fakeplayer.ketongu10.init.BlockInit;
import fakeplayer.ketongu10.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RandomBlock extends Block 
{
	public RandomBlock(String name, Material material) 
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(FakePlayer.fakeplayerTAB);
		setHardness(5.0f);
		setResistance(45.0f);
		setLightLevel(25.0f);
		setLightOpacity(7);
		setDefaultSlipperiness(6.0f);
		setHarvestLevel("axe", 3);
		setSoundType(SoundType.SLIME);
		//setBlockUnbreakable();
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) 
	{
		return ItemInit.DARK_APPLE;
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() 
	{
		return BlockRenderLayer.TRANSLUCENT;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) 
	{
		return true;
	}
}
