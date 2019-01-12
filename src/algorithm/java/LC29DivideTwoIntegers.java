package algorithm.java;

/**
 * Created by huaxiufeng on 18/11/3.
 */
public class LC29DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        boolean negative = (dividend > 0) ^ (divisor > 0);
        long lDividend = Math.abs((long)dividend);
        long lDivisor = Math.abs((long)divisor);
        long lRes = longDivide(lDividend, lDivisor);
        lRes = negative ? (0 - lRes) : lRes;
        if (lRes >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } if (lRes <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)lRes;
    }

    private long longDivide(long dividend, long divisor) {
        if (0 == dividend || dividend < divisor) {
            return 0;
        }
        long sum = divisor;
        long count = 1;
        while (sum + sum < dividend) {
            sum += sum;
            count += count;
        }
        return count + longDivide(dividend - sum, divisor);
    }

    public static void main(String[] args) {
        LC29DivideTwoIntegers solution = new LC29DivideTwoIntegers();
        System.out.println(solution.divide(6, 3));
        System.out.println(solution.divide(-2147483648, -1));
        System.out.println(solution.divide(-7, 3));
        System.out.println(solution.divide(1, 1));
    }
}
