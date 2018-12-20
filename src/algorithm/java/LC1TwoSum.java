package algorithm.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by amyhuiye on 2018/12/21.
 */
public class LC1TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];
            if (map.containsKey(left)) {
                return new int[]{map.get(left), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        LC1TwoSum solution = new LC1TwoSum();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
