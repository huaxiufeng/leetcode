package algorithm.java;

/**
 * Created by amyhuiye on 2019/3/13.
 */
public class LC434NumberOfSegmentsInaString {

    public int countSegments(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        int segments = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                if (i == 0 || s.charAt(i - 1) == ' ') {
                    segments++;
                }
            }
        }
        return segments;
    }

    public static void main(String[] args) {
        LC434NumberOfSegmentsInaString solution = new LC434NumberOfSegmentsInaString();
        System.out.println(solution.countSegments("Hello, my name is John")); // 5
    }
}
