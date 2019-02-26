package algorithm.java;

/**
 *
 There is a list of sorted integers from 1 to n. Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.

 Repeat the previous step again, but this time from right to left, remove the right most number and every other number from the remaining numbers.

 We keep repeating the steps again, alternating left to right and right to left, until a single number remains.

 Find the last number that remains starting with a list of length n.

 * Created by amyhuiye on 2019/2/27.
 */
public class LC390EliminationGame {

    public int lastRemaining(int n) {
        if (n == 1) {
            return 1;
        }
        return doLastRemaining(n, true);
    }

    private int doLastRemaining(int n, boolean leftToRight) {
        if (n <= 1) {
            return n;
        }
        if (n % 2 == 0 && !leftToRight) {
            return (doLastRemaining(n / 2, !leftToRight) - 1) * 2 + 1;
        } else {
            return doLastRemaining(n / 2, !leftToRight) * 2;
        }
    }

    public static void main(String[] args) {
        LC390EliminationGame solution = new LC390EliminationGame();
        System.out.println(solution.lastRemaining(9)); // 6
    }
}
