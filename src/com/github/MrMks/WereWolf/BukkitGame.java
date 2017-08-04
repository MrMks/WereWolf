package com.github.MrMks.WereWolf;

import com.github.MrMks.WereWolf.base.Base;
import com.github.MrMks.WereWolf.executor.CommandManager;
import com.github.MrMks.WereWolf.loader.FileReader;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Mirora_Mikasa on 2017/3/12.
 */
public class BukkitGame extends JavaPlugin{

    public void onLoad(){
        Base.setLibrary(0);
        FileReader.folder = this.getDataFolder();
        FileReader.Init();
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if(sender instanceof Player) CommandManager.execute((Player) sender,command,args);
        if(CommandManager.all_start()) game_start();
        return true;
    }

    private void game_start(){

    }
}
