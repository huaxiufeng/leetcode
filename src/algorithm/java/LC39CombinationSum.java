package algorithm.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by amyhuiye on 2018/11/5.
 */
public class LC39CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            tempList.add(nums[i]);
            backtrace(resultList, tempList, nums, remain - nums[i], i);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        LC39CombinationSum solution = new LC39CombinationSum();
        System.out.println(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(solution.combinationSum(new int[]{2, 3, 5}, 8));
    }
}
