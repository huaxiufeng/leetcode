package algorithm.java;

/**
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Created by amyhuiye on 2019/3/15.
 */
public class LC322CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        LC322CoinChange solution = new LC322CoinChange();
        System.out.println(solution.coinChange(new int[]{1,2,5}, 11)); // 3
        System.out.println(solution.coinChange(new int[]{2,5,10,1}, 27)); // 4
        System.out.println(solution.coinChange(new int[]{186,419,83,408}, 6249)); // 20
        System.out.println(solution.coinChange(new int[]{2}, 3)); // -1
    }
}
