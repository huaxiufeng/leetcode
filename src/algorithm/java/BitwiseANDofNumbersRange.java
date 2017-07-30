package algorithm.java;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

 For example, given the range [5, 7], you should return 4.

 * Created by huaxiufeng on 17/7/2.
 */
public class BitwiseANDofNumbersRange {

    public int rangeBitwiseAnd(int m, int n) {
        int x = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            x++;
        }
        return n << x;
    }

    public int rangeBitwiseAndBenchMark(int m, int n) {
        int result = m;
        for (int i = m + 1 ; i <= n; i++) {
            result = result & i;
        }
        return result;
    }

    public static void main(String[] args) {
        BitwiseANDofNumbersRange solution = new BitwiseANDofNumbersRange();
        long startTime = System.currentTimeMillis();
        System.out.println(solution.rangeBitwiseAndBenchMark(1147483640, 2147483646));
        System.out.println("benchMark cost " + (System.currentTimeMillis() - startTime));
        startTime = System.currentTimeMillis();
        System.out.println(solution.rangeBitwiseAnd(1147483640, 2147483646));
        System.out.println("mine cost " + (System.currentTimeMillis() - startTime));
    }
}
