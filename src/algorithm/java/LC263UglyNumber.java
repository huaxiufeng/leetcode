package algorithm.java;

/**
 * Write a program to check whether a given number is an ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * Created by huaxiufeng on 19/1/26.
 */
public class LC263UglyNumber {

    public boolean isUgly(int num) {
        int[] factors = new int[]{2, 3, 5};
        while (num >= 1) {
            boolean found = false;
            for (int factor : factors) {
                if (num % factor == 0) {
                    num = num / factor;
                    found = true;
                }
                if (1 == num) {
                    return true;
                }
            }
            if (!found) {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LC263UglyNumber solution = new LC263UglyNumber();
        System.out.println(solution.isUgly(6)); // true
        System.out.println(solution.isUgly(8)); // true
        System.out.println(solution.isUgly(14)); // false
    }
}
