package algorithm.java;

/**
 * Created by huaxiufeng on 18/12/4.
 */
public class LC188BestTimeToBuyAndSellStockIV {

    /**
     * dp[i, j] represents the max profit up until prices[j] using at most i transactions.
     * dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
     * = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
     * dp[0, j] = 0; 0 transactions makes 0 profit
     * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
     */
    public int maxProfit_(int k, int[] prices) {
        if (k < 1 || null == prices || 0 == prices.length) {
            return 0;
        }
        if (k >= prices.length / 2) {
            return simpleProfit(prices);
        }
        int[][] profit = new int[k + 1][prices.length];
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < prices.length; j++) {
                int preProfit = 0;
                for (int jj = 0; jj < j; jj++) {
                    preProfit = Math.max(preProfit, prices[j] - prices[jj] + profit[i - 1][jj]);
                }
                profit[i][j] = Math.max(profit[i][j - 1], preProfit);
            }
        }
        return profit[k][prices.length - 1];
    }

    /**
     * 在上面的基础上做了优化
     */
    public int maxProfit(int k, int[] prices) {
        if (k < 1 || null == prices || 0 == prices.length) {
            return 0;
        }
        if (k >= prices.length / 2) {
            return simpleProfit(prices);
        }
        int[][] profit = new int[k + 1][prices.length];
        for (int i = 1; i <= k; i++) {
            int maxDiff = -1 * prices[0];
            for (int j = 1; j < prices.length; j++) {
                profit[i][j] = Math.max(profit[i][j - 1], maxDiff + prices[j]);
                maxDiff = Math.max(maxDiff, profit[i - 1][j] - prices[j]);
            }
        }
        return profit[k][prices.length - 1];
    }

    private int simpleProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        LC188BestTimeToBuyAndSellStockIV solution = new LC188BestTimeToBuyAndSellStockIV();
        System.out.println(solution.maxProfit(2, new int[]{3, 3, 5, 0, 0, 3, 1, 4})); // 6
        System.out.println(solution.maxProfit(2, new int[]{2, 4, 1})); // 2
        System.out.println(solution.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3})); // 7
    }
}
