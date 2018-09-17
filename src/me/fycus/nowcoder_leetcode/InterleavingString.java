package me.fycus.nowcoder_leetcode;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * For example,
 * Given:
 * s1 ="aabcc",
 * s2 ="dbbca",
 *
 * When s3 ="aadbbcbcac", return true.
 * When s3 ="aadbbbaccc", return false.
 */

public class InterleavingString {
    public static void main(String[] args){
        String s1 = "aa";
        String s2 = "ab";
        String s3 = "aaab";
        System.out.print(isInterleave2(s1, s2, s3));
    }

    public static boolean isInterleave2(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if(len1 + len2 != len3)
            return false;
        boolean[] dp = new boolean[len1 + 1];
        dp[0] = true;
        for(int i = 1; i < dp.length; i++)
            dp[i] =  dp[i - 1] && s3.charAt(i - 1) == s1.charAt(i - 1);
        for(int i = 1; i < len2 + 1; i++){
            for(int j = 0; j < len1 + 1; j++){
                if(dp[j]){
                    if(j < len1 && !dp[j + 1] && s3.charAt(i + j) == s1.charAt(j)){
                        dp[j + 1] = true;
                    }
                    if(i < len2 && s3.charAt(i + j) != s2.charAt(i)){
                        dp[j] = false;
                    }
                }
            }
        }
        return dp[len1];
    }
    // wrong version
    public static boolean isInterleave(String s1, String s2, String s3){
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        int i = 0;
        int j = 0;
        int k = 0;
        while(k < len3){
            char c1 = i < len1 ? s1.charAt(i) : ' ';
            char c2 = j < len2 ? s2.charAt(j) : ' ';
            char c3 = s3.charAt(k);
            if(c3 == c1)
                i++;
            else if(c3 == c2)
                j++;
            else
                return false;
            k++;
        }
        if(i == len1 && j == len2)
            return true;
        return false;
    }
}
