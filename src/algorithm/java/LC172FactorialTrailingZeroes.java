package algorithm.java;

public class LC172FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        int result = 0;
        do {
            n = n / 5;
            result += n;
        } while (n > 0);
        return result;
    }

    public static void main(String[] args) {
        LC172FactorialTrailingZeroes solution = new LC172FactorialTrailingZeroes();
        assert solution.trailingZeroes(3) == 0;
        assert solution.trailingZeroes(1) == 1;
        assert solution.trailingZeroes(25) == 6;
    }
}
