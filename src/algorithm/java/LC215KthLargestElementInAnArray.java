package algorithm.java;

import java.util.PriorityQueue;

/**
 * Created by huaxiufeng on 19/1/24.
 */
public class LC215KthLargestElementInAnArray {

    public int findKthLargestHeap(int[] nums, int k) {
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

    public int findKthLargest(int[] nums, int k) {
        int lo = 0, hi = nums.length - 1;
        k = nums.length - k;
        while (lo < hi) {
            int p = partition(nums, lo, hi);
            if (p < k) {
                lo = p + 1;
            } else if (p > k) {
                hi = p - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private int partition(int[] nums, int begin, int end) {
        int lo = begin, hi = end;
        int pivot = nums[lo];
        while (lo < hi) {
            while (lo < hi && nums[hi] >= pivot) {
                hi--;
            }
            nums[lo] = nums[hi];
            while (lo < hi && nums[lo] <= pivot) {
                lo++;
            }
            nums[hi] = nums[lo];
        }
        nums[lo] = pivot;
        return lo;
    }

    public static void main(String[] args) {
        LC215KthLargestElementInAnArray solution = new LC215KthLargestElementInAnArray();
        System.out.println(solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2)); // 5
        System.out.println(solution.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4)); // 4
    }
}
