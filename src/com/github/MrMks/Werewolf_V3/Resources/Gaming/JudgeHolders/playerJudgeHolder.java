package com.github.MrMks.Werewolf_V3.Resources.Gaming.JudgeHolders;

import com.github.MrMks.Werewolf_V3.Resources.Gaming.AdditionArgument;
import com.github.MrMks.Werewolf_V3.Resources.Gaming.BaseArgument;

public class playerJudgeHolder {
    private BaseArgument base = null;
    private AdditionArgument addition = null;
    private roomJudgeHolder room = null;

    public playerJudgeHolder(BaseArgument base, AdditionArgument addition){
        this.base = base;
        this.addition = addition;
    }

    public void setRoom(roomJudgeHolder room) {
        this.room = room;
    }

    public boolean run(){
        return room.run(base,addition);
    }
}
