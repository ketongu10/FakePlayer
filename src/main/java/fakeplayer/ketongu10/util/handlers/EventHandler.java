package fakeplayer.ketongu10.util.handlers;

import fakeplayer.ketongu10.events.*;
import net.minecraftforge.common.MinecraftForge;

public class EventHandler 
{
	public static void registerEvents()
	{
		EventExample exampleEvent = new EventExample();
		EntityEvents entityEvents = new EntityEvents();
		TicksEvent keyDeny = new TicksEvent();
		CapabilityEvent capEvent = new CapabilityEvent();


		MinecraftForge.EVENT_BUS.register(exampleEvent);
		MinecraftForge.EVENT_BUS.register(keyDeny);
		MinecraftForge.EVENT_BUS.register(entityEvents);
		MinecraftForge.EVENT_BUS.register(capEvent);
	}
}
