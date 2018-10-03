package algorithm.java;

/**
 * Created by huaxiufeng on 18/10/3.
 */
public class LargestRectangleinHistogram {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            if (i+1< heights.length && heights[i] < heights[i+1]) {
                continue;
            }
            int minHeight = heights[i];
            int curMaxArea = heights[i];
            int rightIndex = i - 1;
            while (rightIndex >= 0) {
                minHeight = Math.min(minHeight, heights[rightIndex]);
                curMaxArea = Math.max(curMaxArea, (i - rightIndex + 1) * minHeight);
                rightIndex--;
            }
            if (curMaxArea > maxArea) {
                maxArea = curMaxArea;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleinHistogram solution = new LargestRectangleinHistogram();
        System.out.println(solution.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
