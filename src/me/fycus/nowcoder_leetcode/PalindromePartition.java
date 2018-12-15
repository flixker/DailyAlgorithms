package me.fycus.nowcoder_leetcode;

import java.util.ArrayList;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * For example, given s ="aab",
 * Return
 *
 *   [
 *     ["aa","b"],
 *     ["a","a","b"]
 *   ]
 */

public class PalindromePartition {
    ArrayList<ArrayList<String>> res;
    ArrayList<String> tmp;
    public ArrayList<ArrayList<String>> partition(String s){
        res = new ArrayList<>();
        if(s == null)
            return res;
        tmp = new ArrayList<>();
        dfs(s, 0);
        return res;
    }

    public void dfs(String s, int index){
        if(index >= s.length()){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = index + 1; i <= s.length(); i++){
            String sub = s.substring(index, i);
            if(isPalindrome(sub)) {
                tmp.add(sub);
                dfs(s, i);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s){
        int i = 0;
        int j = s.length() - 1;
        while(i < j && s.charAt(i) == s.charAt(j)){
            i++;
            j--;
        }
        return i >= j;
    }
}
