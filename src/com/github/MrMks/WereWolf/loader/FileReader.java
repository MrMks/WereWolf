package com.github.MrMks.WereWolf.loader;

import com.github.MrMks.WereWolf.PlayerDatas.charater.*;
import com.github.MrMks.WereWolf.GlobalData;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Mirora_Mikasa on 2017/3/12.
 * load files from disk
 */
public  class FileReader {
    public static File folder;
    private static Yaml yaml = new Yaml();

    // Character.yml to GlobalData.JobList
    public static void Init(){
        LinkedHashMap<String,Job> jobList = new LinkedHashMap<>();
        try{
            File jobListPath = new File(folder.getAbsolutePath() + "/character.yml");
            FileInputStream ListInputStream = new FileInputStream(jobListPath);
            LinkedHashMap strList = yaml.loadAs(ListInputStream, LinkedHashMap.class);

            for(Object key : strList.keySet()){
                LinkedHashMap SingleJob = (LinkedHashMap)strList.get(key);
                Job job = new Job();

                job.JobName = (String) key;
                job.Display = StringConvert(SingleJob.get("display"),job.JobName);
                job.Faction = StringConvert(SingleJob.get("faction"),"village");
                job.Channels = ChannelInit(SingleJob.get("channel"));
                job.abilities = AbilityInit(SingleJob.get("ability"));
                job.skills = SkillInit(SingleJob.get("skill"));
                job.VictimJudgement = JudgementInit(SingleJob.get("victim"));

                jobList.put(job.JobName,job);
            }
        } catch (Exception e){
        System.out.print("Initialize Error");
        }

    GlobalData.setJobList(jobList);
}

    private static ArrayList<Channel> ChannelInit(Object obj){
        ArrayList<Channel> channels = new ArrayList<>();
        for(Object c : (ArrayList) obj) {
            Matcher m = Pattern.compile("(\\D+):(\\D+)").matcher(c.toString());
            Channel channel = new Channel();
            channel.name = m.group(1);
            channel.time = m.group(2);

            channels.add(channel);
        }
        return channels;
    }

    private static ArrayList<Ability> AbilityInit(Object abilities){
        ArrayList<Ability> list = new ArrayList<>();
        for(Object ability : (ArrayList) abilities){

            LinkedHashMap ability_map = (LinkedHashMap) ability;
            Ability t = new Ability();

            t.Call = StringConvert(ability_map.get("call"),null);
            t.Level = IntegerConvert(ability_map.get("level"),50);
            t.Wait =  IntegerConvert(ability_map.get("wait"),0);
            t.Life = IntegerConvert(ability_map.get("life"),-1);
            t.Amp = IntegerConvert(ability_map.get("amp"),100);
            t.Succeeded = ActBlockConvert(ability_map.get("succeeded"), new ArrayList<>());
            t.Failed = ActBlockConvert(ability_map.get("failed"), new ArrayList<>());

            list.add(t);
        }
        return list;
    }

    private static ArrayList<Skill> SkillInit(Object skills){
        ArrayList<Skill> list = new ArrayList<>();
        for(Object single : ((ArrayList) skills)){
            LinkedHashMap singleSkill = ((LinkedHashMap) single);
            Skill t = new Skill();

            t.LimitA = IntegerConvert(singleSkill.get("limitA"),-1);
            t.LimitE = IntegerConvert(singleSkill.get("limitE"),-1);
            t.Level = IntegerConvert(singleSkill.get("level"),50);
            t.Time = StringConvert(singleSkill.get("time"),"night");
            t.Amp = IntegerConvert(singleSkill.get("amp"),100);
            t.Succeeded = ActBlockConvert(singleSkill.get("success"), new ArrayList<>());
            t.Failed = ActBlockConvert(singleSkill.get("failure"), new ArrayList<>());

            list.add(t);
        }
        return list;

    }

    private static ArrayList<ArrayList<String>> JudgementInit(Object obj){
        return JudgementConvert(obj);
    }

    private static ArrayList<ActBlock> ActBlockConvert(Object act_blocks, ArrayList<ActBlock> defaultValue) {
        ArrayList<ActBlock> list = new ArrayList<>();
        try {
            for(Object act_block : (ArrayList) act_blocks){
                LinkedHashMap source = (LinkedHashMap) act_block;
                ActBlock t = new ActBlock();

                t.Judgement = JudgementConvert(source.get("if"));
                t.Action = ActionConvert(source.get("do"));

                list.add(t);
            }
        } catch (Exception e){
            e.printStackTrace();
            list = defaultValue;
        }
        return list;
    }

    private static ArrayList<ArrayList<String>> JudgementConvert(Object judgements) {
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        try{
            for(Object and : (ArrayList)judgements) {
                ArrayList<String> t = new ArrayList<>();
                for (Object line : (ArrayList) and) {
                    t.add(line.toString());
                }
                list.add(t);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    private static ArrayList<String> ActionConvert(Object actions) {
        ArrayList<String> list = new ArrayList<>();
        try{
            for(Object line : (ArrayList)actions){
                list.add(line.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private static int IntegerConvert(Object level, int defaultValue) {
        Integer value = defaultValue;
        try {
            value = Integer.valueOf(level.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    private static String StringConvert(Object source, String defaultValue) {
        String target;
        try {
            target = (String)source;
        } catch (Exception e) {
            e.printStackTrace();
            target = defaultValue;
        }
        return target;
    }

}
