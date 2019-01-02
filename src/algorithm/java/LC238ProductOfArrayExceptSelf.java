package algorithm.java;

import java.util.Arrays;

/**
 * Created by huaxiufeng on 16/11/7.
 */
public class LC238ProductOfArrayExceptSelf {

//    public int[] productExceptSelf(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return nums;
//        }
//        int len = nums.length;
//        int []result = new int[len];
//        for (int i = 0; i < len; i++) {
//            if (result[i] == 0) {
//                result[i] = 1;
//            }
//            for (int j = 0; j < len; j++) {
//                if (j == i) {
//                    continue;
//                }
//                result[i] = result[i] * nums[j];
//            }
//        }
//        return result;
//    }

        public int[] productExceptSelf(int[] nums) {
            if (nums == null || nums.length <= 1) {
                return nums;
            }
            int len = nums.length;
            int []result = new int[len];
            result[0] = 1;
            for (int i = 1, ap = nums[0]; i < len; i++) {
                result[i] = ap;
                ap *= nums[i];
            }
            for (int i = len - 2, ap = nums[len - 1]; i >= 0; i--) {
                result[i] *= ap;
                ap *= nums[i];
            }
            return result;
        }

    public static void main(String[] args) {
        int nums[] = new int[]{1, 2, 3, 4};
        //int nums[] = new int[]{0 , 0};
        int[] result = new LC238ProductOfArrayExceptSelf().productExceptSelf(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(result));
    }
}
