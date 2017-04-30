package com.github.MrMks.WereWolf.Event;

/**
 * Created by Mirora_Mikasa on 2017/3/25.
 */
public class Event {
    public String action;         //行为
    public String self;           //指定"self"
    public String target;         //指定"target"
    public String[] args;         //行为参数
    public Boolean cancellable = true;
    public Boolean alive;

    Event(String action,String self,String target,String[] args,Boolean cancellable){
        this.action = action;
        this.target = target;
        this.self = self;
        this.args = args;
        this.cancellable = cancellable;
        this.alive = true;
    }

    public void cancel() {
        this.alive = false;
    }
}
