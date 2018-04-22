package com.github.MrMks.Werewolf_V3.Command.CommandExecutor;

import com.github.MrMks.Werewolf_V3.Command.CommandArgs;
import com.github.MrMks.Werewolf_V3.Command.CommandExecutor.CommandExecutor;
import com.github.MrMks.Werewolf_V3.Command.CommandExecutor.CommandReturn;
import com.github.MrMks.Werewolf_V3.Command.CommandExecutor.Executors.Test;
import com.github.MrMks.Werewolf_V3.Command.CommandSource;

import java.util.LinkedHashMap;

public class CommandManager {
    private static LinkedHashMap<String,CommandExecutor> commandList = new LinkedHashMap<>();
    public static void addCommandExecutor(String key,CommandExecutor executor){
        commandList.put(key, executor);
    }

    /*public static void execute(CommandSource src, String label, CommandArgs args){
        CommandReturn commandReturn = commandList.getOrDefault(label,(a, b)->CommandReturn.unSignedCommand()).execute(src, args);
        commandReturn.feedBack(src);
    }*/

    public void execute(CommandSource src, String label, CommandArgs args){
        commandList.put("test",new Test());
        CommandReturn commandReturn = commandList.getOrDefault(label,(a, b)->CommandReturn.unSignedCommand()).execute(src, args);
        commandReturn.feedBack(src);
    }


}