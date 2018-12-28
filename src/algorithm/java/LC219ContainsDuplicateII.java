package algorithm.java;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

 * Created by huaxiufeng on 18/12/28.
 */
public class LC219ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = numIndexMap.get(nums[i]);
            if (index != null && i - index <= k) {
                return true;
            }
            numIndexMap.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        LC219ContainsDuplicateII solution = new LC219ContainsDuplicateII();
        System.out.println(solution.containsNearbyDuplicate(new int[]{1,2,3,1}, 3)); // true
        System.out.println(solution.containsNearbyDuplicate(new int[]{1,0,1,1}, 1)); // true
        System.out.println(solution.containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2)); // false
    }
}
