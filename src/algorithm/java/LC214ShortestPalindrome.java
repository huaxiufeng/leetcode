package algorithm.java;

/**
 * Created by huaxiufeng on 18/12/26.
 */
public class LC214ShortestPalindrome {

    public String shortestPalindrome(String s) {
        if(null == s || s.length() <= 1){
            return s;
        }
        for (int end = s.length() - 1; end >= 0; end--) {
            if (isPalindrome(s, 0, end)) {
                StringBuilder builder = new StringBuilder(s.substring(end + 1));
                return builder.reverse().toString() + s;
            }
        }
        // can not reach here
        return s;
    }

    private boolean isPalindrome(String s, int begin, int end) {
        while (begin < end) {
            if (s.charAt(begin) != s.charAt(end)) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        LC214ShortestPalindrome solution = new LC214ShortestPalindrome();
        System.out.println(solution.shortestPalindrome("aacecaaa")); // aaacecaaa
        System.out.println(solution.shortestPalindrome("abcd")); // dcbabcd
    }
}
