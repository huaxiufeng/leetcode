package algorithm.java;

import java.util.Arrays;

/**
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

 According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

 Example:

 Input: citations = [3,0,6,1,5]
 Output: 3
 Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
 received 3, 0, 6, 1, 5 citations respectively.
 Since the researcher has 3 papers with at least 3 citations each and the remaining
 two with no more than 3 citations each, her h-index is 3.
 Note: If there are several possible values for h, the maximum one is taken as the h-index.

 * Created by huaxiufeng on 19/3/17.
 */
public class LC274HIndex {

    public int hIndex(int[] citations) {
        if (null == citations || citations.length < 1) {
            return 0;
        }
        Arrays.sort(citations);
        for(int h = 1; h <= citations.length; h++) {
            int i = citations.length - h;
            if (citations[i] < h) {
                return h - 1;
            }
        }
        return citations.length;
    }

    public static void main(String[] args) {
        LC274HIndex solution = new LC274HIndex();
        System.out.println(solution.hIndex(new int[]{3,0,6,1,5})); // 3
    }
}
