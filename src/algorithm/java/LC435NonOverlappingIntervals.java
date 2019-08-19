package algorithm.java;

import java.util.Arrays;
import java.util.Comparator;

/**
 Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

 Example 1:

 Input: [[1,2],[2,3],[3,4],[1,3]]
 Output: 1
 Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
 */
public class LC435NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (null == intervals || intervals.length == 0) {
            return 0;
        }
        // 排序
        // 1) sort by end, smaller end in front
        // 2) if end is same, sort by start, bigger start in front
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int cmp = Integer.compare(o1[1], o2[1]);
                if (0 == cmp) {
                    cmp = Integer.compare(o2[0], o1[0]);
                }
                return cmp;
            }
        });

        int end = Integer.MIN_VALUE;
        int count = 0;
        for (int[] interval : intervals) {
            if (interval[0] >= end) {
                end = interval[1];
            } else {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        LC435NonOverlappingIntervals solution = new LC435NonOverlappingIntervals();
        System.out.println(solution.eraseOverlapIntervals(new int[][]{
                {1,100},{11,22},{1,11},{2,12}
        })); // 2
        System.out.println(solution.eraseOverlapIntervals(new int[][]{
                {1,2},{2,3}
        })); // 0
        System.out.println(solution.eraseOverlapIntervals(new int[][]{
                {1,2},{2,3},{3,4},{1,3}
        })); // 1
        System.out.println(solution.eraseOverlapIntervals(new int[][]{
                {1,2},{1,2},{1,2}
        })); // 2
    }
}
