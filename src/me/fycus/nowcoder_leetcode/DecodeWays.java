package me.fycus.nowcoder_leetcode;

/**
 * A message containing letters fromA-Zis being encoded to numbers using the following mapping:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * <p>
 * For example,
 * Given encoded message"12", it could be decoded as"AB"(1 2) or"L"(12).
 * <p>
 * The number of ways decoding"12"is 2.
 */

public class DecodeWays {
    public static void main(String[] args) {
        String s = "1180";
        System.out.println(numDecodings(s));
    }

    public static int numDecodings(String s) {
        if (s == null)
            return 0;
        int len = s.length();
        if (len == 0 || s.charAt(0) == '0')
            return 0;
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            if (s.charAt(i - 1) != '0')
                dp[i] = dp[i - 1];
            else
                dp[i] = 0;
            int last2 = Integer.valueOf(s.substring(i - 2, i));
            if ( last2 <= 26 && last2 > 9)
                dp[i] += dp[i - 2];
            if(dp[i] == 0)
                return 0;
        }
        return dp[len];
    }
}
