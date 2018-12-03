package algorithm.java;

/**
 * Created by amyhuiye on 2018/12/4.
 */
public class LC122BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        if (null == prices || prices.length <= 1) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        LC122BestTimeToBuyAndSellStockII solution = new LC122BestTimeToBuyAndSellStockII();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // 7
        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 4, 5})); // 4
    }
}
