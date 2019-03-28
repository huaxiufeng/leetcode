package algorithm.java;

/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

 Note:

 The length of both num1 and num2 is < 5100.
 Both num1 and num2 contains only digits 0-9.
 Both num1 and num2 does not contain any leading zero.
 You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * Created by huaxiufeng on 17/5/21.
 */
public class LC415AddStrings {

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int advance = 0;
        int index = 0;
        while (true) {
            int c1 = -1, c2 = -1;
            int index1 = num1.length() - 1 - index;
            if (index1 >= 0) {
                c1 = num1.charAt(index1) - '0';
            }
            int index2 = num2.length() - 1 - index;
            if (index2 >= 0) {
                c2 = num2.charAt(index2) - '0';
            }
            if (c1 == -1 && c2 == -1 && advance == 0) {
                break;
            }
            c1 = (c1 < 0 ? 0 : c1);
            c2 = (c2 < 0 ? 0 : c2);
            int sum = c1 + c2 + advance;
            advance = 0;
            if (sum > 9) {
                sum = sum - 10;
                advance = 1;
            }
            sb.insert(0, sum);
            index++;
        }
        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LC415AddStrings solution = new LC415AddStrings();
        System.out.println(solution.addStrings("123", "1"));
        System.out.println(solution.addStrings("78", "9"));
        System.out.println(solution.addStrings("98", "9"));
        System.out.println(solution.addStrings("998", "0"));
        System.out.println(solution.addStrings("0", "0"));
        System.out.println(solution.addStrings("6", "501"));
    }
}
