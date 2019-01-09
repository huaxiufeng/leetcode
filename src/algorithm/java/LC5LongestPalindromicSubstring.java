package algorithm.java;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example:

 Input: "babad"

 Output: "bab"

 Note: "aba" is also a valid answer.
 Example:

 Input: "cbbd"

 Output: "bb"

 * Created by huaxiufeng on 17/8/27.
 */
public class LC5LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (null == s || s.length() <= 1) {
            return s;
        }
        int len = s.length();
        boolean dp[][] = new boolean[len][len];
        int start=0, end=0;
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            if (i < len - 1 && s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                start = i; end = i + 1;
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (i + 1 < len && j - 1 >= 0 && i + 1 <= j - 1) {
                    if (dp[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                        if (j - i > end - start) {
                            start = i; end = j;
                        }
                    }
                }
            }
        }
        return s.substring(start, end+1);
    }

    public static void main(String[] args) {
        LC5LongestPalindromicSubstring solution = new LC5LongestPalindromicSubstring();
        System.out.println(solution.longestPalindrome("babadada"));
        System.out.println(solution.longestPalindrome("abccba"));
        System.out.println(solution.longestPalindrome("cbbd"));
        System.out.println(solution.longestPalindrome("babad"));
    }
}
