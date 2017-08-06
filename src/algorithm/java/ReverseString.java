package algorithm.java;

/**
 * Created by huaxiufeng on 17/8/6.
 */
public class ReverseString {

    public String reverseString(String s) {
        if (null == s || s.length() <= 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseString solution = new ReverseString();
        System.out.println(solution.reverseString("hello"));
    }
}
