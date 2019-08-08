package algorithm.java;

import java.util.Arrays;

/**
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 *
 * Example:
 *
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 * Note:
 *
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */
public class LC260SingleNumberIII {

    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int n : nums) {
            xor ^= n;
        }
        int rightMostBit = 0;
        while ((xor & 1) == 0) {
            xor = xor >> 1;
            rightMostBit++;
        }
        int flag = 1 << rightMostBit;
        int xor1 = 0, xor2 = 0;
        for (int n : nums) {
            if ((n & flag) == 0) {
                xor1 ^= n;
            } else {
                xor2 ^= n;
            }
        }
        return new int[]{xor1, xor2};
    }

    public static void main(String[] args) {
        LC260SingleNumberIII solution = new LC260SingleNumberIII();
        System.out.println(Arrays.toString(solution.singleNumber(new int[]{1,2,1,3,2,5}))); // [3,5]
    }
}
