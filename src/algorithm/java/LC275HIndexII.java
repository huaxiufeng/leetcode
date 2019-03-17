package algorithm.java;

/**
 * Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

 According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

 This is a follow up problem to H-Index, where citations is now guaranteed to be sorted in ascending order.
 Could you solve it in logarithmic time complexity?

 * Created by huaxiufeng on 19/3/17.
 */
public class LC275HIndexII {

    public int hIndex(int[] citations) {
        if (null == citations || citations.length < 1) {
            return 0;
        }
        int left = 0, right = citations.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int h = citations.length - mid;
            if (citations[mid] >= h) {
                right = mid - 1;
            } else if (citations[mid] < h) {
                left = mid + 1;
            }
        }
        return citations.length - left;
    }

    public static void main(String[] args) {
        LC275HIndexII solution = new LC275HIndexII();
        System.out.println(solution.hIndex(new int[]{100})); // 1
        System.out.println(solution.hIndex(new int[]{0})); // 0
        System.out.println(solution.hIndex(new int[]{0,1,3,5,6})); // 3
    }
}
