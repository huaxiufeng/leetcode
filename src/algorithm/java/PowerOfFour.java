package algorithm.java;

/**
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

 Example:
 Given num = 16, return true. Given num = 5, return false.

 Follow up: Could you solve it without loops/recursion?

 * Created by huaxiufeng on 17/8/9.
 */
public class PowerOfFour {

    public boolean isPowerOfFour(int num) {
        return num > 0 && ((num & (num-1)) == 0) && ((num & 0x55555555) == num);
    }

    public static void main(String[] args) {
        PowerOfFour solution = new PowerOfFour();
        // 1, 4, 16, 64, 256, 66536
        // 000000000001
        // 000000000100
        // 000000010000
        // 000001000000
        // 000100000000
        System.out.println(solution.isPowerOfFour(32));
        System.out.println(solution.isPowerOfFour(64));
    }
}
