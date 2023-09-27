package fakeplayer.ketongu10.network.packets;

import fakeplayer.ketongu10.FakePlayer;
import fakeplayer.ketongu10.util.interfaces.IMachineStateContainer;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketUpdateEnergy implements IMessage
{
	private int energy;
	private int progress;
    
    public PacketUpdateEnergy(int energy, int progress)
    {
        this.energy = energy;
        this.progress = progress;
    }
    
    public PacketUpdateEnergy()
    {
    	
    }
    
    @Override
    public void fromBytes(ByteBuf buf)
    {
        energy = buf.readInt();
        progress = buf.readByte();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(energy);
        buf.writeByte(progress);
    }

    public static class Handler implements IMessageHandler<PacketUpdateEnergy, IMessage>
    {
        @Override
        public IMessage onMessage(PacketUpdateEnergy message, MessageContext ctx)
        {
        	FakePlayer.proxy.addScheduledTaskClient(() -> handle(message, ctx));
            return null;
        }
        
        private void handle(PacketUpdateEnergy message, MessageContext ctx)
        {
            EntityPlayer player = FakePlayer.proxy.getClientPlayer();
            if (player.openContainer instanceof IMachineStateContainer)
            {
               ((IMachineStateContainer) player.openContainer).sync(message.energy, message.progress);
            }
        }
    }
}
