package com.github.MrMks.Werewolf_V3.BukkitSupport.Commands;
import com.github.MrMks.Werewolf_V3.Command.CommandArgs;
import com.github.MrMks.Werewolf_V3.Command.CommandExecutor.CommandManager;
import com.github.MrMks.Werewolf_V3.Command.CommandSourceBukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.LinkedList;

public class WerewolfCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage("test msg in CommandExecutor for bukkit");

        CommandSourceBukkit source = new CommandSourceBukkit(commandSender);
        LinkedList<String> allArgs = new LinkedList<>(Arrays.asList(strings));

        String subCommandLabel = allArgs.pollFirst();
        CommandArgs subCommandArgs = new CommandArgs(allArgs);

        (new CommandManager()).execute(source,subCommandLabel,subCommandArgs);
        return true;
    }
}
