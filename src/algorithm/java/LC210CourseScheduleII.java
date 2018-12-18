package algorithm.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

 There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

 * Created by huaxiufeng on 18/12/18.
 *
 * https://www.cnblogs.com/TIMHY/p/8980954.html
 */
public class LC210CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || null == prerequisites) {
            return null;
        }
        int[] degrees = new int[numCourses];
        Map<Integer, List<Integer>> successorMap = new HashMap<>();
        for (int[] pair : prerequisites) {
            degrees[pair[0]]++;
            List<Integer> list = successorMap.getOrDefault(pair[1], new ArrayList<>());
            list.add(pair[0]);
            successorMap.put(pair[1], list);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int course = 0; course < numCourses; course++) {
            if (degrees[course] == 0) {
                queue.offer(course);
            }
        }
        int[] result = new int[numCourses];
        int resultCursor = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[resultCursor++] = course;
            for (int successor : successorMap.getOrDefault(course, new ArrayList<>())) {
                if (--degrees[successor] == 0) {
                    queue.offer(successor);
                }
            }
        }
        return resultCursor == numCourses ? result : new int[0];
    }

    public static void main(String[] args) {
        LC210CourseScheduleII solution = new LC210CourseScheduleII();
        System.out.println(Arrays.toString(solution.findOrder(2, new int[][]{new int[]{1, 0}}))); // [0, 1]
        System.out.println(Arrays.toString(solution.findOrder(4, new int[][]{new int[]{1, 0},new int[]{2, 0},new int[]{3, 1},new int[]{3, 2}}))); // [0,1,2,3] or [0,2,1,3]
    }
}
