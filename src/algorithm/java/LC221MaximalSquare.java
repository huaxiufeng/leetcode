package algorithm.java;

/**
 * Created by huaxiufeng on 19/1/4.
 */
public class LC221MaximalSquare {

    public int maximalSquareSlow(char[][] matrix) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] matrixLen = new int[matrix.length][matrix[0].length];
        int maxMatrixLen = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if ('0' == matrix[i][j]) {
                    matrixLen[i][j] = 0;
                } else {
                    matrixLen[i][j] = 1;
                    if (i >= 1 && j >= 1) {
                        int checkLen = matrixLen[i - 1][j - 1];
                        int len = 0;
                        for (int k = 0; k < checkLen + 1; k++) {
                            if (matrix[i - k][j] == '1' && matrix[i][j - k] == '1') {
                                len++;
                            } else {
                                break;
                            }
                        }
                        matrixLen[i][j] = len;
                    }
                }
                if (matrixLen[i][j] > maxMatrixLen) {
                    maxMatrixLen = matrixLen[i][j];
                }
            }
        }
        return maxMatrixLen * maxMatrixLen;
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) { return 0; }
        int m = matrix.length, n = matrix[0].length, result = 0;
        int[][] b = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    b[i][j] = Math.min(Math.min(b[i][j - 1], b[i - 1][j - 1]), b[i - 1][j]) + 1;
                    result = Math.max(b[i][j], result);
                }
            }
        }
        return result * result;
    }

    public static void main(String[] args) {
        LC221MaximalSquare solution = new LC221MaximalSquare();
        System.out.println(solution.maximalSquare(new char[][]{
                {'0', '0', '0', '1'},
                {'1', '1', '0', '1'},
                {'1', '1', '1', '1'},
                {'0', '1', '1', '1'},
                {'0', '1', '1', '1'}
        })); // 9
        System.out.println(solution.maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        })); // 4
    }
}
