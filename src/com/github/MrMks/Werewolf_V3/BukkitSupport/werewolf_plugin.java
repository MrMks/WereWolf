package com.github.MrMks.Werewolf_V3.BukkitSupport;

import com.github.MrMks.Werewolf_V3.BukkitSupport.Commands.WerewolfCommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class werewolf_plugin extends JavaPlugin {
    @Override
    public void onEnable() {
        super.onEnable();
        this.getCommand("ww").setExecutor(new WerewolfCommandExecutor());
    }

    @Override
    public void onLoad() {
        super.onLoad();
        getLogger().info("werewolf plugin loaded");
    }
}
