package fakeplayer.ketongu10.capabilities.loader;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeChunkManager;

public abstract class ChunkLoaderCapability<T extends EntityLiving> {
    protected T orgEntity;
    protected boolean tileEntityInvalid;
    ForgeChunkManager.Ticket chunkTicket = null;

    /**public ChunkLoaderCapability() {
        System.out.println("Cap constructed");
    }**/

    public void onEntityConstructed(T entityIn) {
        this.orgEntity = entityIn;
    }

    public void onEntityJoinWorld(World world) {
        System.out.println("Smth happened");
        if (orgEntity instanceof EntityVillager) {
            ((EntityVillager)this.orgEntity).setProfession(1);
            ((EntityVillager)this.orgEntity).getDisplayName().appendText(" the Loh");
        }
        if (!world.isRemote) {
            //ChunkLoader.getEntity(world, this.orgEntity, orgEntity.getClass()).ifPresent(ChunkLoaderCapability::setupInitialTicket);
            this.setupInitialTicket();
            //((EntityVillager)this.orgEntity).setProfession(1);
            //((EntityVillager)this.orgEntity).getDisplayName().appendText(" the Loh");
            /**ChunkLoader.getEntityData(world, this.orgEntity.getCapability(ModCapabilities.CL_CAPABILITY, null),
                    this.orgEntity.getCapability(ModCapabilities.CL_CAPABILITY, null).getClass())
                    .ifPresent(ChunkLoaderCapability::setupInitialTicket);**/
        }
    }

    public void releaseTicket() {
        ForgeChunkManager.releaseTicket(chunkTicket);
        chunkTicket = null;
    }

    /**@Override
    public void setDead() {
        ChunkLoader.getEntity(world, this, EntityFakePlayer.class).ifPresent(EntityFakePlayer::releaseTicket);
        super.setDead();
    }**/

    public void setTicket(ForgeChunkManager.Ticket tk) {
        if (this.chunkTicket != tk) {
            releaseTicket();
            if (tk != null) {
                this.chunkTicket = tk;
                forceTicketChunks();
            }
        }
    }

    public void setupInitialTicket() {
        this.chunkTicket = ForgeChunkManager.requestTicket(fakeplayer.ketongu10.FakePlayer.instance, orgEntity.world, ForgeChunkManager.Type.ENTITY);
        if (this.chunkTicket != null) {
            writeDataToTicket();
            forceTicketChunks();
        }
    }


    protected void writeDataToTicket() {
        ChunkLoader.INSTANCE.writeDataToTicket(chunkTicket, this.orgEntity.getPosition(), this.orgEntity);
    }

    protected void forceTicketChunks() {
        int cx = this.orgEntity.getPosition().getX() >> 4;
        int cz = this.orgEntity.getPosition().getZ() >> 4;
        for (int x = cx - 1; x <= cx + 1; x++) {
            for (int z = cz - 1; z <= cz + 1; z++) {
                ChunkPos chunkPos = new ChunkPos(x, z);
                ForgeChunkManager.forceChunk(this.chunkTicket, chunkPos);
            }
        }
        //TODO either uncomment and log chunk loading info or just remove this
        //  AWLog.logDebug("ticket now has chunks: "+tk.getChunkList());
        //  AWLog.logDebug("total forced chunks are: "+ForgeChunkManager.getPersistentChunksFor(world));
    }
}
