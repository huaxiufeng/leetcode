package algorithm.java;

/**
 * Created by huaxiufeng on 18/11/19.
 */
public class LC44WildcardMatching {

    public boolean isMatch(String s, String p) {
        // TODO
    }


    public static void main(String[] args) {
        LC44WildcardMatching solution = new LC44WildcardMatching();
        System.out.println(solution.isMatch("aa", "a")); // false
        System.out.println(solution.isMatch("aa", "*")); // true
        System.out.println(solution.isMatch("cb", "?a")); // false
        System.out.println(solution.isMatch("adceb", "*a*b")); // true
        System.out.println(solution.isMatch("acdcb", "a*c?b")); // false
    }
}
