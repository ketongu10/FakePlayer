package fakeplayer.ketongu10.enchants;

import fakeplayer.ketongu10.init.EnchantmentInit;
import fakeplayer.ketongu10.util.Reference;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.ResourceLocation;

public class EnchantmentDamageHeal extends Enchantment
{
	public EnchantmentDamageHeal(Rarity rarityIn, EnumEnchantmentType typeIn, EntityEquipmentSlot[] slots) 
	{
		super(rarityIn, typeIn, slots);
		this.setName("damage_heal");
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID + ":damage_heal"));
		
		EnchantmentInit.ENCHANTMENTS.add(this);
	}
	
	@Override
	public int getMinEnchantability(int enchantmentLevel) 
	{
		return enchantmentLevel*11;
	}
	
	@Override
	public int getMaxEnchantability(int enchantmentLevel) 
	{
		return super.getMaxEnchantability(enchantmentLevel) * 11;
	}
	
	@Override
	public int getMaxLevel() 
	{
		return 5;
	}
	
	@Override
	protected boolean canApplyTogether(Enchantment ench) 
	{
		if(ench == Enchantments.MENDING)
		{
			return false;
		}
		return true;
	}
}
