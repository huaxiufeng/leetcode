package algorithm.java;

import java.util.Arrays;

/**
 * Created by amyhuiye on 2019/3/16.
 */
public class LC283MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (null == nums || nums.length == 0) {
            return;
        }
        int writeIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[writeIndex++] = nums[i];
            }
        }
        for (int i = writeIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        LC283MoveZeroes solution = new LC283MoveZeroes();
        {
            int[] nums = new int[]{0,1,0,3,12};
            solution.moveZeroes(nums);
            System.out.println(Arrays.toString(nums));
        }
    }
}
