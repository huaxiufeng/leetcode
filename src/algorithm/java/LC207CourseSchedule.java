package algorithm.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 * Created by huaxiufeng on 18/12/18.
 *
 * https://www.cnblogs.com/TIMHY/p/8980954.html
 */
public class LC207CourseSchedule {


    /**
     * Kahn算法，就是以入度为衡量因子的算法，即每次将入度为0的点“删除”，同时将其邻接边的顶点入度减一，重复上述过程即可。
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinishKahn(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || null == prerequisites) {
            return false;
        }
        int[] degrees = new int[numCourses]; // 入度
        List<Integer>[] successors = new List[numCourses]; // 后继列表
        for (int i = 0; i < numCourses; i++) {
            successors[i] = new ArrayList<>();
        }
        for (int[] pair : prerequisites) {
            degrees[pair[0]]++;
            successors[pair[1]].add(pair[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0) {
                queue.add(i);
            }
        }
        int takeCourseCount = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            takeCourseCount++;
            for (int successor : successors[course]) {
                if (--degrees[successor] == 0) {
                    queue.add(successor);
                }
            }
        }
        return takeCourseCount == numCourses;
    }

    /**
     * DFS的方法
     * 0: 未访问 1: 访问中 2: 已访问
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || null == prerequisites) {
            return false;
        }
        int[] visitStatus = new int[numCourses];
        List<Integer>[] successors = new List[numCourses]; // 后继列表
        for (int i = 0; i < numCourses; i++) {
            successors[i] = new ArrayList<>();
        }
        for (int[] pair : prerequisites) {
            successors[pair[1]].add(pair[0]);
        }
        for (int course = 0; course < numCourses; course++) {
            if (visitStatus[course] == 0) {
                if (!doDfs(course, visitStatus, successors)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean doDfs(int course, int[] visitStatus, List<Integer>[] successors) {
        if (visitStatus[course] == 2) {
            return true;
        } else if (visitStatus[course] == 1) {
            return false;
        }
        visitStatus[course] = 1;
        for (int successor : successors[course]) {
            if (!doDfs(successor, visitStatus, successors)) {
                return false;
            }
        }
        visitStatus[course] = 2;
        return true;
    }

    public static void main(String[] args) {
        LC207CourseSchedule solution = new LC207CourseSchedule();
        System.out.println(solution.canFinish(2, new int[][]{new int[]{1, 0}})); // true
        System.out.println(solution.canFinish(2, new int[][]{new int[]{1, 0}, new int[]{0, 1}})); // false
    }
}
