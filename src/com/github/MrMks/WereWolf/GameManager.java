package com.github.MrMks.WereWolf;

import com.github.MrMks.WereWolf.Executor.CommandE;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Mirora_Mikasa on 2017/3/12.
 */
public class GameManager extends JavaPlugin{

    private DataTable data = new DataTable();
    private CommandE commandE = new CommandE(data);

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if(sender instanceof Player) commandE.Act((Player) sender,command,args);
        if(commandE.all_start()) game_start();
        return true;
    }

    private void game_start(){

    }
}
