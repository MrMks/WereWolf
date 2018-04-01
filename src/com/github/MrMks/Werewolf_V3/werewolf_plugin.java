package com.github.MrMks.Werewolf_V3;

import com.github.MrMks.Werewolf_V3.Commands.CommandManager;
import com.github.MrMks.Werewolf_V3.TabCompleter.TabCompleterManager;
import org.bukkit.plugin.java.JavaPlugin;

public class werewolf_plugin extends JavaPlugin {
    @Override
    public void onLoad() {
        super.onLoad();
        CommandManager cmdManager = new CommandManager();
        TabCompleterManager tabCompleter = new TabCompleterManager();
        getCommand("ww").setExecutor(cmdManager);
        getCommand("ww").setTabCompleter(tabCompleter);
        getCommand("wwt").setExecutor(cmdManager.getExecute("talk"));
        getCommand("wwt").setTabCompleter(tabCompleter.getTabCompleter("talk"));
        getCommand("wwj").setExecutor(cmdManager.getExecute("join"));
        getCommand("wws").setExecutor(cmdManager.getExecute("skill"));
        getCommand("wwv").setExecutor(cmdManager.getExecute("vote"));
        getCommand("wwe").setExecutor(cmdManager.getExecute("exit"));
    }
}
