package fakeplayer.ketongu10.objects.items;

import fakeplayer.ketongu10.FakePlayer;
import fakeplayer.ketongu10.init.ItemInit;
import fakeplayer.ketongu10.entity.diamondArrow.EntityDiamondArrow;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DiamondArrow extends ItemArrow
{
	public DiamondArrow(String name) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(FakePlayer.fakeplayerTAB);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public EntityArrow createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter) 
	{
		EntityDiamondArrow entityDiamondArrow = new EntityDiamondArrow(worldIn, shooter);
		return entityDiamondArrow;
	}
}
