package algorithm.java;

/**
 * Created by amyhuiye on 2018/12/13.
 */
public class LC151ReverseWordsinaString {

    public String reverseWords(String s) {
        if (null == s || s.length() == 0) {
            return s;
        }
        char[] arr = s.toCharArray();
        doReverse(arr, 0, arr.length - 1);
        int[] beginEnd = {-1 , -1};
        do {
            beginEnd = findBeginEnd(arr, beginEnd[1] + 1);
            if (null == beginEnd) {
                break;
            }
            doReverse(arr, beginEnd[0], beginEnd[1]);
        } while (true);
        int len = reduceSpace(arr);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append(arr[i]);
        }
        return builder.toString();
    }

    private void doReverse(char[] arr, int begin, int end) {
        while (begin < end) {
            char temp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = temp;
            begin++;
            end--;
        }
    }

    private int[] findBeginEnd(char[] arr, int start) {
        int begin = -1, end = arr.length - 1;
        for (int i = start; i < arr.length; i++) {
            if (arr[i] != ' ') {
                begin = i;
                break;
            }
        }
        if (begin == -1) {
            return null;
        }
        for (int i = begin; i < arr.length; i++) {
            if (arr[i] == ' ') {
                end = i - 1;
                break;
            }
        }
        return new int[]{begin, end};
    }

    private int reduceSpace(char[] arr) {
        int arrStart = 0;
        int arrEnd = arr.length - 1;
        while (arrStart < arr.length && arr[arrStart] == ' ') {
            arrStart++;
        }
        while (arrEnd >= 0 && arr[arrEnd] == ' ') {
            arrEnd--;
        }
        int resultLen = 0;
        int offset = arrStart;
        int continueSpaceCount = 0;
        for (int i = arrStart; i <= arrEnd; i++) {
            if (arr[i] != ' ') {
                arr[i-offset] = arr[i];
                resultLen++;
                continueSpaceCount = 0;
            } else {
                continueSpaceCount++;
                if (1 == continueSpaceCount) {
                    arr[i-offset] = arr[i];
                    resultLen++;
                } else {
                    offset++;
                }
            }
        }
        return resultLen;
    }

    public static void main(String[] args) {
        LC151ReverseWordsinaString solution = new LC151ReverseWordsinaString();
        System.out.println(solution.reverseWords(" "));
        System.out.println(solution.reverseWords("    "));
        System.out.println(solution.reverseWords("the sky is blue")); // blue is sky the
        System.out.println(solution.reverseWords("   the sky  is   blue   ")); // blue is sky the
    }
}
