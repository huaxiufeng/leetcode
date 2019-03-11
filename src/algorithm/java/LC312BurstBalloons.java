package algorithm.java;

/**
 * Created by amyhuiye on 2019/3/11.
 */
public class LC312BurstBalloons {

    // 分而治之
    public int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;

        int[][] mem = new int[n][n];
        return doGetMaxCoins(nums, mem, 0, n - 1);
    }

    private int doGetMaxCoins(int[] nums, int[][] mem, int left, int right) {
        if (left + 1 == right) {
            return 0;
        }
        if (mem[left][right] > 0) {
            return mem[left][right];
        }
        int coins = 0;
        for (int i = left + 1; i < right; i++) {
            coins = Math.max(coins, nums[left] * nums[i] * nums[right]
                    + doGetMaxCoins(nums, mem, left, i) + doGetMaxCoins(nums, mem, i, right));
        }
        mem[left][right] = coins;
        return coins;
    }

    public static void main(String[] args) {
        LC312BurstBalloons solution = new LC312BurstBalloons();
        System.out.println(solution.maxCoins(new int[]{3,1,5,8})); // 167
    }
}
