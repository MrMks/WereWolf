package com.github.MrMks.Werewolf_V3.File.Executors;

import com.github.MrMks.Werewolf_V3.File.FileExecutor;
import com.github.MrMks.Werewolf_V3.Resources.Gaming.Job;
import com.github.MrMks.Werewolf_V3.Resources.Gaming.Skill;

public class DefalutExecutor implements FileExecutor {
    @Override
    public <T> T executeTo(String[] strings, Class<T> tClass) {
        if(tClass.getName().equals(Job.class.getName())) return executeToJob(strings,tClass);
        else if(tClass.getName().equals(Skill.class.getName())) return executeToSkill(strings,tClass);
        return null;
    }

    private <T> T executeToSkill(String[] strings,Class<T> klass) {
        return (T) new Skill();
    }

    private <T> T executeToJob(String[] strings,Class<T> klass) {
        try {
            T t = klass.newInstance();

            return t;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return (T) new Job();
        }
    }

}
