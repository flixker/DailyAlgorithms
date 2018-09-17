package me.fycus.nowcoder_leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordBreak2 {

    public static ArrayList<String> wordBreakDFS(String s, Set<String> dict){
        return dfs(s, dict, new HashMap<>());
    }

    public static ArrayList<String> dfs(String s, Set<String> dict, HashMap<String, ArrayList<String>> map){
        if(map.containsKey(s))
            return map.get(s);

        ArrayList<String> result = new ArrayList<>();
        if(s.length() == 0){
            result.add("");
            return result;
        }
        for(String str : dict){
            if(s.startsWith(str)){
                ArrayList<String> sub = dfs(s.substring(str.length()), dict, map);
                for(String strr : sub){
                    result.add(str + (strr.length() == 0 ? "" : " ") + strr);
                }
            }
        }
        map.put(s, result);
        return result;
    }


    // MLE
    public static ArrayList<String> wordBreak(String s, Set<String> dict){
        if(s == null || dict.isEmpty())
            return new ArrayList<>();
        int len = s.length();
        ArrayList<String>[] isBreakable = new ArrayList[len + 1];
        isBreakable[0] = new ArrayList<>();
        isBreakable[0].add("");
        for(int i = 0; i < isBreakable.length; i++){
            for(int j = 0; j < i; j++){
                if(isBreakable[j] != null && dict.contains(s.substring(j, i))){
                    String sub = s.substring(j, i);
                    if(isBreakable[i] == null)
                    {
                        isBreakable[i] = new ArrayList<>();
                    }
                    for(String str : isBreakable[j]){
                        if(j != 0)
                            isBreakable[i].add(str + " " + sub);
                        else
                            isBreakable[i].add(str + sub);
                    }
                }
            }
        }
        return isBreakable[len] == null ? new ArrayList<>() : isBreakable[len];
    }

    public static void main(String[] args){
        String s = "catsanddog";
        Set<String> dict = new HashSet<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        ArrayList<String> list = wordBreakDFS(s, dict);
        for(String str : list){
            System.out.println(str);
        }
    }
}
