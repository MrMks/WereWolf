package com.github.MrMks.Werewolf_V3.Resources.Gaming;


public interface Job {
    void addSkill(Number skillIndex,String skillDescription);
    String getSkillDescription(Number skillIndex);

    void setWinningCondition(JudgeHolder judgeHolder);
    boolean isWin();

    void setDescription(String description);
    String getDescription();

}
