package com.github.MrMks.Werewolf_V3.Command.TabCompleter;

import com.github.MrMks.Werewolf_V3.Command.CommandArgs;
import com.github.MrMks.Werewolf_V3.Command.CommandSource;

import java.util.List;

public interface TabCompleter {
    List<String> complete(CommandSource src, CommandArgs args);
}
