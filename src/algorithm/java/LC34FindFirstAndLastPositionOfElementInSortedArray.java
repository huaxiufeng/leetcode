package algorithm.java;

import java.util.Arrays;

/**
 * Created by amyhuiye on 2018/11/4.
 */
public class LC34FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        return new int[]{getLeftIndex(nums, target), getRightIndex(nums, target)};
    }

    private int getLeftIndex(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int idx = -1;
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] >= target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
            if (nums[mid] == target) {
                idx = mid;
            }
        }
        return idx;
    }

    private int getRightIndex(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int idx = -1;
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
            if (nums[mid] == target) {
                idx = mid;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        LC34FindFirstAndLastPositionOfElementInSortedArray solution = new LC34FindFirstAndLastPositionOfElementInSortedArray();
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 7)));
    }
}
