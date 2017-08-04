package com.github.MrMks.WereWolf.base;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Created by Mirora_Mikasa on 2017/7/12.
 */
public class Base {
    private static int library = 0;

    public static void setLibrary(int s){
        library = s;
    }

    public static UUID getUUID(Player player){
        if(library == 0) {return Base.getUUID(player);}
        return null;
    }

    public static Player getPlayer(UUID uuid){
        if(library == 0) {return Bukkit.getPlayer(uuid);}
        return null;
    }

    public static boolean isOnline(UUID uuid){
        if (library == 0) {return Bukkit.getPlayer(uuid) != null;}
        return false;
    }

    public static void sendMessage(UUID uuid,String message){
        if(isOnline(uuid)){
            if (library == 0) Bukkit.getPlayer(uuid).sendMessage(message);
        }
    }

    public static String getPlayerName(UUID uuid) {
        if (library == 0) return getPlayer(uuid).getName();
        return null;
    }
}
