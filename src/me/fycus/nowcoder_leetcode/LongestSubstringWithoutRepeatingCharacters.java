package me.fycus.nowcoder_leetcode;

import java.util.HashSet;

/**
 * Given a string,
 * find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3.
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args){
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(
                "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"
        ));
    }
    public int lengthOfLongestSubstring(String s){
        int len;
        if(s == null || (len = s.length()) == 0)
            return 0;
        HashSet<Character> set = new HashSet<>();
        int i = 0, j = 0;
        int max = 0;
        while(i < len && j < len){
            char c = s.charAt(j);
            if(set.contains(c)){
                while(s.charAt(i) != c){
                    set.remove(s.charAt(i));
                    i++;
                }
                i++;
                set.remove(c);
            }
            else
                max = Math.max(j - i + 1, max);
            set.add(c);
            j++;
        }
        return max;
    }
}
