package algorithm.java;

/**
 * Given an unsorted array of integers, find the number of longest increasing subsequence.

 Example 1:
 Input: [1,3,5,4,7]
 Output: 2
 Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
 Example 2:
 Input: [2,2,2,2,2]
 Output: 5
 Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
 Note: Length of the given array will be not exceed 2000 and the answer is guaranteed to be fit in 32-bit signed int.

 * Created by huaxiufeng on 18/10/9.
 */
public class NumberofLongestIncreasingSubsequence {

    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxLen = 0;
        int maxCount = 0;
        int[] dp = new int[nums.length];
        int[] cnt = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j <= i-1; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (dp[i] == dp[j] + 1) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if (maxLen < dp[i]) {
                maxLen = dp[i];
                maxCount = cnt[i];
            } else if(maxLen == dp[i]) {
                maxCount += cnt[i];
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        NumberofLongestIncreasingSubsequence solution = new NumberofLongestIncreasingSubsequence();
        System.out.println(solution.findNumberOfLIS(new int[]{1,2}));
        System.out.println(solution.findNumberOfLIS(new int[]{2,2,2,2,2}));
        System.out.println(solution.findNumberOfLIS(new int[]{1,3,5,4,7}));
    }
}
