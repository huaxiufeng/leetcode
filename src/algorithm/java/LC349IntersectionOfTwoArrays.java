package algorithm.java;

import java.util.HashSet;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

 Note:
 Each element in the result must be unique.
 The result can be in any order.

 * Created by huaxiufeng on 17/8/6.
 */
public class LC349IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();
        for (Integer n1 : nums1) {
            nums1Set.add(n1);
        }
        for (Integer n2 : nums2) {
            if (nums1Set.contains(n2)) {
                resultSet.add(n2);
            }
        }
        int[] result = new int[resultSet.size()];
        int i = 0;
        for (Integer n : resultSet) {
            result[i++] = n;
        }
        return result;
    }
}
