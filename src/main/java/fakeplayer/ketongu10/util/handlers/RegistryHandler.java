package fakeplayer.ketongu10.util.handlers;

import fakeplayer.ketongu10.FakePlayer;
import fakeplayer.ketongu10.commands.autopilot.CommandAutopilot;
import fakeplayer.ketongu10.commands.forceToMove.CommandForceToMove;
import fakeplayer.ketongu10.commands.teleport.CommandTeleportDim;
import fakeplayer.ketongu10.commands.video.CommandVideoSaving;
import fakeplayer.ketongu10.objects.blocks.silver_chest.RenderSilverChest;
import fakeplayer.ketongu10.recipes.CraftingRecipes;
import fakeplayer.ketongu10.recipes.SmeltingRecipes;
import fakeplayer.ketongu10.world.gen.WorldGenOres;
import fakeplayer.ketongu10.world.test.WorldTypeTest;
import fakeplayer.ketongu10.init.BiomeInit;
import fakeplayer.ketongu10.init.BlockInit;
import fakeplayer.ketongu10.init.DimensionInit;
import fakeplayer.ketongu10.init.EnchantmentInit;
import fakeplayer.ketongu10.init.EntityInit;
import fakeplayer.ketongu10.init.FluidInit;
import fakeplayer.ketongu10.init.ItemInit;
import fakeplayer.ketongu10.init.OreDictionaryInit;
import fakeplayer.ketongu10.objects.blocks.silver_chest.TileEntitySilverChest;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.world.WorldType;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber
public class RegistryHandler 
{
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void onModelRegister(ModelRegistryEvent event)
	{
		FakePlayer.proxy.registerItemRenderer(Item.getItemFromBlock(BlockInit.SILVER_CHEST), 0, "inventory");
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySilverChest.class, new RenderSilverChest());
		RenderHandler.registerCustomMeshesAndStates();
		RenderHandler.registerEntityRenders();
		for(Item item : ItemInit.ITEMS)
		{
			FakePlayer.proxy.registerItemRenderer(item, 0, "inventory");
		}
		
		for(Block block : BlockInit.BLOCKS)
		{
			FakePlayer.proxy.registerItemRenderer(Item.getItemFromBlock(block), 0, "inventory");
		}
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
	{
		//BlockInit.getBlocks();
		event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
		TileEntityHandler.registerTileEntities();
	}
	
	@SubscribeEvent
	public static void registerEnchant(RegistryEvent.Register<Enchantment> event)
	{
		event.getRegistry().registerAll(EnchantmentInit.ENCHANTMENTS.toArray(new Enchantment[0]));
	}
	
	public static void preInitRegistries(FMLPreInitializationEvent event)
	{
		FluidInit.registerFluids();
		DimensionInit.registerDimensions();
		BiomeInit.registerBiomes();
		GameRegistry.registerWorldGenerator(new WorldGenOres(), 3);
		EntityInit.registerEntities();
		EventHandler.registerEvents();
		SoundsHandler.registerSounds();
		ConfigHandler.registerConfig(event);
	}
	
	public static void initRegistries()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(FakePlayer.instance, new GuiHandler());
		SmeltingRecipes.init();
		CraftingRecipes.init();
		OreDictionaryInit.registerOres();
		FakePlayer.proxy.render();
		EnumHelper.addArt("Test", "Test", 16, 16, 112, 0);
	}
	
	public static void postInitRegistries()
	{
		@SuppressWarnings("unused")
		WorldType TEST_TYPE = new WorldTypeTest("test");
	}
	
	public static void serverRegistries(FMLServerStartingEvent event)
	{
		event.registerServerCommand(new CommandTeleportDim());
		event.registerServerCommand(new CommandAutopilot());
		event.registerServerCommand(new CommandForceToMove());
		event.registerServerCommand(new CommandVideoSaving());

	}
}
