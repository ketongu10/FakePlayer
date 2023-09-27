package fakeplayer.ketongu10.commands.forceToMove;

import com.google.common.collect.Lists;
import fakeplayer.ketongu10.commands.teleport.CustomTeleport;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

import java.util.Collections;
import java.util.List;

public class CommandForceToMove extends CommandBase
    {
        private final List<String> aliases = Lists.newArrayList("ftm", "move");

        @Override
        public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
        {
            /**if(args.length < 1) return;
            String s = args[0];
            int range;
            try
            {
                range = Integer.parseInt(s);
            } catch(NumberFormatException e)
            {
                sender.sendMessage(new TextComponentString(TextFormatting.RED + "This is not a range!"));
                return;
            }**/

            sender.sendMessage(new TextComponentString(TextFormatting.GREEN + "Starting to move!"));
            Move.findAndStart(getCommandSenderAsPlayer(sender), (float) 300);

        }

        @Override
        public String getName()
        {
            return "move";
        }

        @Override
        public String getUsage(ICommandSender sender)
        {
            return "move <range>";
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
