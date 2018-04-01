package com.github.MrMks.Werewolf_V3.TabCompleter;

import com.github.MrMks.Werewolf_V3.Room.Room;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TabCompleter_Join implements SuperTabCompleter{
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        switch (strings.length){
            case 0:
                ArrayList<String> list = new ArrayList<>();
                for (Integer index :
                        Room.getRoomIndexList()) {
                    list.add(index.toString());
                }
                return list;
            case 1:
                return new ArrayList<>(Collections.singleton(commandSender.getName()));
        }
        return null;
    }
}
