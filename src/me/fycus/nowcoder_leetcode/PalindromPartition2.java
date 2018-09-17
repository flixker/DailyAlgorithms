package me.fycus.nowcoder_leetcode;

/*
Given a string s, partition s such that every substring of the partition is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of s.
For example, given s ="aab",
Return 1 since the palindrome partitioning["aa","b"]could be produced using 1 cut.
*/

import java.util.Stack;

public class PalindromPartition2 {
    public static void main(String args[]){
        String s = "aabbaaaba";
        System.out.println(minCut2(s));
    }

    public static int minCut2(String s){
        int len = s.length();
        if(len == 0)
            return 0;
        int[] dp = new int[len];
        for(int i = 0; i < len; i++)
            dp[i] = i;

        for(int i = 0; i < len; i++){
            for(int left = i, right = i; left >= 0 && right < len && s.charAt(left) == s.charAt(right); left--, right++){
                if(left == 0) {
                    dp[right] = 0;
                    break;
                }
                dp[right] = Math.min(dp[right], dp[left - 1] + 1);
            }
            for(int left = i, right = i + 1; left >= 0 && right < len && s.charAt(left) == s.charAt(right); left--, right++){
                if(left == 0) {
                    dp[right] = 0;
                    break;
                }
                dp[right] =  Math.min(dp[right], dp[left - 1] + 1);
            }
        }

        return dp[len - 1];
    }

    //wrong version
    public static int minCut(String s){
        int len = s.length();
        if(len == 0)
            return 0;
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < len; i++){
            for(int j = i; j < len; j++){
                if(s.charAt(j) == s.charAt(i)){
                    stack.push(j);
                }
            }
            while(!stack.isEmpty()){
                int end = stack.pop();
                if(isPalindrom(s, i, end)){
                    i = end;
                    stack.empty();
                    break;
                }
            }
            count++;
        }
        return count - 1;
    }

    public static boolean isPalindrom(String s, int start, int end){
        while(s.charAt(start) == s.charAt(end) && start < end){
            start++;
            end--;
        }
        if(start >= end)
            return true;
        return false;
    }
}
