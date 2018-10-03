package algorithm.java;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.

 A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

 Example 1:

 Input: S = "rabbbit", T = "rabbit"
 Output: 3
 Explanation:

 As shown below, there are 3 ways you can generate "rabbit" from S.
 (The caret symbol ^ means the chosen letters)

 rabbbit
 ^^^^ ^^
 rabbbit
 ^^ ^^^^
 rabbbit
 ^^^ ^^^
 Example 2:

 Input: S = "babgbag", T = "bag"
 Output: 5
 Explanation:

 As shown below, there are 5 ways you can generate "bag" from S.
 (The caret symbol ^ means the chosen letters)

 babgbag
 ^^ ^
 babgbag
 ^^    ^
 babgbag
 ^    ^^
 babgbag
 ^  ^^
 babgbag
 ^^^

 * Created by huaxiufeng on 18/10/3.
 */
public class DistinctSubsequences {

    public int numDistinct(String s, String t) {
        if (null == s || null == t) {
            return 0;
        }
        if (s.length() < t.length()) {
            return 0;
        }
        if (0 == t.length()) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(0)) {
                count += numDistinct(s.substring(i+1), t.substring(1));
            }
        }
        return count;
    }

    public static void main(String[] args) {
        DistinctSubsequences solution = new DistinctSubsequences();
        System.out.println(solution.numDistinct("rabbbit", "rabbit"));
        System.out.println(solution.numDistinct("babgbag", "bag"));
    }
}
