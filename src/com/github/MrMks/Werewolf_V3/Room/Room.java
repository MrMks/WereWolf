package com.github.MrMks.Werewolf_V3.Room;

import com.github.MrMks.Werewolf_V3.Player.PlayerData;
import com.github.MrMks.Werewolf_V3.Room.Board.JudgeBoard;
import com.github.MrMks.Werewolf_V3.Room.Board.OperateBoard;
import com.github.MrMks.Werewolf_V3.Room.Progress.WereWolfGameProgress;
import com.github.MrMks.Werewolf_V3.Room.Progress.WereWolfGameProgressControl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Room {

    static private LinkedHashMap<Integer,Room> roomList = new LinkedHashMap<>();
    static private LinkedList<Integer> freshed_index = new LinkedList<>();
    static private Integer next_index = 1;

    static public Room createNewRoom(PlayerData creator){
        Room new_room = new Room();
        Integer index;
        if(freshed_index.isEmpty()) index = next_index++;
        else index = freshed_index.pollLast();
        new_room.setIndex(index);
        new_room.setCreator(creator);
        roomList.put(index,new_room);
        return new_room;
    }

    static public Room getRoom(Integer roomIndex){
        return roomList.get(roomIndex);
    }

    static public void removeRoom(Integer roomIndex){
        roomList.remove(roomIndex);
        if(roomIndex + 1 == next_index) next_index -= 1;
        else freshed_index.add(roomIndex);
    }

    private PlayerData creaton = null;
    private Integer index = 0;

    private LinkedHashMap<Integer,Integer> jobAlivePlayer = new LinkedHashMap<>();
    private LinkedHashMap<Integer,Integer> jobDeadPlayer = new LinkedHashMap<>();
    private LinkedHashMap<String,Integer> fictionAlivePlayer = new LinkedHashMap<>();
    private LinkedHashMap<String,Integer> fictionDeadPlayer = new LinkedHashMap<>();
    private LinkedHashMap<Integer,Integer> roomToGlobal = new LinkedHashMap<>();
    private LinkedHashMap<Integer,Integer> globalToRoom = new LinkedHashMap<>();

    private OperateBoard operBoard = new OperateBoard(roomToGlobal);
    private JudgeBoard judgeBoard = new JudgeBoard(jobAlivePlayer,jobDeadPlayer,fictionAlivePlayer,fictionDeadPlayer,roomToGlobal);

    private WereWolfGameProgress progress = WereWolfGameProgress.compose(operBoard,judgeBoard);
    private WereWolfGameProgressControl progressContral = null;

    private Room() {
    }

    private void setCreator(PlayerData creator){
        this.creaton = creator;
    }

    private void setIndex(Integer index){
        this.index = index;
    }

}
