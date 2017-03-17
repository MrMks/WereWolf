package com.github.MrMks.WereWolf.Executor;

import com.github.MrMks.WereWolf.DataTable;
import org.bukkit.entity.Player;

/**
 * Created by Mirora_Mikasa on 2017/3/12.
 */
public class CommonE {

    DataTable data;

    public CommonE(DataTable data){
        this.data = data;
    }
    
    // /ww join

    public void act(Player sender, String[] args){
        switch(args[0]){
            case "join":
            case "j":
                String FakeName = sender.getName();
                if(args[].length == 2) FakeName = args[1];
                join(sender,FakeName);
                break;
            case "visit":
                visit(sender);
                break;
        }
    }
}
