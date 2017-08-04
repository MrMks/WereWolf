package com.github.MrMks.WereWolf.PlayerDatas.event;

import com.github.MrMks.WereWolf.PlayerDatas.Action;

import java.util.ArrayList;

/**
 * Created by Mirora_Mikasa on 2017/7/12.
 */
public class ActListener {
    private Integer level = 7;             //监听优先级
    private Integer life = -1;             //监听激活后有效回合数
    private Integer wait = 0;              //监听激活前等待回合数
    private Action action;                  //监听行为
    private ArrayList<Action> conduct;               //监听后行为

}
