package com.github.MrMks.WereWolf.Executor;

import com.github.MrMks.WereWolf.DataTable;
import org.bukkit.entity.Player;

/**
 * Created by Mirora_Mikasa on 2017/3/12.
 */
public class VoteE {

    DataTable data;

    public VoteE(DataTable data){
        this.data = data;
    }
    
    // /ww conviction player
    // /ww start
    
    public void act(Player sender, String[] args){
        switch(args[0]){
            case "conviction":
            case "c":
                conviction(sender,args[1]);
                break;
            case "start":
                start(sender);
                break;
        }

    }

}
