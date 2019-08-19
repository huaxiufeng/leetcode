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

    /**
     * Actually, the problem is the same as "Given a collection of intervals, find the maximum number of intervals that are non-overlapping."
     * (the classic Greedy problem: Interval Scheduling). With the solution to that problem, guess how do we get the minimum number of intervals to remove? : )
     *
     * Sorting Interval.end in ascending order is O(nlogn), then traverse intervals array to get the maximum number of non-overlapping intervals is O(n). Total is O(nlogn).
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (null == intervals || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        int end = intervals[0][1];
        int count = 1;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
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
