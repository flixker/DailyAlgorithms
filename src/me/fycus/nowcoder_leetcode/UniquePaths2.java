package me.fycus.nowcoder_leetcode;

/**
 * Follow up for "Unique Paths":
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p>
 * For example,
 * <p>
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * <p>
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is2.
 * <p>
 * Note: m and n will be at most 100.
 */
public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 0)
                dp[i] = 1;
            else
                break;
        }
        for (int i = 1; i < m; i++) {
            if(obstacleGrid[i][0] == 1)
                dp[0] = 0;
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 0)
                    dp[j] += dp[j - 1];
                else
                    dp[j] = 0;
            }
        }
        return dp[n - 1];
    }
}
