package algorithm.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huaxiufeng on 18/11/15.
 */
public class LC97InterleavingString {

    // Memory Limit Exceeded
//    public boolean isInterleave(String s1, String s2, String s3) {
//        List<String> resultList = new ArrayList<>();
//        doInterLeave(resultList, new StringBuilder(), s1, 0, s2, 0);
//        System.out.println(resultList);
//        return resultList.contains(s3);
//    }
//
//    private void doInterLeave(List<String> resultList, StringBuilder temp, String s1, int s1Index, String s2, int s2Index) {
//        if (s1Index == s1.length() && s2Index == s2.length()) {
//            resultList.add(temp.toString());
//            return;
//        }
//        if (s1Index < s1.length()) {
//            temp.append(s1.charAt(s1Index));
//            doInterLeave(resultList, temp, s1, s1Index + 1, s2, s2Index);
//            temp.deleteCharAt(temp.length() - 1);
//        }
//        if (s2Index < s2.length()) {
//            temp.append(s2.charAt(s2Index));
//            doInterLeave(resultList, temp, s1, s1Index, s2, s2Index + 1);
//            temp.deleteCharAt(temp.length() - 1);
//        }
//    }

    // Time Limit Exceeded
//    public boolean isInterleave(String s1, String s2, String s3) {
//        if (null == s1 || null == s2 || null == s3) {
//            return false;
//        }
//        if (s1.length() + s2.length() != s3.length()) {
//            return false;
//        }
//        return doInterLeave(new StringBuilder(), s1, 0, s2, 0, s3);
//    }
//
//    private boolean doInterLeave(StringBuilder temp, String s1, int s1Index, String s2, int s2Index, String s3) {
//        if (s1Index == s1.length() && s2Index == s2.length()) {
//            return true;
//        }
//        boolean res = false;
//        if (s1Index < s1.length()) {
//            if (s1.charAt(s1Index) == s3.charAt(s1Index + s2Index)) {
//                temp.append(s1.charAt(s1Index));
//                res = doInterLeave(temp, s1, s1Index + 1, s2, s2Index, s3);
//                temp.deleteCharAt(temp.length() - 1);
//            }
//            if (res) {
//                return true;
//            }
//        }
//        if (s2Index < s2.length()) {
//            if (s2.charAt(s2Index) == s3.charAt(s1Index + s2Index)) {
//                temp.append(s2.charAt(s2Index));
//                res = doInterLeave(temp, s1, s1Index, s2, s2Index + 1, s3);
//                temp.deleteCharAt(temp.length() - 1);
//            }
//            if (res) {
//                return true;
//            }
//        }
//        return false;
//    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (null == s1 || null == s2 || null == s3) {
            return false;
        } else if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        // dp[i][j]为true表示s1的前i个字符和s2的前j个字符交叉可以得到s3的前i+j个字符
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = dp[i-1][0] && (s1.charAt(i-1) == s3.charAt(i-1));
        }
        for (int j = 1; j <= s2.length(); j++) {
            dp[0][j] = dp[0][j-1] && (s2.charAt(j-1) == s3.charAt(j-1));
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                dp[i][j] = (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1))
                        || (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1));
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        LC97InterleavingString solution = new LC97InterleavingString();
        System.out.println(solution.isInterleave("aabc", "abad", "aabadabc")); // true
        System.out.println(solution.isInterleave("", "b", "b")); // true
        System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbcbcac")); // true
        System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbbaccc")); // false
    }
}
