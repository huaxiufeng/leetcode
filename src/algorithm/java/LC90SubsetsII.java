package algorithm.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by amyhuiye on 2018/11/9.
 */
public class LC90SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        doSubsets(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void doSubsets(List<List<Integer>> result, List<Integer> temp, int[] nums, int index) {
        result.add(new ArrayList<>(temp));
        Integer remove = null;
        for (int i = index; i < nums.length; i++) {
            if (remove != null && remove == nums[i]) {
                continue;
            }
            temp.add(nums[i]);
            doSubsets(result, temp, nums, i + 1);
            remove = temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        LC90SubsetsII solution = new LC90SubsetsII();
        System.out.println(solution.subsetsWithDup(new int[]{1, 2, 2}));
    }
}
