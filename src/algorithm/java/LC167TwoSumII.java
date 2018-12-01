package algorithm.java;

import java.util.Arrays;

/**
 * Created by huaxiufeng on 18/12/1.
 */
public class LC167TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[]{-1, -1};
        if (numbers == null || numbers.length < 2) {
            return result;
        }
        int left = 0;
        int right = numbers.length - 1;
        while (right > left) {
            if (numbers[left] + numbers[right] == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC167TwoSumII solution = new LC167TwoSumII();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 18)));
    }
}
