package me.fycus.nowcoder_leetcode;

import java.util.HashMap;

/**
 * Given a roman numeral, convert it to an integer.
 *
 * Input is guaranteed to be within the range from 1 to 3999
 */
public class RomanToInteger {
    public int romanToInt(String s){
        if(s == null || s.length() == 0)
            return 0;
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        int last = 0, cur, res = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            cur = dict.get(s.charAt(i));
            res = cur >= last ? res + cur : res - cur;
            last = cur;
        }
        return res;
    }
}
