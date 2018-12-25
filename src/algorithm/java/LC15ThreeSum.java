package algorithm.java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by huaxiufeng on 18/12/25.
 */
public class LC15ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int target = -1 * nums[i];
            int begin = i + 1, end = nums.length - 1;
            while (begin < end) {
                boolean incrBegin = false, descEnd = false;
                int sum = nums[begin] + nums[end];
                if (sum == target) {
                    resultList.add(Arrays.asList(nums[i], nums[begin], nums[end]));
                    incrBegin = descEnd = true;
                } else if (sum < target) {
                    incrBegin = true;
                } else {
                    descEnd = true;
                }
                if (incrBegin) {
                    do {
                        begin++;
                    } while (begin < end && nums[begin] == nums[begin-1]);
                }
                if (descEnd) {
                    do {
                        end--;
                    } while ((end > begin && nums[end] == nums[end + 1]));
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        LC15ThreeSum solution = new LC15ThreeSum();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4})); // [-1, 0, 1],[-1, -1, 2]
        System.out.println(solution.threeSum(new int[]{0,0,0,0})); // [0, 0, 0]
    }
}
