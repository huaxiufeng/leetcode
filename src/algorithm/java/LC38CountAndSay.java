package algorithm.java;

/**
 * Created by amyhuiye on 2018/11/5.
 */
public class LC38CountAndSay {

    public String countAndSay(int n) {
        String result = "1";
        for (int i = 2; i <= n; i++) {
            result = doCountAndSay(result);
        }
        return result;
    }

    private String doCountAndSay(String s) {
        StringBuilder builder = new StringBuilder();
        char pc = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != pc) {
                builder.append(count).append(pc);
                pc = c;
                count = 1;
            } else {
                count++;
            }
        }
        builder.append(count).append(pc);
        return builder.toString();
    }

    public static void main(String[] args) {
        LC38CountAndSay solution = new LC38CountAndSay();
        System.out.println(solution.countAndSay(10));
    }
}
