package com.github.MrMks.Werewolf_V3.Player;

import com.github.MrMks.Werewolf_V3.Resources.Gaming.AdditionArgument;
import com.github.MrMks.Werewolf_V3.Resources.Gaming.BaseArgument;
import com.github.MrMks.Werewolf_V3.Resources.Gaming.JudgeHolders.playerJudgeHolder;
import com.github.MrMks.Werewolf_V3.Resources.Gaming.OperateHolders.playerOperHolder;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class PlayerData {
    private static LinkedHashMap<Integer,PlayerData> globalPlayerListWithIndex = new LinkedHashMap<>();
    private static LinkedHashMap<String,PlayerData> globalPlayerListWithName = new LinkedHashMap<>();
    private static LinkedHashMap<String,PlayerData> globalPlayerListWithNickname = new LinkedHashMap<>();
    private static LinkedList<Integer> recycle_index = new LinkedList<>();
    private static Integer next_index= 1;

    public static PlayerData createPlayerData(String name,String nickname){
        PlayerData player;
        player = new PlayerData(recycle_index.isEmpty() ? next_index++ : recycle_index.pollLast(),
                name,nickname);
        globalPlayerListWithIndex.put(player.getGlobalIndex(),player);
        globalPlayerListWithName.put(name,player);
        globalPlayerListWithNickname.put(nickname,player);
        return player;
    }

    public static PlayerData getPlayerData(String name,String nickname){
        if(globalPlayerListWithName.containsKey(name)) return getPlayerDataOfName(name);
        else return createPlayerData(name,nickname);
    }

    public static PlayerData getPlayerDataOfIndex(Integer index){
        return globalPlayerListWithIndex.get(index);
    }

    public static PlayerData getPlayerDataOfName(String name){
        return globalPlayerListWithName.get(name);
    }

    public static PlayerData getPlayerDataOfNickname(String nickname){
        return globalPlayerListWithNickname.get(nickname);
    }


    //boundary
    private Identity identity;
    private GamingData gamingData;
    private BaseArgument baseArgument = new BaseArgument();
    private AdditionArgument additionArgument = new AdditionArgument();
    private playerJudgeHolder judgeHolder = new playerJudgeHolder(baseArgument,additionArgument);
    private playerOperHolder operHolder = new playerOperHolder(baseArgument,additionArgument);

    private PlayerData(Integer integer, String name, String fackname) {
        this.identity = new Identity(integer,name,fackname);
    }

    public String getName(){
        return identity.getRealName();
    }

    public String getNickname(){
        return identity.getNickname();
    }

    public Integer getGlobalIndex(){
        return identity.getIndex();
    }

    public void setInRoomIndex(Integer inIndex){
        gamingData.setInRoomIndex(inIndex);
    }

    public Integer getInRoomIndex(){
        return gamingData.getInRoomIndex();
    }

    public void setRoomIndex(Integer index){
        gamingData.setRoomIndex(index);
    }

    public Integer getRoomIndex(){
        return gamingData.getRoomIndex();
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

