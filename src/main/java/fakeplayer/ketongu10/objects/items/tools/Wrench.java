package fakeplayer.ketongu10.objects.items.tools;

import fakeplayer.ketongu10.FakePlayer;
import fakeplayer.ketongu10.init.ItemInit;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Wrench extends Item
{
	public Wrench(String name, int durability) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(FakePlayer.fakeplayerTAB);
		setMaxStackSize(1);
		setMaxDamage(durability);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public EnumActionResult onItemUseFirst(EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, EnumHand hand) 
	{
		if(player.isSneaking())
		{
			world.getBlockState(pos).getBlock().rotateBlock(world, pos, side.getOpposite());
			player.getHeldItemMainhand().damageItem(1, player);
			return EnumActionResult.SUCCESS;
		}
		return super.onItemUseFirst(player, world, pos, side, hitX, hitY, hitZ, hand);
	}
}
