package algorithm.java;

/**
 We are playing the Guess Game. The game is as follows:
 I pick a number from 1 to n. You have to guess which number I picked.
 Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
 However, when you guess a particular number x, and you guess wrong, you pay $x.
 You win the game when you guess the number I picked.

 Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.

 * Created by huaxiufeng on 19/3/27.
 */
public class LC375GuessNumberHigherOrLowerII {

    /**
     Definition of dp[i][j]: minimum number of money to guarantee win for subproblem [i, j].
     Target: dp[1][n]
     Corner case: dp[i][i] = 0 (because the only element must be correct)
     Equation: we can choose k (i<=k<=j) as our guess, and pay price k.
     After our guess, the problem is divided into two sub problems.
     Notice we do not need to pay the money for both sub problems.
     We only need to pay the worst case (because the system will tell us which side we should go) to guarantee win.
     So dp[i][j] = min (i<=k<=j) { k + max(dp[i][k-1], dp[k+1][j]) }
     */
    public int getMoneyAmount(int n) {
        if (n == 1) {
            return 0;
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int diff = 1; diff < n; diff++) {
            for (int i = 0; i + diff <= n; i++) {
                int j = i + diff;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                            k + Math.max(k - 1 >= i ? dp[i][k - 1] : 0,
                                    j >= k + 1 ? dp[k + 1][j] : 0));
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        LC375GuessNumberHigherOrLowerII solution = new LC375GuessNumberHigherOrLowerII();
        System.out.println(solution.getMoneyAmount(4));
    }
}
