package algorithm.java;

/**
 * Created by huaxiufeng on 18/10/4.
 */
public class JumpGame {

    public boolean canJump0(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        boolean[] result = new boolean[nums.length];
        result[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (result[i]) {
                for (int n = 1; n <= nums[i]; n++) {
                    if (i + n < nums.length) {
                        result[i + n] = true;
                    }
                }
            }
        }
        return result[nums.length-1];
    }

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int maxJump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxJump < i) {
                return false;
            }
            maxJump = Math.max(maxJump, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        JumpGame solution = new JumpGame();
        System.out.println(solution.canJump(new int[]{0}));
        System.out.println(solution.canJump(new int[]{2,3,1,1,4}));
        System.out.println(solution.canJump(new int[]{3,2,1,0,4}));
    }
}
