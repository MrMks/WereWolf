package com.github.MrMks.WereWolf.PlayerDatas.charater;

import com.github.MrMks.WereWolf.PlayerDatas.StateJudgement;
import com.github.MrMks.WereWolf.base.Base;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Mirora_Mikasa on 2017/3/12.
 */
public class WPlayer {
    public UUID uuid;
    public String FakeName;
    public String TARGET;
    public String KILLER;
    public Player player;
    public Boolean visitor = false;
    public Boolean ready = false;
    public Boolean start = false;
    public Boolean dead = false;
    public String JobName;
    public ArrayList<Channel> channels;
    public Channel channel;
    public String faction;
    public ArrayList<StateJudgement> VictimJudgement;
    public ArrayList<Skill> skills;
    public ArrayList<Ability> abilities;
    public boolean Switch[] = new boolean[50];
    public int Variety[] = new int[50];

    // visit
    public WPlayer(UUID uuid){
        this.visitor = true;
        this.uuid = uuid;
    }

    // join
    public WPlayer(UUID uuid,String fakeName){
        this.uuid = uuid;
        this.FakeName = fakeName;
    }

    public void sendMessage(String message){
        Base.sendMessage(this.uuid,message);
    }
}
