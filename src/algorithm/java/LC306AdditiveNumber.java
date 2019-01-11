package algorithm.java;

/**
 * Created by huaxiufeng on 19/1/11.
 */
public class LC306AdditiveNumber {

    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) {
            return false;
        }
        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(0) == '0' && i > 1) {
                continue;
            }
            long first = Long.parseLong(num.substring(0, i));
            for (int j = i + 1; j < num.length(); j++) {
                if (num.charAt(i) == '0' && j - i > 1) {
                    continue;
                }
                long second = Long.parseLong(num.substring(i, j));
                if (match(first, second, num.substring(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean match(long first, long second, String num) {
        if (num.length() == 0) {
            return true;
        }
        long third = first + second;
        String thirdStr = Long.toString(third);
        return num.startsWith(thirdStr) && match(second, third, num.substring(thirdStr.length()));
    }

    public static void main(String[] args) {
        LC306AdditiveNumber solution = new LC306AdditiveNumber();
        System.out.println(solution.isAdditiveNumber("0235813")); // false
        System.out.println(solution.isAdditiveNumber("1023")); // false
        System.out.println(solution.isAdditiveNumber("189")); // true
        System.out.println(solution.isAdditiveNumber("17926")); // true
        System.out.println(solution.isAdditiveNumber("18990")); // true
        System.out.println(solution.isAdditiveNumber("18927")); // true
        System.out.println(solution.isAdditiveNumber("199100199")); // true
        System.out.println(solution.isAdditiveNumber("112358")); // true
        System.out.println(solution.isAdditiveNumber("1492762")); // false
    }
}
