package algorithm.java;

/**
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 * Example:
 * Input: 2
 * Output: 91
 * Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100,
 * excluding 11,22,33,44,55,66,77,88,99

 * Created by huaxiufeng on 19/3/21.
 */
public class LC357CountNumbersWithUniqueDigits {

    /**
     Following the hint. Let f(n) = count of number with unique digits of length n.
     f(1) = 10. (0, 1, 2, 3, ...., 9)
     f(2) = 9 * 9. Because for each number i from 1, ..., 9, we can pick j to form a 2-digit number ij and there are 9 numbers that are different from i for j to choose from.
     f(3) = f(2) * 8 = 9 * 9 * 8. Because for each number with unique digits of length 2, say ij, we can pick k to form a 3 digit number ijk and there are 8 numbers that are different from i and j for k to choose from.
     Similarly f(4) = f(3) * 7 = 9 * 9 * 8 * 7....
     ...
     f(10) = 9 * 9 * 8 * 7 * 6 * ... * 1
     f(11) = 0 = f(12) = f(13)....
     */
    public int countNumbersWithUniqueDigits(int n) {
        if (0 == n) {
            return 1;
        }
        int[] f = new int[n + 1];
        int res = 0;
        for (int i = 1; i <= Math.min(n, 10); i++) {
            if (i == 1) {
                f[i] = 10;
            } else if (i == 2) {
                f[i] = 9 * 9;
            } else {
                f[i] = f[i - 1] * (10 - i + 1);
            }
            res += f[i];
        }
        return res;
    }

    public static void main(String[] args) {
        LC357CountNumbersWithUniqueDigits solution = new LC357CountNumbersWithUniqueDigits();
        System.out.println(solution.countNumbersWithUniqueDigits(1)); // 10
        System.out.println(solution.countNumbersWithUniqueDigits(2)); // 91
    }
}
