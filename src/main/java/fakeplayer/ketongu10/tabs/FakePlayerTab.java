package fakeplayer.ketongu10.tabs;

import fakeplayer.ketongu10.init.ItemInit;

import fakeplayer.ketongu10.util.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FakePlayerTab extends CreativeTabs
{
	public FakePlayerTab(String label)
	{
		super("fakeplayertab");
		//this.setBackgroundImageName("fakeplayer.png");
	}
	
	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(ItemInit.OBSIDIAN_INGOT);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public net.minecraft.util.ResourceLocation getBackgroundImage()
	{
		return new net.minecraft.util.ResourceLocation(Reference.MOD_ID + ":textures/tab/fakeplayer.png");
	}
}
