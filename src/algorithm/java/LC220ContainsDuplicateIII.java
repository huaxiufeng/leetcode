package algorithm.java;

import java.util.TreeSet;

/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 *
 * Created by huaxiufeng on 18/12/28.
 */
public class LC220ContainsDuplicateIII {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (0 == k && t > 0) {
            return false;
        }
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long floor = treeSet.floor((long)nums[i] + t);
            Long ceiling = treeSet.ceiling((long)nums[i] - t);
            if ((floor != null && floor >= nums[i]) || (ceiling != null && ceiling <= nums[i])) {
                return true;
            }
            if (i >= k) {
                treeSet.remove((long)nums[i - k]);
            }
            treeSet.add((long)nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        LC220ContainsDuplicateIII solution = new LC220ContainsDuplicateIII();
        System.out.println(solution.containsNearbyAlmostDuplicate(new int[]{-2147483648,-2147483647}, 3, 3)); // true
        System.out.println(solution.containsNearbyAlmostDuplicate(new int[]{1,2}, 0, 1)); // false
        System.out.println(solution.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3)); // false
        System.out.println(solution.containsNearbyAlmostDuplicate(new int[]{1,0,1,1}, 1, 2)); // true
        System.out.println(solution.containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3, 0)); // true
    }
}
