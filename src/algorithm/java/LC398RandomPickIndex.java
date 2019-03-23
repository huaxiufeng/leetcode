package algorithm.java;

import java.util.Random;

/**
 Given an array of integers with possible duplicates, randomly output the index of a given target number.
 You can assume that the given target number must exist in the array.

 Note:
 The array size can be very large. Solution that uses too much extra space will not pass the judge.

 * Created by huaxiufeng on 19/3/23.
 */
public class LC398RandomPickIndex {

    static class Solution {
        private int[] nums;
        private Random random;

        public Solution(int[] nums) {
            this.nums = nums;
            this.random = new Random();
        }

        public int pick(int target) {
            int begin = 0;
            while (begin < this.nums.length && this.nums[begin] != target) {
                begin++;
            }
            int result = begin;
            for (int i = begin + 1; i < this.nums.length && nums[i] == target; i++) {
                if (random.nextInt(i - begin + 1) == 0) {
                    result = i;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1,2,3,3,3});
        System.out.println(solution.pick(3)); // should return either index 2, 3, or 4 randomly
        System.out.println(solution.pick(2)); // should return 1
    }
}
