package me.fycus.nowcoder_leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 *
 * Given n and k, return the k th permutation sequence.
 *
 * Note: Given n will be between 1 and 9 inclusive.
 */

public class permutationSequence {
    public static void main(String[] args){
        System.out.println(new permutationSequence().getPermutation(3, 5));
    }
    public String getPermutation(int n, int k){
        if(n == 1)
            return "1";
        int[] nums = new int[n];
        nums[n - 1] = 0;
        nums[n - 2] = 1;
        for(int i = n - 3; i >= 0; i--)
            nums[i] = nums[i + 1] * (n - i - 1);
        StringBuilder sb = new StringBuilder();
        boolean[] isTaken = new boolean[n];
        int j = 0;
        while(k != 0){
            int r = k % nums[j];
            int next = k / nums[j] + (r == 0 ? 0 : 1);
            sb.append(getN(isTaken, next));
            k = r;
            j++;
        }

        while(j < n){
            sb.append(getN(isTaken, n - j));
            j++;
        }
        return sb.toString();
    }

    public int getN(boolean[] a, int n){
        int count = 0;
        for(int i = 0; i < a.length; i++){
            if(!a[i])
                count++;
            if(count == n){
                a[i] = true;
                return i + 1;
            }
        }
        return -1;
    }
}
