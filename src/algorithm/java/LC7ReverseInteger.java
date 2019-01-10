package algorithm.java;

/**
 * Created by huaxiufeng on 19/1/10.
 */
public class LC7ReverseInteger {

    public int reverse(int x) {
        boolean negative = x < 0;
        if (negative) {
            x = -1 * x;
        }
        long xl = x;
        long lx = 0;
        while (xl > 0) {
            lx = lx * 10 + xl % 10;
            xl = xl / 10;
        }
        if (negative) {
            lx = -1 * lx;
        }
        if (lx > Integer.MAX_VALUE || lx < Integer.MIN_VALUE) {
            lx = 0;
        }
        return (int)lx;
    }

    public static void main(String[] args) {
        LC7ReverseInteger solution = new LC7ReverseInteger();
        System.out.println(solution.reverse(123)); // 321
        System.out.println(solution.reverse(-123)); // -321
        System.out.println(solution.reverse(120)); // 21
    }
}
