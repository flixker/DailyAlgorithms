package me.fycus.nowcoder_leetcode;

/**
 * Implement regular expression matching with support for'.'and'*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
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
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 */

public class RegularExpressionMatching {
    public static void main(String[] args){
        RegularExpressionMatching test = new RegularExpressionMatching();
        System.out.print(test.isMatch("aab", "c*a*b"));
    }
    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        char cos, cop, m;
        for(int i = 2; i < pLen + 1; i += 2){
            if(p.charAt(i - 1) == '*')
                dp[0][i] = true;
            else
                break;
        }
        for(int i = 1; i < sLen + 1; i++){
            cos = s.charAt(i - 1);
            for(int j = 1; j < pLen + 1; j++){
                cop = p.charAt(j - 1);
                if(cop == cos || cop == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                else if(cop == '*'){
                    m = p.charAt(j - 2);
                    if(m != '.' && m != cos)
                        dp[i][j] = dp[i][j - 2];
                    else
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j] || dp[i][j - 2];
                }
            }
        }

        return dp[sLen][pLen];
    }
}
