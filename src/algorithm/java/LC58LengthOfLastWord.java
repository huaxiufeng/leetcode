package algorithm.java;

/**
 * Created by huaxiufeng on 18/11/8.
 */
public class LC58LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        int len = 0;
        int lastIndex = s.length() - 1;
        while (lastIndex >= 0 && s.charAt(lastIndex) == ' ') {
            lastIndex--;
        }
        while (lastIndex >= 0 && s.charAt(lastIndex) != ' ') {
            lastIndex--;
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        LC58LengthOfLastWord solution = new LC58LengthOfLastWord();
        System.out.println(solution.lengthOfLastWord("Hello World   "));
        System.out.println(solution.lengthOfLastWord("Hello World"));
        System.out.println(solution.lengthOfLastWord("fuck"));
    }
}
