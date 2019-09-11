package algorithm.java;

import java.util.HashMap;
import java.util.Map;

public class LC166FractionToRecurringDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        if (numerator > 0 != denominator > 0) {
            builder.append("-");
        }
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        builder.append(num / den);
        num = num % den;
        if (0 == num) {
            return builder.toString();
        }
        builder.append(".");
        Map<Long, Integer> numLenMap = new HashMap<>();
        while (num != 0) {
            if (numLenMap.containsKey(num)) {
                builder.insert(numLenMap.get(num) - 1, "(");
                builder.append(")");
                break;
            } else {
                builder.append(num * 10 / den);
                numLenMap.put(num, builder.length());
            }
            num = num * 10 % den;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        LC166FractionToRecurringDecimal solution = new LC166FractionToRecurringDecimal();
        System.out.println(solution.fractionToDecimal(-1, -2147483648)); // 0.0000000004656612873077392578125
        System.out.println(solution.fractionToDecimal(1, 6)); // 0.1(6)
        System.out.println(solution.fractionToDecimal(2, 3)); // 0.(6)
        System.out.println(solution.fractionToDecimal(1, 2)); // 0.5
        System.out.println(solution.fractionToDecimal(2, 1)); // 2
        System.out.println(solution.fractionToDecimal(2, 7)); // 0.(285714)
    }
}
