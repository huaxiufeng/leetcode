package algorithm.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

 Note:
 Each element in the result should appear as many times as it shows in both arrays.
 The result can be in any order.
 Follow up:
 What if the given array is already sorted? How would you optimize your algorithm?
 What if nums1's size is small compared to nums2's size? Which algorithm is better?
 What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

 * Created by huaxiufeng on 17/8/6.
 */
public class LC350IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (null == nums1 || 0 == nums1.length) {
            return nums1;
        }
        if (null == nums2 || 0 == nums2.length) {
            return nums2;
        }
        Map<Integer, Integer> nums1ContMap = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();
        for (Integer n1 : nums1) {
            if (nums1ContMap.containsKey(n1)) {
                nums1ContMap.put(n1, 1 + nums1ContMap.get(n1));
            } else {
                nums1ContMap.put(n1, 1);
            }
        }
        for (Integer n2 : nums2) {
            Integer count = nums1ContMap.get(n2);
            if (null == count || 0 == count) {
                continue;
            }
            resultList.add(n2);
            nums1ContMap.put(n2, --count);
        }
        int[] result = new int[resultList.size()];
        int i = 0;
        for (Integer n : resultList) {
            result[i++] = n;
        }
        return result;
    }
}
