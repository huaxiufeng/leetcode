package algorithm.java;

/**
 * Created by huaxiufeng on 18/12/1.
 */
public class LC154FindMinimumInRotatedSortedArrayII {

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
        if (nums[left] > nums[mid]) { // 右边非递减
            return doFindMin(nums, left, mid);
        } else if (nums[left] < nums[mid]) { // 左边非递减
            return doFindMin(nums, mid+1, right);
        } else {
            return Math.min(doFindMin(nums, left, mid), doFindMin(nums, mid+1, right));
        }
    }

    public static void main(String[] args) {
        LC154FindMinimumInRotatedSortedArrayII solution = new LC154FindMinimumInRotatedSortedArrayII();
        System.out.println(solution.findMin(new int[]{2,2,2,0,1})); // 0
        System.out.println(solution.findMin(new int[]{2,2,0,1,2})); // 0
    }
}
