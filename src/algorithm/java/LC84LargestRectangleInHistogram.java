package algorithm.java;

import java.util.Stack;

/**
 * Created by huaxiufeng on 18/10/3.
 */
public class LC84LargestRectangleInHistogram {

    public int largestRectangleArea0(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            if (i + 1 < heights.length && heights[i] < heights[i + 1]) {
                continue;
            }
            int minHeight = heights[i];
            int curMaxArea = heights[i];
            int leftIndex = i - 1;
            while (leftIndex >= 0) {
                minHeight = Math.min(minHeight, heights[leftIndex]);
                curMaxArea = Math.max(curMaxArea, (i - leftIndex + 1) * minHeight);
                leftIndex--;
            }
            if (curMaxArea > maxArea) {
                maxArea = curMaxArea;
            }
        }
        return maxArea;
    }

    public int largestRectangleAreaStack(int[] heights) {
        int len = heights.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++) {
            int h = (i == len ? 0 : heights[i]);
            System.out.println("i:" + i + " h:" + h);
            if (s.isEmpty() || h >= heights[s.peek()]) {
                s.push(i);
                System.out.println("i:" + i + " stack push " + i + " now is " + s.toString());
            } else {
                int tp = s.pop();
                maxArea = Math.max(maxArea, heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                System.out.println("i:" + i + " stack pop " + tp + " now is " + s.toString() + " maxArea:" + maxArea);
                i--;
            }
        }
        System.out.println("over");
        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        int[] lessFromLeft = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }
        int[] lessFromRight = new int[heights.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            int p = i + 1;
            while (p < heights.length && heights[p] >= heights[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }
        int maxArea = heights[0];
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        LC84LargestRectangleInHistogram solution = new LC84LargestRectangleInHistogram();
        System.out.println(solution.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3})); // 10
        System.out.println(solution.largestRectangleArea(new int[]{2, 1, 2})); // 3
        System.out.println(solution.largestRectangleArea(new int[]{0, 9})); // 9
    }
}
