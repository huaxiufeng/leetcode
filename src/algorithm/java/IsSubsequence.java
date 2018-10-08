package algorithm.java;

/**
 * Given a string s and a string t, check if s is subsequence of t.

 You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

 A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

 Example 1:
 s = "abc", t = "ahbgdc"

 Return true.

 Example 2:
 s = "axc", t = "ahbgdc"

 Return false.

 Follow up:
 If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?

 Credits:
 Special thanks to @pbrother for adding this problem and creating all test cases.

 * Created by huaxiufeng on 17/8/6.
 */
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        if (null == s || 0 == s.length()) {
            return true;
        }
        if (null == t || 0 == t.length()) {
            return false;
        }
        for (int sIndex = 0, tIndex = 0; tIndex < t.length(); tIndex++) {
            if (t.charAt(tIndex) == s.charAt(sIndex)) {
                sIndex++;
                if (sIndex == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IsSubsequence solution = new IsSubsequence();
        System.out.println(solution.isSubsequence("abc", "ahbgdc"));
        System.out.println(solution.isSubsequence("acb", "ahbgdc"));
        System.out.println(solution.isSubsequence("axc", "ahbgdc"));
    }
}