package com.github.MrMks.Werewolf_V3.Resources.Gaming;

import com.github.MrMks.Werewolf_V3.Room.Board.JudgeBoard;

public interface Judge {
    boolean judge(BaseArgument base, AdditionArgument addition, JudgeBoard judgeBoard);
}
