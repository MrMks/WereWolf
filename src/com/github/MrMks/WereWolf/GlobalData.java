package com.github.MrMks.WereWolf;

import com.github.MrMks.WereWolf.Room.SingleRoom;

import java.util.LinkedHashMap;
import java.util.UUID;

/**
 * Created by Mirora_Mikasa on 2017/3/12.
 */
public class GlobalData {
    private static LinkedHashMap<String,SingleRoom> RoomList;
    private static LinkedHashMap<UUID,String[]> FullPlayerList;
    private static LinkedHashMap JobList;

    public static boolean isInOneRoom(){}

    public static boolean isInSameRoom(){}

    public static boolean isVisitor(){}

    public static boolean isExistRoom(){}

    public static void setJobList(LinkedHashMap jobList){JobList = jobList;}

    public static LinkedHashMap getJobList(){
        return JobList;
    }

}
