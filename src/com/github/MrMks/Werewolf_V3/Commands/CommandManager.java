package com.github.MrMks.Werewolf_V3.Commands;

import com.github.MrMks.Werewolf_V3.Commands.InRoom.Command_Exit;
import com.github.MrMks.Werewolf_V3.Commands.InRoom.Command_Skill;
import com.github.MrMks.Werewolf_V3.Commands.InRoom.Command_Talk;
import com.github.MrMks.Werewolf_V3.Commands.InRoom.Command_Vote;
import com.github.MrMks.Werewolf_V3.Commands.OutRoom.Command_Join;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class CommandManager implements CommandExecutor{
    private LinkedHashMap<String,SuperCommand> cmdList = new LinkedHashMap<>();
    private SuperCommand voidCommand = new Command_Void();
    public CommandManager(){
        cmdList.put("join",new Command_Join());
        cmdList.put("exit",new Command_Exit());
        cmdList.put("skill",new Command_Skill());
        cmdList.put("talk",new Command_Talk());
        cmdList.put("vote",new Command_Vote());
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        String[] arg = new String[strings.length - 1];
        System.arraycopy(strings, 1, arg, 0, strings.length);
        return getExecute(strings[0]).onCommand(commandSender,command,s,arg);
    }

    public SuperCommand getExecute(String string) {
        return cmdList.getOrDefault(string,voidCommand);
    }
}
