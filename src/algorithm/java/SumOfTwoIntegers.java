package algorithm.java;

/**
 * Created by amyhuiye on 2017/5/24.
 */
public class SumOfTwoIntegers {

    public int getSum(int a, int b) {
        if (0 == b) {
            return a;
        }
        int sum = a ^ b;
        int extra = a & b;
        return getSum(sum, extra << 1);
    }

    public static void main(String[] args) {
        SumOfTwoIntegers solution = new SumOfTwoIntegers();
        System.out.println(solution.getSum(1, 2));
        System.out.println(solution.getSum(11, 3));
        System.out.println(solution.getSum(98, 16));
        System.out.println(solution.getSum(-10, 5));
    }
}
