package me.fycus.nowcoder_leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 *
 * You have the following 3 operations permitted on a word:
 *
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 */

public class EditDistance {
    public static void main(String[] args){
        String word1 = "longest";
        String word2 = "est";
        System.out.print(minDistance(word1, word2));
    }

    public static int minDistance(String word1, String word2){
        int len1 = word1.length();
        int len2 = word2.length();
        if(len1 == 0)
            return len2;
        if(len2 == 0)
            return len1;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 0; i < len1 + 1; i++)
            dp[i][0] = i;
        for(int i = 0; i < len2 + 1; i++)
            dp[0][i] = i;

        for(int i = 1; i < len1 + 1; i++){
            for(int j = 1; j < len2 + 1; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else{
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        return dp[len1][len2];
    }
}
