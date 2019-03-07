package algorithm.java;

/**
 * Created by huaxiufeng on 18/12/1.
 */
public class LC198HouseRobber {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i-2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        LC198HouseRobber solution = new LC198HouseRobber();
        System.out.println(solution.rob(new int[]{1, 2, 3, 1})); // 4
        System.out.println(solution.rob(new int[]{2, 7, 9, 3, 1})); // 12
    }
}
