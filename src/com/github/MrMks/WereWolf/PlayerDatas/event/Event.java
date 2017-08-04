package com.github.MrMks.WereWolf.PlayerDatas.event;

import com.github.MrMks.WereWolf.PlayerDatas.Action;
import com.github.MrMks.WereWolf.PlayerDatas.Judgement;

/**
 * Created by Mirora_Mikasa on 2017/3/25.
 */
public class Event implements Comparable<Event>{
    public Action action;         //行为
    private int level;
    public Judgement judgement;
    private Boolean cancellable = true;
    private Boolean alive = true;

    Event(Boolean cancellable){
        this.cancellable = cancellable;
    }

    public void cancel() {
        if(cancellable) this.alive = false;
    }

    public boolean cancelled(){
        return alive;
    }

    @Override
    public int compareTo(Event o){
        if(this.level > o.level) return 1;
        else if(this.level < o.level) return -1;
        else {
            if(action_level(this.action.act) > action_level(o.action.act)) return 1;
            else if(action_level(this.action.act) < action_level(o.action.act)) return -1;
            else return 0;
        }
    }

    private int action_level(String act) {
        switch (act){
            case "kill":
                return 9;
            case "force_kill":
                return 8;
            case "relive":
                return 7;
            case "know":
                return 6;
            case "change":
                return 5;
            case "arg":
                return 4;
            case "switch":
                return 3;
            default:
                return 0;
        }
    }
}
