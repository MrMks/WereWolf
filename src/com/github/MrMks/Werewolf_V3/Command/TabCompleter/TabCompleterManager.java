package com.github.MrMks.Werewolf_V3.Command.TabCompleter;


import com.github.MrMks.Werewolf_V3.Command.CommandArgs;
import com.github.MrMks.Werewolf_V3.Command.CommandSource;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class TabCompleterManager{
    private static LinkedHashMap<String,TabCompleter> list = new LinkedHashMap<>();
    public static void addTabCompleter(String key,TabCompleter tabCompleter){
        list.put(key, tabCompleter);
    }

    public static List<String> complete(CommandSource src, String label, CommandArgs args){
        return list.getOrDefault(label,(a,b)-> Collections.emptyList()).complete(src,args);
    }
}
