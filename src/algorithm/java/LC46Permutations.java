package algorithm.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huaxiufeng on 18/11/6.
 */
public class LC46Permutations {

    public List<List<Integer>> permute(int[] nums) {
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
        for (int i = start; i < nums.length; i++) {
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
        LC46Permutations solution = new LC46Permutations();
        System.out.println(solution.permute(new int[]{1, 2, 3, 4}));
    }
}
