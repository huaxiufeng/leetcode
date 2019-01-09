package algorithm.java;

/**
 * Created by amyhuiye on 2019/1/10.
 */
public class LC14LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        LC14LongestCommonPrefix solution = new LC14LongestCommonPrefix();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"})); // "fl"
        System.out.println(solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"})); // ""
    }
}
