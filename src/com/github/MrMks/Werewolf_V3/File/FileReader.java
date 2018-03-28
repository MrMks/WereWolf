package com.github.MrMks.Werewolf_V3.File;

import java.io.FileInputStream;

public interface FileReader {
    public String[] read(String path);

    public String[] read(FileInputStream pathStream);

}
