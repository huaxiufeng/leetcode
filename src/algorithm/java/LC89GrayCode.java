package algorithm.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 The gray code is a binary numeral system where two successive values differ in only one bit.

 Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

 Example 1:

 Input: 2
 Output: [0,1,3,2]
 Explanation:
 00 - 0
 01 - 1
 11 - 3
 10 - 2

 For a given n, a gray code sequence may not be uniquely defined.
 For example, [0,2,3,1] is also a valid gray code sequence.

 00 - 0
 10 - 2
 11 - 3
 01 - 1
 */
public class LC89GrayCode {

    public List<Integer> grayCode(int n) {
        if (n == 0) {
            return Arrays.asList(0);
        } else if (n == 1) {
            return Arrays.asList(0, 1);
        }
        List<Integer> preList = grayCode(n - 1);
        List<Integer> resultList = new ArrayList<>(preList.size() * 2);
        resultList.addAll(preList);
        for (int i = preList.size() - 1; i >= 0; i--) {
            resultList.add((1 << (n-1)) + preList.get(i));
        }
        return resultList;
    }

    public static void main(String[] args) {
        LC89GrayCode solution = new LC89GrayCode();
        System.out.println(solution.grayCode(2));
        System.out.println(solution.grayCode(3));
    }
}
