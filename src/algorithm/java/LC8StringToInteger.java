package algorithm.java;

/**
 * Created by huaxiufeng on 19/1/10.
 */
public class LC8StringToInteger {

    public int myAtoi(String str) {
        if (null == str || str.length() == 0) {
            return 0;
        }
        Boolean negative = null;
        Long number = null;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '-') {
                if (null == number && null == negative) {
                    negative = true;
                    number = 0L;
                } else {
                    break;
                }
            } else if (c == '+') {
                if (null == number && null == negative) {
                    negative = false;
                    number = 0L;
                } else {
                    break;
                }
            } else if (c == ' ') {
                if (number != null) {
                    break;
                }
            } else if (c >= '0' && c <= '9') {
                if (null == number) {
                    number = 0L;
                }
                number = number * 10 + (c - '0');
                if (number > Integer.MAX_VALUE) {
                    if (negative != null && negative) {
                        return Integer.MIN_VALUE;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }
            } else {
                break;
            }
        }
        if (null == number) {
            number = 0L;
        }
        if (negative != null && negative) {
            number = number * -1;
        }
        return (int) number.longValue();
    }

    public static void main(String[] args) {
        LC8StringToInteger solution = new LC8StringToInteger();
        System.out.println(solution.myAtoi("-9223372036854775809")); // -2147483648
        System.out.println(solution.myAtoi("- 234")); // 0
        System.out.println(solution.myAtoi("9223372036854775808")); // 2147483647
        System.out.println(solution.myAtoi("+0 123")); // 0
        System.out.println(solution.myAtoi("+-2")); // 0
        System.out.println(solution.myAtoi("42")); // 42
        System.out.println(solution.myAtoi("    -42  ")); // -42
        System.out.println(solution.myAtoi("4193 with words")); // 4193
        System.out.println(solution.myAtoi("words and 987")); // 0
        System.out.println(solution.myAtoi("-91283472332")); // -2147483648
    }
}
