package com.github.MrMks.Werewolf_V3.Resources.Gaming.OperateHolders;

import com.github.MrMks.Werewolf_V3.Resources.Gaming.AdditionArgument;
import com.github.MrMks.Werewolf_V3.Resources.Gaming.BaseArgument;
import com.github.MrMks.Werewolf_V3.Resources.Gaming.Operate;
import com.github.MrMks.Werewolf_V3.Room.Board.OperateBoard;

public class roomOperHolder {
    private OperateBoard board = null;
    private Operate oper = null;

    public roomOperHolder(OperateBoard board, Operate oper){
        this.board = board;
        this.oper = oper;
    }

    public void run(BaseArgument base, AdditionArgument addition){
        oper.operate(base,addition,board);
    }
}
