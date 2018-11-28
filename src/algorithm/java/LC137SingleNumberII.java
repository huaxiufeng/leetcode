package algorithm.java;

/**
 * Created by huaxiufeng on 18/11/28.
 */
public class LC137SingleNumberII {

    public int singleNumber(int[] nums) {
        int one = 0; // 保存出现了1次的数的异或值
        int two = 0; // 保存出现了2次的数的异或值
        int three = 0; // 保存出现了3次的数的异或值

        for (int i = 0; i < nums.length; i++) {
            two = two | (one & nums[i]);
            one = one ^ nums[i];
            three = one & two;
            one &= ~three; // 把出现了3次的数去掉
            two &= ~three;
        }
        return one;
    }

    public static void main(String[] args) {
        LC137SingleNumberII solution = new LC137SingleNumberII();
        System.out.println(solution.singleNumber(new int[]{2, 2, 3, 2}));
    }
}
