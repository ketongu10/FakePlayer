package com.tutorialmod.turtywurty.objects.items.worldIn;

import com.tutorialmod.turtywurty.TutorialMod;
import com.tutorialmod.turtywurty.init.ItemInit;
import com.tutorialmod.turtywurty.util.interfaces.IHasModel;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class KillYourself extends Item implements IHasModel
{
	public KillYourself(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(TutorialMod.TUTORIALMODTAB);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) 
	{
		EntityPlayer player = worldIn.getClosestPlayer(playerIn.posX, playerIn.posY, playerIn.posZ, 500, false);
		player.setHealth(0.0f);
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
	@Override
	public void registerModels() 
	{
		TutorialMod.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
