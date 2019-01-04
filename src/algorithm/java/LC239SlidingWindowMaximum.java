package algorithm.java;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by huaxiufeng on 19/1/4.
 */
public class LC239SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        LinkedList<Integer> q = new LinkedList<>(); // 双向链表，保存index，保持降序(前面大，后面小)
        for (int i = 0; i < nums.length; i++) {
            // 保持窗口长度为k
            while (q.size() > 0 && q.getFirst() < i - k + 1) {
                q.removeFirst();
            }
            // 保证链表中没有小于当前的值
            while (q.size() > 0 && nums[q.getLast()] < nums[i]) {
                q.removeLast();
            }
            q.add(i);
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[q.getFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC239SlidingWindowMaximum solution = new LC239SlidingWindowMaximum();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3))); // [3,3,5,5,6,7]
    }
}
