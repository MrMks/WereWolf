package com.github.MrMks.Werewolf_V3.Resources.Gaming.OperateHolders;

import com.github.MrMks.Werewolf_V3.Resources.Gaming.AdditionArgument;
import com.github.MrMks.Werewolf_V3.Resources.Gaming.BaseArgument;

public class playerOperHolder {
    private BaseArgument base = null;
    private AdditionArgument addition = null;
    private roomOperHolder room = null;

    public playerOperHolder(BaseArgument base, AdditionArgument addition){
        this.base = base;
        this.addition = addition;
    }

    public void setRoom(roomOperHolder room) {
        this.room = room;
    }

    public void run(){
        room.run(base,addition);
    }

}
