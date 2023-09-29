package fakeplayer.ketongu10;

import java.io.File;

import fakeplayer.ketongu10.capabilities.ModCapabilities;
import fakeplayer.ketongu10.capabilities.loader.ChunkLoader;
import fakeplayer.ketongu10.capabilities.loader.ProviderEntityCL;
import fakeplayer.ketongu10.network.packets.PacketRequestUpdateEnergy;
import fakeplayer.ketongu10.proxy.CommonProxy;
import fakeplayer.ketongu10.tabs.FakePlayerTab;
import fakeplayer.ketongu10.network.packets.PacketUpdateEnergy;
import fakeplayer.ketongu10.util.Reference;
import fakeplayer.ketongu10.util.handlers.RegistryHandler;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.ForgeChunkManager;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = Reference.MOD_ID, version = Reference.VERSION, name = Reference.NAME)
public class FakePlayer
{
	public static SimpleNetworkWrapper network;
	
	public static File config;
	
	@Instance
	public static FakePlayer instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final CreativeTabs fakeplayerTAB = new FakePlayerTab("fakeplayertab");
	
	static
	{
		FluidRegistry.enableUniversalBucket();
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		RegistryHandler.preInitRegistries(event);
		network = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);
		network.registerMessage(PacketUpdateEnergy.Handler.class, PacketUpdateEnergy.class, 0, Side.CLIENT);
		network.registerMessage(PacketRequestUpdateEnergy.Handler.class, PacketRequestUpdateEnergy.class, 1, Side.SERVER);
		ForgeChunkManager.setForcedChunkLoadingCallback(this, ChunkLoader.INSTANCE);
		ModCapabilities.registerCapabilities();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{

		RegistryHandler.initRegistries();
		ProviderEntityCL.makeMap();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		RegistryHandler.postInitRegistries();
	}
	
	@EventHandler
	public void serverInit(FMLServerStartingEvent event)
	{
		RegistryHandler.serverRegistries(event);
	}


}
