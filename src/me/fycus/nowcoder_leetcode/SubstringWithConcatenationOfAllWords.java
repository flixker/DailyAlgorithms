package me.fycus.nowcoder_leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * You are given a string, S, and a list of words, L, that are all of the same length.
 * Find all starting indices of substring(s) in S
 * that is a concatenation（一连串） of each word in L exactly once
 * and without any intervening（干扰） characters.
 *
 * For example, given:
 * S:"barfoothefoobarman"
 * L:["foo", "bar"]
 *
 * You should return the indices:[0,9].
 * (order does not matter).
 */
public class SubstringWithConcatenationOfAllWords {

    public static void main(String[] args){
        SubstringWithConcatenationOfAllWords substringWithConcatenationOfAllWords =
                new SubstringWithConcatenationOfAllWords();
        System.out.println(substringWithConcatenationOfAllWords.findSubstring("a",
                new String[]{"a"}));
    }

    public ArrayList<Integer> findSubstring(String S, String[] L){
        ArrayList<Integer> res = new ArrayList<>();
        int n = S.length();
        int k;
        int m = L.length;
        if(m == 0 || (k = L[0].length()) > n || k == 0)
            return res;
        HashMap<String, Integer> wDict = new HashMap<>();
        for(String s : L)
            wDict.put(s, wDict.getOrDefault(s, 0) + 1);
        int len = m * k;
        HashMap<String, Integer> curDict = new HashMap<>();
        for(int i = 0; i < k; i++){
            // start 为窗口的左边界
            int start = i;
            // 移动窗口右边界
            for(int j = i ; j + k <= n; j += k){

                // 检查下一个单词是否符合要求
                String tmp = S.substring(j, j + k);
                if(wDict.containsKey(tmp)){
                    int count = curDict.getOrDefault(tmp, 0);
                    if(count < wDict.get(tmp)) {
                        curDict.put(tmp, count + 1);
                        if(start + len == j + k){
                            res.add(start);
                            String head = S.substring(start, start + k);
                            curDict.put(head, curDict.get(head) - 1);
                            start += k;
                        }
                        continue;
                    }
                    String r;
                    while(!(r = S.substring(start, start + k)).equals(tmp)){
                        start += k;
                        curDict.put(r, curDict.get(r) - 1);
                    }
                    start += k;
                }
                else{
                    start = j + k;
                    curDict.clear();
                }
            }
            curDict.clear();
        }
        Collections.sort(res);
        return res;
    }
}
