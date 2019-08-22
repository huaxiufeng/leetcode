package algorithm.java;

/**
 Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

 Note:
 The length of num is less than 10002 and will be ≥ k.
 The given num does not contain any leading zero.
 */
public class LC402RemoveKDigits {

    private int min = Integer.MAX_VALUE;

    public String removeKdigitsError(String num, int k) {
        min = Integer.MAX_VALUE;
        int len = num.length();
        if (k >= len) {
            return "0";
        }
        doSubString(num, new StringBuilder(), len - k, 0);
        return String.valueOf(min);
    }

    private void doSubString(String num, StringBuilder builder, int len, int index) {
        if (builder.length() == len) {
            int n = Integer.valueOf(builder.toString());
            if (n < min) {
                min = n;
            }
        }
        for (int i = index; i < num.length(); i++) {
            builder.append(num.charAt(i));
            doSubString(num, builder, len, i + 1);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (k >= len) {
            return "0";
        } else if (k == 0) {
            return num;
        } else if (k == 1) {
            String result = null;
            for (int i = 0; i < num.length() - 1; i++) {
                if (num.charAt(i) > num.charAt(i + 1)) {
                    result = num.substring(0, i) + num.substring(i + 1);
                    break;
                }
            }
            if (null == result) {
                result = num.substring(0, num.length() - 1);
            }
            int leadingZeroCount = 0;
            for (int i = 0; i < result.length(); i++) {
                if (result.charAt(i) == '0') {
                    leadingZeroCount++;
                } else {
                    break;
                }
            }
            if (leadingZeroCount == result.length()) {
                return "0";
            }
            return result.substring(leadingZeroCount);
        } else {
            return removeKdigits(removeKdigits(num, 1), k - 1);
        }
    }

    public static void main(String[] args) {
        LC402RemoveKDigits solution = new LC402RemoveKDigits();
        System.out.println(solution.removeKdigits("0", 0)); // "0"
        System.out.println(solution.removeKdigits("1432219", 3)); // "1219"
        System.out.println(solution.removeKdigits("123", 2)); // "1"
        System.out.println(solution.removeKdigits("10200", 1)); // "200"
        System.out.println(solution.removeKdigits("10", 2)); // "0"
    }
}
