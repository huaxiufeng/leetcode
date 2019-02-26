package algorithm.java;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by amyhuiye on 2019/2/27.
 */
public class LC384ShuffleAnArray {

    static class Solution {
        private int[] nums;
        Random random = new Random();

        public Solution(int[] nums) {
            this.nums = nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            if (null == nums || nums.length <= 1) {
                return nums;
            }
            int[] result = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                result[i] = nums[i];
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                int index = random.nextInt(i + 1);
                swap(result, index, i);
            }
            return result;
        }

        private void swap(int[] nums, int a, int b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 2, 3});
        for (int i = 0; i < 100; i++) {
            System.out.println(Arrays.toString(solution.shuffle()));
        }
    }
}
