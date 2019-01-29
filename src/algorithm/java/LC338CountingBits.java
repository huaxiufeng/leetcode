package algorithm.java;

import java.util.Arrays;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: [0,1,1]
 * Example 2:
 * <p>
 * Input: 5
 * Output: [0,1,1,2,1,2]
 * <p>
 * Created by huaxiufeng on 19/1/29.
 */
public class LC338CountingBits {

    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        int milestone = 1;
        for (int i = 1; i <= num; i++) {
            if ((i & (i-1)) == 0) {
                milestone = i;
                result[i] = 1;
            } else {
                result[i] = result[i - milestone] + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC338CountingBits solution = new LC338CountingBits();
        System.out.println(Arrays.toString(solution.countBits(2))); // [0,1,1]
        System.out.println(Arrays.toString(solution.countBits(5))); // [0,1,1,2,1,2]
        System.out.println(Arrays.toString(solution.countBits(20)));
    }
}
