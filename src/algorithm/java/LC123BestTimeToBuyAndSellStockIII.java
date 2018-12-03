package algorithm.java;

/**
 * Created by amyhuiye on 2018/12/4.
 */
public class LC123BestTimeToBuyAndSellStockIII {

    // 631 ms
//    public int maxProfit(int[] prices) {
//        if (null == prices || prices.length <= 1) {
//            return 0;
//        }
//        int maxProfit = getMaxProfit(prices, 0, prices.length - 1);
//        for (int i = 0; i < prices.length; i++) {
//            int profitLeft = getMaxProfit(prices, 0, i);
//            int profitRight = getMaxProfit(prices, i+1, prices.length-1);
//            maxProfit = Math.max(maxProfit, profitLeft + profitRight);
//        }
//        return maxProfit;
//    }
//
//    public int getMaxProfit(int[] prices, int begin, int end) {
//        if (begin >= end) {
//            return 0;
//        }
//        int maxProfit = 0;
//        int minPrice = prices[begin];
//        for (int i = begin + 1; i <= end; i++) {
//            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
//            minPrice = Math.min(minPrice, prices[i]);
//        }
//        return maxProfit;
//    }

    public int maxProfit(int[] prices) {
        if (null == prices || prices.length <= 1) {
            return 0;
        }
        int[] profits = new int[prices.length];
        int[] rprofits = new int[prices.length];
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            profits[i] = Math.max(maxProfit, prices[i] - minPrice);
            maxProfit = Math.max(maxProfit, profits[i]);
            minPrice = Math.min(minPrice, prices[i]);
        }
        int maxPrice = prices[prices.length - 1];
        maxProfit = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            rprofits[i] = Math.max(maxProfit, maxPrice - prices[i]);
            maxProfit = Math.max(maxProfit, rprofits[i]);
            maxPrice = Math.max(maxPrice, prices[i]);
        }
        maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, profits[i] + rprofits[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        LC123BestTimeToBuyAndSellStockIII solution = new LC123BestTimeToBuyAndSellStockIII();
        System.out.println(solution.maxProfit(new int[]{3,3,5,0,0,3,1,4})); // 6
        System.out.println(solution.maxProfit(new int[]{1,2,3,4,5})); // 4
        System.out.println(solution.maxProfit(new int[]{7,6,4,3,1})); // 0
    }
}
