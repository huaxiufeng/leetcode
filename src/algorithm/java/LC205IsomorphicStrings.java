package algorithm.java;

import java.util.HashMap;
import java.util.Map;

/**
 Given two strings s and t, determine if they are isomorphic.

 Two strings are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character while preserving the order of characters.
 No two characters may map to the same character but a character may map to itself.

 * Created by huaxiufeng on 19/3/24.
 */
public class LC205IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        if (null == s && null == t) {
            return true;
        } else if (null == s || null == t || s.length() != t.length()) {
            return false;
        }
        int len = s.length();
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            Character msc = sMap.get(sc);
            Character mtc = tMap.get(tc);
            if (null == msc && null == mtc) {
                sMap.put(sc, tc);
                tMap.put(tc, sc);
            } else if (null != msc && null != mtc) {
                if (msc != tc || mtc != sc) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isIsomorphicFast(String s, String t) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) {
                return false;
            }
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        LC205IsomorphicStrings solution = new LC205IsomorphicStrings();
        System.out.println(solution.isIsomorphic("egg", "add")); // true
        System.out.println(solution.isIsomorphic("foo", "bar")); // false
        System.out.println(solution.isIsomorphic("paper", "title")); // true

    }
}
