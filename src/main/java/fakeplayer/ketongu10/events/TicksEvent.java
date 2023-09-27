package fakeplayer.ketongu10.events;

import fakeplayer.ketongu10.commands.autopilot.AutopilotAI;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class TicksEvent {

    @SuppressWarnings("unused")
    @SubscribeEvent
    public void KeyboardEvent(TickEvent.ClientTickEvent event)
    {
        AutopilotAI.tick();

    }


}
