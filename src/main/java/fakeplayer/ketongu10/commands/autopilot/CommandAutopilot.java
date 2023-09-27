package fakeplayer.ketongu10.commands.autopilot;

import com.google.common.collect.Lists;
import fakeplayer.ketongu10.commands.teleport.CustomTeleport;
import fakeplayer.ketongu10.proxy.ClientProxy;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

import java.util.Collections;
import java.util.List;

public class CommandAutopilot extends CommandBase
{
	private final List<String> aliases = Lists.newArrayList("aplt", "autopilot");
	
	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException 
	{

		sender.sendMessage(new TextComponentString(TextFormatting.RED + "Autopilot activated!"));
		AutopilotAI.setActivated(true);
	}
	
	@Override
	public String getName() 
	{
		return "aplt";
	}
	
	@Override
	public String getUsage(ICommandSender sender) 
	{
		return "aplt <id>";
	}
	
	@Override
	public List<String> getAliases() 
	{
		return aliases;
	}
	
	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) 
	{
		return true;
	}
	
	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos targetPos) 
	{
		return Collections.emptyList();
	}
}