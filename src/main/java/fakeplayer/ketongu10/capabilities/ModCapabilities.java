package fakeplayer.ketongu10.capabilities;

import fakeplayer.ketongu10.capabilities.loader.ChunkLoaderCapability;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ModCapabilities {
    @CapabilityInject(ChunkLoaderCapability.class)
    public static final Capability<ChunkLoaderCapability<?>> CL_CAPABILITY = null;



    public static void registerCapabilities() {

        CapabilityManager.INSTANCE.register(ChunkLoaderCapability.class, new Capability.IStorage<ChunkLoaderCapability>() {
            @Override
            public NBTBase writeNBT(Capability<ChunkLoaderCapability> capability, ChunkLoaderCapability instance,
                                    EnumFacing side) {
                return null;
            }

            @Override
            public void readNBT(Capability<ChunkLoaderCapability> capability, ChunkLoaderCapability instance, EnumFacing side,
                                NBTBase nbt) {

            }
        }, () -> null);


    }

}
