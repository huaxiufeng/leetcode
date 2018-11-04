package algorithm.java;

/**
 * Created by amyhuiye on 2018/11/4.
 */
public class LC33SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return doSearch(nums, 0, nums.length - 1, target);
    }

    private int doSearch(int[] nums, int begin, int end, int target) {
        if (begin > end) {
            return -1;
        } else if (begin == end) {
            return nums[begin] == target ? begin : -1;
        }
        int mid = (begin + end) / 2;
        if (target == nums[mid]) {
            return mid;
        }
        if (nums[mid] > nums[begin]) { // 左边都是升序
            if (target >= nums[begin] && target <= nums[mid]) { // 目标在左边
                return doSearch(nums, begin, mid - 1, target);
            } else { // 目标在右边
                return doSearch(nums, mid + 1, end, target);
            }
        } else if (nums[mid] < nums[begin]) { // 右边都是升序
            if (target >= nums[mid] && target <= nums[end]) { // 目标在右边
                return doSearch(nums, mid + 1, end, target);
            } else { // 目标在左边
                return doSearch(nums, begin, mid - 1, target);
            }
        } else {
            if (nums[mid] != nums[end]) { // 左边都相同，肯定在右边
                return doSearch(nums, mid + 1, end, target);
            } else { // 没法判断，两边都要查
                int result = doSearch(nums, begin, mid - 1, target);
                if (result == -1) {
                    result = doSearch(nums, mid + 1, end, target);
                }
                return result;
            }
        }
    }

    public static void main(String[] args) {
        LC33SearchInRotatedSortedArray solution = new LC33SearchInRotatedSortedArray();
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }
}
