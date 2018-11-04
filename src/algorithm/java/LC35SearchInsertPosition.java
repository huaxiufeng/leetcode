package algorithm.java;

/**
 * Created by amyhuiye on 2018/11/4.
 */
public class LC35SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        LC35SearchInsertPosition solution = new LC35SearchInsertPosition();
        System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 0)); // 0
        System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 2)); // 1
        System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 5)); // 2
        System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 7)); // 4
    }
}
