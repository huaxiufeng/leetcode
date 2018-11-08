package algorithm.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amyhuiye on 2018/11/9.
 */
public class LC78Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        doSubsets(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void doSubsets(List<List<Integer>> result, List<Integer> temp, int[] nums, int index) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);
        doSubsets(result, temp, nums, index + 1);
        temp.remove(temp.size() - 1);
        doSubsets(result, temp, nums, index + 1);
    }

    public static void main(String[] args) {
        LC78Subsets solution = new LC78Subsets();
        System.out.println(solution.subsets(new int[]{1, 2, 3}));
    }
}
