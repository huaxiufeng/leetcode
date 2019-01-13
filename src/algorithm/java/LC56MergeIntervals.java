package algorithm.java;

import algorithm.java.data.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * Created by huaxiufeng on 17/5/21.
 */
public class LC56MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        if (null == intervals || intervals.size() <= 1) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });
        List<Interval> result = new ArrayList<>();
        Interval currentInterval = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).end <= currentInterval.end) {
                continue;
            } else if (intervals.get(i).start <= currentInterval.end && intervals.get(i).end > currentInterval.end) {
                currentInterval.end = intervals.get(i).end;
            } else {
                result.add(currentInterval);
                currentInterval = intervals.get(i);
            }
        }
        result.add(currentInterval);
        return result;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));

        System.out.println("before");
        for (Interval interval : intervals) {
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        }

        long startTimeMillis = System.currentTimeMillis();
        List<Interval> result = new LC56MergeIntervals().merge(intervals);
        long endTimeMillis = System.currentTimeMillis();

        System.out.println("\nafter");
        for (Interval interval : result) {
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        }

        System.out.println("\ncost " + (endTimeMillis - startTimeMillis) + " ms");
    }
}
