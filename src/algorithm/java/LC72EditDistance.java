package algorithm.java;

/**
 * Created by amyhuiye on 2018/11/11.
 */
public class LC72EditDistance {

    public int minDistance(String word1, String word2) {
        int len1 = word1 != null ? word1.length() : 0;
        int len2 = word2 != null ? word2.length() : 0;
        if (len1 == 0 || len2 == 0) {
            return Math.max(len1, len2);
        }
        int dp[][] = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                    }
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        LC72EditDistance solution = new LC72EditDistance();
        System.out.println(solution.minDistance("horse", "ros"));
        System.out.println(solution.minDistance("intention", "execution"));
    }
}
