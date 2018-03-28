package com.github.MrMks.Werewolf_V3.Player;

public class Identity {
    Integer index;
    String real;
    String nick;
    Identity(Integer index,String n,String f){
        this.index = index;
        real = n;
        nick = f.length() == 0 ? n : f;
    }
    String getRealName(){
        return real;
    }
    String getNickname(){
        return nick;
    }
    Integer getIndex(){
        return index;
    }
}
