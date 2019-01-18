package me.fycus.nowcoder_leetcode;

/**
 * Write a function to find the longest common prefix string amongst an array of strings
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs){
        if(strs == null || strs.length == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs[0].length(); i++){
            char c = strs[0].charAt(i);
            for(int j = 0; j < strs.length; j++){
                if(i >= strs[j].length() || strs[j].charAt(i) != c)
                    return sb.toString();
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
