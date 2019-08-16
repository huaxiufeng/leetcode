package algorithm.java;

/**
 Given a positive integer n and you can do operations as follow:

 If n is even, replace n with n/2.
 If n is odd, you can replace n with either n + 1 or n - 1.
 What is the minimum number of replacements needed for n to become 1?

 Example 1:

 Input:
 8

 Output:
 3

 Explanation:
 8 -> 4 -> 2 -> 1
 Example 2:

 Input:
 7

 Output:
 4

 Explanation:
 7 -> 8 -> 4 -> 2 -> 1
 or
 7 -> 6 -> 3 -> 2 -> 1
 */
public class LC397IntegerReplacement {

    public int integerReplacement(int n) {
        if (n <= 1) {
            return 0;
        } else if (n == Integer.MAX_VALUE) {
            return 32;
        }
        if (n % 2 == 0) {
            return integerReplacement(n / 2) + 1;
        } else {
            return Math.min(integerReplacement(n - 1), integerReplacement(n + 1)) + 1;
        }
    }

    public static void main(String[] args) {
        LC397IntegerReplacement solution = new LC397IntegerReplacement();
        System.out.println(solution.integerReplacement(2147483647)); // 32
        System.out.println(solution.integerReplacement(65536)); // 16
        System.out.println(solution.integerReplacement(65535)); // 17
        System.out.println(solution.integerReplacement(8)); // 3
        System.out.println(solution.integerReplacement(7)); // 4
    }
}
