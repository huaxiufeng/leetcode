package algorithm.java;

/**
 * Created by huaxiufeng on 18/11/13.
 */
public class LC80RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        int limit = 2;
        if (null == nums) {
            return 0;
        } else if (nums.length <= limit) {
            return nums.length;
        }
        int index = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            while (i < nums.length && nums[i] == nums[index] && count >= limit) {
                i++;
            }
            if (i < nums.length) {
                if (nums[i] != nums[index]) {
                    count = 0;
                }
                nums[++index] = nums[i];
                count++;
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {
        LC80RemoveDuplicatesFromSortedArrayII solution = new LC80RemoveDuplicatesFromSortedArrayII();
        System.out.println(solution.removeDuplicates(new int[]{1,1,1,2,2,3})); // 5
        System.out.println(solution.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3})); // 7
    }
}
