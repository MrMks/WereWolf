package com.github.MrMks.WereWolf.Executor;

import com.github.MrMks.WereWolf.Charater.Ability;
import com.github.MrMks.WereWolf.Charater.Job;
import com.github.MrMks.WereWolf.Charater.Skill;
import com.github.MrMks.WereWolf.DataTable;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Mirora_Mikasa on 2017/3/12.
 *
 */
class JobE {
    private DataTable data;

    public JobE(DataTable data){
        this.data = data;

        Yaml yaml = new Yaml();
        LinkedHashMap<String,Job> joblist = new LinkedHashMap<>();
        try{
            this.data.string_joblist = (LinkedHashMap) yaml.loadAs(
                    new FileInputStream(
                            new File("charater.yml")
                    ), LinkedHashMap.class).get("jobs");
            LinkedHashMap tempList = this.data.string_joblist;
            for(Object key : tempList.keySet()){
                LinkedHashMap singleJob_m = (LinkedHashMap)tempList.get(key);

                Job singleJob = new Job();
                singleJob.JobName = (String) key;
                singleJob.Display = (String) singleJob_m.get("display");
                singleJob.Faction = (String) singleJob_m.get("faction");
                singleJob.Channal = obj_short_ary(singleJob_m.get("channal"));
                singleJob.abilities = AbilityInit(singleJob_m.get("ability"));
                singleJob.skills = SkillInit(singleJob_m.get("skill"));
                singleJob.VictimJudgement = obj_middle_ary(singleJob_m.get("victim"));

                joblist.put(singleJob.JobName,singleJob);
            }
        } catch (Exception e){
            System.out.print("Initialize Error");
        }

        this.data.jobList = joblist;
    }

    private ArrayList<Ability> AbilityInit(Object abilities){
        ArrayList<Ability> list = new ArrayList<>();
        for(Object single : ((ArrayList) abilities)){
            Ability t = new Ability();
            LinkedHashMap singleAbility = ((LinkedHashMap) single);

            t.call = (String)  (singleAbility.get("call"));
            t.ifs =  obj_short_ary( (singleAbility.get("if")) );
            t.dos =  obj_short_ary( (singleAbility.get("do")) );
            t.life = obj_int( singleAbility.get("life") );
            t.wait = obj_int( singleAbility.get("wait") );

            list.add(t);
        }
        return list;
    }

    private ArrayList<Skill> SkillInit(Object skills){
        ArrayList<Skill> list = new ArrayList<>();
        for(Object single : ((ArrayList) skills)){
            LinkedHashMap singleSkill = ((LinkedHashMap) single);
            Skill t = new Skill();

            t.LimitA = obj_int(singleSkill.get("limitA"));
            t.LimitE = obj_int(singleSkill.get("limitE"));
            t.Time = (String) singleSkill.get("time");
            t.amp = obj_int((singleSkill.get("amp")));
            t.failure = obj_long_ary(singleSkill.get("failure"));
            t.success = obj_long_ary(singleSkill.get("success"));
            list.add(t);
        }
        return list;

    }

    private Vector split(String line) {
        Vector<Vector> list = new Vector<>();
        Vector<String> arg1 = new Vector<>(); //action target
        Vector<String> arg2 = new Vector<>(); //@amp,@success,@failed
        Vector<String> arg3 = new Vector<>(); //@listen,@wait,@life,@if,@do,@lv

        for (String word : line.split(" ")) {
            if (word.charAt(0) != '@') {
                arg1.add(word);
            }
        }

        arg2.add(0, subsplit(line, "amp"));
        arg2.add(1, subsplit(line, "success"));
        arg2.add(2, subsplit(line, "fail"));
        arg3.add(0, subsplit(line, "listen"));
        arg3.add(1, subsplit(line, "life"));
        arg3.add(2, subsplit(line, "wait"));
        arg3.add(3, subsplit(line, "if"));
        arg3.add(4, subsplit(line, "do"));
        arg3.add(5, subsplit(line, "lv"));

        list.add(arg1);
        list.add(arg2);
        list.add(arg3);

        return list;
    }

    private String subsplit(String line,String regex){
        Matcher m = (Pattern.compile("@" + regex + "\\((.*)\\)")).matcher(line);
        return m.find() ? m.group(1) : null;
    }

    private ArrayList<String> obj_short_ary(Object obj){
        ArrayList<String> tar = new ArrayList<>();
        for(Object src : (ArrayList) obj){
            tar.add((String) src);
        }
        return tar;
    }

    private Integer obj_int(Object obj){
        try{
            return Integer.valueOf((String) obj);
        }catch (Exception e){
            return -1;
        }
    }

    private ArrayList<LinkedHashMap<String,ArrayList<String>>> obj_long_ary(Object obj){
        ArrayList<LinkedHashMap<String,ArrayList<String>>> list = new ArrayList<>();
        for (Object single:(ArrayList) obj) {
            LinkedHashMap singleAction = (LinkedHashMap) single;
            LinkedHashMap<String,ArrayList<String>> subList = new LinkedHashMap<>();

            for(Object key : singleAction.keySet()){
                subList.put((String)key,obj_short_ary(singleAction.get(obj)));
            }
            list.add(subList);

        }
        return list;
    }

    private ArrayList<ArrayList<String>> obj_middle_ary(Object obj){
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        for(Object ary:(ArrayList)obj){
            list.add(obj_short_ary(ary));
        }
        return list;
    }

}
