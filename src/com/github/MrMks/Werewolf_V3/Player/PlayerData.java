package com.github.MrMks.Werewolf_V3.Player;

import com.github.MrMks.Werewolf_V3.Resources.Gaming.AdditionArgument;
import com.github.MrMks.Werewolf_V3.Resources.Gaming.BaseArgument;
import com.github.MrMks.Werewolf_V3.Resources.Gaming.JudgeHolders.playerJudgeHolder;
import com.github.MrMks.Werewolf_V3.Resources.Gaming.OperateHolders.playerOperHolder;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class PlayerData {
    private static LinkedHashMap<Integer,PlayerData> globalPlayerList = new LinkedHashMap<>();
    private static LinkedList<Integer> recycle_index = new LinkedList<>();
    private static Integer next_index= 1;

    public static PlayerData createPlayerData(String name,String fackname){
        PlayerData player;
        player = new PlayerData(recycle_index.isEmpty() ? next_index++ : recycle_index.pollLast(),
                name,fackname);
        globalPlayerList.put(player.identity.index,player);
        return player;
    }

    public static PlayerData getPlayerData(Integer index){
        return globalPlayerList.get(index);
    }

    private Identity identity;
    //private GameData gameData;
    private BaseArgument baseArgument = new BaseArgument();
    private AdditionArgument additionArgument = new AdditionArgument();
    private playerJudgeHolder judgeHolder = new playerJudgeHolder(baseArgument,additionArgument);
    private playerOperHolder operHolder = new playerOperHolder(baseArgument,additionArgument);

    public PlayerData(Integer integer, String name, String fackname) {
        this.identity = new Identity(integer,name,fackname);
    }

    public Identity getIdentity(){
        return identity;
    }

    public BaseArgument getBaseArgument(){
        return baseArgument;
    }

    public AdditionArgument getAdditionArgument() {
        return additionArgument;
    }

    public playerJudgeHolder getJudgeHolder() {
        return judgeHolder;
    }

    public playerOperHolder getOperHolder() {
        return operHolder;
    }
}

