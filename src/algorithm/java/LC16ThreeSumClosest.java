package algorithm.java;

import java.util.Arrays;

/**
 * Created by amyhuiye on 2018/12/26.
 */
public class LC16ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int begin = i+1, end = nums.length - 1;
            while (begin < end) {
                int sum = nums[i] + nums[begin] + nums[end];
                if (sum < target) {
                    begin++;
                } else if (sum > target) {
                    end--;
                } else {
                    return target;
                }
                if (Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC16ThreeSumClosest solution = new LC16ThreeSumClosest();
        System.out.println(solution.threeSumClosest(new int[]{-3,-2,-5,3,-4}, -1)); // -2
        System.out.println(solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1)); // 2
    }
}
