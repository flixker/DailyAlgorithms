package me.fycus.nowcoder_leetcode;

import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict){
        if(s == null)
            return true;
        if(dict.isEmpty())
            return false;
        int len = s.length();
        boolean[] isBreakable = new boolean[len + 1];
        isBreakable[0] = true;
        for(int i = 1; i < len + 1; i++){
            for(int j = 0; j < i; j++){
                if(isBreakable[j] && dict.contains(s.substring(j, i))){
                    isBreakable[i] = true;
                    break;
                }
            }
        }
        return isBreakable[len];
    }
}
