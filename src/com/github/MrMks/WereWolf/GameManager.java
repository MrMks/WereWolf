package com.github.MrMks.WereWolf;

import com.github.MrMks.WereWolf.Executor.CommandManager;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Mirora_Mikasa on 2017/3/12.
 */
public class GameManager extends JavaPlugin{

    private DataTable data = new DataTable();
    private CommandManager commandManager = new CommandManager(data);

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if(sender instanceof Player) commandManager.Act((Player) sender,command,args);
        if(commandManager.all_start()) game_start();
        return true;
    }

    private void game_start(){

    }
}
