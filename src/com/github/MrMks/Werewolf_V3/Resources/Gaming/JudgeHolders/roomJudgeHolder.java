package com.github.MrMks.Werewolf_V3.Resources.Gaming.JudgeHolders;

import com.github.MrMks.Werewolf_V3.Resources.Gaming.AdditionArgument;
import com.github.MrMks.Werewolf_V3.Resources.Gaming.BaseArgument;
import com.github.MrMks.Werewolf_V3.Resources.Gaming.Judge;
import com.github.MrMks.Werewolf_V3.Room.Board.JudgeBoard;

public class roomJudgeHolder {
    private JudgeBoard board = null;
    private Judge judge = null;

    public roomJudgeHolder(JudgeBoard board, Judge judge){
        this.board = board;
        this.judge = judge;
    }

    boolean run(BaseArgument base, AdditionArgument addition){
        return judge.judge(base,addition,board);
    }
}
