package algorithm.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amyhuiye on 2018/11/28.
 */
public class LC131PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> resultList = new ArrayList<>();
        doPartition(resultList, new ArrayList<>(), s, 0, s.length() - 1);
        return resultList;
    }

    private void doPartition(List<List<String>> resultList, List<String> temp, String s, int start, int end) {
        if (start > end) {
            resultList.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= end; i++) {
            if (isPalindrome(s, start, i)) {
                temp.add(s.substring(start, i + 1));
                doPartition(resultList, temp, s, i + 1, end);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        LC131PalindromePartitioning solution = new LC131PalindromePartitioning();
        System.out.println(solution.partition("aab"));
    }
}
