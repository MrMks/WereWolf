package com.github.MrMks.Werewolf_V3.BukkitSupport.TabCompleter;

import com.github.MrMks.Werewolf_V3.Command.CommandArgs;
import com.github.MrMks.Werewolf_V3.Command.CommandSourceBukkit;
import com.github.MrMks.Werewolf_V3.Command.TabCompleter.TabCompleterManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class WerewolfTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        CommandSourceBukkit source = new CommandSourceBukkit(commandSender);
        LinkedList<String> allArgs = new LinkedList<>(Arrays.asList(strings));

        String subCommandLabel = allArgs.pollFirst();
        CommandArgs subCommandArgs = new CommandArgs(allArgs);

        return TabCompleterManager.complete(source,subCommandLabel,subCommandArgs);
    }
}
