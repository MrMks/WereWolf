package com.github.MrMks.Werewolf_V3.TabCompleter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TabCompleter_Void implements SuperTabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length != 1) return null;
        String[] src = new String[]{"join","exit","talk","vote","skill","room"};
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, src);
        return list;
    }
}
