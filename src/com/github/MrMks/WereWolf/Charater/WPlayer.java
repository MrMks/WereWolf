package com.github.MrMks.WereWolf.Charater;

import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * Created by Mirora_Mikasa on 2017/3/12.
 */
public class WPlayer {
    public String Name;
    public String FakeName;
    public String TARGET;
    public String KILLER;
    public Player player;
    public Boolean visitor = false;
    public Boolean ready = false;
    public Boolean start = false;
    public Boolean died = false;
    public String JobName;
    public ArrayList<String> channels;
    public String channel;
    public String faction;
    public ArrayList<ArrayList<String>> VictimJudgement;
    public ArrayList<Skill> skills;
    public ArrayList<Ability> abilities;

    // visit
    public WPlayer(Player player,String name){
        this.visitor = true;
        new WPlayer(player,name,name);
    }

    // join
    public WPlayer(Player player,String name,String fakeName){
        this.player = player;
        this.Name = name;
        this.FakeName = fakeName;
    }
}
