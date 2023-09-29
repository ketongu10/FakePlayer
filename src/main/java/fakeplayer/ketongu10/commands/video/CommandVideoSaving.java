package fakeplayer.ketongu10.commands.video;

import com.google.common.collect.Lists;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

import java.util.Collections;
import java.util.List;

public class CommandVideoSaving extends CommandBase {

    private final List<String> aliases = Lists.newArrayList("video");

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        if (!VideoHelper.isActivated) {
            sender.sendMessage(new TextComponentString(TextFormatting.GREEN + "Video saving was started!"));
            VideoHelper.startRecording();
        } else {
            sender.sendMessage(new TextComponentString(TextFormatting.RED + "Video saving stopped!"));
            VideoHelper.stopRecording();
        }
    }

    @Override
    public String getName()
    {
        return "video";
    }

    @Override
    public String getUsage(ICommandSender sender)
    {
        return "video <no args>";
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
