package com.github.MrMks.Werewolf_V3.Command.CommandExecutor;

import com.github.MrMks.Werewolf_V3.Command.CommandSource;
import com.github.MrMks.Werewolf_V3.LocaleLang.LocaleCode;

public interface CommandReturn {

    void feedBack(CommandSource src);

    static CommandReturn unSignedCommand(){
        return new CommandReturn() {
            @Override
            public void feedBack(CommandSource src) {
                src.sendMessage(LocaleCode.of("command.unknown"));
            }
        };
    }

    static CommandReturn empty(){
        return (a)->{};
    }



}
