package com.github.MrMks.Werewolf_V3.Utils;

public interface Index extends IndexReader,IndexWriter{
    @Override
    void setIndex(Number index);

    @Override
    Number getIndex();
}
