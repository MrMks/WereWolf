package com.github.MrMks.Werewolf_V3.Utils;

public interface DisplayName extends DisplayNameReader,DisplayNameWriter{
    @Override
    void setDisplayName(String name);

    @Override
    String getDisplayName();
}
