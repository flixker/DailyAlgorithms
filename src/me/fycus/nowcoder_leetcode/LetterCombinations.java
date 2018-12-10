package me.fycus.nowcoder_leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 *
 * 2:abc; 3:def; 4:ghi; 5:jkl; 6:mno; 7:pqrs; 8:tuv; 9:wxyz
 *
 * Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinations {
    private Map<Character, String> map;
    private char[] tmp;
    private ArrayList<String> res;
    public ArrayList<String> letterCombinations(String digits){
        map = new HashMap<Character, String>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        tmp = new char[digits.length()];
        res = new ArrayList<>();
        dfs(digits, 0);
        return res;
    }

    public void dfs(String digits, int pos){
        if(pos >= digits.length()){
            res.add(new String(tmp));
            return;
        }
        char[] cs = map.get(digits.charAt(pos)).toCharArray();
        for(char c : cs){
            tmp[pos] = c;
            dfs(digits, pos + 1);
        }
    }
}
