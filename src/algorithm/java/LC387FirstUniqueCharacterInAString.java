package algorithm.java;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

 Examples:

 s = "leetcode"
 return 0.

 s = "loveleetcode",
 return 2.
 Note: You may assume the string contain only lowercase letters.
 * Created by amyhuiye on 2017/5/24.
 */
public class LC387FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        if (null == s || 0 == s.length()) {
            return -1;
        }
        if (1 == s.length()) {
            return 0;
        }
        int[] counter = new int[256];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            counter[s.charAt(i)]++;
        }
        for (int i = 0; i < len; i++) {
            if (1 == counter[s.charAt(i)]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC387FirstUniqueCharacterInAString solution = new LC387FirstUniqueCharacterInAString();
        System.out.println(solution.firstUniqChar("leetcode"));
        System.out.println(solution.firstUniqChar("loveleetcode"));
        System.out.println(solution.firstUniqChar("aaaa"));
    }
}
