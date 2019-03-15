package algorithm.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * Created by amyhuiye on 2019/3/16.
 */
public class LC279PerfectSquares {

    public int numSquares(int n) {
        List<Integer> ps = new ArrayList<>();
        int x = 1;
        while (x * x <= n) {
            ps.add(x * x);
            x++;
        }
        int[] res = new int[n+1];
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            res[i] = n;
            for (int s : ps) {
                int index = i - s;
                if (index >= 0) {
                    res[i] = Math.min(res[i], res[index] + 1);
                } else {
                    break;
                }
            }
        }
        return res[n];
    }

    public static void main(String[] args) {
        LC279PerfectSquares solution = new LC279PerfectSquares();
        System.out.println(solution.numSquares(6337)); // 2
        System.out.println(solution.numSquares(4)); // 1
        System.out.println(solution.numSquares(12)); // 3
        System.out.println(solution.numSquares(13)); // 2
    }
}
