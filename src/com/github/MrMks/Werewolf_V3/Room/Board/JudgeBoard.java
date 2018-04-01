package com.github.MrMks.Werewolf_V3.Room.Board;

import com.github.MrMks.Werewolf_V3.Player.PlayerData;
import com.github.MrMks.Werewolf_V3.Resources.Gaming.AdditionArgument;

import java.util.LinkedHashMap;

public class JudgeBoard {
    private LinkedHashMap<Integer,Integer> jobAlivePlayer;
    private LinkedHashMap<Integer,Integer> jobDeadPlayer;
    private LinkedHashMap<String,Integer> fictionAlivePlayer;
    private LinkedHashMap<String,Integer> fictionDeadPlayer;
    private LinkedHashMap<Integer,Integer> roomToGlobal;

    public JudgeBoard(LinkedHashMap<Integer,Integer> jobAlivePlayer,
                      LinkedHashMap<Integer,Integer> jobDeadPlayer,
                      LinkedHashMap<String,Integer> fictionAlivePlayer,
                      LinkedHashMap<String,Integer> fictionDeadPlayer,
                      LinkedHashMap<Integer,Integer> roomToGlobal){
        this.fictionAlivePlayer = fictionAlivePlayer;
        this.fictionDeadPlayer = fictionDeadPlayer;
        this.jobAlivePlayer = jobAlivePlayer;
        this.jobDeadPlayer = jobDeadPlayer;
        this.roomToGlobal = roomToGlobal;
    }

    private AdditionArgument getAdditionArgument(Integer tar){
        return PlayerData.getPlayerDataOfIndex(tar).getAdditionArgument();
    }

    public boolean isAlive(Integer target){
        return getAdditionArgument(target).isAlive();
    }

    public boolean isSwitchOn(Integer target,Integer index){
        return getAdditionArgument(target).isSwitchOn(index);
    }

    public boolean isVariableEqualTo(Integer tar,Integer index,Integer value){
        return getAdditionArgument(tar).getVariable(index) == value;
    }

    public boolean isJobIndexEqualTo(Integer tar,Integer jobIndex){
        return getAdditionArgument(tar).getJobIndex() == jobIndex;
    }

    public boolean isFictionNameEqualTo(Integer tar,String FictionName){
        return getAdditionArgument(tar).getFictionName().equalsIgnoreCase(FictionName);
    }

    public boolean isFictionAliveMemberLessThan(String fiction,Integer value){
        return fictionAlivePlayer.get(fiction) < value;
    }

    public boolean isFictionAliveMemberMoreThan(String fiction,Integer value){
        return fictionAlivePlayer.get(fiction) > value;
    }

    public boolean isFictionAliveMemberEqualTo(String fiction,Integer value){
        return fictionAlivePlayer.get(fiction).equals(value);
    }
}
