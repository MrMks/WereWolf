package com.github.MrMks.WereWolf.executor;

import com.github.MrMks.WereWolf.GlobalData;
import com.github.MrMks.WereWolf.base.Base;
import com.github.MrMks.WereWolf.GameMaster;

import java.util.UUID;

/**
 * Created by Mirora_Mikasa on 2017/5/24.
 */
class RoomE {
    static void execute(String[] args, UUID uuid){
        switch (args[1]){
            case "new":
                mkRoom(args[2],uuid);
                break;
            case "del":
                delRoom(Integer.valueOf(args[2]));
                break;
            case "list":
                break;
        }
    }

    private static void mkRoom(String RoomName,UUID uuid){
        GameMaster r = new GameMaster();
        r.setMasterName(Base.getPlayerName(uuid));
        r.setRoomName(RoomName);

        GlobalData.addRoom(r);
    }

    private static void delRoom(int RoomIndex){}
}
