package com.github.MrMks.Werewolf_V3.Room;

import com.github.MrMks.Werewolf_V3.Player.PlayerData;
import com.github.MrMks.Werewolf_V3.Room.Board.JudgeBoard;
import com.github.MrMks.Werewolf_V3.Room.Board.OperateBoard;
import com.github.MrMks.Werewolf_V3.Room.Progress.WereWolfGameProgress;
import com.github.MrMks.Werewolf_V3.Room.Progress.WereWolfGameProgressControl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

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

    public static List<Integer> getRoomIndexList(){
        return new ArrayList<>(roomList.keySet());
    }


    private PlayerData creator = null;
    private Integer index = 0;

    private Integer inRoom_next_index = 0;
    private Integer inRoom_freshed_index;

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
        this.creator = creator;
    }

    private void setIndex(Integer index){
        this.index = index;
    }

    public void joinRoom(String name,String nickname){
        PlayerData player = PlayerData.getPlayerData(name,nickname);
        player.setRoomIndex(index);
        player.setInRoomIndex(inRoom_next_index++);

        roomToGlobal.put(player.getGlobalIndex(), player.getInRoomIndex());
    }

    public void exitRoom(Integer GlobalIndex){
        inRoom_freshed_index = GlobalIndex;

        PlayerData player = PlayerData.getPlayerDataOfIndex(GlobalIndex);
        player.setInRoomIndex(-1);
        player.setRoomIndex(-1);

        Integer in_room_index = globalToRoom.get(GlobalIndex);

        roomToGlobal.remove(in_room_index);
        globalToRoom.remove(GlobalIndex);

        while (inRoom_freshed_index + 1 < inRoom_next_index){
            Integer g = roomToGlobal.get(inRoom_freshed_index + 1);
            roomToGlobal.remove(inRoom_freshed_index + 1);
            roomToGlobal.put(inRoom_freshed_index,g);

            globalToRoom.remove(g);
            globalToRoom.put(g,inRoom_freshed_index);

            PlayerData.getPlayerDataOfIndex(g).setInRoomIndex(inRoom_freshed_index);

            inRoom_freshed_index += 1;
        }
        inRoom_freshed_index = -1;
        inRoom_next_index -= 1;
    }

}
