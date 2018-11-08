package algorithm.java;

/**
 * Created by amyhuiye on 2018/11/9.
 */
public class LC63UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (null == obstacleGrid || null == obstacleGrid[0] || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][]dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 0) {
                dp[0][i] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        LC63UniquePathsII solution = new LC63UniquePathsII();
        System.out.println(solution.uniquePathsWithObstacles(new int[][]{
                {0,0,0},
                {0,1,0},
                {0,0,0}
        }));
        System.out.println(solution.uniquePathsWithObstacles(new int[][]{
                {1}
        }));
    }
}
