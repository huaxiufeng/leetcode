package algorithm.java;

/**
 * Given an integer, write a function to determine if it is a power of three.

 Follow up:
 Could you do it without using any loop / recursion?

 * Created by huaxiufeng on 17/8/10.
 */
public class PowerOfThree {

    public boolean isPowerOfThree(int n) {
        if (n > 1) {
            while (n % 3 == 0) {
                n = n / 3;
            }
        }
        return n == 1;
    }

    public boolean isPowerOfThreeCheat(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    public static void main(String[] args) {
        PowerOfThree solution = new PowerOfThree();
        System.out.println(solution.isPowerOfThree(54));
        System.out.println(solution.isPowerOfThree(27));
    }
}
