package algorithm.java;

/**
 * Created by amyhuiye on 2018/11/13.
 */
public class LC70ClimbingStairs {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int dp[] = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LC70ClimbingStairs solution = new LC70ClimbingStairs();
        System.out.println(solution.climbStairs(1)); // 1
        System.out.println(solution.climbStairs(2)); // 2
        System.out.println(solution.climbStairs(3)); // 3
    }
}
