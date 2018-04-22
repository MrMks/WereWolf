package com.github.MrMks.Werewolf_V3.Command.CommandExecutor.Executors;

import com.github.MrMks.Werewolf_V3.Command.CommandArgs;
import com.github.MrMks.Werewolf_V3.Command.CommandExecutor.CommandExecutor;
import com.github.MrMks.Werewolf_V3.Command.CommandExecutor.CommandManager;
import com.github.MrMks.Werewolf_V3.Command.CommandExecutor.CommandReturn;
import com.github.MrMks.Werewolf_V3.Command.CommandSource;

public class Test implements CommandExecutor {
    static {
        //CommandManager.addCommandExecutor("test",new Test());
    }

    @Override
    public CommandReturn execute(CommandSource src, CommandArgs args) {
        return CommandReturn.unSignedCommand();
    }

}
