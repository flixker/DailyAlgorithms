package me.fycus.nowcoder_leetcode;

import javax.swing.event.TreeWillExpandListener;

/**
 * Implement wildcard pattern matching with support for '?' and '*' .
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 *
 * The matching should cover the entire input string (not partial).
 *
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 *
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 */
public class WildCardMatching {
    public static void main(String[] args){
        WildCardMatching wildCardMatching = new WildCardMatching();
        System.out.print(wildCardMatching.isMatch("aa", "*"));
    }
    // 直接用递归会超时，需要用动态规划。
    public boolean isMatch(String s, String p){
       int sLen = s.length();
       int pLen = p.length();
       boolean[][] dp = new boolean[sLen + 1][pLen + 1];
       dp[0][0] = true;
       for(int i = 1; i < pLen + 1; i++){
           if(dp[0][i - 1] && p.charAt(i - 1) == '*')
               dp[0][i] = true;
           else
               break;
       }
       for(int i = 1; i < sLen + 1; i++){
           char cs = s.charAt(i - 1);
           for(int j = 1; j < pLen + 1; j++){
               char cp = p.charAt(j - 1);
               if(cs == cp || cp == '?'){
                   dp[i][j] = dp[i - 1][j - 1];
               }
               else if(cp == '*'){
                   dp[i][j] = dp[i - 1][j - 1] || dp[i - 1][j] || dp[i][j - 1];
               }
           }
       }

       return dp[sLen][pLen];
    }
}
