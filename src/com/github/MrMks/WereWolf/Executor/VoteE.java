package com.github.MrMks.WereWolf.Executor;

import com.github.MrMks.WereWolf.Charater.WPlayer;
import com.github.MrMks.WereWolf.DataTable;
import org.bukkit.entity.Player;

import java.util.LinkedHashMap;

/**
 * Created by Mirora_Mikasa on 2017/3/12.
 * methods in this class are all require a counter
 * /ww start or /ww vote
 */
class VoteE {

    private DataTable data;
    private LinkedHashMap<String, Integer> VoteRecord;
    private LinkedHashMap<String, String> SubVoteRecord;
    private Integer StartRecord = 0;

    VoteE(DataTable data) {
        this.data = data;
    }

    // /ww vote player
    // /ww start

    void act(Player sender, String[] args) {
        switch (args[0]) {
            case "vote":
            case "v":
                vote(sender, args);
                break;
            case "start":
                start(sender);
                break;
        }

    }

    private void vote(Player sender, String[] args) {
        if (!player_exist(sender)) {
            sender.sendMessage("you aren't a player in or a spectator of this game");
            return;
        }
        if (args.length == 1) {
            sender.sendMessage("this command required a Name,but you didn't give your target's Name\n" +
                    "use \"/ww name\" to get a list of players' Name");
            return;
        }
        VoteRecord.put(args[2],VoteRecord.get(args[2]) == null ? 1 : VoteRecord.get(args[2]) + 1);
        SubVoteRecord.put(args[2],data.NameList.get(sender.getName()));
    }

    private void start(Player sender) {
        if(!sender_to_wplayer(sender).visitor && player_exist(sender)) StartRecord += 1;
    }

    Integer getStartRecord(){return StartRecord;}

    private boolean player_exist(Player sender) {return data.NameList.get(sender.getName()) != null;}
    private WPlayer sender_to_wplayer(Player sender) {
        return data.PlayerList.get(data.NameList.get(sender.getName()));
    }
}