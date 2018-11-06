package algorithm.java;

/**
 * Created by huaxiufeng on 18/10/8.
 */
public class LC53MaximumSubarray {

    public int maxSubArray(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int maxEnd = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEnd = Math.max(maxEnd + nums[i], nums[i]);
            if (maxEnd > result) {
                result = maxEnd;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC53MaximumSubarray solution = new LC53MaximumSubarray();
        System.out.println(solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
