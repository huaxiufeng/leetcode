package algorithm.java;

/**
 Given an array of n positive integers and a positive integer s,
 find the minimal length of a contiguous subarray of which the sum ≥ s.
 If there isn't one, return 0 instead.

 * Created by huaxiufeng on 19/3/24.
 */
public class LC209MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        int minSize = 0;
        int sum = 0;
        int begin = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= s) {
                while (begin < nums.length && sum - nums[begin] >= s) {
                    sum -= nums[begin];
                    begin++;
                }
                if (0 == minSize || i - begin + 1 < minSize) {
                    minSize = i - begin + 1;
                }
            }
        }
        return minSize;
    }

    public static void main(String[] args) {
        LC209MinimumSizeSubarraySum solution = new LC209MinimumSizeSubarraySum();
        System.out.println(solution.minSubArrayLen(7, new int[]{2,3,1,2,4,3})); // 2
    }
}
