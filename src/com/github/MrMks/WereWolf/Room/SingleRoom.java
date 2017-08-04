package com.github.MrMks.WereWolf.Room;

import com.github.MrMks.WereWolf.PlayerDatas.charater.WPlayer;

import java.util.LinkedHashMap;
import java.util.UUID;

/**
 * Created by Mirora_Mikasa on 2017/5/23.
 */
public class SingleRoom {
    public LinkedHashMap<UUID,String> PlayerNameList = new LinkedHashMap<>();
    public LinkedHashMap<String,WPlayer> PlayerList = new LinkedHashMap<>();
    public LinkedHashMap<UUID,String> VisitorNameList = new LinkedHashMap<>();
    public LinkedHashMap<String,WPlayer> VisitorList = new LinkedHashMap<>();
}
