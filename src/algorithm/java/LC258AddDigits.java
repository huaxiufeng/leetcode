package algorithm.java;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

 Example:

 Input: 38
 Output: 2
 Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 Since 2 has only one digit, return it.
 Follow up:
 Could you do it without any loop/recursion in O(1) runtime?

 * Created by huaxiufeng on 19/3/11.
 */
public class LC258AddDigits {

    public int addDigitsBruteForce(int num) {
        if (num <= 9) {
            return num;
        }
        int sum = 0;
        while (num > 0) {
            sum += (num % 10);
            num = num / 10;
        }
        return addDigitsBruteForce(sum);
    }

    // 如果一个正整数可以被9整除，那么各个位之和也可以被9整除
    public int addDigits(int num) {
        int res = num % 9;
        if (res == 0 && num != 0) {
            res = 9;
        }
        return res;
    }

    public static void main(String[] args) {
        LC258AddDigits solution = new LC258AddDigits();
        System.out.println(solution.addDigits(3)); // 3
        System.out.println(solution.addDigits(38)); // 2
    }
}
