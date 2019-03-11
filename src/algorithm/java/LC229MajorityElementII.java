package algorithm.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 Note: The algorithm should run in linear time and in O(1) space.

 * Created by huaxiufeng on 19/3/11.
 */
public class LC229MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> resultList = new ArrayList<>(2);
        if (null == nums || 0 == nums.length) {
            return resultList;
        }
        int n1 = 0, n2 = 0;
        int count1 = 0, count2 = 0;
        for (int n : nums) {
            if ((0 == count1 || n == n1) && n != n2) {
                n1 = n;
                count1++;
            } else if (0 == count2 || n == n2) {
                n2 = n;
                count2++;
            } else {
                --count1;
                --count2;
            }
        }
        count1 = 0; count2 = 0;
        for (int n : nums) {
            if (n1 == n) {
                count1++;
            } else if (n2 == n) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            resultList.add(n1);
        }
        if (count2 > nums.length / 3) {
            resultList.add(n2);
        }
        return resultList;
    }

    public static void main(String[] args) {
        LC229MajorityElementII solution = new LC229MajorityElementII();
        System.out.println(solution.majorityElement(new int[]{1,2,2,3,2,1,1,3})); // 2,1
        System.out.println(solution.majorityElement(new int[]{1,1,1,3,3,2,2,2})); // 1,2
        System.out.println(solution.majorityElement(new int[]{3,2,3})); // 3
    }
}
