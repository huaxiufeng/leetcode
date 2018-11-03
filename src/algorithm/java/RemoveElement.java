package algorithm.java;

/**
 * Created by huaxiufeng on 18/11/3.
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < nums.length; ) {
            while (i < nums.length && nums[i] == val) {
                i++;
            }
            if (i < nums.length) {
                nums[index++] = nums[i++];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        RemoveElement solution = new RemoveElement();
        int[] nums = new int[]{3, 2, 2, 3};
        int n = solution.removeElement(nums, 2);
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
            if (i == n - 1) {
                System.out.print("\n");
            }
        }
    }
}
