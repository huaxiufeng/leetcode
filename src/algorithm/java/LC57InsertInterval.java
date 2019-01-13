package algorithm.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import algorithm.java.data.Interval;

/**
 * Created by huaxiufeng on 19/1/13.
 */
public class LC57InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        for (Interval interval : intervals) {
            if (newInterval == null || interval.end < newInterval.start) {
                result.add(interval);
            } else if (interval.start > newInterval.end) {
                result.add(newInterval);
                result.add(interval);
                newInterval = null;
            } else {
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }
        if (newInterval != null) {
            result.add(newInterval);
        }
        return result;
    }

    public static void main(String[] args) {
        LC57InsertInterval solution = new LC57InsertInterval();
        System.out.println(solution.insert(Arrays.asList(new Interval(1, 2), new Interval(3, 5)), new Interval(4, 7)));
        System.out.println(solution.insert(Arrays.asList(new Interval(1, 2), new Interval(3, 5)), new Interval(6, 7)));
        System.out.println(solution.insert(Arrays.asList(new Interval(1, 3), new Interval(6, 9)), new Interval(2, 5))); // [[1,5],[6,9]]
        System.out.println(solution.insert(Arrays.asList(new Interval(1, 2), new Interval(3, 5), new Interval(6, 7), new Interval(8, 10), new Interval(12, 16)), new Interval(4, 8)));
        System.out.println(solution.insert(new ArrayList<>(), new Interval(5, 7)));
    }
}
