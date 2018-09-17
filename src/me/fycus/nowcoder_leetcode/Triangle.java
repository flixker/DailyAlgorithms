package me.fycus.nowcoder_leetcode;

import java.util.ArrayList;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 *
 * The minimum path sum from top to bottom is11(i.e., 2 + 3 + 5 + 1 = 11).
 */

public class Triangle {
    public static int minTotal(ArrayList<ArrayList<Integer>> triangle){
        int height = triangle.size();
        if(height == 0)
            return 0;
        if(height == 1)
            return triangle.get(0).get(0);
        int len = triangle.get(height - 1).size();
        int[] dp = new int[len];
        for(int i = 0; i < len; i++)
            dp[i] = triangle.get(height - 1).get(i);
        for(int i = height - 2; i >= 0; i--){
            ArrayList<Integer> cur = triangle.get(i);
            for(int j = 0; j < cur.size(); j++){
                dp[j] = cur.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }
}
