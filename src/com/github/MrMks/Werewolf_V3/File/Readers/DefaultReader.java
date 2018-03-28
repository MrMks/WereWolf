package com.github.MrMks.Werewolf_V3.File.Readers;

import com.github.MrMks.Werewolf_V3.File.FileReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DefaultReader implements FileReader {

    @Override
    public String[] read(String path) {
        try {
            FileInputStream fileStream = new FileInputStream(path);
            return read(fileStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new String[0];
        }
    }

    @Override
    public String[] read(FileInputStream pathStream) {
        Scanner reader = new Scanner(pathStream);
        ArrayList<String> stringArrayList = new ArrayList<>();
        while (reader.hasNextLine()) stringArrayList.add(reader.nextLine());
        try {
            pathStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringArrayList.toArray(new String[0]);
    }
//test
    public static void main(String[] args) {
        for (String str : new DefaultReader().read("D:\\Notepad++\\change.log")) {
            System.out.println(str);
        }
    }
}