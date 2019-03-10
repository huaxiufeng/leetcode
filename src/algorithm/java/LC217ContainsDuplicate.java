package algorithm.java;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by huaxiufeng on 19/3/10.
 */
public class LC217ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        if (null == nums || nums.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>(nums.length);
        for (int n : nums) {
            if (!set.add(n)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LC217ContainsDuplicate solution = new LC217ContainsDuplicate();
        System.out.println(solution.containsDuplicate(new int[]{1,2,3,1})); // true
        System.out.println(solution.containsDuplicate(new int[]{1,2,3,4})); // false
    }
}
