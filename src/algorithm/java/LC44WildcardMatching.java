package algorithm.java;

/**
 * Created by huaxiufeng on 18/11/19.
 */
public class LC44WildcardMatching {

    public boolean isMatch(String s, String p) {
        int row = p.length();
        int col = s.length();

        // dp[i][j]为true意味着: p的前i个字符与s的前j个字符匹配
        boolean[][] dp = new boolean[row + 1][col + 1];
        dp[0][0] = true;

        // this is the case to deal multiple * at the beginning of the pattern
        // 如果p开头有*，那么p开头的部分和空的s都是匹配的上的
        for (int i = 0; i < row; i++) {
            if (p.charAt(i) == '*') {
                dp[i + 1][0] = true;
            } else {
                break;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (p.charAt(i) == s.charAt(j) || p.charAt(i) == '?') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(i) == '*') {
                    // ex: s = "acdcb", p = "a*c?b", when compare "acdcb" with "a*"
                    // get the state of dp["a"]["acdcb"] or dp["a*"]["acdc"]
                    dp[i + 1][j + 1] = dp[i][j + 1] | dp[i + 1][j];
                }
            }
        }
        return dp[row][col];
    }


    public static void main(String[] args) {
        LC44WildcardMatching solution = new LC44WildcardMatching();
        System.out.println(solution.isMatch("aa", "*")); // true
        System.out.println(solution.isMatch("adceb", "a*b")); // true
        System.out.println(solution.isMatch("aa", "a")); // false
        System.out.println(solution.isMatch("cb", "?a")); // false
        System.out.println(solution.isMatch("adceb", "*a*b")); // true
        System.out.println(solution.isMatch("acdcb", "a*c?b")); // false
    }
}
