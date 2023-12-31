package fakeplayer.ketongu10.objects.items.staffs;

import fakeplayer.ketongu10.FakePlayer;
import fakeplayer.ketongu10.init.ItemInit;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class LargeFireballStaff extends Item
{
	public LargeFireballStaff(String name) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(FakePlayer.fakeplayerTAB);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) 
	{
		ItemStack item = playerIn.getHeldItem(handIn);
		Vec3d look = playerIn.getLookVec();
		EntityLargeFireball largeFireball = new EntityLargeFireball(worldIn, playerIn, 1D, 1D, 1D);
		largeFireball.setPosition(playerIn.posX + look.x * 1.5D, playerIn.posY + look.y * 1.5D, playerIn.posZ + look.z * 1.5D);
		largeFireball.accelerationX = look.x * 7.0D;
		largeFireball.accelerationY = look.y * 7.0D;
		largeFireball.accelerationZ = look.z * 7.0D;
		largeFireball.explosionPower = 50;
		largeFireball.setGlowing(true);
		playerIn.getCooldownTracker().setCooldown(this, 30);
		worldIn.spawnEntity(largeFireball);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
	}
}
