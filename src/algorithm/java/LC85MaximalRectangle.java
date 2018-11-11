package algorithm.java;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximal-rectangle/discuss/29054/Share-my-DP-solution
 *
 * Created by amyhuiye on 2018/11/11.
 */
public class LC85MaximalRectangle {

    /**
     * we start from the first row, and move downward;
     * height[i] record the current number of continous '1' in column i;
     * left[i] record the left most index j which satisfies that for any index k from j to i, height[k] >= height[i];
     * right[i] record the right most index j which satifies that for any index k from i to j, height[k] >= height[i];
     * by understanding the definition, we can easily figure out we need to update maxArea with value (height[i] * (right[i] - left[i] + 1));
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if (null == matrix || 0 == matrix.length || null == matrix[0] || 0 == matrix[0].length) {
            return 0;
        }
        int h = matrix.length; // 矩阵的高度
        int w = matrix[0].length; // 矩阵的宽度
        int height[] = new int[w]; // 保持当前列的高度，也就是连续1的数量
        int left[] = new int[w]; // 对于当前列的高度，组成矩形的最左边的位置
        int right[] = new int[w]; // 对于当前列的高度，组成矩形的最右边的位置
        int maxArea = 0;
        Arrays.fill(right, w - 1);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            /**
             * It is a little bit tricky for initializing and updating left and right array
             * for initialization:
             * we know initially, height array contains all 0, so according to the definition of left and right array, left array should contains all 0, and right array should contain all n - 1
             * for updating left and right, it is kind of tricky to understand...
             */
            int curLeft = 0;
            for (int j = 0; j < w; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], curLeft); // 取当前行这个位置最左边的1和上一行最左边的1的较大者，也就是两者右边的位置，保正从这个位置开始能组成当前高度的矩形
                } else {
                    left[j] = 0; // 这个时候高度也是0，不用考虑上一行了
                    curLeft = j + 1; // 下一个可能作为矩形左边的位置是j+1
                }
            }
            int curRight = w - 1;
            for (int j = w - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], curRight);
                } else {
                    right[j] = w - 1;
                    curRight = j - 1;
                }
            }
            // 对于每一列计算出来一个最大的面积
            for (int j = 0; j < w; j++) {
                maxArea = Math.max(maxArea, (right[j] - left[j] + 1) * height[j]);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        LC85MaximalRectangle solution = new LC85MaximalRectangle();
        System.out.println(solution.maximalRectangle(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        }));
    }
}
