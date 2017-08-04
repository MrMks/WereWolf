package com.github.MrMks.WereWolf.PlayerDatas;

import com.github.MrMks.WereWolf.PlayerDatas.charater.WPlayer;

/**
 * Created by Mirora_Mikasa on 2017/7/12.
 */
public class StateJudgement {
    private String target,target_ext,stateName,compareMethod,compareValue;
    private int stateIndex;

    public StateJudgement(String target,String target_ext,String stateName,int stateIndex,String compareMethod,String compareValue){
        this.target = target;
        this.target_ext = target_ext;
        this.stateName = stateName;
        this.stateIndex = stateIndex;
        this.compareMethod = compareMethod;
        this.compareValue = compareValue;
    }

    public boolean Match(WPlayer player) {
        boolean value = false;
        if (target.equals("@a")
                || (target.equals("@f") && target_ext.equals(player.faction))
                || (target.equals("@j") && target_ext.equals(player.JobName))
                || target.equals(player.FakeName)
                ) {
            switch(stateName){
                case "dead":
                    value = compare(player.dead.toString(),compareMethod,compareValue);
                    break;
                case "job":
                    value = compare(player.JobName,compareMethod,compareValue);
                    break;
                case "faction":
                    value = compare(player.faction,compareMethod,compareValue);
                    break;
                case "switch":
                    value = compare((player.Switch[stateIndex]),compareMethod,compareValue);
                    break;
                case "variety":
                    value = compare(player.Variety[stateIndex],compareMethod,compareValue);
                    break;
                default:
                    value = false;
            }
        }
        return value;
    }

    private boolean compare(String playerState, String compareMethod, String compareValue) {
        boolean v  = false;
        try{
            switch (compareMethod){
                case "=":
                    v = playerState.equals(compareValue);
                    break;
                case "<>":
                    v = !playerState.equals(compareValue);
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return v;
    }

    private boolean compare(boolean playerState, String compareMethod, String compareValue){
        boolean v = false;
        try {
            switch(compareMethod){
                case "=":
                    v = playerState && Boolean.valueOf(compareValue);
                    break;
                case "<>":
                    v = !(playerState && Boolean.valueOf(compareValue));
                    break;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return v;
    }

    private boolean compare(int playerState, String compareMethod, String compareValue){
        boolean v = false;
        try{
            switch (compareMethod){
                case "=":
                    v = playerState == Integer.valueOf(compareValue);
                    break;
                case "<>":
                    v = !(playerState == Integer.valueOf(compareValue));
                    break;
                case "<":
                    v = playerState < Integer.valueOf(compareValue);
                    break;
                case ">":
                    v = playerState > Integer.valueOf(compareValue);
                    break;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return v;
    }
}
