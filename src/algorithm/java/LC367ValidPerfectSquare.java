package algorithm.java;

/**
 * Created by amyhuiye on 2019/2/27.
 */
public class LC367ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        } else if (num <= 1) {
            return true;
        }
        int low = 1, high = num;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LC367ValidPerfectSquare solution = new LC367ValidPerfectSquare();
        System.out.println(solution.isPerfectSquare(16)); // true
        System.out.println(solution.isPerfectSquare(14)); // false
        System.out.println(solution.isPerfectSquare(9)); // true
    }
}
