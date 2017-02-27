package algorithm.java;

/**
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 * Subscribe to see which companies asked this question.
 * Created by huaxiufeng on 17/2/27.
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        int maxSoFar = nums[0];
        int maxEnding = nums[0];
        int minEnding = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int maxEndingHere = maxEnding;
            int minEndingHere = minEnding;
            maxEnding = Math.max(Math.max(maxEndingHere * nums[i], minEndingHere * nums[i]), nums[i]);
            minEnding = Math.min(Math.min(maxEndingHere * nums[i], minEndingHere * nums[i]), nums[i]);
            maxSoFar = Math.max(maxEnding, maxSoFar);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        System.out.println(maximumProductSubarray.maxProduct(new int[]{-4,-3,-2}));
    }
}
