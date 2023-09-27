package fakeplayer.ketongu10.capabilities.loader;

import net.minecraft.entity.EntityLiving;

public class TravellerData<T extends EntityLiving> extends ChunkLoaderCapability<T>{

    public TravellerData() {
        System.out.println("Cap constructed");
    }
}
