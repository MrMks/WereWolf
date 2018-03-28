package com.github.MrMks.Werewolf_V3.Resources.Gaming;

import com.github.MrMks.Werewolf_V3.Utils.*;

public interface Job extends Index,UniqueName,DisplayName,Permission{
    void addSkill(Number skillIndex,String skillDescription);
    String getSkillDescription(Number skillIndex);

    void setWinningCondition(JudgeHolder judgeHolder);
    boolean isWin();

    void setDescription(String description);
    String getDescription();

}
