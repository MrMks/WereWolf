package com.github.MrMks.Werewolf_V3.LocaleLang;

import java.util.LinkedHashMap;
import java.util.Locale;

public class LocaleCode {

    private String source;
    private LocaleCode(String string){
        source = string;
    }

    public String getTrabslatedMessage(){
        return list.getOrDefault(source,"unknown locale code");
    }

    public static LocaleCode of(String string){
        return new LocaleCode(string);
    }


    private static LinkedHashMap<String,String> list;
    public static void init(){
        Locale locale = Locale.getDefault();
        list = new LinkedHashMap<>();
        list.put("command.unknown","未知指令");
    }
}
