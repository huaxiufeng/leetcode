package algorithm.java;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 *
 * Created by huaxiufeng on 19/1/7.
 */
public class LC73SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        boolean firstRowHasZero = false;
        boolean firstColumnHasZero = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    if (i == 0) {
                        firstRowHasZero = true;
                    }
                    if (j == 0) {
                        firstColumnHasZero = true;
                    }
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstColumnHasZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if (firstRowHasZero) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        LC73SetMatrixZeroes solution = new LC73SetMatrixZeroes();
        int[][] matrix = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        solution.setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
