package algorithm.java;

import java.util.Arrays;

/**
 * Created by huaxiufeng on 18/11/3.
 */
public class LC31NextPermutation {

    /**
     * 1, Find the largest index k such that a[k] < a[k + 1]. If no such index exists, the permutation is the last permutation.
     * 2, Find the largest index l such that a[k] < a[l]. Since k+1 is such an index, l is well defined and satisfies k < l.
     * 3, Swap a[k] with a[l].
     * 4, Reverse the sequence from a[k+1] up to and including the last element a[n].
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int k = -1, l = nums.length - 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                k = i;
            }
        }
        if (k < 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        for (int i = nums.length - 1; i >= k + 1; i--) {
            if (nums[i] > nums[k]) {
                l = i;
                break;
            }
        }
        swap(nums, k, l);
        reverse(nums, k + 1, nums.length - 1);
    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end && end >= 0 && start < nums.length) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        LC31NextPermutation solution = new LC31NextPermutation();
        int[] nums = new int[]{5,1,1};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
