package algorithm.java;

/**
 * Created by huaxiufeng on 18/12/1.
 */
public class LC198HouseRobber {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i+1] = Math.max(dp[i], dp[i-1] + nums[i]);
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        LC198HouseRobber solution = new LC198HouseRobber();
        System.out.println(solution.rob(new int[]{1, 2, 3, 1})); // 4
        System.out.println(solution.rob(new int[]{2, 7, 9, 3, 1})); // 12
    }
}
