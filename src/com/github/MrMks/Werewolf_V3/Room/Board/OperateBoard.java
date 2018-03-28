package com.github.MrMks.Werewolf_V3.Room.Board;

import com.github.MrMks.Werewolf_V3.Player.PlayerData;
import com.github.MrMks.Werewolf_V3.Resources.Gaming.AdditionArgument;
import com.github.MrMks.Werewolf_V3.Resources.Gaming.BaseArgument;

import java.util.LinkedHashMap;

public class OperateBoard {
    private LinkedHashMap<Integer,Integer> roomToGlobal;

    public OperateBoard(LinkedHashMap<Integer,Integer> roomToGlobal){
        this.roomToGlobal = roomToGlobal;
    }
    private BaseArgument getBaseArgument(Integer tar){
        return PlayerData.getPlayerData(tar).getBaseArgument();
    }

    private AdditionArgument getAdditionArgument(Integer tar){
        return PlayerData.getPlayerData(tar).getAdditionArgument();
    }

    public void kill(Integer target){
        getAdditionArgument(target).kill();
    }

    public void setKiller(Integer tar,Integer src){
        getBaseArgument(tar).setKILLER(src);
    }

    public void revive(Integer target){
        getAdditionArgument(target).revive();
    }

}
