package algorithm.java;

/**
 * Created by amyhuiye on 2018/11/13.
 */
public class LC81SearchInRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        if (null == nums || 0 == nums.length) {
            return false;
        }
        return doSearch(nums, target, 0, nums.length - 1);
    }

    private boolean doSearch(int[] nums, int target, int left, int right) {
        if (left > right) {
            return false;
        } else if (left == right) {
            return nums[left] == target;
        }
        int mid = (left + right) / 2;
        if (target == nums[mid]) {
            return true;
        }
        if (nums[left] > nums[mid]) { // 右边都是升序
            if (target >= nums[mid] && target <= nums[right]) {
                return doSearch(nums, target, mid + 1, right);
            } else {
                return doSearch(nums, target, left, mid - 1);
            }
        } else if (nums[left] < nums[mid]) { // 左边都是升序
            if (target >= nums[left] && target <= nums[mid]) {
                return doSearch(nums, target, left, mid - 1);
            } else {
                return doSearch(nums, target, mid + 1, right);
            }
        } else {
            if (nums[mid] != nums[right]) {
                return doSearch(nums, target, mid + 1, right);
            } else {
                boolean res = doSearch(nums, target, left, mid - 1);
                if (res) {
                    return true;
                } else {
                    return doSearch(nums, target, mid + 1, right);
                }
            }
        }
    }

    public static void main(String[] args) {
        LC81SearchInRotatedSortedArrayII solution = new LC81SearchInRotatedSortedArrayII();
        System.out.println(solution.search(new int[]{3, 1, 1}, 3));
        System.out.println(solution.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        System.out.println(solution.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
    }
}
