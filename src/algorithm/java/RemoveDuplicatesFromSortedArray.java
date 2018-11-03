package algorithm.java;

/**
 * Created by huaxiufeng on 18/11/3.
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < nums.length;) {
            while (i < nums.length && nums[i] == nums[index]) {
                i++;
            }
            if (i < nums.length) {
                nums[++index] = nums[i++];
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();
        int[] nums = new int[]{0,1,2,3,4,5};
        int n = solution.removeDuplicates(nums);
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
            if (i == n-1) {
                System.out.print("\n");
            }
        }
    }
}
