package fakeplayer.ketongu10.capabilities.loader;

import fakeplayer.ketongu10.capabilities.ModCapabilities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ProviderEntityCL implements ICapabilityProvider {
    private static final Map<Class<? extends EntityLiving>, Supplier<ChunkLoaderCapability<?>>> capabilityMap =
            new HashMap<Class<? extends EntityLiving>, Supplier<ChunkLoaderCapability<?>>>();


    public static void makeMap() {
        //capabilityMap.put(EntityVillager.class, TravellerData::new);
    }
    private ChunkLoaderCapability<?> capability;

    public ProviderEntityCL(Entity entity) {
        if(capabilityMap.containsKey(entity.getClass())) {
            capability = capabilityMap.get(entity.getClass()).get();
        }
    }

    public boolean hasCapability() {
        return capability != null;
    }

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == ModCapabilities.CL_CAPABILITY && this.capability != null ? true : false;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if (capability == ModCapabilities.CL_CAPABILITY && this.capability != null) {
            return (T) this.capability;
        }
        return null;
    }
}
