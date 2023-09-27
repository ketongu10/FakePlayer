package fakeplayer.ketongu10.capabilities.loader;

import fakeplayer.ketongu10.capabilities.ModCapabilities;
import fakeplayer.ketongu10.entity.FakePlayer.IChunkLoaderEntity;
import fakeplayer.ketongu10.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeChunkManager.LoadingCallback;
import net.minecraftforge.common.ForgeChunkManager.Ticket;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

public final class ChunkLoader implements LoadingCallback {

    public static final ChunkLoader INSTANCE = new ChunkLoader();
    private static final String TILE_POSITION_TAG = "tilePosition";

    private ChunkLoader() {

    }

    @Override
    public void ticketsLoaded(List<Ticket> tickets, World world) {
        for (Ticket tk : tickets) {
            if (!tk.isPlayerTicket() && tk.getModId().startsWith(Reference.MOD_ID) && tk.getModData().hasKey(TILE_POSITION_TAG)) {
                this.getEntity(world, tk.getEntity(), IChunkLoaderEntity.class).ifPresent(t -> t.setTicket(tk));
                //this.getEntityData(world, tk.getEntity().getCapability(ModCapabilities.CL_CAPABILITY, null), ChunkLoaderCapability.class).ifPresent(t -> t.setTicket(tk));
                if (tk.getEntity().hasCapability(ModCapabilities.CL_CAPABILITY, null)) {
                    tk.getEntity().getCapability(ModCapabilities.CL_CAPABILITY, null).setTicket(tk);
                }
            }
        }
    }

    public void writeDataToTicket(Ticket tk, BlockPos pos, EntityLiving entityLiving) {
        tk.getModData().setLong(TILE_POSITION_TAG, pos.toLong());
        tk.bindEntity(entityLiving);
    }

    public static <T> Optional<T> getTile(@Nullable IBlockAccess world, @Nullable BlockPos pos, Class<T> teClass) {
        if (world == null || pos == null) {
            return Optional.empty();
        }

        TileEntity te = world.getTileEntity(pos);

        if (teClass.isInstance(te)) {
            return Optional.of(teClass.cast(te));
        }

        return Optional.empty();
    }

    public static <T> Optional<T> getEntity(@Nullable IBlockAccess world, @Nullable Entity entityLiving, Class<T> teClass) {
        if (world == null || entityLiving.getPosition() == null) {
            return Optional.empty();
        }


        if (teClass.isInstance(entityLiving)) {
            return Optional.of(teClass.cast(entityLiving));
        }

        return Optional.empty();
    }
    public static <T> Optional<T> getEntityData(@Nullable IBlockAccess world, @Nullable ChunkLoaderCapability entityData, Class<T> teClass) {
        if (world == null || entityData == null) {
            return Optional.empty();
        }


        if (teClass.isInstance(entityData)) {
            return Optional.of(teClass.cast(entityData));
        }

        return Optional.empty();
    }

}
