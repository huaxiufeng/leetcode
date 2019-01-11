package algorithm.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

 Example:

 Input: S = "ADOBECODEBANC", T = "ABC"
 Output: "BANC"
 Note:

 If there is no such window in S that covers all characters in T, return the empty string "".
 If there is such window, you are guaranteed that there will always be only one unique minimum window in S.

 * Created by huaxiufeng on 19/1/11.
 */
public class LC76MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (null == s || null == t) {
            return "";
        }
        Map<Character, Integer> tMap = new HashMap<>(); // t中出现的字符对应的次数
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        Map<Character, Integer> sMap = new HashMap<>(); // s在窗口中出现的t中的字符的次数
        Set<Character> sSet = new HashSet<>(); // s在窗口中已符合条件的字符集合
        int begin = 0, end = 0; // 窗口的起止位置
        String result = null;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!tMap.containsKey(c)) {
                continue;
            }
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            if (sMap.get(c) >= tMap.get(c)) { // 符合条件了就记录到sSet中
                sSet.add(c);
            }
            if (sSet.size() == tMap.size()) { // 符合条件了
                end = i;
                while (begin <= end) {
                    if (null == result || result.length() > end - begin + 1) {
                        result = s.substring(begin, end + 1);
                    }
                    char cb = s.charAt(begin);
                    begin++;
                    if (tMap.containsKey(cb)) {
                        int cbn = sMap.get(cb);
                        cbn--;
                        sMap.put(cb, cbn);
                        if (cbn < tMap.get(cb)) {
                            sSet.remove(cb);
                            break;
                        }
                    }
                }
            }
        }
        return result != null ? result : "";
    }

    public static void main(String[] args) {
        LC76MinimumWindowSubstring solution = new LC76MinimumWindowSubstring();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC")); // BANC
        System.out.println(solution.minWindow("a", "a")); // a
        System.out.println(solution.minWindow("a", "aa")); // ""
    }
}
