package algorithm.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by amyhuiye on 2018/11/5.
 */
public class LC40CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(candidates);
        backtrace(resultList, new ArrayList<>(), candidates, target, 0);
        return resultList;
    }

    private void backtrace(List<List<Integer>> resultList, List<Integer> tempList, int[] nums, int remain, int index) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            tempList.add(nums[i]);
            backtrace(resultList, tempList, nums, remain - nums[i], i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        LC40CombinationSumII solution = new LC40CombinationSumII();
        System.out.println(solution.combinationSum2(new int[]{2, 3, 5}, 5));
        System.out.println(solution.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
        System.out.println(solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
