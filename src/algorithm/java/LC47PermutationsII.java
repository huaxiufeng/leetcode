package algorithm.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by huaxiufeng on 18/11/6.
 */
public class LC47PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        doPermutate(resultList, nums, 0);
        return resultList;
    }

    private void doPermutate(List<List<Integer>> resultList, int[] nums, int start) {
        if (start == nums.length) {
            List<Integer> numList = new ArrayList<>(nums.length);
            for (int num : nums) {
                numList.add(num);
            }
            resultList.add(numList);
        }

        Set<Integer> used = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (used.contains(nums[i])) {
                continue;
            }
            used.add(nums[i]);
            swap(nums, i, start);
            doPermutate(resultList, nums, start + 1);
            swap(nums, i, start);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        LC47PermutationsII solution = new LC47PermutationsII();
        System.out.println(solution.permuteUnique(new int[]{1,2,3}));
    }
}
