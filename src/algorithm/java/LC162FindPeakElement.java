package algorithm.java;

/**
 * A peak element is an element that is greater than its neighbors.

 Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

 The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

 You may imagine that nums[-1] = nums[n] = -∞.

 * Created by huaxiufeng on 18/12/8.
 */
public class LC162FindPeakElement {

    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high - 1) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > nums[mid + 1]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return nums[low] > nums[high] ? low : high;
    }

    public static void main(String[] args) {
        LC162FindPeakElement solution = new LC162FindPeakElement();
        System.out.println(solution.findPeakElement(new int[]{1,2,3,1})); // 2
        System.out.println(solution.findPeakElement(new int[]{1,2,1,3,5,6,4})); // 1 or 5
    }
}
