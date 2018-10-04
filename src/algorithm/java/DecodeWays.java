package algorithm.java;

/**
 * Created by huaxiufeng on 18/10/4.
 */
public class DecodeWays {

    public int numDecodings0(String s) {
        if (null == s) {
            return 0;
        }
        if (s.length() == 0) {
            return 1;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int result = 0;
        int value0 = s.charAt(0) - '0';
        int value1 = s.charAt(1) - '0';
        if (value1 != 0) {
            result += numDecodings0(s.substring(1));
        }
        if (value0 * 10 + value1 <= 26 && value0 * 10 + value1 >= 1) {
            result += numDecodings0(s.substring(2));
        }
        return result;
    }

    public int numDecodings1(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        int result[] = new int[s.length()+1];
        result[0] = 1;
        result[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= s.length(); i++) {
            int value1 = Integer.valueOf(s.substring(i-1, i));
            int value2 = Integer.valueOf(s.substring(i-2, i));
            int count  = 0;
            if (value1 >= 1 && value1 <= 9) {
                count += result[i-1];
            }
            if (value2 >= 10 && value2 <= 26) {
                count += result[i-2];
            }
            result[i] = count;
        }
        return result[s.length()];
    }

    public int numDecodings(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        int p0 = 1;
        int p1 = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= s.length(); i++) {
            int value1 = Integer.valueOf(s.substring(i-1, i));
            int value2 = Integer.valueOf(s.substring(i-2, i));
            int count  = 0;
            if (value1 >= 1 && value1 <= 9) {
                count += p1;
            }
            if (value2 >= 10 && value2 <= 26) {
                count += p0;
            }
            p0 = p1;
            p1 = count;
        }
        return p1;
    }

    public static void main(String[] args) {
        DecodeWays solution = new DecodeWays();
        System.out.println(solution.numDecodings("0"));
        System.out.println(solution.numDecodings("12"));
        System.out.println(solution.numDecodings("226"));
        System.out.println(solution.numDecodings("00"));
    }
}
