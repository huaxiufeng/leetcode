package algorithm.java;

/**
 * Your are given an array of positive integers nums.

 Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.

 Example 1:
 Input: nums = [10, 5, 2, 6], k = 100
 Output: 8
 Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 Note:

 0 < nums.length <= 50000.
 0 < nums[i] < 1000.
 0 <= k < 10^6.

 * Created by huaxiufeng on 18/10/13.
 */
public class SubarrayProductLessThanK {

    public int numSubarrayProductLessThanKX(int[] nums, int k) {
        if (k == 0) return 0;
        int cnt = 0;
        int pro = 1;
        for (int i = 0, j = 0; j < nums.length; j++) {
            pro *= nums[j];
            while (i <= j && pro >= k) {
                pro /= nums[i++];
            }
            cnt += j - i + 1;
        }
        return cnt;
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (null == nums || nums.length == 0 || k <= 0) {
            return 0;
        }
        int startIndex = 0;
        int curProduct = 1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int product = curProduct * nums[i];
            while (product >= k && startIndex <= i) {
                product = product / nums[startIndex++];
            }
            curProduct = product;
            count += i - startIndex + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        SubarrayProductLessThanK solution = new SubarrayProductLessThanK();
        System.out.println(solution.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        System.out.println(solution.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 1));
    }
}
