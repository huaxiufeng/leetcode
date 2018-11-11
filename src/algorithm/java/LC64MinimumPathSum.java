package algorithm.java;

/**
 * Created by amyhuiye on 2018/11/11.
 */
public class LC64MinimumPathSum {

    public int minPathSum(int[][] grid) {
        if (null == grid || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int height = grid.length;
        int width = grid[0].length;
        int[][] dp = new int[height][width];
        for (int i = 0; i < height; i++) {
            dp[i][0] = grid[i][0] + (i == 0 ? 0 : dp[i - 1][0]);
        }
        for (int j = 0; j < width; j++) {
            dp[0][j] = grid[0][j] + (j == 0 ? 0 : dp[0][j - 1]);
        }
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[height - 1][width - 1];
    }
}
