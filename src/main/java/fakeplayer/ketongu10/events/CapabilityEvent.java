package fakeplayer.ketongu10.events;

import fakeplayer.ketongu10.capabilities.loader.ChunkLoaderCapability;
import fakeplayer.ketongu10.capabilities.ModCapabilities;
import fakeplayer.ketongu10.capabilities.loader.ProviderEntityCL;
import fakeplayer.ketongu10.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid= Reference.MOD_ID)
public class CapabilityEvent {

    @SubscribeEvent
    public static void attachEntityCapability(AttachCapabilitiesEvent<Entity> event) {
        if(event.getObject().getCapability(ModCapabilities.CL_CAPABILITY, null) == null) {
            ProviderEntityCL prov = new ProviderEntityCL(event.getObject());
            if(prov.hasCapability()) {
                ChunkLoaderCapability entityCap = prov.getCapability(ModCapabilities.CL_CAPABILITY, null);
                entityCap.onEntityConstructed((EntityLiving) event.getObject());
                event.addCapability(new ResourceLocation(Reference.MOD_ID, "entity_cap"), prov);
            }
        }



    }
}
