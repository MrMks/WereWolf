package com.github.MrMks.Werewolf_V3.Player;

public interface GameData {
    void turnOnSwitch(int switchIndex);
    void turnOffSwitch(int switchIndex);
    boolean isSwitchOn(int switchIndex);

    void setVariable(int variableIndex,int number);
    void addVariable(int variableIndex,int number);
    void subtractVariable(int variableIndex, int number);
    void resetVariable(int variableIndex);
    int getVariable(int variableIndex);

    void setKilled(boolean ver);
    boolean isKilled();

    void setPunished(boolean ver);
    boolean isPunished();

    void setKiller(Number player);
    Number getKiller();

    String getJobUniqueName();

    String getJobDisplayName();

    String getJobIndex();

    boolean hasJobPermission(String permissionCode);

    boolean isWin();

    String getSkillDescription(Number skillIndexInPlayer);

    String getJobDescription();
}
