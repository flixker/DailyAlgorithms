package me.fycus.nowcoder_leetcode;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 *
 * For example, given the array[−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray[4,−1,2,1]has the largest sum =6.
 *
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using the
 * divide and conquer approach, which is more subtle.
 */
public class MaximumSubarray {
    public static void main(String[] args){
        int[] arrat = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.print(maxSubarray(arrat));
    }
    public static int maxSubarray(int[] A){
        int len = A.length;
        int max = Integer.MIN_VALUE;
        int now = 0;
        for(int i = 0; i < len; i++){
            now += A[i];
            max = max > now ? max : now;
            now = now > 0 ? now : 0;
        }
        return max;
    }
}
