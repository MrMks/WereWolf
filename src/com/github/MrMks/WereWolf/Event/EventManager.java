package com.github.MrMks.WereWolf.Event;

import java.util.ArrayList;

/**
 * Created by Mirora_Mikasa on 2017/3/25.
 */
public class EventManager {
    private ArrayList<Listener> listeners = new ArrayList<>();
    private ArrayList<ArrayList<Event>> events = new ArrayList<>();

    public void addListener(Listener l){listeners.add(l);}
    public void addEvent(Integer index,Event e){events.get(index).add(e);}


}
