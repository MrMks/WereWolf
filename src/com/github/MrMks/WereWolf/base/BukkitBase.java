package com.github.MrMks.WereWolf.base;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Created by Mirora_Mikasa on 2017/5/7.
 */
 class BukkitBase {
    public static UUID getUUID(Player player){
        return player.getUniqueId();
    }

    public static Player getPlayer(UUID uuid){
        return Bukkit.getPlayer(uuid);
    }

    public static boolean isOnline(UUID uuid){
        return Bukkit.getPlayer(uuid) != null;
    }

    public static void sendMessage(UUID uuid,String message){
        if(isOnline(uuid)){
            Bukkit.getPlayer(uuid).sendMessage(message);
        }
    }

    public static String getPlayerName(UUID uuid) {
        return getPlayer(uuid).getName();
    }
}
