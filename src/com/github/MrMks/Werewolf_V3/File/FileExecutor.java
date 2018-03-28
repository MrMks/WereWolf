package com.github.MrMks.Werewolf_V3.File;

public interface FileExecutor {
    <T> T executeTo(String[] strings,Class<T> tClass);
}
