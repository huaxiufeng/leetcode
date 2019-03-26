package algorithm.java;

/**
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).

 Example 1:
 Input: [1,3,5,4,7]
 Output: 3
 Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
 Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
 Example 2:
 Input: [2,2,2,2,2]
 Output: 1
 Explanation: The longest continuous increasing subsequence is [2], its length is 1.
 Note: Length of the array will not exceed 10,000.

 * Created by huaxiufeng on 18/10/8.
 */
public class LC674LongestContinuousIncreasingSubsequence {

    public int findLengthOfLCIS(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int previous = Integer.MIN_VALUE;
        int maxIncrLen = 0;
        int curIncrLen = 0;
        for (int n : nums) {
            if (n > previous) {
                curIncrLen++;
            } else {
                maxIncrLen = Math.max(curIncrLen, maxIncrLen);
                curIncrLen = 1;
            }
            previous = n;
        }
        return Math.max(curIncrLen, maxIncrLen);
    }

    public static void main(String[] args) {
        LC674LongestContinuousIncreasingSubsequence solution = new LC674LongestContinuousIncreasingSubsequence();
        System.out.println(solution.findLengthOfLCIS(new int[]{1,3,5,7}));
        System.out.println(solution.findLengthOfLCIS(new int[]{1,3,5,4,7}));
        System.out.println(solution.findLengthOfLCIS(new int[]{2,2,2,2,2}));
    }
}
