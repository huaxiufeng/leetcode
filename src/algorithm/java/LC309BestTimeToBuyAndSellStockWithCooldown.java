package algorithm.java;

import java.util.HashMap;
import java.util.Map;

public class LC309BestTimeToBuyAndSellStockWithCooldown {

    public int maxProfit(int[] prices) {
        return doMaxProfit(prices, 0, new HashMap<>());
    }

    private int doMaxProfit(int[] prices, int start, Map<Integer, Integer> map) {
        if (start >= prices.length - 1) {
            return 0;
        }
        if (map.containsKey(start)) {
            return map.get(start);
        }
        int maxProfit = 0;
        int minPrice = prices[start];
        for (int i = start + 1; i < prices.length; i++) {
            if (prices[i] > minPrice) {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice + doMaxProfit(prices, i + 2, map));
            } else if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }
        map.put(start, maxProfit);
        return maxProfit;
    }

    public static void main(String[] args) {
        LC309BestTimeToBuyAndSellStockWithCooldown solution = new LC309BestTimeToBuyAndSellStockWithCooldown();
        System.out.println(solution.maxProfit(new int[]{1,2,3,0,2})); // 3 [buy, sell, cooldown, buy, sell]
    }
}
