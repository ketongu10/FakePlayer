package fakeplayer.ketongu10.events;

import fakeplayer.ketongu10.capabilities.ModCapabilities;
import fakeplayer.ketongu10.entity.FakePlayer.EntityFakePlayer;
import net.minecraft.entity.EntityLiving;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EntityEvents {

    @SubscribeEvent
    public void entityEvent(LivingSpawnEvent event)
    {
        if(event.getEntity() instanceof EntityFakePlayer) {
            ((EntityFakePlayer) event.getEntity()).onEntityJoinWorld(event.getWorld());
        }
        if (event.getEntity().getCapability(ModCapabilities.CL_CAPABILITY, null) != null) {
            event.getEntity().getCapability(ModCapabilities.CL_CAPABILITY, null).onEntityJoinWorld(event.getWorld());
        }

    }


}