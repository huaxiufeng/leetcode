package algorithm.java.must;

/**
 * Created by huaxiufeng on 18/12/27.
 */
public class KMP {

    public int kmp(String text, String pattern) {
        if (pattern == null || pattern.length() == 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int[] next = getNext(pattern);
        while (i < text.length() && j < pattern.length()) {
            if (j == -1 || text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == pattern.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    private int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < pattern.length() - 1) {
            if (k == -1 || pattern.charAt(j) == pattern.charAt(k)) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        KMP solution = new KMP();
        System.out.println(solution.kmp("abababdafdasabcfdfeaba", "abc"));
    }
}
