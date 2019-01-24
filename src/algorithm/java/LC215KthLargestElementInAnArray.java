package algorithm.java;

import java.util.PriorityQueue;

/**
 * Created by huaxiufeng on 19/1/24.
 */
public class LC215KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int n : nums) {
            if (heap.size() < k) {
                heap.offer(n);
            } else {
                if (n > heap.peek()) {
                    heap.poll();
                    heap.offer(n);
                }
            }
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        LC215KthLargestElementInAnArray solution = new LC215KthLargestElementInAnArray();
        System.out.println(solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2)); // 5
        System.out.println(solution.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4)); // 4
    }
}
