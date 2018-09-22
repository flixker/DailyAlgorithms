package me.fycus.nowcoder_leetcode;

public class JumpGame {
    public static void main(String[] args){
        int[] a = {3,2,1,0,4};
        System.out.print(canJump(a));
    }
    public static boolean canJump(int[] A){
        int len = A.length;
        if(len == 0)
            return true;
        boolean[] dp = new boolean[len];
        dp[0] = true;
        for(int i = 1; i < len; i++)
            dp[i] = false;
        for(int i = 0; i < len; i++){
            if(dp[i]) {
                for (int j = 1; j <= A[i]; j++){
                    if(i + j < len)
                        dp[i + j] = true;
                    else
                        return true;
                }
            }
        }
        return dp[len - 1];
    }
}
