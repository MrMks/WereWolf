package com.github.MrMks.WereWolf.Executor;

import com.github.MrMks.WereWolf.Charater.WPlayer;
import com.github.MrMks.WereWolf.DataTable;
import org.bukkit.entity.Player;


/**
 * Created by Mirora_Mikasa on 2017/3/12.
 * used when player use the follow commands:
 * join / j
 * exit
 * ready / r
 * talk / t
 * select / s
 * name
 */
public class CommonE {

    private DataTable data;

    public CommonE(DataTable data){
        this.data = data;
    }

    public void act(Player sender, String[] args) {
        switch (args[0]) {
            case "join":
            case "j":
                join(sender, args);
                break;
            case "visit":
                visit(sender);
                break;
            case "exit":
                exit(sender);
                break;
            case "ready":
            case "r":
                ready(sender);
                break;
            case "talk":
            case "t":
                talk(sender, args.length == 2 ? args[1] : "");
                break;
            case "select":
            case "s":
                select(sender,args);
                break;
            case "name":
                name_list(sender);
            default:
                sender.sendMessage("no this command");
        }
    }

    // /ww join <FakeName>
    private void join(Player sender,String[] args){
        if(player_exist(sender)){
            sender.sendMessage("you have joined the game");
            return;
        }

        String Name = sender.getName();
        String FakeName = Name;
        if(args.length == 2) FakeName = args[1];

        WPlayer wPlayer = new WPlayer(sender,Name,FakeName);

        data.NameList.put(Name,FakeName);
        data.PlayerList.put(FakeName,wPlayer);
        data.player_number += 1;
    }

    private void visit(Player sender){
        if(player_exist(sender)){
            sender.sendMessage("you are looking on the game");
            return;
        }

        String Name = sender.getName();
        WPlayer wPlayer = new WPlayer(sender,Name);

        data.NameList.put(Name,Name);
        data.PlayerList.put(Name,wPlayer);
    }

    private void exit(Player sender){
        if(!player_exist(sender)){
            sender.sendMessage("you haven't join this game");
            return;
        }

        if(!sender_to_wplayer(sender).visitor) data.player_number -= 1;
        String Name = sender.getName();
        String FakeName = data.NameList.get(Name);
        data.PlayerList.remove(FakeName);
        data.NameList.remove(Name);
    }

    private void ready(Player sender){
        if(!player_exist(sender)){
            sender.sendMessage("you haven't join this game");
            return;
        }

        sender_to_wplayer(sender).ready = true;
        sender.sendMessage("now readied");
    }
    // haven't complete talk command,i can't work it out now.
    private void talk(Player sender,String msg){
        if(!player_exist(sender)) {
            sender.sendMessage("you haven't join this game");
            return;
        }

        StringBuffer full_msg = new StringBuffer();
        full_msg.append(data.NameList.get(sender.getName()));
        full_msg.append(": ").append(msg);

        // keep empty until i can work it out
        for (WPlayer p : data.PlayerList.values()) {
            ;
        }
    }
    // /ww select FakeName
    private void select(Player sender,String[] args){
        if(!player_exist(sender)) {
            sender.sendMessage("you haven't join this game");
            return;
        }

        if(args.length == 1){
            sender.sendMessage("this command requires a \"Name\",but you didn't type your target's Name\n" +
                    "you can use \"/ww name\" to get the list of players' Name");
        }

        sender_to_wplayer(sender).TARGET = args[1];
    }

    private void name_list(Player sender){
        if(!player_exist(sender)){
            sender.sendMessage("you aren't a player or a spectator in this game ");
            return;
        }

        StringBuffer list = new StringBuffer();
        for(WPlayer p:data.PlayerList.values()){
            if(!p.visitor){list.append(p.FakeName + ": " + (p.died ? "died" : "living"));}
        }

        sender.sendMessage(list.toString());
    }

    // return true if player existed.
    private boolean player_exist(Player sender){
        return data.NameList.get(sender.getName()) != null;
    }
    private WPlayer sender_to_wplayer(Player sender) {
        return data.PlayerList.get(data.NameList.get(sender.getName()));
    }
}
