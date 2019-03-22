package algorithm.java;

/**
 * Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer
 * given in the form of an array.
 *
 * Created by huaxiufeng on 19/3/23.
 */
public class LC372SuperPow {

    public int superPow(int a, int[] b) {
        int ans = 1;
        for (int i = b.length - 1; i >= 0; i--) {
            ans = ans * fastPow(a, b[i]) % 1337;
            a = fastPow(a, 10);
        }
        return ans;
    }

    private int fastPow(int a, int b) {
        a = a % 1337;
        int ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = ans * a % 1337;
            }
            a = a * a % 1337;
            b = b >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        LC372SuperPow solution = new LC372SuperPow();
        System.out.println(solution.superPow(2, new int[]{1,0})); // 1024
        System.out.println(solution.superPow(2, new int[]{3})); // 8
        System.out.println(solution.superPow(2147483647, new int[]{2,0,0})); // 1198
    }
}
