package com.github.MrMks.Werewolf_V3.Resources.Gaming;

public class AdditionArgument {
    private boolean alive = true;
    private int jobIndex = 0;
    private String fictionName = null;
    private boolean[] switches = new boolean[10];
    private int[] variable = new int[10];

    public boolean isAlive(){
        return alive;
    }

    public void kill(){
        alive = false;
    }

    public void revive(){
        alive = true;
    }

    public void setJobIndex(int jobIndex) {
        this.jobIndex = jobIndex;
    }

    public int getJobIndex() {
        return jobIndex;
    }

    public void setFictionName(String fictionName) {
        this.fictionName = fictionName;
    }

    public String getFictionName() {
        return fictionName;
    }

    public boolean isSwitchOn(int index){
        return switches[index - 1];
    }

    public void turnSwitchOn(int index){
        switches[index -1] = true;
    }

    public void turnSwitchOff(int index){
        switches[index - 1] = false;
    }

    public void resetSwitches(){
        for(int i = 0;i <= 9;i++){
            switches[i] = false;
        }
    }

    public int getVariable(int index){
        return variable[index - 1];
    }

    public void setVariable(int index,int value){
        variable[index - 1] = value;
    }

    public void addVariable(int index){
        addVariable(index,1);
    }

    public void addVariable(int index,int value){
        variable[index - 1] += value;
    }

    public void subtractVariable(int index){
        subtractVariable(index,1);
    }

    public void subtractVariable(int index, int value) {
        variable[index - 1] += value;
    }

    public void resetVariable(){
        for(int i = 0;i <= 9;i++){
            variable[i] = 0;
        }
    }
}
