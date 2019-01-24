package me.fycus.nowcoder_leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array S of n integers, are there elements a, b, c in S
 * such that a + b + c = 0 ?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 *
 * For example, given array S = {-1 0 1 2 -1 -4},
 *
 *     A solution set is:
 *     (-1, 0, 1)
 *     (-1, -1, 2)
 */
public class Sum3 {
    public static void main(String[] args){
        int[] num = new int[]{-1, 0, 1, 2, -1, -4};
        ArrayList<ArrayList<Integer>> res = new Sum3().threeSum(num);
        for(ArrayList<Integer> li : res)
            System.out.println(li);
    }
    public ArrayList<ArrayList<Integer>> threeSum(int[] num){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.sort(num);
        int len = num.length;
        for(int i = 0; i < len - 2; i++){
            int a = num[i];
            if(a > 0)
                break;
            for(int j = i + 1; j < len - 1; j++){
                int b = num[j];
                if(a + b > 0)
                    break;
                for(int k = j + 1; k < len; k++) {
                    int c = num[k];
                    if(a + b + c > 0)
                        break;
                    if(a + b + c == 0){
                        ArrayList<Integer> tmp = new ArrayList<>();
                        tmp.add(num[i]);
                        tmp.add(num[j]);
                        tmp.add(num[k]);
                        if(!res.contains(tmp))
                            res.add(tmp);
                    }
                }
            }
        }
        return res;
    }
}
