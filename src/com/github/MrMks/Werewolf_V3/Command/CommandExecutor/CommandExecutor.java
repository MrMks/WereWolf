package com.github.MrMks.Werewolf_V3.Command.CommandExecutor;

import com.github.MrMks.Werewolf_V3.Command.CommandArgs;
import com.github.MrMks.Werewolf_V3.Command.CommandSource;

public interface CommandExecutor {
    CommandReturn execute(CommandSource src, CommandArgs args);
}
