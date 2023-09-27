package fakeplayer.ketongu10.commands.forceToMove;

import com.google.common.base.Predicates;
import fakeplayer.ketongu10.entity.FakePlayer.EntityFakePlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

import java.util.List;

public class Move {

    public Move(WorldServer world, double x, double y, double z) {

    }

    public static void findAndStart(EntityPlayerMP sender, float range) {
        //List<Entity> list = sender.world.<Entity>getEntitiesWithinAABB(EntityFakePlayer.class, sender.getEntityBoundingBox().grow((double)range, 3.0D, (double)range));
        List<Entity> list = sender.world.loadedEntityList;
        for (Entity e: list) {
            if (e instanceof EntityFakePlayer) {
                ((EntityFakePlayer) e).shouldFolow = true;
                ((EntityFakePlayer) e).moveTo = sender.getPosition();
            }
        }
    }



}
