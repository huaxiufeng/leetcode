package algorithm.java;

/**
 * Created by amyhuiye on 2018/12/4.
 */
public class LC121BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if (null == prices || prices.length <= 1) {
            return 0;
        }
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        LC121BestTimeToBuyAndSellStock solution = new LC121BestTimeToBuyAndSellStock();
        System.out.println(solution.maxProfit(new int[]{7,1,5,3,6,4})); // 5
        System.out.println(solution.maxProfit(new int[]{7,6,4,3,1})); // 0
    }
}
