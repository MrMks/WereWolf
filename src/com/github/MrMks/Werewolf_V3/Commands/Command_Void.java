package com.github.MrMks.Werewolf_V3.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class Command_Void implements SuperCommand {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage("unknown command");
        return true;
    }
}
