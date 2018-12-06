package algorithm.java;

/**
 * Created by huaxiufeng on 18/12/6.
 */
public class LC174DungeonGame {

    public int calculateMinimumHP(int[][] dungeon) {
        if (null == dungeon || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int height = dungeon.length;
        int width = dungeon[0].length;
        int[][] dp = new int[height][width];
        dp[height-1][width-1] = dungeon[height-1][width-1] >= 0 ? 1 : dungeon[height-1][width-1] * -1 + 1;
        for (int i = height-2; i >= 0; i--) {
            int diff = dungeon[i][width-1] - dp[i+1][width-1];
            dp[i][width-1] = diff >= 0 ? 1 : -1 * diff;
        }
        for (int j = width-2; j >= 0; j--) {
            int diff = dungeon[height-1][j] - dp[height-1][j+1];
            dp[height-1][j] = diff >= 0 ? 1 : -1 * diff;
        }
        for (int i = height-2; i >= 0; i--) {
            for (int j = width-2; j >= 0; j--) {
                int rightDiff = dungeon[i][j] - dp[i][j+1];
                int dpRight = rightDiff >= 0 ? 1 : -1 * rightDiff;
                int downDiff = dungeon[i][j] - dp[i+1][j];
                int dpDown = downDiff >= 0 ? 1 : -1 * downDiff;
                dp[i][j] = Math.min(dpRight, dpDown);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        LC174DungeonGame solution = new LC174DungeonGame();
        System.out.println(solution.calculateMinimumHP(new int[][]{
                {-2,-3,3},
                {-5,-10,1},
                {10,30,	-5 }
        })); // 7
    }
}
