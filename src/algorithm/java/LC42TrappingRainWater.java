package algorithm.java;

/**
 * Created by huaxiufeng on 19/1/11.
 */
public class LC42TrappingRainWater {

    /**
     * 在每个位置分别找到左右两边的最高的位置，计算当前bar对应的雨量
     * @param height
     * @return
     */
    public int trapBruteForce(int[] height) {
        if (null == height || height.length < 3) {
            return 0;
        }
        int total = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int maxLeftHeight = 0; int maxRightHeight = 0;
            for (int j = i; j >= 0; j--) {
                maxLeftHeight = Math.max(maxLeftHeight, height[j]);
            }
            for (int j = i; j < height.length; j++) {
                maxRightHeight = Math.max(maxRightHeight, height[j]);
            }
            total += Math.min(maxLeftHeight, maxRightHeight) - height[i];
        }
        return total;
    }

    /**
     * 把每个点左右两边的最高高度都记下来
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (null == height || height.length < 3) {
            return 0;
        }
        int[] maxLeftHeight = new int[height.length];
        int[] maxRightHeight = new int[height.length];
        for (int i = 0, max = height[i]; i < height.length; i++) {
            maxLeftHeight[i] = max = Math.max(max, height[i]);
        }
        for (int i = height.length - 1, max = height[i]; i >= 0; i--) {
            maxRightHeight[i] = max = Math.max(max, height[i]);
        }
        int total = 0;
        for (int i = 0; i < height.length; i++) {
            total += Math.min(maxLeftHeight[i], maxRightHeight[i]) - height[i];
        }
        return total;
    }

    public static void main(String[] args) {
        LC42TrappingRainWater solution = new LC42TrappingRainWater();
        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})); // 6
    }
}
