package com.github.MrMks.Werewolf_V3.Resources.Gaming.Operations;

import com.github.MrMks.Werewolf_V3.Resources.Gaming.AdditionArgument;
import com.github.MrMks.Werewolf_V3.Resources.Gaming.BaseArgument;
import com.github.MrMks.Werewolf_V3.Resources.Gaming.Operate;
import com.github.MrMks.Werewolf_V3.Room.Board.OperateBoard;

public class Operate_Kill implements Operate {
    @Override
    public void operate(BaseArgument base, AdditionArgument addition, OperateBoard operateBoard) {
        operateBoard.kill(base.getTARGET());
        operateBoard.setKiller(base.getTARGET(),base.getSELF());
    }
}
