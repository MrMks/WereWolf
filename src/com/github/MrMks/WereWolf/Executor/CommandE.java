package com.github.MrMks.WereWolf.Executor;

import com.github.MrMks.WereWolf.DataTable;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by Mirora_Mikasa on 2017/3/12.
 */
public class CommandE {

    private DataTable data;
    private CommonE common = new CommonE(data);
    private GmE gm = new GmE(data);
    private VoteE vote = new VoteE(data);

    public CommandE(DataTable data){
        this.data = data;
    }

    public void Act(Player sender, Command cmd, String[] args){
        switch(args[0]){
            case "vote":
            case "v":
            case "start":
                vote.act(sender,args);
                break;
            case "gm":
                if(sender.hasPermission("werewolf.gm")) {
                    gm.act(args);
                } else {
                    sender.sendMessage("you have no permission to do this.");
                }
                break;
            default:
                common.act(sender,args);
                break;
        }
    }
}
