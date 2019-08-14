package algorithm.java;

/**
 Given a non-empty array containing only positive integers,
 find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

 Note:
 Each of the array element will not exceed 100.
 The array size will not exceed 200.
 */
public class LC416PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int n = nums.length;

        // dp[i][j]表示前i个数字，是否存在子集之和为j
        boolean[][] dp = new boolean[n+1][target+1];

        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            // 肯定存在子集之和为0
            dp[i][0] = true;
        }
        for (int j = 1; j <= target; j++) {
            // 如果不选任何数，和不可能大于0
            dp[0][j] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= nums[i-1]) {
                    dp[i][j] = (dp[i-1][j] || dp[i-1][j-nums[i-1]]);
                }
            }
        }

        return dp[n][target];
    }

    public static void main(String[] args) {
        LC416PartitionEqualSubsetSum solution = new LC416PartitionEqualSubsetSum();
        System.out.println(solution.canPartition(new int[]{1, 5, 11, 5})); // true
        System.out.println(solution.canPartition(new int[]{1, 2, 3, 5})); // false
    }
}
