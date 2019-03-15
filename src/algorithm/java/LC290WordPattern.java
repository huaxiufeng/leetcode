package algorithm.java;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.

 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

 Example 1:

 Input: pattern = "abba", str = "dog cat cat dog"
 Output: true

 * Created by amyhuiye on 2019/3/16.
 */
public class LC290WordPattern {

    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length) {
            return false;
        }
        Map<Character, String> cMap = new HashMap<>();
        Map<String, Character> sMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String s = strs[i];
            if (!cMap.containsKey(c)) {
                cMap.put(c, s);
            } else {
                if (!s.equals(cMap.get(c))) {
                    return false;
                }
            }

            if (!sMap.containsKey(s)) {
                sMap.put(s, c);
            } else {
                if (c != sMap.get(s)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC290WordPattern solution = new LC290WordPattern();
        System.out.println(solution.wordPattern("abba", "dog cat cat dog")); // true
        System.out.println(solution.wordPattern("abba", "dog cat cat fish")); // false
        System.out.println(solution.wordPattern("aaaa", "dog cat cat dog")); // false
        System.out.println(solution.wordPattern("abba", "dog dog dog dog")); // false
    }
}
