package algorithm.java;

/**
 * Created by amyhuiye on 2018/11/13.
 */
public class LC67AddBinary {

    public String addBinary(String a, String b) {
        if (null == a || 0 == a.length()) return b;
        if (null == b || 0 == b.length()) return a;
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        while (indexA >= 0 || indexB >= 0) {
            int na = indexA >= 0 ? a.charAt(indexA) - '0' : 0;
            int nb = indexB >= 0 ? b.charAt(indexB) - '0' : 0;
            int value = na + nb + carry;
            carry = value / 2;
            builder.append(value % 2);
            indexA--;
            indexB--;
        }
        if (carry > 0) {
            builder.append(carry);
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        LC67AddBinary solution = new LC67AddBinary();
        System.out.println(solution.addBinary("11", "1")); // 100
        System.out.println(solution.addBinary("1010", "1011")); // 10101
    }
}
