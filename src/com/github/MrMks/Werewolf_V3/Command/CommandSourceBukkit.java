package com.github.MrMks.Werewolf_V3.Command;

import com.github.MrMks.Werewolf_V3.LocaleLang.LocaleCode;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CommandSourceBukkit extends CommandSource {
    public CommandSourceBukkit(CommandSender src){
        this.sender = src;
        if(src instanceof Player) type = SourceType.PLAYER;
        else if (src instanceof ConsoleCommandSender) type = SourceType.CONSOLE;
        else if (src instanceof BlockCommandSender) type = SourceType.COMMAND_BLOCK;
    }

    private CommandSender sender;
    @Override
    public String getName() {
        return sender.getName();
    }

    private SourceType type;
    @Override
    public SourceType getType() {
        return type;
    }

    @Override
    public boolean hasPermission(String permission) {
        return sender.hasPermission(permission);
    }

    @Override
    public void sendMessage(LocaleCode msg) {
        sender.sendMessage(msg.getTrabslatedMessage());
    }
}
