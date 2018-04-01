package com.github.MrMks.Werewolf_V3.TabCompleter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.LinkedHashMap;
import java.util.List;

public class TabCompleterManager implements TabCompleter{

    private LinkedHashMap<String,SuperTabCompleter> tabList = new LinkedHashMap<>();
    private SuperTabCompleter tabCompleter_void = new TabCompleter_Void();
    public TabCompleterManager(){
        tabList.put("join",new TabCompleter_Join());
    }
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        String[] arg = new String[strings.length - 1];
        System.arraycopy(strings, 1, arg, 0, strings.length);
        return getTabCompleter(strings[0]).onTabComplete(commandSender,command,s,arg);
    }

    public SuperTabCompleter getTabCompleter(String s){
        return tabList.getOrDefault(s,tabCompleter_void);
    }
}
