package com.github.MrMks.Werewolf_V3.Command;

import com.github.MrMks.Werewolf_V3.LocaleLang.LocaleCode;

public abstract class CommandSource {
    public abstract String getName();
    public abstract SourceType getType();
    public abstract boolean hasPermission(String permission);
    public abstract void sendMessage(LocaleCode msg);
}
