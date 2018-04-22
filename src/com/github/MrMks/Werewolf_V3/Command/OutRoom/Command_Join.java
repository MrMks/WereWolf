package com.github.MrMks.Werewolf_V3.Command.OutRoom;

import com.github.MrMks.Werewolf_V3.Player.PlayerData;
import com.github.MrMks.Werewolf_V3.Room.Room;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Command_Join implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        switch (strings.length) {
            case 0:
                commandSender.sendMessage("you didn't choose a room");
                break;
            case 1:
                if (PlayerData.getPlayerDataOfName(commandSender.getName()).getRoomIndex() != -1) {
                    commandSender.sendMessage("you can't join another room before you exit");
                    break;
                } else {
                    if (is_not_exist_room(strings[0])) commandSender.sendMessage("you choose a invalid room");
                    else joinRoom(strings[0], commandSender.getName(), commandSender.getName());
                    break;
                }
            case 2:
                if (PlayerData.getPlayerDataOfName(commandSender.getName()).getRoomIndex() != -1) {
                    commandSender.sendMessage("you can't join another room before you exit");
                    break;
                }else if (is_not_exist_room(strings[0])){
                    commandSender.sendMessage("you choose a invalid room");
                    break;
                } else if (PlayerData.getPlayerDataOfNickname(strings[1]) != null){
                    commandSender.sendMessage("your nickname have been used");
                    break;
                } else {
                    joinRoom(strings[0], commandSender.getName(), strings[1]);
                    break;
                }
            default:
                commandSender.sendMessage("//wwj [roomIndex] <nickname> \nor\n //ww join [roomIndex] <nickname");
        }
        return true;
    }

    private boolean is_not_exist_room(String roomIndex){
        return Room.getRoom(Integer.valueOf(roomIndex)) == null;
    }

    private void joinRoom(String room,String name,String nickname){
        Room r = Room.getRoom(Integer.valueOf(room));
        r.joinRoom(name,nickname);
    }
}
