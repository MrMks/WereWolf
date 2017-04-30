package com.github.MrMks.WereWolf.Event;

/**
 * Created by Administrator on 2017/4/7.
 */
public class Listener {
    private Integer level = 7;             //监听优先级
    private Integer life = -1;             //监听激活后有效回合数
    private Integer wait = 0;              //监听激活前等待回合数
    public String action;                  //监听行为
    public String[] args;                  //监听行为参数
    public String[] judgement;             //条件判断
    public String[] conduct;               //监听后行为

    Listener(String action, String[] args, String[] judgement, String[] conduct){
        this.action = action;
        this.args = args;
        this.judgement = judgement;
        this.conduct = conduct;
    }

    Listener(String action, String[] args, String[] judgement, String[] conduct, Integer level){
        this.action = action;
        this.args = args;
        this.judgement = judgement;
        this.conduct = conduct;
        this.level = level;
    }

    Listener(String action, String[] args, String[] judgement, String[] conduct, Integer level, Integer life){
        this.action = action;
        this.args = args;
        this.judgement = judgement;
        this.conduct = conduct;
        this.level = level;
        this.life = life;
    }

    Listener(String action, String[] args, String[] judgement, String[] conduct, Integer level, Integer life, Integer wait){
        this.action = action;
        this.args = args;
        this.judgement = judgement;
        this.conduct = conduct;
        this.level = level;
        this.life = life;
        this.wait = wait;
    }

    public boolean available(){return wait != 0 || life != 0;}
    public int getLevel() {return this.level;}

}
