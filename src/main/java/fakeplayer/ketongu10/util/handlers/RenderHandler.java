package fakeplayer.ketongu10.util.handlers;

import fakeplayer.ketongu10.entity.FakePlayer.EntityFakePlayer;
import fakeplayer.ketongu10.entity.FakePlayer.FakePlayerRenderer;
import fakeplayer.ketongu10.entity.test.RenderTest;
import fakeplayer.ketongu10.init.BlockInit;
import fakeplayer.ketongu10.util.Reference;
import fakeplayer.ketongu10.entity.diamondArrow.EntityDiamondArrow;
import fakeplayer.ketongu10.entity.diamondArrow.RenderDiamondArrow;
import fakeplayer.ketongu10.entity.test.EntityTest;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPigZombie;
import net.minecraft.client.renderer.entity.RenderZombie;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderHandler 
{
	public static void registerCustomMeshesAndStates()
	{
		ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(BlockInit.WHITE_WATER_FLUID), new ItemMeshDefinition()
		{	
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) 
			{
				return new ModelResourceLocation(Reference.MOD_ID + ":white_water", "fluid");
			}
		});
		
		ModelLoader.setCustomStateMapper(BlockInit.WHITE_WATER_FLUID, new StateMapperBase() 
		{
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) 
			{
				return new ModelResourceLocation(Reference.MOD_ID + ":white_water", "fluid");
			}
		});
	}

	public static void registerEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityTest.class, new IRenderFactory<EntityTest>()
		{
			@Override
			public Render<? super EntityTest> createRenderFor(RenderManager manager) 
			{
				return new RenderTest(manager);
			}
		});

		RenderingRegistry.registerEntityRenderingHandler(EntityFakePlayer.class, new IRenderFactory<EntityFakePlayer>()
		{
			@Override
			public Render<? super EntityFakePlayer> createRenderFor(RenderManager manager)
			{
				return new FakePlayerRenderer(manager);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityDiamondArrow.class, new IRenderFactory<EntityDiamondArrow>() 
		{
			@Override
			public Render<? super EntityDiamondArrow> createRenderFor(RenderManager manager) 
			{
				return new RenderDiamondArrow(manager);
			}
		});
	}
}
