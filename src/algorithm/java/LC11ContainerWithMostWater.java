package algorithm.java;

/**
 * Created by amyhuiye on 2019/1/10.
 */
public class LC11ContainerWithMostWater {

    public int maxArea(int[] height) {
        if (null == height || height.length <= 1) {
            return 0;
        }
        int begin = 0, end = height.length - 1;
        int maxArea = 0;
        while (begin < end) {
            maxArea = Math.max(maxArea, (end - begin) * Math.min(height[begin], height[end]));
            if (height[begin] < height[end]) {
                begin++;
            } else {
                end--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        LC11ContainerWithMostWater solution = new LC11ContainerWithMostWater();
        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49
    }
}
