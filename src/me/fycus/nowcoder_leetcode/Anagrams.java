package me.fycus.nowcoder_leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Given an array of strings, return all groups of strings that are anagrams(同字异构单词）.
 *
 * Note: All inputs will be in lower-case
 */

public class Anagrams {
    ArrayList<ArrayList<String>> storage;
    ArrayList<HashMap<Character, Integer>> counter;
    public ArrayList<String> anagrams(String[] strs){
        storage = new ArrayList<>();
        counter = new ArrayList<>();
        for(String s : strs){
            find(s);
        }
        ArrayList<String> res = new ArrayList<>();
        for(ArrayList<String> list : storage){
            if(list.size() > 1)
                for(String s : list){
                    res.add(s);
                }
        }
        return res;
    }

    public void find(String s){
        HashMap<Character, Integer> tmp = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int num = tmp.getOrDefault(c, 0);
            tmp.put(c, num + 1);
        }
        for(int i= 0; i < counter.size(); i++){
            HashMap<Character, Integer> exist = counter.get(i);
            if(exist.equals(tmp)) {
                storage.get(i).add(s);
                return;
            }
        }
        counter.add(tmp);
        storage.add(new ArrayList<String>(){{add(s);}});
    }
}
