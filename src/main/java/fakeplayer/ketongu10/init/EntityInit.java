package fakeplayer.ketongu10.init;

import fakeplayer.ketongu10.FakePlayer;
import fakeplayer.ketongu10.entity.FakePlayer.EntityFakePlayer;
import fakeplayer.ketongu10.entity.diamondArrow.EntityDiamondArrow;
import fakeplayer.ketongu10.entity.magiball.EntityMagiball;
import fakeplayer.ketongu10.entity.test.EntityTest;
import fakeplayer.ketongu10.util.Reference;
import fakeplayer.ketongu10.util.handlers.ConfigHandler;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.datafix.fixes.SpawnEggNames;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit 
{
	public static void registerEntities()
	{
		registerEntity("test", EntityTest.class, ConfigHandler.ENTITY_TEST, 50, 13310623, 65354);
		registerEntity("fake_player", EntityFakePlayer.class, ConfigHandler.ENTITY_FAKEPLAYER, 50, 13210623, 61354);
		registerArrow("diamond_arrow", EntityDiamondArrow.class, ConfigHandler.ENTITY_DIAMOND_ARROW);
		registerProjectile("magiball", ConfigHandler.ENTITY_MAGIBALL, EntityMagiball.class, ItemInit.MAGIBALL);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, FakePlayer.instance, range, 1, true, color1, color2);
	}
	
	private static void registerArrow(String name, Class<? extends Entity> entity, int id)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, FakePlayer.instance, 64, 20, true);
	}
	
	private static void registerProjectile(String name, int id, Class<? extends Entity> entity, Item item)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(name), entity, name, id, FakePlayer.instance, 64, 10, true);
	}

}