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
        // TODO
        return false;
    }

    public static void main(String[] args) {
        LC97InterleavingString solution = new LC97InterleavingString();
        System.out.println(solution.isInterleave("aabc", "abad", "aabadabc")); // true
        System.out.println(solution.isInterleave("", "b", "b")); // true
        System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbcbcac")); // true
        System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbbaccc")); // false
    }
}
