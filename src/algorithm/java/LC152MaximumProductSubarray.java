package algorithm.java;

/**
 * Created by amyhuiye on 2018/12/13.
 */
public class LC152MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if (nums == null || 0 == nums.length) {
            return 0;
        }
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = min[0] = nums[0];
        int result = max[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                if (max[i-1] > 0) {
                    max[i] = max[i-1] * nums[i];
                } else {
                    max[i] = nums[i];
                }
                if (min[i-1] <= 0) {
                    min[i] = min[i-1] * nums[i];
                } else {
                    min[i] = nums[i];
                }
            } else if (nums[i] < 0) {
                if (min[i-1] < 0) {
                    max[i] = min[i-1] * nums[i];
                } else {
                    max[i] = nums[i];
                }
                if (max[i-1] > 0) {
                    min[i] = max[i-1] * nums[i];
                } else {
                    min[i] = nums[i];
                }
            } else {
                max[i] = min[i] = 0;
            }
            result = Math.max(result, max[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        LC152MaximumProductSubarray solution = new LC152MaximumProductSubarray();
        System.out.println(solution.maxProduct(new int[]{2, 3, -2, 4})); // 6
        System.out.println(solution.maxProduct(new int[]{-2, 0, -1})); // 0
    }
}
