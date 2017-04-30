package com.github.MrMks.WereWolf;

import com.github.MrMks.WereWolf.Charater.WPlayer;

import java.util.LinkedHashMap;

/**
 * Created by Mirora_Mikasa on 2017/3/12.
 */
public class DataTable {
    public LinkedHashMap<String,String> NameList;
    // PlayerName -> FakeName
    public LinkedHashMap<String, WPlayer> PlayerList;
    // FakeName -> WolfPlayer
    public Integer time;

    public Integer player_number = 0;
    public LinkedHashMap string_joblist;
    public LinkedHashMap jobList;
}
