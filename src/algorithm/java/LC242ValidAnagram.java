package algorithm.java;

public class LC242ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (null == s && null == t) {
            return true;
        } else if (null == s || null == t || s.length() != t.length()) {
            return false;
        }
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            ++count[c];
        }
        for (char c : t.toCharArray()) {
            if (--count[c] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC242ValidAnagram solution = new LC242ValidAnagram();
        System.out.println(solution.isAnagram("anagram", "nagaram")); // true
        System.out.println(solution.isAnagram("rat", "car")); // false
    }
}
