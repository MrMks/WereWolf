package com.github.MrMks.WereWolf.PlayerDatas.event;

import com.github.MrMks.WereWolf.PlayerDatas.StateJudgement;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/7.
 */
public class StateListener implements Comparable<StateListener>{
    private Integer level = 7;             //监听优先级
    private Integer life = -1;             //监听激活后有效回合数
    private Integer wait = 0;              //监听激活前等待回合数
    private ArrayList<StateJudgement> judgement;             //条件判断
    private ArrayList<Event> events;               //监听后行为

    public ArrayList<StateJudgement> getJudgements(){
        return judgement;
    }

    public ArrayList<Event> getEvents(){
        return events;
    }

    @Override
    public int compareTo(StateListener o) {
        if(this.level > o.level) return 1;
        else if(this.level < o.level) return -1;
        else return 0;
    }

}
