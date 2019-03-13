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

    /**
     * 假设数组中没有重复，那我们可以做到这么一点，就是将数组的下标和1到n每一个数一对一的映射起来。
     * 比如数组是213,则映射关系为0->2, 1->1, 2->3。假设这个一对一映射关系是一个函数f(n)，其中n是下标，f(n)是映射到的数。
     * 如果我们从下标为0出发，根据这个函数计算出一个值，以这个值为新的下标，再用这个函数计算，以此类推，直到下标超界。
     * 实际上可以产生一个类似链表一样的序列。比如在这个例子中有两个下标的序列，0->2->3。
     * 但如果有重复的话，这中间就会产生多对一的映射，比如数组2131,则映射关系为0->2, {1，3}->1, 2->3。
     * 这样，我们推演的序列就一定会有环路了，这里下标的序列是0->2->3->1->1->1->1->...，而环的起点就是重复的数。
     * @param nums
     * @return
     */
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
