package algorithm.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by huaxiufeng on 17/5/21.
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:
 Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

 Example 2:
 Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

 This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (null == intervals || 0 == intervals.size()) {
            return Arrays.asList(newInterval);
        }
        int index= 0 ;
        List<Interval> result = new ArrayList<>();
        while (index < intervals.size() && intervals.get(index).end < newInterval.start) {
            result.add(intervals.get(index++));
        }
        while (index < intervals.size() && !(intervals.get(index).start > newInterval.end)) {
            newInterval.start = Math.min(intervals.get(index).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(index).end, newInterval.end);
            index++;
        }
        result.add(newInterval);
        while (index < intervals.size()) {
            result.add(intervals.get(index++));
        }
        return result;
    }

    // stupid
//    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
//        if (null == intervals || 0 == intervals.size()) {
//            return Arrays.asList(newInterval);
//        }
//        List<Interval> result = new ArrayList<>();
//        boolean merged = false;
//        int newStart = newInterval.start;
//        int newEnd = newInterval.end;
//        for (Interval interval : intervals) {
//            if (newInterval.start >= interval.start && newInterval.start <= interval.end) {
//                newStart = interval.start;
//                merged = true;
//            }
//            if (newInterval.end >= interval.start && newInterval.end <= interval.end) {
//                newEnd = interval.end;
//                merged = true;
//            }
//        }
//
//        boolean inserted = false;
//        for (Interval interval : intervals) {
//            if (!merged && !inserted && newEnd < interval.start) {
//                result.add(new Interval(newStart, newEnd));
//                inserted = true;
//            }
//            if (interval.end < newStart || interval.start > newEnd) {
//                result.add(interval);
//            } else {
//                if (!inserted) {
//                    result.add(new Interval(newStart, newEnd));
//                    inserted = true;
//                }
//            }
//        }
//        if (!inserted) {
//            result.add(new Interval(newStart, newEnd));
//        }
//        return result;
//    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 2));
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(12, 16));

        System.out.println("before");
        for (Interval interval : intervals) {
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        }

        long startTimeMillis = System.currentTimeMillis();
        List<Interval> result = new InsertInterval().insert(intervals, new Interval(4, 9));
        long endTimeMillis = System.currentTimeMillis();

        System.out.println("\nafter");
        for (Interval interval : result) {
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        }

        System.out.println("\ncost " + (endTimeMillis - startTimeMillis) + " ms");
    }
}
