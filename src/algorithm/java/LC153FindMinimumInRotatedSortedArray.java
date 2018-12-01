package algorithm.java;

/**
 * Created by huaxiufeng on 18/12/1.
 */
public class LC153FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        return doFindMin(nums, 0, nums.length - 1);
    }

    private int doFindMin(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        } else if (right - left == 1) {
            return Math.min(nums[left], nums[right]);
        }
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        int mid = (left + right) / 2;
        if (nums[left] < nums[mid]) {
            return doFindMin(nums, mid+1, right);
        } else if (nums[left] > nums[mid]) {
            return doFindMin(nums, left, mid);
        }
        return -1;
    }

    public static void main(String[] args) {
        LC153FindMinimumInRotatedSortedArray solution = new LC153FindMinimumInRotatedSortedArray();
        System.out.println(solution.findMin(new int[]{3,4,5,1,2})); // 1
        System.out.println(solution.findMin(new int[]{4,5,6,7,0,1,2})); // 0
        System.out.println(solution.findMin(new int[]{6,7,0,1,2,4,5})); // 0
    }
}
