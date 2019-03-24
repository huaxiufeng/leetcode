package algorithm.java;

import java.util.Arrays;

/**
 * Created by huaxiufeng on 19/3/24.
 */
public class LC48RotateImage {

    public void rotate(int[][] matrix) {
        // 上下反转
        for (int row = 0; row < matrix.length / 2; row++) {
            int[] temp = matrix[row];
            matrix[row] = matrix[matrix.length - row - 1];
            matrix[matrix.length - row - 1] = temp;
        }
        // 对称反转
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                if (row >= column) {
                    continue;
                }
                int temp = matrix[row][column];
                matrix[row][column] = matrix[column][row];
                matrix[column][row] = temp;
            }
        }
    }

    public static void main(String[] args) {
        LC48RotateImage solution = new LC48RotateImage();
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        solution.rotate(matrix);
        for (int[] line : matrix) {
            System.out.println(Arrays.toString(line));
        }
    }
}
