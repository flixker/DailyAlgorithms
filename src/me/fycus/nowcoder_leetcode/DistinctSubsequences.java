package me.fycus.nowcoder_leetcode;

/**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none)
 * of the characters without disturbing the relative positions of the remaining characters. (ie,"ACE"is a subsequence
 * of"ABCDE"while"AEC"is not).
 *
 * Here is an example:
 * S ="rabbbit", T ="rabbit"
 *
 * Return 3.
 */
public class DistinctSubsequences {
    public int numDistinct(String S, String T) {
        int slen = S.length();
        int tlen = T.length();
        if(tlen == 0)
            return 1;
        if(slen == 0)
            return 0;
        int[] dp = new int[tlen + 1];
        dp[0] = 1;
        for(int i = 0; i < slen; i++){
            for(int j = Math.min(i + 1, tlen); j > 0; j--){
                if(T.charAt(j - 1) == S.charAt(i))
                    dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[tlen];
    }
}
