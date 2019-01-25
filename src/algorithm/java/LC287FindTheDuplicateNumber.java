package algorithm.java;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by huaxiufeng on 19/1/25.
 */
public class LC287FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) {
                return n;
            }
            set.add(n);
        }
        return 0;
    }

    public int findDuplicateNiu(int[] nums) {
        int len = nums.length, left = 0, right = len - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            int count = 0;
            for (int i = 0; i < len; ++i) {
                if (nums[i] <= mid) {
                    ++count;
                }
            }
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int findDuplicateCycle(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }

    public static void main(String[] args) {
        LC287FindTheDuplicateNumber solution = new LC287FindTheDuplicateNumber();
        System.out.println(solution.findDuplicate(new int[]{1, 3, 4, 2, 2})); // 2
        System.out.println(solution.findDuplicate(new int[]{3, 1, 3, 4, 2})); // 3
        System.out.println(solution.findDuplicate(new int[]{2, 2, 2, 2, 2})); // 2
    }
}
