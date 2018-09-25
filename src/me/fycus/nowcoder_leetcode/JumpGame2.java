package me.fycus.nowcoder_leetcode;

/**
 * Given an array of non-negative integers, you are initially positioned
 * at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * For example:
 * Given array A =[2,3,1,1,4]
 *
 * The minimum number of jumps to reach the last index is 2.
 * (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */

public class JumpGame2 {
    public static void main(String[] args){

    }
    public static int jump(int[] A){
        int len = A.length;
        int max = 0;
        int count = 0;
        int start = 0, end = -1;
        while(max < len - 1){
            start = end + 1;
            end = max;
            for(int i = start; i <= end; i++){
                max = Math.max(max, A[i] + i);
            }
            count++;
        }
        return count;
    }
}
