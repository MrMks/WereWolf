package com.github.MrMks.WereWolf;

import com.github.MrMks.WereWolf.PlayerDatas.charater.WPlayer;
import com.github.MrMks.WereWolf.Room.SingleRoom;
import com.github.MrMks.WereWolf.executor.CommandManager;

import java.util.LinkedHashMap;
import java.util.UUID;

/**
 * Created by Mirora_Mikasa on 2017/5/22.
 */
public class GameMaster implements Runnable{
    private SingleRoom data = new SingleRoom();
    private String RoomName,MasterName;
    private LinkedHashMap<UUID,String> FakeNameList = new LinkedHashMap<>();
    private LinkedHashMap<String,WPlayer> PlayerList = new LinkedHashMap<>();

    @Override
    public void run() {
        GameStart();
    }

    public void setRoomName(String RoomName){
        this.RoomName = RoomName;
    }

    public String getRoomName(){
        return this.RoomName;
    }

    public void setMasterName(String MasterName){
        this.MasterName = MasterName;
    }

    public String getMasterName(){
        return this.MasterName;
    }

    //public void setRoomIndex(int index){}

    private void GameStart(){
        //分配职业
        randomJob();
        do {
            try {
                sleep(3 * 60 * 1000);
                CommandManager.systemCallAll("", this.data);
                sleep(60 * 1000);
                CommandManager.systemCallAll("", this.data);
                sortEvents();
                if (isGameEnd()) break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (isGameEnd());
    }

    private boolean isGameEnd() {

        return false;
    }

    private void randomJob(){}

    private void collectEvent(){}

    private void sortEvents(){}

    private void talk(String msg){}

    private void vote(){}

    private void punish(){}

    private void sleep(int millis) throws InterruptedException{
        Thread.sleep(millis);
    }

    public void addPlayer(WPlayer player) {
        FakeNameList.put(player.uuid,player.FakeName);
        PlayerList.put(player.FakeName,player);
    }
}
