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
        result.add(new ArrayList<>(temp));
        for(int i = index; i < nums.length; i++){
            temp.add(nums[i]);
            doSubsets(result, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        LC78Subsets solution = new LC78Subsets();
        System.out.println(solution.subsets(new int[]{1, 2, 3}));
    }
}
