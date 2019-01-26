package algorithm.java;

import java.util.Arrays;

/**
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * <p>
 * Created by huaxiufeng on 19/1/26.
 */
public class LC264UglyNumberII {

    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        int count = 1;
        int i = 0, j = 0, k = 0;
        while (count < n) {
            int v = Math.min(2 * nums[i], Math.min(3 * nums[j], 5 * nums[k]));
            nums[count++] = v;
            if (v == 2 * nums[i]) {
                i++;
            }
            if (v == 3 * nums[j]) {
                j++;
            }
            if (v == 5 * nums[k]) {
                k++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums[n - 1];
    }

    public static void main(String[] args) {
        LC264UglyNumberII solution = new LC264UglyNumberII();
        System.out.println(solution.nthUglyNumber(1600)); // 12.-- 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
    }
}
