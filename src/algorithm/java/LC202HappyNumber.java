package algorithm.java;

import java.util.HashSet;
import java.util.Set;

/**
 Write an algorithm to determine if a number is "happy".

 A happy number is a number defined by the following process:
 Starting with any positive integer, replace the number by the sum of the squares of its digits,
 and repeat the process until the number equals 1 (where it will stay),
 or it loops endlessly in a cycle which does not include 1.
 Those numbers for which this process ends in 1 are happy numbers.

 Example:

 Input: 19
 Output: true
 Explanation:
 1^2 + 9^2 = 82
 8^2 + 2^2 = 68
 6^2 + 8^2 = 100
 1^2 + 0^2 + 0^2 = 1

 * Created by huaxiufeng on 19/3/24.
 */
public class LC202HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> loopSet = new HashSet<>();
        while (n != 1) {
            n = sumOfDigitsSquare(n);
            if (loopSet.contains(n)) {
                return false;
            }
            loopSet.add(n);
        }
        return true;
    }

    private int sumOfDigitsSquare(int n) {
        int sum = 0;
        while (n > 0) {
            int k = n % 10;
            n = n / 10;
            sum += k * k;
        }
        return sum;
    }

    public static void main(String[] args) {
        LC202HappyNumber solution = new LC202HappyNumber();
        System.out.println(solution.isHappy(19)); // true
        System.out.println(solution.isHappy(18)); // false
    }
}
