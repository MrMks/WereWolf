package com.github.MrMks.Werewolf_V3.Utils;

public interface UniqueName extends UniqueNameReader,UniqueNameWriter{
    @Override
    void setUniqueName(String name);

    @Override
    String getUniqueName();
}
