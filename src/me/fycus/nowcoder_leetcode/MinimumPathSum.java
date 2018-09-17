package me.fycus.nowcoder_leetcode;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 */

public class MinimumPathSum {
    public static void main(String[] args){
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.print(minPathSum(grid));
    }
    public static int minPathSum(int[][] grid){
        int width = grid[0].length;
        int height = grid.length;

        int[] dp = new int[width];
        dp[0] = grid[0][0];
        for(int i = 1; i < width; i++)
            dp[i] = grid[0][i] + dp[i - 1];
        for(int i = 1; i < height; i++){
            dp[0] += grid[i][0];
            for(int j = 1; j < width; j++){
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
        return dp[width - 1];
    }
}
