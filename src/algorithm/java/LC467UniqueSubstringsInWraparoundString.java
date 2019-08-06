package algorithm.java;

import java.util.HashSet;
import java.util.Set;

/**
 * Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz", so s will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
 * <p>
 * Now we have another string p. Your job is to find out how many unique non-empty substrings of p are present in s. In particular, your input is the string p and you need to output the number of
 * different non-empty substrings of p in the string s.
 * <p>
 * Note: p consists of only lowercase English letters and the size of p might be over 10000.
 * <p>
 * Created by huaxiufeng on 19/4/5.
 */
public class LC467UniqueSubstringsInWraparoundString {

    // Time Limit Exceeded
    public int findSubstringInWraproundString0(String p) {
        if (null == p || p.length() == 0) {
            return 0;
        }
        Set<String> set = new HashSet<>();
        int len = p.length();
        boolean[][] sequence = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (i == j || (sequence[i][j - 1] && (p.charAt(j) - p.charAt(j - 1) + 26) % 26 == 1)) {
                    sequence[i][j] = true;
                    set.add(p.substring(i, j + 1));
                }
            }
        }
        return set.size();
    }

    public int findSubstringInWraproundString(String p) {
        if (null == p || p.length() == 0) {
            return 0;
        }
        int dp[] = new int[26];
        int i = 0;
        int n = p.length();
        char[] s = p.toCharArray();
        int len = 1;
        while (i < n) {
            char prev = s[i];
            i++;
            dp[prev - 'a'] = Math.max(dp[prev - 'a'], len);
            while (i < p.length() && s[i] - 'a' == (prev - 'a' + 1) % 26) {
                prev = s[i];
                len++;
                i++;
                dp[prev - 'a'] = Math.max(dp[prev - 'a'], len);
            }
            len = 1;
        }
        int count = 0;
        for (int j = 0; j < 26; j++) {
            count += dp[j];
        }
        return count;
    }

    public static void main(String[] args) {
        LC467UniqueSubstringsInWraparoundString solution = new LC467UniqueSubstringsInWraparoundString();
        System.out.println(solution.findSubstringInWraproundString("zabzab")); // 6
        System.out.println(solution.findSubstringInWraproundString("zab")); // 6
        System.out.println(solution.findSubstringInWraproundString("zaba")); // 6
        System.out.println(solution.findSubstringInWraproundString("a")); // 1
        System.out.println(solution.findSubstringInWraproundString("aabb")); // 3
        System.out.println(solution.findSubstringInWraproundString("cac")); // 2
    }
}
