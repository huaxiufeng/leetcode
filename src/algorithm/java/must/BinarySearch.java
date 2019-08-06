package algorithm.java.must;

/**
 * Created by huaxiufeng on 18/11/5.
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        assert binarySearch.search(new int[]{1,2,3,4}, 2) == 1;
        assert binarySearch.search(new int[]{1,2,3,4}, 3) == 2;
        assert binarySearch.search(new int[]{1,2,3,4,5}, 3) == 2;
        assert binarySearch.search(new int[]{1,2,3,4,5}, 4) == 3;
        assert binarySearch.search(new int[]{1,2,4,5,6}, 3) == -1;
    }
}
